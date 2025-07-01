# **為何在小螢幕要用 `display: block;` 而非 `display: flex;`？**

* **堆疊 vs. 水平排列**：`display: block` 預設每個子項目佔滿一整行，容易自然斷行堆疊，適合 off-canvas 抽屜式菜單的直式列表；若改成 `display: flex`，預設仍是水平排列，除非額外加上 `flex-direction: column`。

* **UX 慣例**：大部分行動裝置側邊菜單（drawer menu）都採直式列表，一行一個選項，使用者手指點擊才容易命中；若在手機上水平滑動多個 icon 反而不符合常見交互。

* **若您想用 Flex 也可**，建議直接寫：

    ```css
    @media (max-width:700px) {
    .main-nav ul.main-menu {
        display: flex;
        flex-direction: column;
        /* 其餘 off-canvas 樣式…… */
    }
    }
    ```

    這樣同樣能達成垂直堆疊，又保留未來可能的彈性對齊需求。