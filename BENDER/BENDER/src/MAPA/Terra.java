package MAPA;

import MAPA.OBJECTES.Artifact;

public class Terra extends Casella implements TipusCaminable {
    Terra(Artifact a) {
        super(a);
    }

    @Override
    public String toString() {
        return this.artifact.toString();
    }
}
