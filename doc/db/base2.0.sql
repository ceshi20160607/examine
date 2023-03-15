DROP TABLE IF EXISTS `un_examine`;
CREATE TABLE `un_examine`  (
                               `id` bigint(20) UNSIGNED NOT NULL COMMENT '审批ID',
                               `module_type` bigint(20) NOT NULL COMMENT '1 合同 2 回款 3发票   101 普通审批 102 请假审批 103 出差审批 104 加班审批 105 差旅报销 106 借款申请',
                               `type` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '0 默认基础 1默认修改使用中 2自定义',
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

-- ----------------------------
-- Records of un_examine
-- ----------------------------

-- ----------------------------
-- Table structure for un_examine_group
-- ----------------------------
DROP TABLE IF EXISTS `un_examine_group`;
CREATE TABLE `un_examine_group`  (
                                     `id` bigint(20) NOT NULL COMMENT '分组id',
                                     `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分组名称',
                                     `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
                                     `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '更新人',
                                     `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                     `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                     `company_id` bigint(20) NULL DEFAULT NULL COMMENT '企业id',
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '审批分组表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of un_examine_group
-- ----------------------------

-- ----------------------------
-- Table structure for un_examine_record
-- ----------------------------
DROP TABLE IF EXISTS `un_examine_record`;
CREATE TABLE `un_examine_record`  (
                                      `id` bigint(20) NOT NULL COMMENT '审核记录ID',
                                      `examine_id` bigint(20) NOT NULL COMMENT '审核ID',
                                      `module_type` bigint(20) NOT NULL COMMENT '1 合同 2 回款 3发票',
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

-- ----------------------------
-- Records of un_examine_record
-- ----------------------------

-- ----------------------------
-- Table structure for un_examine_record_log
-- ----------------------------
DROP TABLE IF EXISTS `un_examine_record_log`;
CREATE TABLE `un_examine_record_log`  (
                                          `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                          `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '条件的名称',
                                          `record_id` bigint(20) NULL DEFAULT NULL COMMENT '关联的record_id',
                                          `task_type` int(11) NULL DEFAULT NULL COMMENT '审批的任务类别 0 普通审批 1 条件审批 2抄送 3转他人处理 4条件内的审批',
                                          `examine_type` int(11) NULL DEFAULT NULL COMMENT '审批人类型 0 固定人员 1 固定人员上级 2角色 3发起人自选',
                                          `task_id` bigint(20) NULL DEFAULT NULL COMMENT '关联的task_id',
                                          `task_sort` int(11) NULL DEFAULT NULL COMMENT '关联的task总排序',
                                          `condition_parent_id` bigint(20) NULL DEFAULT 0 COMMENT '条件父关联 默认0',
                                          `condition_module_type` bigint(20) NOT NULL COMMENT '1 合同 2 回款 3发票',
                                          `condition_module_search` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字段名称',
                                          `condition_module_field_search` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '条件',
                                          `examine_flag` int(1) NULL DEFAULT 0 COMMENT '多人情况时候审批的人员审批方式  0默认一个爱一个默认顺序  1一个爱一个无序 2只要有一个',
                                          `user_id` bigint(20) NULL DEFAULT NULL COMMENT '适用用户id 选择类型是上级时候可以指定某人的上级来处理',
                                          `role_id` bigint(20) NULL DEFAULT NULL COMMENT '适用角色id',
                                          `status` int(1) NULL DEFAULT NULL COMMENT '审批状态',
                                          `transfer_flag` int(1) NULL DEFAULT 0 COMMENT '转他人处理flag 默认0 1表示这个是转他人的审批场景 2抄送的邮箱',
                                          `transfer_user_id` bigint(20) NULL DEFAULT NULL COMMENT '类型是转他人对应的主键',
                                          `transfer_status` int(1) NULL DEFAULT NULL COMMENT '类型是转他人 审批状态',
                                          `end_user_id` bigint(20) NULL DEFAULT NULL COMMENT '上级审批截至人员 配置这个如果没有上级转该人审批 有上级这个配置失效',
                                          `copy_emails` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '抄送的 email',
                                          `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
                                          `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                          `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
                                          `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
                                          `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人',
                                          `company_id` bigint(20) NULL DEFAULT NULL COMMENT '企业id',
                                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '审批任务日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of un_examine_record_log
-- ----------------------------

-- ----------------------------
-- Table structure for un_examine_setting
-- ----------------------------
DROP TABLE IF EXISTS `un_examine_setting`;
CREATE TABLE `un_examine_setting`  (
                                       `id` bigint(20) NOT NULL COMMENT 'id',
                                       `examine_id` bigint(20) NOT NULL COMMENT '审批id',
                                       `rule_type` int(11) NULL DEFAULT NULL COMMENT '0撤回规则 1通过规则 ',
                                       `recheck_type` int(11) NULL DEFAULT NULL COMMENT '撤回之后重新审核操作 1 从第一层开始 2 从拒绝的层级开始',
                                       `pass_type` int(11) NULL DEFAULT NULL COMMENT '通过规则类型 1 超时自动通过 2 转他人处理',
                                       `pass_rule` int(11) NULL DEFAULT NULL COMMENT '通过规则类型 1 该审批人一个同意该人全部同意 2 该相同审批人同意 3该审批人依次审批',
                                       `limit_time_type` int(11) NULL DEFAULT NULL COMMENT '现时配置是否开启  0默认不开启  1开启 设置超时通过必须设置现时',
                                       `limit_time_num` int(11) NULL DEFAULT NULL COMMENT '现时时间',
                                       `limit_time_unit` int(11) NULL DEFAULT NULL COMMENT '现时时间单位',
                                       `apply_type` int(10) NOT NULL COMMENT '适用类型 0默认全公司 1用户 2部门',
                                       `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
                                       `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '更新人',
                                       `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                       `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                       `company_id` bigint(20) NULL DEFAULT NULL COMMENT '企业id',
                                       PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '审批高级设置及异常处理规则' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of un_examine_setting
-- ----------------------------

-- ----------------------------
-- Table structure for un_examine_setting_user
-- ----------------------------
DROP TABLE IF EXISTS `un_examine_setting_user`;
CREATE TABLE `un_examine_setting_user`  (
                                            `id` bigint(20) NOT NULL COMMENT 'id',
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

-- ----------------------------
-- Records of un_examine_setting_user
-- ----------------------------

-- ----------------------------
-- Table structure for un_examine_template
-- ----------------------------
DROP TABLE IF EXISTS `un_examine_template`;
CREATE TABLE `un_examine_template`  (
                                        `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                        `examine_id` bigint(20) NULL DEFAULT NULL COMMENT '审批id',
                                        `task_type` int(11) NULL DEFAULT NULL COMMENT '审批的任务类别 0 普通审批 1 条件审批 2抄送 3转他人处理 4条件内的审批',
                                        `examine_type` int(11) NULL DEFAULT NULL COMMENT '审批人类型 0 固定人员 1 固定人员上级 2角色 3发起人自选',
                                        `condition_col_depth` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '总列的深度',
                                        `condition_parent_id` bigint(20) NULL DEFAULT NULL COMMENT '关联的task_id',
                                        `condition_parent_depth` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '条件内关联的深度 有序',
                                        `condition_module_type` bigint(20) NULL DEFAULT NULL COMMENT '1 合同 2 回款 3发票',
                                        `condition_module_field_search` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '条件',
                                        `examine_flag` int(1) NULL DEFAULT 0 COMMENT '多人情况时候审批的人员审批方式  0默认一个爱一个默认顺序  1一个爱一个无序 2只要有一个',
                                        `user_ids` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '适用用户id 选择类型是上级时候可以指定某人的上级来处理',
                                        `role_ids` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '适用角色id',
                                        `transfer_flag` int(1) NULL DEFAULT 0 COMMENT '转他人处理flag 默认0 1表示这个是转他人的审批场景 2抄送的邮箱',
                                        `transfer_user_id` bigint(20) NULL DEFAULT NULL COMMENT '类型是转他人对应的主键',
                                        `transfer_status` int(1) NULL DEFAULT NULL COMMENT '类型是转他人 审批状态',
                                        `end_user_id` bigint(20) NULL DEFAULT NULL COMMENT '上级审批截至人员 配置这个如果没有上级转该人审批 有上级这个配置失效',
                                        `copy_emails` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '抄送的 email',
                                        `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
                                        `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                        `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
                                        `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
                                        `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人',
                                        PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '审批任务日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of un_examine_template
-- ----------------------------
INSERT INTO `un_examine_template` VALUES (1, 1, 1, 1, '0', 0, NULL, NULL, NULL, 0, '1,2,3,4', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `un_examine_template` VALUES (2, 1, 2, NULL, '1', 1, '1', 1, '{\"name\":\"zhangsna\",\"type\":1,\"value\":3}', 0, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `un_examine_template` VALUES (3, 1, 2, NULL, '1', 1, '1', 1, '{\"name\":\"zhangsna\",\"type\":1,\"value\":3}', 0, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `un_examine_template` VALUES (4, 1, 2, NULL, '1', 1, '1', 1, '{\"name\":\"zhangsna\",\"type\":1,\"value\":3}', 0, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `un_examine_template` VALUES (5, 1, 1, 1, NULL, 2, '1,2', NULL, NULL, 0, '1,2,3,4', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `un_examine_template` VALUES (6, 1, 1, 1, NULL, 3, '1,3', NULL, NULL, 0, '1,2,3,4', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `un_examine_template` VALUES (7, 1, 2, NULL, NULL, 5, '1,2,5', 1, '{\"name\":\"zhangsna\",\"type\":1,\"value\":3}', 0, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `un_examine_template` VALUES (8, 1, 2, NULL, NULL, 5, '1,2,5', 1, '{\"name\":\"zhangsna\",\"type\":1,\"value\":3}', 0, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `un_examine_template` VALUES (9, 1, 1, 3, NULL, 7, '1,2,5,7', NULL, NULL, 0, '1,2,3,4', '1,2', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `un_examine_template` VALUES (10, 1, 2, NULL, NULL, 9, '1,2,5,7,9', 1, '{\"name\":\"zhangsna\",\"type\":1,\"value\":3}', 0, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `un_examine_template` VALUES (11, 1, 2, NULL, NULL, 9, '1,2,5,7,9', 1, '{\"name\":\"zhangsna\",\"type\":1,\"value\":3}', 0, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `un_examine_template` VALUES (12, 1, 1, 1, NULL, 0, NULL, NULL, NULL, 0, '1,2,3,4', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `un_examine_template` VALUES (13, 1, 2, NULL, NULL, 12, '12', 1, '{\"name\":\"zhangsna\",\"type\":1,\"value\":3}', 0, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `un_examine_template` VALUES (14, 1, 2, NULL, NULL, 12, '12', 1, '{\"name\":\"zhangsna\",\"type\":1,\"value\":3}', 0, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `un_examine_template` VALUES (15, 1, 1, 1, NULL, 0, NULL, NULL, NULL, 0, '1,2,3,4', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
