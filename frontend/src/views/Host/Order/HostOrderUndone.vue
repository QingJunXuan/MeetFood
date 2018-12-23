<template>
<div>
    <guestTopbar/>
    <el-row>
        <el-col :span="4">          
            <hostReserveSidebar/>
        </el-col>

    </el-row>
</div>
</template>

<script>
import guestTopbar from '@/components/guestTopbar.vue'
import hostReserveSidebar from '@/components/hostReserveSidebar.vue'
export default {
    components:{
        guestTopbar,
       hostReserveSidebar
    }
}
</script>