> 這種「隱藏原生表單元素，改由相鄰的 <label> 和偽元素來控制顯示／切換狀態」的思路，其實在前端專案裡已經被廣泛運用於各種「純 CSS 交互元件」——尤其是在想要減少 JavaScript、快速打造可切換狀態，又或是希望在無框架環境下也能實現基本互動時。常見的場景包括如下：

# 自訂 Radio Button
> 用同樣的方式隱藏 <input type="radio">，再透過 :checked + label::before 或 ::after 來繪製實心圓、外圈高亮等狀態。
> - 用途：多選一表單、分頁切換（CSS-only tabs）。

以下範例示範一種「隱藏原生 radio，再用 <label> 的偽元素繪製外圈與實心點」的做法，具備可重用性與動態過渡效果。請留意：實務中還需補強 focus 樣式與隱藏文字以提升可及性。

```html
<!-- HTML -->
<div class="radio-group">
    <input type="radio" id="radio1" name="choice" class="custom-radio" checked>
    <label for="radio1">選項一</label>

    <input type="radio" id="radio2" name="choice" class="custom-radio">
    <label for="radio2">選項二</label>

    <input type="radio" id="radio3" name="choice" class="custom-radio">
    <label for="radio3">選項三</label>
</div>
```

```css
/* CSS */
.custom-radio {
    /* 隱藏原生 radio，但保留可聚焦（focus）行為 */
    position: absolute;
    opacity: 0;
    width: 0;
    height: 0;
}

.custom-radio+label {
    position: relative;
    padding-left: 32px;
    margin-right: 24px;
    line-height: 1.2;
    cursor: pointer;
    user-select: none;
}

/* 外圈 */
.custom-radio+label::before {
    content: "";
    position: absolute;
    left: 0;
    top: 50%;
    transform: translateY(-50%);
    width: 20px;
    height: 20px;
    border: 2px solid #a1a4b9;
    border-radius: 50%;
    transition: border-color 0.3s;
}

/* 實心點（初始隱藏） */
.custom-radio+label::after {
    content: "";
    position: absolute;
    left: 5px;
    top: 50%;
    transform: translateY(-50%) scale(0);
    width: 10px;
    height: 10px;
    background-color: #4d76fd;
    border-radius: 50%;
    transition: transform 0.3s;
}

/* 選中後的樣式 */
.custom-radio:checked+label::before {
    border-color: #4d76fd;
}

.custom-radio:checked+label::after {
    transform: translateY(-50%) scale(1);
}

/* 鍵盤聚焦態 */
.custom-radio:focus+label::before {
    outline: 2px dashed #4d76fd;
    outline-offset: 2px;
}
```

- 說明：
    1. .custom-radio 以 opacity:0 隱藏，但保留 focus。

    2. label::before 畫外圈，label::after 畫實心圓點，並以 transform: scale() 控制顯示動畫。

    3. 可依專案需求，將顏色與尺寸抽成 SCSS 變數或 mixin，並補充隱藏文字（aria-label 或 <span class="visually-hidden">）以強化 a11y。

# Toggle Switch（開關切換）
> 隱藏 checkbox，讓偽元素扮演滑動圓點和軌道，配合 transition 做平滑切換。
用途：功能開關（深色模式、靜音／鈴聲切換）。

以下範例示範一種「隱藏原生 checkbox，再用 `<label>` 的偽元素繪製軌道與滑塊」的純 CSS Toggle Switch 實作，具備平滑過渡與鍵盤可聚焦（a11y）支援。

```html
<!-- HTML -->
<div class="switch">
  <input type="checkbox" id="toggle" class="custom-switch">
  <label for="toggle"></label>
</div>
```

