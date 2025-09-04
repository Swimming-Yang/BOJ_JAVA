package z_java_test_01;

public class p1_01_2 {

    public static int cur_num;

    public static void main(String[] args) {

        for(int i = 1; i <= 5; i++) {
 
        if(i % 2 == 1) { //홀수 줄
            cur_num = i * 5 - 4;
            for(int j = 0; j < 5; j++) {
                System.out.print(cur_num + " ");
                cur_num++;
            }
        } else if (i % 2 == 0) {
            cur_num = i * 5;
            for(int j = 5; j > 0; j--) {
                System.out.print(cur_num + " ");
                cur_num--;
            }
        }
        System.out.println();
    }
        
    }


}


