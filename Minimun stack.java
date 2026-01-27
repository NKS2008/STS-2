//Minimun stack
import java.util.*;
import java.util.Scanner;
class Main{
    static Stack<Integer> st = new Stack<>();
    static Stack<Integer> mst = new Stack<>();
    static void push(int n){
        if(st.isEmpty()){
            st.push(n);
            mst.push(n);
        }
        else{
            st.push(n);
            if(n<=mst.peek()) mst.push(n);
        }
    }
    static void pop(){
        int ele=st.pop();
        if(ele==mst.peek()) mst.pop();
    }
    static void getmin(){
        if(mst.isEmpty()) System.out.print("Stack is Empty");
        else System.out.print(mst.peek());
    }
    public static void main(String ar[]){
        Scanner sw = new Scanner(System.in);
        int n=sw.nextInt();
        for(int i=0;i<n;i++) push(sw.nextInt());
        getmin();
    }
}

//celebrity problem
import java.util.Scanner;
import java.util.Stack;
class Main{
    static void celeb(int c[][],int n){
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++) st.push(i);
        while(st.size()>=2){
            int a=st.pop();
            int b=st.pop();
            if(c[a][b]==1) st.push(b);
            else st.push(a);
        }
        int pc=st.pop();
        boolean temp=true;
        for(int i=0;i<n;i++){
            if(i!=pc){
                if(c[i][pc]==0||c[pc][i]==1){
                    temp=false;
                    break;
                }
            }
        }
        if(temp){
            System.out.print("celebrity is: "+pc);
            return;
        }
        else System.out.print("No celebrity found");
        
    }
    public static void main(String ar[]){
        Scanner sw = new Scanner(System.in);
        int n=sw.nextInt();
        int a[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sw.nextInt();
            }
        }
        celeb(a,n);
    }
}


