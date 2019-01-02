<template>
<div>
    <guestTopbar/>
    <el-row>
        <el-col :span="24">
            <div class="information">
                <el-form ref="form" :model="form" label-width="80px">
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
import axios from 'axios'
export default {
   components:{
        guestTopbar,
    },
    
    data() {
      return {
        form: {
          content: '',
          rate:0
        }
      }
    },
    methods: {
      onSubmit() {
        let that = this;
        let param = new URLSearchParams();
        param.append('dining_id',1);
        param.append('guest_id',1);
        param.append('text',this.form.content);
        param.append('score',this.form.rate);

        axios({
            method:'post',
            url:'http://172.20.10.4:8080/comment/addComment/text',
            data: param
        })
        .then(function(response){
            that.$message('成功')
        })
        .catch(function(error){
            console.log(error)
            this.errored = true
        })
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