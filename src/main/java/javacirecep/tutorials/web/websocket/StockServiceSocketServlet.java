package javacirecep.tutorials.web.websocket;
 
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

public class StockServiceSocketServlet extends WebSocketServlet { 
        @Override
        public void configure(WebSocketServletFactory factory) {
            factory.getPolicy().setIdleTimeout(12 * 60 * 60 * 1000);
            factory.register(StockServiceWebSocket.class); 
        }
}
