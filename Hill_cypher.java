public class Hill_cypher {
    public static void main(String[] args) {
        String s="ACT";
        int n=s.length();
        String key="GYBNQKURP";
        int A1[][]=new int[n][n];
        int ch=0;
        for (int i = 0; i < n; i++) {
            for(int j=0;j<n;j++)
            {
                A1[i][j]=key.charAt(ch)-'A';
                ch++;
            }
        }
        int input[][]=new int[n][1];
        ch=0;
        for (int i = 0; i < n; i++) {
            input[i][0]=s.charAt(i)-'A';
        }
        int res[][]=new int[n][1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 1; j++) {
                res[i][j]=0;
                for (int k = 0; k < n; k++) {
                    res[i][j]+=(A1[i][k]*input[k][j]);
                }
                res[i][j]%=26;
            }
        }
        System.out.println("Encrypted message:");
        for (int i = 0; i < n; i++) {
            System.out.print((char)(res[i][0]+'A'));
        }
    }
}
