var categoryName = "*";
function getC(category) {
  categoryName = category;
  window.location.href = "front?controller=products";
  var buttons = document.querySelectorAll(".stext-106");

 
  buttons.forEach(function (button) {
    if (button.textContent.toLowerCase() === categoryName) {
      button.setAttribute("data-filter", "." + categoryName);
    } else {
      button.setAttribute("data-filter", "*");
    }
  });
}
