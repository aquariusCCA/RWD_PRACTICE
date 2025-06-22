<template>
    <div>
        <div class="text-center">
            <p class="text-lg">
                Choose one plan and watch everything on Netflix.
            </p>
            <a href="#" class="btn btn-lg">Watch Free For 30 Days</a>
        </div>

        <table class="table">
            <thead>
                <tr>
                    <th></th>
                    <th>Basic</th>
                    <th>Standard</th>
                    <th>Premium</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Monthly price after free month ends on 6/19/19</td>
                    <td>$8.99</td>
                    <td>$12.99</td>
                    <td>$15.99</td>
                </tr>
                <tr>
                    <td>HD Available</td>
                    <td><i class="fas fa-times"></i></td>
                    <td><i class="fas fa-check"></i></td>
                    <td><i class="fas fa-check"></i></td>
                </tr>
                <tr>
                    <td>Ultra HD Available</td>
                    <td><i class="fas fa-times"></i></td>
                    <td><i class="fas fa-times"></i></td>
                    <td><i class="fas fa-check"></i></td>
                </tr>
                <tr>
                    <td>Screens you can watch on at the same time</td>
                    <td>1</td>
                    <td>2</td>
                    <td>4</td>
                </tr>
                <tr>
                    <td>Watch on your laptop, TV, phone and tablet</td>
                    <td><i class="fas fa-check"></i></td>
                    <td><i class="fas fa-check"></i></td>
                    <td><i class="fas fa-check"></i></td>
                </tr>
                <tr>
                    <td>Unlimited movies and TV shows</td>
                    <td><i class="fas fa-check"></i></td>
                    <td><i class="fas fa-check"></i></td>
                    <td><i class="fas fa-check"></i></td>
                </tr>
                <tr>
                    <td>Cancel anytime</td>
                    <td><i class="fas fa-check"></i></td>
                    <td><i class="fas fa-check"></i></td>
                    <td><i class="fas fa-check"></i></td>
                </tr>
                <tr>
                    <td>First month free</td>
                    <td><i class="fas fa-check"></i></td>
                    <td><i class="fas fa-check"></i></td>
                    <td><i class="fas fa-check"></i></td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script lang="ts" setup></script>

<style scoped lang="scss">
@use '@/styles/variables' as *;

.text-center {
    text-align: center;
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

.table {
    width: 100%;
    margin-top: 2rem;
    border-collapse: collapse;
    border-spacing: 0;
}

.table thead th {
    text-transform: uppercase;
    padding: 0.8rem;
}

.table tbody {
    display: table-row-group;
    vertical-align: middle;
    border-color: inherit;
}

.table tbody tr td {
    color: #999;
    padding: 0.8rem 1.2rem;
    text-align: center;
}

.table tbody tr td:first-child {
    text-align: left;
}

.table tbody tr:nth-child(odd) {
    background: #222;
}
</style>