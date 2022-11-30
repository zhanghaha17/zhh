package com.example.zhh.dao;

import com.example.zhh.pojo.QuestionPracticeDetail;
import com.example.zhh.pojo.QuestionPracticeDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionPracticeDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_practice_detail
     *
     * @mbggenerated
     */
    int countByExample(QuestionPracticeDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_practice_detail
     *
     * @mbggenerated
     */
    int deleteByExample(QuestionPracticeDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_practice_detail
     *
     * @mbggenerated
     */
    int insert(QuestionPracticeDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_practice_detail
     *
     * @mbggenerated
     */
    int insertSelective(QuestionPracticeDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_practice_detail
     *
     * @mbggenerated
     */
    List<QuestionPracticeDetail> selectByExample(QuestionPracticeDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_practice_detail
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") QuestionPracticeDetail record, @Param("example") QuestionPracticeDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_practice_detail
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") QuestionPracticeDetail record, @Param("example") QuestionPracticeDetailExample example);
}