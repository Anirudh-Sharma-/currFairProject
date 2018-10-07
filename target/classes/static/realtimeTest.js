var realtimeApp = angular.module('realtimeApp', ['ngRoute']);

realtimeApp.stompClient = null;

function connect() {
	var socket = new SockJS('/websocket-messages');
	realtimeApp.stompClient = Stomp.over(socket);

	realtimeApp.stompClient.connect({}, function (frame){
		console.log("FRAME: " + frame);
		stompClient.subscribe('/topic/liveMessage', function (messageData){
			console.log("my message data: ", messageData);
		});
	});	
}