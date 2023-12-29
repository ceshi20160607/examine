package com.kakarote.crm.entity.tianyancha;

import com.kakarote.crm.entity.VO.CrmEnterpriseCbIcVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
public class BriefCancel implements Serializable {
    @ApiModelProperty("公告id")
    private String id;
    @ApiModelProperty("公司名")
    private String company_name;
    @ApiModelProperty("注册号")
    private String reg_num;
    @ApiModelProperty("统一社会信用代码")
    private String credit_code;
    @ApiModelProperty("公告期")
    private String announcement_term;
    @ApiModelProperty("公告结束日期")
    private String announcement_end_date;
    @ApiModelProperty("登记机关")
    private String reg_authority;
    @ApiModelProperty("原链接")
    private String investor_commitment_download_url;
    @ApiModelProperty("oss路径")
    private String ossPath;
    @ApiModelProperty("简易注销结果")
    private String brief_cancel_result;
    @ApiModelProperty("公告申请日期")
    private String announcement_apply_date;
    @ApiModelProperty("异议")
    private List<Objection> objectionList;
}
