package org.ump;

import java.util.*;

public class UsersJoiner {

    Map<String, UserWithEmails> emailsMap = new HashMap<>();
    Set<UserWithEmails> topUsers = new HashSet<>();

    public Set<UserWithEmails> clear(List<UserWithEmails> users) {
        users.forEach(
                u -> {
                    final UserWithEmails[] usr = {findMainUser(u)};
                    u.emails.forEach(e -> {
                        if (emailsMap.containsKey(e)) {
                            UserWithEmails usrToUnion = emailsMap.get(e);
                            if (!usrToUnion.userName.equals(usr[0].userName)) {
                                usr[0] = unionUser(usr[0], usrToUnion);
                            }
                        } else {
                            topUsers.add(usr[0]);
                            emailsMap.put(e, usr[0]);
                        }
                    });
                }
        );
        return topUsers;
    }

    private UserWithEmails findMainUser(UserWithEmails user) {
        UserWithEmails mainUser = user;
        while (mainUser.parent != null) {
            mainUser = mainUser.parent;
        }
        return mainUser;
    }

    private UserWithEmails unionUser(UserWithEmails a, UserWithEmails b) {
        UserWithEmails from = findMainUser(a);
        UserWithEmails to = findMainUser(b);

        if (!from.equals(to)) {
            if (from.level > to.level) {
                to.parent = from;
                from.emails.addAll(to.emails);
                topUsers.remove(to);
                return from;
            } else if (to.level > from.level) {
                from.parent = to;
                to.emails.addAll(from.emails);
                topUsers.remove(from);
                return to;
            } else {
                from.parent = to;
                to.level++;
                to.emails.addAll(from.emails);
                topUsers.remove(from);
                return to;
            }
        }
        return from;
    }
}
