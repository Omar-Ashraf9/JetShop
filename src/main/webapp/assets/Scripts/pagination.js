let category = "all";

function getCategory(c) {
  category = c;
  console.log(category);
}
function loadMore() {
var data = new URLSearchParams();
  data.append("start", 1);
  data.append("category", category);
  console.log("loadMore clicked");
  fetch("front?controller=products", {
    method: "POST",
    body: data,
    headers: {
      "Content-Type": "application/x-www-form-urlencoded",
    },
  }).then((response) => response.text())
    .then((data) => {
    console.log(data)})
    .catch((error) => {
      console.log(
        "An error occurred while adding the product to the cart:",
        error
      );
    });
}


