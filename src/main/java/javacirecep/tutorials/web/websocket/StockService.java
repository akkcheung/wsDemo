package javacirecep.tutorials.web.websocket;
 
import java.text.MessageFormat;
// import java.time.LocalTime;
import java.util.Iterator;
import java.util.Random;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
// import java.text.DateFormat;
 import java.util.Date;
 import java.util.List;
 
// A sample class that generates fake stock information.
public class StockService {
 
    // Random stock value generators. One for each sample stock
    private static Random rnd = new Random();
    
    // private static ArrayList a1 = new ArrayList();
    
    private static Iterator<Double> goog ;
    private static Iterator<Double> aapl ;    
    private static Iterator<Double> fb ;    
    private static Iterator<Double> orcl ;
 
    private static final String FORMAT =
            "[{0}]\t\tGOOG = {1, number, #0.00}\tAAPL = {2, number, #0.00}" +
                    "\tFB = {3, number, #0.00}\tORCL = {4, number, #0.00}";
 
    public static String getStockInfo() {
        
        // List <Double> a1 = new ArrayList<Double>();
        
        double d1 = 525.00  +  rnd.nextDouble() * 2 ;
        Double D1 = new Double(d1) ;
       
        // a1=null;
        // aapl = a1.iterator() ;
        double d2 = 110.00  +  rnd.nextDouble() * 2 ;
        Double D2 = new Double(d2) ;
        
        double d3 = 75.00  +  rnd.nextDouble() * 2 ;
        Double D3 = new Double(d3) ;
        
        double d4 = 40.00  +  rnd.nextDouble() * 2 ;
        Double D4 = new Double(d4) ;
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        return MessageFormat.format(FORMAT, 
            //LocalTime.now().toString(),  
            formatter.format(new Date()),
            //goog.next(), aapl.next(), fb.next(), orcl.next()
            D1, D2, D3, D4
            );
    }
}