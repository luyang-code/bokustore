package com.tsc.graduateproj.bokubookstore.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.UUID;

/**
 * 服务器上传文件
 */
public class MyFTP {
    //阿里云服务器ip地址
    private static final String HOSTNAME = "120.26.175.109";
    //ftp端口号
    private static final int  PORT = 21;
    //服务器登录用户名
    private static final String  USERNAME = "root";
    //服务器登录密码
    private static final String  PASSWORD = "Ly1997731";
    //服务器上tomcat服务虚拟路径(/root目录)
    private static final String LINUXTOMCATVIRTUALPATH = "http://120.26.175.109:8080/pictures/";

    public static String ftpUpLoadImg(MultipartFile file){
        InputStream input = null;
        //初始化服务器端图片文件名
        String remoteFileName="";
        //获取图片名字
        String imagefileFileName = file.getOriginalFilename();
        //截取文件后缀名
        String extendName = imagefileFileName.substring(imagefileFileName.lastIndexOf("."));
        //创建ftp客户端
        FTPClient ftpClient = new FTPClient();
        ftpClient.setControlEncoding("UTF-8");//GBK
        try {
            //链接ftp服务器
            ftpClient.connect(HOSTNAME, PORT);
            //登录ftp
            ftpClient.login(USERNAME, PASSWORD);
            int  reply = ftpClient.getReplyCode();
            //如果reply返回230就算成功了，如果返回530密码用户名错误或当前用户无权限
            System.out.println(reply);

            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                return "";
            }
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
//            ftpClient.makeDirectory("path");//在root目录下创建文件夹
            remoteFileName = UUID.randomUUID().toString()+System.currentTimeMillis()+extendName;
            input = file.getInputStream();
            ftpClient.storeUniqueFile(remoteFileName,input);//文件你若是不指定就会上传到root目录下
            ftpClient.logout();


        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally
        {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (ftpClient.isConnected())
            {
                try
                {
                    ftpClient.disconnect();
                } catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }

        }
        //返回可在浏览器访问的服务器的图片路径
        return LINUXTOMCATVIRTUALPATH + remoteFileName;
    }
}
