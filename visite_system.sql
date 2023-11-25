/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : visite_system

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 25/11/2023 22:53:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for build_appointment
-- ----------------------------
DROP TABLE IF EXISTS `build_appointment`;
CREATE TABLE `build_appointment`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  `visite_dept_id` bigint NULL DEFAULT NULL COMMENT '访问的部门id',
  `isagree` int NULL DEFAULT -1 COMMENT '是否同意\r\n0-同意\r\n1-不同意\r\n-1 -未确认',
  `isvisite` int NULL DEFAULT -1 COMMENT '是否到访 0-到访 1-未到访',
  `isgo` int NULL DEFAULT NULL COMMENT '是否离开 0-离开 1-未离开',
  `code` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '二维码',
  `examiner_id` bigint NULL DEFAULT NULL COMMENT '审核人员id',
  `visite_employee_id` bigint NOT NULL COMMENT '被访问人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '施工人员预约表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of build_appointment
-- ----------------------------

-- ----------------------------
-- Table structure for car_long_appointment
-- ----------------------------
DROP TABLE IF EXISTS `car_long_appointment`;
CREATE TABLE `car_long_appointment`  (
  `id` int NOT NULL COMMENT 'id',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  `code` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '二维码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '长期物流司机登记' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car_long_appointment
-- ----------------------------

-- ----------------------------
-- Table structure for car_long_record
-- ----------------------------
DROP TABLE IF EXISTS `car_long_record`;
CREATE TABLE `car_long_record`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `appointment_id` bigint NOT NULL COMMENT '登记id',
  `enter_time` datetime NULL DEFAULT NULL COMMENT '进入时间',
  `go_time` datetime NULL DEFAULT NULL COMMENT '离开时间',
  `examine_id` bigint NULL DEFAULT NULL COMMENT '部门班长id',
  `examine_result` int NULL DEFAULT NULL COMMENT '部门班长审核结果',
  `baoan_id` bigint NULL DEFAULT NULL COMMENT '保安id',
  `baoan_result` int NULL DEFAULT NULL COMMENT '保安审核结果',
  `picture` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '货物照片',
  `cameraman_id` bigint NULL DEFAULT NULL COMMENT '拍摄人员id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '长期物流司机进出记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car_long_record
-- ----------------------------

-- ----------------------------
-- Table structure for car_short_appointment
-- ----------------------------
DROP TABLE IF EXISTS `car_short_appointment`;
CREATE TABLE `car_short_appointment`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  `go_out_count` int NULL DEFAULT NULL COMMENT '当天计划进出次数',
  `code` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '二维码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '临时物流人员预约表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car_short_appointment
-- ----------------------------

-- ----------------------------
-- Table structure for car_short_record
-- ----------------------------
DROP TABLE IF EXISTS `car_short_record`;
CREATE TABLE `car_short_record`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `appointment_id` bigint NOT NULL COMMENT '登记id',
  `enter_time` datetime NULL DEFAULT NULL COMMENT '进入时间',
  `go_time` datetime NULL DEFAULT NULL COMMENT '离开时间',
  `examine_id` bigint NULL DEFAULT NULL COMMENT '部门班长id',
  `examine_result` int NULL DEFAULT NULL COMMENT '部门班长审核结果',
  `baoan_id` bigint NULL DEFAULT NULL COMMENT '保安id',
  `baoan_result` int NULL DEFAULT NULL COMMENT '保安审核结果',
  `picture` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '货物照片',
  `cameraman_id` bigint NULL DEFAULT NULL COMMENT '拍摄人员id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '长期物流司机进出记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car_short_record
-- ----------------------------

-- ----------------------------
-- Table structure for common_appointment
-- ----------------------------
DROP TABLE IF EXISTS `common_appointment`;
CREATE TABLE `common_appointment`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  `visite_dept_id` bigint NULL DEFAULT NULL COMMENT '访问的部门id',
  `visite_employee_id` bigint NULL DEFAULT NULL COMMENT '被访问人id',
  `visite_start_time` datetime NULL DEFAULT NULL COMMENT '访问开始时间',
  `visite_end_time` datetime NULL DEFAULT NULL COMMENT '访问结束时间',
  `isagree` int NULL DEFAULT -1 COMMENT '是否同意\r\n0-同意\r\n1-不同意\r\n-1 -未确认',
  `isvisite` int NULL DEFAULT -1 COMMENT '是否到访 0-到访 1-未到访',
  `isgo` int NULL DEFAULT NULL COMMENT '是否结束 0-离开 1-未离开',
  `code` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '二维码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '普通访客预约表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of common_appointment
-- ----------------------------

-- ----------------------------
-- Table structure for common_record
-- ----------------------------
DROP TABLE IF EXISTS `common_record`;
CREATE TABLE `common_record`  (
  `id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '普通访客记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of common_record
-- ----------------------------

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `dept_id` bigint NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `dept_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '部门名称',
  `manager_id` bigint NULL DEFAULT NULL COMMENT '部门经理id',
  PRIMARY KEY (`dept_id`) USING BTREE,
  INDEX `manager_id`(`manager_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '董事部', NULL);
INSERT INTO `dept` VALUES (2, '开发部', NULL);
INSERT INTO `dept` VALUES (3, '人事部', NULL);
INSERT INTO `dept` VALUES (4, '宣传部', NULL);
INSERT INTO `dept` VALUES (5, '保卫部', NULL);
INSERT INTO `dept` VALUES (6, '采购部', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `carnum` char(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车牌号',
  `type` int NULL DEFAULT NULL COMMENT '0-普通访客\r\n1-VIP，行政访客\r\n2-物流司机，长期\r\n3-物流司机，临时\r\n4-施工人员',
  `company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所属公司',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `is_employee` int NULL DEFAULT 1 COMMENT '是否为内部人员 0-是 1-否',
  `dept_id` bigint NULL DEFAULT NULL COMMENT '内部人员所属的部门id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '童永振', '15295707696', '苏E55BP9', NULL, NULL, '123456', 0, 1);
INSERT INTO `user` VALUES (2, '徐敏杰', '18251328636', '苏A56245', NULL, NULL, '123456', 0, 2);
INSERT INTO `user` VALUES (3, '小李', '13914782259', NULL, NULL, NULL, '123456', 0, 3);
INSERT INTO `user` VALUES (4, '小罗', '13814015365', NULL, NULL, NULL, '123456', 0, 4);
INSERT INTO `user` VALUES (5, '小邹', '15295707698', NULL, NULL, NULL, '123456', 0, 5);
INSERT INTO `user` VALUES (6, '小朱', '15295707694', NULL, NULL, NULL, '123456', 0, 6);

-- ----------------------------
-- Table structure for vip_appointment
-- ----------------------------
DROP TABLE IF EXISTS `vip_appointment`;
CREATE TABLE `vip_appointment`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '预约id',
  `carnum` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车牌号',
  `visite_employee_id` bigint NOT NULL COMMENT '被访问人id',
  `company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '来访单位',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'VIP访客预约表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vip_appointment
-- ----------------------------

-- ----------------------------
-- Table structure for vip_examine
-- ----------------------------
DROP TABLE IF EXISTS `vip_examine`;
CREATE TABLE `vip_examine`  (
  `id` int NOT NULL COMMENT 'id',
  `appointment_id` bigint NULL DEFAULT NULL COMMENT '预约id',
  `visite_dept_opinion` int NULL DEFAULT NULL COMMENT '申请部门意见 0-同意 1-不同意',
  `renshi_opinion` int NULL DEFAULT NULL COMMENT '人事部门意见 0-同意 1-不同意',
  `manage_opinion` int NULL DEFAULT NULL COMMENT '总经理意见 0-同意 1-不同意',
  `manage_id` bigint NULL DEFAULT NULL COMMENT '总经理id',
  `renshi_id` bigint NULL DEFAULT NULL COMMENT '人事id',
  `visite_dept_id` bigint NULL DEFAULT NULL COMMENT '申请部门id',
  `code` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '二维码',
  `isgo` int NULL DEFAULT NULL COMMENT '是否离开 0-离开 1-未离开',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'vip审批' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vip_examine
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
