import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cerebro on 23/06/16.
 */
public class Demo {
    public static void main(String[] args) {

        List students = Student.allStudents();

        JButton button = (JButton)students.get(2);
    }



}