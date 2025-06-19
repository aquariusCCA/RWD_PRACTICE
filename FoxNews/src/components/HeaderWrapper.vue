<template>
    <div class="header responsive-wrapper">
        <HeaderLeft />
        <HeaderMiddle />
        <HeaderRight />
    </div>
</template>

<script lang="ts" setup>
import HeaderLeft from './HeaderLeft.vue';
import HeaderMiddle from './HeaderMiddle.vue';
import HeaderRight from './HeaderRight.vue';
</script>

<style scoped lang="scss">
.header {
    display: flex;
	justify-content: space-between;
	align-items: center;
	padding-right: 1.5rem;
	padding-left: 1.5rem;
	padding-top: 3rem;
	padding-bottom: 4rem;
}

.responsive-wrapper {
	width: 95%;
	max-width: 1900px;
	margin-left: auto;
	margin-right: auto;
}
</style>