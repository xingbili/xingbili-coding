/*
 * 版权信息: © 聚均科技
 */
package test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 高管信息Dto
 *
 * @author xinghuolin
 * @date 2022/04/15 14:20
 **/
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class CorpSeniorDto implements Serializable {

    /**
     * 高管id
     */
    private Long id;
    /**
     * 企业id
     */
    private Long corpOrgId;
    /**
     * 高管姓名
     */
    private String seniorName;
    /**
     * 高管职务
     */
    private String seniorPosition;
    /**
     * 证件类型
     */
    private Integer idType;
    /**
     * 证件号码
     */
    private String idNo;
    /**
     * 证件换证/签发次数
     */
    private String numberOfIssues;
    /**
     * 手机号码
     */
    private String mobilePhone;

    /**
     * 证件正面文件Id
     */
    private Long idcardAFileId;

    /**
     * 证件反面文件ID
     */
    private Long idcardBFileId;

}
