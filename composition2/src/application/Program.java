package application;

import entities.Comment;
import entities.Post;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        LocalDateTime d05 = LocalDateTime.parse("2018-06-21T13:05:44");
        LocalDateTime d06 = LocalDateTime.parse("2018-07-28T23:14:19");

        Comment c1 = new Comment("Have a nice trip!");
        Comment c2 = new Comment("Wow that's awesome!");
        Post p1 = new Post(d05, "Traveling to New Zealand", "I'm going to visit this wonderful country!", 12);
        p1.addComment(c1);
        p1.addComment(c2);

        System.out.println(p1);

        Comment c3 = new Comment("Good night");
        Comment c4 = new Comment("May the Force be with you");
        Post p2 = new Post(d06, "Good night guys", "See you tomorrow", 5);
        p2.addComment(c3);
        p2.addComment(c4);

        System.out.println(p2);
    }
}
