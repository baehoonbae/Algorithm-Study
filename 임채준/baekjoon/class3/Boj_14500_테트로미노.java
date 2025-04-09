package class3;

import java.io.*;
import java.util.*;

public class Boj_14500_테트로미노 {

    static int N, M, max = 0;
    static int[][] map;
    static int[][][] tetrominos = {
            {{0,0}, {0,1}, {0,2}, {0,3}},
            {{0,0}, {1,0}, {2,0}, {3,0}},

            {{0,0}, {0,1}, {1,0}, {1,1}},

            {{0,0}, {1,0}, {2,0}, {2,1}},
            {{0,0}, {0,1}, {0,2}, {1,0}},
            {{0,0}, {0,1}, {1,1}, {2,1}},
            {{0,2}, {1,0}, {1,1}, {1,2}},

            {{0,1}, {1,1}, {2,0}, {2,1}},
            {{0,0}, {1,0}, {1,1}, {1,2}},
            {{0,0}, {0,1}, {1,0}, {2,0}},
            {{0,0}, {0,1}, {0,2}, {1,2}},

            {{0,0}, {0,1}, {0,2}, {1,1}},
            {{0,1}, {1,0}, {1,1}, {2,1}},
            {{0,1}, {1,0}, {1,1}, {1,2}},
            {{0,0}, {1,0}, {1,1}, {2,0}},

            {{0,0}, {0,1}, {1,1}, {1,2}},
            {{0,1}, {1,0}, {1,1}, {2,0}},

            {{0,1}, {0,2}, {1,0}, {1,1}},
            {{0,0}, {1,0}, {1,1}, {2,1}}
    };

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cal(i, j);
            }
        }

        System.out.println(max);

    }

    private static void cal(int r, int c) {

        for (int[][] tetromino : tetrominos) {
            int sum = 0;
            boolean isValid = true;

            for (int[] block : tetromino) {
                int nr = r + block[0];
                int nc = c + block[1];

                if (!check(nr, nc)) {
                    isValid = false;
                    break;
                }

                sum += map[nr][nc];
            }

            if (isValid) {
                max = Math.max(max, sum);
            }
        }
    }

    private static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

}
