DROP TABLE IF EXISTS `un_field`;
CREATE TABLE `un_field` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
`module_type` bigint(20) NOT NULL COMMENT '1 合同 2 回款 3发票',
`field_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '自定义字段英文标识',
`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '字段名称',
`type` int(11) NOT NULL DEFAULT '1' COMMENT '字段类型 1 单行文本 2 多行文本 3 单选 4日期 5 数字 6 小数 7 手机  8 文件 9 多选 10 人员 11 附件 12 部门 13 日期时间 14 邮箱 15客户 16 商机 17 联系人 18 地图 19 产品类型 20 合同 21 回款计划',
`remark` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段说明',
`input_tips` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '输入提示',
`max_length` int(11) DEFAULT NULL COMMENT '最大长度',
`default_value` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '默认值',
`unique_flag` int(11) DEFAULT '0' COMMENT '是否唯一 1 是 0 否',
`null_flag` int(11) DEFAULT '0' COMMENT '是否必填 1 是 0 否',
`hidden_flag` int(11) NOT NULL DEFAULT '0' COMMENT '是否隐藏  0不隐藏 1隐藏',
`sorting` int(11) DEFAULT '1' COMMENT '排序 从小到大',
`options` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '如果类型是选项，此处不能为空，多个选项以，隔开',
`field_type` int(11) NOT NULL DEFAULT '0' COMMENT '字段来源  0.自定义 1.原始固定 2原始字段但值存在扩展表中',
`relevant` int(11) DEFAULT NULL COMMENT '只有线索需要，转换客户的自定义字段ID',
`style_percent` int(11) DEFAULT '50' COMMENT '样式百分比%',
`precisions` int(11) DEFAULT NULL COMMENT '精度，允许的最大小数位',
`max_num_restrict` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '限制的最大数值',
`min_num_restrict` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '限制的最小数值',


`index_flag` int(11) DEFAULT '0' COMMENT '是否列表显示 1 是 0 否',
`add_flag` int(11) DEFAULT '0' COMMENT '是否新建显示 1 是 0 否',
`detail_flag` int(11) DEFAULT '0' COMMENT '是否详情显示 1 是 0 否',

`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',

PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='自定义字段表';

DROP TABLE IF EXISTS `un_field_auth`;
CREATE TABLE `un_field_auth` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
`field_id` bigint(20) DEFAULT NULL COMMENT '字段ID',
`role_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色id',
`auth_type` int(11) NOT NULL DEFAULT '0' COMMENT '授权类型   0不能查看   1只能看 2可以编辑',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='自定义字段关联角色表';



DROP TABLE IF EXISTS `un_field_user`;
CREATE TABLE `un_field_user` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
`field_id` bigint(20) DEFAULT NULL COMMENT '字段ID',
`user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户id',
`hidden_flag` int(11) NOT NULL DEFAULT '0' COMMENT '是否隐藏  0不隐藏 1隐藏',
`auth_type` int(11) NOT NULL DEFAULT '0' COMMENT '授权类型   0不能查看   1只能看 2可以编辑',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='自定义字段关联用户表';



