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

 Date: 28/11/2023 20:25:26
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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '施工人员预约表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of build_appointment
-- ----------------------------
INSERT INTO `build_appointment` VALUES (1, 7, 1, 0, -1, NULL, 'data:image/png;base64,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', 1, 1, '2023-11-27 21:43:43');

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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '长期物流司机登记' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car_long_appointment
-- ----------------------------
INSERT INTO `car_long_appointment` VALUES (4, 7, 'data:image/png;base64,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', '2023-11-27 22:37:53');

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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '长期物流司机进出记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car_long_record
-- ----------------------------
INSERT INTO `car_long_record` VALUES (1, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `car_long_record` VALUES (2, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '临时物流人员预约表' ROW_FORMAT = Dynamic;

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
  `appoint_time` datetime NULL DEFAULT NULL COMMENT '预约时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '普通访客预约表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of common_appointment
-- ----------------------------
INSERT INTO `common_appointment` VALUES (1, 7, 1, 1, '2023-11-16 08:00:00', '2023-11-30 08:00:00', 0, -1, NULL, 'data:image/png;base64,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', '2023-11-27 21:25:27');
INSERT INTO `common_appointment` VALUES (2, 7, 1, 1, '2023-11-01 21:36:12', '2023-11-02 21:36:16', 1, -1, NULL, NULL, '2023-11-27 21:36:28');

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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '童永振', '15295707696', '苏E55BP9', NULL, NULL, '123456', 0, 1);
INSERT INTO `user` VALUES (2, '徐敏杰', '18251328636', '苏A56245', NULL, NULL, '123456', 0, 2);
INSERT INTO `user` VALUES (3, '小李', '13914782259', NULL, NULL, NULL, '123456', 0, 2);
INSERT INTO `user` VALUES (4, '小罗', '13814015365', NULL, NULL, NULL, '123456', 0, 3);
INSERT INTO `user` VALUES (5, '小邹', '15295707698', NULL, NULL, NULL, '123456', 0, 5);
INSERT INTO `user` VALUES (6, '小朱', '15295707694', NULL, NULL, NULL, '123456', 0, 6);
INSERT INTO `user` VALUES (7, '小熊', '13205159515', NULL, 2, NULL, '123456', 1, NULL);

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
  `visite_dept_id` bigint NULL DEFAULT NULL COMMENT '访问的部门id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'VIP访客预约表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vip_appointment
-- ----------------------------
INSERT INTO `vip_appointment` VALUES (9, '苏E123456', 3, '苏科大', '2023-11-28 19:31:43.373', 2);
INSERT INTO `vip_appointment` VALUES (10, '苏D233654', 3, '苏科大', '2023-11-28 20:01:32.23', 2);

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
  `dept_examine_id` bigint NULL DEFAULT NULL COMMENT '申请部门审批者id',
  `code` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '二维码',
  `isgo` int NULL DEFAULT NULL COMMENT '是否离开 0-离开 1-未离开',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'vip审批' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vip_examine
-- ----------------------------
INSERT INTO `vip_examine` VALUES (8, 9, 0, 0, 0, 1, 4, 2, 'data:image/png;base64,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', NULL);
INSERT INTO `vip_examine` VALUES (9, 10, 1, NULL, NULL, NULL, NULL, 2, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
