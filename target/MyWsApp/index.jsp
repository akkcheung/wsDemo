<html>
<body>
    <h1>Web Socket Sample</h1>
    <script src="stocks.js"></script>
 
    <%@ page import="javacirecep.tutorials.web.websocket.StockService"   %> 
    
    <%
    System.out.println("Test");
    System.out.println(StockService.getStockInfo());
    %>
 
 
    <button onclick="sendToServer('start')">Start</button>
    <button onclick="sendToServer('start at next hour')">Start at next hour</button>

    <button onclick="sendToServer('stop')">Stop!</button>
    
    <br/><br/>
    <textarea id="log" rows="20" cols="90"></textarea>
</body>
</html>