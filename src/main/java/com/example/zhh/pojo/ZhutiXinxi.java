package com.example.zhh.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

//主体信息
//档案主体
@XmlAccessorType(XmlAccessType.FIELD)
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "NNDD","DABM","DH","QZH","MLH","JZH","MJ","BGQX","LJBM","LJR","LJRQ","GDBM","GDR","GDRQ","YJR","JSR","JSRQ"
})
public class ZhutiXinxi {
    private String NNDD;
    private String DABM;
    private String DH;
    private String QZH;
    private String MLH;
    private String JZH;
    private String MJ;
    private String BGQX;
    private String LJBM;
    private String LJR;
    private String LJRQ;
    private String GDBM;
    private String GDR;
    private String GDRQ;
    private String YJR;
    private String JSR;
    private String JSRQ;

    public String getJSRQ() {
        return JSRQ;
    }

    public void setJSRQ(String JSRQ) {
        this.JSRQ = JSRQ;
    }

    public String getJSR() {
        return JSR;
    }

    public void setJSR(String JSR) {
        this.JSR = JSR;
    }

    public String getYJR() {
        return YJR;
    }

    public void setYJR(String YJR) {
        this.YJR = YJR;
    }

    public String getGDRQ() {
        return GDRQ;
    }

    public void setGDRQ(String GDRQ) {
        this.GDRQ = GDRQ;
    }

    public String getGDR() {
        return GDR;
    }

    public void setGDR(String GDR) {
        this.GDR = GDR;
    }

    public String getGDBM() {
        return GDBM;
    }

    public void setGDBM(String GDBM) {
        this.GDBM = GDBM;
    }

    public String getLJRQ() {
        return LJRQ;
    }

    public void setLJRQ(String LJRQ) {
        this.LJRQ = LJRQ;
    }

    public String getLJR() {
        return LJR;
    }

    public void setLJR(String LJR) {
        this.LJR = LJR;
    }

    public String getLJBM() {
        return LJBM;
    }

    public void setLJBM(String LJBM) {
        this.LJBM = LJBM;
    }

    public String getBGQX() {
        return BGQX;
    }

    public void setBGQX(String BGQX) {
        this.BGQX = BGQX;
    }

    public String getMJ() {
        return MJ;
    }

    public void setMJ(String MJ) {
        this.MJ = MJ;
    }

    public String getJZH() {
        return JZH;
    }

    public void setJZH(String JZH) {
        this.JZH = JZH;
    }

    public String getMLH() {
        return MLH;
    }

    public void setMLH(String MLH) {
        this.MLH = MLH;
    }

    public String getQZH() {
        return QZH;
    }

    public void setQZH(String QZH) {
        this.QZH = QZH;
    }

    public String getDH() {
        return DH;
    }

    public void setDH(String DH) {
        this.DH = DH;
    }

    public String getDABM() {
        return DABM;
    }

    public void setDABM(String DABM) {
        this.DABM = DABM;
    }

    public String getNNDD() {
        return NNDD;
    }

    public void setNNDD(String NNDD) {
        this.NNDD = NNDD;
    }
}
