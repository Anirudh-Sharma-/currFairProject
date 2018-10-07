/**
 * 
 */
var myApp = angular.module('myApp', ['ngRoute']);

myApp.vizMap = new Map();

labelArray = [];
dataArray = [];


myApp.controller('mainController', function($scope, $http) {
	
	
    $http.get('http://localhost:8080/message').
        then(function(response) {
            $scope.messages = response.data;
            
            console.log("inside messages data: ", $scope.messages);
            
            prepareStackedVizData($scope.messages);
            prepareStackedViz();
        });   
});

function prepareStackedVizData(data){
	
	// when saved in db
	for (var i in data){
		var vizKey = data[i].currencyFrom + '/' + data[i].currencyTo;
		console.log("viz Key: ", vizKey);
	
		if (myApp.vizMap.has(vizKey)) {
			console.log("already exist");
			var temp = myApp.vizMap.get(vizKey);
			temp++;
			myApp.vizMap.set(vizKey, temp);
		}
		else {
			console.log("adding new value");
			myApp.vizMap.set(vizKey, 1);
		}
		console.log("stacked map: ", myApp.vizMap);
	}	
}

function prepareStackedViz(){
	//getting map data in array
	var mapLength = myApp.vizMap.size;
	console.log("mapSize: ", mapLength);
	
	backgroundColorArray = new Array(myApp.vizMap.size);
	borderColorArray = new Array(myApp.vizMap.size);
	backgroundColorArray.fill('rgb(255, 4, 95)');
	borderColorArray.fill('rgb(255, 4, 95)')

	myApp.vizMap.forEach(getMapElements);
	console.log(labelArray);
	console.log(dataArray);
	
	var ctx = document.getElementById("stackedChart").getContext('2d');
	var myChart = new Chart(ctx, {
	    type: 'bar',
	    data: {
	        labels: labelArray,
	        datasets: [{
	            label: '# of Tranaction for (currFrom/To)',
	            data: dataArray,
	            backgroundColor: backgroundColorArray,
	            borderColor: borderColorArray,
	            borderWidth: 1
	        }]
	    },
	    options: {
	        scales: {
	            yAxes: [{
	                ticks: {
	                    beginAtZero:true
	                }
	            }]
	        }
	    }
	});
}

function getMapElements(value, key, map) {
	labelArray.push(key);
	dataArray.push(value);
}










