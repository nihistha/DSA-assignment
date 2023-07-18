import java.util.HashMap;

public class NTargets{
    public void points(int arr[]){
        int n = arr.length;        
        int product = 1;
        int sum= 0;
        //made a hashmap so that maile first ko ra last ko key ma chai 1 rakhnu pawos
        HashMap<Integer,Integer> targets = new HashMap<Integer,Integer>();
        //tyo hashmap ko first ma 1 haleko
        targets.put(0,1);
        //last ma ni 1 haleko hashmap ko size chai length+1 ho
        targets.put(n+1,1); 
        // ani yo chai hashmap ma array ko value haleko
        for(int i = 1;i<=n;i++){
            targets.put(i,arr[i-1]); //i-1 because indx 0 at key 1
        }
        if(n==1){ //so array ma euta matra element cha vane chai tei return gareko
            System.out.println(arr[0]);
        }else{ // now 
            for(int i = 2;i<n+1;i++){ // maile i chai 2 bata suru gare kinaki maile hashmap bata value get garnu lako
                //so suppose timro array {8,2,3,4,5} cha vane first ma chai 8*2*3 huncha
                if(targets.containsKey(i+1)==true){ //yo chai to verify tyo key cha ki chaina vanera
                    product = targets.get(i-1)*targets.get(i)*targets.get(i+1); // so yo chai formula nai vayo deko wala esle first iteration ma 1*2*3 garcha
                    //ani product lai lagera sum ma joddincha
                    sum +=product;
                    // ani yo chai very important hamile first interation ma ith key ko target lai chai hit garyo ni ta
                    //so ya chai tyo ith key ma tyo vanda agadi ko value haaldeko 
                    targets.put(i,targets.get(i-1));
                    targets.put(i-1,1);//ani tyo vanda agadi ko key ma chai 1 haaldeko
                    //so that next iteration ma 8*3*4 huncha
                    //then 8*4*5
                    //8*5*1
                    //ani yo samma vayo sum ma ni jodiyo k tara tyo last ma 8 ko matra chai aaudai aayena k 
                }else{// yo if else tesaile lekheko 8 matra baki vo vane sum ma tyo 8 direct joddos vanera but its not working 
                    System.out.println(targets.get(i-1));
                    int a = targets.get(i-1);
                    sum+=a;
                }
            } 
        System.out.println(targets);
        System.out.println(sum);
        }
       
    }
    //yo run gara ani hera aru sab thikcha tara tyo key 4 ko 2 ni malai sum ma jodnu paryo but its not happening
    public static void main(String[] args) {
        NTargets n = new NTargets();
        int ar[] = {2,2,2,1};
        n.points(ar);
    }
}