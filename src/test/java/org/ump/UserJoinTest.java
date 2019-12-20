package org.ump;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class UserJoinTest {

    @Test
    public void testTwoUsersJoin() throws IllegalArgumentException {
        List<UserWithEmails> users = new ArrayList<>();
        UserWithEmails a = new UserWithEmails("a -> a@b, b@c");
        UserWithEmails b = new UserWithEmails("b -> b@b, b@c");
        users.add(a);
        users.add(b);

        UsersJoiner clearer = new UsersJoiner();

        Set<UserWithEmails> result = clearer.clear(users);

        assertTrue(result.size() == 1);
        UserWithEmails c = (UserWithEmails) result.toArray()[0];
        assertEquals("a", c.userName);
        assertEquals("a -> a@b, b@c, b@b", c.toString());

    }

    @Test
    public void test100JoinWith100Email() throws IllegalArgumentException {
        List<UserWithEmails> users = new ArrayList<>();
        String lastEmail = "";
        for (int i = 0; i < 100; i++) {
            StringBuilder emails = new StringBuilder();
            emails.append("a" + i + " -> ");
            String delim = "";
            if (lastEmail != "") {
                delim = ", ";
            }
            emails.append(lastEmail);
            for (int j = 0; j < 100; j++) {
                String email = delim + i + "." + j + "@b123";
                delim = ", ";
                emails.append(email);
                lastEmail = email;
            }
            UserWithEmails a = new UserWithEmails(emails.toString());
            users.add(a);
        }

        UsersJoiner clearer = new UsersJoiner();
        Set<UserWithEmails> result = clearer.clear(users);

        assertTrue(result.size() == 1);
        UserWithEmails c = (UserWithEmails) result.toArray()[0];
        assertEquals("a0", c.userName);
        assertEquals("a0(10001)", c.userName + "(" + c.emails.size() + ")");
    }

    @Test
    public void test100000JoinWith10Email() throws IllegalArgumentException {
        List<UserWithEmails> users = new ArrayList<>();
        String lastEmail = "";
        for (int i = 0; i < 100000; i++) {
            StringBuilder emails = new StringBuilder();
            emails.append("a" + i + " -> ");
            String delim = "";
            if (lastEmail != "") {
                delim = ", ";
            }
            emails.append(lastEmail);
            for (int j = 0; j < 10; j++) {
                String email = delim + i + "." + j + "@b";
                delim = ", ";
                emails.append(email);
                lastEmail = email;
            }
            UserWithEmails a = new UserWithEmails(emails.toString());
            users.add(a);
        }

        UsersJoiner clearer = new UsersJoiner();
        Set<UserWithEmails> result = clearer.clear(users);

        assertTrue(result.size() == 1);
        UserWithEmails c = (UserWithEmails) result.toArray()[0];
        assertEquals("a0", c.userName);
        assertEquals("a0(1000001)", c.userName + "(" + c.emails.size() + ")");
    }


    @Test
    public void test100JoinWith10000Email() throws IllegalArgumentException {
        List<UserWithEmails> users = new ArrayList<>();
        String lastEmail = "";
        for (int i = 0; i < 100; i++) {
            StringBuilder emails = new StringBuilder();
            emails.append("a" + i + " -> ");
            String delim = "";
            if (i % 10 == 0) {
                if (lastEmail != "") {
                    delim = ", ";
                }
            } else {
                lastEmail = "";
            }
            emails.append(lastEmail);
            for (int j = 0; j < 10000; j++) {
                String email = delim + i + "." + j + "@b123";
                delim = ", ";
                emails.append(email);
                lastEmail = email;
            }
            UserWithEmails a = new UserWithEmails(emails.toString());
            users.add(a);
        }

        UsersJoiner clearer = new UsersJoiner();
        Set<UserWithEmails> result = clearer.clear(users);

        assertTrue(result.size() == 83);
    }


    @Test
    public void testTripleUsersJoin() throws IllegalArgumentException {
        List<UserWithEmails> users = new ArrayList<>();
        UserWithEmails a = new UserWithEmails("a -> a@b, b@c");
        UserWithEmails b = new UserWithEmails("b -> b@b, b@c");
        UserWithEmails c = new UserWithEmails("c -> c@b, d@c");
        UserWithEmails d = new UserWithEmails("d -> a@b, d@c");
        users.add(a);
        users.add(b);
        users.add(c);
        users.add(d);

        UsersJoiner clearer = new UsersJoiner();

        Set<UserWithEmails> result = clearer.clear(users);

        assertTrue(result.size() == 1);
        UserWithEmails r = (UserWithEmails) result.toArray()[0];
        assertEquals("a", r.userName);
        assertEquals("a -> a@b, b@c, c@b, b@b, d@c", r.toString());

    }


}