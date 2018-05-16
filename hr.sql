/*
Navicat MySQL Data Transfer

Source Server         : zhao
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : hr

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-30 09:03:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for applicant_info
-- ----------------------------
DROP TABLE IF EXISTS `applicant_info`;
CREATE TABLE `applicant_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `job` varchar(30) DEFAULT NULL COMMENT '应聘人员职位',
  `major` varchar(30) DEFAULT NULL COMMENT '所学专业',
  `experence` varchar(200) DEFAULT NULL COMMENT '工作经历',
  `study_effort` varchar(200) DEFAULT NULL COMMENT '学历',
  `school` varchar(50) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `content` text COMMENT '详细经历',
  `is_store` varchar(2) DEFAULT NULL COMMENT '是否入库',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of applicant_info
-- ----------------------------
INSERT INTO `applicant_info` VALUES ('11', '王丽', '女', '24', '教师', '英语', '无', '大学本科', '湖北大学', '15082258274', '15082258274@qq.com', null, '无', '是');
INSERT INTO `applicant_info` VALUES ('12', '张文', '男', '23', '软件设计师', '软件工程', '无', '大学本科', '武汉大学', '15082327812', '15082327812@qq.com', null, '无', '是');
INSERT INTO `applicant_info` VALUES ('13', '孙雯', '女', '22', '会计', '经济学', '无', '大学本科', '北京大学', '15082129538', '15082129538@qq.com', null, '无', '是');
INSERT INTO `applicant_info` VALUES ('14', '李飞', '男', '26', '管理', '管理学', '无', '大学本科', '南京大学', '15285446238', '15285446238@qq.com', null, '无', '是');
INSERT INTO `applicant_info` VALUES ('15', '王五', '男', '28', '翻译', '英语', '无', '大学本科', '清华大学', '15098456738', '15098456738@qq.com', null, '无', '是');

-- ----------------------------
-- Table structure for reward__info
-- ----------------------------
DROP TABLE IF EXISTS `reward__info`;
CREATE TABLE `reward__info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '奖惩名称',
  `reason` varchar(200) DEFAULT NULL COMMENT '奖惩原因',
  `explain` varchar(200) DEFAULT NULL COMMENT '奖惩说明',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reward__info
-- ----------------------------
INSERT INTO `reward__info` VALUES ('21', '张三', '迟到', '警告一次', '2017-12-21 15:06:33');
INSERT INTO `reward__info` VALUES ('22', '李四', '高效率完成任务', '奖励月底奖金', '2017-12-15 15:06:38');
INSERT INTO `reward__info` VALUES ('23', '王亮', '早退', '扣除月底奖金', '2017-12-30 15:06:42');
INSERT INTO `reward__info` VALUES ('24', '张伟', '没有限时完成工作', '警告一次', '2017-12-29 15:06:51');
INSERT INTO `reward__info` VALUES ('25', '赵亮', '全勤工作效率高', '加成年度奖金', '2017-12-29 15:06:54');

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL COMMENT '员工姓名',
  `basic` int(11) DEFAULT NULL,
  `eat` int(11) DEFAULT NULL,
  `house` int(11) DEFAULT NULL,
  `grant_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `scot` int(11) DEFAULT NULL,
  `duty` int(11) DEFAULT NULL,
  `punishment` int(11) DEFAULT NULL,
  `other` int(11) DEFAULT NULL,
  `total_salary` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of salary
-- ----------------------------
INSERT INTO `salary` VALUES ('21', '张三', '3000', '100', '200', '2018-01-01 00:00:00', '500', '300', '100', '100', '3500');
INSERT INTO `salary` VALUES ('22', '李四', '3500', '100', '200', '2018-01-01 00:00:00', '500', '350', '150', '100', '3900');
INSERT INTO `salary` VALUES ('23', '王亮', '4000', '100', '200', '2018-01-01 00:00:00', '500', '300', '100', '100', '4500');
INSERT INTO `salary` VALUES ('24', '张伟', '3800', '100', '200', '2018-01-01 00:00:00', '500', '300', '100', '100', '4300');
INSERT INTO `salary` VALUES ('25', '赵亮', '4400', '100', '200', '2018-01-01 00:00:00', '500', '300', '100', '100', '4900');

-- ----------------------------
-- Table structure for train
-- ----------------------------
DROP TABLE IF EXISTS `train`;
CREATE TABLE `train` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '培训名称',
  `prupose` varchar(100) DEFAULT NULL COMMENT '培训目的',
  `begin_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `end_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `datum` text COMMENT '培训材料',
  `teacher` varchar(30) DEFAULT NULL COMMENT '培训老师',
  `student` varchar(30) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `educate` varchar(2) DEFAULT NULL COMMENT '培训是否完成',
  `effect` text COMMENT '培训效果',
  `summarize` varchar(200) DEFAULT NULL COMMENT '培训总结',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of train
-- ----------------------------
INSERT INTO `train` VALUES ('1', '岗位培训', '无', '2017-12-29 15:12:11', '2017-12-29 15:12:11', '相关书籍及资料', '张三', '王丽', '2017-12-29 15:12:11', '是', '基本已完成培训目的', '不错');
INSERT INTO `train` VALUES ('2', '入职培训', '无', '2017-12-29 15:12:14', '2017-12-29 15:12:14', '相关书籍及资料', '李四', '张文', '2017-12-29 15:12:14', '是', '基本已完成培训目的', '还不错');
INSERT INTO `train` VALUES ('3', '内部培训', '无', '2017-12-29 15:12:17', '2017-12-29 15:12:17', '相关书籍及资料', '王亮', '孙雯', '2017-12-29 15:12:17', '是', '基本已完成培训目的', '挺不错');
INSERT INTO `train` VALUES ('4', '外部培训', '无', '2017-12-29 15:12:22', '2017-12-29 15:12:22', '相关书籍及资料', '张伟', '李飞', '2017-12-29 15:12:22', '是', '基本已完成培训目的', '还挺不错');
INSERT INTO `train` VALUES ('5', '海外培训', '无', '2017-12-29 15:12:27', '2017-12-29 15:12:27', '相关书籍及资料', '赵亮', '王五', '2017-12-29 15:12:27', '是', '基本已完成培训目的', '确实还挺不错');
INSERT INTO `train` VALUES ('6', '123', '123', '2018-01-15 00:00:00', '2018-01-22 00:00:00', '123', '123', '123', '2017-12-30 09:00:20', '1', '213', '123');

-- ----------------------------
-- Table structure for trainer_info
-- ----------------------------
DROP TABLE IF EXISTS `trainer_info`;
CREATE TABLE `trainer_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `detail` varchar(200) DEFAULT NULL,
  `train_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='培训学员信息';

-- ----------------------------
-- Records of trainer_info
-- ----------------------------
INSERT INTO `trainer_info` VALUES ('3', '1234', '男', '1234', '6');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `birthday` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_admin` varchar(2) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL COMMENT '人员简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1007 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('21', 'zhangsan', '789', '男', '1994-06-03 00:00:00', '2017-03-05 00:00:00', '是', '培训职工');
INSERT INTO `user_info` VALUES ('22', 'lisi', '456', '男', '1991-08-05 00:00:00', '2017-03-05 00:00:00', '是', '培训职工');
INSERT INTO `user_info` VALUES ('23', 'wangwu', '777', '男', '1987-03-04 00:00:00', '2017-03-05 00:00:00', '是', '培训职工');
INSERT INTO `user_info` VALUES ('24', 'wangliang', '000', '男', '1977-07-04 00:00:00', '2017-03-05 00:00:00', '是', '培训职工');
INSERT INTO `user_info` VALUES ('25', 'zhangwei', '888', '男', '1980-11-02 00:00:00', '2017-03-05 00:00:00', '是', '培训职工');
INSERT INTO `user_info` VALUES ('1001', 'zhaoliang', '123', '女', '1993-04-07 00:00:00', '2017-03-05 00:00:00', '否', '培训人员');
INSERT INTO `user_info` VALUES ('1002', 'zhangwen', '111', '男', '1994-02-07 00:00:00', '2017-03-05 00:00:00', '否', '培训人员');
INSERT INTO `user_info` VALUES ('1003', 'sunwen', '321', '女', '1995-01-03 00:00:00', '2017-03-05 00:00:00', '否', '培训人员');
INSERT INTO `user_info` VALUES ('1004', 'lifei', '333', '男', '2017-12-30 08:44:26', '2017-12-30 08:44:26', '否', '培训人员');
INSERT INTO `user_info` VALUES ('1005', 'wangwu', '333', '男', '1990-08-03 00:00:00', '2017-03-05 00:00:00', '否', '培训人员');
