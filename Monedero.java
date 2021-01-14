package Combat;

public class Monedero {
    int monedes;
    Monedero(int m){
        this.monedes = m;
    }

    public int LlencarMonedes(){
        int exit = 0;
        for (int i = 0; i < this.monedes; i++) {
            exit = Math.random() > 0.5 ? exit + 1 : exit;
        }
        return exit;
    }
    public void IncrementarMonedes(int cantitat){
        this.monedes += cantitat;
    }
    public void DecrementarMonedes(int cantitat){
        if (this.monedes - cantitat > 1)
        this.monedes -= cantitat;
        else
            this.monedes = 1;
    }
}
