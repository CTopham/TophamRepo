// Start of Code
// Total - 6 SECTIONS

//---------------------------------------------------------------------------------------------
// SECTION 1 - Defining variables for HTML page references

// Define references for the tbody element, search input fields and search button

var $tbody = document.querySelector("tbody"); // Variable for table body in our HTML (for populating table in our HTML), this will be used in renderTable() function to 'populate' the table

// Variable definitions for our 5 Search Fields in our HTML - Date/Time, City, State, Country and Shape
var $TypeInput = document.querySelector("#Type"); // Variable for Date Time Input search category in our HTML, which will be used in our handleSearchButtonClick() function
var $RatingInput = document.querySelector("#Rating"); // Variable for City Input search category in our HTML, which will be used in our handleSearchButtonClick() function
var $LatitudeInput = document.querySelector("#Latitude"); // Variable for State Input search category in our HTML, which will be used in our handleSearchButtonClick() function
var $LongitudeInput = document.querySelector("#Longitude"); // Variable for Country Input search category in our HTML , which will be used in our handleSearchButtonClick() function
var $YearInput = document.querySelector("#Year"); // Variable for Shape Input search category in our HTML, which will be used in our handleSearchButtonClick() function
// var $MagnitudeInput = document.querySelector("#Magnitude");
// var $MassInput = document.querySelector("#Mass");
// var $VEIInput = document.querySelector("#VEI");
// // Search Button variable defintion
var $searchBtn = document.querySelector("#search"); // Variable to call Search Button function in our HTML


//---------------------------------------------------------------------------------------------
// SECTION 2 - Defining event listeners for handling search button clicks and for handling a user pressing an 'enter' key...

// Add an event listener to the searchButton, call handleSearchButtonClick when clicked
// handleSearchButtonClick function has all the logic for searching our table with the exact data elements we want to render
$searchBtn.addEventListener("click", handleSearchButtonClick);

// Add an event listener to initiate a search (by kicking off handleSearchButtonClick() function by just pressing the 'enter' key :)
// Just a shortcut for quicker search results where you don't have to 'click' on the search button everytime...
document.addEventListener('keypress', function (e) {
  var key = e.which || e.keyCode;
  if (key === 13) { // 13 is enter
    handleSearchButtonClick(); // This is where we are calling the handleSearchButtonClick() function...
  }
});


//---------------------------------------------------------------------------------------------
// SECTION 3 - Render Table (renderTable()) Function

// Set Filtered Data to our source data, which is provided to us in our data.js file
var filtered_data = dataSet;

// RENDER TABLE FUNCTION
// Defining renderTable function. This function will be our main function to populate the table data. It will render the
// filtered data (filtered_data) to our table body (tbody)
function renderTable(filtered_data) { // function starts
  $tbody.innerHTML = "";
  for (var i = 0; i < filtered_data.length; i++) {
    // Get get the current address object and its fields
    var sighting = filtered_data[i];
    var fields = Object.keys(sighting);
    // Create a new row in the tbody, set the index to be i + startingIndex
    var $row = $tbody.insertRow(i);
    for (var j = 0; j < fields.length; j++) {
      // For every field in the address object, create a new cell at set its inner text to be the current value at the current address's field
      var field = fields[j];
      var $cell = $row.insertCell(j);
      $cell.innerText = sighting[field];
    }
  }
}

//---------------------------------------------------------------------------------------------
// SECTION 4 - handleSearchButtonClick() function
// This function will contain all our query logic for populating the filtered data (filtered_data) to our table body (tbody)
// This is a our main function for all the code logic requiring for searching and filtering our table contents

