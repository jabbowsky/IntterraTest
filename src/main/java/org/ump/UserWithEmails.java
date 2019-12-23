package org.ump;

import java.util.HashSet;
import java.util.Set;

public class UserWithEmails {
    UserWithEmails parent;
    int level = 0;
    String userName;
    Set<String> emails;

    UserWithEmails(String textLine) throws Exception {
        emails = new HashSet<>();
        parse(textLine);
    }

    private void parse(String textLine) throws Exception {
        String[] data = textLine.split("\\s*->\\s*");
        this.userName = data[0];
        if (data.length > 1 && data[1].length() > 0) {
            String[] emails = data[1].split("\\s*,\\s*");
            for (String e : emails) {
                this.emails.add(e);
            }
        } else {
            throw new FormatException();
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

    class FormatException extends Exception {
        @Override
        public String toString() {
            return "User & email format exception: " +
                    "expected \"user -> email1, email2, email3\"";
        }
    }
}
