/* Selects random background */
var select_bg = function()
{
	/* List of containing all bgs */
	var bg_array = new Array('banana-bg1.png', 'banana-bg2.jpg', 'banana-bg3.jpg');
	
	/* Define number of backgrounds available in images folder */
	var bg_amount = 3;
	
	/* Selects random number between 0 and bg_amount */
	var r = bg_array[Math.floor(Math.random() * bg_amount)];
	
	/* Sets background */ 
	var bg = document.getElementsByClassName('widget-background');
	bg[0].style.backgroundImage = `url("/images/${r}")`;
}

/* Displays product details in pop-up widget for CRUD operations */
var toggle_product_details = function(name, description, size, price, id)
{		
	/* Initializes update and delete button handlers */
	$('#update-product').attr('onclick', `location.href='/product/update?id=${id}'`)
	$('#delete-product').attr('onclick', `location.href='/product/delete?id=${id}'`)
	
	/* If widget is not displayed */
	if($('#product-details').css('display') == 'none')
	{
		/* Display widget */
		$('#product-details').css('display', 'block')
		$('#product-details').css('z-index', 3)
		
		/* Display bg filter */
		$('#dark-filter').css('display', 'flex')
		$('#dark-filter').css('z-index', 2)
		
		/* Display product information */
		$('#product-name').text(name)
		$('#product-size').text(size)
		$('#product-price').text(price)
		$('#product-description').text(description)
		$('#product-img').attr('src', `https://loremflickr.com/300/400/${name}`)
	}
	else
	{
		/* Remove widget */
		$('#product-details').css('display', 'none')
		$('#product-details').css('z-index', -3)
		
		/* Remove bg filter */
		$('#dark-filter').css('display', 'none')
		$('#dark-filter').css('z-index', -2)
	}	
}
