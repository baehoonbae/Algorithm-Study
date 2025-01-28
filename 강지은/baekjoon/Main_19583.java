import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_19583 {

    static String S, E, Q;
    static int SH, SM, EH, EM, QH, QM;
    static HashSet<String> student;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = st.nextToken();
        SH = Integer.parseInt(S.substring(0, 2));
        SM = Integer.parseInt(S.substring(3, 5));

        E = st.nextToken();
        EH = Integer.parseInt(E.substring(0, 2));
        EM = Integer.parseInt(E.substring(3, 5));

        Q = st.nextToken();
        QH = Integer.parseInt(Q.substring(0, 2));
        QM = Integer.parseInt(Q.substring(3, 5));

        student = new HashSet<>();

        String t;
        int cnt = 0;
        while ((t = br.readLine()) != null) {
            if (t.trim().isEmpty()) {
                break;
            }

            st = new StringTokenizer(t);
            String time = st.nextToken();
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3, 5));

            String name = st.nextToken();

            if (h < SH || (h==SH && m <= SM)) {
            	student.add(name);
            }
            
            if ((EH==h && EM <= m) || EH < h) {
            	if (student.contains(name)) {
            		if (h < QH || (h==QH && m <= QM)) {
            			student.remove(name);
            			cnt++;
            		}
            	}
            }
        }
        System.out.println(cnt);
    }
}
