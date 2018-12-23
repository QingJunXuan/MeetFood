<template>
<div>
    <guestTopbar/>
    <el-row>
        <el-col :span="4">          
            <guestReserveSidebar/>
        </el-col>

    </el-row>
</div>
</template>

<script>
import guestTopbar from '@/components/guestTopbar.vue'
import guestReserveSidebar from '@/components/guestReserveSidebar.vue'
export default {
    components:{
        guestTopbar,
        guestReserveSidebar
    }
}
</script>