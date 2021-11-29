package com.zy.until;

import java.io.IOException;

/**
 * protoc.exe
 * @author zy
 *
 * 通过执行cmd命令调用protoc.exe程序
 *
 * 命令格式如下：
 * protoc.exe -I=proto的输入目录 --java_out=java类输出目录 proto的输入目录包括包括proto文件
 *
 * cmd执行命令如：
 * protoc.exe -I=G:/proto --java_out=G:/proto G:/proto/person-entity.proto
 *
 * 所有路径均由自行创建并指定
 * 1、G:/proto 是本地存放.proto文件夹路径
 * 2、G:/proto 代表.proto转为.java文件路径
 * 3、指向.proto文件全路径
 */
class GenerateClass {
    public static void main(String[] args) {
        String protoFile = "person-entity.proto";
        String strCmd = "G:/App/Tools/protoc/protof/protobuf-master/src/protoc.exe -I=./proto --java_out=./src/main/java/com ./proto/"+ protoFile;
        try {
            Runtime.getRuntime().exec(strCmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
