package synapsoft;

public class test2 {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 1, 1},{2, 2, 2}, {3, 3, 3}};
        int[][] arr2 = new int[3][3];
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
        
        int m = 2;
        for(int i = 0; i < 3; i++) {
            int n = 0;
            for(int j = 0; j < 3; j++) {
                arr2[n][m] = arr1[i][j];
                n++;
            }
            m--;
        }
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
