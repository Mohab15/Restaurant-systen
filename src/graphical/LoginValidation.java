package graphical;

import java.util.List;

import XML.*;

public class LoginValidation {
    private List<User> users_list = XMLReader.users;

    public User validation(String username, String password) {
        for (int i = 0; i < users_list.size(); i++) {
            if (users_list.get(i).getUsername().equals(username)) {
                if (users_list.get(i).getPassword().equals(password))
                    return users_list.get(i);
            }
        }
        return null;
    }
}

