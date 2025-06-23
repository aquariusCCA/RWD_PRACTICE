> ✅ 目標：打造通用 `<Tabs>` + `<Tab>` 組件組合

# 📦 一、元件設計總覽

| 元件           | 功能                     |
| ------------ | ---------------------- |
| `<Tabs>`     | 包裝容器、集中管理 state        |
| `<Tab>`      | 單一標籤頁，透過 slot 呈現       |
| `<TabPanel>` | 顯示內容，根據 activeIndex 切換 |

---

# 🧱 二、元件設計與實作細節

### 🔹 Tabs.vue（控制狀態與提供上下文）

```vue
<!-- Tabs.vue -->
<template>
  <div class="tabs">
    <div class="tab-headers">
      <slot name="tabs" />
    </div>
    <div class="tab-panels">
      <slot />
    </div>
  </div>
</template>

<script setup lang="ts">
import { provide, ref } from 'vue'

const activeIndex = ref(0)
const setActiveIndex = (index: number) => (activeIndex.value = index)

provide('tabContext', {
  activeIndex,
  setActiveIndex,
})
</script>
```

---

### 🔹 Tab.vue（單個 tab 標籤）

```vue
<!-- Tab.vue -->
<template>
  <button
    class="tab"
    :class="{ active: isActive }"
    @click="setActiveIndex(index)"
  >
    <slot />
  </button>
</template>

<script setup lang="ts">
import { inject, computed } from 'vue'

const props = defineProps<{ index: number }>()

const context = inject('tabContext') as {
  activeIndex: Ref<number>
  setActiveIndex: (index: number) => void
}

const isActive = computed(() => context.activeIndex.value === props.index)
const setActiveIndex = context.setActiveIndex
</script>

<style scoped>
.tab {
  padding: 10px 20px;
  cursor: pointer;
}
.tab.active {
  border-bottom: 2px solid #000;
}
</style>
```

---

### 🔹 TabPanel.vue（內容面板）

```vue
<!-- TabPanel.vue -->
<template>
  <div v-show="isActive">
    <slot />
  </div>
</template>

<script setup lang="ts">
import { inject, computed } from 'vue'

const props = defineProps<{ index: number }>()

const context = inject('tabContext') as {
  activeIndex: Ref<number>
}

const isActive = computed(() => context.activeIndex.value === props.index)
</script>
```

---

# 🧪 三、使用範例：封裝後的使用方式

```vue
<!-- App.vue -->
<template>
  <Tabs>
    <template #tabs>
      <Tab :index="0">功能介紹</Tab>
      <Tab :index="1">方案費用</Tab>
      <Tab :index="2">常見問題</Tab>
    </template>

    <TabPanel :index="0">
      <p>這是功能介紹內容</p>
    </TabPanel>
    <TabPanel :index="1">
      <p>這是方案費用內容</p>
    </TabPanel>
    <TabPanel :index="2">
      <p>這是常見問題內容</p>
    </TabPanel>
  </Tabs>
</template>
```

---

## ✅ 四、特性與優點

| 特性      | 描述                                |
| ------- | --------------------------------- |
| ✅ 插槽控制  | Tab 結構靈活，不受限資料型別                  |
| ✅ 綁定上下文 | 使用 `provide/inject`，實現無 props 傳遞  |
| ✅ 高擴充性  | 日後可擴充支援動態 tab、router tab、圖示、自動切換等 |
| ✅ 組件解耦  | 每個元件職責單一，易維護                      |

---