package orcPresa;

public class Presa {
    boolean assustada;
    boolean vivo;

    public Presa(){
        this.assustada = false;
        this.vivo = true;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setAssustada(boolean assustada) {
        this.assustada = assustada;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }



    public boolean isAssustada() {
        return assustada;
    }
}