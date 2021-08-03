package com.example.demo.Service;

import com.example.demo.Exception.QuestionNotFoundException;
import com.example.demo.Repo.QuestionRepo;
import com.example.demo.model.Question;
import com.example.demo.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("QuestionService")
@Transactional
public class QuestionService {
    private QuestionRepo questionRepo;
    @Autowired

    public QuestionService(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }
    public Question findById(Long idQs) {
        return  questionRepo.findById(idQs).orElseThrow(() -> new QuestionNotFoundException("Question Not Found!!"));
    }



    public List<Question> findAll() {
        return questionRepo.findAll();
    }

    public List<Question> findByQuiz(Quiz quiz) {
        return questionRepo.findByQuiz(quiz);
    }

    public Question save(Question question) {
        return questionRepo.save(question);
    }


    public void delete(Long idQs) {
        questionRepo.deleteById(idQs);
    }


    public Question update(Question question) {
        return questionRepo.save(question);
    }
}

