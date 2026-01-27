//segregation of even and odd numbers in a LL

import java.util.Scanner;
class list{
    node head=null;
    class node{
        int data;
        node next;
        node(int n){
            data=n;
            next=null;
        }
    }
    void insert(int n){
        node newnode = new node(n);
        if(head==null) head=newnode;
        else{
            node cur=head;
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=newnode;
        }
    }
    void display(){
        node cur=head;
        while(cur!=null){
            System.out.print(cur.data+"-->");
            cur=cur.next;
        }
        System.out.print("null");
    }
    void seg(){
        node es=null;
        node ee=null;
        node os=null;
        node oe=null;
        node cur=head;
        while(cur!=null){
            if(cur.data%2==0){
                if(es==null) es=ee=cur;
                else{
                    ee.next=cur;
                    ee=cur;
                }
            }
            else{
                if(os==null) os=oe=cur;
                else{
                    oe.next=cur;
                    oe=cur;
                }
            }
            cur=cur.next;
        }
        if(es==null) head=os;
        else{
            head=es;
            ee.next=os;
        }
        oe.next=null;
    }
}
class Main{
    public static void main(String ar[]){
        Scanner sw=new Scanner(System.in);
        int n=sw.nextInt();
        list l=new list();
        for(int i=0;i<n;i++){
            l.insert(sw.nextInt());
        }
        l.display();
        l.seg();
        System.out.println();
        l.display();
    }
}



