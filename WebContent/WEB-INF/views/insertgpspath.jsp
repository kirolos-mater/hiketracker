<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert GPS Path</title>
		<link rel="stylesheet" href="http://unpkg.com/leaflet@1.6.0/dist/leaflet.css"
      integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
      crossorigin="" />
<!-- Make sure you put this AFTER Leaflet's CSS -->
<script src="http://unpkg.com/leaflet@1.6.0/dist/leaflet.js"
        integrity="sha512-gZwIG9x3wUXg2hdXF6+rVkLF/0Vi9U8D2Ntg4Ga5I5BZpVkVxlJWbSQtXPSiUTtC0TjtGOmxa1AJPuV0CPthew=="
        crossorigin=""></script>
<link rel="stylesheet" href="http://leaflet.github.io/Leaflet.markercluster/dist/MarkerCluster.css">
<link rel="stylesheet" href="http://leaflet.github.io/Leaflet.markercluster/dist/MarkerCluster.Default.css">
<script src="http://leaflet.github.io/Leaflet.markercluster/dist/leaflet.markercluster-src.js"></script>
<script src="https://cdn.rawgit.com/hayeswise/Leaflet.PointInPolygon/v1.0.0/wise-leaflet-pip.js"></script>
<script src="https://api.mqcdn.com/sdk/mapquest-gl-js/v0.4.0/mapquest-gl.js"></script>
<link type="text/css" rel="stylesheet" href="https://api.mqcdn.com/sdk/mapquest-gl-js/v0.4.0/mapquest-gl.css" />
</head>
<body>
		<h3>Please fill in the form suggested below</h3>
		<form action="./insertgpspath" method="POST" autocomplete="off">
			Transport&nbsp;<input type="number" name="transport" value="" placeholder="Car, bike, ..."/><br/>
			Start&nbsp;<input type="text" name="start" value="" placeholder="[lat:long]"/><br/>
			Start time&nbsp;<input type="datetime" name="startDateTime" value=""/><br/>
			Finish&nbsp;<input type="text" name="finish" value="" placeholder="[lat:long]"/><br/>
			Finish time&nbsp;<input type="datetime" name="finishDateTime" value=""/><br/>
			Full route&nbsp;<input type="text" name="fullRoute" value=""/><br/>
			<input type="submit" value="submit"/>	
		</form>
		<button type="button" value="SHOW PATH" onclick="showPolyline()">Show polyline</button>
		<div id="routefrommodel" style="display: none;" >${route}</div>
		<div id="mapid"></div>
		<style>
			#mapid {
				height: 1080px;
			}
		</style>
		<script src="http://www.openlayers.org/api/OpenLayers.js"></script>
		<script>var mymap = L.map('mapid').setView([45.4754304, 9.1881472], 13);
			var map = mymap;
			//var OsmLayer = new OpenLayers.Map("Mappa");
			L.tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
				attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>',
				maxZoom: 18,
			}).addTo(mymap);
			
			function showPolyline() {
                var puntijs = document.getElementById("routefrommodel").innerHTML;
            
                var markers = L.markerClusterGroup();
                
                var polyline = L.polyline(puntijs, {color: 'red'}).addTo(map);
                
                for (var i = 0; i < puntijs.length; i++) {
                    /*cluster di marker*/
                    var puntiMatrice = puntijs[i];
                    var marker = L.marker(new L.LatLng(puntiMatrice[0], puntiMatrice[1]));
                    //console.log(marker);
                    markers.addLayer(marker);
                }
                map.addLayer(markers);
            }
			
			</script>
</body>
</html>