/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : quartz

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-07-10 09:42:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for qrtz_job_clazz
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_clazz`;
CREATE TABLE `qrtz_job_clazz` (
                                  `id` varchar(64) NOT NULL COMMENT '主键',
                                  `clazz` varchar(255) NOT NULL COMMENT '任务类名',
                                  `description` varchar(255) DEFAULT NULL COMMENT '描述',
                                  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
                                  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
                                  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
                                  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
                                  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
                                  `del_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
                                  PRIMARY KEY (`id`),
                                  UNIQUE KEY `KEY_JOB_CLAZZ` (`clazz`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务类表';

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details` (
                                    `id` varchar(64) NOT NULL COMMENT '主键',
                                    `job_name` varchar(255) NOT NULL COMMENT '任务名',
                                    `job_group` varchar(255) NOT NULL COMMENT '任务组',
                                    `job_status` varchar(16) NOT NULL COMMENT '任务状态',
                                    `qrtz_task_clazz` varchar(255) NOT NULL COMMENT '任务类名',
                                    `description` varchar(255) DEFAULT NULL COMMENT '描述',
                                    `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
                                    `create_date` datetime DEFAULT NULL COMMENT '创建时间',
                                    `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
                                    `update_date` datetime DEFAULT NULL COMMENT '更新时间',
                                    `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
                                    `del_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
                                    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务详情表';

-- ----------------------------
-- Table structure for qrtz_job_log
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_log`;
CREATE TABLE `qrtz_job_log` (
                                `id` varchar(64) NOT NULL,
                                `job_group` varchar(255) NOT NULL,
                                `job_name` varchar(255) NOT NULL,
                                `trigger_group` varchar(255) NOT NULL,
                                `trigger_name` varchar(255) NOT NULL,
                                `exec_fire_time` datetime NOT NULL,
                                `exec_status` varchar(16) NOT NULL,
                                `exec_start_time` datetime NOT NULL,
                                `exec_end_time` datetime NOT NULL,
                                `create_date` datetime DEFAULT NULL,
                                `update_date` datetime DEFAULT NULL,
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务日志表';

-- ----------------------------
-- Table structure for qrtz_job_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_triggers`;
CREATE TABLE `qrtz_job_triggers` (
                                     `id` varchar(64) NOT NULL COMMENT '主键',
                                     `trigger_name` varchar(255) NOT NULL COMMENT '触发器名',
                                     `trigger_group` varchar(255) NOT NULL COMMENT '触发器组',
                                     `cron_expression` varchar(200) NOT NULL COMMENT 'cron表达式',
                                     `trigger_status` varchar(16) NOT NULL COMMENT '触发器状态',
                                     `description` varchar(255) DEFAULT NULL COMMENT '描述',
                                     `job_id` varchar(64) NOT NULL,
                                     `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
                                     `create_date` datetime DEFAULT NULL COMMENT '创建时间',
                                     `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
                                     `update_date` datetime DEFAULT NULL COMMENT '更新时间',
                                     `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
                                     `del_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
                                     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务触发器表';
