function saveCustomer() {
    let id = $('#customer_id').val()
    let name = $('#customer_name').val()
    let address = $('#customer_address').val()

    $.ajax({
        url: 'http://localhost:8080/api/v1/customer',
        method: 'POST',
        contentType: 'application/json',

        data: JSON.stringify({
            id: id,
            name: name,
            address: address
        }),
        success: function (response) {
            alert("Customer Saved Successfully");
            getALLCustomers();
            clearCustomerForm();
        }, error: function (error) {
            alert("Error saving customer");
            console.log(error);
        }
    })
}

function updateCustomer() {
    let id = $('#customerId').val()
    let name = $('#customerName').val()
    let address = $('#customerAddress').val()

    $.ajax({
        url: 'http://localhost:8080/api/v1/customer',
        method: 'PUT',
        contentType: 'application/json',

        data: JSON.stringify({
            id: id,
            name: name,
            address: address
        }),
        success: function (response) {
            alert("Customer Updated Successfully");
            getALLCustomers();
            clearCustomerForm();
        }, error: function (error) {
            alert("Error Updating customer");
            console.log(error);
        }
    })
}

function deleteCustomer() {
    let id = $('#customerId').val()
    $.ajax({
        url: 'http://localhost:8080/api/v1/customer/' + id,
        method: 'DELETE',
        success: function (response) {
            alert("Customer Deleted Successfully");
            getALLCustomers();
            clearCustomerForm();
        }, error: function (error) {
            alert("Error Deleting customer");
            console.log(error);
        }
    })
}

function getALLCustomers() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/v1/customer",
        success: function (response) {
            $("#customer-table tbody").html("");
            $.each(response, function (index, customer) {
                let row = "<tr style='cursor: pointer;'><td>" + customer.id + "</td><td>" + customer.name + "</td><td>" + customer.address + "</td></tr>";
                $("#customer-table tbody").append(row);
            })

            // Add click event handler to table rows
            $("#customer-table tbody tr").on('click', function () {
                let id = $(this).find('td:eq(0)').text();
                let name = $(this).find('td:eq(1)').text();
                let address = $(this).find('td:eq(2)').text();

                fillCustomerForm(id, name, address);
            });
        }, error: function (error) {
            alert("Error loading customers");
            console.log(error);
        }
    })
}

function fillCustomerForm(id, name, address) {
    $('#customer_id').val(id);
    $('#customer_name').val(name);
    $('#customer_address').val(address);
    $('#customerId').val(id);
    $('#customerName').val(name);
    $('#customerAddress').val(address);
}

function clearCustomerForm() {
    $('#customer_id').val('');
    $('#customer_name').val('');
    $('#customer_address').val('');
    $('#customerId').val('');
    $('#customerName').val('');
    $('#customerAddress').val('');
}

$(document).ready(function () {
    getALLCustomers();
});