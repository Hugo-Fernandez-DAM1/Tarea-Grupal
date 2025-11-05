import java.util.concurrent.Semaphore;

public class Cliente extends Thread{
 private Fiesta F1;
 private String nombre;
 Semaphore entrar,mutex;
 public Cliente(Fiesta F1, String nomb, Semaphore entrar, Semaphore mutex){
     this.F1=F1;
     this.nombre=nomb;
     this.entrar=entrar;
     this.mutex=mutex;

 }
 public void run(){
     for(int i=0;i<4;i++){
         try{
             if(F1.getRacionesTotales()>0){
                 mutex.acquire();
                 System.out.println("Entra "+nombre + " quedan "+ F1.getRacionesTotales());
                 F1.comerRacion();
                 if (F1.getRacionesTotales() % 80 == 0) {
                     System.out.println(nombre + " avisa al encargado: ¡paellera vacía!");
                     entrar.release();
                 }
                 sleep(40);
                 mutex.release();
             }else{
                 System.out.println(" No hay mas raciones");
                 mutex.release();
             }
         }catch(InterruptedException ex){
             ex.printStackTrace();
         }
     }
 }
}
