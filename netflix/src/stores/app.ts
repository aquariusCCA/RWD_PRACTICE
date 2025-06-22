import { defineStore } from "pinia";
import { ref } from "vue";

export const useAppStore = defineStore("app", () => {
  const activeIndex = ref(0);

  function setActive(index: number) {
    activeIndex.value = index;
  }

  return { activeIndex, setActive };
});
