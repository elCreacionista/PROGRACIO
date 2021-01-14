package Combat;

public enum Estrategia {
    ATAC,
    DEFENSA,
    ENGANY,
    MANIOBRA;
    public String getEstrategy(Estrategia e){
        switch (e) {
            case ATAC:
                return "Atac";
            case DEFENSA:
                return "Defensa";
            case ENGANY:
                return "Engany";
            case MANIOBRA:
                return "Maniobra";

            default:
                return "ola";
        }
    }
    public int getNumber(Estrategia e){
        switch (e) {
            case ATAC:
                return 0;
            case DEFENSA:
                return 1;
            case ENGANY:
                return 2;
            case MANIOBRA:
                return 3;

            default:
                return 777;
        }
    }

}
enum Rol{
    AGRESIU   (0.50, 0.16, 0.16, 0.16, "Agresiu"),    /** PRIORITZA ATAC*/
    DEFENSIU  (0.16, 0.50, 0.16, 0.16, "Defensiu"),   /** PRIORITZA        DEFENSA*/
    ENGANYADOR(0.16, 0.16, 0.50, 0.16, "Enganyador"), /** PRIORITZA                  ENGANY*/
    MANIOBRER (0.16, 0.16, 0.16, 0.50, "Maniobrer"),  /** PRIORITZA                           MANIOBRA*/

    MIXTE (0.375, 0.375, 0.125, 0.125, "Mixte"),      /** PRIORITZA ATAC I DEFENSA*/
    LLADRE(0.125, 0.125, 0.375, 0.375, "Lladre"),     /** PRIORITZA                  ENGANY I MANIOBRA*/
    CLASE1(0.375, 0.125, 0.375, 0.125, "Clase1"),     /** PRIORITZA ATAC           I ENGANY*/
    CLASE2(0.375, 0.125, 0.125, 0.375, "Clase2");     /** PRIORITZA ATAC                    I MANIOBRA*/

    double ProbAtac;
    double ProbDefensa;
    double ProbEngany;
    double ProbManiobra;
    String tipus;

    Rol(double atc, double def, double eng, double man, String nom){
        this.ProbAtac = atc;
        this.ProbDefensa = def + atc;
        this.ProbEngany = eng + def + atc;
        this.ProbManiobra = man + eng + def + atc;
        this.tipus = nom;
    }
    public Estrategia getEstrategia(){
        double random = Math.random();
        if (random < this.ProbAtac)
            return Estrategia.ATAC;
        else if(random < this.ProbDefensa)
            return Estrategia.DEFENSA;
        else if(random < this.ProbEngany)
            return Estrategia.ENGANY;
        else
            return Estrategia.MANIOBRA;
    }
    public String getRol(){
        return this.tipus;
    }
}
