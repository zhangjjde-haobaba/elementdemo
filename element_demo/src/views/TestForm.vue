<template>
    <div style="width: 800px;">
        <el-form :model="ruleForm"  ref="ruleForm" label-width="100px" class="demo-ruleForm">
<!--            <el-form-item label="活动名称" prop="name">-->
<!--                <el-input v-model="ruleForm.name"></el-input>-->
<!--            </el-form-item>-->
<!--            <el-form-item label="邮箱" prop="email">-->
<!--                <el-input v-model="ruleForm.email"></el-input>-->
<!--            </el-form-item>-->
            <el-form-item label="年龄" prop="age" :rules="[
            { required: true, message: '年龄不能为空'},
            { type: 'number', message: '年龄要是整数类型'}
            ]">
                <el-input v-model.numer="ruleForm.age"></el-input>
            </el-form-item>
<!--            <el-form-item label="活动区域" prop="region">-->
<!--                <el-select v-model="ruleForm.region" placeholder="请选择活动区域">-->
<!--                    <el-option label="区域一" value="shanghai"></el-option>-->
<!--                    <el-option label="区域二" value="beijing"></el-option>-->
<!--                </el-select>-->
<!--            </el-form-item>-->

<!--            <el-form-item label="即时配送" prop="delivery">-->
<!--                <el-switch v-model="ruleForm.delivery"></el-switch>-->
<!--            </el-form-item>-->
<!--            <el-form-item label="活动性质" prop="type">-->
<!--                <el-checkbox-group v-model="ruleForm.type">-->
<!--                    <el-checkbox label="美食/餐厅线上活动" name="type"></el-checkbox>-->
<!--                    <el-checkbox label="地推活动" name="type"></el-checkbox>-->
<!--                    <el-checkbox label="线下主题活动" name="type"></el-checkbox>-->
<!--                    <el-checkbox label="单纯品牌曝光" name="type"></el-checkbox>-->
<!--                </el-checkbox-group>-->
<!--            </el-form-item>-->
<!--            <el-form-item label="特殊资源" prop="resource">-->
<!--                <el-radio-group v-model="ruleForm.resource">-->
<!--                    <el-radio label="线上品牌商赞助"></el-radio>-->
<!--                    <el-radio label="线下场地免费"></el-radio>-->
<!--                </el-radio-group>-->
<!--            </el-form-item>-->

            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {

        data() {
            var checkEmail = (rule,value,callback)=>{
                const emailRegex = /^\\w+@\\w+(\\.[a-zA-Z]{2,3}){1,2}$/
                if(!value){
                    callback(new Error("邮箱不能为空"))
                }
                setTimeout(()=>{
                    if(emailRegex.test(value)){
                        callback()
                    }else {
                        callback(new Error("请输入正确的邮箱格式"))
                    }
                },100)
            };
            return {
                ruleForm: {
                    age:'',
                    name: '',
                    email:'',
                    region: '',
                    delivery: false,
                    type: [],
                    resource: ''
                },
                rules: {
                    name: [
                        { required: true, message: '请输入活动名称', trigger: 'blur' },
                        { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                    ],
                    email: [
                        { required: true, validator:checkEmail , trigger: 'blur' },

                    ],
                    region: [
                        { required: true, message: '请选择活动区域', trigger: 'change' }
                    ],
                    date1: [
                        { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
                    ],
                    date2: [
                        { type: 'date', required: true, message: '请选择时间', trigger: 'change' }
                    ],
                    type: [
                        { type: 'array', required: true, message: '请至少选择一个活动性质', trigger: 'change' }
                    ],
                    resource: [
                        { required: true, message: '请选择活动资源', trigger: 'change' }
                    ],
                    desc: [
                        { required: true, message: '请填写活动形式', trigger: 'blur' }
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        console.log(this.ruleForm);
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

<style scoped>

</style>