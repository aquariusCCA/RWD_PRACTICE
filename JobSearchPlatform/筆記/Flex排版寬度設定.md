**源碼如下：**

```html
<div class="search-menu">
    <div class="search-bar">
        <!-- 省略... -->
    </div>
    <div class="search-location">
        <!-- 省略... -->
    </div>
    <div class="search-job">
        <!-- 省略... -->
    </div>
    <div class="search-salary">
       <!-- 省略... -->
    </div>
    <button class="search-button">Find Job</button>
</div>
```

```scss 
.search-menu {
    width: 100%;
    height: 56px;
    display: flex;
    align-items: center;
    padding-left: 20px;
    border-radius: 8px;
    background-color: var(--header-bg-color);
    white-space: nowrap;
}


.search-bar {
    width: 100%;
    height: 55px;
    position: relative;
}


.search-location,
.search-job,
.search-salary {
    display: flex;
    align-items: center;
    padding: 0 25px;
    width: 50%;
    height: 100%;
    font-size: 14px;
    font-weight: 500;
}
```

在使用 Flex 排版時，你會發現**Flex 容器本身只定義了佈局模型**，但**子項目的最終寬度仍取決於它們的預設 `flex` 屬性（即 `flex: 0 1 auto`）和任何明確設定的尺寸**。簡而言之：

1. **預設行為是「按內容尺寸排列，必要時才縮小」**

   * Flex 預設：`flex-grow: 0; flex-shrink: 1; flex-basis: auto`。
   * `flex-basis: auto` 會以內容或 `width`（如果有設定）作為基準。
   * 沒有設定 `width`，子項目只會佔用它內容所需的最小空間，並在空間不足時才會縮小。

2. **使用 `width`（或更合適的 `flex-basis`）是為了明確指定基準寬度**

   * 當你想讓某個區塊佔滿「剩餘空間」或「父容器的某個百分比」時，一定要透過 `width`（或 `flex: 0 0 50%`、`flex-basis: 50%`）來定義。
   * 例如：

     ```scss
     .search-bar { width: 100%; /* 先定出基準，才好讓它佔滿剩餘空間 */ }
     .search-location { width: 50%; /* 明確希望佔父容器一半 */ }
     ```
   * 否則，項目只會依內容寬度排開，不會自動拉伸或平分空間。

3. **更推薦的寫法：直接用 Flex 屬性代替固定寬度**
   如果你的目標只是「等分」或「剩餘空間自動分配」，不妨改成：

   ```scss
   .search-bar {
     flex: 1;            /* 佔據剩餘全部空間 */
     position: relative;
     height: 55px;
   }

   .search-location,
   .search-job,
   .search-salary {
     flex: 0 0 25%;      /* 各佔 25% 或依你需求調整 */
     display: flex;
     align-items: center;
     padding: 0 25px;
     height: 100%;
     font-size: 14px;
     font-weight: 500;
   }
   ```

   * `flex: 1` 等同於 `flex: 1 1 0%`，表示可成長、可縮小，基準為 0；
   * `flex: 0 0 25%` 表示不成長、不縮小，基準為 25%。

---

**結論**：Flex 佈局只是工具，而預設的 `flex-basis: auto` 不會自動分配空間給子項目。若要讓子項目填滿剩餘空間或佔據特定比例，**仍然需要透過 `width` 或 `flex` 屬性來明確設定基準寬度**；若想更直觀地平分或自動調整，則應該使用 `flex: grow shrink basis` 而非固定 `width`。
