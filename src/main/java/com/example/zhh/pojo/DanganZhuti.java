package com.example.zhh.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

//档案主体
@XmlAccessorType(XmlAccessType.FIELD)
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "DHDM"
})
public class DanganZhuti {
    private String DHDM;

    public String getDHDM() {
        return DHDM;
    }

    public void setDHDM(String DHDM) {
        this.DHDM = DHDM;
    }
}
