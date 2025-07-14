document.addEventListener('DOMContentLoaded', () => {
  // 切換主題按鈕
  document.querySelectorAll('button.mode-switch').forEach(button => {
    button.addEventListener('click', () => {
      document.body.classList.toggle('dark');
    });
  });

  // 關閉右側面板
  document.querySelectorAll('.btn-close-right').forEach(button => {
    button.addEventListener('click', () => {
      const rightSide = document.querySelector('.right-side');
      const expandBtn = document.querySelector('.expand-btn');
      if (rightSide) rightSide.classList.remove('show');
      if (expandBtn) expandBtn.classList.add('show');
    });
  });

  // 展開右側面板
  document.querySelectorAll('.expand-btn').forEach(button => {
    button.addEventListener('click', () => {
      const rightSide = document.querySelector('.right-side');
      if (rightSide) rightSide.classList.add('show');
      button.classList.remove('show');
    });
  });
});
