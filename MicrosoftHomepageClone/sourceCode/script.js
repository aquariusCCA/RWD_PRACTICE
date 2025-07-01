const menuButton = document.querySelector(".menu-btn");
menuButton.addEventListener("click", () => {
  const menu = document.querySelector(".main-nav ul.main-menu");
  const overlay = document.getElementById("overlay");

  // 切換菜單的顯示狀態
  menu.classList.toggle("show");
  
  // 切換遮罩的顯示狀態
  overlay.classList.toggle("open");
});

const overlay = document.getElementById("overlay");

// 2. 點按遮罩：只要遮罩可見就關閉菜單
overlay.addEventListener("click", () => {
  const menu = document.querySelector(".main-nav ul.main-menu");
  
  // 如果菜單是顯示狀態，則關閉菜單
  if (menu.classList.contains("show")) {
    menu.classList.remove("show");
    overlay.classList.remove("open");
  }
});
