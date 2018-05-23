/*
Navicat MySQL Data Transfer

Source Server         : Test
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : hostelworld

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-04-12 23:53:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bankaccount`
-- ----------------------------
DROP TABLE IF EXISTS `bankaccount`;
CREATE TABLE `bankaccount` (
  `bankAccount` varchar(255) NOT NULL,
  `balance` double(11,2) DEFAULT NULL,
  PRIMARY KEY (`bankAccount`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bankaccount
-- ----------------------------

-- ----------------------------
-- Table structure for `bookhostel`
-- ----------------------------
DROP TABLE IF EXISTS `bookhostel`;
CREATE TABLE `bookhostel` (
  `bookID` int(11) NOT NULL AUTO_INCREMENT,
  `bookTime` datetime DEFAULT NULL,
  `membershipID` int(7) DEFAULT NULL,
  `hostelID` int(7) DEFAULT NULL,
  `roomCategory` varchar(255) DEFAULT NULL,
  `cost` double(11,2) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  PRIMARY KEY (`bookID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookhostel
-- ----------------------------
INSERT INTO `bookhostel` VALUES ('1', '2017-03-19 00:00:00', '5', '4', 'standardRoom', '100.00', '2017-03-19', '2017-03-21');
INSERT INTO `bookhostel` VALUES ('4', '2017-03-15 00:00:00', '5', '4', 'suiteRoom', '450.00', '2017-03-17', '2017-03-19');
INSERT INTO `bookhostel` VALUES ('5', '2017-03-29 00:00:00', '18', '5', 'suiteRoom', '375.00', '2017-04-01', '2017-04-05');
INSERT INTO `bookhostel` VALUES ('6', '2017-03-29 00:00:00', '27', '8', 'standardRoom', '600.00', '2017-04-02', '2017-04-04');
INSERT INTO `bookhostel` VALUES ('7', '2017-04-12 00:00:00', '5', '4', 'standardRoom', '615.00', '2017-04-12', '2017-04-14');

-- ----------------------------
-- Table structure for `checkapplication`
-- ----------------------------
DROP TABLE IF EXISTS `checkapplication`;
CREATE TABLE `checkapplication` (
  `checkID` int(11) NOT NULL AUTO_INCREMENT,
  `checkingState` int(2) DEFAULT NULL,
  `applyerID` int(7) DEFAULT NULL,
  `applyerName` varchar(255) DEFAULT NULL,
  `applyerPhoneNum` varchar(255) DEFAULT NULL,
  `hostelID` int(7) DEFAULT NULL,
  `hostelName` varchar(255) DEFAULT NULL,
  `hostelProvince` varchar(255) DEFAULT NULL,
  `hostelCity` varchar(255) DEFAULT NULL,
  `hostelAddress` varchar(255) DEFAULT NULL,
  `singleRoomNum` int(11) DEFAULT NULL,
  `standardRoomNum` int(11) DEFAULT NULL,
  `suiteRoomNum` int(11) DEFAULT NULL,
  `hostelbreifintro` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`checkID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of checkapplication
-- ----------------------------
INSERT INTO `checkapplication` VALUES ('1', '2', '4', '羊羊羊', '1826666648154', '4', '五五开真的贼JB丑', '江苏省', '南京市', '鼓楼区', '10', '5', '2', '五五开是真的傻逼！！！');
INSERT INTO `checkapplication` VALUES ('2', '2', '5', '羊羊羊', '1826666666', '5', '杨三洋好帅', '北京市', '北京市市辖区', '朝阳区', '3', '2', '1', '杨三洋是个宝宝，需要抱抱！！！');
INSERT INTO `checkapplication` VALUES ('3', '2', '7', '科比', '18260098583', '7', '科比的客栈', '山东省', '济南市', '槐荫区', '10', '5', '2', '便宜便宜');
INSERT INTO `checkapplication` VALUES ('4', '2', '8', '杨关', '4545454', '8', '杨关dssd', '江西省', '南昌市', '东湖区', '20', '10', '5', 'dsfdsfdsfdsfsd');
INSERT INTO `checkapplication` VALUES ('5', '0', '9', '剩剩', '09876543211', '9', '剩剩大酒店', '江苏省', '苏州市', '姑苏区', '50', '50', '10', '剩剩连锁大酒店');

-- ----------------------------
-- Table structure for `hostel`
-- ----------------------------
DROP TABLE IF EXISTS `hostel`;
CREATE TABLE `hostel` (
  `hostelID` int(7) NOT NULL,
  `hostelName` varchar(255) DEFAULT NULL,
  `hostelProvince` varchar(255) DEFAULT NULL,
  `hostelCity` varchar(255) DEFAULT NULL,
  `hostelAddress` varchar(255) DEFAULT NULL,
  `singleRoomNum` int(11) DEFAULT NULL,
  `standardRoomNum` int(11) DEFAULT NULL,
  `suiteRoomNum` int(11) DEFAULT NULL,
  `hostelbreifintro` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hostelID`),
  CONSTRAINT `ownerID` FOREIGN KEY (`hostelID`) REFERENCES `hostelowner` (`hostelownerID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hostel
-- ----------------------------
INSERT INTO `hostel` VALUES ('1', '杨三洋的店', '江苏省', '南京市', '鼓楼区', '10', '5', '2', '杨三洋');
INSERT INTO `hostel` VALUES ('4', '杨三洋', '江苏省', '南京市', '鼓楼区', '10', '5', '2', '炒鸡实惠的酒店啊！！');
INSERT INTO `hostel` VALUES ('5', '杨三洋的酒店', '北京市', '北京市市辖区', '朝阳区', '3', '2', '1', '很便宜 很实惠');
INSERT INTO `hostel` VALUES ('7', '科比的客栈', '山东省', '济南市', '槐荫区', '10', '5', '2', '便宜便宜');
INSERT INTO `hostel` VALUES ('8', 'aasas', '江西省', '南昌市', '东湖区', '20', '10', '5', 'sadsadsa');

-- ----------------------------
-- Table structure for `hostelaccount`
-- ----------------------------
DROP TABLE IF EXISTS `hostelaccount`;
CREATE TABLE `hostelaccount` (
  `hostelID` int(11) NOT NULL,
  `hostelBalance` double(11,2) DEFAULT NULL,
  PRIMARY KEY (`hostelID`),
  CONSTRAINT `hostelAccount` FOREIGN KEY (`hostelID`) REFERENCES `hostel` (`hostelID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hostelaccount
-- ----------------------------
INSERT INTO `hostelaccount` VALUES ('1', '220.00');
INSERT INTO `hostelaccount` VALUES ('4', '450.00');
INSERT INTO `hostelaccount` VALUES ('5', '375.00');
INSERT INTO `hostelaccount` VALUES ('7', '0.00');
INSERT INTO `hostelaccount` VALUES ('8', '650.00');

-- ----------------------------
-- Table structure for `hostelmanager`
-- ----------------------------
DROP TABLE IF EXISTS `hostelmanager`;
CREATE TABLE `hostelmanager` (
  `managerID` char(8) NOT NULL,
  `managerPassword` varchar(255) NOT NULL,
  `category` int(11) NOT NULL,
  `managerName` varchar(255) NOT NULL,
  `managerSex` varchar(255) NOT NULL,
  `managerPhone` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hostelmanager
-- ----------------------------
INSERT INTO `hostelmanager` VALUES ('JL-00001', '123', '2', '杨关', '男', '18260098583');

-- ----------------------------
-- Table structure for `hostelowner`
-- ----------------------------
DROP TABLE IF EXISTS `hostelowner`;
CREATE TABLE `hostelowner` (
  `hostelownerID` int(7) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `category` int(2) DEFAULT NULL,
  `ownerName` varchar(255) DEFAULT NULL,
  `ownerSex` varchar(255) DEFAULT NULL,
  `phoneNum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hostelownerID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hostelowner
-- ----------------------------
INSERT INTO `hostelowner` VALUES ('1', 'abc', '1', '杨三洋', '女', '18260098583');
INSERT INTO `hostelowner` VALUES ('2', '123456', '1', '杨三洋', '男', '18260095267');
INSERT INTO `hostelowner` VALUES ('3', 'abc', '1', '杨三洋', '男', '1826666666');
INSERT INTO `hostelowner` VALUES ('4', 'uuu', '1', '羊羊羊', '男', '1826666648154');
INSERT INTO `hostelowner` VALUES ('5', 'qqq', '1', '羊羊羊', '男', '1826666666');
INSERT INTO `hostelowner` VALUES ('6', 'www', '1', '羊羊羊', '男', '185447567152');
INSERT INTO `hostelowner` VALUES ('7', 'abc8879623', '1', '科比', '男', '18260098583');
INSERT INTO `hostelowner` VALUES ('8', '8879623', '1', '杨关', '男', '4545454');
INSERT INTO `hostelowner` VALUES ('9', '654321', '1', '剩剩', '男', '09876543211');

-- ----------------------------
-- Table structure for `hostelupdate`
-- ----------------------------
DROP TABLE IF EXISTS `hostelupdate`;
CREATE TABLE `hostelupdate` (
  `updateID` int(11) NOT NULL AUTO_INCREMENT,
  `checkingState` int(11) DEFAULT NULL,
  `applyerID` int(7) DEFAULT NULL,
  `applyerName` varchar(255) DEFAULT NULL,
  `hostelName` varchar(255) DEFAULT NULL,
  `hostelbreif` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`updateID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hostelupdate
-- ----------------------------
INSERT INTO `hostelupdate` VALUES ('1', '1', '4', '羊羊羊', '杨三洋的三陪服务店', '杨三洋人帅屌大速来！');
INSERT INTO `hostelupdate` VALUES ('2', '2', '5', '羊羊羊', '杨三洋帅不帅', '杨三洋还是个宝宝');
INSERT INTO `hostelupdate` VALUES ('3', '2', '5', '羊羊羊', '杨三洋的酒店', '很便宜 很实惠');
INSERT INTO `hostelupdate` VALUES ('4', '2', '8', '杨关', 'aasas', 'sadsadsa');

-- ----------------------------
-- Table structure for `inandout`
-- ----------------------------
DROP TABLE IF EXISTS `inandout`;
CREATE TABLE `inandout` (
  `inID` int(11) NOT NULL AUTO_INCREMENT,
  `hostelID` int(7) NOT NULL,
  `membershipID` int(7) NOT NULL,
  `checkinDate` date DEFAULT NULL,
  `roomID` int(11) DEFAULT NULL,
  PRIMARY KEY (`inID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inandout
-- ----------------------------
INSERT INTO `inandout` VALUES ('5', '4', '5', '2017-03-19', '10');
INSERT INTO `inandout` VALUES ('6', '4', '5', '2017-03-20', '10');
INSERT INTO `inandout` VALUES ('7', '4', '5', '2017-03-21', '10');
INSERT INTO `inandout` VALUES ('8', '8', '27', '2017-04-02', '20');
INSERT INTO `inandout` VALUES ('9', '8', '27', '2017-04-03', '20');
INSERT INTO `inandout` VALUES ('10', '8', '27', '2017-04-04', '20');

-- ----------------------------
-- Table structure for `manageaccount`
-- ----------------------------
DROP TABLE IF EXISTS `manageaccount`;
CREATE TABLE `manageaccount` (
  `hostelID` int(7) DEFAULT NULL,
  `hostelIncome` double(11,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manageaccount
-- ----------------------------
INSERT INTO `manageaccount` VALUES ('4', '615.00');
INSERT INTO `manageaccount` VALUES ('1', '0.00');
INSERT INTO `manageaccount` VALUES ('5', '0.00');
INSERT INTO `manageaccount` VALUES ('7', '0.00');
INSERT INTO `manageaccount` VALUES ('8', '0.00');

-- ----------------------------
-- Table structure for `membership`
-- ----------------------------
DROP TABLE IF EXISTS `membership`;
CREATE TABLE `membership` (
  `membershipID` int(7) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `category` int(2) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `phoneNum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`membershipID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of membership
-- ----------------------------
INSERT INTO `membership` VALUES ('3', 'bbb', '0', '羊羊羊', '女', '18222258584');
INSERT INTO `membership` VALUES ('4', 'abc8879623', '0', '杨关', '男', '18260098583');
INSERT INTO `membership` VALUES ('5', 'abc8879623', '0', '杨关', '男', '18260098583');
INSERT INTO `membership` VALUES ('6', 'abc8879623', '0', '杨关', '男', '18260098583');
INSERT INTO `membership` VALUES ('7', 'abc8879623', '0', '杨关', '男', '18260098583');
INSERT INTO `membership` VALUES ('8', 'abc8879623', '0', '杨关', '男', '18260098583');
INSERT INTO `membership` VALUES ('9', 'abc8879623', '0', '杨关', '男', '18260098583');
INSERT INTO `membership` VALUES ('10', 'abc8879623', '0', '杨关', '男', '18260098583');
INSERT INTO `membership` VALUES ('11', 'abc8879623', '0', '杨关', '男', '18260098583');
INSERT INTO `membership` VALUES ('26', 'abc8879623', '0', '杨关', '男', '18260098583');
INSERT INTO `membership` VALUES ('29', '123456', '0', 'Lizi', '女', '11012013014');
INSERT INTO `membership` VALUES ('30', '123456', '0', 'Lizi', '女', '12345678909');

-- ----------------------------
-- Table structure for `membershipcard`
-- ----------------------------
DROP TABLE IF EXISTS `membershipcard`;
CREATE TABLE `membershipcard` (
  `membershipID` int(7) NOT NULL,
  `qualification` int(11) DEFAULT NULL,
  `bankAccount` varchar(255) DEFAULT NULL,
  `banlance` double(11,2) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `totalPay` double(11,2) DEFAULT NULL,
  `authority` int(11) DEFAULT NULL,
  `credits` int(11) DEFAULT NULL,
  PRIMARY KEY (`membershipID`),
  CONSTRAINT `membershipID` FOREIGN KEY (`membershipID`) REFERENCES `membership` (`membershipID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of membershipcard
-- ----------------------------
INSERT INTO `membershipcard` VALUES ('5', '2', '123456789', '2145.00', '2017-03-15', '2018-03-15', '615.00', '1', '61');
INSERT INTO `membershipcard` VALUES ('6', '2', '8879623', '192.50', '2017-03-19', '2018-03-19', '1012.50', '2', '0');

-- ----------------------------
-- Table structure for `releaseinfo`
-- ----------------------------
DROP TABLE IF EXISTS `releaseinfo`;
CREATE TABLE `releaseinfo` (
  `releaseID` int(11) NOT NULL AUTO_INCREMENT,
  `releaseName` varchar(255) DEFAULT NULL,
  `hostelID` int(7) NOT NULL,
  `hostelName` varchar(255) DEFAULT NULL,
  `hostelProvince` varchar(255) DEFAULT NULL,
  `hostelCity` varchar(255) DEFAULT NULL,
  `singleRoom` double(11,2) DEFAULT NULL,
  `standardRoom` double(11,2) DEFAULT NULL,
  `suiteRoom` double(11,2) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  PRIMARY KEY (`releaseID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of releaseinfo
-- ----------------------------
INSERT INTO `releaseinfo` VALUES ('1', '大优惠啊~~', '4', '五五开真的贼JB丑', '江苏省', '南京市', '50.00', '100.00', '150.00', '2017-03-17', '2017-03-24');
INSERT INTO `releaseinfo` VALUES ('2', '大大大大优惠', '4', '杨三洋', '江苏省', '南京市', '102.00', '202.00', '302.00', '2017-03-29', '2017-04-10');
INSERT INTO `releaseinfo` VALUES ('3', '小优惠', '4', '杨三洋', '江苏省', '南京市', '105.00', '205.00', '305.00', '2017-04-11', '2017-04-20');
INSERT INTO `releaseinfo` VALUES ('4', '杨三洋的优惠大计划', '5', '杨三洋帅不帅', '北京市', '北京市市辖区', '55.00', '65.00', '75.00', '2017-03-31', '2017-04-10');
INSERT INTO `releaseinfo` VALUES ('5', 'jijijiji', '8', 'aasas', '江西省', '南昌市', '50.00', '200.00', '500.00', '2017-04-01', '2017-04-10');

-- ----------------------------
-- Table structure for `room`
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `hostelID` int(7) NOT NULL,
  `roomID` int(11) NOT NULL,
  `isCheckin` int(11) DEFAULT NULL,
  `roomCategory` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hostelID`,`roomID`),
  CONSTRAINT `hostelID` FOREIGN KEY (`hostelID`) REFERENCES `hostel` (`hostelID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('4', '0', '0', 'singleRoom');
INSERT INTO `room` VALUES ('4', '1', '0', 'singleRoom');
INSERT INTO `room` VALUES ('4', '2', '0', 'singleRoom');
INSERT INTO `room` VALUES ('4', '3', '0', 'singleRoom');
INSERT INTO `room` VALUES ('4', '4', '0', 'singleRoom');
INSERT INTO `room` VALUES ('4', '5', '0', 'singleRoom');
INSERT INTO `room` VALUES ('4', '6', '0', 'singleRoom');
INSERT INTO `room` VALUES ('4', '7', '0', 'singleRoom');
INSERT INTO `room` VALUES ('4', '8', '0', 'singleRoom');
INSERT INTO `room` VALUES ('4', '9', '0', 'singleRoom');
INSERT INTO `room` VALUES ('4', '10', '1', 'standardRoom');
INSERT INTO `room` VALUES ('4', '11', '0', 'standardRoom');
INSERT INTO `room` VALUES ('4', '12', '0', 'standardRoom');
INSERT INTO `room` VALUES ('4', '13', '0', 'standardRoom');
INSERT INTO `room` VALUES ('4', '14', '0', 'standardRoom');
INSERT INTO `room` VALUES ('4', '15', '0', 'suiteRoom');
INSERT INTO `room` VALUES ('4', '16', '0', 'suiteRoom');
INSERT INTO `room` VALUES ('5', '0', '0', 'singleRoom');
INSERT INTO `room` VALUES ('5', '1', '0', 'singleRoom');
INSERT INTO `room` VALUES ('5', '2', '0', 'singleRoom');
INSERT INTO `room` VALUES ('5', '3', '0', 'standardRoom');
INSERT INTO `room` VALUES ('5', '4', '0', 'standardRoom');
INSERT INTO `room` VALUES ('5', '5', '0', 'suiteRoom');
INSERT INTO `room` VALUES ('7', '0', '0', 'singleRoom');
INSERT INTO `room` VALUES ('7', '1', '0', 'singleRoom');
INSERT INTO `room` VALUES ('7', '2', '0', 'singleRoom');
INSERT INTO `room` VALUES ('7', '3', '0', 'singleRoom');
INSERT INTO `room` VALUES ('7', '4', '0', 'singleRoom');
INSERT INTO `room` VALUES ('7', '5', '0', 'singleRoom');
INSERT INTO `room` VALUES ('7', '6', '0', 'singleRoom');
INSERT INTO `room` VALUES ('7', '7', '0', 'singleRoom');
INSERT INTO `room` VALUES ('7', '8', '0', 'singleRoom');
INSERT INTO `room` VALUES ('7', '9', '0', 'singleRoom');
INSERT INTO `room` VALUES ('7', '10', '0', 'standardRoom');
INSERT INTO `room` VALUES ('7', '11', '0', 'standardRoom');
INSERT INTO `room` VALUES ('7', '12', '0', 'standardRoom');
INSERT INTO `room` VALUES ('7', '13', '0', 'standardRoom');
INSERT INTO `room` VALUES ('7', '14', '0', 'standardRoom');
INSERT INTO `room` VALUES ('7', '15', '0', 'suiteRoom');
INSERT INTO `room` VALUES ('7', '16', '0', 'suiteRoom');
INSERT INTO `room` VALUES ('8', '0', '2', 'singleRoom');
INSERT INTO `room` VALUES ('8', '1', '0', 'singleRoom');
INSERT INTO `room` VALUES ('8', '2', '0', 'singleRoom');
INSERT INTO `room` VALUES ('8', '3', '0', 'singleRoom');
INSERT INTO `room` VALUES ('8', '4', '0', 'singleRoom');
INSERT INTO `room` VALUES ('8', '5', '0', 'singleRoom');
INSERT INTO `room` VALUES ('8', '6', '0', 'singleRoom');
INSERT INTO `room` VALUES ('8', '7', '0', 'singleRoom');
INSERT INTO `room` VALUES ('8', '8', '0', 'singleRoom');
INSERT INTO `room` VALUES ('8', '9', '0', 'singleRoom');
INSERT INTO `room` VALUES ('8', '10', '0', 'singleRoom');
INSERT INTO `room` VALUES ('8', '11', '0', 'singleRoom');
INSERT INTO `room` VALUES ('8', '12', '0', 'singleRoom');
INSERT INTO `room` VALUES ('8', '13', '0', 'singleRoom');
INSERT INTO `room` VALUES ('8', '14', '0', 'singleRoom');
INSERT INTO `room` VALUES ('8', '15', '0', 'singleRoom');
INSERT INTO `room` VALUES ('8', '16', '0', 'singleRoom');
INSERT INTO `room` VALUES ('8', '17', '0', 'singleRoom');
INSERT INTO `room` VALUES ('8', '18', '0', 'singleRoom');
INSERT INTO `room` VALUES ('8', '19', '0', 'singleRoom');
INSERT INTO `room` VALUES ('8', '20', '0', 'standardRoom');
INSERT INTO `room` VALUES ('8', '21', '0', 'standardRoom');
INSERT INTO `room` VALUES ('8', '22', '0', 'standardRoom');
INSERT INTO `room` VALUES ('8', '23', '0', 'standardRoom');
INSERT INTO `room` VALUES ('8', '24', '0', 'standardRoom');
INSERT INTO `room` VALUES ('8', '25', '0', 'standardRoom');
INSERT INTO `room` VALUES ('8', '26', '0', 'standardRoom');
INSERT INTO `room` VALUES ('8', '27', '0', 'standardRoom');
INSERT INTO `room` VALUES ('8', '28', '0', 'standardRoom');
INSERT INTO `room` VALUES ('8', '29', '0', 'standardRoom');
INSERT INTO `room` VALUES ('8', '30', '0', 'suiteRoom');
INSERT INTO `room` VALUES ('8', '31', '0', 'suiteRoom');
INSERT INTO `room` VALUES ('8', '32', '0', 'suiteRoom');
INSERT INTO `room` VALUES ('8', '33', '0', 'suiteRoom');
INSERT INTO `room` VALUES ('8', '34', '0', 'suiteRoom');

-- ----------------------------
-- Procedure structure for `scheduler_ManageCard`
-- ----------------------------
DROP PROCEDURE IF EXISTS `scheduler_ManageCard`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `scheduler_ManageCard`()
BEGIN

UPDATE membershipcard mem,(SELECT m.membershipID FROM membershipcard AS m WHERE m.endDate = CURDATE() AND m.qualification = 2 AND m.banlance < 0) b SET mem.qualification = 1 , mem.startDate = CURDATE() , mem.endDate = DATE_ADD(CURDATE(),INTERVAL 1 YEAR) WHERE mem.membershipID = b.membershipID;

DELETE FROM membershipcard WHERE membershipID in (SELECT * FROM (SELECT m.membershipID FROM membershipcard m WHERE m.endDate = CURDATE() AND m.qualification = 1) AS a);

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `scheduler_pauseCard`
-- ----------------------------
DROP PROCEDURE IF EXISTS `scheduler_pauseCard`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `scheduler_pauseCard`()
BEGIN

UPDATE membershipcard mem,(SELECT m.membershipID FROM membershipcard AS m WHERE m.endDate = CURDATE() AND m.qualification = 2 AND m.banlance < 0) b SET mem.qualification = 1 WHERE mem.membershipID = b.membershipID;

DELETE FROM membershipcard WHERE membershipID in (SELECT * FROM (SELECT m.membershipID FROM membershipcard m WHERE m.endDate = CURDATE() AND m.qualification = 1) AS a);

END
;;
DELIMITER ;

-- ----------------------------
-- Event structure for `my_scheduler_event`
-- ----------------------------
DROP EVENT IF EXISTS `my_scheduler_event`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` EVENT `my_scheduler_event` ON SCHEDULE EVERY 1 DAY STARTS '2017-03-11 17:09:45' ON COMPLETION NOT PRESERVE ENABLE DO CALL scheduler_ManageCard()
;;
DELIMITER ;
