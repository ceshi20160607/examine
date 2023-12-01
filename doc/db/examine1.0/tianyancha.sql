CREATE TABLE `un_third_tianyancha` (
`id` bigint(20) NOT NULL COMMENT 'id',
`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '名称',
`group_id` bigint(20) DEFAULT NULL COMMENT '所属分组',
`customer_id` bigint(20) DEFAULT NULL COMMENT '关联业务主键ID',
`loop_flag` int(11) DEFAULT '0' COMMENT '循环查询标志 0默认不循环 1循环获取所有数据',
`update_flag` int(11) DEFAULT '0' COMMENT '更新标志 0默认 1强制更新',
`status` int(11) DEFAULT NULL COMMENT '记录状态 0 正常 1 终止 2 暂停  3 作废',
`param_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求url',
`param_page_num` int(11) DEFAULT NULL COMMENT '当前页数（默认第1页）',
`param_word` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '查询公司下的关键字',
`param_page_size` int(11) DEFAULT NULL COMMENT '每页条数（默认20条，最大20条）',
`param_keyword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '搜索关键字（公司名称、公司id、注册号或社会统一信用代码）',
`param_publish_start_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '发布结束日期',
`param_publish_end_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '发布开始日期',
`param_province` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '省份地区',
`param_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '公告类型 1. 招标预告、2. 招标公告、3. 招标变更（废弃）、4. 中标结果',
`param_cid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '公司id（cid和name只需输入其中一个）',
`param_human_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名（humanName和hid只需输入其中一个）',
`param_uuid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '集团uuid',
`param_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求参数',
`param_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '公司名称（cid和name只需输入其中一个）',
`param_flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '层次，最大4',
`param_dir` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'up,down',
`param_assistance_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '司法协助基本信息id',
`param_gid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '公司id',
`param_business_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '抽查id',
`param_year` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '年份（默认所有年份）',
`param_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '时间',
`param_hid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '人id（humanName和hid只需输入其中一个）',
`param_types` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '类型 OWN-法人,SERVE_ALL-任职,INVEST-投资,BRANCH-分支机构,LAW-诉讼,CAC-竞合,EQ-债务, STOCK_PLEDGE_M-股权质押,MORTGAGE_M-动产抵押,LAND_MORTGAGE_M-土地抵押,SUPPLY_M-供应商,CLIENT_M-客户,FOREIGN_GUARANTEE_M-对外担保,ALL-所有类型',
`param_depth` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '深度（最大支持10，默认5）',
`param_id_to` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '目标公司id（与目标公司名必须输入其中之一）',
`param_name_to` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '目标公司名',
`param_id_from` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '源公司id（与源公司名必须输入其中之一）',
`param_name_from` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '源公司名',
`param_return` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '请求返回',
`remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
`update_time` datetime DEFAULT NULL COMMENT '修改时间',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='天眼查记录表';


CREATE TABLE `un_third_tianyancha_group` (
`id` bigint(20) NOT NULL COMMENT '分组id',
`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '分组名称',
`create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`update_time` datetime DEFAULT NULL COMMENT '更新时间',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='天眼查分组表';

INSERT INTO `un_third_tianyancha_group` (`id`, `name`, `create_user_id`, `update_user_id`, `create_time`, `update_time`) VALUES (1, '工商信息', 1, 1, '2023-03-07 10:50:11', '2023-03-07 10:50:13');
INSERT INTO `un_third_tianyancha_group` (`id`, `name`, `create_user_id`, `update_user_id`, `create_time`, `update_time`) VALUES (2, '司法风险', 1, 1, '2023-03-07 10:50:11', '2023-03-07 10:50:13');
INSERT INTO `un_third_tianyancha_group` (`id`, `name`, `create_user_id`, `update_user_id`, `create_time`, `update_time`) VALUES (3, '经营信息', 1, 1, '2023-03-07 10:50:11', '2023-03-07 10:50:13');
INSERT INTO `un_third_tianyancha_group` (`id`, `name`, `create_user_id`, `update_user_id`, `create_time`, `update_time`) VALUES (4, '经营风险', 1, 1, '2023-03-07 10:50:11', '2023-03-07 10:50:13');
INSERT INTO `un_third_tianyancha_group` (`id`, `name`, `create_user_id`, `update_user_id`, `create_time`, `update_time`) VALUES (5, '人员相关', 1, 1, '2023-03-07 10:50:11', '2023-03-07 10:50:13');
INSERT INTO `un_third_tianyancha_group` (`id`, `name`, `create_user_id`, `update_user_id`, `create_time`, `update_time`) VALUES (6, '关系发现', 1, 1, '2023-03-07 10:50:11', '2023-03-07 10:50:13');
INSERT INTO `un_third_tianyancha_group` (`id`, `name`, `create_user_id`, `update_user_id`, `create_time`, `update_time`) VALUES (7, '集团族群', 1, 1, '2023-03-07 10:50:11', '2023-03-07 10:50:13');
INSERT INTO `un_third_tianyancha_group` (`id`, `name`, `create_user_id`, `update_user_id`, `create_time`, `update_time`) VALUES (8, '人员风险', 1, 1, '2023-03-07 10:50:11', '2023-03-07 10:50:13');
INSERT INTO `un_third_tianyancha_group` (`id`, `name`, `create_user_id`, `update_user_id`, `create_time`, `update_time`) VALUES (9, '其他关联', 1, 1, '2023-03-07 10:50:11', '2023-03-07 10:50:11');
INSERT INTO `un_third_tianyancha_group` (`id`, `name`, `create_user_id`, `update_user_id`, `create_time`, `update_time`) VALUES (10, '即用接口', 1, 1, '2023-03-07 10:50:11', '2023-03-07 10:50:11');

