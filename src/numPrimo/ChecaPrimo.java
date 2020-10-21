package numPrimo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class ChecaPrimo {

	private Scanner in = new Scanner(System.in);


	// array de Threads para processar o resultados
	private ArrayList<EhPrimoThread> threadsPrimos;


	//Tempo de inicio e termino quando o processamento comecou e termininou, usa p analisar o desempenhog.

	private long inicioTempo;
	private long fimTempo;

	//entrada N pedido na questo

	private BigInteger N;

	//entrada de x Threads pedido na questao
	private int nThread;

	//Array utilizado pelas Threads para identificar quais BigInteger comecar e terminar
	private BigInteger[] inicio;
	private BigInteger[] fim;

	//tamanho de numero primos para testar
	public static final String Exp     = "8";
	public static final String Small   = "472882049";
	public static final String Medium  = "27704267971";
	public static final String Large   = "32416190071";
	public static final String XLarge  = "48112959837082048697";
	public static final String XXLarge = "2074722246773485207821695222107608587480996474721117292752992589912196684750549658310084416732550077";
	
	public static final boolean willGetUserInput = true;
	public static final String defaultValue = Exp;


	public static void main(String args[]) {
		new ChecaPrimo();
	}
	
	public ChecaPrimo() {
		try {
			getUserEntrada();
			initInicioFim();
			runThreads();

			System.out.println();
			System.out.println("O numero " + N + " é primo? " + checkResults());
			System.out.println("Tempo de execução: " + (fimTempo - inicioTempo) + " ms");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Funcao para pegar entradas do usuario
	 */
	public void getUserEntrada() throws Exception {
		if (willGetUserInput) {
			System.out.print("Digite um numero para saber se eh primo: ");
			N = in.nextBigInteger();
		} else {
			N = new BigInteger(defaultValue);
		}
		System.out.print("Quantas threads vc deseja criar? ");
		nThread = in.nextInt();
		System.out.println();
	}
	
	/**
	 * Inicializa os vários threads e sua divisão de cargas de trabalho.
	 */
	public void initInicioFim() {
		inicio = new BigInteger[nThread];
		fim = new BigInteger[nThread];
		
		/**
		 * O tamanho de uma carga de trabalho
		 */
		BigInteger size = N.divide(BigInteger.valueOf(nThread));
		//System.out.println("tamanho: "+ size);

		// inicializar início e fim
		inicio[0] = BigInteger.valueOf(2);

		for (int i = 0; i < nThread - 1; i++) {
			inicio[i + 1] = inicio[i].add(size);
			//System.out.println("inicio:"+ inicio[i]);
			fim[i] = inicio[i + 1];
			//System.out.println("fim: "+fim[i]);
		}
		fim[nThread - 1] = N;

			/*
		  for (int i = 0; i < nThread; i++) { System.out.println("Thread #" +
		  (i + 1) + ": " + inicio[i] + "-" + fim[i]); } System.out.println();
*/


	}

	public void runThreads() {
		threadsPrimos = new ArrayList<EhPrimoThread>();

		// inicializar threads
		for (int i = 0; i < nThread; i++) {
			// distrubui o trabalho entre as threads
			EhPrimoThread thread = new EhPrimoThread(i + 1, inicio[i], fim[i], N);
			
			// add to pool
			threadsPrimos.add(thread);
		}

		// inicia benchmark
		inicioTempo = System.currentTimeMillis();

		// run threads
		for (EhPrimoThread thread : threadsPrimos) {
			thread.start();
		}

		for (EhPrimoThread thread : threadsPrimos) {
			while (thread.isAlive()) {
				// do nothing
			}
		}
		fimTempo = System.currentTimeMillis();
		// acaba benchmark
	}

	public boolean checkResults() {
		for (EhPrimoThread i : threadsPrimos) {
			// se nenhuma das threads identifcar o numero como primo, ent eh nao primo
			if (!i.isPrime)
				return false;
		}
		// caso contrario, é primo
		return true;
	}
}