```css
/* 隱藏原生 checkbox，但保留 focus 行為 */
.custom-switch {
  position: absolute;
  opacity: 0;
  width: 0;
  height: 0;
}

/* label 當作開關外框（軌道） */
.custom-switch + label {
  display: inline-block;
  width: 50px;
  height: 24px;
  background-color: #ccc;
  border-radius: 12px;
  position: relative;
  cursor: pointer;
  transition: background-color 0.3s;
}

/* 滑塊 */
.custom-switch + label::before {
  content: "";
  position: absolute;
  width: 20px;
  height: 20px;
  background-color: #fff;
  border-radius: 50%;
  top: 2px;
  left: 2px;
  transition: left 0.3s;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.3);
}

/* 選中後：改變軌道顏色、移動滑塊 */
.custom-switch:checked + label {
  background-color: #4d76fd;
}
.custom-switch:checked + label::before {
  left: calc(100% - 2px - 20px);
}

/* 鍵盤聚焦態，方便無障礙操作 */
.custom-switch:focus + label {
  outline: 2px dashed #4d76fd;
  outline-offset: 4px;
}
```

**重點說明：**

1. **結構簡潔**：只需一個隱藏的 `<input>` 和一個 `<label>`，零 JS。
2. **可定制**：寬度、高度、顏色、陰影都可抽成變數或 mixin，封裝成共用元件。
3. **可及性**：`opacity:0` 而非 `display:none`，保留原生 focus；並提供明顯的 focus 樣式。
4. **效能**：CSS-only 減少事件綁定，可在無框架專案快速導入；若要統一圖示或高階主題，可改用 CSS 變數或 CSS-in-JS。

此作法在實務中經常作為開關切換元件的基礎，並可與設計系統（Design System）中的主題變數、SCSS mixin、或前端框架組件化結合，達到可維護、可拓展、且符合 a11y 要求的最終效果。

# CSS-Only Accordion（手風琴折疊）
> 每個項目用隱藏的 checkbox（或 radio 分組）控制展開／收合，再用兄弟選擇器顯示隱藏內容。
> - 優點：零 JS；缺點：複雜狀態管理較困難。

以下範例示範如何用純 CSS（不需 JavaScript）實作一個手風琴折疊（Accordion）元件。核心思路是：

1. 隱藏原生 `<input type="checkbox">`，但保留 focus 行為；
2. 以相鄰的 `<label>` 作為標題列，偽元素繪製「展開／收合」圖示；
3. 用 `:checked + label + .content` 及 `max-height` 或 `height` 動態切換內容區塊的顯示。

```html
<!-- HTML 結構 -->
<div class="accordion">

  <div class="accordion-item">
    <input type="checkbox" id="acc1" class="accordion-checkbox">
    <label for="acc1" class="accordion-title">第一段標題</label>
    <div class="accordion-content">
      <p>這裡是第一段的折疊內容，預設隱藏。</p>
    </div>
  </div>

  <div class="accordion-item">
    <input type="checkbox" id="acc2" class="accordion-checkbox">
    <label for="acc2" class="accordion-title">第二段標題</label>
    <div class="accordion-content">
      <p>這裡是第二段的折疊內容。</p>
    </div>
  </div>

  <div class="accordion-item">
    <input type="checkbox" id="acc3" class="accordion-checkbox">
    <label for="acc3" class="accordion-title">第三段標題</label>
    <div class="accordion-content">
      <p>這裡是第三段的折疊內容。</p>
    </div>
  </div>

</div>
```

```css
/* 1. 隱藏原生 checkbox，但保留 focus */
.accordion-checkbox {
  position: absolute;
  opacity: 0;
  width: 0; height: 0;
}

/* 2. 標題列基本樣式 */
.accordion-title {
  display: block;
  padding: 1rem;
  background: #f7f7f7;
  cursor: pointer;
  position: relative;
  user-select: none;
  transition: background 0.3s;
}

/* 3. 在 title 右側加上 「+／–」 圖示 */
.accordion-title::after {
  content: "+";
  position: absolute;
  right: 1rem;
  font-size: 1.2rem;
  transition: transform 0.3s;
}

/* 4. 折疊內容區塊，預設 max-height:0 隱藏並平滑過渡 */
.accordion-content {
  max-height: 0;
  overflow: hidden;
  transition: max-height 0.3s ease;
  padding: 0 1rem;
}

/* 5. 當 checkbox 被選中，改變 title 背景、圖示，並攤開內容 */
.accordion-checkbox:checked + .accordion-title {
  background: #e6f0ff;
}
.accordion-checkbox:checked + .accordion-title::after {
  content: "–";
  transform: rotate(0deg);
}
/* 利用 + label + .accordion-content 選擇器展開內容區塊 */
/* 這裡將 max-height 設得夠大，只要內容不超過即可；也可改用 height:auto + JS 計算 */
.accordion-checkbox:checked + .accordion-title + .accordion-content {
  max-height: 200px;
  padding: 1rem;
}

/* 6. 鍵盤 focus 樣式（a11y 強化） */
.accordion-checkbox:focus + .accordion-title {
  outline: 2px dashed #4d76fd;
  outline-offset: 2px;
}
```

