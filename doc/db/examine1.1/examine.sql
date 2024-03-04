DROP TABLE IF EXISTS `un_examine`;
CREATE TABLE `un_examine`  (
`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '审批ID',
`module_id` bigint(20) NOT NULL COMMENT '模块id 关联模块--可以是业务，也可以是特殊的模块，比如oa 1 合同 2 回款 3发票   101 普通审批 102 请假审批 103 出差审批 104 加班审批 105 差旅报销 106 借款申请',
`icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图标',
`name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '审批名称',
`sort_num` int(11) NULL DEFAULT NULL COMMENT '审批的排序',
`group_id` bigint(20) NULL DEFAULT NULL COMMENT '所属分组',
`status` int(11) NULL DEFAULT NULL COMMENT '1 正常 2 停用 3 删除 ',
`remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
`create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
`create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
`update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
`update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人',
`company_id` bigint(20) NULL DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '审批表' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `un_examine_group`;
CREATE TABLE `un_examine_group`  (
 `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '分组id',
`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分组名称',
`create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
`update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '更新人',
`create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
`update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
`company_id` bigint(20) NULL DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '审批分组表' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `un_examine_setting`;
CREATE TABLE `un_examine_setting`  (
 `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
`examine_id` bigint(20) NOT NULL COMMENT '审批id',
`rule_type` int(11) NULL DEFAULT NULL COMMENT '0撤回规则 1通过规则 ',
`recheck_type` int(11) NULL DEFAULT NULL COMMENT '撤回之后重新审核操作 1 从第一层开始 2 从拒绝的层级开始',
`pass_type` int(11) NULL DEFAULT NULL COMMENT '通过规则类型 1 超时自动通过 2 转他人处理',
`pass_rule` int(11) NULL DEFAULT NULL COMMENT '通过规则类型 1 该审批人一个同意该人全部同意 2 该相同审批人同意 3该审批人依次审批',
`limit_time_type` int(11) NULL DEFAULT NULL COMMENT '现时配置是否开启  0默认不开启  1开启 设置超时通过必须设置现时',
`limit_time_num` int(11) NULL DEFAULT NULL COMMENT '限时时间',
`limit_time_unit` int(11) NULL DEFAULT NULL COMMENT '限时时间单位',
`apply_type` int(10) NOT NULL COMMENT '适用类型 0默认全公司 1用户 2部门',
`create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
`update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '更新人',
`create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
`update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
`company_id` bigint(20) NULL DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '审批高级设置及异常处理规则' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `un_examine_setting_user`;
CREATE TABLE `un_examine_setting_user`  (
 `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
`examine_id` bigint(20) NOT NULL COMMENT '审批id',
`apply_type` int(10) NOT NULL COMMENT '适用类型 0用户 1部门',
`user_id` bigint(20) NOT NULL COMMENT '适用用户id',
`dept_id` bigint(20) NOT NULL COMMENT '适用部门id',
`create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
`update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '更新人',
`create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
`update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
`company_id` bigint(20) NULL DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '审批适用用户部门表' ROW_FORMAT = Dynamic;


-- examine 20231129升级examine审批流程
-- 审批流程，自定义表单；关联【表单动态反射】字段对
-- 审批模版，模版流程设置， 节点添加，构建节点，动态， 条件节点的重新设计，单向 【0开始节点】=》2=》3=》【1结束节点】
-- 1.兼容flow
--      1.1流程，表单自建的
--      1.2审批的接入
-- 2.兼容examine
--      1.1流程，表单自建的
--      1.2审批的接入

DROP TABLE IF EXISTS `un_examine_node`;
CREATE TABLE `un_examine_node`  (
 `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
`examine_id` bigint(20) NULL DEFAULT NULL COMMENT '审批id--关联的审批的高级配置，以及审批的基础信息',
`module_id` bigint(20) NULL DEFAULT NULL COMMENT '模块id 关联模块--可以是业务，也可以是特殊的模块，比如oa',

`node_before_id` bigint(20) NULL DEFAULT NULL COMMENT '审批的类型 0开始节点或者其他节点',
`node_type` int(11) NULL DEFAULT NULL COMMENT '审批的类型 0动态添加 1普通审批 2条件审批 3抄送 4转他人处理 ',
`node_after_id` bigint(20) NULL DEFAULT NULL COMMENT '审批的类型 1结束节点或者其他节点',
`node_sort` int(11) NULL DEFAULT '0' COMMENT '节点排序 默认0',
`node_depth` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '节点深度,存储节点的父级，从0开始逗号分隔',


`examine_type` int(11) NULL DEFAULT NULL COMMENT '审批人类型 0 固定人员 1 固定人员上级 2角色 3发起人自选',
`examine_flag` int(1) NULL DEFAULT 0 COMMENT '多人情况时候审批的人员审批方式  0默认一个爱一个默认顺序  1一个爱一个无序 2只要有一个',
-- `examine_user_ids` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '适用用户id 选择类型是上级时候可以指定某人的上级来处理',
-- `examine_role_ids` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '适用角色id',
`examine_end_user_id` bigint(20) NULL DEFAULT NULL COMMENT '上级审批截至人员 配置这个如果没有上级转该人审批 有上级这个配置失效',

`condition_module_field_search` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '条件',

`copy_emails` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '抄送的 email',

`transfer_flag` int(1) NULL DEFAULT 0 COMMENT '转他人处理flag 默认0 1表示这个是转他人的审批场景 2抄送的邮箱',
`transfer_user_id` bigint(20) NULL DEFAULT NULL COMMENT '类型是转他人对应的主键',
`transfer_status` int(1) NULL DEFAULT NULL COMMENT '类型是转他人 审批状态',

`remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
`create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
`create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
`update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
`update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人',
`company_id` bigint(20) NULL DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '审批节点表' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `un_examine_node_user`;
CREATE TABLE `un_examine_node_user`  (
 `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
`examine_id` bigint(20) NOT NULL COMMENT '审批id',
`node_id` bigint(20) NOT NULL COMMENT '节点id',
`apply_type` int(10) NOT NULL COMMENT '适用类型 0用户 1部门 2 角色 4邮箱',
`user_id` bigint(20) NOT NULL COMMENT '适用用户id',
`dept_id` bigint(20) NOT NULL COMMENT '适用部门id',
`role_id` bigint(20) NOT NULL COMMENT '适用角色id',
`eamil` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
`sorting` int(11) NULL DEFAULT NULL COMMENT '排序',
`create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
`update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '更新人',
`create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
`update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
`company_id` bigint(20) NULL DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '审批适用用户部门表' ROW_FORMAT = Dynamic;


-- 实例

DROP TABLE IF EXISTS `un_examine_record`;
CREATE TABLE `un_examine_record`  (
 `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '审核记录ID',
`examine_id` bigint(20) NOT NULL COMMENT '审核ID',
`module_id` bigint(20) NOT NULL COMMENT '模块id 关联模块--可以是业务，也可以是特殊的模块，比如oa',
`relation_id` bigint(20) NULL DEFAULT NULL COMMENT '关联业务主键ID',
`status` int(11) NULL DEFAULT NULL COMMENT '记录状态 0 正常 1 终止 2 暂停  3 作废',
`examine_status` int(11) NULL DEFAULT NULL COMMENT '审核状态 0 未审核 1 审核通过 2 审核拒绝 3 审核中 4 已撤回 6创建',
`remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
`create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
`create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
`update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
`update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人',
`company_id` bigint(20) NULL DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '审核记录表' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `un_examine_record_node`;
CREATE TABLE `un_examine_record_node`  (
 `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
`examine_id` bigint(20) NULL DEFAULT NULL COMMENT '审批id--关联的审批的高级配置，以及审批的基础信息',
`module_id` bigint(20) NULL DEFAULT NULL COMMENT '模块id 关联模块--可以是业务，也可以是特殊的模块，比如oa',
`record_id` bigint(20) NULL DEFAULT NULL COMMENT '关联的record_id',

`node_before_id` bigint(20) NULL DEFAULT NULL COMMENT '审批的类型 0开始节点或者其他节点',
`node_type` int(11) NULL DEFAULT NULL COMMENT '审批的类型 0动态添加 1普通审批 2条件审批 3抄送 4转他人处理 ',
`node_after_id` bigint(20) NULL DEFAULT NULL COMMENT '审批的类型 1结束节点或者其他节点',
`node_sort` int(11) NULL DEFAULT '0' COMMENT '节点排序 默认0',
`node_depth` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '节点深度,存储节点的父级，从0开始逗号分隔',

`examine_type` int(11) NULL DEFAULT NULL COMMENT '审批人类型 0 固定人员 1 固定人员上级 2角色 3发起人自选',
`examine_flag` int(1) NULL DEFAULT 0 COMMENT '多人情况时候审批的人员审批方式  0默认一个爱一个默认顺序  1一个爱一个无序 2只要有一个',
`user_id` bigint(20) NULL DEFAULT NULL COMMENT '适用用户id 选择类型是上级时候可以指定某人的上级来处理',
`role_id` bigint(20) NULL DEFAULT NULL COMMENT '适用角色id',
`copy_emails` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '抄送的 email',

`status` int(1) NULL DEFAULT NULL COMMENT '审批状态',

`condition_module_field_search` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '条件',

`transfer_flag` int(1) NULL DEFAULT 0 COMMENT '转他人处理flag 默认0 1表示这个是转他人的审批场景 2抄送的邮箱',
`transfer_user_id` bigint(20) NULL DEFAULT NULL COMMENT '类型是转他人对应的主键',
`transfer_status` int(1) NULL DEFAULT NULL COMMENT '类型是转他人 审批状态',

`end_user_id` bigint(20) NULL DEFAULT NULL COMMENT '上级审批截至人员 配置这个如果没有上级转该人审批 有上级这个配置失效',

`remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
`create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
`create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
`update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
`update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人',
`company_id` bigint(20) NULL DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '审批节点表' ROW_FORMAT = Dynamic;


