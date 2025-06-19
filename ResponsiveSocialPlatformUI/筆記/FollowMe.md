# ✅ 為什麼在 `.text-layer` 和 `.developer-layer` 中要使用 `position: absolute`？

## 一、**實現「滑動切換」動畫的基礎條件**

* 兩層 `.text-layer` 是堆疊在 `.follow-me` 容器內的兩個內容層。
* 使用 `absolute` 可以讓兩層完全重疊於相同區域內，才能透過 `transform: translateY(...)` 做出上下滑動切換的動畫效果。

## 二、**避免 layout shift（佈局跳動）**

* 若使用一般流式排版（非絕對定位），兩層會在 DOM 中佔據實際空間，hover 時切換將導致高度變動，產生視覺跳動。
* 使用 `absolute`，讓它們脫離文檔流，避免影響 `.follow-me` 的外觀和大小，動畫更順暢。

## 三、**讓轉場過渡更直觀與可控**

* `position: absolute` 配合 `transition + transform` 能進行平滑的位移動畫，而不是僅靠 `opacity` 做漸隱。
* 使用 `transform` 的動畫比 `height` 或 `margin` 更具效能（不會觸發 reflow）。

## 四、**維持 `.follow-me` 的結構單純**

* 父層只需設為 `position: relative`，就能作為定位參考點。
* 子層使用 `absolute` 不影響父層尺寸，也不需為內容變化調整排版邏輯。

## 🧠 總結語：

> 使用 `position: absolute` 是為了 **在固定範圍內堆疊兩個內容層，並透過 `transform` 做出滑動切換動畫，同時避免佈局干擾與視覺跳動。** 這是建立視覺轉場效果的核心手法，既高效又結構清晰。

若移除 `absolute`，會直接破壞動畫與堆疊邏輯，導致樣式錯亂或體驗不佳。這不是附加選項，而是此設計實現的**關鍵必要條件**。