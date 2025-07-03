// 等同於 $(document).ready(...)
document.addEventListener('DOMContentLoaded', function () {
  // 切換 pageLink 的 active 樣式
  const pageLinks = document.querySelectorAll('a#pageLink');
  pageLinks.forEach(function (link) {
    link.addEventListener('click', function (event) {
      pageLinks.forEach(function (l) {
        l.classList.remove('active');
      });
      this.classList.add('active');
    });
  });

  // 顯示左側區域
  const btnShowLeft = document.querySelectorAll('.btn-show-left-area');
  const leftArea = document.querySelector('.left-area');
  btnShowLeft.forEach(function (btn) {
    btn.addEventListener('click', function () {
      leftArea.classList.remove('show');
      leftArea.classList.add('show');
    });
  });

  // 顯示右側區域
  const btnShowRight = document.querySelectorAll('.btn-show-right-area');
  const rightArea = document.querySelector('.right-area');
  btnShowRight.forEach(function (btn) {
    btn.addEventListener('click', function () {
      rightArea.classList.remove('show');
      rightArea.classList.add('show');
    });
  });

  // 關閉右側區域
  const btnCloseRight = document.querySelectorAll('.btn-close-right');
  btnCloseRight.forEach(function (btn) {
    btn.addEventListener('click', function () {
      rightArea.classList.remove('show');
    });
  });

  // 關閉左側區域
  const btnCloseLeft = document.querySelectorAll('.btn-close-left');
  btnCloseLeft.forEach(function (btn) {
    btn.addEventListener('click', function () {
      leftArea.classList.remove('show');
    });
  });

  // 監聽 .main-area 捲動，切換 header 固定樣式
  const mainArea = document.querySelector('.main-area');
  const mainHeader = document.querySelector('div.main-area-header');

  if (mainArea && mainHeader) {
    mainArea.addEventListener('scroll', function () {
      if (mainArea.scrollTop >= 88) {
        mainHeader.classList.add('fixed');
      } else {
        mainHeader.classList.remove('fixed');
      }
    });
  }
});
