import java.util.Arrays;
import java.util.Scanner;

public class Equilibrium_Index {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size= scanner.nextInt();
        int[] array = new int[size];
        for(int iterator=0;iterator<size;iterator++){
            array[iterator]=scanner.nextInt();
        }

        System.out.println(equilibrium_index(array));

    }

    static int equilibrium_index(int[] array) {
        int[] prefix_sum= new int[array.length];
        prefix_sum[0]=array[0];
        int min=Integer.MAX_VALUE;
        int count=0;
        for(int iterator=1;iterator<array.length;iterator++){
            prefix_sum[iterator]=prefix_sum[iterator-1]+array[iterator];
        }
        int n= prefix_sum.length;
        for(int i=1;i<n;i++){
            if(prefix_sum[i-1]==prefix_sum[n-1]-prefix_sum[i]){
                count++;
                if(min>i){
                    min=i;
                }
            }
        }
        if(count==0) {
            return -1;
        }
        else{
            return min;
        }
    }
}
