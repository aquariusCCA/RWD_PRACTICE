# 為什麼「.showcase」明確寫上 width: 100%？
`<header>` 元素本身預設會是 `display: block`，而 block 元素在未設定寬度時，會自動撐滿其父容器的寬度（即 `width: auto`，效果等同於 `width: 100%`）。

### 那為什麼還是明確寫上 `width: 100%`？

這屬於**防禦性寫法**，有以下幾個實用原因：

### ✅ **1. 明確化目的，提升可讀性與維護性**

雖然不寫也會撐滿，但明寫 `width: 100%` 能讓後續開發者清楚這個區塊**預期**是要全寬，避免誤以為是其他設計（如自動收縮或 inline block）。這是可預測行為的顯性標記。

> **舉例**：像是團隊專案時，這樣的明確設定能減少他人維護時對 layout 的誤判。

### ✅ **2. 避免被外部樣式影響（CSS Reset、樣式覆蓋）**

有些 CSS reset（如 Normalize.css、Bootstrap、Tailwind 的 preflight）會將元素樣式清空或變動。如果未明確指定 `width`，可能會受其他層樣式干擾。

> 假設 parent container 有 `display: flex` 且有 `flex-basis` 等設定，`header` 若不設寬度，可能會非預期收窄。

### ✅ **3. 為相對定位與子元素做鋪墊**

有些場景下需要配合 `position: relative` 使用（如 `.showcase-content` 的絕對定位），若不明確定義寬度，可能會導致子元素定位出錯或 `overflow`。

### ✅ **4. 搭配背景圖時強化一致性**

此例中 `.showcase` 使用：

```scss
background: url(...) no-repeat center center/cover;
```

這種背景鋪法依賴容器大小，若 `.showcase` 被外部容器裁切或沒撐滿，就會導致背景圖無法正常 cover 全區。因此指定 `width: 100%` 可確保背景圖鋪滿視覺區塊。

### ✅ **總結一句話：**

雖然技術上不寫 `width: 100%` 也能撐滿，但為了**防範未來變動、強化視覺一致性，以及提升維護性與語意清晰度**，這是一種良好的寫法慣例。

---