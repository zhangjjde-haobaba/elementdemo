<template>
    <div>
        <el-row>
            <el-button>默认按钮</el-button>
            <el-button type="primary" size="medium">主要按钮</el-button>
            <el-button type="success" size="small">成功按钮</el-button>
            <el-button type="info" size="mini">信息按钮</el-button>
            <el-button type="warning">警告按钮</el-button>
            <el-button type="danger">危险按钮</el-button>
        </el-row>
        <el-row>
            <el-button round>圆角按钮</el-button>
            <el-button type="primary" round circle icon="el-icon-eleme" disabled></el-button>
            <el-button type="primary" round circle icon="el-icon-eleme" @click="test()" :loading="loading"></el-button>

        </el-row>
        <el-link icon="el-icon-phone" href="https://element.eleme.cn/#/zh-CN/component/icon">Element UI</el-link>
        <el-radio v-model="radio" label="1" @change="change">备选项1</el-radio>
        <el-radio v-model="radio" label="2" @change="change">备选项2</el-radio>
        <br/>
        <el-checkbox :indeterminate="isIndeterminate" v-model="checkAll" @change="handleCheckAllChange">全选</el-checkbox>
        <div style="margin: 15px 0;"></div>
        <el-checkbox-group v-model="checkedCities" @change="handleCheckedCitiesChange">
            <el-checkbox v-for="city in cities" :label="city" :key="city">{{city}}</el-checkbox>
        </el-checkbox-group>
        <el-input v-model="input" placeholder="请输入内容"  prefix-icon="el-icon-user-solid" maxlength="10" show-word-limit></el-input>
        <el-button type="primary" @click="click">主要按钮</el-button>
        <br/>
        <el-select v-model="value" placeholder="请选择" @change="changeTwo">
            <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value"
                    :disabled="item.disabled"
            >
            </el-option>
        </el-select>
        <br/>
        <el-switch
                v-model="checked"
                active-color="#13ce66"
                active-text="上架"
                inactive-color="#ff4949"
                inactive-text="下架"
                @change="changeThree"
        >
        </el-switch>
        <br/>
        <el-upload
                class="upload-demo"
                drag
                action="http://localhost:8181/excel/import"
                multiple>
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
            <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
        </el-upload>
    </div>
</template>

<script>
    const cityOptions = ['上海', '北京', '广州', '深圳'];
    export default {
        name: "Test",
        methods:{
            click(){
                this.input = "abc"
            },
            test(){
                this.loading = true;
                setTimeout(()=>{
                    this.loading = false;
                },3000)
            },
            change(){
                console.log("当前radio值:"+this.radio)
            },
            changeTwo(){
                console.log("当前选择的是:"+this.value)
            },
            changeThree(){
                console.log("当前开关状态:"+this.checked)
            },
            handleCheckAllChange(val) {
                this.checkedCities = val ? cityOptions : [];
                this.isIndeterminate = false;
            },
            handleCheckedCitiesChange(value) {
                //当前选中城市的数量
                let checkedCount = value.length;
                this.checkAll = checkedCount === this.cities.length;
                this.isIndeterminate = checkedCount > 0 && checkedCount < this.cities.length;
            }
        },
        data(){
            return{
               loading:false,
                radio:'1',
                checkAll: false,
                checkedCities: ['上海', '北京'],
                cities: cityOptions,
                isIndeterminate: true,
                input: '',
                options: [{
                    value: '选项1',
                    label: '黄金糕'
                }, {
                    value: '选项2',
                    label: '双皮奶'
                }, {
                    value: '选项3',
                    label: '蚵仔煎',
                    disabled:true
                }, {
                    value: '选项4',
                    label: '龙须面'
                }, {
                    value: '选项5',
                    label: '北京烤鸭'
                }],
                value: '',
                checked:true
            }
        }
    }
</script>

<style scoped>

</style>