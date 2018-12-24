<template>
<div>
    <guestTopbar/>
    <el-row>
        <el-col :span="24">
            <div class="information">
                <el-form ref="form" :model="form" label-width="80px">
                    <el-form-item label="评论标题">
                        <el-input v-model="form.title"></el-input>
                    </el-form-item>
                    <el-form-item label="评论内容">
                        <el-input type="textarea" v-model="form.content"></el-input>
                    </el-form-item>
                    <div class="image">
                        <el-upload
                            action="https://jsonplaceholder.typicode.com/posts/"
                            list-type="picture-card"
                            :on-preview="handlePictureCardPreview"
                            :on-remove="handleRemove">
                            <i class="el-icon-plus"></i>
                        </el-upload>
                    </div>
                    <el-form-item class="button">
                        <el-button type="primary" @click="onSubmit">提交评论</el-button>
                        <el-button>取消</el-button>
                    </el-form-item>
                </el-form>

            </div>
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
        form: {
          title: '',
          content: '',
        }
      }
    },
    methods: {
      onSubmit() {
        console.log('submit!');
      },
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
.information{
    margin-top: 20px;
    padding-top: 40px;
    padding-bottom: 20px;
    padding-left: 10px;
    margin-left: 200px;
    margin-right: 200px;
    font-size: 16px;
    
    background-color: #f3f1f1;
}
.button{
    margin-top: 20px;
    padding-top: 40px;
}
.image{
    padding-left: 10px;
    margin-left: 60px;
}
</style>