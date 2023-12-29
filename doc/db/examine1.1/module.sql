DROP TABLE IF EXISTS `un_module`;
CREATE TABLE `un_module` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '字段名称',
`group_id` int(11) NULL DEFAULT NULL COMMENT '模块分组',
`sort_num` int(11) NULL DEFAULT NULL COMMENT '流程的排序',
`parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父级id',
`depth_depth` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '列的深度',

`remark` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段说明',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='模块表';

DROP TABLE IF EXISTS `un_module_group`;
CREATE TABLE `un_module_group`  (
`id` bigint(20) NOT NULL COMMENT '分组id',
`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分组名称',
`create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
`update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '更新人',
`create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
`update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
`company_id` bigint(20) NULL DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '模块分组表' ROW_FORMAT = Dynamic;



DROP TABLE IF EXISTS `un_module_field`;
CREATE TABLE `un_module_field` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
`module_id` bigint(20) NOT NULL COMMENT '模块id',
`field_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '自定义字段英文标识',
`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '字段名称',
`type` int(11) NOT NULL DEFAULT '1' COMMENT '字段类型 1 单行文本 2 多行文本 3 单选 4日期 5 数字 6 小数 7 手机  8 文件 9 多选 10 人员 11 附件 12 部门 13 日期时间 14 邮箱 15客户 16 商机 17 联系人 18 地图 19 产品类型 20 合同 21 回款计划',
`remark` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段说明',
`input_tips` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '输入提示',
`max_length` int(11) DEFAULT NULL COMMENT '最大长度',
`default_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '默认值',
`type_env` int(8) unsigned zerofill COMMENT '唯一,必填,隐藏,删除,列表,新建,详情,其他',
`sorting` int(11) DEFAULT '1' COMMENT '排序 从小到大',
`field_type` int(11) NOT NULL DEFAULT '0' COMMENT '字段来源  0.自定义 1.原始固定 2原始字段但值存在扩展表中',

`dictId` bigint(20) DEFAULT NULL COMMENT '字典id',
`option_data` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT 'json类型的数据，如果是下来可以配置显示隐藏字段',

`parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父级id',
`depth_depth` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '列的深度',

`transfer_model_id` bigint(20) DEFAULT NULL COMMENT '转化modelid',
`transfer_field_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '转化字段名称',

`style_percent` int(11) DEFAULT '50' COMMENT '样式百分比%',
`precisions` int(11) DEFAULT NULL COMMENT '精度，允许的最大小数位',
`max_num_restrict` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '限制的最大数值',
`min_num_restrict` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '限制的最小数值',

`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='自定义字段表';

DROP TABLE IF EXISTS `un_module_field_auth`;
CREATE TABLE `un_module_field_auth` (
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


DROP TABLE IF EXISTS `un_module_field_user`;
CREATE TABLE `un_module_field_user` (
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

-- 对接第三方的动态字段配置
DROP TABLE IF EXISTS `un_module_field_api_open`;
CREATE TABLE `un_module_field_api_open` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`module_id` bigint(20) NOT NULL COMMENT '模块ID',
`field_id` bigint(20) DEFAULT NULL COMMENT '字段ID',
`parent_field_id` bigint(20) DEFAULT NULL COMMENT '父字段ID 目前适配逻辑表单',
`field_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '自定义字段英文标识',
`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '字段名称',
`type` int(11) NOT NULL DEFAULT '1' COMMENT '字段类型 1 单行文本 2 多行文本 3 单选 4日期 5 数字 6 小数 7 手机  8 文件 9 多选 10 人员 11 附件 12 部门 13 日期时间 14 邮箱 15客户 16 商机 17 联系人 18 地图 19 产品类型 20 合同 21 回款计划',
`api_type` int(11) NOT NULL COMMENT '第三方类型 0ttc 1erp 2广告',
`api_field_group` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '自定义字段数组的名称',
`api_field_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '自定义字段英文标识',
`api_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
`create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
`owner_user_id` bigint(20) DEFAULT NULL COMMENT '负责人ID',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`update_time` datetime DEFAULT NULL COMMENT '更新时间',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='第三方接口 字段对照表';


-- 字典表
DROP TABLE IF EXISTS `un_module_dict`;
CREATE TABLE `un_module_dict` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`module_id` bigint(20) NOT NULL COMMENT '模块ID',
`group_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '组名称',
`dict_key` int(11) NOT NULL COMMENT '字典key',
`dict_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典value',

`hidden_flag` int(11) NOT NULL DEFAULT '0' COMMENT '是否隐藏  0不隐藏 1隐藏',
`remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',

`create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
`owner_user_id` bigint(20) DEFAULT NULL COMMENT '负责人ID',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`update_time` datetime DEFAULT NULL COMMENT '更新时间',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='字典表';