---

**質疑與檢視：**

* **內容高度**：直接寫死 `max-height:200px` 可能不夠彈性；若內容長度不一，建議用少量 JavaScript 讀取真實高度再設定，或採用 CSS Custom Property／Grid 技巧。
* **可及性**：務必測試螢幕閱讀器是否能正確朗讀標題與展開狀態，並考慮在標題中加入 `aria-expanded`、`aria-controls` 等屬性。
* **可維護性**：若折疊項目為動態生成，CSS-Only 方案會難以管理多重互斥展開（只允許一項打開），此時可考慮改用同 group 的 radio button 或少量 JS 綁事件控制。

這套純 CSS 實作適合「簡單需求、無框架專案」或「減少 JS 依賴」的場景；但若需求複雜，仍建議以組件化、ARIA 標準及少量行為補強的方式來確保可維護性與可及性。

# CSS-Only Tabs（純 CSS 分頁）
> 利用一組隱形 radio buttons，讓選中的那一項對應的內容區塊透過 :checked ~ .panel 顯示，其它則隱藏。
> - 用途：輕量化 Tab 組件。

以下範例示範如何以純 CSS（不需 JavaScript）實作分頁（Tabs）元件。核心思路與 Accordion 類似：

1. 利用隱藏的 `<input type="radio">` 成為狀態開關；
2. 每個 `<label>` 作為分頁標籤，對應不同的內容區塊；
3. 透過 `:checked` 狀態控制內容的顯示／隱藏。

```html
<!-- HTML -->
<div class="tabs">

  <!-- 分頁按鈕群組 -->
  <input type="radio" name="tab" id="tab1" class="tab-input" checked>
  <label for="tab1" class="tab-label">分頁一</label>

  <input type="radio" name="tab" id="tab2" class="tab-input">
  <label for="tab2" class="tab-label">分頁二</label>

  <input type="radio" name="tab" id="tab3" class="tab-input">
  <label for="tab3" class="tab-label">分頁三</label>

  <!-- 內容區塊 -->
  <div class="tab-content" id="content1">
    <p>這是第一個分頁的內容。</p>
  </div>
  <div class="tab-content" id="content2">
    <p>這是第二個分頁的內容。</p>
  </div>
  <div class="tab-content" id="content3">
    <p>這是第三個分頁的內容。</p>
  </div>

</div>
```

```css
/* 隱藏原生 radio，但保留 focus */
/* 注意：必須用 opacity 或 clip-path，不能用 display:none，才能保留鍵盤焦點 */
.tab-input {
  position: absolute;
  opacity: 0;
  width: 0; height: 0;
}

/* 分頁標籤排列 */
.tab-label {
  display: inline-block;
  padding: 0.5rem 1rem;
  margin-right: 0.5rem;
  cursor: pointer;
  border-bottom: 2px solid transparent;
  transition: border-color 0.3s, color 0.3s;
}

/* 預設內容隱藏 */
.tab-content {
  display: none;
  padding: 1rem;
  border: 1px solid #ddd;
  margin-top: -1px; /* 讓內容與標籤邊界相連 */
}

/* 當 radio 被選中，標籤變色並畫底線 */
#tab1:checked + .tab-label[for="tab1"],
#tab2:checked + .tab-label[for="tab2"],
#tab3:checked + .tab-label[for="tab3"] {
  color: #4d76fd;
  border-color: #4d76fd;
}

/* 利用 general sibling 選擇器顯示對應內容 */
#tab1:checked ~ #content1,
#tab2:checked ~ #content2,
#tab3:checked ~ #content3 {
  display: block;
}

/* 鍵盤聚焦態 (a11y) */
.tab-input:focus + .tab-label {
  outline: 2px dashed #4d76fd;
  outline-offset: 2px;
}
```

---

**質疑與檢視：**

