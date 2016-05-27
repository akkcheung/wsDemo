 var ws;

 $(document).ready(
function() {
    ws = new WebSocket("ws://localhost:8081/myWsApp/WebSocketChat");
        ws.onopen = function(event) {
    }

    ws.onmessage = function(event) {
        var $textarea = $('#messages');
        $textarea.val($textarea.val() + event.data + "\n");
    }

    ws.onclose = function(event) {
    }

     sendMessage() {
        var message = $('#username').val() + ":" + $('#message').val();
        ws.send(message);
        $('#message').val('');
    }
    
});