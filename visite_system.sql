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

 Date: 26/11/2023 11:41:18
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
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  `code` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '二维码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '长期物流司机登记' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car_long_appointment
-- ----------------------------
INSERT INTO `car_long_appointment` VALUES (3, 7, 'data:image/png;base64,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');

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '临时物流人员预约表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car_short_appointment
-- ----------------------------
INSERT INTO `car_short_appointment` VALUES (3, 1, 2, 'data:image/png;base64,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');
INSERT INTO `car_short_appointment` VALUES (4, 7, 2, 'data:image/png;base64,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');

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
  `visite_dept_id` bigint NULL DEFAULT NULL COMMENT '访问部门id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'VIP访客预约表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vip_appointment
-- ----------------------------
INSERT INTO `vip_appointment` VALUES (3, '苏E56245', 1, '苏科大', NULL);

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

SET FOREIGN_KEY_CHECKS = 1;
