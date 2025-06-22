<template>
    <div>
        <div class="tab-2-content-top">
            <p class="text-lg">
                Watch TV shows and movies anytime, anywhere — personalized for
                you.
            </p>
            <a href="#" class="btn btn-lg">Watch Free For 30 Days</a>
        </div>
        <div class="tab-2-content-bottom">
            <div>
                <img src="https://i.ibb.co/DpdN7Gn/tab-content-2-1.png" alt="" />
                <p class="text-md">
                    Watch on your TV
                </p>
                <p class="text-dark">
                    Smart TVs, PlayStation, Xbox, Chromecast, Apple TV, Blu-ray
                    players and more.
                </p>
            </div>
            <div>
                <img src="https://i.ibb.co/R3r1SPX/tab-content-2-2.png" alt="" />
                <p class="text-md">
                    Watch instantly or download for later
                </p>
                <p class="text-dark">
                    Available on phone and tablet, wherever you go.
                </p>
            </div>
            <div>
                <img src="https://i.ibb.co/gDhnwWn/tab-content-2-3.png" alt="" />
                <p class="text-md">
                    Use any computer
                </p>
                <p class="text-dark">
                    Watch right on Netflix.com.
                </p>
            </div>
        </div>
    </div>
</template>

<script lang="ts" setup></script>

<style scoped lang="scss">
@use '@/styles/variables' as *;

.tab-2-content-top {
    display: grid;
    grid-template-columns: 2fr 1fr;
    grid-gap: 1rem;
    justify-content: center;
    align-items: center;

    @media (max-width: 700px) {
        display: block;
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


.tab-2-content-bottom {
    margin-top: 2rem;
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    grid-gap: 2rem;
    text-align: center;

    @media (max-width: 700px) {
        margin-top: 2rem;
        display: grid;
        grid-template-columns: 1fr;
        grid-gap: 2rem;
        text-align: center;
    }
}

.text-md {
	margin-bottom: 1.5rem;
	font-size: 1.2rem;

    @media (max-width: 960px) {
        margin-bottom: 1rem;
		font-size: 1.2rem;
    }
}

.text-dark {
	color: #999;
}
</style>