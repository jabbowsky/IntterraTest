package org.ump;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserJoin {
    public static void main(String[] args) {
        // read input
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(n + " cases to enter: ");
        List<UserWithEmails> users = new ArrayList<>();
        // create users and email.
        while(n > 0){
            users.add(new UserWithEmails(sc.nextLine()));
            n--;
        }

        // join them
        UsersJoiner clearer = new UsersJoiner();
        System.out.println("Output");

        // print to output
        clearer.clear(users).forEach(
                System.out::println);

    }
}