* **維護性**：標籤與內容需透過 `id` 與 `for` 精確對應，若分頁數量動態變動，管理會變得複雜。建議在動態專案中以模板語言自動生成。
* **可及性**：雖然保留了 focus，但若需支援螢幕閱讀器，應補上 `role="tablist"`、`role="tab"`、`role="tabpanel"` 及 ARIA 屬性（如 `aria-selected`、`aria-controls`）。
* **彈性**：此方案只適合簡單場景；若分頁內容高度不一，且需平滑轉場動畫，建議在必要時輔以少量 JavaScript 計算與控制。

這套純 CSS Tabs 方案適合輕量專案、減少 JavaScript 依賴的場景，但在大規模或高度互動需求下，要審慎評估可維護性與可及性。

# Hamburger Menu 漢堡選單切換
> 手機版常見：隱藏 checkbox，label 當作漢堡按鈕，點擊切換後用 CSS 控制側邊選單的位移或遮罩。
> - 用途：行動端導航選單。

以下是一個純 CSS 實作的漢堡選單範例，採用隱藏的 checkbox 控制開關，並以相鄰的 label 繪製漢堡線條與「X」切換，最後用一般兄弟選擇器顯示／隱藏導覽菜單。

```html
<!-- HTML -->
<nav class="hamburger-nav">
  <!-- 隱藏的 checkbox 作為狀態開關 -->
  <input type="checkbox" id="hamburger-toggle" class="hamburger-checkbox">
  <!-- label 當作漢堡按鈕，同時繪製三條線 -->
  <label for="hamburger-toggle" class="hamburger-button" aria-label="切換選單"></label>

  <!-- 導覽菜單，預設隱藏 -->
  <ul class="hamburger-menu">
    <li><a href="#">首頁</a></li>
    <li><a href="#">關於我們</a></li>
    <li><a href="#">產品服務</a></li>
    <li><a href="#">聯絡我們</a></li>
  </ul>
</nav>
```

```css
/* 1. 隱藏 checkbox，但保留 focus */
.hamburger-checkbox {
  position: absolute;
  opacity: 0;
  width: 0; height: 0;
}

/* 2. 漢堡按鈕尺寸與位置 */
.hamburger-button {
  display: inline-block;
  width: 32px; height: 24px;
  position: relative;
  cursor: pointer;
  transition: transform 0.3s;
}

/* 3. 漢堡線條（上下中三條）*/
.hamburger-button::before,
.hamburger-button::after,
.hamburger-button span {
  content: "";
  position: absolute;
  left: 0; right: 0;
  height: 3px;
  background: #333;
  transition: transform 0.3s, top 0.3s, opacity 0.3s;
}
.hamburger-button::before { top: 0; }
.hamburger-button span  { top: 50%; transform: translateY(-50%); }
.hamburger-button::after  { bottom: 0; }

/* 4. 當開關打開時，把三條線變成「X」 */
.hamburger-checkbox:checked + .hamburger-button::before {
  top: 50%; transform: translateY(-50%) rotate(45deg);
}
.hamburger-checkbox:checked + .hamburger-button::after {
  bottom: auto; top: 50%; transform: translateY(-50%) rotate(-45deg);
}
.hamburger-checkbox:checked + .hamburger-button span {
  opacity: 0;
}

/* 5. 導覽菜單，預設隱藏並滑入 */
.hamburger-menu {
  list-style: none;
  margin: 1rem 0 0;
  padding: 0;
  max-height: 0;
  overflow: hidden;
  transition: max-height 0.3s ease;
}

/* 打開時展開 */
.hamburger-checkbox:checked ~ .hamburger-menu {
  max-height: 500px; /* 足夠容納菜單 */
}

/* 菜單項目樣式 */
.hamburger-menu li {
  margin: 0.5rem 0;
}
.hamburger-menu a {
  text-decoration: none;
  color: #333;
  font-size: 1rem;
  display: block;
  padding: 0.5rem;
  transition: background 0.2s;
}
.hamburger-menu a:hover {
  background: #f0f0f0;
}

/* 6. 鍵盤聚焦態（a11y） */
.hamburger-checkbox:focus + .hamburger-button {
  outline: 2px dashed #4d76fd;
  outline-offset: 4px;
}
```

