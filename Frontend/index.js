var list = [];  // This will keep all of the products on the shopping card


axios.get('http://localhost:8080/products')
    .then(function (response) {
        const products = response.data;

        var tables = "<tr>   <th>Image</th> <th>Name</th> <th>Price</th> <th>Action</th>  </tr>";
        
        for(var i = 0; i < products.length; i++) {
            list.push(products[i]);
            var price = products[i].price;
            var image = "<img src=" + products[i].image + ".jpg width=\"100\" height=\"100\"/>";
            var button = "<input type=\"button\" value=\"Add to card\" onClick=\"addToCard(" + price + ")\"";
            
            tables += "<tr>" + 
                "<td>" + image + " </td>" + "<td>" + products[i].name + " </td><td>" + products[i].price + " </td><td>" + button + "</td>" + "</tr>";
            
        }
        
        document.getElementById("productsAll").innerHTML = "<table border=1>" + tables + "</tables>";
    })
    .catch(function (error) {
        console.log(error);
    })


function addToCard(price) {
    console.log("Price: " + price)
}

function shoppingCard() {

    // var tables = "<tr>   <th>Name</th> <th>Price</th> <th>Action</th>  </tr>";
    // for(var i = 0; i < list.length; i++) {
    //     console.log("That part");
    //     console.log(list.length);
    //     // var price = list[i].price;            
    //     tables += "<tr>" + 
    //         "<td>" + list[i].name + " </td><td>" + list[i].price + " </td><td>" + "</td>" + "</tr>";

    // }
    document.getElementById("shoppingCard").innerHTML = "<h1>Hello</h1>";
    // document.getElementById("productsAll").innerHTML = "<table border=1>" + tables + "</tables>";
}

shoppingCard();