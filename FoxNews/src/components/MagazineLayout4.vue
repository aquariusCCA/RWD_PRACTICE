<template>
    <div>
        <article class="article">
            <h2 class="article-title article-title--medium">
                <a href="#" class="article-link">Traveller Visiting Ice Cave With Amazing Eye-Catching
                    Scenes</a>
            </h2>
            <div class="article-excerpt">
                <p>Slack has become indispensible for many businesses operation remotely during the pandemic.
                    Here's what the acquisition could mean for users...</p>
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
        <article class="article">
            <small class="article-category">
                <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="28"
                    height="22" viewBox="0 0 28 22">
                    <defs>
                        <clipPath id="clip-headphones">
                            <rect width="28" height="22" />
                        </clipPath>
                    </defs>
                    <g id="headphones" clip-path="url(#clip-headphones)">
                        <g id="Group_2" data-name="Group 2" transform="translate(-3680 -609)">
                            <path id="Subtraction_1" data-name="Subtraction 1"
                                d="M5,12H5A5.274,5.274,0,0,1,0,6.5,5.274,5.274,0,0,1,5,1V12Z"
                                transform="translate(3680 619)" />
                            <rect id="Rectangle_18" data-name="Rectangle 18" width="2" height="11"
                                transform="translate(3686 620)" />
                            <path id="Subtraction_5" data-name="Subtraction 5"
                                d="M1.243,12H.045C.015,11.67,0,11.334,0,11A11,11,0,0,1,18.778,3.222,10.925,10.925,0,0,1,22,11c0,.331-.015.667-.045,1h-1.2a14.108,14.108,0,0,0-2.685-6.241A8.982,8.982,0,0,0,11,2,8.982,8.982,0,0,0,3.929,5.759,14.109,14.109,0,0,0,1.243,12Z"
                                transform="translate(3683 609)" />
                            <path id="Subtraction_6" data-name="Subtraction 6"
                                d="M5,0H5A5.274,5.274,0,0,0,0,5.5,5.274,5.274,0,0,0,5,11V0Z"
                                transform="translate(3708 631) rotate(180)" />
                            <rect id="Rectangle_23" data-name="Rectangle 23" width="2" height="11"
                                transform="translate(3700 620)" />
                            <path id="Path_8" data-name="Path 8" d="M.156-.031,2.125-1.687,2,2H0Z"
                                transform="translate(3683 619)" />
                            <path id="Path_9" data-name="Path 9" d="M1.969-.031,0-1.687.125,2h2Z"
                                transform="translate(3702.875 619)" />
                        </g>
                    </g>
                </svg>
                <span>Post Reports / Podcast</span>
            </small>
            <h2 class="article-title article-title--medium">
                <a href="#" class="article-link">Things to Do After 6 P.M Will Enrich <mark
                        class="mark mark--tertiary">Your Life</mark></a>
            </h2>
            <div class="article-podcast-player">
                <button class="podcast-play-button">
                    <svg xmlns="http://www.w3.org/2000/svg" width="192" height="192" fill="#000000"
                        viewBox="0 0 256 256">
                        <rect width="256" height="256" fill="none"></rect>
                        <path
                            d="M232.3125,114.34375,88.34375,26.35937A15.99781,15.99781,0,0,0,64,40.00781V215.99219a16.00521,16.00521,0,0,0,24.34375,13.64843L232.3125,141.65625a16.00727,16.00727,0,0,0,0-27.3125Z">
                        </path>
                    </svg>
                </button>
                <div class="podcast-progression">
                </div>
                <span class="podcast-time">23:45</span>
            </div>
            <div class="article-podcast-info">
                Apple Podcasts, Google Podcasts, Stitcher
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

.article-link {
    color: inherit;
    text-decoration: none;
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

.article-category {
    font-weight: 500;
    margin-bottom: 1rem;
    display: block;

    svg {
        max-width: 1.5rem;
        margin-right: .5rem;
        vertical-align: middle;
    }
}

.article-podcast-player {
    display: flex;
    align-items: center;
    margin-bottom: 1rem;
    margin-top: 1.25rem;
}

.podcast-play-button {
    width: 2.25rem;
    height: 2.25rem;
    border-radius: 12px;
    border: 0;
    background-color: #000;
    margin-right: .5rem;

    svg {
        max-width: 1rem;
        max-height: 1rem;
        fill: #FFF;
    }
}

.podcast-progression {
    flex: 1;
    height: 8px;
    border-radius: 99em;
    background-color: #D9D4CD;
    background-image: linear-gradient(to right, #F99970 30%, #D9D4CD 30%, #D9D4CD 100%)
}

.podcast-time {
	font-weight: 500;
	font-size: 1.125rem;
	margin-left: .5rem;
}
</style>