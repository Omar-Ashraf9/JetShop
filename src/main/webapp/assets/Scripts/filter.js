var $topeContainer = $('.isotope-grid');
var filterPrice = '';
var filterCategory = '';

// filter items on button click
$('.filter-tope-group').on('click', 'button', function () {
    // Clear the existing category filters
    filterCategory = $(this).attr('data-filter');
    // Add the new category filter
    var comboFilter = filterCategory + filterPrice;
    $topeContainer.isotope({filter: comboFilter});
});
$('.filter-price-group').on('click', 'button', function () {

    filterPrice = $(this).attr('data-filter');
    var comboFilter = filterCategory + filterPrice;
    $topeContainer.isotope({filter: comboFilter});
});


$(window).on('load', function () {
    var $grid = $topeContainer.each(function () {
        $(this).isotope({
            itemSelector: '.isotope-item',
            layoutMode: 'fitRows',
            percentPosition: true,
            animationEngine : 'best-available',
            masonry: {
                columnWidth: '.isotope-item'
            }
        });
    });
});

var isotopeButton = $('.filter-tope-group button');

$(isotopeButton).each(function(){
    $(this).on('click', function(){
        for(var i=0; i<isotopeButton.length; i++) {
            $(isotopeButton[i]).removeClass('how-active1');
        }

        $(this).addClass('how-active1');
    });
});

var priceFilterButtons = $('.filter-price-group button');

$(priceFilterButtons).each(function(){
    $(this).on('click', function(){
        for(var i=0; i<priceFilterButtons.length; i++) {
            $(priceFilterButtons[i]).removeClass('filter-link-active');
        }

        $(this).addClass('filter-link-active');
    });
});