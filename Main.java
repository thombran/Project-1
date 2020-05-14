package project1;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	    SimpleDate s1 = new SimpleDate("02/29/2020");
       SimpleDate s2 = new SimpleDate("12/31/2020");
//        System.out.println(s1.equals(s2));
        SimpleDate s3 = s1.daysFromNow(2);
        System.out.println(s3.toString());
    }
}
