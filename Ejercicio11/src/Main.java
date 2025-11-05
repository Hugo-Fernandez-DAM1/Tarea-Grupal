import java.util.concurrent.Semaphore;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Semaphore entrar=new Semaphore(1);
        Semaphore mutex=new Semaphore(1);
        Fiesta F1=new Fiesta();
        Cliente C1;
        Encargado E1=new Encargado(F1,entrar,mutex);
        for(int i=0;i<100;i++){
           C1=new Cliente(F1,"Cliente"+i,entrar,mutex);
           C1.start();
           try{
               Thread.sleep(100);
           }catch(Exception ex){
           }
        }
    }
}