<template>
    <section class="tab-content">
        <div class="container">
            <!-- Tab Content 1 -->
            <div 
                class="tab-content-item"
                :class="{ 'show': activeIndex === 0 }"
            >
                <TabContent1 />
            </div>

            <!-- Tab Content 2 -->
            <div 
                class="tab-content-item"
                :class="{ 'show': activeIndex === 1 }"
            >
                 <TabContent2 />
            </div>

            <!-- Tab Content 3 -->
            <div 
                class="tab-content-item" 
                :class="{ 'show': activeIndex === 2 }"
            >
                <TabContent3 /> 
            </div>
        </div>
    </section>
</template>

<script lang="ts" setup>
import { useAppStore } from '@/stores/app'
import { storeToRefs } from 'pinia'
import TabContent1 from './TabContent1.vue'
import TabContent2 from './TabContent2.vue'
import TabContent3 from './TabContent3.vue'

const appStore = useAppStore()
const { activeIndex } = storeToRefs(appStore)
</script>

<style scoped lang="scss">
.tab-content {
    padding: 3rem 0;
    background: #000;
    color: #fff;
}

.container {
    max-width: 70%;
    margin: auto;
    overflow: hidden;
    padding: 0 2rem;
}

.tab-content-item {
    display: none;
    opacity: 0;
}

.show {
    display: block !important;
    opacity: 1 !important;
    transition: all 1000 ease-in;
}
</style>