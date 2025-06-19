<template>
    <div>
        <article class="article">
            <h2 class="article-title article-title--large">
                <a href="#" class="article-link">The First Signs of <mark class="mark mark--primary">Alcoholic
                        Liver</mark> Damage Are Not in the Liver</a>
            </h2>
            <div class="article-excerpt">
                <p>The combination of my father's death and my personal back ground lit a fire in me to know
                    more</p>
                <p>He was admitted to the hospital on June 24, 2016.</p>
            </div>
            <div class="article-author">
                <div class="article-author-img">
                    <img src="https://assets.codepen.io/285131/author-3.png" />
                </div>
                <div class="article-author-info">
                    <dl>
                        <dt>David Sherof</dt>
                        <dd>Reporter</dd>
                    </dl>
                </div>
            </div>
        </article>
        <article class="article">
            <h2 class="article-title article-title--medium">
                <a href="#" class="article-link">The Founder's Guide to Actually Understanding Users
                    Nowadays</a>
            </h2>
            <div class="article-creditation">
                <p>By Johnathan O'Connell, Andrew Van Dam, Aaron Gregg and Alyssa Fowers</p>
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

.article-excerpt,
.article-creditation  {
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