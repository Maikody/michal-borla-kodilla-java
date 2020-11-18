package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> usersList = new ArrayList<>();

    public List<ForumUser> getUserList(){
        return new ArrayList<>(usersList);
    }

    public void generateListOfUsers(int numberOfUsers){
        for(int i = 1; i <= numberOfUsers; i++){
            usersList.add(new ForumUser(i,"userName"+i, (i%2==0)?'M':'F',LocalDate.of(2005-i,12-i,30-i), (int)(10 * Math.random())));
        }
    }
}
