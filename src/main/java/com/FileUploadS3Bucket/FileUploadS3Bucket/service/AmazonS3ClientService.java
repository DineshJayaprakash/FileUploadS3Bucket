package com.FileUploadS3Bucket.FileUploadS3Bucket.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * class AmazonS3ClientService
 * 
 * @author dinesh
 * @created Date 06/01
 * @description used to upload or delete the files in s3 bucket
 *
 */
public interface AmazonS3ClientService {
	/**
	 * function uploadFileToS3Bucket
	 * 
	 * @param multipartFile
	 * @param enablePublicReadAccess
	 * @return none
	 */
    void uploadFileToS3Bucket(MultipartFile multipartFile, boolean enablePublicReadAccess);

    /**
     * function deleteFileFromS3Bucket
     * 
     * @param fileName
     * @return none
     */
    void deleteFileFromS3Bucket(String fileName);

}
