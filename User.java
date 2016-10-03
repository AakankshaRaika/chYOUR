package test;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int age = 21;
    private String name = "Ash";
    private List<String> messages = new ArrayList<String>() {
        {
            add("msg 1");
            add("msg 2");
            add("msg 3");
        }
    };

    //getter and setter methods

    @Override
    public String toString() {
        return "User [age=" + age + ", name=" + name + ", " +
                "messages=" + messages + "]";
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
