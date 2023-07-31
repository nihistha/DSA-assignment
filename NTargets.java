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
            targets.put(i,arr[i-1]); //i-1 because indx 0 at key 1
        }
        if(n==1){ 
            System.out.println(arr[0]);
        }else{ 
            for(int i = 2;i<n+1;i++){//[1,3,1,5,8,1] //[1,1,3,5,8,1] //[1,1,1,3,8,1],[1,1,1,1,1,8] 2,3,4
                
                    product = targets.get(i-1)*targets.get(i)*targets.get(i+1);
                    sum +=product;
                    targets.put(i,targets.get(i-1));
                    targets.put(i-1,1);
                
                    
                } 
                System.out.println(targets.get(n-1));
                int a = targets.get(n-1);
                sum+=a;
        System.out.println(targets);
        System.out.println(sum);
        }
       
    }
    
    public static void main(String[] args) {
        NTargets n = new NTargets();
        int ar[] = {2,2,2,1};
        n.points(ar);
    }
}