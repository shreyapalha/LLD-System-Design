package com.base.stackoverflow.stretegies;

import com.base.stackoverflow.models.Question;
import com.base.stackoverflow.models.Tag;
import com.base.stackoverflow.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserBasedSearchStretegy implements SearchStrategy{

    private final User user;


    public UserBasedSearchStretegy(User user){
        this.user=user;
    }


    @Override
    public List<Question> search(List<Question> questions) {
        List<Question> ans=new ArrayList<>();
        return questions.stream().filter(
                q-> q.getAuthor().getId().equalsIgnoreCase(user.getId())).collect(Collectors.toList());
    }
}
