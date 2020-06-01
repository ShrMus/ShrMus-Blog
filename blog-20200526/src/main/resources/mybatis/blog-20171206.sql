/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50027
Source Host           : localhost:3306
Source Database       : blog-20171206

Target Server Type    : MYSQL
Target Server Version : 50027
File Encoding         : 65001

Date: 2020-06-01 21:48:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog_album
-- ----------------------------
DROP TABLE IF EXISTS `blog_album`;
CREATE TABLE `blog_album` (
  `album_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `album_name` varchar(50) default NULL,
  `album_description` varchar(255) default NULL,
  `album_cover_img` varchar(255) default NULL,
  `album_create_time` datetime default NULL,
  PRIMARY KEY  (`album_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for blog_article
-- ----------------------------
DROP TABLE IF EXISTS `blog_article`;
CREATE TABLE `blog_article` (
  `article_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `article_type_id` int(11) default NULL,
  `article_top` int(11) default NULL,
  `article_ispass` int(11) default NULL,
  `article_title` varchar(255) default NULL,
  `article_content` text,
  `article_count_click` int(11) default NULL,
  `article_update_time` datetime default NULL,
  `article_publish_time` datetime default NULL,
  PRIMARY KEY  (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for blog_article_comment
-- ----------------------------
DROP TABLE IF EXISTS `blog_article_comment`;
CREATE TABLE `blog_article_comment` (
  `article_comment_id` int(11) NOT NULL auto_increment,
  `article_comment_pid` int(11) default NULL,
  `article_id` int(11) default NULL,
  `article_commment_isreply` int(11) default NULL,
  `user_id_author` int(11) default NULL,
  `user_id_reply` int(11) default NULL,
  `article_comment_content` text,
  `article_comment_publish_time` datetime default NULL,
  PRIMARY KEY  (`article_comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for blog_article_type
-- ----------------------------
DROP TABLE IF EXISTS `blog_article_type`;
CREATE TABLE `blog_article_type` (
  `article_type_id` int(11) NOT NULL auto_increment,
  `article_type_name` varchar(50) default NULL,
  `article_type_description` varchar(255) default NULL,
  PRIMARY KEY  (`article_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for blog_leave_message
-- ----------------------------
DROP TABLE IF EXISTS `blog_leave_message`;
CREATE TABLE `blog_leave_message` (
  `message_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `message_pid` int(11) default NULL,
  `message_isreply` int(11) default NULL,
  `user_id_author` int(11) default NULL,
  `user_id_reply` int(11) default NULL,
  `message_content` text,
  `message_publish_time` datetime default NULL,
  PRIMARY KEY  (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for blog_picture
-- ----------------------------
DROP TABLE IF EXISTS `blog_picture`;
CREATE TABLE `blog_picture` (
  `picture_id` int(11) NOT NULL auto_increment,
  `album_id` int(11) default NULL,
  `picture_name` varchar(255) default NULL,
  `picture_url` varchar(255) default NULL,
  `picture_upload_time` datetime default NULL,
  PRIMARY KEY  (`picture_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for blog_privilege
-- ----------------------------
DROP TABLE IF EXISTS `blog_privilege`;
CREATE TABLE `blog_privilege` (
  `privilege_id` int(11) NOT NULL auto_increment,
  `privilege_name` varchar(50) default NULL,
  `privilege_url` varchar(255) default NULL,
  `privilege_parent_id` int(11) default NULL,
  `privilege_icon` varchar(255) default NULL,
  PRIMARY KEY  (`privilege_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for blog_question
-- ----------------------------
DROP TABLE IF EXISTS `blog_question`;
CREATE TABLE `blog_question` (
  `question_id` int(11) NOT NULL auto_increment,
  `question_pid` int(11) default NULL,
  `user_id_author` int(11) default NULL,
  `user_id_reply` int(11) default NULL,
  `question_title` varchar(255) default NULL,
  `question_content` text,
  `question_publish_time` datetime default NULL,
  `question_integral` int(11) default NULL,
  `question_accpeted` int(11) default NULL,
  PRIMARY KEY  (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for blog_resource
-- ----------------------------
DROP TABLE IF EXISTS `blog_resource`;
CREATE TABLE `blog_resource` (
  `resource_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `resource_ispass` int(11) default NULL,
  `resource_integral` int(11) default NULL,
  `resource_url` varchar(255) default NULL,
  `resource_size` int(11) default NULL,
  `resource_download_count` int(11) default NULL,
  `resource_name` varchar(255) default NULL,
  `resource_filename` varchar(255) default NULL,
  `resource_description` varchar(255) default NULL,
  `resource_upload_time` datetime default NULL,
  PRIMARY KEY  (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for blog_role
-- ----------------------------
DROP TABLE IF EXISTS `blog_role`;
CREATE TABLE `blog_role` (
  `role_id` int(11) NOT NULL auto_increment,
  `role_name` varchar(20) default NULL,
  `role_description` varchar(255) default NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for blog_role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `blog_role_privilege`;
CREATE TABLE `blog_role_privilege` (
  `role_privilege_id` int(11) NOT NULL auto_increment,
  `role_id` int(11) default NULL,
  `privilege_id` int(11) default NULL,
  PRIMARY KEY  (`role_privilege_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for blog_user
-- ----------------------------
DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user` (
  `user_id` int(11) NOT NULL auto_increment,
  `user_username` varchar(20) default NULL,
  `user_password` varchar(100) default NULL,
  `user_integral` int(11) default NULL,
  `user_phone` varchar(11) default NULL,
  `user_openid` varchar(100) default NULL,
  `user_nickname` varchar(100) default NULL,
  `user_icon` varchar(255) default NULL,
  `user_realname` varchar(20) default NULL,
  `user_email` varchar(50) default NULL,
  `user_gender` int(1) default NULL,
  PRIMARY KEY  (`user_id`),
  UNIQUE KEY `UQ__USER_USERNAME` USING HASH (`user_username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for blog_user_privilege
-- ----------------------------
DROP TABLE IF EXISTS `blog_user_privilege`;
CREATE TABLE `blog_user_privilege` (
  `user_privilege_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `privilege_id` int(11) default NULL,
  PRIMARY KEY  (`user_privilege_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for blog_user_role
-- ----------------------------
DROP TABLE IF EXISTS `blog_user_role`;
CREATE TABLE `blog_user_role` (
  `user_role_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `role_id` int(11) default NULL,
  PRIMARY KEY  (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
