import constant.Constants;
import util.CompareUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BootstrapTest {

    public static void main(String[] args) {

        String str1 = "ebc";
        String str2 = "bbc";

        System.out.println(str1.compareTo(str2));

        User user1 = new User("ebc", 1);
        User user2 = new User("bbc", 2);
        User user3 = new User("abc", 3);
        List<User> list = new ArrayList<User>(3);
        list.add(user1);
        list.add(user2);
        list.add(user3);

        Collections.sort(list, CompareUtil.<User>createComparator(Constants.ASC, "name"));

        for (User item : list) {
            System.out.println(item);
        }
    }

}
