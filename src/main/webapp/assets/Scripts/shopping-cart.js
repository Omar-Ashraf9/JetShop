$(document).ready(function() {
    // Listen for changes on all quantity dropdowns
    $('.quantity-select').change(function() {
        console.log('Quantity changed');
        // Get the new quantity
        var quantity = $(this).val();

        // Get the price for this product
        var price = $(this).closest('.table_row').find('.column-3').text().replace('EGP ', '');

        // Calculate the new total for this product
        var newTotal = quantity * price;

        // Update the total for this product
        $(this).closest('.table_row').find('.column-5').text('EGP ' + newTotal.toFixed(2));

        // Calculate the grand total
        var grandTotal = 0;
        $('.table_row .column-5').each(function() {
            grandTotal += parseFloat($(this).text().replace('EGP ', ''));
        });

        // Update the grand total
        $('.size-209 .mtext-110').text('EGP ' + grandTotal.toFixed(2));
    });
});