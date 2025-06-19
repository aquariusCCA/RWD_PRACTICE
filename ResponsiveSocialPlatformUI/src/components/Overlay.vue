<template>
    <div 
        class="overlay" 
        :class="{ 'active': isOverlayOpen }"
        @click="toggleOverlay"
    >
    </div>
</template>

<script lang="ts" setup>
import { useAppStore } from '@/stores/app';
import { storeToRefs } from 'pinia';

const appStore = useAppStore();
const {
  isOverlayOpen,
  isLeftSidebarOpen,
  isRightSidebarOpen,
  isMobile,
} = storeToRefs(appStore);
const { toggleLeftSidebar, toggleRightSidebar } = appStore;

const toggleOverlay = () => {
    if (isLeftSidebarOpen.value && isMobile.value) {
        toggleLeftSidebar();
    }
    if (isRightSidebarOpen.value) {
        toggleRightSidebar();
    }
};
</script>

<style scoped lang="scss">
.overlay {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(36, 39, 59, 0.8);
    transform: scale(1.1);
    opacity: 0;
    pointer-events: none;
    transition: transform 0.3s ease, opacity 0.3s ease;

    &.active {
        transform: scale(1);
        opacity: 1;
        pointer-events: auto;
        z-index: 3;
    }
}
</style>