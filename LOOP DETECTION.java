//Loop detection

import java.util.Scanner;
class list{
    Node head=null;
    class Node{
        int data;
        Node next;
        Node(int n){
            data=n;
            next=null;
        }
    }
    void insert(int n){
        Node newNode=new Node(n);
        if(head==null) 
        head=newNode;
        else{
            Node cur=head;
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=newNode;
        }
    }
   boolean create(int a,int b){
       int c=0;
       Node p1=head;
       Node p2=head;
       while(p1.data!=a||c!=b){
           if(p1.data!=a) {
               p1=p1.next;
               if(p1.next==null)
               return false;
           }
           if(c!=b){
               p2=p2.next;
               ++c;
           }
       }
       p2.next=p1;
       return true;
   }
   boolean detect(){
       Node fast=head;
       Node slow=head;
       while(fast.next!=null&&fast.next.next!=null){
           fast=fast.next.next;
           slow=slow.next;
           if(slow==fast)
           return true;
       }
       if(fast.next==null)
       return false;
       return false;
   }
}
class Main{
    public static void main(String ar[]){
        Scanner sw = new Scanner(System.in);
        int n=sw.nextInt();
        list l=new list();
        for(int i=0;i<n;i++) l.insert(sw.nextInt());
        int a=sw.nextInt();
        int b=n-1;
        l.create(a,b);
        System.out.print(l.detect());
    }
}
