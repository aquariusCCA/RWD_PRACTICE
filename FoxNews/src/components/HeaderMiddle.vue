<template>
    <div class="header-middle">
        <a href="#" class="header-link">Call Us (348) 981 872</a>
        <span>/</span>
        <a href="#" class="header-link">hello@foxnews.com</a>
    </div>
</template>

<script lang="ts" setup></script>

<style scoped lang="scss">
.header-middle {
    display: none;

    @media (min-width: 1200px) {
        display: block;
    }
}

.header-link {
    color: #000;
    text-decoration: none;
    margin-left: .75rem;
    margin-right: .75rem;
    display: none;
    font-weight: 500;
    display: inline-block;

    &--button {
        background-color: #000;
        color: #fff;
        padding: .5rem 1.25rem;
    }
}
</style>