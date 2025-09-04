package z_java_test_01;

import java.io.IOException;

public class p1_01_1 {

    public static void main(String[] args) throws IOException{
        for(int i = 0; i < 4; i++) {
            int star_num = 4 - i;
            int space = i;

            for(int j = 0; j < space; j++) {
                System.out.print(" " + " ");
            }

            for(int j = 0; j < star_num; j++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
        
    }

}
