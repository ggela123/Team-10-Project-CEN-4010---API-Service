$(document).ready(function() {

    $(".minusButton").on("click", function(evt) {
        evt.preventDefault();
        decreaseQuantity($(this));

    });

    $(".plusButton").on("click", function(evt) {
        evt.preventDefault();
        increaseQuantity($(this));

    });

    $(".link-remove").on("click", function(evt) {
        evt.preventDefault();
        removeFromCart($(this));
    });

    updateTotal();
})

function decreaseQuantity(link) {
    bookId = link.attr("bid");
    qtyInput = $("#quantity" + bookId);

    newQty = parseInt(qtyInput.val()) - 1;
    if (newQty > 0)  {
        qtyInput.val(newQty);
        updateQuantity(bookId, newQty);
    }
}

function increaseQuantity(link) {
    bookId = link.attr("bid");
    qtyInput = $("#quantity" + bookId);

    newQty = parseInt(qtyInput.val()) + 1;
    if (newQty < 10) {
        qtyInput.val(newQty);
        updateQuantity(bookId, newQty);
    }
}

function updateQuantity(bookId, quantity) {
    url = contextPath + "cart/update/" + bookId + "/" + quantity;

    $.ajax({
        type: "POST",
        url: url,
        beforeSend: function(xhr) {
            xhr.setRequestHeader(csrfHeaderName, csrfValue);
        }
    }).done(function(newSubtotal) {
        updateSubtotal(newSubtotal, bookId);
        updateTotal();
    }).fail(function() {
        $("#modalTitle").text("Shopping Cart");
        $("#modalBody").text("Error while adding product to shopping cart.");
        $("#myModal").modal();
    });
}

function updateSubtotal(newSubtotal, bookId) {
    $("#subtotal" + bookId).text(newSubtotal);
}

function updateTotal() {
    total = 0.0;

    $(".productSubtotal").each(function(index, element) {
        total = total + parseFloat(element.innerHTML);
    });

    $("#totalAmount").text("$" + total);
}

function removeFromCart(link) {
    url = link.attr("href");

    $.ajax({
        type: "POST",
        url: url,
        beforeSend: function(xhr) {
            xhr.setRequestHeader(csrfHeaderName, csrfValue);
        }
    }).done(function(response) {

        $("#modalTitle").text("Shopping Cart");
        if (response.includes("removed")) {
            $("#myModal").on("hide.bs.modal", function(e) {
                rowNumber = link.attr("rowNumber");
                removeBook(rowNumber);
                updateTotal();
            });
        }

        $("#modalBody").text(response);
        $("#myModal").modal();

    }).fail(function() {
        $("#modalTitle").text("Shopping Cart");
        $("#modalBody").text("Error while removing product to shopping cart.");
        $("#myModal").modal();
    });
}

function removeBook(rowNumber) {
    rowId = "row" + rowNumber;
    $("#" + rowId).remove();
}