# 一、流體響應式基礎設定

```css
img {
  display: block;
  max-width: 100%;
}
```

### 原理
1. `display: block;`：去除行內元素底部白隙，並可自由設定上下 margin。
2. `max-width: 100%;`：讓圖片寬度不超出父容器，縮小時自動等比縮放。

### 案例 1：文章內置圖

```html
<article class="post">
  <h2>標題</h2>
  <p>段落文字...</p>
  <img src="banner.jpg" alt="文章插圖">
  <p>更多內文...</p>
</article>
```

```css
.post img { /* 已含共用樣式 */
  margin: 1rem 0;
}
```

> **效果**：圖片寬度隨文章區域縮放，不會溢出也不留左右空白。

### 案例 2：卡片縮略圖

```html
<div class="card">
  <img src="thumb.jpg" alt="縮略圖">
  <div class="info">卡片內容</div>
</div>
```

```css
.card {
  width: 250px;
  border: 1px solid #ddd;
  overflow: hidden;
}
.card img { /* 基礎響應式 */
  display: block;
  max-width: 100%;
}
```

> **效果**：即便圖片本身寬度超過 250px，也會自動縮放到卡片寬度。

---

# 二、裁切填滿的 object-fit

```css
.image {
  width: 100%;
  height: 200px;       /* 固定或比例高度皆可 */
  object-fit: cover;
}
```

> **原理**
> - `object-fit: cover;`：保持素材比例，放大至填滿容器，超出部分自動裁切。

### 案例 1：卡片封面圖

```html
<div class="card">
  <img class="image" src="cover.jpg" alt="卡片封面">
  <h3>卡片標題</h3>
</div>
```

```css
.card {
  width: 300px;
  height: 180px;
  overflow: hidden;
}
.card .image {
  width: 100%;
  height: 100%;
  object-fit: cover;
}
```

> **效果**：不同尺寸的 cover.jpg 都會均勻填滿 300×180 的區塊。

### 案例 2：Hero Banner

```html
<section class="hero">
  <img class="image" src="hero.jpg" alt="大圖橫幅">
  <div class="overlay">Welcome</div>
</section>
```

```css
.hero {
  position: relative;
  height: 400px;
  overflow: hidden;
}
.hero .image {
  position: absolute;
  top: 0;
  left: 0;
  width:100%;
  height:100%;
  object-fit: cover;
}
.hero .overlay {
  position: relative;
  color: #fff;
  text-align: center;
  padding-top: 180px;
}
```

> **效果**：hero.jpg 會自動裁切，確保重要畫面區域永遠可見。

### 案例 3：圓形頭像 Avatar

```html
<img class="image avatar" src="profile.jpg" alt="頭像">
```

```css
.avatar {
  width: 80px;
  height: 80px;
  border-radius: 50%;
  overflow: hidden;
}
.avatar.image {
  object-fit: cover;
}
```

* **效果**：不論 profile.jpg 原始比例，皆裁切為完美圓形頭像。

---

# 三、結合「流體」＋「裁切」：`.img-cover`

```css
.img-cover {
  display: block;      /* 參考基礎設定 */
  width: 100%;
  max-width: 100%;
  height: 200px;       /* 或自訂比例、高度 */
  object-fit: cover;   /* 裁切填滿 */
}
```

```html
<div class="card">
  <img class="img-cover" src="photo.jpg" alt="示例照片">
  <p>說明文字</p>
</div>
```

> **特性**：
> 1. 宽度隨容器自适应，永不溢出。
> 2. 高度固定並裁切，畫面一致性佳。

### 案例：響應式卡片封面

```html
<div class="card">
  <img class="img-cover" src="landscape.jpg" alt="景觀照">
  <div class="content">卡片說明</div>
</div>
```

```css
.card {
  width: 100%;
  max-width: 320px;
  overflow: hidden;
  border: 1px solid #ccc;
}
.card .img-cover {
  height: 180px;
}
```

> **效果**：landscape.jpg 根據卡片寬度縮放，並裁切頂部／底部以符合 320×180 規格。

---

# 四、小技巧

* 若希望更靈活，可將 `height` 設為 `%`、`vh/vw` 或依據父容器比例。
* 直接把基礎與裁切設定合併成一段 `.img-cover`，減少重複：

  ```css
  .img-cover {
    display: block;
    width: 100%;
    max-width: 100%;
    height: 200px;
    object-fit: cover;
  }
  ```
* 若要支援低階瀏覽器，可在必要時加上 `object-position: center;` 以微調裁切位置。

---
