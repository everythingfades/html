<template>
    <table class="content">
        <thead>
            <tr>
                <th>序号</th>
                <th>姓名</th>
                <th>年纪</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(item, index) in data" :key="item.id">
                <th>{{index + 1}}</th>
                <th>{{item.name}}</th>
                <th>{{item.age}}</th>
                <th>
                    <slot :row="item"></slot>
                </th>
            </tr>
        </tbody>
        <tfoot>

        </tfoot>
    </table>
</template>

<script>
export default {
    props: {
        data: Array
    }
}
</script>

<style>
 