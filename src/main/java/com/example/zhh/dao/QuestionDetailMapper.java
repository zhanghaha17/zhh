package com.example.zhh.dao;

import com.example.zhh.pojo.QuestionDetail;
import com.example.zhh.pojo.QuestionDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_detail
     *
     * @mbggenerated
     */
    int countByExample(QuestionDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_detail
     *
     * @mbggenerated
     */
    int deleteByExample(QuestionDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_detail
     *
     * @mbggenerated
     */
    int insert(QuestionDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_detail
     *
     * @mbggenerated
     */
    int insertSelective(QuestionDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_detail
     *
     * @mbggenerated
     */
    List<QuestionDetail> selectByExample(QuestionDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_detail
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") QuestionDetail record, @Param("example") QuestionDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_detail
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") QuestionDetail record, @Param("example") QuestionDetailExample example);
}