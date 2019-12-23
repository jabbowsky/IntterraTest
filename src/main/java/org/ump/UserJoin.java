package org.ump;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UserJoin {
    public static void main(String[] args) {
        // read input
        List<UserWithEmails> users = new ArrayList<>();
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        // Reading data using readLine
        boolean getEmptyString = false;
        while (!getEmptyString) {
            try {
                String userAndEmails = reader.readLine();
                if (userAndEmails.length() > 0) {
                    users.add(new UserWithEmails(userAndEmails));
                } else {
                    getEmptyString = true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // join them
        UsersJoiner clearer = new UsersJoiner();

        // print to output
        clearer.clear(users).forEach(
                System.out::println);

    }
}
