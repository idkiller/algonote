import java.util.Scanner;

public class Algorithm {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        int t = scanner.nextInt();

        for(int i=0; i<t; i++) {
            solution();
        }
    }

    static int matrix[][] = null;
    static int N = 0;

    public static void solution() {

        N = scanner.nextInt();
        matrix = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                 matrix[i][j] = scanner.nextInt();
            }
        }

        maxL = 1;

        calc(-1,-1,0);

        System.out.println(maxL);
    }

    static int maxL = 1;

    public static void calc(int x, int y, int l) {
        for(int i=x+1; i<N; i++) {
            for(int j=y+1; j<N; j++) {
                if(l+N-i > maxL && l+N-j > maxL && 
                        ( (x<0 || y<0 ) || matrix[x][y] <= matrix[i][j]) ) {
                    maxL = maxL > l+1 ? maxL : l+1;
                    calc(i,j,l+1);
                }
            }
        }
        return;
    }
}
