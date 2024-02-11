package com.crio.codingame.services;

import java.util.ArrayList;
import java.util.List;

import com.crio.codingame.entities.Level;
import com.crio.codingame.entities.Question;
import com.crio.codingame.repositories.IQuestionRepository;
// import com.crio.codingame.repositories.QuestionRepository;

public class QuestionService implements IQuestionService{
    private final IQuestionRepository questionRepository;

    public QuestionService(IQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    int countQuest=1;
    @Override
    public Question create(String title, Level level, Integer difficultyScore) {
     final Question question = new Question(""+countQuest ,title,level, difficultyScore);
     countQuest+=1;
        return questionRepository.save(question);
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Get All Questions if level is not specified.
    // Or
    // Get List of Question which matches the level provided.

    @Override
    public List<Question> getAllQuestionLevelWise(Level level) {
        List<Question>res=new ArrayList<>();
        if(level!=null)
        res=questionRepository.findAllQuestionLevelWise(level);
        else{
            for(Question q:questionRepository.findAll()){
                res.add(q);
            }
        }
     return res;
    //  Collections.emptyList();
    }
    
}
