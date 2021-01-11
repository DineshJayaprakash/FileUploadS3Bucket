package com.FileUploadS3Bucket.FileUploadS3Bucket.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.FileUploadS3Bucket.FileUploadS3Bucket.service.AmazonS3ClientService;

/**
 * class FileController
 * 
 * @author dinesh
 * @created Date 06/01
 * @description used to map the endpoint url's based on user operation
 *
 */
@RestController
@RequestMapping("files")
public class FileController {
	
    /**
     * bean of amazonS3ClientService
     */
    private AmazonS3ClientService amazonS3ClientService;
    
    /**
     * parameterized constructor
     * 
     * @param amazonS3ClientService
     * @description used to add dependency injection
     */
    @Autowired
    public FileController(AmazonS3ClientService amazonS3ClientService) {
    	this.amazonS3ClientService = amazonS3ClientService;
    }

    /**
     * function uploadFile
     * 
     * @param file
     * @return response message
     * @description used to upload file in amazon s3 bucket
     */
    @PostMapping("")
    public Map<String, String> uploadFile(@RequestPart(value = "file") MultipartFile file)
    {
        this.amazonS3ClientService.uploadFileToS3Bucket(file, true);

        Map<String, String> response = new HashMap<>();
        response.put("message", "file [" + file.getOriginalFilename() + "] uploading request submitted successfully.");

        return response;
    }

    /**
     * function deleteFile
     * 
     * @param fileName
     * @return response message
     * @description used to delete file amazon s3 bucket
     */
    @DeleteMapping("")
    public Map<String, String> deleteFile(@RequestParam("file_name") String fileName)
    {
        this.amazonS3ClientService.deleteFileFromS3Bucket(fileName);

        Map<String, String> response = new HashMap<>();
        response.put("message", "file [" + fileName + "] removing request submitted successfully.");

        return response;
    }

}
