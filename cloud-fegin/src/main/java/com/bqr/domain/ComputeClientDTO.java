package com.bqr.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author baiqirui
 * @version [版本号, 2017年3月15日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@ApiModel("返回的值对象")
public class ComputeClientDTO
{
    @ApiModelProperty(value = "加数")
    private Integer count;
    
    @ApiModelProperty(value = "物料名称")
    private String materialName;
    
    @ApiModelProperty(value = "物料ID（必传）")
    private Long materialId;
    
    @ApiModelProperty(value = "物料数量（必传）")
    private Double materialNum;
    
    @ApiModelProperty(value = "物料采购单位ID（必传）")
    private Long purchaseUnitId;
    
    @ApiModelProperty(value = "物料收货单位ID（必传）")
    private Long receiptUnitId;
    
    @ApiModelProperty(value = "物料采购单位名称")
    private String purchaseUnitName;
    
    @ApiModelProperty(value = "物料送货时间（必传）")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date deliveryDate;
    
    @ApiModelProperty(value = "采购单位到收货单位的换算比例（必传）")
    private Double pToRRate;
    
    @ApiModelProperty(value = "上午送货开始时间", hidden = true)
    private String forenoonStartTime;
    
    @ApiModelProperty(value = "上午送货结束时间", hidden = true)
    private String forenoonEndTime;
    
    @ApiModelProperty(value = "下午送货开始时间", hidden = true)
    private String afternoonStartTime;
    
    @ApiModelProperty(value = "下午送货结束时间", hidden = true)
    private String afternoonEndTime;
    
    
    
    public Integer getCount()
    {
        return count;
    }
    
    public void setCount(Integer count)
    {
        this.count = count;
    }
    
    public Double getpToRRate()
    {
        return pToRRate;
    }
    
    public void setpToRRate(Double pToRRate)
    {
        this.pToRRate = pToRRate;
    }
    
    public Long getReceiptUnitId()
    {
        return receiptUnitId;
    }
    
    public void setReceiptUnitId(Long receiptUnitId)
    {
        this.receiptUnitId = receiptUnitId;
    }
    
    public String getForenoonStartTime()
    {
        return forenoonStartTime;
    }
    
    public void setForenoonStartTime(String forenoonStartTime)
    {
        this.forenoonStartTime = forenoonStartTime;
    }
    
    public String getForenoonEndTime()
    {
        return forenoonEndTime;
    }
    
    public void setForenoonEndTime(String forenoonEndTime)
    {
        this.forenoonEndTime = forenoonEndTime;
    }
    
    public String getAfternoonStartTime()
    {
        return afternoonStartTime;
    }
    
    public void setAfternoonStartTime(String afternoonStartTime)
    {
        this.afternoonStartTime = afternoonStartTime;
    }
    
    public String getAfternoonEndTime()
    {
        return afternoonEndTime;
    }
    
    public void setAfternoonEndTime(String afternoonEndTime)
    {
        this.afternoonEndTime = afternoonEndTime;
    }
    
    public Date getDeliveryDate()
    {
        return deliveryDate;
    }
    
    public void setDeliveryDate(Date deliveryDate)
    {
        this.deliveryDate = deliveryDate;
    }
    
    public String getPurchaseUnitName()
    {
        return purchaseUnitName;
    }
    
    public void setPurchaseUnitName(String purchaseUnitName)
    {
        this.purchaseUnitName = purchaseUnitName;
    }
    
    public String getMaterialName()
    {
        return materialName;
    }
    
    public void setMaterialName(String materialName)
    {
        this.materialName = materialName;
    }
    
    public Long getMaterialId()
    {
        return materialId;
    }
    
    public void setMaterialId(Long materialId)
    {
        this.materialId = materialId;
    }
    
    public Double getMaterialNum()
    {
        return materialNum;
    }
    
    public void setMaterialNum(Double materialNum)
    {
        this.materialNum = materialNum;
    }
    
    public Long getPurchaseUnitId()
    {
        return purchaseUnitId;
    }
    
    public void setPurchaseUnitId(Long purchaseUnitId)
    {
        this.purchaseUnitId = purchaseUnitId;
    }
}