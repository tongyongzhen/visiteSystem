CREATE TABLE `build_appointment`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint NULL COMMENT '用户id',
  `visite_dept_id` bigint NULL COMMENT '访问的部门id',
  `isagree` int NULL DEFAULT -1 COMMENT '是否同意\r\n0-同意\r\n1-不同意\r\n-1 -未确认',
  `isvisite` int NULL DEFAULT -1 COMMENT '是否到访 0-到访 1-未到访',
  `isgo` int NULL COMMENT '是否离开 0-离开 1-未离开',
  `code` varchar(255) NULL COMMENT '二维码',
  PRIMARY KEY (`id`)
) COMMENT = '施工人员预约表';

CREATE TABLE `car_long_appointment`  (
  `id` int NOT NULL COMMENT 'id',
  `user_id` bigint NULL COMMENT '用户id',
  `code` varchar(255) NULL COMMENT '二维码',
  PRIMARY KEY (`id`)
) COMMENT = '长期物流司机登记';

CREATE TABLE `car_long_record`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `appointment_id` bigint NOT NULL COMMENT '登记id',
  `enter_time` datetime NULL COMMENT '进入时间',
  `go_time` datetime NULL COMMENT '离开时间',
  `examine_id` bigint NULL COMMENT '部门班长id',
  `examine_result` int NULL COMMENT '部门班长审核结果',
  `baoan_id` bigint NULL COMMENT '保安id',
  `baoan_result` int NULL COMMENT '保安审核结果',
  `picture` varchar(255) NULL COMMENT '货物照片',
  PRIMARY KEY (`id`)
) COMMENT = '长期物流司机进出记录';

CREATE TABLE `car_short_appointment`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint NULL COMMENT '用户id',
  `go_out_count` int NULL COMMENT '当天计划进出次数',
  `code` varchar(255) NULL COMMENT '二维码',
  PRIMARY KEY (`id`)
) COMMENT = '临时物流人员预约表';

CREATE TABLE `common_appointment`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int NULL COMMENT '用户id',
  `visite_dept_id` int NULL COMMENT '访问的部门id',
  `visite_employee_id` int NULL COMMENT '被访问人id',
  `visite_start_time` datetime NULL COMMENT '访问开始时间',
  `visite_end_time` datetime NULL COMMENT '访问结束时间',
  `isagree` int NULL DEFAULT -1 COMMENT '是否同意\r\n0-同意\r\n1-不同意\r\n-1 -未确认',
  `isvisite` int NULL DEFAULT -1 COMMENT '是否到访 0-到访 1-未到访',
  `isgo` int NULL COMMENT '是否结束 0-离开 1-未离开',
  `code` varchar(255) NULL COMMENT '二维码',
  PRIMARY KEY (`id`)
) COMMENT = '普通访客预约表';

CREATE TABLE `common_record`  (
  `id` int NOT NULL,
  PRIMARY KEY (`id`)
) COMMENT = '普通访客记录';

CREATE TABLE `dept`  (
  `dept_id` bigint NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `dept_name` varchar(255) NOT NULL COMMENT '部门名称',
  `manager_id` bigint NULL COMMENT '部门经理id',
  PRIMARY KEY (`dept_id`)
) COMMENT = '部门表';

CREATE TABLE `employee`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '成员id',
  `name` varchar(10) NULL COMMENT '姓名',
  `phone` varchar(11) NULL COMMENT '手机号',
  `dept_id` bigint NULL COMMENT '所属部门id',
  PRIMARY KEY (`id`)
) COMMENT = '员工表';

CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(255) NULL COMMENT '姓名',
  `phone` char(11) NULL COMMENT '手机号',
  `carnum` char(7) NULL COMMENT '车牌号',
  `type` int NOT NULL DEFAULT 0 COMMENT '0-普通访客\r\n1-VIP，行政访客\r\n2-物流司机，长期\r\n3-物流司机，临时\r\n4-施工人员',
  `company` varchar(255) NULL COMMENT '所属公司',
  `password` varchar(255) NULL COMMENT '密码',
  `is_employee` int NULL COMMENT '是否为内部人员 0-是 1-否',
  `dept_id` bigint NULL COMMENT '内部人员所属的部门id',
  PRIMARY KEY (`id`)
) COMMENT = '用户表';

CREATE TABLE `vip_appointment`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '预约id',
  `carnum` varchar(255) NULL COMMENT '车牌号',
  `visite_employee_id` bigint NOT NULL COMMENT '被访问人id',
  PRIMARY KEY (`id`)
) COMMENT = 'VIP访客预约表';

CREATE TABLE `vip_examine`  (
  `id` int NOT NULL COMMENT 'id',
  `appointment_id` int NULL COMMENT '预约id',
  `visite_dept_opinion` int NULL COMMENT '申请部门意见 0-同意 1-不同意',
  `renshi_opinion` int NULL COMMENT '人事部门意见 0-同意 1-不同意',
  `manage_opinion` int NULL COMMENT '总经理意见 0-同意 1-不同意',
  `manage_id` bigint NULL COMMENT '总经理id',
  `renshi_id` bigint NULL COMMENT '人事id',
  `visite_dept_id` bigint NULL COMMENT '申请部门id',
  `code` varchar(255) NULL COMMENT '二维码',
  `isgo` int NULL COMMENT '是否离开 0-离开 1-未离开',
  PRIMARY KEY (`id`)
) COMMENT = 'vip审批';

ALTER TABLE `dept` ADD FOREIGN KEY (`manager_id`) REFERENCES `employee` (`id`);

