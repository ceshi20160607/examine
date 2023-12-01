DROP TABLE IF EXISTS `un_note_study_group`;
CREATE TABLE `un_note_study_group` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '名称',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
`company_id` bigint(20) NULL DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='学习笔记分组';


DROP TABLE IF EXISTS `un_note_study`;
CREATE TABLE `un_note_study` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`group_id` bigint(20) NOT NULL  COMMENT '类型分组',

`title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '名称',
`content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '笔记内容',
`show_flag` int(11) NOT NULL DEFAULT '0'  COMMENT '是否公开',

`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
`company_id` bigint(20) NULL DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='车加油笔记';


DROP TABLE IF EXISTS `un_note_car`;
CREATE TABLE `un_note_car` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`car_type` int(11) NOT NULL DEFAULT '0' COMMENT '类型,0日常 1 充值 2加油',

`start_time` datetime DEFAULT NULL COMMENT '区间开始时间',
`end_time` datetime DEFAULT NULL COMMENT '区间结束时间',
`start_kilo_number` int(11) NOT NULL DEFAULT '0'  COMMENT '区间结开始公里数',
`end_kilo_number` int(11) NOT NULL DEFAULT '0'  COMMENT '区间结束公里数',
`between_kilo_number` int(11) NOT NULL DEFAULT '0'  COMMENT '区间公里数',
`danger_number` int(11) NOT NULL DEFAULT '0'  COMMENT '避险次数',
`future_kilo_number` int(11) NOT NULL DEFAULT '0'  COMMENT '预计剩余里程',


`oil_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '油名称',
`before_oil_number`  decimal(10,2) NOT NULL COMMENT '加之前的油量',
`oil_liter_number` int(11) NOT NULL DEFAULT '0'  COMMENT '加多少升油',
`oil_price`  decimal(10,2) NOT NULL COMMENT '油价',
`oil_money`  decimal(10,2) NOT NULL COMMENT '花费多少钱',
`after_oil_number`  decimal(10,2) NOT NULL COMMENT '加之后的油量',


`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
`company_id` bigint(20) NULL DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='车加油笔记';


DROP TABLE IF EXISTS `un_note_lotto_log`;
CREATE TABLE `un_note_lotto_log` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`lotto_type` int(11) NOT NULL DEFAULT '0' COMMENT '类型,0大乐透 1双色球 2 七星彩 3快乐八 4排列三 5排列5',

`open_stage` int(11) DEFAULT NULL COMMENT '期号',
`open_time` datetime DEFAULT NULL COMMENT '开奖时间',
`open_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '开奖号码,分割',
`single_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '个位数字',
`parity_ratio` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '奇偶比',

`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
`company_id` bigint(20) NULL DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='开奖日志';

DROP TABLE IF EXISTS `un_note_lotto`;
CREATE TABLE `un_note_lotto` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`lotto_type` int(11) NOT NULL DEFAULT '0' COMMENT '类型,0大乐透 1双色球 2 七星彩 3快乐八 4排列三 5排列5',

`open_stage` int(11) DEFAULT NULL COMMENT '期号',
`buy_time` datetime DEFAULT NULL COMMENT '买奖时间',
`buy_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '买奖号码,分割',
`single_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '个位数字',
`parity_ratio` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '奇偶比',

`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
`company_id` bigint(20) NULL DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='购买彩票';

{
    "code":0,
    "message":"",
    "data":T
}