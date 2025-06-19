// composables/useSidebarExpand.ts
import { ref, onMounted } from 'vue';
import { useWindowSize } from '@vueuse/core';

export function useSidebarExpand(threshold = 930) {
  const isExpand = ref(false);
  const { width } = useWindowSize();

  onMounted(() => {
    isExpand.value = width.value > threshold;
  });

  return { isExpand };
}
