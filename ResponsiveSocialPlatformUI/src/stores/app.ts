import { ref, watch, computed, onMounted } from "vue";
import { defineStore } from "pinia";
import { useWindowSize } from "@vueuse/core";

export const useAppStore = defineStore("app", () => {
  // 是否展開左邊側欄
  const isLeftSidebarOpen = ref(true);

  // 是否展開右邊側欄
  const isRightSidebarOpen = ref(false);

  const { width } = useWindowSize();

  watch(
    width,
    (newWidth) => {
      isLeftSidebarOpen.value = newWidth >= 1024;
      isRightSidebarOpen.value = newWidth > 1024;
    },
    { immediate: true }
  );

  const isMobile = computed(() => width.value < 1024);
  const isTablet = computed(() => width.value >= 1024 && width.value < 1440);
  const isOverlayOpen = computed(() =>
    // 如果是手機，左邊側欄或右邊側欄開啟則顯示覆蓋層
    (isMobile.value && (isLeftSidebarOpen.value || isRightSidebarOpen.value)) ||
    // 如果是平板，右邊側欄開啟則顯示覆蓋層
    (isTablet.value && isRightSidebarOpen.value)
  );

  function toggleLeftSidebar() {
    isLeftSidebarOpen.value = !isLeftSidebarOpen.value;
  }

  function toggleRightSidebar() {
    isRightSidebarOpen.value = !isRightSidebarOpen.value;
  }

  return {
    isLeftSidebarOpen,
    isRightSidebarOpen,
    isMobile,
    isOverlayOpen,
    toggleLeftSidebar,
    toggleRightSidebar,
  };
});
