package com.mxiaoy.community.service;

import com.mxiaoy.community.dto.PaginationDto;
import com.mxiaoy.community.dto.QuestionDto;
import com.mxiaoy.community.mapper.QuestionMapper;
import com.mxiaoy.community.mapper.UserMapper;
import com.mxiaoy.community.model.Question;
import com.mxiaoy.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public PaginationDto list(Integer page, Integer size) {

        Integer offset = size * (page - 1);
        List<Question> questions = questionMapper.list(offset, size);
        List<QuestionDto> questionDtoList = new ArrayList<>();

        PaginationDto paginationDto = new PaginationDto();

        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question, questionDto);
            questionDto.setUser(user);
            questionDtoList.add(questionDto);
        }

        paginationDto.setQuestions(questionDtoList);
        Integer totalCount = questionMapper.questionCount();
        paginationDto.setPagination(totalCount, page, size);
        return paginationDto;
    }
}
