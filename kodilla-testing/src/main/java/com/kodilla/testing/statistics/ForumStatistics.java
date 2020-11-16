package com.kodilla.testing.statistics;

public class ForumStatistics {
    private double avgPostsPerUser;
    private double avgCommentsPerUser;
    private double avgCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics){
        double numOfUsers = statistics.usersName().size();
        double numOfPosts = statistics.postsCount();
        double numOfComments = statistics.commentsCount();

        avgPostsPerUser = numOfPosts/numOfUsers;
        avgCommentsPerUser = numOfComments/numOfUsers;
        avgCommentsPerPost = numOfComments/numOfPosts;
    }

    public void showStatistics(){
        System.out.println("Average number of posts per user: " + avgPostsPerUser + "\n" +
                "Average number of comments per user: " + avgCommentsPerUser + "\n" +
                "Average number of comments per post: " + avgCommentsPerPost);
    }

    public double getAvgPostsPerUser() {
        return avgPostsPerUser;
    }

    public double getAvgCommentsPerUser() {
        return avgCommentsPerUser;
    }

    public double getAvgCommentsPerPost() {
        return avgCommentsPerPost;
    }
}
