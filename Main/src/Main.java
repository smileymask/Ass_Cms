import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        int n=input.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i]=input.nextInt();
        }
        int max=a[0];
        for(int i=0;i<n;i++){
            if(max < a[i]){
                max=a[i];
            }
        }
        System.out.println(max);

    }
}