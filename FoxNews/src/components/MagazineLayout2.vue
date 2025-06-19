<template>
    <div>
        <article class="article">
            <figure class="article-img">
                <img
                    src="https://images.unsplash.com/photo-1484807352052-23338990c6c6?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80" />
            </figure>
            <h2 class="article-title article-title--medium">
                <a href="#" class="article-link">How 7 Lines of Code Turned Into a $36 Billion Empire</a>
            </h2>
            <div class="article-excerpt">
                <p>Yeah, it's safe to say these guys have a great sense of humor, which isn't really suprising
                    for us considering their seemingly absurd solution to online payments. Instead of chasing
                    1000-hour programming contracts to build clunky payments solutions for each individual
                    client, the Collison...</p>
            </div>
            <div class="article-author">
                <div class="article-author-img">
                    <img src="https://assets.codepen.io/285131/author-2.png" />
                </div>
                <div class="article-author-info">
                    <dl>
                        <dt>James Robert</dt>
                        <dd>Editor</dd>
                    </dl>
                </div>
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


.article-link {
    color: inherit;
    text-decoration: none;
}

.article-excerpt {
    font-size: 1.125rem;
    line-height: 1.4;

    p+p {
        margin-top: 1.5rem;
    }
}

.article-author {
    display: flex;
    flex-wrap: wrap;
    margin-top: 1.5rem;
}

.article-author-img {
    width: 3rem;
    height: 3rem;
    border-radius: 12px;
    background-color: #323232;
    overflow: hidden;
    background-blend-mode: multiply;

    &+.article-author-info {
        margin-left: 0.5rem;
    }
}

.article-author-info {
    line-height: 1.375;

    dl {
        margin-top: 0.25em;
    }

    dt {
        font-weight: 600;
    }

    dd {
        font-size: 0.875em;
    }
}
</style>