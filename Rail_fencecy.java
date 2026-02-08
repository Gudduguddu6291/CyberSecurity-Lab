public class Rail_fencecy {
    public static void main(String[] args) {
        String s="Goodafternoon";
        int key=4;
        int n=s.length();
        char mat[][]=new char[key][n];
        int i=0;
        while (i<n) 
        {
            for (int j1 = 0; j1 <key && i<n; j1++) {
                if(s.charAt(i)==' ') mat[j1][i]='_';
                else
                mat[j1][i]=s.charAt(i);
                
                i++;
            }
            for (int j1 = key-2; j1>0 && i<n; j1--) {
                if(s.charAt(i)==' ') mat[j1][i]='_';
                else
                mat[j1][i]=s.charAt(i);
                i++;
            }
        }
        for (int j = 0; j < mat.length; j++) {
            for (int j2 = 0; j2 < mat[0].length; j2++) {
                System.out.print(mat[j][j2]);
            }
        }
    }
}
