<template>
    <div class="tab-1-content-inner">
        <div>
            <p class="text-lg">
                If you decide Netflix isn't for you - no problem. No commitment.
                Cancel online anytime.
            </p>
            <a href="#" class="btn btn-lg">Watch Free For 30 Days</a>
        </div>
        <img src="https://i.ibb.co/J2xDJV7/tab-content-1.png" alt="" />
    </div>
</template>

<script lang="ts" setup></script>

<style scoped lang="scss">
@use '@/styles/variables' as *;

.tab-1-content-inner {
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    grid-gap: 2rem;
    align-items: center;
    justify-content: center;

    @media (max-width: 700px) {
        grid-template-columns: 1fr;
        text-align: center;
    }
}

.text-lg {
    font-size: 1.8rem;
    margin-bottom: 1rem;

    @media (max-width: 960px) {
        font-size: 1.3rem;
        margin-bottom: 1rem;
    }
}

.btn {
	display: inline-block;
	background: $primary-color;
	color: #fff;
	padding: 0.4rem 1.3rem;
	font-size: 1rem;
	text-align: center;
	border: none;
	cursor: pointer;
	margin-right: 0.5rem;
	transition: opacity 0.2s ease-in;
	outline: none;
	box-shadow: 0 1px 0 rgba(0, 0, 0, 0.45);
	border-radius: 2px;
}

.btn:hover {
	opacity: 0.9;
}

.btn-lg {
	font-size: 1rem;
	padding: 0.8rem 1.3rem;
	text-transform: uppercase;
}
</style>