package AlGO.Permutation;

//주사위를 3번 던져서 나올 수 있는 모든 경우
/*
 * 1. 중복된 결과가 있음
 * 2. 구성이 동일할 수 있음 (순서는 다름)
 */

public class Permutation_Dice_1 {
    public static void main(String[] args) {
        System.out.println("주사위를 3번 던져서 나올 수 있는 모든 경우");
        System.out.println("===================================");

        int count = 0;

        for (int first = 1; first <= 6; first++) {
            for (int second = 1; second <= 6; second++) {
                for(int third = 1; third <= 6; third++) {
                    count++;

                    System.out.printf("[ %d, %d, %d]", first, second, third);
                    System.out.println();
                }
            }
        }
        
    }

}
