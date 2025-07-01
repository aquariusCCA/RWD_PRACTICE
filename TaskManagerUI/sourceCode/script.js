// 處理 .mail-choice (checkbox) 的選取背景切換
document.querySelectorAll('.mail-choice').forEach(function(checkbox) {
  checkbox.addEventListener('change', function() {
    const parent = this.parentElement;
    if (this.checked) {
      parent.classList.add('selected-bg');
    } else {
      parent.classList.remove('selected-bg');
    }
  });
});

// 處理色彩選擇器，動態設定 CSS 變數 --button-color
const colorInput = document.getElementById('colorpicker');
if (colorInput) {
  colorInput.addEventListener('input', function(e) {
    document.body.style.setProperty('--button-color', e.target.value);
  });
}

// 處理點擊 .inbox-calendar 後，三個區塊的顯示/隱藏切換
document.querySelectorAll('.inbox-calendar').forEach(function(btn) {
  btn.addEventListener('click', function() {
    document.querySelectorAll('.calendar-container').forEach(el => {
      el.classList.toggle('calendar-show');
    });
    document.querySelectorAll('.inbox-container').forEach(el => {
      el.classList.toggle('hide');
    });
    document.querySelectorAll('.mail-detail').forEach(el => {
      el.classList.toggle('hide');
    });
  });
});
