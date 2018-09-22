// Caching the DOM elements we'll need for repeated use later
var $table = document.querySelector("#wd-table");
var $loader = document.querySelector(".loader");
var $pagination = document.querySelector(".pagination");
var $tbody = document.getElementsByTagName("tbody")[0];
var $typeSearch = document.querySelector("#type-search");
var $ratingSearch = document.querySelector("#rating-search");
var $latitudeSearch = document.querySelector("#latitude-search");
var $longitudeSearch = document.querySelector("#longitude-search");
var $yearSearch = document.querySelector("#year-search");
var $numResults = document.querySelector("#num-results");
var $updateFilterBtn = document.querySelector("#filter-submit");

// Adding event listeners to the pagination buttons and the update filter button
$pagination.addEventListener("click", changePage);
$updateFilterBtn.addEventListener("click", filterData);

// filterOptions contains methods which return the trimmed value of the corresponding inputs/dropdowns in the sidebar
var filterOptions = {
  Type: function() {
    return $typeSearch.value.trim();
  },
  Rating: function() {
    return $ratingSearch.value.trim();
  },
  Latitude: function() {
    return $latitudeSearch.value.trim();
  },
  longitude: function() {
    return $longitude.value.trim();
  },
  year: function() {
    return $yearSearch.value.trim();
  }
};

// data is an object containing information and methods that have to do with the dataset
var data = {
  dataSet: dataSet,
  filtered: dataSet,
  // filterData compares the data in the dataSet to the selected filterOptions, and sets data.filtered equal to an array of the objects which pass the filter
  updateFilter: function() {
    // filterKeys is an array containing the keys in the filterOptions object
    var filterKeys = Object.keys(filterOptions);
    // The filter method goes through each element in the dataSet and returns a new array. Items from the original array which fail the test are not included
    this.filtered = this.dataSet.filter(function(ufoRecord) {
      // For each key in filterKeys, pass the value of the filter and the value of the ufoRecord's corresponding key to the fuzzySearch function
      // If fuzzySearch ever returns false, don't include the ufoRecord into the filteredData
      for (var i = 0; i < filterKeys.length; i++) {
        if (!fuzzySearch(filterOptions[filterKeys[i]](), ufoRecord[filterKeys[i]])) {
          return false;
        }
      }
      // If fuzzySearch never returns false, return true, adding the current ufroRecord to the filtered data set
      return true;
    });
  }
};

// fuzzySearch takes in the user's search and the property we want to check it matches from an individual ufoRecord in the dataSet
function fuzzySearch(search, result) {
  // Trim result to be at most the length of the search, this way we can type partial searches and still match, or empty searches and match with everything
  var slicedResult = result.slice(0, search.length);
  if (search === slicedResult) {
    return true;
  }
  return false;
}

// page is an object containing methods and information that have to do with paginating the dataSet
var page = {
  currentPage: 1,
  // numPages refers to the total number of pages that should appear in the pagination list based on the size of the data and results per page
  numPages: function() {
    return Math.ceil(data.filtered.length / this.resultsPerPage());
  },
  // resultsPerPage returns the value of the "Results Per Page" dropwdown inside the sidebar
  resultsPerPage: function() {
    return $numResults.value.trim();
  },
  // getPageSubset returns an array containing the page numbers which should show up on the pagination list
  getPageSubset: function() {
    var counter;
    // If the current page is less than 11, start the counter at 1 as we are on the first page
    if (this.currentPage < 11) {
      counter = 1;
    }
    // If the current page is evenly divisible by 10, start the counter at itself minus 9 (e.g. pagination rows go 11 - 20, 21 - 30 ,etc)
    else if (this.currentPage % 10 === 0) {
      counter = this.currentPage - 9;
    }
    else {
      // Otherwise divide the current page by 10, round down (e.g. 26 becomes 2), then multiply by 10 (becomes 20) and add 1 (starts at 21)
      counter = Math.floor(this.currentPage / 10) * 10 + 1;
    }
    // Create an array to contain the pages numbers to return
    var pageNumbers = [counter];
    counter++;
    // While the current page number is less than the total number of pages and we have less than 10 pages in this set of pageNumbers...
    while (pageNumbers[pageNumbers.length - 1] < this.numPages() && pageNumbers.length < 10) {
      pageNumbers.push(counter);
      counter++;
    }
    // Return the pageNumbers array when complete
    return pageNumbers;
  },
  // paginate returns an array containing only section of the filtered data which should show up on the current page
  paginate: function(array, pageSize, pageNumber) {
    pageNumber--;
    return array.slice(pageNumber * pageSize, (pageNumber + 1) * pageSize);
  }
};

