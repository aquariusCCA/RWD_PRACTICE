<template>
	<header class="showcase">
		<div class="showcase-top">
			<img src="https://i.ibb.co/r5krrdz/logo.png" alt="" />
			<a href="#" class="btn btn-rounded">Sign In</a>
		</div>
		<div class="showcase-content">
			<h1>See what's next</h1>
			<p>Watch anywhere. Cancel Anytime</p>
			<a href="#" class="btn btn-xl">Watch Free For 30 Days <i class="fas fa-chevron-right btn-icon"></i></a>
		</div>
	</header>
</template>

<script lang="ts" setup></script>

<style scoped lang="scss">
@use '@/styles/variables' as *;

.showcase {
	width: 100%;
	height: 93vh;
	position: relative;
	background: url('https://i.ibb.co/vXqDmnh/background.jpg') no-repeat center center/cover;

	@media (max-width: 960px) {
		height: 70vh;
	}
}

.showcase-top {
	position: relative;
	z-index: 2;
	height: 90px;
}

.showcase-top img {
	width: 170px;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	margin-left: 0;

	@media (max-width: 960px) {
		top: 30%;
		left: 5%;
		transform: translate(0);
	}
}

.showcase-top a {
	position: absolute;
	top: 50%;
	right: 0;
	transform: translate(-50%, -50%);
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

.btn-xl {
	font-size: 2rem;
	padding: 1.5rem 2.1rem;
	text-transform: uppercase;

	@media (max-width: 960px) {
		font-size: 1.5rem;
		padding: 1.4rem 2rem;
		text-transform: uppercase;
	}

	@media (max-width: 700px) {
		font-size: 1rem;
		padding: 1.2rem 1.6rem;
		text-transform: uppercase;
	}
}

.btn:hover {
	opacity: 0.9;
}

.btn-rounded {
	border-radius: 5px;
}

.showcase-content {
	position: relative;
	z-index: 2;
	width: 65%;
	margin: auto;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	text-align: center;
	margin-top: 9rem;

	@media(max-height: 600px) {
		margin-top: 3rem;
	}
}

.showcase-content h1 {
	font-weight: 700;
	font-size: 5.2rem;
	line-height: 1.1;
	margin: 0 0 2rem;

	@media (max-width: 960px) {
		font-size: 3.7rem;
		line-height: 1;
	}

	@media (max-width: 700px) {
		font-size: 2.5rem;
		line-height: 1;
	}
}

.showcase-content p {
	text-transform: uppercase;
	color: #fff;
	font-weight: 400;
	font-size: 1.9rem;
	line-height: 1.25;
	margin: 0 0 2rem;

	@media (max-width: 960px) {
		font-size: 1.5rem;
	}

	@media (max-width: 700px) {
		font-size: 1rem;
	}
}

.showcase::after {
	content: '';
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: 1;
	background: rgba(0, 0, 0, 0.6);
	box-shadow: inset 120px 100px 250px #000000, inset -120px -100px 250px #000000;

	@media (max-width: 960px) {
		background: rgba(0, 0, 0, 0.6);
		box-shadow: inset 80px 80px 150px #000000, inset -80px -80px 150px #000000;
	}
}
</style>