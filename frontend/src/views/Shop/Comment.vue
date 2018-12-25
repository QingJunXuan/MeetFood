<template>
<div>
    <guestTopbar/>
    <el-row>
        <el-col :span="24">
            <div class="information">
                <el-form ref="form" :model="form" label-width="80px">
                    <el-form-item label="Title">
                        <el-input v-model="form.title" placeholder="Please enter the title"></el-input>
                    </el-form-item>
                    <el-form-item label="Content">
                        <el-input type="textarea" v-model="form.content" placeholder="Please enter the comment content"></el-input>
                    </el-form-item>
                    <el-form-item label="Rate">
                          <el-rate v-model="form.rate" :colors="['#99A9BF', '#F7BA2A', '#FF9900']" class="rate"></el-rate>
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
                        <el-button type="primary" @click="onSubmit">Submit the Comment</el-button>
                        <el-button>Cancel</el-button>
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
          rate:0
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
.rate{
    margin-top: 10px;
}
</style>