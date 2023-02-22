<template>
    <div>
        <h2>PropsTest.Vue</h2>
        {{ title }} / {{ contents }}<br/>
        {{ $props }}
    </div>
</template>

<script>
export default {
    setup (props) {
        console.log('전달받은 타이틀: ', props.title);
        // console.log($props.contents.value);
        return {}
    },
    props: {
        title:{
            type: String,
            required: true,
            default: '디폴트제목',
            validator: value => {
                return value != '제목'
            }
        },
        contents:{
            type: String,
            required: false,
            default: '디폴트내용',
        }
    },
}
</script>

<style lang="scss" scoped>

</style>