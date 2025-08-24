package AlGO.재귀;

public class factorial {

    public static int factorial(int n) {
        //기저 조건 (Base Case) - 재귀 호출을 멈추는 조건
        if(n == 1 || n == 0) {
            return 1;
        }

        //재귀 호출 (Recursive Case) - 자기 자신을 호출
        return n * factorial(n - 1);
        }


    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorial(4));
        System.out.println(factorial(0));
        System.out.println(factorial(1));

    }

}