// The init function starts the app
init();

// init calls loadDropdown, loadTable, and appendPagination
function init() {
  loadDropdown();
  loadTable();
  appendPagination();
}

function filterData() {
  // filterData calls data.updateFilter, which updates the data.filtered
  data.updateFilter();

  // loadTable is then called, which reloads the table with the updated and filtered data
  loadTable();

  // appendPagination updates the pagination to match the size of the filtered data
  appendPagination();
}

function loadDropdown() {
  // dropdownOptions will be used to construct HTML for the country and shape dropdown menus
  // Each possible country and shape option gets a string option tag like the ones below
  var dropdownOptions = {
    Type: ["<option default value=''>all</option>"],
    Rating: ["<option default value=''>all</option>"]
  };

  // optionKeys is an array containing the keys in the dropdownOptions object as strings (['country', 'shape'])
  var optionKeys = Object.keys(dropdownOptions);

  // For each object in the dataSet, also loop through each object in dropdownOptions
  // Create an HTML tag string for a dropdown option containing the each piecedata's country and shape
  for (var i = 0; i < data.dataSet.length; i++) {
    var ufoData = data.dataSet[i];
    for (var j = 0; j < optionKeys.length; j++) {
      var dropdownOption = optionKeys[j];
      var optionHTML = "<option value='" + ufoData[dropdownOption] + "'>" + ufoData[dropdownOption] + "</option>";
      // If the country and shape option is not already inside dropdownOptions.country or dropdownOptions.state, add it to the appropriate array
      if (dropdownOptions[dropdownOption].indexOf(optionHTML) < 0) {
        dropdownOptions[dropdownOption].push(optionHTML);
      }
    }
  }
  // Render the arrays of country and shape HTML option tags to the countrySearch select box on the page
  $typeSearch.innerHTML = dropdownOptions.Type.join("");
  $ratingSearch.innerHTML = dropdownOptions.Rating.join("");
}

function changePage(event) {
  // Prevent the default behavior of the anchor tag which called this function when clicked
  event.preventDefault();
  // Get a reference to the anchor tag which was clicked on and triggered the event, then get the href attribute of the anchor tag
  var paginationBtn = event.target;
  var newPageNumber = parseInt(paginationBtn.getAttribute("href"));
  // If newPageNumber is less than 1 OR more than the maximum number of pages available in the dataset, return out of the function early since there is no page to go backwards to forwards to
  if (newPageNumber < 1 || newPageNumber > page.numPages()) {
    return false;
  }
  // Otherwise set page.currentPage to the newPageNumber
  page.currentPage = newPageNumber;
  // If the clicked paginationBtn is one of the arrow buttons...
  if (paginationBtn.getAttribute("class") === "page-direction") {
    // Run appendPagination, which completely replaces all the buttons inside the pagination list with new buttons
    appendPagination();
  }
  else {
    // Otherwise just update the CSS of the pagination list so only the button for the active page is given the "active" class, making it orange
    setActivePage();
  }
  // Whether we need to reload the entire pagination list or not, reload the table to display the data which should now be rendered to the table
  return loadTable();
}

