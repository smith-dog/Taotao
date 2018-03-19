package com.taotao;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

public class TestFtpSever {
        @Test
        public void testFtp() throws Exception {
            //1、连接ftp服务器
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect("192.168.1.104", 21);
            //2、登录ftp服务器
            ftpClient.login("hunterftp", "123456");
            //3、读取本地文件
            FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\mmallShop\\taotaoImage\\imagehahah.png"));
            //4、上传文件
            //1）指定上传目录
            ftpClient.changeWorkingDirectory("/home/hunterftp/");
            //2）指定文件类型
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            //第一个参数：文件在远程服务器的名称
            //第二个参数：文件流
            ftpClient.storeFile("hello.jpg", inputStream);
            //5、退出登录
            ftpClient.logout();
        }
}
