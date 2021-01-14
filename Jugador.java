package Combat;

public class Jugador {
    int nivell;
    int punts;
    String Nom;
    int VidaMaxima;
    int Vida;
    Monedero Atac;
    Monedero Defensa;
    Estrategia estrategia;
    Rol rol;

    Jugador(String nom, int vida, int atac, int defensa, Rol rol){
        this.nivell = 0;
        this.punts = 0;
        this.Nom = nom;
        this.Vida = vida;
        this.VidaMaxima = vida;
        this.Atac = new Monedero(atac);
        this.Defensa = new Monedero(defensa);
        this.rol = rol;
        this.Makemove();
    }

    public void GetStatics(){
        System.out.print("Nom: " + Nom);
        System.out.print(" Vida: " + Vida);
        System.out.print(" Vida maxima: " + VidaMaxima);
        System.out.print(" Atac: " + Atac.monedes);
        System.out.print(" Defensa: " + Defensa.monedes);
        System.out.println(" Estrategia: " + getEstrategia());
    }

    public void Dany(int valor){
        this.Vida -= valor;
    }

    public void Penal(int valor){
        if (Math.random() > 0.5)
            this.Atac.Penalitzar(valor);
        else
            this.Defensa.Penalitzar(valor);
    }

    public void Guarit(int valor){
        if (this.VidaMaxima > this.Vida + valor)
            this.Vida = this.Vida + valor;
        else
            this.Vida = this.VidaMaxima;
    }


    public int LlencarMonedes(){
        if (this.estrategia == Estrategia.ATAC || this.estrategia == Estrategia.ENGANY)
            return this.Atac.LlencarMonedes();
        else
            return this.Defensa.LlencarMonedes();
    }

    public String getEstrategia(){
        return this.estrategia.getEstrategy(this.estrategia);
    }
    public int getNombreEstrategia(){
        return this.estrategia.getNumber(this.estrategia);
    }
    public String getRol(){
        return this.rol.getRol();
    }
    public void Makemove(){
        this.Atac.Actualitzar();
        this.Defensa.Actualitzar();

        this.estrategia = this.rol.getEstrategia();
    }

    public void PujarNivell(){
        this.nivell++;
        this.VidaMaxima += 2;
        int valor = new Monedero(1).LlencarMonedes();
        if (valor == 0)
            this.Atac.IncrementarMonedes(1);
        else
            this.Defensa.IncrementarMonedes(1);
    }

}

