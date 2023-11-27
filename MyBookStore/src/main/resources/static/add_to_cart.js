$(document).ready(function() {
    $(".addToCartButton").on("click", function(e) {
        var bookId = $(this).data('book-id');
        addToCart(bookId);
    });
});

function addToCart(bookId) {
    console.log('addToCart function called');
    quantity = $("#quantity" + bookId).val();

    url = contextPath + "cart/add/" + bookId + "/" + quantity;

    $.ajax({
        type: "POST",
        url: url,
        beforeSend: function(xhr) {
            xhr.setRequestHeader(csrfHeaderName, csrfValue);
        }
    }).done(function(response) {
        $("#modalTitle").text("Shopping Cart");
        $("#modalBody").text(response);
        $("#myModal").modal();
    }).fail(function() {
        $("#modalTitle").text("Shopping Cart");
        $("#modalBody").text("Error while adding product to shopping cart.");
        $("#myModal").modal();
    });
}