<template>
    <div class="responsive-wrapper">
        <PageTitle />

        <div class="magazine-layout">
            <MagazineLayout1 class="magazine-column" />
            <MagazineLayout2 class="magazine-column" />
            <MagazineLayout3 class="magazine-column" />
            <MagazineLayout4 class="magazine-column" />
        </div>
    </div>
</template>

<script lang="ts" setup>
import PageTitle from './PageTitle.vue';
import MagazineLayout1 from './MagazineLayout1.vue';
import MagazineLayout2 from './MagazineLayout2.vue';
import MagazineLayout3 from './MagazineLayout3.vue';
import MagazineLayout4 from './MagazineLayout4.vue';
</script>

<style scoped lang="scss">
.responsive-wrapper {
    width: 95%;
    max-width: 1900px;
    margin-left: auto;
    margin-right: auto;
}

.magazine-layout {
    margin-top: 3rem;
    display: grid;
    grid-template-columns: repeat(5, 1fr);
    grid-row-gap: 2rem;
}

.magazine-column {
    padding: 0 1.5rem;
    grid-column: span 5;

    @media (min-width: 1200px) {
        grid-column: span 1;
        border-right: 1px solid #CCC;

        &:last-child {
            border-right: none;
        }
    }

    &:nth-child(2) {
        @media (min-width: 1200px) {
            grid-column: span 2;
        }
    }
}
</style>