**說明重點：**

* 用 `opacity:0` 而非 `display:none` 隱藏 checkbox，保留鍵盤操作與 focus；
* `.hamburger-button` 的 `::before`、`span`、`::after` 三條線，透過 `transform` 切換成「X」圖示；
* 導覽選單用 `max-height` + `overflow:hidden` 實現滑動展開效果；
* 可再進一步抽成 SCSS mixin 或 Vue/React 組件，以便統一管理尺寸、顏色與主題。

--- 

# CSS-Only Modal／Popover（彈窗／提示框）
> 隱藏 checkbox 再用 :checked 來觸發遮罩和內容的顯示；關閉則靠同一或另一個 label。
> - 優勢：無需 JS 綁事件；但不易做鍵盤／ESC 關閉等行為。

以下範例示範如何以純 CSS（零 JavaScript）實作一個簡易但可用於真實專案的 Modal／Popover。核心思路是：

1. 隱藏原生 `<input type="checkbox">` 作為開關；
2. 用一個 `<label>` 當作「開啟按鈕」，另一個 `<label>`（置於彈窗內）當作「關閉按鈕」；
3. 以 `:checked` 狀態控制遮罩層與內容的顯示／隱藏；
4. 保留原生 focus 行為並提供可見 focus 樣式，增強 a11y。

```html
<!-- HTML -->
<div class="modal-container">
  <!-- 1. 隱藏開關 -->
  <input type="checkbox" id="modal-toggle" class="modal-checkbox" />

  <!-- 2. 開啟按鈕 -->
  <label for="modal-toggle" class="modal-button">開啟彈窗</label>

  <!-- 3. 遮罩 + 內容 -->
  <div class="modal-overlay">
    <div class="modal-content" role="dialog" aria-modal="true" aria-labelledby="modal-title">
      <!-- 4. 關閉按鈕 -->
      <label for="modal-toggle" class="modal-close" aria-label="關閉彈窗">&times;</label>
      <h2 id="modal-title">彈窗標題</h2>
      <p>這是一段示範內容，可以放文字、表單或其他互動元件。</p>
    </div>
  </div>
</div>
```

```css
/* 隱藏開關，但保留 focus */
.modal-checkbox {
  position: absolute;
  opacity: 0;
  width: 0; height: 0;
}

/* 開啟按鈕 */
.modal-button {
  display: inline-block;
  padding: 0.5rem 1rem;
  background: #4d76fd;
  color: #fff;
  border-radius: 4px;
  cursor: pointer;
  user-select: none;
  transition: background 0.3s;
}
.modal-button:hover {
  background: #3b62d9;
}
.modal-checkbox:focus + .modal-button {
  outline: 2px dashed #4d76fd;
  outline-offset: 4px;
}

/* 遮罩層（預設隱藏） */
.modal-overlay {
  position: fixed;
  top: 0; left: 0; right: 0; bottom: 0;
  background: rgba(0,0,0,0.5);
  display: none;
  align-items: center;
  justify-content: center;
  padding: 1rem;
  z-index: 1000;
  transition: opacity 0.3s;
}

/* 選中時顯示 */
.modal-checkbox:checked ~ .modal-overlay {
  display: flex;
}

/* 內容盒子 */
.modal-content {
  background: #fff;
  border-radius: 6px;
  max-width: 500px;
  width: 100%;
  padding: 1.5rem;
  position: relative;
  box-shadow: 0 4px 12px rgba(0,0,0,0.15);
  transform: translateY(-20px);
  transition: transform 0.3s;
}
.modal-checkbox:checked ~ .modal-overlay .modal-content {
  transform: translateY(0);
}

/* 關閉按鈕 */
.modal-close {
  position: absolute;
  top: 0.5rem; right: 0.5rem;
  font-size: 1.5rem;
  line-height: 1;
  cursor: pointer;
  user-select: none;
  color: #666;
  transition: color 0.2s;
}
.modal-close:hover {
  color: #333;
}
.modal-close:focus {
  outline: 2px dashed #4d76fd;
  outline-offset: 4px;
}
```

---

**為何這麼做？**

