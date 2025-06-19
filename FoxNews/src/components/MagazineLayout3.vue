<template>
    <div>
        <article class="article">
            <figure class="article-img">
                <img
                    src="https://images.unsplash.com/photo-1512521743077-a42eeaaa963c?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1351&q=80" />
            </figure>
            <h2 class="article-title article-title--small">
                <a href="#" class="article-link">To Become <mark class="mark mark--secondary">Happier</mark>,
                    Ask Yourself These Two Questions Every Night</a>
            </h2>
            <div class="article-creditation">
                <p>By Jonathan O'Connell</p>
            </div>
        </article>
        <article class="article">
            <figure class="article-img">
                <img
                    src="https://images.unsplash.com/photo-1569234817121-a2552baf4fd4?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80" />
            </figure>
            <h2 class="article-title article-title--small">
                <a href="#" class="article-link">10 Things I Stole From People Smarter Than Me</a>
            </h2>
            <div class="article-creditation">
                <p>By Jonathan O'Connell</p>
            </div>
        </article>
    </div>
</template>

<script lang="ts" setup></script>

<style scoped lang="scss">
.article {
    &+.article {
        padding-top: 2rem;
        margin-top: 2rem;
        border-top: 1px solid #ccc;
    }
}

.article-img {
    &+* {
        margin-top: 1rem;
    }
}

.article-title {
    font-family: "Fraunces", serif;
    font-weight: 900;
    line-height: 1.25;
    color: #000;

    &--large {
        font-size: 2rem;

        &+* {
            margin-top: 1.5rem;
        }
    }

    &--medium {
        font-size: 1.5rem;

        &+* {
            margin-top: 0.75rem;
        }
    }

    &--small {
        font-size: 1.25rem;

        &+* {
            margin-top: 0.75rem;
        }
    }
}

.article-creditation {
	font-size: 1.125rem;
	line-height: 1.4;
	p + p {
		margin-top: 1.5rem;
	}
}
</style>