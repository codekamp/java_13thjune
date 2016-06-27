import java.util.List;

/**
 * Created by cerebro on 24/06/16.
 */
public class Demo {
    public static void main(String[] args) {

        try {
            List<String> allFriends = FriendService.fetchFriendlist(10);
            System.out.println("2nd line of try");


        } catch (InternetUnavailableException e) {
            //write code to handle the situation when function fails due to
            //unavailablity of internet
            System.out.println(
                    "Interntet not working. So we are going to ask user" +
                            " to check his internet settings and try again."
            );
        } catch (UserIdInvalidException e) {
            //write code to hande situation when function fails due to
            //invalid user id
            System.out.println(
                    "User id invalid, so we are going to ask user to choose a " +
                            "valid profile"
            );
        } finally {
            System.out.println("hello world! this is finally block");
        }

        System.out.println("after try catch");
    }
}
