# 源碼如下：
```html
<div class="progress">
    <div class="progress-bar"></div>
</div>
```

```scss
.progress {
  margin-top: 5px;
  border-radius: 4px;
  background-color: #e7e7ef;
  height: 8px;
  overflow: hidden;

  &-bar {
    background-color: #4d76fd;
    border-radius: 4px;
    width: 35%;
    height: 100%;
    animation: progressAnimation 6s;
  }
}

@keyframes progressAnimation {
  0% {
    width: 5%;
    background-color: #a2b6f5;
  }

  100% {
    width: 35%;
    background-color: #4d76fd;
  }
}
```

--- 

# 動畫流程拆解
流程上，這段 CSS 動畫大致可以拆解成以下幾個階段（以預設的 `animation-fill-mode: none` 為例）：

1. **頁面初始渲染**：

   * 進度條 `.progress-bar` 套用你在 CSS 裡直接寫的屬性——也就是 `width: 35%`、`background-color: #4d76fd`。
   * 因為預設動畫並不向前套用（`fill-mode: none`），所以在動畫「正真啟動」前，會看到這個靜態樣式。

2. **動畫啟動瞬間（t = 0s）**：

   * 瀏覽器立刻把 0% 關鍵影格套用到元素，強制覆寫為 `width: 5%`、`background-color: #a2b6f5`。
   * 這也是為什麼你必須在 keyframes 裡指定 0% 的起始狀態，否則它會「從目前樣式」去推算動畫起點。

3. **動畫進行（0s → 6s）**：

   * 隨著時間推移，屬性值在 5%→35% 與 #a2b6f5→#4d76fd 之間線性插值，根據 `animation-timing-function`（預設為 `ease`）計算出每一刻的中間值。

4. **動畫結束（t = 6s）**：

   * 6 秒後，瀏覽器會還原為原本 CSS 裡定義的 `width: 35%`、`background-color: #4d76fd`（因為沒設定 `animation-fill-mode: forwards`，動畫結束後不保留最後影格）。

---