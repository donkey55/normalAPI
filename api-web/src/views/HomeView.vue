<template>
    <div class="container">
        <div style="margin-left: 20px">
            <n-button type="primary" @click="openSnake">
                贪吃蛇
            </n-button>
        </div>
        <div class="short-link">
            <n-input-group>
                <n-input placeholder="please your link" v-model:value="link">
                    <template #prefix>
                        <n-icon :component="Link" />
                    </template>
                </n-input>
                <n-button type="primary" ghost @click="short">
                    生成
                </n-button>
            </n-input-group>
        </div>
    </div>
</template>

<script setup>
import {NButton, NInput, NInputGroup, NIcon} from "naive-ui";
import { Link } from '@vicons/tabler'
import {ref} from "vue";
import {shortLink} from "@/api";

const openSnake = () => {
    window.open("/Snake/index.html")
}

const short = () => {
    const query = {
        link: link.value
    }
    shortLink(query).then(({data}) => {
        alert(data.result.redirect)
    })
}

const link = ref("");
</script>

<style scoped lang="less">
.container {
  width: 1200px;
  margin: 50px auto auto;
  .short-link {
    margin-top: 50px;
  }
}
</style>
