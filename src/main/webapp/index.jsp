<html>
<head>
  <title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
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
    
    <div id="message-div">
    	
    </div>
</body>
</html>