function handleSearchButtonClick() // function starts
{
  // Format the user's search by removing leading and trailing whitespace, lowercase the strings for our 5 Search Fields
  // Our 5 Search Fields in our HTML are - Date/Time, City, State, Country and Shape
  // This is where we are defining 5 new variables to our earlier established 5 user input variables (SECTION 1) to remove any user white spaces
  // We are making our search string lowercase as well so that all our inputs remain consistent. This is because all the data elements except
  // for 'comments' in the source data.js file are in 'LOWER CASE'....

  var filtertype = $TypeInput.value.trim().toLowerCase();
  var filterating = $RatingInput.value.trim().toLowerCase();
  var filterlat = $LatitudeInput.value.trim().toLowerCase();;
  var filterlong = $LongitudeInput.value.trim().toLowerCase();
  var filteryr = $YearInput.value.trim().toLowerCase();
  
// Defining our first IF Condition - This condition will kick off if a user enters 'any value' in any 'one' of our 5 search fields
// Our 5 Search Fields in our HTML are - Date/Time, City, State, Country and Shape
  if (filtertype || filterating || filterlat || filterlong || filteryr)
  {
    // Code logic for filtering the table contents based on data being input on the Date/Time field
    if (filtertype){ 
      //Set filtered_data to an array of all table enteries whose "Date/Time" matches the filter
      filtered_data = dataSet.filter (function(sighting) { 
        var SightingDateTime = sighting.Type.toLowerCase();
        // If true, add the corresponding table data to the filtered_data, otherwise don't add it to filtered_data
        return SightingDateTime === filtertype;
      });
    } else {filtered_data = dataSet}; // return initial dataSet if "DateTime" Search Field is blank
    
    // Code logic for filtering the table contents based on data being input on the City field
    if (filterating){
      //Set filtered_data to an array of all table enteries whose "City" matches the filter
      filtered_data = filtered_data.filter (function(sighting) {
        var SightingCity = sighting.Rating.toLowerCase();
        // If true, add the corresponding table data to the filtered_data, otherwise don't add it to filtered_data
        return SightingCity === filterating;
      });
    } else {filtered_data = filtered_data}; // return initial filtered_data dataSet if "City" search field is blank

    // Code logic for filtering the table contents based on data being input on the State field
    if (filterlat){
      //Set filtered_data to an array of all table enteries whose "State" matches the filter
      filtered_data = filtered_data.filter (function(sighting) {
        var SightingState = sighting.state.toLowerCase();
        // If true, add the corresponding table data to the filtered_data, otherwise don't add it to filtered_data      
        return SightingState === filterlat;
      });
    } else {filtered_data = filtered_data}; // return initial filtered_data dataSet if "State" search field is blank

    // Code logic for filtering the table contents based on data being input on the Country field
    if (filterlong){
      //Set filtered_data to an array of all table enteries whose "Country" matches the filter
      filtered_data = filtered_data.filter (function(sighting) {
        var SightingCountry = sighting.country.toLowerCase();
        // If true, add the corresponding table data to the filtered_data, otherwise don't add it to filtered_data        
        return SightingCountry === filterlong;
      });
    } else {filtered_data = filtered_data}; // return initial filtered_data dataSet if "Country" search field is blank

    // Code logic for filtering the table contents based on data being input on the Shape field
    if (filteryr){
      //Set filtered_data to an array of all table enteries whose "Shape" matches the filter      
      filtered_data = filtered_data.filter (function(sighting) {
        var SightingShape = sighting.shape.toLowerCase();
        // If true, add the corresponding table data to the filtered_data, otherwise don't add it to filtered_data        
        return SightingShape === filteryr;
      });
    } else {filtered_data = filtered_data}; // return initial filtered_data dataSet if "Shape" seach field is blank


 } else {
  //location.reload(); //Commented this code out as we don't need to refresh the web page if the user doesn't select any inputs in the search fields
  // Earlier I was refreshing the web page, but it is bad for performance. Instead I am now rendering 'full table' when user doesn't put any value in the search fields
  filtered_data = dataSet; // This is where we render full table, i.e., we re-initialize our table (complete data set) if all search enteries are blank
  }
  $('#table').DataTable().destroy(); // Destroy the already initialized earlier version of the pagination table
  renderTable(filtered_data); // Call the rederTable() function to render (display) the table with our filtered dataset (filtered_data)
  tushaar_pagination(); // Re-initate the pagination table with the new rendered search results
}

//---------------------------------------------------------------------------------------------
// SECTION 5 - Pagination function (tushaar_pagination())

// Setting up pagination function - This function is acquired via 'Google Fu :)'
function tushaar_pagination() 
{
  $(document).ready(function() {
    if ( $.fn.dataTable.isDataTable( '#table' ) ) { // This conditions checks for table being active and bypasses an active table - this is fail safe to remove warning errors
      $('#table').DataTable();
    }
    else {
      $('#table').DataTable({
        "pagingType": "full_numbers",
        destroy: true, // table needs to be destroyed after one active session
        paging: true, // this parameter sets the table paging to be active
        searching: false // this parameter removes the 'search' box, which is optional but I removed it because it may otherwise confuse the user
        });
        } 
      });
}

//---------------------------------------------------------------------------------------------
// SECTION 6 (LAST SECTION) - Rendering our table for the first time when web page first loads
// Render the 'entire table' for the first time when our web page loads by calling our renderTable function and by passing the 
// filtered_data parameter
renderTable(filtered_data);
tushaar_pagination(); // Initiate the pagination function for the first time the browser page loads

//---------------------------------------------------------------------------------------------
// End of Code