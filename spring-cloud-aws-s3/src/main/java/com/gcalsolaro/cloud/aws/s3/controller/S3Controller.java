package com.gcalsolaro.cloud.aws.s3.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcalsolaro.cloud.aws.s3.config.SpringCloudS3Service;

@RestController
@RequestMapping(value = "/aws/s3")
public class S3Controller {

	private static String bucketName;
	private static String fileName = "sample-file.txt";

	@PostConstruct
	public void init() {
		setupResources();
	}

	@Autowired
	private SpringCloudS3Service springCloudS3Service;

	@GetMapping(value = "/create")
//	@PostMapping(value = "/create")
	public void createBucket() {
		springCloudS3Service.createBucket(bucketName);
	}

	@GetMapping(value = "/download")
	public void downloadObject() {
		springCloudS3Service.downloadObject(bucketName, fileName);
	}

	@GetMapping(value = "/upload")
//	@PostMapping(value = "/upload")
	public void uploadObject() {
		springCloudS3Service.uploadObject(bucketName, fileName);
	}

	@GetMapping(value = "/delete")
//	@DeleteMapping(value = "/delete")
	public void deleteBucket() {
		springCloudS3Service.deleteBucket(bucketName);
	}

	private static void setupResources() {
		bucketName = "custom-test-" + UUID.randomUUID().toString();
		try {
			Files.write(Paths.get(fileName), "Hello World!".getBytes());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
