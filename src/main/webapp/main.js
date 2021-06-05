var columnDefs = [
    { field: 'countryName' , rowGroup: true , filter: 'agTextColumnFilter'},
    { field: 'countryCode' ,filter: 'agTextColumnFilter'},
    { field: 'validState', filter: 'agTextColumnFilter'},
    { field: 'phoneNumber' , filter: 'agTextColumnFilter'},
    { field: 'customerName' ,filter: 'agTextColumnFilter' },
];

var gridOptions = {
    columnDefs: columnDefs,
    pagination: true,
    paginationPageSize: 10,
    paginateChildRows: true,
    defaultColDef: {
        editable: false,
        sortable: true,
        resizable: true,
        filter: true,
        flex: 1,
        minWidth: 190,
    },
};

// setup the grid after the page has finished loading
document.addEventListener('DOMContentLoaded', function () {
    var gridDiv = document.querySelector('#myGrid');
    new agGrid.Grid(gridDiv, gridOptions);

    agGrid.simpleHttpRequest({url: 'http://localhost:9090/getAllPhones',})
        .then(function (data) {
            gridOptions.api.setRowData(data);
        });
});