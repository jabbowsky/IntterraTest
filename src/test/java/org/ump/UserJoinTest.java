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
        UserWithEmails c = (UserWithEmails)result.toArray()[0];
        assertEquals("a",c.userName );
        assertEquals("a -> ",c.toString());

    }

    @Test
    public void test100000() throws IllegalArgumentException{

        int testSize = 100000;
        for (int i = 0; i < testSize; i++) {
        }
        assertTrue(true);
    }


}