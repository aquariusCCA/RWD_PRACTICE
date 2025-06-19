<template>
    <div class="page-title">
        <h1>Latest Updates</h1>
    </div>
</template>

<script lang="ts" setup></script>

<style scoped lang="scss">
.page-title {
    padding-left: 1.5rem;
    padding-right: 1.5rem;
    display: flex;
    justify-content: center;

    h1 {
        font-size: 1.75rem;
        font-weight: 700;
        color: #000;
        text-align: center;
        position: relative;


        &:after {
            content: "";
            display: block;
            position: absolute;
            width: 100%;
            bottom: -3px;
            height: 2px;
            background-color: currentcolor;
        }
    }
}
</style>