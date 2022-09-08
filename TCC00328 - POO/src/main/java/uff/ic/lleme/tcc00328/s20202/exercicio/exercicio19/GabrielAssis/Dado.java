package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio19.GabrielAssis;

import java.util.Random;

public class Dado {
    private int ultimaFace;

    public int getUltimaFace() {
        return ultimaFace;
    }

    public void setUltimaFace(int ultimaFace) {
        this.ultimaFace = ultimaFace;
    }
    
    public int lancaDado(){
        Random random = new Random();
        int face = random.nextInt(6) + 1;
        this.ultimaFace = face;
        return face;
    }

    
    
    
}
