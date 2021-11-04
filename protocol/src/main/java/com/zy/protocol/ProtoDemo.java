package com.zy.protocol;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ProtoDemo {

    public static void main(String[] args) throws Exception{
        // 对应java实体类
        Student s = new Student();
        s.setUsername("admin");
        s.setPassword("123456");
        s.setEmail("9977@163.com");
        s.setdValue(Double.MAX_VALUE); // 科学计数法 可在工具类设置显示方式
        s.setAge(Integer.MAX_VALUE);
        s.setTimespane(System.currentTimeMillis());

        // json序列化  138字节
        // 工具类
        ObjectMapper mapper = new ObjectMapper();
        String stuStr = mapper.writeValueAsString(s);
        System.out.println(stuStr);
        System.out.println("json字节长度： "+stuStr.getBytes("utf-8").length);
        System.out.println(Arrays.toString(stuStr.getBytes("utf-8")));

        // jdk原型序列化  184字节
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); // 内存流
        ObjectOutputStream oos = new ObjectOutputStream(baos); // 输出流
        oos.writeObject(s);
        oos.flush();
        System.out.println("jdk字节长度： "+baos.toByteArray().length);
        System.out.println(Arrays.toString(baos.toByteArray()));

        System.out.println("====================proto序列化===================");

        // protobuf序列化  53字节
        // 将实体类Student指向stu
        StudentProto3.Student stu =  StudentProto3.Student.newBuilder()
                .setUsername("admin")
                .setPassword("123456")
                .setEmail("9977@163.com")
                .setDValue(Double.MAX_VALUE)
                .setAge(Integer.MAX_VALUE)
                .setTimespane(System.currentTimeMillis()).build();
        System.out.println(stu);

        byte[] content = stu.toByteArray(); // 转为二进制 // 将stu指向content
        System.out.println("proto字节长度： "+content.length); // 长度
        System.out.println(Arrays.toString(content)); // 输出序列化的字节数（计算机后台读取二进制字节）

        System.out.println("--------------------proto反序列化---------------------");

        // protobuf反序列化
        //StudentProto3.Student.parseFrom(content);
        // 将二进制content传给proto定义的Student对象
        // 此时 StudentProto3.Student是一个新的对象，是反序列化出来的新对象
        StudentProto3.Student stuNew = StudentProto3.Student.parseFrom(content);
        System.out.println(stuNew);
    }
}