* **零 JavaScript**：減少依賴，對於簡單提示框、Cookie 同意條款、輕量功能面板等場景非常有效。
* **CSS-only 動畫**：利用 `transition` 和 `transform`，讓遮罩淡入、內容滑動進場，增強使用者體驗。
* **可及性**：`opacity:0` 隱藏而非 `display:none`，保留鍵盤操作；並在開關與關閉按鈕上提供明顯的 focus 樣式。
* **易於組件化**：在真實專案中，可將 `.modal-*` 抽成 SCSS partial，或包成 Vue/React 元件，再傳入標題、內容作動態渲染。

**質疑與挑戰**

* **鍵盤聚焦管理**：此法無法實現 focus trap；進階需求仍須少量 JS 監聽鍵盤（如 ESC 關閉、Tab 限定在彈窗內）。
* **動態內容高度**：若內容高度超過視口，需額外處理滾動區域；可改為 `max-height: 80vh; overflow: auto;`。
* **多重彈窗管理**：若同時存在多個 Modal，需命名空間或改用 radio group + ARIA 屬性，避免互相干擾。

此方案適合簡單、輕量的提示/彈窗需求；若專案對可及性、鍵盤操作與複雜互動有更高要求，建議在此基礎上補強或改用專業 Modal Library。

---

# 星等評分（Star Rating）
> 一排隱形 radio + label，每個 label 用偽元素插入星星圖示，選中後用相鄰選擇器填滿樣式。
> - 用途：商品評分、互動式標籤。

以下範例示範一種純 CSS 的星等評分元件做法，利用隱藏的 radio 控制狀態，再以相鄰 label 的偽元素繪製星星，並支援滑鼠懸停以及鍵盤操作。請注意：純 CSS 方案只適合靜態選擇，若需動態讀取或顯示半顆星，還是得搭配 JavaScript。

```html
<!-- HTML -->
<div class="star-rating" role="radiogroup" aria-label="星等評分">
  <input type="radio" id="star5" name="rating" value="5" class="star-input">
  <label for="star5" class="star-label" aria-label="5 顆星">★</label>

  <input type="radio" id="star4" name="rating" value="4" class="star-input">
  <label for="star4" class="star-label" aria-label="4 顆星">★</label>

  <input type="radio" id="star3" name="rating" value="3" class="star-input">
  <label for="star3" class="star-label" aria-label="3 顆星">★</label>

  <input type="radio" id="star2" name="rating" value="2" class="star-input">
  <label for="star2" class="star-label" aria-label="2 顆星">★</label>

  <input type="radio" id="star1" name="rating" value="1" class="star-input">
  <label for="star1" class="star-label" aria-label="1 顆星">★</label>
</div>
```

```css
/* 1. 容器反向排列，讓 CSS sibling 選擇器能向「前面」的 label 套用樣式 */
.star-rating {
  display: inline-block;
  direction: rtl;
  font-size: 2rem;
  unicode-bidi: bidi-override;
}

/* 2. 隱藏原生 radio，但保留 focus 行為 */
.star-input {
  position: absolute;
  opacity: 0;
  width: 0; height: 0;
}

/* 3. 星星外觀 */
.star-label {
  display: inline-block;
  cursor: pointer;
  color: #ccc;
  transition: color 0.2s;
}

/* 4. 當滑鼠懸停特定星星，該星星及之前的都變色 */
.star-label:hover,
.star-label:hover ~ .star-label {
  color: #4d76fd;
}

/* 5. 當已選中（checked），該星星及之前的星星保留選中狀態 */
.star-input:checked ~ .star-label {
  color: #4d76fd;
}

/* 6. 鍵盤 focus 樣式 */
.star-input:focus + .star-label {
  outline: 2px dashed #4d76fd;
  outline-offset: 4px;
}
```

---

**質疑與檢視：**

* **動態與部分星**：若要在後端渲染預設分數、或顯示半顆星，需要額外的 JavaScript 或改用 SVG 元件。
* **可及性**：已加上 `role="radiogroup"` 及各 label 的 `aria-label`，但還可再補 `aria-checked`、`tabindex` 管理，確保螢幕閱讀器與鍵盤使用體驗完整。
* **維護性**：若想共用於專案中，建議封裝為 SCSS mixin、或 Vue/React 元件，引入時只要傳入 `value`、`max` 即可。

