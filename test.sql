/*
Navicat MySQL Data Transfer

Source Server         : yh
Source Server Version : 50523
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50523
File Encoding         : 65001

Date: 2017-01-02 20:07:34
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `card`
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `account` int(40) NOT NULL AUTO_INCREMENT,
  `pwd` varchar(20) NOT NULL,
  `money` float NOT NULL DEFAULT '0',
  `phone` varchar(40) DEFAULT NULL,
  `name` varchar(40) NOT NULL,
  `usess` varchar(40) NOT NULL DEFAULT 'yes',
  `id` varchar(50) NOT NULL,
  `pmoney` float(50,0) NOT NULL DEFAULT '0',
  PRIMARY KEY (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=222230 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('123450', '222222', '16121', '18711755965', 'yh', 'no', '11111111', '70');
INSERT INTO `card` VALUES ('123451', '111111', '400', '18711755966', 'qq', 'yes', '11111111', '50');
INSERT INTO `card` VALUES ('123454', '111111', '10790', '18731202665', 'xr', 'yes', '11111111', '100');
INSERT INTO `card` VALUES ('123455', '111111', '1544', '18711755961', 'wj', 'yes', '11111111', '20');
INSERT INTO `card` VALUES ('123456', '222222', '100', '18711755962', 'cjy', 'yes', '11111111', '32');
INSERT INTO `card` VALUES ('123457', '111111', '1040', '11111111111r', 'ab', 'yes', '11111111', '0');
INSERT INTO `card` VALUES ('123458', '111111', '10059', '18711755963', 'li', 'yes', '11111111', '0');
INSERT INTO `card` VALUES ('123459', '111111', '716', '11111111111', 'baiduren', 'yes', '11111111', '0');
INSERT INTO `card` VALUES ('123460', '111111', '198', '11111111111', 'xingzou', 'yes', '11111111', '0');
INSERT INTO `card` VALUES ('222222', '222222', '0', '22222222222', 'hm', 'yes', '22222222', '88');
INSERT INTO `card` VALUES ('222225', '111111', '0', '11111111111', '1', 'yes', '11111111', '76');
INSERT INTO `card` VALUES ('222226', '111111', '0', '11111111111', '1', 'yes', '11111111', '56');
INSERT INTO `card` VALUES ('222228', '111111', '0', '11111111111', '1', 'yes', '11111111', '66');
INSERT INTO `card` VALUES ('222229', '111111', '0', '11111111111', '1', 'yes', '11111111', '66');

-- ----------------------------
-- Table structure for `mcard`
-- ----------------------------
DROP TABLE IF EXISTS `mcard`;
CREATE TABLE `mcard` (
  `account` int(40) NOT NULL AUTO_INCREMENT,
  `pwd` varchar(40) NOT NULL,
  `id` int(11) DEFAULT NULL,
  `money` float(40,0) NOT NULL DEFAULT '0',
  `name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=567891 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mcard
-- ----------------------------
INSERT INTO `mcard` VALUES ('567890', '111111', '111', '0', '111');

-- ----------------------------
-- Table structure for `mingxi`
-- ----------------------------
DROP TABLE IF EXISTS `mingxi`;
CREATE TABLE `mingxi` (
  `time` datetime NOT NULL,
  `type` varchar(40) NOT NULL,
  `account` int(11) NOT NULL,
  `money` float NOT NULL,
  `num` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=213 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mingxi
-- ----------------------------
INSERT INTO `mingxi` VALUES ('2016-12-28 22:34:30', 'take', '123450', '100', '148');
INSERT INTO `mingxi` VALUES ('2016-12-28 22:34:37', 'Communi', '123450', '10', '149');
INSERT INTO `mingxi` VALUES ('2016-12-28 22:34:50', 'save', '123450', '100', '150');
INSERT INTO `mingxi` VALUES ('2016-12-29 10:11:58', 'take', '123450', '100', '151');
INSERT INTO `mingxi` VALUES ('2016-12-29 10:15:04', 'take', '123450', '100', '152');
INSERT INTO `mingxi` VALUES ('2016-12-29 10:15:26', 'save', '123450', '100', '153');
INSERT INTO `mingxi` VALUES ('2016-12-29 10:15:37', 'Tranfer', '123450', '100', '154');
INSERT INTO `mingxi` VALUES ('2016-12-29 10:15:37', 'Transfered', '123454', '100', '155');
INSERT INTO `mingxi` VALUES ('2016-12-29 10:16:20', 'Communi', '123450', '10', '156');
INSERT INTO `mingxi` VALUES ('2016-12-29 10:16:33', 'Donate', '123450', '10', '157');
INSERT INTO `mingxi` VALUES ('2016-12-29 10:16:33', 'Donated', '123454', '10', '158');
INSERT INTO `mingxi` VALUES ('2016-12-29 10:16:44', 'Baiduren', '123450', '88', '159');
INSERT INTO `mingxi` VALUES ('2016-12-29 10:16:44', 'Baidurened', '123459', '88', '160');
INSERT INTO `mingxi` VALUES ('2016-12-29 10:29:52', 'Communi', '123450', '10', '161');
INSERT INTO `mingxi` VALUES ('2016-12-29 10:38:39', 'Communi', '123450', '10', '162');
INSERT INTO `mingxi` VALUES ('2016-12-29 10:42:09', 'Communi', '123450', '10', '163');
INSERT INTO `mingxi` VALUES ('2016-12-29 10:52:42', 'take', '123450', '100', '164');
INSERT INTO `mingxi` VALUES ('2016-12-29 10:52:50', 'save', '123450', '100', '165');
INSERT INTO `mingxi` VALUES ('2016-12-29 10:53:05', 'Tranfer', '123450', '100', '166');
INSERT INTO `mingxi` VALUES ('2016-12-29 10:53:05', 'Transfered', '123454', '100', '167');
INSERT INTO `mingxi` VALUES ('2016-12-29 10:53:22', 'Communi', '123450', '10', '168');
INSERT INTO `mingxi` VALUES ('2016-12-29 10:58:29', 'save', '123450', '200', '169');
INSERT INTO `mingxi` VALUES ('2016-12-30 13:37:02', 'take', '123450', '100', '170');
INSERT INTO `mingxi` VALUES ('2016-12-30 13:37:06', 'save', '123450', '200', '171');
INSERT INTO `mingxi` VALUES ('2016-12-30 13:37:23', 'Donate', '123450', '0', '172');
INSERT INTO `mingxi` VALUES ('2016-12-30 13:37:23', 'Donated', '123458', '0', '173');
INSERT INTO `mingxi` VALUES ('2016-12-30 13:37:35', 'Donate', '123450', '10', '174');
INSERT INTO `mingxi` VALUES ('2016-12-30 13:37:35', 'Donated', '123458', '10', '175');
INSERT INTO `mingxi` VALUES ('2016-12-30 13:37:45', 'Baiduren', '123450', '88', '176');
INSERT INTO `mingxi` VALUES ('2016-12-30 13:37:45', 'Baidurened', '123459', '88', '177');
INSERT INTO `mingxi` VALUES ('2016-12-30 14:29:36', 'take', '123450', '100', '178');
INSERT INTO `mingxi` VALUES ('2016-12-30 14:31:52', 'save', '123450', '100', '179');
INSERT INTO `mingxi` VALUES ('2016-12-30 14:32:04', 'Tranfer', '123450', '200', '180');
INSERT INTO `mingxi` VALUES ('2016-12-30 14:32:04', 'Transfered', '123454', '200', '181');
INSERT INTO `mingxi` VALUES ('2016-12-30 14:32:25', 'Communi', '123450', '10', '182');
INSERT INTO `mingxi` VALUES ('2016-12-30 14:32:38', 'Donate', '123450', '10', '183');
INSERT INTO `mingxi` VALUES ('2016-12-30 14:32:38', 'Donated', '123455', '10', '184');
INSERT INTO `mingxi` VALUES ('2016-12-30 14:32:46', 'Baiduren', '123450', '88', '185');
INSERT INTO `mingxi` VALUES ('2016-12-30 14:32:46', 'Baidurened', '123459', '88', '186');
INSERT INTO `mingxi` VALUES ('2016-12-30 15:59:43', 'take', '123450', '100', '187');
INSERT INTO `mingxi` VALUES ('2016-12-30 16:00:01', 'save', '123450', '100', '188');
INSERT INTO `mingxi` VALUES ('2016-12-30 16:00:15', 'Tranfer', '123450', '100', '189');
INSERT INTO `mingxi` VALUES ('2016-12-30 16:00:15', 'Transfered', '123454', '100', '190');
INSERT INTO `mingxi` VALUES ('2016-12-30 16:00:31', 'Communi', '123450', '10', '191');
INSERT INTO `mingxi` VALUES ('2016-12-30 16:00:45', 'Donate', '123450', '10', '192');
INSERT INTO `mingxi` VALUES ('2016-12-30 16:00:45', 'Donated', '123455', '10', '193');
INSERT INTO `mingxi` VALUES ('2016-12-30 16:00:53', 'Baiduren', '123450', '88', '194');
INSERT INTO `mingxi` VALUES ('2016-12-30 16:00:53', 'Baidurened', '123459', '88', '195');
INSERT INTO `mingxi` VALUES ('2016-12-30 16:52:29', 'Tranfer', '123450', '111', '196');
INSERT INTO `mingxi` VALUES ('2016-12-30 16:52:29', 'Transfered', '123454', '111', '197');
INSERT INTO `mingxi` VALUES ('2016-12-30 16:53:51', 'Donate', '123450', '10', '198');
INSERT INTO `mingxi` VALUES ('2016-12-30 16:53:51', 'Donated', '123455', '10', '199');
INSERT INTO `mingxi` VALUES ('2016-12-30 16:56:21', 'Baiduren', '123450', '88', '200');
INSERT INTO `mingxi` VALUES ('2016-12-30 16:56:21', 'Baidurened', '123459', '88', '201');
INSERT INTO `mingxi` VALUES ('2017-01-01 00:29:49', 'save', '123456', '500', '202');
INSERT INTO `mingxi` VALUES ('2017-01-01 00:30:40', 'take', '123456', '200', '203');
INSERT INTO `mingxi` VALUES ('2017-01-01 00:30:51', 'Tranfer', '123456', '1000', '204');
INSERT INTO `mingxi` VALUES ('2017-01-01 00:30:51', 'Transfered', '123457', '1000', '205');
INSERT INTO `mingxi` VALUES ('2017-01-01 00:31:37', 'Communi', '123456', '10', '206');
INSERT INTO `mingxi` VALUES ('2017-01-01 00:32:23', 'Donate', '123456', '10', '207');
INSERT INTO `mingxi` VALUES ('2017-01-01 00:32:23', 'Donated', '123458', '10', '208');
INSERT INTO `mingxi` VALUES ('2017-01-01 00:33:07', 'Baiduren', '123456', '88', '209');
INSERT INTO `mingxi` VALUES ('2017-01-01 00:33:07', 'Baidurened', '123459', '88', '210');
INSERT INTO `mingxi` VALUES ('2017-01-01 00:33:38', 'Xingzou', '123456', '0', '211');
INSERT INTO `mingxi` VALUES ('2017-01-01 00:33:38', 'Xingzoued', '123460', '0', '212');
