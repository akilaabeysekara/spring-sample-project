function saveItem() {
    let id = $("#item-code").val();
    let name = $("#item-name").val();
    let price = $("#item-price").val();
    let qty = $("#item-qty").val();

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/v1/item",
        contentType: "application/json",
        data: JSON.stringify({
            id: id,
            name: name,
            price: price,
            qty: qty
        }),
        success: function (response) {
            alert("Item Saved Successfully");
            getAllItems();
            clearItemForm();
        }, error: function (error) {
            alert("Error saving item");
            console.log(error);
        }
    })
}

function updateItem() {
    let code = $("#item-code").val();
    let name = $("#item-name").val();
    let price = $("#item-price").val();
    let qty = $("#item-qty").val();

    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/v1/item",
        contentType: "application/json",
        data: JSON.stringify({
            id: id,
            name: name,
            price: price,
            qty: qty
        }),
        success: function (response) {
            alert("Item Updated Successfully");
            getAllItems();
            clearItemForm();
        },
        error: function (error) {
            alert("Error updating item");
            console.log(error);
        }
    });
}

function deleteItem() {
    let code = $("#item-code").val();
    $.ajax({
        type: "DELETE",
        url: 'http://localhost:8080/api/v1/item/' + id,
        success: function (response) {
            alert("Item Deleted Successfully");
            getAllItems();
            clearItemForm();
        },
        error: function (error) {
            alert("Error deleting item");
            console.log(error);
        }
    });
}

function getAllItems() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/v1/item",
        success: function (response) {
            $("#item-table tbody").html("");
            $.each(response, function (index, item) {
                $("#item-table tbody").append("<tr><td>" + item.id + "</td><td>" + item.name + "</td><td>" + item.price + "</td><td>" + item.qty + "</td></tr>");
            })
        }, error: function (error) {
            alert("Error loading items");
            console.log(error);
        }
    })
}

function clearItemForm() {
    $("#item-code").val('');
    $("#item-name").val('');
    $("#item-price").val('');
    $("#item-qty").val('');
}

$(document).ready(function () {
    getAllItems();
});