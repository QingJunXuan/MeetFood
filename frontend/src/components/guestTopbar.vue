<template>
<el-row>
    <div class="topbar">  
        <el-col :span="3"><p></p></el-col>    
        <el-col :span="18">
            <el-menu :default-active="activeIndex"
                    class="el-menu-demo"
                    mode="horizontal"
                    @select="handleSelect"
                    
                    background-color="#181818"
                    text-color="#fff"
                    active-text-color="#fff">
                <el-menu-item index="1" >HOME</el-menu-item>
                <el-menu-item index="2" >DISCOVERY QUEUES</el-menu-item> 
                <el-menu-item index="3" >YOUR ORDER</el-menu-item>  
                <el-menu-item index="4" >YOUR MEETFOOD.COM</el-menu-item>               
            </el-menu>
        </el-col>  
        <el-col :span="3"></el-col>         
    </div>
</el-row>
</template>

<script>
    
</script>


<style scoped>
.topbar{
    background-color: #181818;
    height: 60px;
    border-radius: 4px 4px 0 0;
}
.el-menu{
    text-align: center
}
.el-menu-item{
    width:230px;

}
.el-menu-item:hover{
    background-color: rgb(0, 0, 0) !important;
}
.el-menu-item.is-active{
    background-color: #F3C402 !important;
    border: 0px;
}

</style>

