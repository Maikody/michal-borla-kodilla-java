package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        Forum forum = new Forum();
        forum.generateListOfUsers(10);

        Map<Integer, ForumUser> forumUserMap = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> LocalDate.now().getYear() - forumUser.getBirthDate().getYear() >= 20)
                .filter(forumUser -> forumUser.getNumberOfPosts() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserID,forumUser -> forumUser));

        forumUserMap.entrySet().stream()
                .map(entry -> "User ID: " + entry.getKey() + " -> " + entry.getValue())
                .forEach(System.out::println);

    }

}
