# **為何把 `transition` 放在 media query 內？**
* **限定生效範圍**：目前的 `.main-nav ul.main-menu` 預設並未用到 `transform`，只有在寬度 ≤ 700 px 的斷點下才會啟用 off-canvas 功能（`transform: translateX(-500px)`）。把 `transition` 放在該斷點裡，就能保證只有在「手機／小螢幕打開／關閉菜單」時才有平滑過渡，不會影響到桌面版或其他斷點下的行為。

* **避免多餘影響**：若您把 `transition` 寫在基礎樣式（非 media query）裡，一旦該元素在其他斷點被改動（例如 margin、padding、甚至某些 JS 動態變更），也會觸發不必要的動畫效果。

* **若真要放在基礎樣式**，建議至少限定屬性：

    ```css
    .main-nav ul.main-menu {
        /* 只對 transform 生效 */
        transition: transform 0.5s ease-in-out;
    }
    @media (max-width:700px) {
        /* 手機版才改用 transform */
        transform: translateX(-500px);
    }
    ```

    這樣也能達到您希望「不同斷點有不同效果」的目的——在桌面版其實就不會呼叫到 `transform`，也不會有動畫。