//stack permuatations

import java.util.*;
class Main{
    public static void main(String ar[]){
        Scanner sw = new Scanner(System.in);
        int n=sw.nextInt();
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i=0;i<n;i++) q1.add(sw.nextInt());
        for(int i=0;i<n;i++) q2.add(sw.nextInt());
        Stack<Integer> st = new Stack<>();
        while(!q1.isEmpty()){
            int ele=q1.poll();
            if(ele==q2.peek()){
                q2.poll();
                while(!st.isEmpty()){
                    if(st.peek()==q2.peek()){
                        st.pop();
                        q2.poll();
                    }
                    else{
                        break;
                    }
                }
            }
            else st.push(ele);
        }
        if(q1.isEmpty()&&st.isEmpty()){
            System.out.print("Yes");
        }
        else System.out.print("No");
    }
}
