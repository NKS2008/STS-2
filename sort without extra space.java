//sort without extra space

import java.util.*;
class Main{
    static int min(Queue<Integer> q,int limit){
        int minval=Integer.MAX_VALUE;
        int min_index=-1;
        int n=q.size();
        for(int i=0;i<n;i++){
            int cur=q.poll();
            if(cur<=minval&&i<limit){
                min_index=i;
                minval=cur;
            }
            q.add(cur);
        }
        return min_index;
    }
    static void insertatend(Queue<Integer> q,int min_index){
        int minval=0;
        int n=q.size();
        for(int i=0;i<n;i++){
            int cur=q.poll();
            if(i!=min_index) q.add(cur);
            else minval=cur;
        }
        q.add(minval);
    }
    static void sort (Queue<Integer> q){
        for(int i=0;i<q.size();i++){
            int min_index=min(q,q.size()-i);
            insertatend(q,min_index);
        }
    }
    public static void main(String ar[]){
        Scanner sw = new Scanner(System.in);
        int n = sw.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++) q.add(sw.nextInt());
        sort(q);
        while(!q.isEmpty()){
            System.out.print(q.poll()+" ");
        }
    }
}


