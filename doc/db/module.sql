DROP TABLE IF EXISTS `un_module`;
CREATE TABLE `un_module` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
`module_type` bigint(20) NOT NULL COMMENT '1 合同 2 回款 3发票',
`title_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '自定义字段英文标识',
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

