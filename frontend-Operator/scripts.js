document.addEventListener("DOMContentLoaded", function () {
    const homeSection = document.getElementById("homeSection");
    const addIssueFormSection = document.getElementById("addIssueFormSection");
    const searchFormSection = document.getElementById("searchFormSection");
    const resultsSection = document.getElementById("results");
    const searchButton = document.getElementById("searchButton");
    const searchResultsTableBody = document.getElementById("searchResultsTableBody");
    const additionalOptions = document.querySelector(".additional-options");
    const okButton = document.getElementById("okButton");
    const popup = document.getElementById("popup");
  
    // Show Home Section
    document.getElementById("homeLink").addEventListener("click", function (event) {
      event.preventDefault();
      hideSections();
      homeSection.style.display = "block";
    });
  
    // Show Add Customer Issue Form
    document.getElementById("addCustomerIssueLink").addEventListener("click", function (event) {
      event.preventDefault();
      hideSections();
      addIssueFormSection.style.display = "block";
    });
  
    // Show Search Customers Form
    document.getElementById("searchCustomerLink").addEventListener("click", function (event) {
      event.preventDefault();
      hideSections();
      searchFormSection.style.display = "block";
    });
  
    // Add Customer Issue Form Submission
    document.getElementById("addIssueForm").addEventListener("submit", function (event) {
      event.preventDefault();
      const issueType = document.getElementById("issueType").value;
      const description = document.getElementById("description").value;
      const status = document.getElementById("status").value;
  
      const newIssue = {
        issueType,
        description,
        issueStatus: status
      };
  
      fetch("http://localhost:3000/issues", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(newIssue)
      })
        .then(response => response.json())
        .then(data => {
          showPopup("Issue created successfully");
          document.getElementById("issueType").value = "";
          document.getElementById("description").value = "";
          document.getElementById("status").value = "Open";
        })
        .catch(error => {
          console.error("Error adding issue:", error);
        });
    });
  
    // Search Customers Form Submission
    searchButton.addEventListener("click", function () {
      const searchBy = document.getElementById("searchByInput").value;
      const searchValue = document.getElementById("searchValueInput").value;
  
      fetch(`http://localhost:3000/customers?${searchBy}=${searchValue}`)
        .then(response => response.json())
        .then(data => {
          displaySearchResults(data); // Use the whole response object
          showAdditionalOptions();
          resultsSection.style.display = "block";
        })
        .catch(error => {
          console.error("Error searching for customers:", error);
        });
    });
  
    function displaySearchResults(data) {
      searchResultsTableBody.innerHTML = "";
  
      if (data.length > 0) {
        data.forEach(customer => {
          const row = document.createElement("tr");
          row.innerHTML = `
            <td>${customer.id}</td>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.email}</td>
            <td>${customer.mobile}</td>
            <td>${customer.city}</td>
          `;
  
          searchResultsTableBody.appendChild(row);
  
          // Check if the customer has any issues
          if (customer.issues && customer.issues.length > 0) {
            const issuesRow = document.createElement("tr");
            const issuesHeadingCell = document.createElement("th");
            issuesHeadingCell.setAttribute("colspan", "6");
            issuesHeadingCell.textContent = "Customer Issue with ID: " + customer.id +", Name  : -   "+customer.firstName +' '+customer.lastName;
            issuesRow.appendChild(issuesHeadingCell);
            searchResultsTableBody.appendChild(issuesRow);
  
            const issuesTableHeaderRow = document.createElement("tr");
            issuesTableHeaderRow.innerHTML = `
              <th>Issue ID</th>
              <th>Issue Type</th>
              <th>Description</th>
              <th>Status</th>
            `;
            searchResultsTableBody.appendChild(issuesTableHeaderRow);
  
            customer.issues.forEach(issue => {
              const issueRow = document.createElement("tr");
              issueRow.innerHTML = `
                <td>${issue.id}</td>
                <td>${issue.issueType}</td>
                <td>${issue.description}</td>
                <td>${issue.status}</td>
              `;
              searchResultsTableBody.appendChild(issueRow);
            });
          } else {
            const noIssueRow = document.createElement("tr");
            const noIssueCell = document.createElement("td");
            noIssueCell.setAttribute("colspan", "6");
            noIssueCell.textContent = "Customer has no issue";
            noIssueRow.appendChild(noIssueCell);
            searchResultsTableBody.appendChild(noIssueRow);
          }
        });
      } else {
        const row = document.createElement("tr");
        row.innerHTML = `<td colspan="6">No customers found.</td>`;
        searchResultsTableBody.appendChild(row);
      }
    }
  
    function showAdditionalOptions() {
      additionalOptions.style.display = "block";
    }
  
    function showPopup(message) {
      const popupMessage = document.getElementById("popupMessage");
      popupMessage.textContent = message;
      popup.style.display = "flex";
    }
  
    function hideSections() {
      homeSection.style.display = "none";
      addIssueFormSection.style.display = "none";
      searchFormSection.style.display = "none";
      resultsSection.style.display = "none";
      additionalOptions.style.display = "none";
    }
  
    // Close popup when "OK" button is clicked
    okButton.addEventListener("click", function () {
      popup.style.display = "none";
      hideSections();
      homeSection.style.display = "block";
    });
  });
  