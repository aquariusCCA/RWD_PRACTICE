# 一、`linear-gradient()` 基本語法

```css
background-image: linear-gradient(
  [方向],
  [顏色1] [位置1],
  [顏色2] [位置2],
  …
);
```

* **方向（Direction）**
  決定漸層的延伸方向。可以用角度（如 `45deg`）或用關鍵字 `to top`、`to bottom right` 等。
* **顏色（Color Stops）**
  每個顏色可以指定一或兩個參數：

  * 單純顏色（`#F99970`）
  * 顏色加位置（`#F99970 30%`），表示這個顏色在漸層的 **30%** 處到達完整不透明。

### 顏色停止點（Color Stops）的作用

* 如果只給兩個顏色，不指定百分比，預設第一個在 0%、第二個在 100%，中間平滑過渡。
* 當你對兩個相鄰的停止點指定同樣的位置時（例如 `#F99970 30%` 與 `#D9D4CD 30%`），就會在該位置發生 **銳利的斷層**，從一色直接跳到另一色。

---

# 二、拆解範例 CSS

```css
background-image:
  linear-gradient(
    to right,        /* 從左到右 */
    #F99970 30%,     /* 左側 0–30% 都是 #F99970 */
    #D9D4CD 30%,     /* 從 30% 開始立刻切換到 #D9D4CD */
    #D9D4CD 100%     /* 一直到 100% 都是 #D9D4CD */
  );
```

1. **`to right`**：漸層方向從左往右。
2. **`#F99970 30%`**：在漸層軸上，從 0% 開始到 30% 的範圍都填滿這個顏色。
3. **`#D9D4CD 30%`**：在 30% 的位置立刻切換顏色，之後保持這個顏色直到 100%。
4. 整體效果：左邊 30% 是暖橘色，中間無過渡，馬上變成灰白色，並持續到最右邊。

---

# 三、實際範例

下面用幾個簡單的 HTML+CSS 範例，示範不同的用法。你可以複製到本地檔案或 CodePen 上試試看。

### 範例 1：平滑兩色色塊

```html
<div class="smooth-gradient">平滑漸層</div>

<style>
  .smooth-gradient {
    width: 300px; height: 100px;
    background-image: linear-gradient(to right, #FF7F50, #1E90FF);
    /* 預設 0→100% 平滑過渡 */
  }
</style>
```

### 範例 2：帶銳利斷層的兩色色塊

```html
<div class="sharp-break">銳利分隔</div>

<style>
  .sharp-break {
    width: 300px; height: 100px;
    background-image:
      linear-gradient(
        to right,
        #F99970 30%,
        #D9D4CD 30%,
        #D9D4CD 100%
      );
  }
</style>
```

### 範例 3：三色色塊（中間帶過渡）

```html
<div class="three-color">三色混合</div>

<style>
  .three-color {
    width: 300px; height: 100px;
    background-image:
      linear-gradient(
        to right,
        #FF7F50 0%,
        #FFD700 50%,   /* 中間帶金色過渡 */
        #1E90FF 100%
      );
  }
</style>
```

### 範例 4：對角線 & 重複漸層

```html
<div class="diagonal">對角線漸層</div>
<div class="repeat">重複漸層</div>

<style>
  .diagonal {
    width: 300px; height: 100px;
    background-image:
      linear-gradient(45deg, #FF7F50, #1E90FF);
  }
  .repeat {
    width: 300px; height: 100px;
    background-image:
      repeating-linear-gradient(
        to right,
        #F99970 0 20%,
        #D9D4CD 20% 40%
      );
    /* 每 20% 重複一次兩色色塊 */
  }
</style>
```

---

# 四、何時使用銳利斷層？

* **進度條**：顯示已完成 vs 未完成的部分。
* **分隔色塊**：在同一容器內區分兩種狀態。
* **帶狀標籤**：如「New」「Sale」標示。

而如果你想要逐漸過渡，就不應該在同一位置同時設置兩個不同顏色的停止點，而是給它們不同的百分比（例如 `#F99970 30%, #D9D4CD 31%`）。

---

### 小結

1. `linear-gradient()` 接受方向 + 多組「顏色 + 停止位置」
2. 同一位置重複不同顏色 → **銳利分隔**
3. 不同位置 → **平滑過渡**
4. 可結合 `repeating-linear-gradient()`、角度等做更多變化

希望這些解釋與範例能幫助你理解漸層的工作機制，並能在專案中靈活運用！如果還有其他疑問，或想看更多進階案例（例如不同方向、透明度動畫等），隨時告訴我～
