DROP TABLE IF EXISTS `un_flow`;
CREATE TABLE `un_flow`  (
`id` bigint(20) UNSIGNED NOT NULL COMMENT '流程ID',
`type` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '0 默认基础 1默认修改使用中 2自定义',
`icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图标',
`name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '流程名称',
`sort_num` int(11) NULL DEFAULT NULL COMMENT '流程的排序',
`parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父级id',
`depth_depth` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '列的深度',
`group_id` bigint(20) NULL DEFAULT NULL COMMENT '所属分组',

`module_type` bigint(20) NOT NULL COMMENT '关联的类型',
-- `relation_id` bigint(20) NULL DEFAULT NULL COMMENT '关联业务主键ID',


`status` int(11) NULL DEFAULT NULL COMMENT '1 正常 2 停用 3 删除 ',
`remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
`create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
`create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
`update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
`update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人',
`company_id` bigint(20) NULL DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '流程表' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `un_flow_group`;
CREATE TABLE `un_flow_group`  (
`id` bigint(20) NOT NULL COMMENT '分组id',
`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分组名称',
`create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
`update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '更新人',
`create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
`update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
`company_id` bigint(20) NULL DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '流程分组表' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `un_flow_field`;
CREATE TABLE `un_flow_field`  (
`id` bigint(20) NOT NULL COMMENT 'id',
`flow_id` bigint(20) NOT NULL COMMENT '流程ID',

`field_id` bigint(20) NOT NULL COMMENT '''自定义字段ID',
`field_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '自定义字段英文标识',
`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '字段名称',
`type` int NOT NULL DEFAULT '1' COMMENT '字段类型 1 单行文本 2 多行文本 3 单选 4日期 5 数字 6 小数 7 手机  8 文件 9 多选 10 人员 11 附件 12 部门 13 日期时间 14 邮箱 15客户 16 商机 17 联系人 18 地图 19 产品类型 20 合同 21 回款计划',
`label` int NOT NULL COMMENT '标签 1 合同 2 回款 3发票',
`group` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '分组',

`create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
`update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '更新人',
`create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
`update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
`company_id` bigint(20) NULL DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '流程关联表字段表' ROW_FORMAT = Dynamic;



DROP TABLE IF EXISTS `un_flow_record_log`;
CREATE TABLE `un_flow_record_log`  (
`id` bigint(20) NOT NULL COMMENT '流程记录ID',
`flow_id` bigint(20) NOT NULL COMMENT '流程ID',
`module_type` bigint(20) NOT NULL COMMENT '1 合同 2 回款 3发票',
`relation_id` bigint(20) NULL DEFAULT NULL COMMENT '关联业务主键ID',
`examine_id` bigint(20) NULL DEFAULT NULL COMMENT '关联审批主键ID',
`examine_record_id` bigint(20) NULL DEFAULT NULL COMMENT '关联审批的进行recordId',
`status` int(11) NULL DEFAULT NULL COMMENT '记录状态 0 正常 1 终止 2 暂停  3 作废',
`flow_status` int(11) NULL DEFAULT NULL COMMENT '流程状态 0 未流程 1 流程通过 2 流程拒绝 3 流程中 4 已撤回 6创建',
`remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
`create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
`create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
`update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
`update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人',
`company_id` bigint(20) NULL DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '流程记录表' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `un_flow_field_log`;
CREATE TABLE `un_flow_field_log`  (
`id` bigint(20) NOT NULL COMMENT 'id',
`flow_id` bigint(20) NOT NULL COMMENT '流程ID',

`field_id` bigint(20) NOT NULL COMMENT '''自定义字段ID',
`field_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '自定义字段英文标识',
`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '字段名称',
`type` int NOT NULL DEFAULT '1' COMMENT '字段类型 1 单行文本 2 多行文本 3 单选 4日期 5 数字 6 小数 7 手机  8 文件 9 多选 10 人员 11 附件 12 部门 13 日期时间 14 邮箱 15客户 16 商机 17 联系人 18 地图 19 产品类型 20 合同 21 回款计划',
`module_type` int NOT NULL COMMENT '标签 1 合同 2 回款 3发票',
`group` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '分组',
`field_value` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '值',

`create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
`update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '更新人',
`create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
`update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
`company_id` bigint(20) NULL DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '流程关联表字段表' ROW_FORMAT = Dynamic;
