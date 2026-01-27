//Sort the Bitonic DLL

import java.util.Scanner;
class list{
     node head = null;
     class node{
        int data;
        node next;
        node prev;
        node(int n){
            data=n;
            prev=null;
            next=null;
        }
     }
     void insert(int n){
        node newnode = new node(n); 
        if(head==null)
        head=newnode;
        else{
            node cur=head;
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=newnode;
            newnode.prev=cur;
        }
     }
     void display(){
        node cur=head;
        while(cur!=null){
            System.out.print(cur.data+"<-->");
            cur=cur.next;
        }
        System.out.print("null");
     }
    void bit(){
        node first=head;
        node last=head;
        node res=null;
        node resend=null;
        while(last.next!=null)
        last=last.next;
        //start the condition checking 
        while(first!=last){
            if(first.data<=last.data){
                if(res==null){
                    res=resend=first;
                    first=first.next;
                }
                else{
                    node cur=first.next;
                    resend.next=first;
                    first.prev=resend;
                    cur.prev=null;
                    first=cur;
                    resend=resend.next;
                }
            }
            else{
                if(res==null){
                    res=resend=last;
                    last=last.prev;
                }
                else{
                    node cur=last.prev;
                    resend.next=last;
                    last.prev=resend;
                    cur.next=null;
                    last=cur;
                    resend=resend.next;
                }
            }
        }
        //after while 
        resend.next=first;
        first.prev=resend;
        head=res;
    } 
}
class Main{
     public static void main(String ar[]){
        Scanner sw = new Scanner(System.in);
        int n=sw.nextInt();
        list l=new list();
        for(int i=0;i<n;i++){
            l.insert(sw.nextInt());
        }
        l.display(); 
        System.out.println();
        l.bit();
        l.display();
     }
}

