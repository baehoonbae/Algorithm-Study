import java.io.*;

public class Main_9655 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write((N % 2 == 1) ? "SK" : "CY");
        bw.flush();
        bw.close();
    }

}