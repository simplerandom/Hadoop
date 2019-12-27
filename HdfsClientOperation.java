package test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

public class Test {
    public static void main(String[] args) throws IOException {

        /*
        参考文档
        https://www.cnblogs.com/YellowstonePark/p/7699083.html
        配置步骤：
        1.下载hadoop
        2.下载winutil.exe文件，hadoop.dll文件，并且将文件放置bin目录
        3.配置window下的hadoop环境变量HADOOP_HOME
        4.导入maven依赖
         <dependencies>
    <dependency>
        <groupId>org.apache.hadoop</groupId>
        <artifactId>hadoop-common</artifactId>
        <version>3.2.1</version>
    </dependency>
    <dependency>
        <groupId>org.apache.hadoop</groupId>
        <artifactId>hadoop-hdfs</artifactId>
        <version>3.2.1</version>
    </dependency>
    <dependency>
        <groupId>org.apache.hadoop</groupId>
        <artifactId>hadoop-mapreduce-client-core</artifactId>
        <version>3.2.1</version>
    </dependency>

    </dependencies>
         5.---------配置文件未用到，配置存在很大问题
         <2019.12.27更新>
         idea可以不配置
         conf.set("fs.defaultFS", "hdfs://host47:8020");
         访问namenode，
         若namenode不能自动切换
         可能是zkfc进程关闭了
         hadoop-daemon.sh start zkfc
         恢复正常
        */

        Configuration conf = new Configuration(true);

        //系统默认会读取resource目录下的core-site，hdfs-site文件
        //        conf.set("fs.defaultFS", "hdfs://host47:8020");
        //设置访问用户
        System.setProperty("HADOOP_USER_NAME", "root");
        //获取文件系统对象
        FileSystem fs = FileSystem.get(conf);
      /*//1.新建文件夹和删除文件夹
        if (fs.exists(new Path("/idea"))) {
            System.out.println(fs.delete(new Path("/idea"), true));
        }
        boolean mkdirs = fs.mkdirs(new Path("/idea"));*/
        //2.向hdfs上传文件
        /*String uploadFileName="D:\\GoogleDownLoad\\hdfile\\hadoop-3.2.1.tar.gz";
        String filePath="/likun/hadoop.tar.gz";
        FSDataOutputStream out = fs.create(new Path(filePath));
        //conf里有缓存区size,true代表io流自动关闭
        IOUtils.copyBytes(new FileInputStream(uploadFileName),out,conf,true);*/
        //3.读文件
        /*FSDataInputStream open = fs.open(new Path("/likun/core-site-upload.xml"));
        IOUtils.copyBytes(open,System.out,conf,true);*/
        //4.查看文件所在block信息
        //方式一
       /* BlockLocation[] fileBlockLocations = fs.getFileBlockLocations(new Path("/likun/hadoop.tar.gz"), 0, 5000);
        for (BlockLocation fileBlockLocation : fileBlockLocations) {
            System.out.println(fileBlockLocation);
        }*/
        //方式二
        /*FileStatus fileStatus = fs.getFileStatus(new Path("/likun/hadoop.tar.gz"));
        BlockLocation[] fileBlockLocations1 = fs.getFileBlockLocations(fileStatus, 0, fileStatus.getLen());
        for (BlockLocation blockLocation : fileBlockLocations1) {

            System.out.println(blockLocation);
        }*/
        //5.选择block读字节
        FSDataInputStream open = fs.open(new Path("/likun/core-site-upload.xml"));
        for (int i = 0; i < 100; i++) {

            System.out.print((char)open.read());
        }
        System.out.println(" ");
        open.seek(700);
        System.out.println("-------------------");
        int a=0;
        while ((a=open.read())!=-1){
            System.out.print((char)a);
        }



    }
}
