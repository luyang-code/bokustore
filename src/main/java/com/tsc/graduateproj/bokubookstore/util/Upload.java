//package com.tsc.graduateproj.bokubookstore.util;
//
//import com.aliyun.oss.OSS;
//import com.aliyun.oss.OSSClient;
//import com.aliyun.oss.model.PutObjectRequest;
//
//import java.io.File;
//
//public class Upload {
//    // Endpoint以杭州为例，其它Region请按实际情况填写。
//    String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";//http://oss-cn-hangzhou.aliyuncs.com
//    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
//    String accessKeyId = "LTAI4FotoncCgdsKwaYnzT9f";//<yourAccessKeyId>AccessKeyID：LTAI4FotoncCgdsKwaYnzT9f
//    String accessKeySecret = "FkWQsKqLdAv3UDa2hMvqIONEiuU4L7";//<yourAccessKeySecret>AccessKeySecret：FkWQsKqLdAv3UDa2hMvqIONEiuU4L7
//
//    // 创建OSSClient实例。
//    OSS ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//
//    // 创建PutObjectRequest对象。
//    PutObjectRequest putObjectRequest = new PutObjectRequest("luyang1997", "/root/1.jpg", new File("D:/bokuimg/1.jpg"));
//
//    // 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
//    // ObjectMetadata metadata = new ObjectMetadata();
//    // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
//    // metadata.setObjectAcl(CannedAccessControlList.Private);
//    // putObjectRequest.setMetadata(metadata);
//
//    // 上传文件
//    ossClient.putObject(putObjectRequest);
//
//    // 关闭OSSClient。
//    ossClient.shutdown();
//}
