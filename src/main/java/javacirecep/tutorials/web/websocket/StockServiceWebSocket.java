package javacirecep.tutorials.web.websocket;
 
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
 
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;
 
@WebSocket
public class StockServiceWebSocket {
 
    private Session session;
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
 
    // called when the socket connection with the browser is established
    @OnWebSocketConnect    
    public void handleConnect(Session session) {
        this.session = session;
    }
 
    // called when the connection closed
    @OnWebSocketClose
    public void handleClose(int statusCode, String reason) {
        System.out.println("Connection closed with statusCode=" 
            + statusCode + ", reason=" + reason);
    }
 
    // called when a message received from the browser
    @OnWebSocketMessage
    public void handleMessage(String message) {
        
        int i =0 ;
        
        if (message.equals("start"))
            i = 1 ;
        
        if (message.equals("stop"))
            i = 0 ;
        
          if (message.equals("start at next hour"))
            i = 2 ;
          
        // switch (message) {
        switch (i) {
            // case "start":
            case 1:
                send("Stock service started!");
                
                /*
                executor.scheduleAtFixedRate(
                    () -> send(StockService.getStockInfo()), 0, 5, TimeUnit.SECONDS);  
                */            

            executor.scheduleAtFixedRate(
                    new Runnable() {
                        @Override
                        public void run() {
                             send(StockService.getStockInfo());
                            // send("running ...") ;
                        }
                    }, 0, 5, TimeUnit.SECONDS);                     
            
                break;
            // case "stop":
            case 0:
                this.stop();
                break;
            
             case 2:
                send("Stock service start at next hour !");
             
                executor.scheduleAtFixedRate(
                    new Runnable() {
                        @Override
                        public void run() {
                             send(StockService.getStockInfo());
                            // send("running ...") ;
                        }
                    }, getDelay(), 3600, TimeUnit.SECONDS);                     
            
                break;
           
        }
    }
 
    // called in case of an error
    // @OnWebSocketError
    public void handleError(Throwable error) {
        error.printStackTrace();    
    }
    
    // sends message to browser
    private void send(String message) {
        try {
            if (session.isOpen()) {
                session.getRemote().sendString(message);            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    // closes the socket
    private void stop() {
        try {
            session.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private long getDelay() {
        Calendar cal = new GregorianCalendar();
        // cal.add(Calendar.DATE, fONE_DAY);
        
        long result = 60 ;
        
        return ( result - cal.get(Calendar.MINUTE) ) * 60 ;
                        
    }
}
