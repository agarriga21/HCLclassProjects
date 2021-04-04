
var myData = [
    {"dealId" : 0, "client_name" : "Microsoft", "project_name" : "Apollo Project", "project_manager" : "Mary", "project_cost" : 1000},
    {"dealId" : 1, "client_name" : "Intel", "project_name" : "Hermes Project", "project_manager" : "Bob", "project_cost" : 10000},
    {"dealId" : 2, "client_name" : "Apple", "project_name" : "Zeus Project", "project_manager" : "Jane", "project_cost" : 100000}
]


var currentDealId = myData.length;



// localstorage allows us to persist key value pairs in a way that would survive page refreshes, navigation, and user closing/reopening browser.
// localstorage has limits to the size of each object stored.   

localStorage.setItem("myData", "test")

var myDataTest = localStorage.getItem("myData")



function CreateTableFromJSON() {    
    myData.sort(function(a, b){
        return a.dealId - b.dealId;
    });

    // EXTRACT VALUE FOR HTML HEADER. 
    // ('Deal ID', 'Deal Name', 'Category' and 'Price')
    var col = [];
    for (var i = 0; i < myData.length; i++) {
        for (var key in myData[i]) {
            if (col.indexOf(key) === -1) {
                col.push(key);
            }
        }
    }

    // CREATE DYNAMIC TABLE.
    var table = document.createElement("table");

    // CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.

    var tr = table.insertRow(-1);                   // TABLE ROW.

    for (var i = 0; i < col.length; i++) {
        var th = document.createElement("th");      // TABLE HEADER.
        th.innerHTML = col[i];
        tr.appendChild(th);
    }

    // ADD JSON DATA TO THE TABLE AS ROWS.
    for (var i = 0; i < myData.length; i++) {

        tr = table.insertRow(-1);

        for (var j = 0; j < col.length; j++) {
            var tabCell = tr.insertCell(-1);
            tabCell.innerHTML = myData[i][col[j]];
        }
        // Insert Extra Cell for the Delete Icon
        //TODO: Complete this
        //var tabCell = tr.insertCell(-1);
        //tabCell.innerHTML = '<button onclick="DeleteRow(' + myData[i].dealId + ')"> <img src="trashcan.png"> </button>'

    }

    // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
    
    var divContainer = document.getElementById("showData");
    divContainer.innerHTML = "";
    divContainer.appendChild(table);
}

function AddNewDeal() {
    var clientName = document.getElementById("clientNameInput").value;
    var projectName = document.getElementById("projectNameInput").value;
    var projectManager = document.getElementById("projectManagerInput").value;
    var projectCost = document.getElementById("projectCostInput").value;


if(clientName!=""&&projectName!=""&&projectManager!=""&&projectCost!=""){
    document.getElementById("clientNameInput").value = "";
    document.getElementById("projectNameInput").value = "";
    document.getElementById("projectManagerInput").value = "";
    document.getElementById("projectCostInput").value = "";


    InsertRow(currentDealId, clientName, projectName, projectManager, projectCost);
    
}
}

function InsertRow(dealId, clientName, projectName, projectManager, projectCost) {
    myData.push({"dealId": dealId, "client_name" : clientName, "project_name" : projectName, "project_manager" : projectManager, "project_cost" : projectCost})
    currentDealId++;
    CreateTableFromJSON();

}

function DeleteRow() {
    var dealid = document.getElementById("dealid").value;
   if(dealid==""){
       dealid=-1;
   }
    Id= Number(dealid);
    
    for( var i = 0; i < myData.length; i++){ 
    
        if ( myData[i].dealId === Id) { 
    
            myData.splice(i, 1); 
        }
    
    }
    CreateTableFromJSON();
}

function ShowEdit() {
    var dealid = document.getElementById("dealidedit").value;
    if(dealid==""){
        dealid=-1;
    }
    Id= Number(dealid);
 
    for( var i = 0; i < myData.length; i++){ 
    
        if ( myData[i].dealId === Id) { 
    
            document.getElementById("clientNameEdit").value = myData[i].client_name;
            document.getElementById("projectNameEdit").value = myData[i].project_name;
            document.getElementById("projectManagerEdit").value = myData[i].project_manager;
        break;
        }
    else{
        document.getElementById("clientNameEdit").value = "";
            document.getElementById("projectNameEdit").value = "";
            document.getElementById("projectManagerEdit").value = "";
    }
    }
    CreateTableFromJSON();
}
function EditRow() {
    var dealid = document.getElementById("dealidedit").value;
    var clientName = document.getElementById("clientNameEdit").value
    var projectName = document.getElementById("projectNameEdit").value
    var projectManager = document.getElementById("projectManagerEdit").value
  
    if(dealid==""){
       dealid=-1;
   }
    Id= Number(dealid);
    
    for( var i = 0; i < myData.length; i++){ 
    
        if ( myData[i].dealId === Id) { 
            if(clientName!=""&&projectName!=""&&projectManager!=""){
               
                var projectCost = myData[i].project_cost;

                myData.splice(i, 1);

                myData.push({"dealId": Id, "client_name" : clientName, "project_name" : projectName, "project_manager" : projectManager, "project_cost" : projectCost})
                
            }
        }
    }
    CreateTableFromJSON();
}

