package orcPresa;
/*Orcs são criaturas estúpidas que só conseguem fazer duas coisas: morder ou gritar. Para um Orc
conseguir comer sua presa, ele deve primeiro gritar até atordoar sua vítima, para depois então tentar
morder. Um certo dia dois Orcs resolveram caçar juntos no pântano e eles fizeram um acordo: quando
eles avistarem uma presa, primeiro eles tentarão gritar, quem conseguir gritar depois poderá tentar
morder, se o outro não estiver mordendo, ele conseguirá morder com certeza. Mas claro, Orcs não são
criaturas confiáveis, então mesmo que o primeiro Orc consiga gritar o outro ainda assim terá uma
chance de 50% de tentar morder e roubar a presa. Implemente este problema dos Orcs usando locks
explícitos. Considere que a cada segundo aparece uma presa nova. O programa deve parar quando um
número N de presas, definido no início da execução, forem atacadas. Cada Orc deve ser
implementada como uma thread distinta.*/
public class Main {
    public volatile static Presa bode= new Presa();

    public static void main(String[] args) {
        final int N=10;
        Thread novasPresas = new Thread(()->{
            System.out.println("estou rodando");
            int abates=0;
            while (true){
                try{
                    bode = new Presa();
                    System.out.println("nova presa");
                    Thread.sleep(1000);
                    if(!bode.isVivo()){
                        System.out.println("presa morta.");
                        abates++;
                        if(abates==N){
                            break;
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                } catch (InterruptedException e) {
                    System.out.println("deu merda");
                }
            }
        });
        //dois orcs caçam juntos
        Orcs iury = new Orcs("iury");
        Orcs ulisses = new Orcs("ulisses");
        
        novasPresas.start();



    }

}
