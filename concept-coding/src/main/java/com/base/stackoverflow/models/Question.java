package com.base.stackoverflow.models;

import com.base.stackoverflow.enums.EventType;

import java.util.*;

public class Question extends Post{

    private final String title;

    private final Set<Tag> tags;

    private final List<Answer> answers;

    private Answer acceptedAnswer;


    public Question(String body, User user,String title,Set<Tag> tags) {
        super(body, user);
        this.title=title;
        this.tags=new HashSet<>(tags);
        this.answers=new ArrayList<>();
    }

    public void setAnswer(Answer answer){
        answers.add(answer);
    }

    public void setAnswerAccepted(Answer answer){
        synchronized (this){
            if(!acceptedAnswer.isAccepted() && !Objects.equals(answer.getAuthor().getId(), this.getAuthor().getId())){
                acceptedAnswer=answer;
                acceptedAnswer.setAccepted(true);
                notifyObservers(new Event(this.getAuthor(),answer, EventType.ANSWER_ACCEPTED));
            }
        }

    }

    public String getTitle() {
        return title;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public Answer getAcceptedAnswer() {
        return acceptedAnswer;
    }
}
