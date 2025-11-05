import java.util.concurrent.Semaphore;

public class Encargado extends Thread{
    private Fiesta F1;
    Semaphore entrar,mutex;
    public Encargado(Fiesta F1, Semaphore entrar, Semaphore mutex){
        this.F1=F1;
        this.entrar=entrar;
        this.mutex=mutex;
    }
    public void run() {
        try {
            while (F1.getRacionesTotales() > 0) {
                mutex.acquire();
                if (F1.getRacionesTotales()>0) {
                    System.out.println("Rellenado la paellera quedan "+F1.getRacionesTotales()+ " raciones");
                    Thread.sleep(25);
                    F1.rellenarPaellera();
                }
                mutex.release();
            }
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
