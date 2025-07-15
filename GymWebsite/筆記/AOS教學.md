> **參考文章**
> - [AOS-Animate 套件運用](https://www.tpisoftware.com/tpu/articleDetails/2797 "AOS-Animate 套件運用")
> - [AOS-Animate Ｇithub](https://github.com/michalsnik/aos "AOS-Animate Ｇithub")
> - [AOS-Animate 官網](https://michalsnik.github.io/aos/ "AOS-Animate 官網")

[AOS (Animate On Scroll)](https://michalsnik.github.io/aos/ "AOS (Animate On Scroll)") 是一款輕量、易用的滾動動畫庫，能夠在使用者滾動頁面時自動觸發各種 CSS 動畫。下面示範一個最基本的整合範例，從 CDN 引入、初始化到 HTML 標記和簡單自訂 CSS 全流程：

---

# 1. 引入 AOS

在 `<head>` 裡加入 AOS 的 CSS，於 `<body>` 結尾前加入 AOS 的 JS：

```html
<!-- AOS 樣式 -->
<link
  rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/aos@2.3.4/dist/aos.css"
/>

<!-- ...你的其他樣式與內容... -->

<!-- AOS 腳本 -->
<script src="https://cdn.jsdelivr.net/npm/aos@2.3.4/dist/aos.js"></script>
<script>
  // 初始化 AOS：可設定持續時間、偏移值、是否只執行一次等選項
  AOS.init({
    duration: 800,   // 動畫持續時間，單位毫秒
    offset: 120,     // 觸發動畫前偏移量，單位像素
    once: true       // 只在第一次滾動到該元素時執行一次
  });
</script>
```

---

# 2. HTML 標記範例

在你希望出現滾動動畫的元素上，加入 `data-aos` 屬性並指定動畫類型，例如 `fade-up`、`slide-right`、`zoom-in` 等：

```html
<body>
  <section class="hero">
    <h1 data-aos="fade-down">歡迎使用 AOS 動畫</h1>
    <p data-aos="fade-up" data-aos-delay="200">
      這段文字 200ms 後才開始出現
    </p>
    <button data-aos="zoom-in" data-aos-duration="1200">
      立即體驗
    </button>
  </section>

  <section class="features">
    <div class="feature-item" data-aos="flip-left">
      <h3>功能一</h3>
      <p>描述功能一的內容。</p>
    </div>
    <div class="feature-item" data-aos="flip-right" data-aos-offset="100">
      <h3>功能二</h3>
      <p>描述功能二的內容。</p>
    </div>
    <div class="feature-item" data-aos="fade-up" data-aos-delay="300">
      <h3>功能三</h3>
      <p>描述功能三的內容。</p>
    </div>
  </section>
</body>
```

* `data-aos-delay`：延遲執行時間（毫秒）。
* `data-aos-duration`：單獨設定此元素的動畫持續時間。
* `data-aos-offset`：單獨設定此元素的觸發偏移量。

---

# 3. 常用屬性介紹

* `data-aos` = 呈現的效果  (fade、flip、zoom任君挑選，官網中有Animations可以挑)

* `data-aos-duration` = 出場持續時間  (單位是毫秒，所以1000代表1秒)

* `data-aos-delay` = 遲延秒數

* `data-aos-offset` = 卷軸滾到多少px才觸發

* `data-aos-easing` = 動畫執行速度  (官網中有Easing functions可以挑)

* `data-aos-once` = 觸發一次或上下滾動都觸發  (用true或false)

* `data-aos-anchor-placement` = 滾動到哪才觸發  (可用top-bottom、center-bottom、bottom-bottom等屬性值)
    
    * `top-bottom` 指的是「該元素的頂端」在瀏覽器的下方，也就是剛剛要出現時，觸發動畫。

    * `center-bottom` 指的是「該元素的中間」在瀏覽器的下方，觸發動畫。

    * `bottom-bottom` 指的是「該元素的底部」在瀏覽器的下方，觸發動畫。

    * 所以一般從上往下捲動網頁時，該元素的出現快慢是 `top-bottom` > `center-bottom` > `bottom-bottom`。

---

# 4. 自訂 CSS（可選）

AOS 自帶一些基礎動畫樣式，但你可以針對容器、排版、動畫前後狀態做自訂：

```css
/* 讓整個頁面更易閱讀 */
body {
  font-family: Arial, sans-serif;
  line-height: 1.6;
  margin: 0;
  padding: 0;
}

.hero {
  text-align: center;
  padding: 100px 20px;
  background: #f5f5f5;
}

.features {
  display: flex;
  gap: 20px;
  padding: 80px 20px;
  justify-content: center;
}

.feature-item {
  background: #fff;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0,0,0,0.1);
  padding: 20px;
  width: 200px;
  text-align: center;
}

/* 若要微調 AOS 動畫的初始與結束狀態，可覆寫以下類別 */
[data-aos] {
  opacity: 0;           /* 動畫前先隱藏 */
  transition-property: opacity, transform;
}

[data-aos].aos-animate {
  opacity: 1;           /* 動畫完成後顯示 */
}
```

---

# 5. 完整範例檔案

```html
<!DOCTYPE html>
<html lang="zh-Hant">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>AOS 範例</title>

  <!-- AOS 樣式 -->
  <link
    rel="stylesheet"
    href="https://cdn.jsdelivr.net/npm/aos@2.3.4/dist/aos.css"
  />

  <!-- 自訂樣式 -->
  <style>
    body {
      font-family: Arial, sans-serif;
      line-height: 1.6;
      margin: 0;
      padding: 0;
    }
    .hero {
      text-align: center;
      padding: 100px 20px;
      background: #f5f5f5;
    }
    .features {
      display: flex;
      gap: 20px;
      padding: 80px 20px;
      justify-content: center;
    }
    .feature-item {
      background: #fff;
      border-radius: 8px;
      box-shadow: 0 2px 8px rgba(0,0,0,0.1);
      padding: 20px;
      width: 200px;
      text-align: center;
    }
    [data-aos] {
      opacity: 0;
      transition-property: opacity, transform;
    }
    [data-aos].aos-animate {
      opacity: 1;
    }
  </style>
</head>
<body>

  <section class="hero">
    <h1 data-aos="fade-down">歡迎使用 AOS 動畫</h1>
    <p data-aos="fade-up" data-aos-delay="200">
      這段文字 200ms 延遲後出現
    </p>
    <button data-aos="zoom-in" data-aos-duration="1200">
      立即體驗
    </button>
  </section>

  <section class="features">
    <div class="feature-item" data-aos="flip-left">
      <h3>功能一</h3>
      <p>描述功能一的內容。</p>
    </div>
    <div class="feature-item" data-aos="flip-right" data-aos-offset="100">
      <h3>功能二</h3>
      <p>描述功能二的內容。</p>
    </div>
    <div class="feature-item" data-aos="fade-up" data-aos-delay="300">
      <h3>功能三</h3>
      <p>描述功能三的內容。</p>
    </div>
  </section>

  <!-- AOS 腳本 -->
  <script src="https://cdn.jsdelivr.net/npm/aos@2.3.4/dist/aos.js"></script>
  <script>
    AOS.init({
      duration: 800,
      offset: 120,
      once: true
    });
  </script>
</body>
</html>
```

---

### 核心要點

1. **引入**：載入 AOS 的 CSS/JS（CDN 或本地）。
2. **初始化**：呼叫 `AOS.init()` 並設定全局參數。
3. **標記**：在要做動畫的元素上加 `data-aos="動畫名稱"`，並可加上延遲、持續、偏移等自訂屬性。
4. **優化**：配合自訂 CSS，調整動畫前後的透明度、位移等，確保流暢且不過度。

---
