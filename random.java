import java.util.Random;

public class random{
    public void dp(int n){
        int arr[] = new int[n+1];
        for(int i = 0;i<=n;i++){
            arr[i] = 0;
        }
        arr[1] = 1;
        for(int i = 0;i<=n+1;i++){
            if(i+1<=n+1 && i+2<=n+1){
                arr[i+1] += arr[i];
                arr[i+2] += arr[i];
            }
        }
        System.out.println(arr[5]);
    }
    public static void main(String[] args) {
        random r = new random();
        r.dp(6);
    }
}