<template>
    <div class="header-right">
        <nav class="header-nav">
            <a href="#" class="header-link">Login</a>
            <a href="#" class="header-link header-link--button">Get 1 year for $50 USD</a>
        </nav>
        <button class="header-menu-button">Menu</button>
    </div>
</template>

<script lang="ts" setup></script>

<style scoped lang="scss">
.header-right {
    display: flex;
    align-items: center;
}

.header-nav {
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

.header-menu-button {
    margin-left: .75rem;
    border: 0;
    padding: 0;
    background-color: transparent;
    font: inherit;
    position: relative;
    padding-right: 30px;
    font-weight: 500;

    &:after,
    &:before {
        content: "";
        display: block;
        position: absolute;
        width: 20px;
        height: 2px;
        background-color: currentcolor;
        right: 0;
        top: 8px;
    }

    &:after {
        top: 16px;
        width: 12px;
        right: 8px;
    }
}
</style>