<template>
<el-container>
    <guestTopbar/>
    <el-row>
        <el-col :span="4">          
            <guestInforSidebar/>
        </el-col>
    </el-row>
    <el-footer>Footer</el-footer>
</el-container>
</template>

<script>
import guestTopbar from '@/components/guestTopbar.vue'
import guestInforSidebar from '@/components/guestInforSidebar.vue'
export default {
    components:{
        guestTopbar,
        guestInforSidebar
    }
}
</script>