// This function uses the page.currentPage variable to determine which pagination button should have the "active" class
function setActivePage() {
  // If the anchor tag inside the pagination list item has an 'href' attribute equal to the current page, set it's the class to active
  for (var i = 0; i < $pagination.children.length; i++) {
    var li = $pagination.children[i];
    if (parseInt(li.children[0].getAttribute("href")) === page.currentPage) {
      li.classList = "active";
    }
    else {
      // Otherwise remove any classes it may have
      li.classList = "";
    }
  }
}

// appendPagination completely replaces the current pagination list with a new one with updated numbers
function appendPagination() {
  // Empty the pagination list
  $pagination.innerHTML = "";
  // Create a document fragment to store the nodes which will make up the li tags inside of the new pagination list
  var fragment = document.createDocumentFragment();
  // pageSubset is an array containing the pageNumbers which should appear in the pagination list at this current page number
  var pageSubset = page.getPageSubset();
  // Create an li tag, which will contain HTML to create the back button on the pagination list. Append the backButton to the fragment first
  var backButton = document.createElement("li");
  backButton.innerHTML = "<a class='page-direction' href='" + (pageSubset[0] - 1) + "'><</a>";
  fragment.appendChild(backButton);

  // For every page number in the pageSubset, create an li tag containing an anchor tag with an href attribute of the page number the pagination button should take the user to when clicked
  var listItem;
  for (var i = 0; i < pageSubset.length; i++) {
    listItem = document.createElement("li");
    listItem.innerHTML = "<a href='" + pageSubset[i] + "'>" + pageSubset[i] + "</a>";
    // If this is the active page, give the listItem the "active class"
    if (pageSubset[i] === page.currentPage) {
      listItem.classList = "active";
    }
    // Add the listItem to the fragment
    fragment.appendChild(listItem);
  }

  // Append a forwardButton to the fragment last
  var forwardButton = document.createElement("li");
  forwardButton.classList = "page-direction";
  forwardButton.innerHTML = "<a class='page-direction' href='" + (pageSubset[0] + pageSubset.length) + "'>></a>";
  fragment.appendChild(forwardButton);
  // Append the fragment containing the list-items to the pagination list
  $pagination.appendChild(fragment);
}

function loadTable() {
  // Clear the contents of the tbody on the page, start showing the loader
  $tbody.innerHTML = "";
  showLoader(true);
  // Create a fragment which will contain the new table before appending to the DOM
  var fragment = document.createDocumentFragment();
  // resultsThisPage is an array containing the slice of the data which should be rendered to the table on this page
  var resultsThisPage = page.paginate(
    data.filtered,
    page.resultsPerPage(),
    page.currentPage
  );

  // For every object in the resultsThisPage array, construct a table-row containing information about the object
  for (var i = 0; i < resultsThisPage.length; i++) {
    var ufoObject = resultsThisPage[i];
    // Get an array containing the keys of the ufoObject, create a new tablerow element
    var ufoKeys = Object.keys(ufoObject);
    var $row = document.createElement("tr");
    $row.className = "table-row";

    for (var j = 0; j < ufoKeys.length; j++) {
      var currentKey = ufoKeys[j];
      // For valuue in the ufoKeys array, append a new 'td' element into the row, set it's innerHTML to the value of the ufoObject's key
      var $cell = $row.insertCell(j);
      $cell.innerHTML = ufoObject[currentKey];
      $cell.className = "text-center";
      // This code adds a data-th attribute to the current cell equal to the currentKey. This is only used for CSS styling purposes
      $cell.setAttribute("data-th", currentKey);
    }
    // Append the newly created table row to the fragment
    fragment.appendChild($row);
  }

  // Stop the loader, append the fragment containing all of the table rows and td elements to the table body
  showLoader(false);
  $tbody.appendChild(fragment);
}

// showLoader accpets a boolean, and either shows the loader while hiding the table, or hides the table and shows the loader
function showLoader(shouldLoad) {
  if (!shouldLoad) {
    $table.style.visibility = "visible";
    $loader.style.display = "none";
  }
  else {
    $table.style.visibility = "hidden";
    $loader.style.display = "block";
  }
}
