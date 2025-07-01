下面以正式、專業的語氣，從多個層面比對與說明 `display: flex` 與 `display: inline-flex` 的相關知識，並提供範例協助理解。

---

## 一、顯示類型（Formatting Context）

1. **`display: flex`**

   * 生成一個 **塊級彈性容器**（block-level flex container）。
   * 在塊級格式化上下文中，其 **寬度預設為 `auto`**，會撐滿包含塊（即父容器）可用寬度。
   * 元素前後會換行。

2. **`display: inline-flex`**

   * 生成一個 **行內彈性容器**（inline-level flex container）。
   * 行內格式化上下文中，其 **寬度為 shrink-to-fit**，僅包覆內容所需寬度（類似 `inline-block`）。
   * 不會強制換行，可與兄弟行內元素同列顯示。

---

## 二、共同特性：Flex 容器屬性

無論是塊級或行內彈性容器，都支援下列核心屬性，控制子元素（flex items）的排列行為：

| 屬性                | 說明                                          |
| ----------------- | ------------------------------------------- |
| `flex-direction`  | 排列主軸方向：`row`（水平，預設）、`column`（垂直）等           |
| `flex-wrap`       | 是否換行：`nowrap`（不換行，預設）、`wrap`（換行）等           |
| `justify-content` | 主軸對齊：`flex-start`、`center`、`space-between`… |
| `align-items`     | 交叉軸對齊：`flex-start`、`center`、`stretch`（預設）…  |
| `align-content`   | 多行內容的交叉軸排列（僅當 `flex-wrap: wrap` 時有效）        |

```css
.container {
  display: flex;            /* 或 inline-flex */
  flex-direction: row;      /* 主軸水平 */
  flex-wrap: wrap;          /* 超出時換行 */
  justify-content: center;  /* 水平置中對齊 */
  align-items: center;      /* 垂直置中對齊 */
  gap: 10px;                /* Flex item 之間的間距（較新規範） */
}
```

---

## 三、Flex 項目屬性

每個直接子元素都可設定以下屬性來控制伸縮與基礎尺寸：

| 屬性            | 說明                           |
| ------------- | ---------------------------- |
| `flex-grow`   | 增長因子，定義可分配剩餘空間比例；預設 `0`（不增長） |
| `flex-shrink` | 收縮因子，定義空間不足時如何縮小；預設 `1`（可縮小） |
| `flex-basis`  | 初始尺寸；可為固定長度或 `auto`（內容尺寸或寬度） |
| `order`       | 排序順序；數值越小越靠前，預設 `0`          |

```css
.item {
  flex: 1 1 200px;  /* flex-grow:1，flex-shrink:1，flex-basis:200px */
  order: 2;         /* 決定排列順序 */
}
```

---

## 四、`flex` vs. `inline-flex` 的選擇時機

1. **想要讓容器撐滿父容器** → 使用 `display: flex`

   * 常見於布局區塊：側邊欄、主內容區、導航列等。

2. **想要讓容器僅包覆子元素** → 使用 `display: inline-flex`

   * 常見於按鈕、標籤、圖示組合等：和文字或其他行內元素在同一行顯示，且寬度根據內容自適應。

```html
<!-- inline-flex：按鈕隨文字寬度伸縮 -->
<a href="#" class="btn-inline">按我 <svg>…</svg></a>

<!-- flex：區塊式橫向菜單撐滿整行 -->
<nav class="navbar">
  <a href="#">Home</a>
  <a href="#">About</a>
  <a href="#">Contact</a>
</nav>
```

```css
.btn-inline {
  display: inline-flex;
  align-items: center;
  padding: 8px 12px;
  background: #0066cc;
  color: #fff;
}

.navbar {
  display: flex;
  justify-content: space-around;
  background: #333;
}
```

---

## 五、常見誤區與疑問

1. **「為何 `flex` 容器寬度變得很大？」**
   → 因 `flex` 默認為塊級，寬度 `auto` → 撐滿可用空間。

2. **「`inline-flex` 可否包裏多行？」**
   → `inline-flex` 本身是單行容器；若要多行排列，需子項設 `flex-wrap: wrap`，但容器整體仍為行內級，會與周遭元素同列。

3. **「Flex 會影響文檔流？」**
   → 容器轉為 flex 後，其直系子元素脫離普通塊流，排列方式由 flex 規則決定；但容器本身仍遵守其 `display` 定義的文檔流行為。

---

### 總結

* **`display: flex`**：塊級 → 撐滿父寬；行內換行
* **`display: inline-flex`**：行內 → shrink-to-fit；同列顯示
* **兩者共享彈性容器機制**：`flex-direction`、`justify-content`、`align-items`、`flex` shorthand…

若在按鈕或小組件上同時需求彈性排列與自適應寬度，請務必選用 `inline-flex`。若需整行水平分佈或占滿容器，請使用 `flex`。如此才能真正掌握彈性布局的核心精髓。