---

# 自訂檔案上傳按鈕 / Range Slider
> 隱藏 <input type="file"> 或 <input type="range">，自己畫按鈕或刻度，再用 CSS 控制:hover、:focus、:active 等狀態。
> - 用途：統一 UI 風格、加入更豐富的互動效果。

以下範例示範如何「隱藏原生控制元件，改由相鄰的 `<label>` 或偽元素來繪製」，以達到自訂化的檔案上傳按鈕和 Range Slider 效果。請務必在專案中抽成 mixin/變數並補強 a11y（如 focus 樣式、隱藏文字、aria 屬性）以確保可維護性與可及性。

---

## 1. 自訂檔案上傳按鈕

```html
<div class="file-upload">
  <!-- 隱藏原生 input -->
  <input type="file" id="fileInput" class="file-input" />
  <!-- 自訂按鈕 -->
  <label for="fileInput" class="file-label">
    選擇檔案
  </label>
  <!-- 顯示檔名 -->
  <span class="file-name" id="fileName">尚未選擇檔案</span>
</div>
```

```css
/* 隱藏原生 input，但保留 focus */
.file-input {
  position: absolute;
  opacity: 0;
  width: 0;
  height: 0;
}

/* 自訂按鈕外觀 */
.file-label {
  display: inline-block;
  padding: 0.6em 1.2em;
  background-color: #4d76fd;
  color: #fff;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s;
  user-select: none;
}
.file-label:hover {
  background-color: #3b62d9;
}
/* 鍵盤 focus 樣式 */
.file-input:focus + .file-label {
  outline: 2px dashed #4d76fd;
  outline-offset: 4px;
}

/* 檔名顯示 */
.file-name {
  margin-left: 1em;
  font-size: 0.9em;
  color: #666;
}
```

> 若要動態顯示使用者選擇的檔名，需要一小段 JavaScript：

```js
const fileInput = document.getElementById('fileInput');
const fileName  = document.getElementById('fileName');
fileInput.addEventListener('change', () => {
  fileName.textContent = fileInput.files.length
    ? fileInput.files[0].name
    : '尚未選擇檔案';
});
```

---

## 2. 自訂 Range Slider

```html
<div class="range-container">
  <input type="range" id="range" class="custom-range"
         min="0" max="100" value="50">
  <output for="range" id="rangeValue">50</output>
</div>
```

```css
/* 基本軌道樣式 */
.custom-range {
  -webkit-appearance: none; /* 移除預設樣式 */
  width: 100%;
  height: 6px;
  background: #ddd;
  border-radius: 3px;
  outline: none;
  transition: background 0.3s;
}
.custom-range:hover {
  background: #ccc;
}

/* WebKit 拇指（Thumb） */
.custom-range::-webkit-slider-thumb {
  -webkit-appearance: none;
  width: 18px;
  height: 18px;
  border-radius: 50%;
  background: #4d76fd;
  cursor: pointer;
  transition: background 0.3s, transform 0.2s;
}
.custom-range::-webkit-slider-thumb:hover {
  background: #3b62d9;
  transform: scale(1.1);
}
.custom-range:focus::-webkit-slider-thumb {
  outline: 2px dashed #4d76fd;
  outline-offset: 4px;
}

/* Firefox 拇指（Thumb） */
.custom-range::-moz-range-thumb {
  width: 18px;
  height: 18px;
  border: none;
  border-radius: 50%;
  background: #4d76fd;
  cursor: pointer;
  transition: background 0.3s, transform 0.2s;
}
.custom-range::-moz-range-thumb:hover {
  background: #3b62d9;
  transform: scale(1.1);
}
.custom-range:focus::-moz-range-thumb {
  outline: 2px dashed #4d76fd;
  outline-offset: 4px;
}

/* 值顯示 */
#rangeValue {
  margin-left: 0.5em;
  font-size: 0.9em;
  color: #333;
}
```

```js
const range      = document.getElementById('range');
const rangeValue = document.getElementById('rangeValue');
range.addEventListener('input', () => {
  rangeValue.textContent = range.value;
});
```

---

### 檢視與質疑

