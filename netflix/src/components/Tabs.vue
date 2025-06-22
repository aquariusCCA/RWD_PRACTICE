<template>
  <section class="tabs">
    <div class="container">
      <div
        class="tab-item"
        :class="{ 'tab-border': activeIndex === 0 }"
        :ref="el => collectTabItem(el as HTMLElement | null, 0)"
        @click="handleTabClick(0)"
      >
        <Icon icon="fa-solid:door-open" width="60" height="48" />
        <p class="hide-sm">Cancel at any time</p>
      </div>
      <div
        class="tab-item"
        :class="{ 'tab-border': activeIndex === 1 }"
        :ref="el => collectTabItem(el as HTMLElement | null, 1)"
        @click="handleTabClick(1)"
      >
        <Icon icon="ic:baseline-phone-iphone" width="60" height="48" />
        <p class="hide-sm">Watch anywhere</p>
      </div>
      <div
        class="tab-item"
        :class="{ 'tab-border': activeIndex === 2 }"
        :ref="el => collectTabItem(el as HTMLElement | null, 2)"
        @click="handleTabClick(2)"
      >
        <Icon icon="ic:baseline-discount" width="60" height="48" />
        <p class="hide-sm">Pick your price</p>
      </div>
    </div>
  </section>
</template>

<script setup lang="ts">
import { Icon } from '@iconify/vue'
import { ref } from 'vue'
import { useAppStore } from '@/stores/app'
import { storeToRefs } from 'pinia'

const appStore = useAppStore()
const { activeIndex } =  storeToRefs(appStore)
const { setActive } = appStore

// 使用陣列來儲存 tab DOM 元素
const tabItems = ref<HTMLElement[]>([])

// 收集 ref 或移除（el 為 null 表示已卸載）
function collectTabItem(el: HTMLElement | null, index: number) {
  if (el) {
    tabItems.value[index] = el
  } else {
    tabItems.value[index] = null!
  }
}

// 綁定 click 事件到每個 tab-item，點擊時添加或移除 tab-border 類別
function handleTabClick(index: number) {
  setActive(index)
}
</script>

<style scoped lang="scss">
@use '@/styles/variables' as *;

.tabs {
    background: $dark-color;
    padding-top: 1rem;
    border-bottom: 3px solid #3d3d3d;
    border-right: none;
}

.tabs .container {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    grid-gap: 1rem;
    align-items: center;
    justify-content: center;
    text-align: center;
}

.tab-item {
    padding: 1.5rem 0;
    color: #ccc;
    transition: all 0.3s ease;
    border-bottom: 4px solid transparent;

    &:hover {
        color: #fff;
        border-color: lighten($primary-color, 10%);
    }

    p {
        font-size: 1.2rem;
        margin-top: 0.5rem;
    }
}

.tab-border {
    border-bottom: $primary-color 4px solid;
}

.hide-sm {
    @media (max-width: 960px) {
        display: none;
    }
}
</style>