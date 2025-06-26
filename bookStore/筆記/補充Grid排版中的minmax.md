以下範例補充 `minmax()` 在各種場景下的靈活應用，並說明它如何兼顧「最小尺寸保護」與「最大彈性擴張」。

---

## 範例一：流式卡片牆（固定最小寬度，自動填滿容器）

**HTML**

```html
<div class="fluid-gallery">
  <div class="card">A</div>
  <div class="card">B</div>
  <div class="card">C</div>
  <div class="card">D</div>
  <div class="card">E</div>
</div>
```

**SCSS**

```scss
$gap: 16px;
$min-width: 180px;

.fluid-gallery {
  display: grid;
  /* 每個欄位最小 180px，最大按剩餘空間等分 */
  grid-template-columns: repeat(auto-fit, minmax($min-width, 1fr));
  gap: $gap;
  padding: $gap;
  margin: 0 auto;
}
.card {
  background: #eef;
  padding: 24px;
  text-align: center;
  border-radius: 4px;
}
```

> **說明**：
>
> * `auto-fit`＋`minmax(180px, 1fr)` 可讓卡片在寬度足夠時自動新增欄數，窄螢幕時保持每欄至少 180px，不會被壓得過窄。

---

## 範例二：動態行高控制（內容自適應＋最大高度限制）

**HTML**

```html
<div class="text-list">
  <div class="item">短標題</div>
  <div class="item">這是一段比較長的文字，用來測試行高是否能自動擴張</div>
  <div class="item">中等長度文字</div>
</div>
```

**SCSS**

```scss
$text-gap: 12px;

.text-list {
  display: grid;
  /* 行高最小 40px，最大自動撐開（auto），項目之間保留間距 */
  grid-auto-rows: minmax(40px, auto);
  row-gap: $text-gap;
  padding: $text-gap;
}
.item {
  background: #fde;
  padding: 8px;
  border-radius: 3px;
}
```

> **說明**：
>
> * `grid-auto-rows: minmax(40px, auto)` 保證每列至少 40px 高，內容多時自動增高，避免文字溢出或不均。

---

## 範例三：兩區段佈局（可調整側邊欄最小/最大寬度）

**HTML**

```html
<div class="layout">
  <aside class="sidebar">側邊選單</aside>
  <main class="main-content">主要內容區</main>
</div>
```

**SCSS**

```scss
$gap: 20px;
$sidebar-min: 200px;
$sidebar-max: 300px;

.layout {
  display: grid;
  grid-template-columns: minmax($sidebar-min, $sidebar-max) 1fr;
  gap: $gap;
  padding: $gap;
}
.sidebar {
  background: #eef4ff;
  padding: 16px;
  border-radius: 4px;
}
.main-content {
  background: #f4ffe8;
  padding: 16px;
  border-radius: 4px;
}
```

> **說明**：
>
> * 側邊欄寬度可在 200–300px 間彈性伸縮，主區域自動填滿剩餘空間；適用於桌機/平板不同解析度。

---

## 範例四：維持長寬比的網格項目

**HTML**

```html
<div class="ratio-grid">
  <div class="box">1:1</div>
  <div class="box">2:1</div>
  <div class="box">1:2</div>
</div>
```

**SCSS**

```scss
$gap: 16px;

.ratio-grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: $gap;
  padding: $gap;
}

.box {
  position: relative;
  background: #ffe;
  border: 1px solid #ccc;
  border-radius: 4px;
  
  /* 先用 minmax 控制高度，再用 padding-top 依比例設定高度 */
  grid-auto-rows: minmax(100px, 0);
}

.box:nth-child(1) { padding-top: 100%; } /* 1:1 */
.box:nth-child(2) { padding-top: 50%;  } /* 2:1 */
.box:nth-child(3) { padding-top: 200%; } /* 1:2 */
```

> **說明**：
>
> * `grid-auto-rows: minmax(100px, 0)` 先確保最小高度 100px；實際高度由 `padding-top` 決定，維持長寬比。

---

### 疑問拋磚

* 在以上例子中，您是否發現 `minmax()` 在保障「最低可讀性／最小可互動區域」的同時，也讓整體佈局更具彈性？
* 若您的專案有更特殊的「最大尺寸」或「最小尺寸」需求，還可結合百分比、`fr`、`px` 乃至 `em` 單位，您認為哪種組合最適合？
