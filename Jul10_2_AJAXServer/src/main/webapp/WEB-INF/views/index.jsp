<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.canvasjs.com/canvasjs.min.js"></script>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
	$(function() {
		
		$.ajax({
			url: "k.weather.get",
			success: function(asd) {
				let ar = [];
				let hTh = $("<th></th>").text("시간");
				let tTh = $("<th></th>").text("기온");
				let wTh = $("<th></th>").text("날씨");
				
				let trh = $("<tr></tr>").append(hTh, tTh, wTh);
				$("table").prepend(trh);
				
				$(asd).find("data").each(function(i, d) {
					let hour = $(d).find("hour").text();
					let temp = $(d).find("temp").text();
					let wfKor = $(d).find("wfKor").text();
					
					let hTd = $("<td></td>").text(hour);
					let tTd = $("<td></td>").text(temp);
					let wTd = $("<td></td>").text(wfKor);
					
					let trd = $("<tr></tr>").append(hTd, tTd, wTd);
					$("table").append(trd);
					ar[i] = {label: hour, y: temp * 1, lineColor: "orange",
							markerColor: "#1E09FF"};
				});
				var chart = new CanvasJS.Chart("chartContainer", {
					animationEnabled: true,
					theme: "light2",
					title:{
						text: "Simple Line Chart"
					},
					data: [{        
						type: "line",
				      	indexLabelFontSize: 16,
						dataPoints: ar
					}]
				});
				chart.render();
				
				
			}
		});
		
		
	});
</script>
</head>
<body>
	<div id="chartContainer" style="height: 300px; width: 100%;"></div>
	<hr>
	<table border="1"></table>
</body>
</html>