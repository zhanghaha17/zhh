package com.example.zhh.pojo;

import java.io.Serializable;
import java.util.Date;

public class TTaishi implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_taishi.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_taishi.time
     *
     * @mbggenerated
     */
    private Date time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_taishi.value
     *
     * @mbggenerated
     */
    private String value;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_taishi
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_taishi.id
     *
     * @return the value of t_taishi.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_taishi.id
     *
     * @param id the value for t_taishi.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_taishi.time
     *
     * @return the value of t_taishi.time
     *
     * @mbggenerated
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_taishi.time
     *
     * @param time the value for t_taishi.time
     *
     * @mbggenerated
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_taishi.value
     *
     * @return the value of t_taishi.value
     *
     * @mbggenerated
     */
    public String getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_taishi.value
     *
     * @param value the value for t_taishi.value
     *
     * @mbggenerated
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_taishi
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", time=").append(time);
        sb.append(", value=").append(value);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}