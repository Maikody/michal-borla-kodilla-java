package com.kodilla.testing.statistics;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {

    private ForumStatistics forumStatistics;

    @Mock
    private Statistics statisticsMock;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @BeforeEach
    public void setUp(){
        forumStatistics = new ForumStatistics();
        //Default conditions
        when(statisticsMock.commentsCount()).thenReturn(100);
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.usersName()).thenReturn(generateUsers(10));
    }

    @Test
    public void testCalculateAdvStatisticsZeroPosts(){
        when(statisticsMock.postsCount()).thenReturn(0);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(Double.POSITIVE_INFINITY, forumStatistics.getAvgCommentsPerPost(),0.01);
        assertEquals(10.0, forumStatistics.getAvgCommentsPerUser(),0.01);
        assertEquals(0.0, forumStatistics.getAvgPostsPerUser(),0.01);
    }

    @Test
    public void testCalculateAdvStatistics1000Posts(){
        when(statisticsMock.postsCount()).thenReturn(1000);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(0.1, forumStatistics.getAvgCommentsPerPost(),0.01);
        assertEquals(10.0, forumStatistics.getAvgCommentsPerUser(),0.01);
        assertEquals(100.0, forumStatistics.getAvgPostsPerUser(),0.01);
    }

    @Test
    public void testCalculateAdvStatisticsZeroComments(){
        when(statisticsMock.commentsCount()).thenReturn(0);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(0.0, forumStatistics.getAvgCommentsPerPost(),0.01);
        assertEquals(0.0, forumStatistics.getAvgCommentsPerUser(),0.01);
        assertEquals(5.0, forumStatistics.getAvgPostsPerUser(),0.01);
    }

    @Test
    public void testCalculateAdvStatisticsCommentsLessThanPosts(){
        when(statisticsMock.commentsCount()).thenReturn(25);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(0.5, forumStatistics.getAvgCommentsPerPost(),0.01);
        assertEquals(2.5, forumStatistics.getAvgCommentsPerUser(),0.01);
        assertEquals(5.0, forumStatistics.getAvgPostsPerUser(),0.01);
    }

    @Test
    public void testCalculateAdvStatisticsCommentsMoreThanPosts(){
        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(2.0, forumStatistics.getAvgCommentsPerPost(),0.01);
        assertEquals(10.0, forumStatistics.getAvgCommentsPerUser(),0.01);
        assertEquals(5.0, forumStatistics.getAvgPostsPerUser(),0.01);
    }

    @Test
    public void testCalculateAdvStatisticsCommentsZeroUsers(){
        when(statisticsMock.usersName()).thenReturn(new ArrayList<>());
        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(2.0, forumStatistics.getAvgCommentsPerPost(),0.01);
        assertEquals(Double.POSITIVE_INFINITY, forumStatistics.getAvgCommentsPerUser(),0.01);
        assertEquals(Double.POSITIVE_INFINITY, forumStatistics.getAvgPostsPerUser(),0.01);
    }

    @Test
    public void testCalculateAdvStatisticsComments100Users(){
        List<String> users = generateUsers(100);

        when(statisticsMock.usersName()).thenReturn(users);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(2.0, forumStatistics.getAvgCommentsPerPost(),0.01);
        assertEquals(1.0, forumStatistics.getAvgCommentsPerUser(),0.01);
        assertEquals(0.5, forumStatistics.getAvgPostsPerUser(),0.01);
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    private List<String> generateUsers(int numberOfUsers) {
        List<String > usersList = new ArrayList<>();
        for (int i = 1; i <= numberOfUsers; i++) {
            String user = "Username #" + i;
            usersList.add(user);
        }
        return usersList;
    }
}
