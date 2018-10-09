package com.bees360.fast;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import com.bees360.common.utils.FastDFSClient;

public class FastDfsTest {
	@Test
	public void testUpload() throws Exception {
		//创建一个配置文件。文件名任意。内容就是tracker服务器的地址。
		//使用全局对象加载配置文件。
		ClientGlobal.init("F:/Users/bees360/workspace1/e3-manager-web/src/main/resources/conf/client.conf");
		//创建一个TrackerClient对象
		TrackerClient trackerClient = new TrackerClient();
		//通过TrackClient获得一个TrackerServer对象
		TrackerServer trackerServer = trackerClient.getConnection();
		//创建一个StrorageServer的引用，可以是null
		StorageServer storageServer = null;
		//创建一个StorageClient，参数需要TrackerServer和StrorageServer
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		//使用StorageClient上传文件。
		String[] strings = storageClient.upload_file("D:/Documents/Pictures/images/2f2eb938943d.jpg", "jpg", null);
		for (String string : strings) {
			System.out.println(string);
		}
		
	}
	@Test
	public void testFastDfClient() throws Exception{
		FastDFSClient fastDFSClient = new FastDFSClient("F:/Users/bees360/workspace1/e3-manager-web/src/main/resources/conf/client.conf");
		String string = fastDFSClient.uploadFile("E:/BaiduNetdiskDownload/项目二：宜立方商城/e3商城_day01/黑马32期/01.教案-3.0/01.参考资料/静态页面/04.商品详情静态页面/images/html/2a3ba6ffb33d8fca0dc848f94e3d99d8.jpg");
		System.out.println(string);
	}
}
