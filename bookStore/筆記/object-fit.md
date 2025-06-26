# 說明
在實際專案中，我們常在以下幾種情境下「非用不可」地採用 `object-fit`：

1. **固定容器但圖片尺寸不一**
   當卡片、格子佈局（grid）、列表等 UI 元素的寬高都是統一固定的，但來源圖片的寬高比例千變萬化，如果只用 `width: 100%; height: 100%`，就會導致圖片被強行拉伸、變形。
   ▸ `object-fit: cover;` 可自動依照容器比例裁切並填滿，不必再多套一層背景圖或額外的裁剪邏輯。

2. **維持原始長寬比又要填滿容器**
   單純用 `width: 100%; height: auto;` 雖能維持比例，卻無法保證垂直方向也填滿；反過來，若兩者都設定 100%，就必須靠 `object-fit` 來平衡：「不失真地填滿」或「完整顯示並留白」。

   * `object-fit: contain;` → 完整顯示，兩側留白
   * `object-fit: cover;`   → 填滿容器，中央裁切

3. **響應式設計下的簡化方案**
   在 RWD 中，容器大小會隨螢幕、彈性佈局而動；若還要動態計算裁切區塊、寫 JavaScript，反而複雜且效能差。
   `object-fit` 一行 CSS，瀏覽器幫你完成所有調整，既乾淨又高效。

4. **減少額外標記與樣式**
   傳統解法常見：

   ```html
   <div class="thumb">
     <img src="..." alt="">
   </div>
   ```

   再用 `.thumb { background-image: url(...); background-size: cover; }`
   但這會犧牲語意（無法保留 `<img>` 的 alt），且失去原生延遲載入（lazy-loading）支援。`object-fit` 讓你既保留語意，也獲得背景圖般的裁切效果。

### 什麼時候可以不用？

* **只需單向延伸**：若你只想按比例調整，一邊寬度或高度固定、另一邊自適應，直接用 `width: 100%; height: auto;` 即可。
* **背景裝飾圖**：若圖片純粹是裝飾、與語意無關，就可改用 `background-image` + `background-size`。

### 結論

並非「任何」圖片都要套 `object-fit`，但在「需要同時固定寬高、維持比例、並自動裁切」的場景中，它是最簡潔、具語意且效能優的方案。
下次遇到相同問題，不妨先思考：

> 「我的目標是──拉伸？完整顯示？還是填滿？」
> 針對不同需求，選擇最合適的 `object-fit` 值即可。

--- 

# 範例
以下示例涵蓋不同場景下常見的 `object-fit` 用法，助您更直觀地掌握其特性與應用。每個範例都包含 HTML 結構與對應的 CSS 設定，請直接拷貝到專案中測試。


## 1. 商品卡片（`cover`）

**需求**：固定寬高的卡片內，圖片自動填滿並保持比例，多餘部分從中心裁切。

```html
<!-- HTML -->
<div class="product-card">
  <img src="https://via.placeholder.com/400x300" alt="商品圖" />
  <h3>商品名稱</h3>
  <p>NT$1,200</p>
</div>
```

```css
/* CSS */
.product-card {
  width: 200px;
  height: 200px;
  border: 1px solid #ddd;
  overflow: hidden;
  text-align: center;
}
.product-card img {
  width: 100%;
  height: 100%;
  object-fit: cover; /* 關鍵 */
}
```

**解說**：不論原圖比例，皆以卡片中心為基準裁切，確保不留空白且不變形。

## 2. 使用者大頭貼（`contain`）

**需求**：圓形容器內，完整顯示圖片且不變形，背景顯示預設底色。

```html
<!-- HTML -->
<div class="avatar">
  <img src="https://via.placeholder.com/300x500" alt="使用者大頭貼" />
</div>
```

```css
/* CSS */
.avatar {
  width: 100px;
  height: 100px;
  border-radius: 50%;
  background-color: #f0f0f0;
  overflow: hidden;
}
.avatar img {
  width: 100%;
  height: 100%;
  object-fit: contain; /* 完整顯示 */
}
```

**解說**：原圖縱橫比存在，四周可能留白，但能保留全貌且不變形。

## 3. 全螢幕橫幅（`cover` + 響應式）

**需求**：頂部橫幅圖需隨視窗寬度變化自動縮放、裁切。

```html
<!-- HTML -->
<section class="hero-banner">
  <img src="https://via.placeholder.com/1600x600" alt="橫幅圖" />
  <h1>歡迎光臨</h1>
</section>
```

```css
/* CSS */
.hero-banner {
  position: relative;
  width: 100%;
  height: 50vh;
  overflow: hidden;
}
.hero-banner img {
  position: absolute;
  top: 0; left: 0;
  width: 100%; height: 100%;
  object-fit: cover;
}
.hero-banner h1 {
  position: relative;
  text-align: center;
  line-height: 50vh;
  color: white;
  text-shadow: 0 0 5px rgba(0,0,0,0.7);
}
```

**解說**：橫幅圖自動填滿視窗高度的一半，中央裁切，並保證文字置中可讀。

## 4. 影片縮圖列表（`scale-down`）

**需求**：列表中需要同時保持圖片完整顯示、不得放大以致失真。

```html
<!-- HTML -->
<ul class="thumbnail-list">
  <li><img src="https://via.placeholder.com/640x360" alt="縮圖1"></li>
  <li><img src="https://via.placeholder.com/200x300" alt="縮圖2"></li>
  <li><img src="https://via.placeholder.com/300x200" alt="縮圖3"></li>
</ul>
```

```css
/* CSS */
.thumbnail-list {
  display: flex;
  gap: 16px;
  list-style: none;
  padding: 0;
}
.thumbnail-list li {
  width: 120px;
  height: 90px;
  border: 1px solid #ccc;
  overflow: hidden;
}
.thumbnail-list img {
  width: 100%;
  height: 100%;
  object-fit: scale-down; /* 不裁切、不放大 */
}
```

**解說**：當原圖尺寸大於容器時，等同 `contain`；小於容器時，等同 `none`，避免放大失真。

## 5. 自訂比例容器（`none`）

**需求**：容器需維持 4:3 比例展示圖片，但允許圖片正常顯示原始大小（可能跑版）。

```html
<!-- HTML -->
<div class="ratio-4-3">
  <img src="https://via.placeholder.com/800x600" alt="4:3 圖片">
</div>
```

```css
/* CSS */
.ratio-4-3 {
  width: 320px;
  aspect-ratio: 4 / 3;
  border: 1px dashed #888;
  overflow: hidden;
}
.ratio-4-3 img {
  object-fit: none; /* 原圖置左上，不做縮放 */
}
```

**解說**：不縮放圖像，僅顯示左上區塊；用於特殊需求，如局部裁切或搭配 JS 控制。

## 小結

* `cover`：填滿＋裁切（最常用）
* `contain`：完整顯示＋留白
* `scale-down`：縮小不放大
* `none`：不縮放
* **實戰建議**：先界定「裁切／完整顯示」與「放大／等比縮放」需求，再選擇最符合的值。
* 非必要時，可用單邊固定（`width:100%; height:auto;`）取代。

透過這些範例，您可以在各種 UI 情境下靈活運用 `object-fit`，提升開發效率與使用者體驗。

---