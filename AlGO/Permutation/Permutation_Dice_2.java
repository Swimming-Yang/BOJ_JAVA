package AlGO.Permutation;
/*
 * 주사위를 3번 던져서 모두 다른수가 나올 수 있는 모든 경우
 */

public class Permutation_Dice_2 {
    public static void main(String[] args) {
        for (int first = 1; first <= 6; first++) {
            for (int second = 1; second <= 6; second++) {
                for(int third = 1; third <= 6; third++) {
                    
                    if(first != second && second != third && third != first) {
                        System.out.printf("[%d, %d, %d]", first, second, third);
                        System.out.println();
                    }
                }
            }
        }
    }
}
