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

