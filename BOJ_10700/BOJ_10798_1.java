import java.io.*;
import java.util.*;

public class BOJ_10798_1 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb;
    
    public static String[] word;

    public static void main(String[] args) throws IOException{
        sb = new StringBuilder();
        word = new String[5];
        
        //*총 다섯 줄의 입력이 주어진다. */
        for(int i = 0; i < 5; i++) {
            String cur_word = br.readLine();
            word[i] = cur_word;
        }

        for(int i = 0; i < 15; i++) {//*최대 글자 길이는 15자 */
            for(int j = 0; j < 5; j++) { //*5개의 단어 */
                if(i < word[j].length()) { //*i번째 단어 -> i가 글자길이보다 작아면(i번째 글자가 존재) */
                    sb.append(word[j].charAt(i));
                } else {
                    continue;
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}
