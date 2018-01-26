# Host: localhost  (Version: 5.5.47)
# Date: 2018-01-26 11:49:53
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "course"
#

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

#
# Data for table "course"
#

INSERT INTO `course` VALUES (1,'java基础开发'),(4,'前端框架'),(8,'测试基础'),(10,'javaWeb'),(11,'SSH'),(15,'SSM'),(16,'ssm'),(17,'ssm'),(18,'ssm2');

#
# Structure for table "papers"
#

DROP TABLE IF EXISTS `papers`;
CREATE TABLE `papers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `testId` int(11) NOT NULL,
  `courseId` int(11) NOT NULL,
  `time` varchar(11) NOT NULL,
  `score` double(11,0) NOT NULL,
  `wrongQueId` varchar(1000) DEFAULT NULL,
  `wrongAns` varchar(1000) DEFAULT NULL,
  `studentId` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

#
# Data for table "papers"
#

INSERT INTO `papers` VALUES (14,2,1,'0分3秒',10,',1,2,3,4,5,6,7,8,9',',null,null,null,null,null,null,null,null,null',1,'2017-06-20 10:42:40'),(15,3,1,'0分3秒',3,',1,2,3,4,5,6,7,8,9,10',',null,null,null,null,null,null,null,null,null,D',1,'2017-06-20 08:07:32'),(16,2,1,'0分3秒',10,',1,2,3,4,5,6,7,8,9',',null,null,null,null,null,null,null,null,null',2,'2017-06-20 10:42:40'),(17,1,1,'0分3秒',5,',1,2,3,4,5,6,7,8,9,10',',null,null,null,null,null,null,null,null,null,D',2,'2017-06-20 08:07:32'),(18,2,1,'0分3秒',9,',1,2,3,4,5,6,7,8,9',',null,null,null,null,null,null,null,null,null',3,'2017-06-20 10:42:40'),(19,15,1,'0分3秒',7,',1,2,3,4,5,6,7,8,9',',null,null,null,null,null,null,null,null,null',5,'2018-01-25 16:07:38'),(27,12,1,'0分8秒',62,'6,7,8','B,B,B',5,'2018-01-26 10:26:54');

#
# Structure for table "questions"
#

DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) NOT NULL,
  `queType` int(11) NOT NULL,
  `queTitle` varchar(2000) NOT NULL,
  `choiceA` varchar(2000) NOT NULL,
  `choiceB` varchar(2000) NOT NULL,
  `choiceC` varchar(2000) NOT NULL,
  `choiceD` varchar(2000) NOT NULL,
  `ans` varchar(50) NOT NULL,
  `queExist` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

#
# Data for table "questions"
#

INSERT INTO `questions` VALUES (1,1,1,'你好吗1？','a','b','c','d','A',1),(2,4,1,'你好吗2？','a','b','c','d','A',1),(3,4,1,'你好吗3？','a','b','c','d','A',1),(4,1,1,'你好吗4？','a','b','c','d','A',1),(5,1,1,'你好吗5？','a','b','c','d','A',1),(6,1,1,'山东理工','a','b','c','d','A',1),(7,1,1,'你好吗？','a','b','c','d','A',1),(8,1,1,'你好吗？','a','b','c','d','A',1),(9,1,1,'你好吗9？','a','b','c','d','A',1),(10,1,1,'你好吗10？','a','b','c','d','A',1),(11,1,1,'你好吗11？','a','b','c','d','A',1),(12,1,1,'山东理工','a','b','c','d','A',1);

#
# Structure for table "stuclass"
#

DROP TABLE IF EXISTS `stuclass`;
CREATE TABLE `stuclass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `deptName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "stuclass"
#

INSERT INTO `stuclass` VALUES (1,'开发2班','开发'),(2,'测试1班','测试'),(3,'开发1班','开发'),(4,'开发4班','开发'),(6,'test测试班','测试');

#
# Structure for table "student"
#

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL COMMENT '学号',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `pwd` varchar(50) NOT NULL COMMENT '密码',
  `school` varchar(50) DEFAULT NULL,
  `deptName` varchar(50) NOT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `born` varchar(255) DEFAULT NULL,
  `classId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "student"
#

INSERT INTO `student` VALUES (1,'王旭','123','山理工','开发','男','2017-06-16',3),(2,'何英2','123','山理工2','开发','女','1998-01-02',4),(3,'王旭2','123','山理工','开发','男','2017-06-16',3),(4,'王旭3','123','山理工','测试','男','2017-06-16',2),(5,'1','123','地方法','开发','男','1980-12-12',1);

#
# Structure for table "teacher"
#

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL COMMENT 'teacher id号',
  `name` varchar(50) NOT NULL COMMENT 'teacher name',
  `pwd` varchar(100) NOT NULL COMMENT 'teacher password',
  `deptName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "teacher"
#

INSERT INTO `teacher` VALUES (1,'1','123','开发'),(2,'yao','123','开发'),(4,'如杰','123','测试'),(5,'瑞祥','yaoyaoyao','开发'),(6,'延波','yaoyaoyao','开发'),(7,'陈帅','yaoyaoyao','开发'),(8,'郭吉楠','yaoyaoyao','开发');

#
# Structure for table "teachercourse"
#

DROP TABLE IF EXISTS `teachercourse`;
CREATE TABLE `teachercourse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teaId` int(11) NOT NULL,
  `courseId` int(11) NOT NULL,
  `classId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

#
# Data for table "teachercourse"
#

INSERT INTO `teachercourse` VALUES (14,8,4,1),(18,4,8,2),(20,5,10,3),(21,5,10,1),(22,7,11,1),(23,7,11,3),(24,8,4,3),(25,5,1,2),(28,2,1,1),(29,1,1,1),(30,1,1,3),(31,1,11,3);

#
# Structure for table "test"
#

DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `courseId` int(11) NOT NULL,
  `endDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `questions` varchar(2000) NOT NULL,
  `teacherId` int(11) NOT NULL,
  `classIds` varchar(2000) NOT NULL,
  `testTime` int(11) NOT NULL,
  `scores` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

#
# Data for table "test"
#

INSERT INTO `test` VALUES (1,'java基础入学试卷',1,'2017-06-20 11:11:11','1,2,3,4,5,6,7,8,9,10',2,'1,3,4',45,'100'),(2,'c基础入学试卷',1,'2017-06-20 11:11:11','1,2,3,4,5,6,7,8,9,10',2,'1,3,4',45,'100'),(8,'2017春天出题',1,'2017-06-20 20:37:50','4,10,2,6,3',2,'3',45,'100'),(9,'2017中期考试',1,'2017-06-21 20:11:55','7,10,2,6,5',2,'1',45,'100'),(10,'2017中期考试 瑞祥',1,'2017-06-22 20:34:10','2,9,1,11,7',1,'1',45,'100'),(11,'java开发测试',1,'2018-01-16 10:33:27','11,6,5,1,7,12,8,10',1,'15,3,2,4,6',45,'100'),(12,'ssm',1,'2018-01-28 15:58:28','11,6,5,1,7,12,8,10',1,'1,3,2,4,6',45,'100'),(13,'adad',1,'2018-01-27 09:51:25','5,10,7,8,1,12,9,11,4,6,',2,'1',45,'10'),(14,'dsada',1,'2018-01-25 11:36:27','9,12,10,6,5,8,4,7,1,11',2,'1',45,'10'),(15,'哒哒哒',1,'2018-01-27 10:19:52','12,8,10,7,1,4,5,6,11,9,',2,'1',45,'10');
