import static java.lang.Thread.sleep;

public class Fiesta {
    // 80 raciones cada paella hay 5
    // se rellena en 25 mseg
    // comer 40seg
   private int racionesTotales =400;
   private int racionesPaellera=80;
    public int getRacionesTotales() {
        return racionesTotales;
    }
    public void comerRacion() {
        if (racionesTotales > 0 && racionesPaellera > 0) {
            racionesTotales--;
            racionesPaellera--;
        }
    }
    public int getRacionesPaellera() {
        return racionesPaellera;
    }
    public void rellenarPaellera() {
        if (racionesTotales > 0 && racionesPaellera==0) {
            racionesPaellera=80;
        }
    }
}
