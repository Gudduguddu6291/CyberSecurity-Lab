import java.util.Scanner;
public class playfairencrypt {
    static char[][] matrix = new char[5][5];
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        System.out.print("Enter key: ");
        String key = sc.nextLine();

        System.out.print("Enter plaintext: ");
        String text = sc.nextLine();

        generateMatrix(key);
        String prepared = prepareText(text);
        String cipher = encrypt(prepared);

        System.out.println("Encrypted Text: " + cipher);
    }

    public static String encrypt(String text) {
       StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i);
            char b = text.charAt(i + 1);

            int[] p1 = findPosition(a);
            int[] p2 = findPosition(b);

            if (p1[0] == p2[0]) {
                result.append(matrix[p1[0]][(p1[1] + 1) % 5]);
                result.append(matrix[p2[0]][(p2[1] + 1) % 5]);
            } 
            else if (p1[1] == p2[1]) {
                result.append(matrix[(p1[0] + 1) % 5][p1[1]]);
                result.append(matrix[(p2[0] + 1) % 5][p2[1]]);
            } 
            else {
                result.append(matrix[p1[0]][p2[1]]);
                result.append(matrix[p2[0]][p1[1]]);
            }
        }
        return result.toString();
    }

    private static int[] findPosition(char c) {
          for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (matrix[i][j] == c)
                    return new int[]{i, j};
        return null;
    }

    public static String prepareText(String text) {
       text=text.toUpperCase().replace("J", "I").replace("\\s", "");
       StringBuilder sb= new StringBuilder(text);
       for (int i = 0; i < sb.length()-1; i+=2) {
            if(sb.charAt(i)==sb.charAt(i+1)) sb.insert(i+1,'X');
       }
       if(sb.length()%2 !=0 ) sb.append('X');
       return sb.toString();
    }

    public static void generateMatrix(String key) {
        boolean used[]=new boolean[26];
        key=key.toUpperCase().replace('J', 'I');
        int index=0;
        for(char ch:key.toCharArray())
        {
            if(!used[ch-'A'])
            {
                matrix[index/5][index%5]=ch;
                used[ch-'A']=true;
                index++;
            }
        }
        for(char c='A';c<='Z';c++)
        {
            if(c=='J') continue;
            if(!used[c-'A'])
            {
                matrix[index/5][index%5]=c;
                index++;
            }
        }
    }
}
