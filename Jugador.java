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


    public String getEstrategia(){
        return this.estrategia.getEstrategy(this.estrategia);
    }
    public String getRol(){
        return this.rol.getRol();
    }
    public void Makemove(){
        this.estrategia = this.rol.getEstrategia();
    }

    public void PujarNivell(){

    }

}

