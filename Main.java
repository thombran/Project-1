package project1;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//	    SimpleDate s1 = new SimpleDate("02/29/2020");
       SimpleDate s2 = new SimpleDate("12/31/2020");
//        System.out.println(s1.equals(s2));

        s2.increment();
        s2.increment();
        System.out.println(s2.toString());
    }
}
