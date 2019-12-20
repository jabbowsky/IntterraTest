package org.ump;

import java.util.HashSet;
import java.util.Set;

public class UserWithEmails {
    UserWithEmails parent;
    int level = 0;
    String userName;
    Set<String> emails;

    UserWithEmails(String textLine) {
        emails = new HashSet<>();
        parse(textLine);
    }

    private void parse(String textLine) {
        String[] data = textLine.split("\\s*->\\s*");
        this.userName = data[0];
        if (data[1].length() > 0) {
            String[] emails = data[1].split("\\s*,\\s*");
            for (String e : emails) {
                this.emails.add(e);
            }
        }
    }

    @Override
    public String toString() {
        String text = userName + " -> ";
        String delim = "";
        for (String e : emails) {
            text += delim + e;
            delim = ", ";
        }
        return text;
    }
}
