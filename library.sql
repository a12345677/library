/*
Navicat MySQL Data Transfer

Source Server         : admin
Source Server Version : 80027
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 80027
File Encoding         : 65001

Date: 2022-02-05 01:50:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `sales` int DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `img_path` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES ('3', '怎样拐跑别人的媳妇', '68', '龙伍', '99999', '52222', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('4', '木虚肉盖饭', '16', '小胖', '1000', '50', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('5', 'C++编程思想', '46', '刚哥', '14', '95', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('6', '蛋炒饭', '10', '周星星', '12', '53', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('7', '赌神', '67', '龙伍', '125', '535', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('8', 'Java编程思想', '100', '阳哥', '47', '36', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('9', 'JavaScript从入门到精通', '10', '婷姐', '85', '95', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('10', 'cocos2d-x游戏编程入门', '49', '国哥', '52', '62', 'static/img/default.jpg');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `order_id` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL,
  `total_money` decimal(11,2) NOT NULL,
  `status` int NOT NULL DEFAULT '0',
  `user_id` int NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `total_money` decimal(11,2) DEFAULT NULL,
  `count` int NOT NULL,
  `order_id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `t_order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_order_item
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '11', '22', '123');
INSERT INTO `t_user` VALUES ('15', '1', 'asd123', '123@qq.com');
INSERT INTO `t_user` VALUES ('16', 'aaaa', 'asd123', '123@qq.com');
INSERT INTO `t_user` VALUES ('17', '111', 'asd111', '123@qq.com');
INSERT INTO `t_user` VALUES ('18', 'aaasss', 'asd123', '111@qq.com');
INSERT INTO `t_user` VALUES ('20', '1111', 'asd111', '123456@qq.com');
INSERT INTO `t_user` VALUES ('22', '11111', '111lll', '111@qq.com');
INSERT INTO `t_user` VALUES ('23', '112', '1122aa', '123@qqq.com');
INSERT INTO `t_user` VALUES ('24', '123', '111www', '111@qq.com');
INSERT INTO `t_user` VALUES ('25', '44', '12345aaa', '12345@qq.com');
INSERT INTO `t_user` VALUES ('26', '444', '444lll', '123@qq.com');
INSERT INTO `t_user` VALUES ('27', '777', '777lll', '777@qq.com');
INSERT INTO `t_user` VALUES ('28', '112233', '123123www', '1122@qq.com');
INSERT INTO `t_user` VALUES ('29', '1122', '1122ww', '112qq.com');
INSERT INTO `t_user` VALUES ('30', '11223', '1122ww', '112qq.com');
INSERT INTO `t_user` VALUES ('31', '112234', '1122ww', '112qq.com');
INSERT INTO `t_user` VALUES ('32', '1133', '1122ww', '11qq.com');
INSERT INTO `t_user` VALUES ('33', '12345', '123qq', '123@qq.com');
INSERT INTO `t_user` VALUES ('43', '11122', '123ww', '11QQ@qq.com');
