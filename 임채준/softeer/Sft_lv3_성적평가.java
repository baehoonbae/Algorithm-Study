package sft;

import java.io.*;
import java.util.*;

public class Sft_lv3_성적평가 {

    static int N;
    static int[][] scores, ranks;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        scores = new int[3][N];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ranks = new int[4][N];


        for (int i = 0; i < 3; i++) {
            Integer[] idx = new Integer[N];
            for (int j = 0; j < N; j++) idx[j] = j;

            final int compIdx = i;
            Arrays.sort(idx, (a, b) -> scores[compIdx][b] - scores[compIdx][a]);

            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (j > 0 && scores[i][idx[j]] != scores[i][idx[j - 1]]) {
                    rank = j + 1;
                }
                ranks[i][idx[j]] = rank;
            }
        }

        int[] totalScores = new int[N];
        for (int i = 0; i < N; i++) {
            totalScores[i] = scores[0][i] + scores[1][i] + scores[2][i];
        }

        Integer[] totalIdx = new Integer[N];
        for (int i = 0; i < N; i++) totalIdx[i] = i;

        Arrays.sort(totalIdx, (a, b) -> totalScores[b] - totalScores[a]);

        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (i > 0 && totalScores[totalIdx[i]] != totalScores[totalIdx[i - 1]]) {
                rank = i + 1;
            }
            ranks[3][totalIdx[i]] = rank;
        }

        for (int i = 0; i < 4; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                sb.append(ranks[i][j]).append(" ");
            }
            System.out.println(sb);
        }
    }
}
