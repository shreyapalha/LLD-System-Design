package com.base.stackoverflow;

import com.base.stackoverflow.enums.VoteType;
import com.base.stackoverflow.models.*;
import com.base.stackoverflow.observers.PostObserver;
import com.base.stackoverflow.observers.ReputationManager;
import com.base.stackoverflow.stretegies.SearchStrategy;

import java.util.*;

public class StackOverFlowEngine {
    private final Map<String, User> users=new HashMap<>();
    private final Map<String, Question> questions=new HashMap<>();
    private final Map<String, Answer> answers=new HashMap<>();
    private final PostObserver reputationManager=new ReputationManager();

    public User createUser(String name){
        User user=new User(name);
        users.put(user.getId(), user);
        return user;
    }

    public Question postQuestion(String userId, String title, String body, Set<Tag> tags) {
        User author = users.get(userId);
        Question question = new Question(body, author, title, tags);
        question.addObserver(reputationManager);
        questions.put(question.getId(), question);
        return question;
    }

    public Answer postAnswer(String userId, String questionId, String body) {
        User author = users.get(userId);
        Question question = questions.get(questionId);
        Answer answer = new Answer(body, author);
        answer.addObserver(reputationManager);
        question.setAnswer(answer);
        answers.put(answer.getId(), answer);
        return answer;
    }

    public void voteOnPost(String userId, String postId, VoteType voteType) {
        User user = users.get(userId);
        Post post = findPostById(postId);
        post.vote(user, voteType);
    }

    public void acceptAnswer(String questionId, String answerId) {
        Question question = questions.get(questionId);
        Answer answer = answers.get(answerId);
        question.setAnswerAccepted(answer);
    }

    public List<Question> searchQuestions(List<SearchStrategy> strategies) {
        List<Question> results = new ArrayList<>(questions.values());

        // Sequentially apply each filter strategy to the results of the previous one.
        for (SearchStrategy strategy : strategies) {
            results = strategy.search(results);
        }

        return results;
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    private Post findPostById(String postId) {
        if (questions.containsKey(postId)) {
            return questions.get(postId);
        } else if (answers.containsKey(postId)) {
            return answers.get(postId);
        }

        throw new NoSuchElementException("Post not found");
    }

}
