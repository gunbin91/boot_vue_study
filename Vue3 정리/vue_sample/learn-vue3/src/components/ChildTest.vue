<template>
    <div class="card">
        <div class="card-header">Child_Header</div>
        <div class="card-body">
            <DeepChildTest/>
        </div>
    </div>
</template>

<script>
import DeepChildTest from '@/components/DeepChildTest.vue'
export default {
    setup () {
        

        return {}
    },
    components:{DeepChildTest}
}
</script>

<style lang="scss" scoped>

</style>