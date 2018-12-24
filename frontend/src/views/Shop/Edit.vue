<template>
<div>
    <guestTopbar/>
    <el-row>
        <el-col :span="8">
            <div class="title">
                <span>XXX西餐厅</span>
            </div>
            <div>
                <el-upload
                    list-type="picture-card"
                    action="''"
                    :http-request="upload"
                    :before-upload="beforeAvatarUpload">
                    <i class="el-icon-plus"></i>
                </el-upload>

                <el-button>上传封面</el-button>
            </div>
        </el-col>
        <el-col :span="8">
            <el-upload
                action="https://jsonplaceholder.typicode.com/posts/"
                list-type="picture-card"
                :on-preview="handlePictureCardPreview"
                :on-remove="handleRemove">
                <el-button size="small" type="primary">上传图片</el-button>
                <i class="el-icon-plus"></i>
            </el-upload>
            <el-dialog :visible.sync="dialogVisible">
                <img width="100%" :src="dialogImageUrl" alt="">
            </el-dialog>
        </el-col>
    </el-row>
</div>
</template>

<script>
import guestTopbar from '@/components/guestTopbar.vue'

export default {
    components:{
        guestTopbar,
    },
    data() {
      return {
        dialogImageUrl: '',
        dialogVisible: false
      };
    },
    methods: {
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
      }
    }
}
</script>

<style scoped>
template {
    height: 100%;
    width: 100%;
}
</style>