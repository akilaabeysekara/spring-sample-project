function loadCustomers() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/v1/customer",
        success: function (response) {
            let options = "<option value=''>Select Customer</option>";
            $.each(response, function (index, customer) {
                options += "<option value='" + customer.cId + "'>" + customer.cName + "</option>";
            });
            $("#customer-select").html(options);
        },
        error: function (error) {
            alert("Error loading customers");
            console.log(error);
        }
    });
}

function loadItems() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/v1/item",
        success: function (response) {
            let options = "<option value=''>Select Item</option>";
            $.each(response, function (index, item) {
                options += "<option value='" + item.iCode + "'>" + item.iName + " - " + item.iPrice + "</option>";
            });
            $("#item-select").html(options);
        },
        error: function (error) {
            alert("Error loading items");
            console.log(error);
        }
    });
}

function saveOrder() {
    let orderId = $("#order-id").val();
    let customerId = $("#customer-select").val();
    let itemCode = $("#item-select").val();
    let qty = $("#order-qty").val();

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/v1/order",
        contentType: "application/json",
        data: JSON.stringify({
            orderId: orderId,
            customerId: customerId,
            orderDate: new Date().toISOString().split("T")[0],
            orderDetails: [{itemCode: itemCode, qty: qty}]
        }),
        success: function (response) {
            alert("Order Saved Successfully");
            getAllOrders();
        },
        error: function (error) {
            alert("Error saving order");
            console.log(error);
        }
    });
}

function updateOrder() {
    let orderId = $("#order-id").val();
    let customerId = $("#customer-select").val();
    let itemCode = $("#item-select").val();
    let qty = $("#order-qty").val();

    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/v1/order",
        contentType: "application/json",
        data: JSON.stringify({
            orderId: orderId,
            customerId: customerId,
            orderDate: new Date().toISOString().split("T")[0],
            orderDetails: [{itemCode: itemCode, qty: qty}]
        }),
        success: function (response) {
            alert("Order Updated Successfully");
            getAllOrders();
        },
        error: function (error) {
            alert("Error updating order");
            console.log(error);
        }
    });
}

function deleteOrder() {
    let orderId = $("#order-id").val();
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/v1/order?id=" + orderId,
        success: function (response) {
            alert("Order Deleted Successfully");
            getAllOrders();
        },
        error: function (error) {
            alert("Error deleting order");
            console.log(error);
        }
    });
}

function searchOrder() {
    let orderId = $("#search-order").val();
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/v1/order/" + orderId,
        success: function (order) {
            $("#order-id").val(order.orderId);
            $("#customer-select").val(order.customerId);
            if (order.orderDetails && order.orderDetails.length > 0) {
                $("#item-select").val(order.orderDetails[0].itemCode);
                $("#order-qty").val(order.orderDetails[0].qty);
            }
        },
        error: function (error) {
            alert("Order not found");
            console.log(error);
        }
    });
}

function getAllOrders() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/v1/order",
        success: function (response) {
            $("#order-table tbody").html("");
            $.each(response, function (index, order) {
                let totalQty = 0;
                if (order.orderDetails) {
                    $.each(order.orderDetails, function (i, detail) {
                        totalQty += parseInt(detail.qty);
                    });
                }
                $("#order-table tbody").append("<tr><td>" + order.orderId + "</td><td>" + order.customerId + "</td><td>" + totalQty + "</td><td>$" + (order.total || "0.00") + "</td></tr>");
            });
        },
        error: function (error) {
            alert("Error loading orders");
            console.log(error);
        }
    });
}

$(document).ready(function () {
    loadCustomers();
    loadItems();
    getAllOrders();
});