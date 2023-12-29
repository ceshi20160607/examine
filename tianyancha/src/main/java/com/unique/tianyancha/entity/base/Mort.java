package com.kakarote.crm.entity.tianyancha;

import com.kakarote.crm.entity.VO.CrmEnterpriseCbIcVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
public class Mort implements Serializable {
    @ApiModelProperty("表id")
    private String id;
    @ApiModelProperty("省份简称")
    private String base;
    @ApiModelProperty("登记编号")
    private String regNum;
    @ApiModelProperty("登记日期")
    private String regDate;
    @ApiModelProperty("公示日期")
    private String publishDate;
    @ApiModelProperty("状态")
    private String status;
    @ApiModelProperty("登记机关")
    private String regDepartment;
    @ApiModelProperty("被担保债权种类")
    private String type;
    @ApiModelProperty("被担保债权数额")
    private String amount;
    @ApiModelProperty("债务人履行债务的期限")
    private String term;
    @ApiModelProperty("担保范围")
    private String scope;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("概况种类(字段弃用)")
    private String overviewType;
    @ApiModelProperty("概况数额(字段弃用)")
    private String overviewAmount;
    @ApiModelProperty("概况担保的范围(字段弃用)")
    private String overviewScope;
    @ApiModelProperty("概况债务人履行债务的期限(字段弃用)")
    private String overviewTerm;
    @ApiModelProperty("概况备注(字段弃用)")
    private String overviewRemark;
    @ApiModelProperty("注销日期")
    private String cancelDate;
    @ApiModelProperty("注销原因")
    private String cancelReason;
    @ApiModelProperty("变更")
    private List<ChangeVO> changeList;
    @ApiModelProperty("变更")
    private List<PawnVO> pawnList;
    @ApiModelProperty("变更")
    private List<PeopleVO> peopleList;


    @NoArgsConstructor
    @Data
    public static class ChangeVO {
        @ApiModelProperty("变更时间")
        private String changeDate;
        @ApiModelProperty("变更内容")
        private String changeContent;
    }
    @NoArgsConstructor
    @Data
    public static class PawnVO {
        @ApiModelProperty("名称")
        private String pawnName;
        @ApiModelProperty("所有权归属")
        private String ownership;
        @ApiModelProperty("数量、质量、状况、所在地等情况")
        private String detail;
        @ApiModelProperty("备注")
        private String remark;
    }
    @NoArgsConstructor
    @Data
    public static class PeopleVO {
        @ApiModelProperty("抵押权人名称")
        private String peopleName;
        @ApiModelProperty("抵押权人证照/证件类型")
        private String licenseType;
        @ApiModelProperty("证照/证件号码")
        private String licenseNum;
    }
}
