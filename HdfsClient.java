package test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.net.URI;

public class Test {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://host47:8020");
        System.out.println(conf);
        FileSystem fs = FileSystem.get(conf);
        FSDataInputStream open = fs.open(new Path("/hello.txt"));
        IOUtils.copyBytes(open, System.out, 1024);

    }
}
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

Configuration: core-default.xml, core-site.xml
log4j:WARN No appenders could be found for logger (org.apache.hadoop.metrics2.lib.MutableMetricsFactory).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
In Chinese lunar calendar, July 7th is a romantic day for the young people, which is called Qixi Festival that is also referred to the Chinese Valentine’s Day. This festival has been the tradition and many young people celebrate it in their own way. What’s more, the government listed Qixi Festival as the intangible cultural heritage.
在中国的农历7月7日对年轻人来说是一个浪漫的日子，被称为七夕节，也被称为中国的情人节。这个节日一直奉为传统节日，许多年轻人都用自己的方式来庆祝。此外，政府还将七夕节列为非物质文化遗产。

The origin of Qixi Festival is about a romantic story. It was said that in the ancient time, a beautiful young lady who was an immortal came to the men’s world. She fell in love with an ordinary man. But there was limitation between immortal and human being, so they were separated by the lady’s parents. Their love story moved a lot of people and the girl’s parents decided to let this couple meet on July 7th every year.
七夕节的起源是一个浪漫的故事。据说，在古代有一个美丽的年轻女神仙来到了人间，她爱上了一个平凡的男子。但是人与神仙之间是不允许结合的，所以他们被女孩的父母分开了。他们的爱情故事打动了很多人，女孩的父母决定让这对情侣每年的7月7日见一面。

Today, When Qixi Festival comes, the single ladies and men will try to ask the one they like out. They want to have a date and show their likeness. So they know each other’s heart if they say yes on that day. The romantic atmosphere can be sensed everywhere and we are enjoying it. 
如今，七夕节来临之际，单身男女们会试着向自己喜欢的人发出邀约，进行约会，并展示自己的爱意。所以，如果他们在那天说“是”，他们就会了解到彼此内心的想法。到处都能感受到浪漫的气氛，我们很享受这样的氛围
Process finished with exit code 0

        */
