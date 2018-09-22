// We create the tile layers that will be the selectable backgrounds of our map.
// One for our grayscale background.
var graymap = L.tileLayer("https://api.mapbox.com/styles/v1/mapbox/light-v9/tiles/256/{z}/{x}/{y}?access_token=" +
  "pk.eyJ1IjoidHdpc3RlZGxleCIsImEiOiJjamsxd3YxYWYwbTR2M3ZtdDFsNDQ0bm1yIn0.rN5pBdLvOAiaO9H2QjQzmA", {
    attribution: "Map data &copy;" +
      "<a href='http://openstreetmap.org'>OpenStreetMap</a> contributors," +
      "<a href='http://creativecommons.org/licenses/by-sa/2.0/'>" +
      "CC-BY-SA</a>" +
      "IMagnitudeery &copy;" +
      "<a href='http://mapbox.com'>Mapbox</a>",
    maxZoom: 18
  });

// Another for our satellite background.
var satellitemap = L.tileLayer("https://api.mapbox.com/styles/v1/mapbox/satellite-streets-v9/tiles/256/{z}/{x}/{y}?" +
  "access_token=pk.eyJ1IjoidHdpc3RlZGxleCIsImEiOiJjamsxd3YxYWYwbTR2M3ZtdDFsNDQ0bm1yIn0.rN5pBdLvOAiaO9H2QjQzmA", {
    attribution: "Map data &copy;" +
      "<a href='http://openstreetmap.org'>OpenStreetMap</a> contributors," +
      "<a href='http://creativecommons.org/licenses/by-sa/2.0/'>CC-BY-SA</a>" +
      "IMagnitudeery &copy; <a href='http://mapbox.com'>Mapbox</a>",
    maxZoom: 18
  });

// One for our outdoors background.
var outdoors = L.tileLayer("https://api.mapbox.com/styles/v1/mapbox/outdoors-v9/tiles/256/{z}/{x}/{y}?" +
  "access_token=pk.eyJ1IjoidHdpc3RlZGxleCIsImEiOiJjamsxd3YxYWYwbTR2M3ZtdDFsNDQ0bm1yIn0.rN5pBdLvOAiaO9H2QjQzmA", {
    attribution: "Map data &copy;" +
      "<a href='http://openstreetmap.org'>OpenStreetMap</a> contributors," +
      "<a href='http://creativecommons.org/licenses/by-sa/2.0/'>CC-BY-SA</a>" +
      "IMagnitudeery &copy; <a href='http://mapbox.com'>Mapbox</a>",
    maxZoom: 18
  });

// We then create the map object with options. Adding the tile layers we just
// created to an array of layers.
var map = L.map("mapid", {
  center: [
    40.7, -94.5
  ],
  zoom: 3,
  layers: [graymap, satellitemap, outdoors]
});

// Adding our 'graymap' tile layer to the map.
graymap.addTo(map);

var volcanodata = new L.LayerGroup();
var earthquakedata = new L.LayerGroup();
var meteordata = new L.LayerGroup();

// Defining an object that contains all of our different map choices. Only one
// of these maps will be visible at a time!
var baseMaps = {
  Satellite: satellitemap,
  Grayscale: graymap,
  Outdoors: outdoors
};

// We define an object that contains all of our overlays. Any combination of
// these overlays may be visible at the same time!
var overlays = {
  "Volcanic Eruptions": volcanodata,
  "Earthquakes": earthquakedata,
  "Meteor Strikes": meteordata
};

// Then we add a control to the map that will allow the user to change which
// layers are visible.
L
  .control
  .layers(baseMaps, overlays)
  .addTo(map);

  
    function volcanoevents(feature) {
        if(feature.properties.Type == "Volcano") return true

    }
    var volcanopoints = L.geoJSON(events, {
        filter: volcanoevents,
        pointToLayer: function (feature, latlng) {
            return L.marker(latlng, {
                icon: L.icon({
                    iconUrl: "../static/volcano.png",
                    iconSize: [24, 28],
                    iconAnchor: [12, 28],
                    popupAnchor: [0, -25]
                }),
                title: feature.properties.NAME,
                riseOnHover: true 
            });
        },    
        onEachFeature: function(feature, layer){
            layer.bindPopup("Rating: " + feature.properties.Rating);
        }    
    });

    function earthquakeEvents(feature) {
        if(feature.properties.Type == "Earthquake") return true

    }
    var earthquakepoints = L.geoJSON(events, {
        filter: earthquakeEvents,
        pointToLayer: function (feature, latlng) {
            return L.marker(latlng, {
                icon: L.icon({
                    iconUrl: "../static/earthquake.png",
                    iconSize: [24, 28],
                    iconAnchor: [12, 28],
                    popupAnchor: [0, -25]
                }),
                title: feature.properties.NAME,
                riseOnHover: true 
            });
        },
        onEachFeature: function(feature, layer){
            layer.bindPopup("Magnitude: " + feature.properties.Magnitude);
        },

    });
    function meteorevents(feature) {
        if(feature.properties.Type == "Meteor") return true

    }
    var meteorpoints = L.geoJSON(events, {
        filter: meteorevents,
        pointToLayer: function (feature, latlng) {
            return L.marker(latlng, {
                icon: L.icon({
                    iconUrl: "../static/meteor.jpg",
                    iconSize: [24, 28],
                    iconAnchor: [12, 28],
                    popupAnchor: [0, -25]
                }),
                title: feature.properties.NAME,
                riseOnHover: true 
            });
        },
        onEachFeature: function(feature, layer){
            layer.bindPopup("Mass: " + feature.properties.Mass);
        },

    });

    meteorpoints.addTo(meteordata);
    meteordata.addTo(map);

    earthquakepoints.addTo(earthquakedata);
    earthquakedata.addTo(map);

    volcanopoints.addTo(volcanodata);
    volcanodata.addTo(map);