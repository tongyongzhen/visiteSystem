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

 Date: 26/11/2023 22:07:39
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
  `appoint_time` datetime NULL DEFAULT NULL COMMENT '预约时间',
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
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  `code` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '二维码',
  `appoint_time` datetime NULL DEFAULT NULL COMMENT '预约时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '长期物流司机登记' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car_long_appointment
-- ----------------------------
INSERT INTO `car_long_appointment` VALUES (3, 7, 'data:image/png;base64,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', NULL);

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
INSERT INTO `car_long_record` VALUES (1, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for car_short_appointment
-- ----------------------------
DROP TABLE IF EXISTS `car_short_appointment`;
CREATE TABLE `car_short_appointment`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  `go_out_count` int NULL DEFAULT NULL COMMENT '当天计划进出次数',
  `code` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '二维码',
  `appoint_time` datetime NULL DEFAULT NULL COMMENT '预约时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '临时物流人员预约表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car_short_appointment
-- ----------------------------
INSERT INTO `car_short_appointment` VALUES (5, 7, 3, 'data:image/png;base64,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', '2023-11-26 19:35:00');

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
  `appoint_time` datetime NULL DEFAULT NULL COMMENT '预约时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '普通访客预约表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of common_appointment
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
INSERT INTO `dept` VALUES (1, '董事部', 1);
INSERT INTO `dept` VALUES (2, '开发部', 2);
INSERT INTO `dept` VALUES (3, '人事部', 4);
INSERT INTO `dept` VALUES (5, '保卫部', 5);
INSERT INTO `dept` VALUES (6, '物流部', 6);

-- ----------------------------
-- Table structure for enter_record
-- ----------------------------
DROP TABLE IF EXISTS `enter_record`;
CREATE TABLE `enter_record`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  `enter_time` datetime NULL DEFAULT NULL COMMENT '进入时间',
  `out_time` datetime NULL DEFAULT NULL COMMENT '离场时间',
  `carnum` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车牌号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '访客进出厂记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of enter_record
-- ----------------------------

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
INSERT INTO `user` VALUES (4, '小罗', '13814015365', NULL, NULL, NULL, '123456', 0, 3);
INSERT INTO `user` VALUES (5, '小邹', '15295707698', NULL, NULL, NULL, '123456', 0, 5);
INSERT INTO `user` VALUES (6, '小朱', '15295707694', NULL, NULL, NULL, '123456', 0, 6);
INSERT INTO `user` VALUES (7, '小熊', '13205159515', NULL, 3, NULL, '123456', 1, NULL);

-- ----------------------------
-- Table structure for vip_appointment
-- ----------------------------
DROP TABLE IF EXISTS `vip_appointment`;
CREATE TABLE `vip_appointment`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '预约id',
  `carnum` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车牌号',
  `visite_employee_id` bigint NOT NULL COMMENT '被访问人id',
  `company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '来访单位',
  `appoint_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '预约时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'VIP访客预约表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vip_appointment
-- ----------------------------
INSERT INTO `vip_appointment` VALUES (5, '苏E13565', 1, '苏科大', '2023-11-26 22:03:42.842');

-- ----------------------------
-- Table structure for vip_examine
-- ----------------------------
DROP TABLE IF EXISTS `vip_examine`;
CREATE TABLE `vip_examine`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
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
INSERT INTO `vip_examine` VALUES (2, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `vip_examine` VALUES (3, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `vip_examine` VALUES (4, 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
