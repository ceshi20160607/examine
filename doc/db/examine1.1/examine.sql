
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
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`examine_id` bigint(20) NULL DEFAULT NULL COMMENT '审批id--关联的审批的高级配置，以及审批的基础信息',
`module_id` bigint(20) NULL DEFAULT NULL COMMENT '模块id 关联模块--可以是业务，也可以是特殊的模块，比如oa',

`node_before_id` bigint(20) NULL DEFAULT NULL COMMENT '审批的类型 0开始节点或者其他节点',
`node_type` int(11) NULL DEFAULT NULL COMMENT '审批的类型 0动态添加 1普通审批 2条件审批 3抄送 4转他人处理 ',
`node_after_id` bigint(20) NULL DEFAULT NULL COMMENT '审批的类型 1结束节点或者其他节点',
`node_sort` int(11) NULL DEFAULT '0' COMMENT '节点排序 默认0',
`node_depth` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '节点深度,存储节点的父级，从0开始逗号分隔',


`examine_type` int(11) NULL DEFAULT NULL COMMENT '审批人类型 0 固定人员 1 固定人员上级 2角色 3发起人自选',
`examine_flag` int(1) NULL DEFAULT 0 COMMENT '多人情况时候审批的人员审批方式  0默认一个爱一个默认顺序  1一个爱一个无序 2只要有一个',
`user_ids` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '适用用户id 选择类型是上级时候可以指定某人的上级来处理',
`role_ids` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '适用角色id',
`end_user_id` bigint(20) NULL DEFAULT NULL COMMENT '上级审批截至人员 配置这个如果没有上级转该人审批 有上级这个配置失效',

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
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '审批节点表' ROW_FORMAT = Dynamic;
