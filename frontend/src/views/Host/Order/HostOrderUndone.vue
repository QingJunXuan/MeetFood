<template>
<div>
    <hostTopbar/>
    <el-row>
        <el-col :span="4">          
            <hostReserveSidebar/>
        </el-col>

    </el-row>
</div>
</template>

<script>
import hostTopbar from '@/components/hostTopbar.vue'
import hostReserveSidebar from '@/components/hostReserveSidebar.vue'
export default {
    components:{
        hostTopbar,
       hostReserveSidebar
    }
}
</script>