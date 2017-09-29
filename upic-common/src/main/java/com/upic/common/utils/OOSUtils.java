package com.upic.common.utils;

import java.io.InputStream;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;

public class OOSUtils {
	/**
	 * 上传文件流
	 * 
	 * @param endpoint
	 * @param accessKeyId
	 * @param accessKeySecret
	 * @param bucketName
	 * @param key
	 * @param inputStream
	 * @return
	 */
	public static String uploadFile(String endpoint, String accessKeyId, String accessKeySecret, String bucketName,
			String key, InputStream inputStream) {
		String result = null;
		// 创建OSSClient实例
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		try {
			ossClient.putObject(bucketName, key, inputStream);
			// 关闭client
			ossClient.shutdown();
			result = "success";
			return result;
		} catch (OSSException oe) {
			System.out.println("Caught an OSSException, which means your request made it to OSS, "
					+ "but was rejected with an error response for some reason.");
			System.out.println("Error Message: " + oe.getErrorCode());
			System.out.println("Error Code:       " + oe.getErrorCode());
			System.out.println("Request ID:      " + oe.getRequestId());
			System.out.println("Host ID:           " + oe.getHostId());
		} catch (ClientException ce) {
			System.out.println("Caught an ClientException, which means the client encountered "
					+ "a serious internal problem while trying to communicate with OSS, "
					+ "such as not being able to access the network.");
			System.out.println("Error Message: " + ce.getMessage());
		} finally {
			if (ossClient != null) {
				ossClient.shutdown();
			}
		}
		return null;
	}
	
	/**
	 * 文件删除
	 * 
	 * @param endpoint
	 * @param accessKeyId
	 * @param accessKeySecret
	 * @param bucketName
	 * @param key
	 * @param inputStream
	 * @return
	 */
	public static String deleteFile(String endpoint, String accessKeyId, String accessKeySecret, String bucketName,
			String key) {
		String result = null;
		// 创建OSSClient实例
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		try {
			// 删除Object
			ossClient.deleteObject(bucketName, key);
			// 关闭client
			ossClient.shutdown();
			result = "success";
			return result;
		} catch (OSSException oe) {
			System.out.println("Caught an OSSException, which means your request made it to OSS, "
					+ "but was rejected with an error response for some reason.");
			System.out.println("Error Message: " + oe.getErrorCode());
			System.out.println("Error Code:       " + oe.getErrorCode());
			System.out.println("Request ID:      " + oe.getRequestId());
			System.out.println("Host ID:           " + oe.getHostId());
		} catch (ClientException ce) {
			System.out.println("Caught an ClientException, which means the client encountered "
					+ "a serious internal problem while trying to communicate with OSS, "
					+ "such as not being able to access the network.");
			System.out.println("Error Message: " + ce.getMessage());
		} finally {
			if (ossClient != null) {
				ossClient.shutdown();
			}
		}
		return null;
	}
}
