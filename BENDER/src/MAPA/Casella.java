package MAPA;

import MAPA.OBJECTES.Artifact;

public abstract class Casella {
    boolean caminable;
    public Artifact artifact;
    Casella(Artifact a){
        this.artifact = a;
    }
    Casella(){}
}
