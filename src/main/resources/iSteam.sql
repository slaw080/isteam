/*
Navicat MySQL Data Transfer

Source Server         : 商保通开发数据库
Source Server Version : 50720
Source Host           : 192.168.7.69:3306
Source Database       : iSteam

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-11-12 17:33:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for biz_log
-- ----------------------------
DROP TABLE IF EXISTS `biz_log`;
CREATE TABLE `biz_log` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `USERNAME` varchar(50) DEFAULT NULL COMMENT '操作用户',
  `OPERATION` text COMMENT '操作内容',
  `TIME` decimal(11,0) DEFAULT NULL COMMENT '耗时',
  `METHOD` text COMMENT '操作方法',
  `PARAMS` text COMMENT '方法参数',
  `IP` varchar(64) DEFAULT NULL COMMENT '操作者IP',
  `STATUS` char(1) NOT NULL,
  `EXCEPTION_TYPE` varchar(50) DEFAULT NULL COMMENT '异常类型',
  `STACKTRACE` varchar(2000) DEFAULT NULL COMMENT '堆栈',
  `DESCRIPTION` varchar(255) DEFAULT NULL COMMENT '异常描述',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `LOCATION` varchar(50) DEFAULT NULL COMMENT '操作地点',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1074 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of biz_log
-- ----------------------------
INSERT INTO `biz_log` VALUES ('1072', 'zhongan', '{业务操作}:获取患者基本信息', '4748', 'com.bjgoodwill.isteam.Business.service.impl.BizServiceImpl.getPatientInfo()', 'string: \"hello \"', '127.0.0.1', '1', 'class java.lang.NullPointerException', '[MethodName:com.bjgoodwill.isteam.Business.service.impl.BizServiceImpl.getPatientInfo LineNumber:22\n, MethodName:com.bjgoodwill.isteam.common.aspect.BizLogAspect.around LineNumber:59\n, MethodName:com.bjgoodwill.isteam.Business.controller.BizController.getPatientInfo LineNumber:29\n, MethodName:com.bjgoodwill.isteam.common.xss.XssFilter.doFilter LineNumber:52\n]', null, '2018-11-12 17:32:24', '内网IP|0|0|内网IP|内网IP');
INSERT INTO `biz_log` VALUES ('1073', 'zhongan', '{业务操作}:获取患者基本信息', '2', 'com.bjgoodwill.isteam.Business.service.impl.BizServiceImpl.getPatientInfo()', 'string: \"hello \"', '127.0.0.1', '1', 'class java.lang.Exception', '[MethodName:com.bjgoodwill.isteam.common.util.WebServiceUtils.WebServiceUtils LineNumber:13\n, MethodName:com.bjgoodwill.isteam.Business.service.impl.BizServiceImpl.getPatientInfo LineNumber:20\n, MethodName:com.bjgoodwill.isteam.common.aspect.BizLogAspect.around LineNumber:59\n, MethodName:com.bjgoodwill.isteam.Business.controller.BizController.getPatientInfo LineNumber:29\n, MethodName:com.bjgoodwill.isteam.common.xss.XssFilter.doFilter LineNumber:52\n]', 'web Service 调用失败', '2018-11-12 17:33:09', '内网IP|0|0|内网IP|内网IP');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `DEPT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `PARENT_ID` bigint(20) NOT NULL COMMENT '上级部门ID',
  `DEPT_NAME` varchar(100) NOT NULL COMMENT '部门名称',
  `ORDER_NUM` bigint(20) DEFAULT NULL COMMENT '排序',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`DEPT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', '0', '开发部', null, '2018-01-04 15:42:26');
INSERT INTO `sys_dept` VALUES ('2', '1', '开发一部', null, '2018-01-04 15:42:34');
INSERT INTO `sys_dept` VALUES ('3', '1', '开发二部', null, '2018-01-04 15:42:29');
INSERT INTO `sys_dept` VALUES ('4', '0', '市场部', null, '2018-01-04 15:42:36');
INSERT INTO `sys_dept` VALUES ('5', '0', '人事部', null, '2018-01-04 15:42:32');
INSERT INTO `sys_dept` VALUES ('6', '0', '测试部', null, '2018-01-04 15:42:38');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `DICT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典ID',
  `KEYY` bigint(20) NOT NULL COMMENT '键',
  `VALUEE` varchar(100) NOT NULL COMMENT '值',
  `FIELD_NAME` varchar(100) NOT NULL COMMENT '字段名称',
  `TABLE_NAME` varchar(100) NOT NULL COMMENT '表名',
  PRIMARY KEY (`DICT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('1', '0', '男', 'ssex', 'sys_user');
INSERT INTO `sys_dict` VALUES ('2', '1', '女', 'ssex', 'sys_user');
INSERT INTO `sys_dict` VALUES ('3', '2', '保密', 'ssex', 'sys_user');
INSERT INTO `sys_dict` VALUES ('4', '1', '有效', 'status', 'sys_user');
INSERT INTO `sys_dict` VALUES ('5', '0', '锁定', 'status', 'sys_user');
INSERT INTO `sys_dict` VALUES ('6', '0', '菜单', 'type', 'sys_menu');
INSERT INTO `sys_dict` VALUES ('7', '1', '按钮', 'type', 'sys_menu');
INSERT INTO `sys_dict` VALUES ('8', '0', '正常', 'status', 'sys_job');
INSERT INTO `sys_dict` VALUES ('9', '1', '暂停', 'status', 'sys_job');
INSERT INTO `sys_dict` VALUES ('10', '0', '成功', 'status', 'sys_job_log');
INSERT INTO `sys_dict` VALUES ('11', '1', '失败', 'status', 'sys_job_log');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `USERNAME` varchar(50) DEFAULT NULL COMMENT '操作用户',
  `OPERATION` text COMMENT '操作内容',
  `TIME` decimal(11,0) DEFAULT NULL COMMENT '耗时',
  `METHOD` text COMMENT '操作方法',
  `PARAMS` text COMMENT '方法参数',
  `IP` varchar(64) DEFAULT NULL COMMENT '操作者IP',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `location` varchar(50) DEFAULT NULL COMMENT '操作地点',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1053 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1046', 'admin', '', '0', 'com.bjgoodwill.isteam.Business.service.impl.BizServiceImpl.getPatientInfo()', 'string: \"hello \"', '127.0.0.1', '2018-11-12 14:47:09', '内网IP|0|0|内网IP|内网IP');
INSERT INTO `sys_log` VALUES ('1047', 'admin', '', '0', 'com.bjgoodwill.isteam.Business.service.impl.BizServiceImpl.getPatientInfo()', 'string: \"hello \"', '127.0.0.1', '2018-11-12 14:47:09', '内网IP|0|0|内网IP|内网IP');
INSERT INTO `sys_log` VALUES ('1048', 'admin', '获取在线用户信息', '0', 'com.bjgoodwill.isteam.system.controller.SessionController.online()', '', '127.0.0.1', '2018-11-12 14:47:21', '内网IP|0|0|内网IP|内网IP');
INSERT INTO `sys_log` VALUES ('1049', 'admin', '获取在线用户信息', '0', 'com.bjgoodwill.isteam.system.controller.SessionController.online()', '', '127.0.0.1', '2018-11-12 14:47:22', '内网IP|0|0|内网IP|内网IP');
INSERT INTO `sys_log` VALUES ('1050', 'admin', '{业务操作}:获取患者基本信息', '0', 'com.bjgoodwill.isteam.Business.service.impl.BizServiceImpl.getPatientInfo()', 'string: \"hello \"', '127.0.0.1', '2018-11-12 14:49:29', '内网IP|0|0|内网IP|内网IP');
INSERT INTO `sys_log` VALUES ('1051', 'admin', '获取在线用户信息', '0', 'com.bjgoodwill.isteam.system.controller.SessionController.online()', '', '127.0.0.1', '2018-11-12 14:49:34', '内网IP|0|0|内网IP|内网IP');
INSERT INTO `sys_log` VALUES ('1052', 'admin', '{业务操作}:获取患者基本信息', '3', 'com.bjgoodwill.isteam.Business.service.impl.BizServiceImpl.getPatientInfo()', 'string: \"hello \"', '127.0.0.1', '2018-11-12 15:20:37', '内网IP|0|0|内网IP|内网IP');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `MENU_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单/按钮ID',
  `PARENT_ID` bigint(20) NOT NULL COMMENT '上级菜单ID',
  `MENU_NAME` varchar(50) NOT NULL COMMENT '菜单/按钮名称',
  `URL` varchar(100) DEFAULT NULL COMMENT '菜单URL',
  `PERMS` text COMMENT '权限标识',
  `ICON` varchar(50) DEFAULT NULL COMMENT '图标',
  `TYPE` char(2) NOT NULL COMMENT '类型 0菜单 1按钮',
  `ORDER_NUM` bigint(20) DEFAULT NULL COMMENT '排序',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `MODIFY_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', null, null, 'zmdi zmdi-settings', '0', '1', '2017-12-27 16:39:07', null);
INSERT INTO `sys_menu` VALUES ('2', '0', '系统监控', null, null, 'zmdi zmdi-shield-security', '0', '2', '2017-12-27 16:45:51', '2018-01-17 17:08:28');
INSERT INTO `sys_menu` VALUES ('3', '1', '用户管理', 'user', 'user:list', '', '0', '1', '2017-12-27 16:47:13', '2018-04-25 09:00:01');
INSERT INTO `sys_menu` VALUES ('4', '1', '角色管理', 'role', 'role:list', '', '0', '2', '2017-12-27 16:48:09', '2018-04-25 09:01:12');
INSERT INTO `sys_menu` VALUES ('5', '1', '菜单管理', 'menu', 'menu:list', '', '0', '3', '2017-12-27 16:48:57', '2018-04-25 09:01:30');
INSERT INTO `sys_menu` VALUES ('6', '1', '部门管理', 'dept', 'dept:list', '', '0', '4', '2017-12-27 16:57:33', '2018-04-25 09:01:40');
INSERT INTO `sys_menu` VALUES ('8', '2', '在线用户', 'session', 'session:list', '', '0', '1', '2017-12-27 16:59:33', '2018-04-25 09:02:04');
INSERT INTO `sys_menu` VALUES ('10', '2', '系统日志', 'log', 'log:list', '', '0', '3', '2017-12-27 17:00:50', '2018-04-25 09:02:18');
INSERT INTO `sys_menu` VALUES ('11', '3', '新增用户', null, 'user:add', null, '1', null, '2017-12-27 17:02:58', null);
INSERT INTO `sys_menu` VALUES ('12', '3', '修改用户', null, 'user:update', null, '1', null, '2017-12-27 17:04:07', null);
INSERT INTO `sys_menu` VALUES ('13', '3', '删除用户', null, 'user:delete', null, '1', null, '2017-12-27 17:04:58', null);
INSERT INTO `sys_menu` VALUES ('14', '4', '新增角色', null, 'role:add', null, '1', null, '2017-12-27 17:06:38', null);
INSERT INTO `sys_menu` VALUES ('15', '4', '修改角色', null, 'role:update', null, '1', null, '2017-12-27 17:06:38', null);
INSERT INTO `sys_menu` VALUES ('16', '4', '删除角色', null, 'role:delete', null, '1', null, '2017-12-27 17:06:38', null);
INSERT INTO `sys_menu` VALUES ('17', '5', '新增菜单', null, 'menu:add', null, '1', null, '2017-12-27 17:08:02', null);
INSERT INTO `sys_menu` VALUES ('18', '5', '修改菜单', null, 'menu:update', null, '1', null, '2017-12-27 17:08:02', null);
INSERT INTO `sys_menu` VALUES ('19', '5', '删除菜单', null, 'menu:delete', null, '1', null, '2017-12-27 17:08:02', null);
INSERT INTO `sys_menu` VALUES ('20', '6', '新增部门', null, 'dept:add', null, '1', null, '2017-12-27 17:09:24', null);
INSERT INTO `sys_menu` VALUES ('21', '6', '修改部门', null, 'dept:update', null, '1', null, '2017-12-27 17:09:24', null);
INSERT INTO `sys_menu` VALUES ('22', '6', '删除部门', null, 'dept:delete', null, '1', null, '2017-12-27 17:09:24', null);
INSERT INTO `sys_menu` VALUES ('23', '8', '踢出用户', null, 'user:kickout', null, '1', null, '2017-12-27 17:11:13', null);
INSERT INTO `sys_menu` VALUES ('24', '10', '删除日志', null, 'log:delete', null, '1', null, '2017-12-27 17:11:45', null);
INSERT INTO `sys_menu` VALUES ('64', '1', '系统字典', 'dict', 'dict:list', '', '0', null, '2018-01-18 10:38:25', '2018-11-08 15:33:13');
INSERT INTO `sys_menu` VALUES ('65', '64', '新增字典', null, 'dict:add', null, '1', null, '2018-01-18 19:10:08', null);
INSERT INTO `sys_menu` VALUES ('66', '64', '修改字典', null, 'dict:update', null, '1', null, '2018-01-18 19:10:27', null);
INSERT INTO `sys_menu` VALUES ('67', '64', '删除字典', null, 'dict:delete', null, '1', null, '2018-01-18 19:10:47', null);
INSERT INTO `sys_menu` VALUES ('101', '0', '任务调度', null, null, 'zmdi zmdi-alarm', '0', null, '2018-02-24 15:52:57', null);
INSERT INTO `sys_menu` VALUES ('102', '101', '定时任务', 'job', 'job:list', '', '0', null, '2018-02-24 15:53:53', '2018-04-25 09:05:12');
INSERT INTO `sys_menu` VALUES ('103', '102', '新增任务', null, 'job:add', null, '1', null, '2018-02-24 15:55:10', null);
INSERT INTO `sys_menu` VALUES ('104', '102', '修改任务', null, 'job:update', null, '1', null, '2018-02-24 15:55:53', null);
INSERT INTO `sys_menu` VALUES ('105', '102', '删除任务', null, 'job:delete', null, '1', null, '2018-02-24 15:56:18', null);
INSERT INTO `sys_menu` VALUES ('106', '102', '暂停任务', null, 'job:pause', null, '1', null, '2018-02-24 15:57:08', null);
INSERT INTO `sys_menu` VALUES ('107', '102', '恢复任务', null, 'job:resume', null, '1', null, '2018-02-24 15:58:21', null);
INSERT INTO `sys_menu` VALUES ('108', '102', '立即执行任务', null, 'job:run', null, '1', null, '2018-02-24 15:59:45', null);
INSERT INTO `sys_menu` VALUES ('109', '101', '调度日志', 'jobLog', 'jobLog:list', '', '0', null, '2018-02-24 16:00:45', '2018-04-25 09:05:25');
INSERT INTO `sys_menu` VALUES ('110', '109', '删除日志', null, 'jobLog:delete', null, '1', null, '2018-02-24 16:01:21', null);
INSERT INTO `sys_menu` VALUES ('113', '2', 'Redis监控', 'redis/info', 'redis:list', '', '0', null, '2018-06-28 14:29:42', null);
INSERT INTO `sys_menu` VALUES ('114', '2', 'Redis终端', 'redis/terminal', 'redis:terminal', '', '0', null, '2018-06-28 15:35:21', null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ROLE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `ROLE_NAME` varchar(100) NOT NULL COMMENT '角色名称',
  `REMARK` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `MODIFY_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', '管理员', '2017-12-27 16:23:11', '2018-11-08 10:42:39');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID',
  `MENU_ID` bigint(20) NOT NULL COMMENT '菜单/按钮ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '2');
INSERT INTO `sys_role_menu` VALUES ('1', '3');
INSERT INTO `sys_role_menu` VALUES ('1', '67');
INSERT INTO `sys_role_menu` VALUES ('1', '1');
INSERT INTO `sys_role_menu` VALUES ('1', '4');
INSERT INTO `sys_role_menu` VALUES ('1', '5');
INSERT INTO `sys_role_menu` VALUES ('1', '6');
INSERT INTO `sys_role_menu` VALUES ('1', '20');
INSERT INTO `sys_role_menu` VALUES ('1', '21');
INSERT INTO `sys_role_menu` VALUES ('1', '22');
INSERT INTO `sys_role_menu` VALUES ('1', '10');
INSERT INTO `sys_role_menu` VALUES ('1', '8');
INSERT INTO `sys_role_menu` VALUES ('1', '66');
INSERT INTO `sys_role_menu` VALUES ('1', '11');
INSERT INTO `sys_role_menu` VALUES ('1', '12');
INSERT INTO `sys_role_menu` VALUES ('1', '64');
INSERT INTO `sys_role_menu` VALUES ('1', '13');
INSERT INTO `sys_role_menu` VALUES ('1', '14');
INSERT INTO `sys_role_menu` VALUES ('1', '65');
INSERT INTO `sys_role_menu` VALUES ('1', '15');
INSERT INTO `sys_role_menu` VALUES ('1', '16');
INSERT INTO `sys_role_menu` VALUES ('1', '17');
INSERT INTO `sys_role_menu` VALUES ('1', '18');
INSERT INTO `sys_role_menu` VALUES ('1', '23');
INSERT INTO `sys_role_menu` VALUES ('1', '19');
INSERT INTO `sys_role_menu` VALUES ('1', '24');
INSERT INTO `sys_role_menu` VALUES ('1', '101');
INSERT INTO `sys_role_menu` VALUES ('1', '102');
INSERT INTO `sys_role_menu` VALUES ('1', '103');
INSERT INTO `sys_role_menu` VALUES ('1', '104');
INSERT INTO `sys_role_menu` VALUES ('1', '105');
INSERT INTO `sys_role_menu` VALUES ('1', '106');
INSERT INTO `sys_role_menu` VALUES ('1', '107');
INSERT INTO `sys_role_menu` VALUES ('1', '108');
INSERT INTO `sys_role_menu` VALUES ('1', '109');
INSERT INTO `sys_role_menu` VALUES ('1', '110');
INSERT INTO `sys_role_menu` VALUES ('1', '113');
INSERT INTO `sys_role_menu` VALUES ('1', '114');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `USERNAME` varchar(50) NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(128) NOT NULL COMMENT '密码',
  `DEPT_ID` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `EMAIL` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `MOBILE` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `STATUS` char(1) NOT NULL COMMENT '状态 0锁定 1有效',
  `CRATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `MODIFY_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `LAST_LOGIN_TIME` datetime DEFAULT NULL COMMENT '最近访问时间',
  `SSEX` char(1) DEFAULT NULL COMMENT '性别 0男 1女',
  `THEME` varchar(10) DEFAULT NULL COMMENT '主题',
  `AVATAR` varchar(100) DEFAULT NULL COMMENT '头像',
  `DESCRIPTION` varchar(100) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'steam', 'ff595db143ab9f14e2e722cd0534836c', '5', '', '', '1', '2018-11-08 10:21:55', '2018-11-08 10:47:06', '2018-11-12 11:00:44', '0', 'lime', 'default.jpg', null);
INSERT INTO `sys_user` VALUES ('168', 'admin', 'c7242b2bc2435c1ead6b89f85d9e6a96', '5', '', '', '1', '2018-11-09 14:10:24', null, '2018-11-12 13:40:03', '0', 'green', 'default.jpg', null);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `USER_ID` bigint(20) NOT NULL COMMENT '用户ID',
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('168', '1');
