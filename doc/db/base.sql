-- 1.0基础结构
CREATE TABLE `un_examine_group` (
`id` bigint(20) NOT NULL COMMENT '分组id',
`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '分组名称',
`create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`update_time` datetime DEFAULT NULL COMMENT '更新时间',
`company_id` bigint(20) DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='审批分组表';

CREATE TABLE `un_examine_setting_user` (
`id` bigint(20) NOT NULL COMMENT 'id',
`examine_id` bigint(20) NOT NULL COMMENT '审批id',
`apply_type` int(10) NOT NULL COMMENT '适用类型 0用户 1部门',
`user_id` bigint(20) NOT NULL COMMENT '适用用户id',
`dept_id` bigint(20) NOT NULL COMMENT '适用部门id',

`create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`update_time` datetime DEFAULT NULL COMMENT '更新时间',
`company_id` bigint(20) DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='审批适用用户部门表';

CREATE TABLE `un_examine_setting` (
`id` bigint(20) NOT NULL COMMENT 'id',
`examine_id` bigint(20) NOT NULL COMMENT '审批id',
`rule_type` int(11) DEFAULT NULL COMMENT '0撤回规则 1通过规则 ',
`recheck_type` int(11) DEFAULT NULL COMMENT '撤回之后重新审核操作 1 从第一层开始 2 从拒绝的层级开始',
`pass_type` int(11) DEFAULT NULL COMMENT '通过规则类型 1 超时自动通过 2 转他人处理',
`pass_rule` int(11) DEFAULT NULL COMMENT '通过规则类型 1 该审批人一个同意该人全部同意 2 该相同审批人同意 3该审批人依次审批',

`limit_time_type` int(11) DEFAULT NULL COMMENT '现时配置是否开启  0默认不开启  1开启 设置超时通过必须设置现时',
`limit_time_num` int(11) DEFAULT NULL COMMENT '现时时间',
`limit_time_unit` int(11) DEFAULT NULL COMMENT '现时时间单位',

`apply_type` int(10) NOT NULL COMMENT '适用类型 0默认 1用户 2部门',
-- `user_id` longtext NOT NULL COMMENT '适用用户id',
-- `dept_id` bigint(20) NOT NULL COMMENT '适用部门id',

-- `user_ids` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '适用用户id',
-- `dept_ids` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '适用部门id',

`create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`update_time` datetime DEFAULT NULL COMMENT '更新时间',
`company_id` bigint(20) DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`group_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='审批高级设置及异常处理规则';
-- 转他人处理的  记录?

CREATE TABLE `un_examine` (
`id` bigint(20) unsigned NOT NULL COMMENT '审批ID',
`module_type` bigint(20) NOT NULL COMMENT '1 合同 2 回款 3发票   101 普通审批 102 请假审批 103 出差审批 104 加班审批 105 差旅报销 106 借款申请',
`type` int(10) unsigned DEFAULT NULL COMMENT '0 默认基础 1默认修改使用中 2自定义',
`icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图标',
`name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '审批名称',
`sort_num` int(11) DEFAULT NULL COMMENT '审批的排序',
`group_id` bigint(20) DEFAULT NULL COMMENT '所属分组',
`status` int(11) DEFAULT NULL COMMENT '1 正常 2 停用 3 删除 ',
--
-- `user_ids` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '可见范围（员工）',
-- `dept_ids` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '可见范围（部门）',

-- `batch_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '批次ID',
`remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
`update_time` datetime DEFAULT NULL COMMENT '修改时间',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
`company_id` bigint(20) DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE,
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='审批表';


CREATE TABLE `un_examine_task` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`task_type` int(11) DEFAULT NULL COMMENT '审批的任务类别 0 普通审批 1 条件审批 2抄送 3转他人处理 4条件内的审批',

`examine_type` int(11) DEFAULT NULL COMMENT '审批人类型 0 固定人员 1 固定人员上级 2角色 3发起人自选',

`user_ids` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '适用用户id 选择类型是上级时候可以指定某人的上级来处理',
`role_ids` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '适用角色id',

`examine_flag` int(1) DEFAULT 0 COMMENT '多人情况时候审批的人员审批方式  0默认一个爱一个默认顺序  1一个爱一个无序 2只要有一个',

`end_user_id` bigint(20) DEFAULT NULL COMMENT '上级审批截至人员 配置这个如果没有上级转该人审批 有上级这个配置失效',
`transfer_flag` int(1) DEFAULT 0 COMMENT '转他人处理flag 默认0 1表示这个是转他人的审批场景 2抄送的邮箱',
`transfer_task_id` bigint(20) DEFAULT NULL COMMENT '类型是转他人对应的主键',
`copy_emails` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '抄送的 email',

`remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
`update_time` datetime DEFAULT NULL COMMENT '修改时间',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
`company_id` bigint(20) DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='审批任务表';

CREATE TABLE `un_examine_condition` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`task_id` bigint(20) NOT NULL COMMENT '关联taskid',
`parent_id` bigint(20) DEFAULT 0 COMMENT '条件父关联 默认0',
`deep_ids` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '条件内关联的深度 有序',
`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '条件的名称',

`module_type` bigint(20) NOT NULL COMMENT '1 合同 2 回款 3发票',
`module_field_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '字段名称',
`module_field_search` int(10) unsigned DEFAULT NULL COMMENT '比较条件符号',
`module_field_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '字段值',

`examine_task_id` bigint(20) DEFAULT NULL COMMENT '条件内 关联的审批',

`remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
`update_time` datetime DEFAULT NULL COMMENT '修改时间',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
`company_id` bigint(20) DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='审批条件表';

-- 具体审批记录
CREATE TABLE `un_examine_record` (
`id` bigint(20) NOT NULL COMMENT '审核记录ID',
`examine_id` bigint(20) NOT NULL COMMENT '审核ID',
`module_type` bigint(20) NOT NULL COMMENT '1 合同 2 回款 3发票',
`relation_id` bigint(20) DEFAULT NULL COMMENT '关联业务主键ID',
`status` int(11) DEFAULT NULL COMMENT '记录状态 0 正常 1 终止 2 暂停  3 作废',
`examine_status` int(11) DEFAULT NULL COMMENT '审核状态 0 未审核 1 审核通过 2 审核拒绝 3 审核中 4 已撤回 6创建',
`remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
`update_time` datetime DEFAULT NULL COMMENT '修改时间',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
`company_id` bigint(20) DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='审核记录表';


CREATE TABLE `un_examine_record_log` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`task_type` int(11) DEFAULT NULL COMMENT '审批的任务类别 0 普通审批 1 条件审批 2抄送 3转他人处理 4条件内的审批',

`examine_type` int(11) DEFAULT NULL COMMENT '审批人类型 0 固定人员 1 固定人员上级 2角色 3发起人自选',

`user_ids` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '适用用户id 选择类型是上级时候可以指定某人的上级来处理',
`role_ids` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '适用角色id',

`examine_flag` int(1) DEFAULT 0 COMMENT '多人情况时候审批的人员审批方式  0默认一个爱一个默认顺序  1一个爱一个无序 2只要有一个',

`end_user_id` bigint(20) DEFAULT NULL COMMENT '上级审批截至人员 配置这个如果没有上级转该人审批 有上级这个配置失效',
`transfer_flag` int(1) DEFAULT 0 COMMENT '转他人处理flag 默认0 1表示这个是转他人的审批场景 2抄送的邮箱',
`transfer_task_id` bigint(20) DEFAULT NULL COMMENT '类型是转他人对应的主键',
`copy_emails` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '抄送的 email',

`remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
`update_time` datetime DEFAULT NULL COMMENT '修改时间',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
`company_id` bigint(20) DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='审批任务日志表';


CREATE TABLE `un_examine_record_condition` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`task_id` bigint(20) NOT NULL COMMENT '关联taskid',
`parent_id` bigint(20) DEFAULT 0 COMMENT '条件父关联 默认0',
`deep_ids` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '条件内关联的深度 有序',
`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '条件的名称',

`module_type` bigint(20) NOT NULL COMMENT '1 合同 2 回款 3发票',
`module_field_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '字段名称',
`module_field_search` int(10) unsigned DEFAULT NULL COMMENT '比较条件符号',
`module_field_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '字段值',

`examine_task_id` bigint(20) DEFAULT NULL COMMENT '条件内 关联的审批',

`remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
`update_time` datetime DEFAULT NULL COMMENT '修改时间',
`update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
`company_id` bigint(20) DEFAULT NULL COMMENT '企业id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='审批条件表';


-- CREATE TABLE `un_examine_flow` (
-- `id` bigint(20) NOT NULL COMMENT '审核流程ID',
-- `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '名称',
-- `examine_id` bigint(20) unsigned DEFAULT NULL COMMENT '审批ID',
-- `examine_type` int(11) NOT NULL COMMENT '0 条件 1 指定成员 2 主管 3 角色 4 发起人自选 5 连续多级主管',
-- `examine_error_handling` int(11) NOT NULL DEFAULT '1' COMMENT '审批找不到用户或者条件均不满足时怎么处理 1 自动通过 2 管理员审批',
-- `condition_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '条件ID',
-- `sort` int(11) NOT NULL COMMENT '执行顺序，不可为空',
-- `create_time` datetime DEFAULT NULL COMMENT '创建时间',
-- `create_user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
-- `batch_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '批次ID',
-- `company_id` bigint(20) DEFAULT NULL COMMENT '企业ID',
-- `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
-- `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
-- PRIMARY KEY (`flow_id`) USING BTREE,
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='审批流程表';
