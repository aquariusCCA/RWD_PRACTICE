<template>
    <section class="tabs">
        <div class="container">
            <div id="tab-1" class="tab-item tab-border">
                <Icon icon="fa-solid:door-open" width="60" height="48" />
                <p class="hide-sm">Cancel at any time</p>
            </div>
            <div id="tab-2" class="tab-item">
                <Icon icon="ic:baseline-phone-iphone" width="60" height="48" />
                <p class="hide-sm">Watch anywhere</p>
            </div>
            <div id="tab-3" class="tab-item">
                <Icon icon="ic:baseline-discount" width="60" height="48" />
                <p class="hide-sm">Pick your price</p>
            </div>
        </div>
    </section>
</template>

<script setup lang="ts">
import { Icon } from '@iconify/vue';
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