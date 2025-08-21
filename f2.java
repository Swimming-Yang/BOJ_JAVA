import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class f2 {

    static class house{
        int x, y, dist;
        house(int X, int Y, int D){
            x = X;
            y = Y;
            dist = D;
        }

        Boolean can_connect(int x, int y){
            return (Math.abs(this.x - x) + Math.abs(this.y - y)) <= dist;
        }

        int get_dist(int x, int y){
            return (Math.abs(this.x - x) + Math.abs(this.y - y));
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            house[] houses = new house[n];
            for (int i = 0; i < houses.length; i++) {
                st = new StringTokenizer(br.readLine());
                int x, y, d;
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                houses[i] = new house(x+15, y+15, d);
            }
            for (int i = 0; i < houses.length; i++) {
                house cur = houses[i];
                int st_x = cur.x - cur.dist;
                int st_y = cur.y - cur.dist;
                for (int j = 0; j < cur.dist * 2 + 1; j++) {
                    for (int j2 = 0; j2 < cur.dist * 2 + 1; j2++) {
                        int nx = st_x + j2;
                        int ny = st_y + j;
                        if(nx < 0 || ny < 0 || nx >= 31 || ny >= 31 || (nx == cur.x && ny == cur.y)) continue;
                        if(!cur.can_connect(nx, ny)) continue;
                        int cx = nx;
                        int cy = ny;
                        for (int k = 0; k < houses.length; k++) {
                            house next = houses[k];
                            if(next.can_connect(cx, cy)) continue;
                        }
                    }
                }
            }
        }
    }
}