1. **維護性**：建議將顏色、尺寸等抽成 SCSS 變數或 mixin，並封裝成通用元件。
2. **可及性（a11y）**：

   * 確保所有互動元件皆可鍵盤操作，並提供清晰的 focus 樣式。
   * 對 file upload 可補 `aria-describedby`，range slider 可補 `aria-valuemin/max`、`aria-valuenow`。
3. **效能與快取**：

   * 如需多處使用相同圖示，可考慮 SVG Sprite 或 icon font，避免重複 inline 資源。

這兩種純 CSS+少量 JS 的自訂元件思路，適用於大部分無需複雜行為、希望減少依賴的場景；若需求升級，請考慮在此基礎上加入更完善的行為與無障礙支援。

---

# 步驟指示器（Step Indicator）／進度條
> 用一系列隱藏的 checkbox 控制目前步驟的高亮，搭配 Flex/Grid 排列即可。
> - 用途：多步驟表單、安裝精靈。

下面範例示範如何用一組隱藏的 radio（也可視同 checkbox 用法）控制「目前步驟」的高亮，並搭配 Flex 排列＋偽元素畫圓點與底線，完全純 CSS 實現。

```html
<!-- HTML：一組隱藏的 radio + label -->
<div class="stepper">
  <input type="radio" name="step" id="step1" class="step-input" checked>
  <label for="step1" class="step-label">購物車</label>

  <input type="radio" name="step" id="step2" class="step-input">
  <label for="step2" class="step-label">運送資料</label>

  <input type="radio" name="step" id="step3" class="step-input">
  <label for="step3" class="step-label">付款方式</label>

  <input type="radio" name="step" id="step4" class="step-input">
  <label for="step4" class="step-label">完成訂單</label>
</div>
```

```css
/* 1. 隱藏原生 radio，但保留 focus */
.step-input {
  position: absolute;
  opacity: 0;
  width: 0; height: 0;
}

/* 2. 總容器——Flex 排列、置中對齊 */
.stepper {
  position: relative;
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin: 2rem 0;
  padding: 0 1rem;
}

/* 3. 背後的連接線 */
.stepper::before {
  content: "";
  position: absolute;
  top: 50%;
  left: 1rem;
  right: 1rem;
  height: 2px;
  background: #ddd;
  transform: translateY(-50%);
  z-index: 1;
}

/* 4. 每個步驟的 label */
.step-label {
  position: relative;
  z-index: 2;
  flex: 1;
  text-align: center;
  cursor: pointer;
  user-select: none;
  padding-top: 1.5rem;  /* 為圓點留空間 */
  transition: color 0.3s;
  color: #666;
}

/* 5. label 上的圓點 */
.step-label::before {
  content: "";
  position: absolute;
  top: 0;
  left: 50%;
  transform: translateX(-50%);
  width: 16px;
  height: 16px;
  border: 2px solid #ccc;
  border-radius: 50%;
  background: #fff;
  transition: border-color 0.3s, background 0.3s;
}

/* 6. 當前步驟高亮（填滿圓點 + 文字變色） */
.step-input:checked + .step-label {
  color: #4d76fd;
}
.step-input:checked + .step-label::before {
  background: #4d76fd;
  border-color: #4d76fd;
}

/* 7. 鍵盤 focus 樣式 */
.step-input:focus + .step-label::before {
  outline: 2px dashed #4d76fd;
  outline-offset: 4px;
}
```

---

**說明：**

1. **Flex+偽元素**：`.stepper::before` 畫出連接線，`.step-label::before` 畫圓點。
2. **隱藏輸入、保留 focus**：用 `opacity:0`、`position:absolute` 隱藏 radio，但 `:focus` 仍然有效。
3. **互斥選擇**：radio group 保證同一時間只有一個步驟被選中，並觸發高亮樣式。
4. **可維護性**：若需要「已完成步驟」與「目前步驟」不同樣式，可額外在之前步驟的 label 前加入 CSS 規則（例如用 `~` 兄弟選擇器）；也可將顏色、尺寸抽成 SCSS 變數或 mixin。
5. **無障礙**：提供明顯的 focus 樣式；實務中可再補 `role="radiogroup"`、`role="radio"`、`aria-checked` 等 ARIA 屬性，讓螢幕閱讀器告知使用者目前狀態。
