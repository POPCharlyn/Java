package com.zy.tutor;

import org.apache.commons.io.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@SpringBootApplication
public class TutorApplication {
    private static String strNetImageToBase64;

    public static void main(String[] args) throws Exception {
        // protobuf序列化
        xunjianProtos.ParkingPub parking = xunjianProtos.ParkingPub.newBuilder().build();

        java.io.InputStream f = new FileInputStream("C:/Users/zhangying/Desktop/car/q/publish_0.txt");

        byte[] buf = IOUtils.toByteArray(f);
        xunjianProtos.ParkingPub parkingPub = xunjianProtos.ParkingPub.parseFrom(buf);

        System.out.println(parkingPub);

        for (int i = 0; i < parkingPub.getParkingmsgCount(); i++) {
            System.out.println(i); // 0 (一个数组)
            xunjianProtos.ParkingImage parkingImage = parkingPub.getParkingmsg(i);
            System.out.println(parkingImage.getPrimaryID()); // 1、停车位主键ID (唯一性) （等待甲方确认）
            System.out.println(parkingImage.getParkingId()); // 2、停车位ID
            System.out.println(parkingImage.getObtainObstacle()); // 3、巡检结果的车位号否有车 （0:无车，1:有车）
            System.out.println("车位上所停车辆的车牌号:");
            System.out.println(parkingImage.getLicensePlate()); // 4、车位上所停车辆的车牌号，如无车则为空
            System.out.println("巡检的时间:");
            System.out.println(parkingImage.getMeasurementTime()); // 5、巡检的时间
            // 打印时间戳
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
            String dateString = formatter.format(currentTime);
            System.out.println("当次巡检的唯一编号:");
            System.out.println(dateString); // 6、批次号 当次巡检的唯一编号


            // 打印巡检的图片集
            for (int j = 0; j < parkingImage.getPictureCount(); j++) {
                java.io.OutputStream os = new FileOutputStream("C:/Users/zhangying/Desktop/car/q/t.jpg");
                os.write(parkingImage.getPicture(j).getData().toByteArray());
                os.close();
            }
        }
    }
}




        /*

     System.out.println(parking1);

        // 转为二进制
        byte[] content = parking1.toByteArray();

        // 通过httpclient的post请求传输protobuf二进制流
        // 使用protobuf，所有的参数和返回都是对象的形式
        HttpClient client = new HttpClient();
        PostMethod postMethod = new PostMethod(URL);
        // content-type 设置为 application/octet-stream
        postMethod.addRequestHeader("Content-Type", "application/octet-stream;charset=utf-8");
        postMethod.setRequestEntity(new ByteArrayRequestEntity(content ));
        client.executeMethod(postMethod);

        // String byte 切换方法
        // 服务端返回字符串
        // 两种方式
        // Arrays.toString(personInfo.toByteArray())
        // toByteString().toStringUtf8()


        // protobuf反序列化
        xunjianProtos.ParkingImage parking2 = xunjianProtos.ParkingImage.parseFrom(content);
        System.out.println(parking2);

        // 写入文件 // 有乱码
        // parking1.writeTo(new FileOutputStream("G:/proto/pro/proto.data"));
        parking1.writeTo(new FileOutputStream("G:/proto/pro/proto.json"));

       // xunjianProtos.ParkingImage parking2 = xunjianProtos.ParkingImage.parseFrom(new FileInputStream("G:/proto/pro/proto.data"));
        xunjianProtos.ParkingImage parking2 = xunjianProtos.ParkingImage.parseFrom(new FileInputStream("G:/proto/pro/proto.json"));
        System.out.println(parking2.getLicensePlate());*/





