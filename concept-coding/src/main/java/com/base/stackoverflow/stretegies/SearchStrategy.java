package com.base.stackoverflow.stretegies;

import com.base.stackoverflow.models.Question;

import java.util.List;

public interface SearchStrategy {
    List<Question> search(List<Question> questions);
}
