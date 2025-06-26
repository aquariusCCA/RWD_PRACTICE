以下範例展示四種常見的 CSS Grid 實戰場景，並附上對應的 HTML 和 SCSS 實作。您可以依專案需求，調整欄位數、間距、斷點等設定。

---

## 案例一：響應式卡片自動填充

> **需求場景**
> 多張卡片在寬螢幕下呈現三欄，窄螢幕時自動折返。您是否真正需要手動設定每個媒體斷點？

### HTML

```html
<div class="card-gallery">
  <div class="card">Card 1</div>
  <div class="card">Card 2</div>
  <div class="card">Card 3</div>
  <div class="card">Card 4</div>
  <div class="card">Card 5</div>
  <div class="card">Card 6</div>
</div>
```

### SCSS

```scss
$gap: 16px;
$min-card-width: 200px;

.card-gallery {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax($min-card-width, 1fr));
  gap: $gap;
  padding: $gap;

  // 可思考：是否需要額外的 max-width 限制？
  max-width: 1200px;
  margin: 0 auto;
}

.card {
  background: #f8f8f8;
  padding: 24px;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(#000, .1);
  text-align: center;
}
```

---

## 案例二：Dashboard 佈局（grid-template-areas）

> **需求場景**
> 一個典型儀表板包含：頂部導航、左側選單、右側主內容以及底部版權。直接用 grid-template-areas 是否更直觀？

### HTML

```html
<div class="dashboard">
  <header class="dashboard__header">Header</header>
  <aside class="dashboard__sidebar">Sidebar</aside>
  <main class="dashboard__content">Main Content</main>
  <footer class="dashboard__footer">Footer</footer>
</div>
```

### SCSS

```scss
$sidebar-width: 240px;
$header-height: 64px;
$footer-height: 40px;
$gap: 16px;

.dashboard {
  display: grid;
  grid-template-columns: $sidebar-width 1fr;
  grid-template-rows: $header-height 1fr $footer-height;
  grid-template-areas:
    "header header"
    "sidebar content"
    "footer footer";
  height: 100vh;
  gap: $gap;

  &__header   { grid-area: header; background: #24292e; color: #fff; display: flex; align-items: center; padding: 0 24px; }
  &__sidebar  { grid-area: sidebar; background: #f6f8fa; padding: 24px; overflow-y: auto; }
  &__content  { grid-area: content; padding: 24px; overflow-y: auto; }
  &__footer   { grid-area: footer; background: #e1e4e8; text-align: center; line-height: $footer-height; }
}
```

---

## 案例三：不規則瀑布流式相片牆

> **需求場景**
> 需要隨機高低不一的相片排版，並自動補位？純 CSS Grid＋`grid-auto-flow: dense` 就能簡易實現嗎？

### HTML

```html
<div class="masonry">
  <div class="item h2">A</div>
  <div class="item">B</div>
  <div class="item h3">C</div>
  <div class="item">D</div>
  <div class="item">E</div>
  <div class="item h2">F</div>
  <div class="item">G</div>
</div>
```

### SCSS

```scss
$gap: 8px;

.masonry {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(150px, 1fr));
  gap: $gap;
  grid-auto-rows: 150px;
  grid-auto-flow: dense; // 允許填補空洞

  .item {
    background: #cfd8dc;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 1.5rem;
    border-radius: 4px;
    overflow: hidden;

    &.h2 { grid-row: span 2; } // 佔據兩行
    &.h3 { grid-row: span 3; } // 佔據三行
  }
}
```

---

## 案例四：雜誌排版（嵌套 Grid + subgrid 思維）

> **需求場景**
> 主區塊左右分欄，且內部文章區要再細分：使用 subgrid 概念（暫以父子共用同樣間距模擬）是否更易維護？

### HTML

```html
<section class="magazine">
  <div class="magazine__sidebar">側欄</div>
  <article class="magazine__article">
    <header class="article__header">文章標題</header>
    <div class="article__content">
      <p>第一段文字……</p>
      <p>第二段文字……</p>
      <p>第三段文字……</p>
    </div>
    <footer class="article__footer">作者 • 日期</footer>
  </article>
</section>
```

### SCSS

```scss
$gap: 24px;

.magazine {
  display: grid;
  grid-template-columns: 1fr 3fr;
  gap: $gap;
  padding: $gap;

  &__sidebar {
    background: #eceff1;
    padding: $gap;
    border-radius: 6px;
  }

  &__article {
    display: grid;
    grid-template-rows: auto 1fr auto;
    gap: $gap; // 與父層共用間距
    background: #fff;
    padding: $gap;
    border-radius: 6px;
    box-shadow: 0 2px 6px rgba(#000, .08);

    &__header { font-size: 1.75rem; font-weight: bold; }
    &__content { line-height: 1.6; }
    &__footer  { font-size: 0.875rem; color: #555; text-align: right; }
  }
}
```

---

以上四種範例各有取捨：

* **自動填充**：最少手動斷點設定，對於卡片牆最直覺；
* **Template‐areas**：語意化極佳，適合複雜儀表板；
* **Dense 瀑布流**：純 CSS 近似 Masonry，但仍有空白風險；
* **嵌套 Grid**：子容器延續父層間距，思考未來 subgrid 取代方式。

您是否已經找到最適合當前專案的那一種？如果兼容或框架有限制，還需要考慮 fallback 或同時混用 Flexbox 嗎？
