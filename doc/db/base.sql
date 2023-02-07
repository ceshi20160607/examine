-- 1.0基础结构
CREATE TABLE `un_examine_group` (
`id` bigint(20) NOT NULL COMMENT '分组id',
`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '分组名称',
`create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人',
`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`update_time` datetime DEFAULT NULL COMMENT '更新时间',
`company_id` bigint(20) DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='审批分组表';

CREATE TABLE `un_examine_apply_user` (
`id` bigint(20) NOT NULL COMMENT 'id',
`examine_id` bigint(20) NOT NULL COMMENT '审批id',
`apply_type` int(10) NOT NULL COMMENT '适用类型 0用户 1部门',
`user_id` bigint(20) NOT NULL COMMENT '适用用户id',
`dept_id` bigint(20) NOT NULL COMMENT '适用部门id',

`create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人',
`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`update_time` datetime DEFAULT NULL COMMENT '更新时间',
`company_id` bigint(20) DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='审批适用用户部门表';

CREATE TABLE `un_examine_high_rule` (
`id` bigint(20) NOT NULL COMMENT 'id',
`examine_id` bigint(20) NOT NULL COMMENT '审批id',
`rule_type` int(11) DEFAULT NULL COMMENT '0撤回规则 1通过规则 ',
`recheck_type` int(11) DEFAULT NULL COMMENT '撤回之后重新审核操作 1 从第一层开始 2 从拒绝的层级开始',

`apply_type` int(10) NOT NULL COMMENT '适用类型 0用户 1部门',
`user_id` bigint(20) NOT NULL COMMENT '适用用户id',
`dept_id` bigint(20) NOT NULL COMMENT '适用部门id',

`create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人',
`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`update_time` datetime DEFAULT NULL COMMENT '更新时间',
`company_id` bigint(20) DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`group_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='审批高级设置及异常处理规则';

CREATE TABLE `un_examine` (
`id` bigint(20) unsigned NOT NULL COMMENT '审批ID',
`module_type` int(10) unsigned DEFAULT NULL COMMENT '1 合同 2 回款 3发票   101 普通审批 102 请假审批 103 出差审批 104 加班审批 105 差旅报销 106 借款申请',
`type` int(10) unsigned DEFAULT NULL COMMENT '0 默认基础 1默认修改使用中 2自定义',
`icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图标',
`name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '审批名称',
`sort_num` int(11) DEFAULT NULL COMMENT '审批的排序',
`group_id` bigint(20) DEFAULT NULL COMMENT '所属分组',
`status` int(11) DEFAULT NULL COMMENT '1 正常 2 停用 3 删除 ',
--
-- `user_ids` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '可见范围（员工）',
-- `dept_ids` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '可见范围（部门）',

`batch_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '批次ID',
`remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
`update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
`company_id` bigint(20) DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE,
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='审批表';
