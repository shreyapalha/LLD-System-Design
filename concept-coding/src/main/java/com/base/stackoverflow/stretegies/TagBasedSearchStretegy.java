package com.base.stackoverflow.stretegies;

import com.base.stackoverflow.models.Question;
import com.base.stackoverflow.models.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TagBasedSearchStretegy implements SearchStrategy{

    private final Tag tag;


    public TagBasedSearchStretegy(Tag tag){
        this.tag=tag;
    }


    @Override
    public List<Question> search(List<Question> questions) {
        List<Question> ans=new ArrayList<>();
        return questions.stream().filter(
                q-> q.getTags().stream().anyMatch(
                        t->t.getName().equalsIgnoreCase(tag.getName()))).collect(Collectors.toList());
    }
}
