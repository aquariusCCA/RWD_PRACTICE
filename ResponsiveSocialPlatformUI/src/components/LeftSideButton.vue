<template>
  <div class="left-side-button" @click="toggleLeftSidebar">
    <!-- 展開圖示（點擊收起） -->
    <svg
      v-if="isLeftSidebarOpen"
      viewBox="0 0 24 24"
      stroke="currentColor"
      stroke-width="2"
      fill="none"
      stroke-linecap="round"
      stroke-linejoin="round"
    >
      <path d="M19 12H5M12 19l-7-7 7-7" />
    </svg>

    <!-- 收起圖示（點擊展開） -->
    <svg
      v-else
      viewBox="0 0 24 24"
      stroke="currentColor"
      stroke-width="2"
      fill="none"
      stroke-linecap="round"
      stroke-linejoin="round"
    >
      <line x1="3" y1="12" x2="21" y2="12" />
      <line x1="3" y1="6" x2="21" y2="6" />
      <line x1="3" y1="18" x2="21" y2="18" />
    </svg>
  </div>
</template>

<script lang="ts" setup>
import { useAppStore } from '@/stores/app';
import { storeToRefs } from 'pinia';

const appStore = useAppStore();
const { isLeftSidebarOpen } = storeToRefs(appStore);
const { toggleLeftSidebar } = appStore;
</script>

<style scoped lang="scss">
.left-side-button {
  display: none;
}

@media screen and (max-width: 930px) {
  .left-side-button {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 60px;
    padding: 10px;
    border-bottom: 1px solid #272a3a;
    background-color: rgba(39, 42, 58, 0.5);
    color: #fff;
    cursor: pointer;
  }

  .left-side-button svg {
    width: 24px;
    height: 24px;
    transition: opacity 0.2s;
  }
}
</style>