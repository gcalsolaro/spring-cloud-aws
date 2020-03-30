

# Spring Cloud AWS

![Java CI with Maven](https://github.com/gcalsolaro/spring-cloud-aws/workflows/Java%20CI%20with%20Maven/badge.svg)
> **Sample application using Spring Cloud AWS**


## Table of Contents

   * [Spring Cloud AWS](#spring-cloud-aws)
      * [Architecture](#architecture)
      * [Prerequisites](#prerequisites)
      * [Running Instructions for AWS S3](#running-instructions-for-aws-s3)
      * [Running Instructions for AWS SNS](#running-instructions-for-aws-sns)
      

## Architecture

The technology stack used is provided by Spring, in particular:

* **_Spring Boot_** - 2.1.1.RELEASE
* **_Spring Cloud_** - Greenwich.RELEASE
* **_Spring Cloud AWS_** - 2.1.1.RELEASE

## Prerequisites
* **_JDK 8_** - Install JDK 1.8 version
* **_Maven_** - Download latest version
* **_AWS Account_**

## Running Instructions for AWS S3
 - Change *"accessKey"* and *"secretKey"* inside the **application.yml** file with your AWS personal data

### Rest API

Method | URI | Description | Parameters |
--- | --- | --- | --- |
`POST` | */aws/s3/create* | Create new S3 Bucket
`GET` | */aws/s3/download* | Download content
`POST` | */aws/s3/upload* | Upload content
`DELETE` | */aws/s3/delete* | Delete S3 Bucket 

## Running Instructions for AWS SNS
 - Change *"accessKey"* and *"secretKey"* inside the **application.yml** file with your AWS personal data

### Rest API

Method | URI | Description | Parameters |
--- | --- | --- | --- |
`POST` | */aws/sns/create* | Create new SNS
`POST` | */aws/sns/subscribe/{topicArn}/{email}* | Subscribe to SNS | Topic ARN; Personal Email Address
`POST` | */aws/sns/send/{topicArn}* | Send Message | Topic ARN
`DELETE` | */aws/sns/delete/{topicArn}* | Delete SNS | Topic ARN 