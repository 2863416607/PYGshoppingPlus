package com.shop.pyg.util.fastDFS;


import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @作者: 段清刚
 * @日期时间: 2019-02-22 13:57
 * @功能描述: 工具类(DFSS图片服务器图片操作需要实例化对象，推荐所有无参构造)
 * @see
 */

public class FastDFSUtil {
    private static TrackerClient trackerClient = null;
    private static TrackerServer trackerServer = null;
    private static StorageServer storageServer = null;
    private static StorageClient1 storageClient = null;


    public FastDFSUtil(String conf) throws Exception {
        if (conf.contains("classpath:")) {
            conf = conf.replace("classpath:", this.getClass().getResource("/").getPath());
        }
        ClientGlobal.init(conf);
        trackerClient = new TrackerClient();
        trackerServer = trackerClient.getConnection();
        storageServer = null;
        storageClient = new StorageClient1(trackerServer,   storageServer);
    }


    /**
     * 使用无参需要将common层的fastdfs-client.properties文件拷贝一份到本工程web层resources根目录下
     * @throws Exception
     */
    public FastDFSUtil() throws Exception{
        String path = this.getClass().getClassLoader().getResource("fastdfs-client.properties").getPath();
        ClientGlobal.init(path);
        trackerClient = new TrackerClient();
        trackerServer = trackerClient.getConnection();
        storageServer = null;
        storageClient = new StorageClient1(trackerServer, storageServer);
    }

    /**
     * 图片上传
     * @param fileContent
     * @param extName 后缀 例如：jpg，png
     * @return 上传成功后返回id例如group1/M00/00/00/rBAADVxvjh6AICJuAAERHRdS-j8320.jpg，保存到数据库只需要前面加上服务器ip
     * @throws Exception
     */
    public String uploadFile(byte[] fileContent, String extName) throws Exception {
        return storageClient.upload_appender_file1(fileContent,extName,null);
    }

    /**
     * 删除
     * @param result 例如：group1/M00/00/00/rBAADVxvjh6AICJuAAERHRdS-j8320.jpg
     * @return 0表示成功
     * @throws Exception
     */
    public int delete(String result) throws Exception{
       return storageClient.delete_file1(result);
    }


    /**
     * 下载
     * @param result 例如：group1/M00/00/00/rBAADVxvjh6AICJuAAERHRdS-j8320.jpg
     * @return
     * @throws Exception
     */
    public byte[] download_file(String result) throws Exception{
        return storageClient.download_file1(result);
    }


    /**
     * 关闭
     * @throws IOException
     */
    public void close() throws IOException {
        trackerServer.close();
    }


}
