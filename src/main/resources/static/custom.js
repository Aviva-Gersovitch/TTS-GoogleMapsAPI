let map;


function initMap() {
	map = new google.maps.Map(document.getElementById('map'),
			{center: coords,
			scrollwheel: false,
			zoom: 10});
			
	let image = {
		url: "/xmarksspot.png",
		scaledSize: new google.maps.Size(50,50)
	}
			
	let marker = new google.maps.Marker (
		{
			position: coords,
			map: map,
			icon: image,
			animation: google.maps.Animation.BOUNCE
		}
	);

	let contentString = "<h2>" + city + ", " + state + "</h2>";

	let infoWindow = new google.maps.InfoWindow({
		content: contentString
	});

	google.maps.event.addListener(marker, 'click', function(){
		infoWindow.open(map, marker);
	});

}

