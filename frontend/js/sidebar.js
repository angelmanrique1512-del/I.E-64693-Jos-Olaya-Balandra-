const btn = document.querySelector(".hamburger");
const sidebar = document.querySelector(".sidebar");

btn.addEventListener("click", () => {
  sidebar.classList.toggle("active");
});
