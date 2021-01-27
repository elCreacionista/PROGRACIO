package Combat;

public class Monedero {
    int monedes;
    int[] tempsPenalitzat;
    int[] Penalitzacio;
    Monedero(int m){
        this.monedes = m;
        tempsPenalitzat = new int[5];
        Penalitzacio = new int[5];
    }
    public void Actualitzar(){
        for (int i = 0; i < 4; i++) {
            if (this.tempsPenalitzat[i] > 0)
                this.tempsPenalitzat[i] --;
            if (this.tempsPenalitzat[i] == 0) {
                this.monedes += Penalitzacio[i];
                Penalitzacio[i] = 0;
            }
        }
    }

    public void Penalitzar(int valor){
        for (int i = 0; i < 4; i++) {
            if (tempsPenalitzat[i] == 0 && Penalitzacio[i] == 0) {
                int valoractual = this.monedes - valor > 1 ? valor : monedes - 1;

                this.tempsPenalitzat[i] = 5;
                this.Penalitzacio[i] = valoractual;
                this.monedes -= valoractual;
                break;
            }
        }
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
