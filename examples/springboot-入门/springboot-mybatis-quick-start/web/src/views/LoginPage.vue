<script>
import axios from 'axios'
import router from '@/router'
export default {
  data() {
    return {
      username: '',
      password: '',
      confirm_password: '',
      activate_mode: 'login'
    }
  },
  methods: {
    login() {
      const data = {
        username: this.username,
        password: this.password
      }

      axios({
        url: 'http://localhost:8080/login',
        method: 'post',
        data: data
      }).then((res) => {
        console.log(res)
        if (res.data.msg === 'error') {
          alert('登录失败，请重试')
        } else {
          localStorage.setItem('login_token', res.data.data)
          router.push('/employers')
        }
      })
    }
  },
  mounted() {}
}
</script>

<template>
  <div class="router-view">
    <div class="container">
      <el-form class="form-container">
        <el-form-item>
          <el-col :gutter="20" :span="16" :offset="4">
            <el-row>
              <el-col :span="10" ref="login">
                <el-button
                  v-if="activate_mode === 'login'"
                  class="mode active-mode"
                  >登录
                </el-button>
                <el-button v-else class="mode" @click="activate_mode = 'login'">
                  登录
                </el-button>
              </el-col>
              <el-col :span="10" ref="register">
                <el-button
                  v-if="activate_mode === 'register'"
                  class="mode active-mode"
                  >注册</el-button
                >
                <el-button
                  v-else
                  class="mode"
                  @click="activate_mode = 'register'"
                  >注册</el-button
                >
              </el-col>
            </el-row>
          </el-col>
        </el-form-item>
        <el-form-item>
          <el-col :gutter="20" :span="16" :offset="4">
            <p>用户名</p>
            <el-input v-model="username" />
          </el-col>
        </el-form-item>
        <el-form-item>
          <el-col :gutter="20" :span="16" :offset="4">
            <p>密码</p>
            <el-input v-model="password" />
          </el-col>
        </el-form-item>
        <el-form-item v-if="activate_mode === 'register'">
          <el-col ref="comfirm_password" :gutter="20" :span="16" :offset="4">
            <p>确认密码</p>
            <el-input v-model="confirm_password" />
          </el-col>
        </el-form-item>
        <el-form-item>
          <el-col :gutter="20" :span="16" :offset="4">
            <el-button
              v-if="activate_mode === 'login'"
              type="danger"
              class="submit-button"
              @click="login"
              >登录</el-button
            >
            <el-button
              v-else
              type="danger"
              class="submit-button"
              @click="register"
              >注册</el-button
            >
          </el-col>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<style scoped>
.container {
  height: 50%;
  position: absolute;
  top: 25%;
  width: 50%;
  left: 25%;
  border: 1px solid black;
}

.main {
  height: 100%;
  width: 100%;
}

.form-input {
  height: 100%;
  width: 100%;
}

.form-container {
  margin: 20%;
}

.submit-button {
  width: 100%;
}

.active-mode {
  background-color: aqua;
}

.mode {
  text-align: center;
  border-radius: 10px;
  border: none;
}
</style>
