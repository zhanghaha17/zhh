package com.example.zhh.pojo;
//诉讼档案

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "诉讼档案")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {})
public class SusongDangan {

//    档案主体
    @XmlElement(name = "档案主体")
    private DanganZhuti danganZhuti;
//    主体信息
    @XmlElement(name = "主体信息")
    private ZhutiXinxi zhutiXinxi;
/*//     辅助信息
    private FuzhuXinxi fuzhuXinxi;
//      案件信息
    private AnjianXinxi anjianXinxi;
//      当事人信息
    private List<DangshirenXinxi> dangshirenXinxis;
//      卷册信息
    private JuanceXinxi juanceXinxi;
//      编目信息
    private List<BianmuXinxi> bianmuXinxis;
//影像文件信息
    private List<YingxiangwenjianXinxi> yingxiangwenjianXinxis;
//影像文件存放位置信息
    private YingxiangCunfangweizhi yingxiangCunfangweizhi;*/

    public DanganZhuti getDanganZhuti() {
        return danganZhuti;
    }

    public void setDanganZhuti(DanganZhuti danganZhuti) {
        this.danganZhuti = danganZhuti;
    }

    public ZhutiXinxi getZhutiXinxi() {
        return zhutiXinxi;
    }

    public void setZhutiXinxi(ZhutiXinxi zhutiXinxi) {
        this.zhutiXinxi = zhutiXinxi;
    }
}
