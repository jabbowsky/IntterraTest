package org.ump;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserJoin {
    public static void main(String[] args) {
        // read input
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<UserWithEmails> users = new ArrayList<>();
        // create users and email.
        while(n > 0){
            n--;
            users.add(new UserWithEmails(sc.next()));
        }

        // join them
        UsersJoiner clearer = new UsersJoiner();

        // print to output
        clearer.clear(users).forEach(
            System.out::println);

    }
}
