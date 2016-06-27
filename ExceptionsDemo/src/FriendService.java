import java.util.LinkedList;
import java.util.List;

/**
 * Created by cerebro on 24/06/16.
 */
public class FriendService {

    public static boolean internetAvailable = false;
    public static boolean userIdValid = true;

    public static List<String> fetchFriendlist(int UserId) throws InternetUnavailableException, UserIdInvalidException {

        if (!internetAvailable) {
            throw new InternetUnavailableException();
        }

        if (!userIdValid) {
            throw new UserIdInvalidException("User id should be positive");

        }


        List<String> friendList = new LinkedList<>();


        // in a real app, it will be fetched from internet
        friendList.add("Barak Obama");
        friendList.add("Hilary Clinton");
        friendList.add("Bill Clinton");
        friendList.add("Narendera Modi");

        return friendList;
    }

}
