import java.util.HashMap;

public class NTargets{
    public void points(int arr[]){
        int n = arr.length;        
        int product = 1;
        int sum= 0;
        HashMap<Integer,Integer> targets = new HashMap<Integer,Integer>();
        targets.put(0,1);
        targets.put(n+1,1); 
        for(int i = 1;i<=n;i++){
            targets.put(i,arr[i-1]);
        }
        if(n==1){
            System.out.println(arr[0]);
        }if(n == 0){
            System.out.println(0);
        }else{

            for(int i = 2;i<n+1;i++){
                if(targets.containsKey(i+1)==true){
                    product = targets.get(i-1)*targets.get(i)*targets.get(i+1);
                    sum +=product;
                    targets.put(i,targets.get(i-1));
                    targets.put(i-1,1);
                }else{
                    System.out.println(targets.get(i-1));
                    int a = targets.get(i-1);
                    sum+=a;
                }
            } 
        System.out.println(targets);
        System.out.println(sum);
        }
       
    }
    public static void main(String[] args) {
        NTargets n = new NTargets();
        int ar[] = {2};
        n.points(ar);
    }
}