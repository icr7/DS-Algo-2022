
public class SearchByKeyInHashmap {

    public static void main(String[] args) {

        Map myMap = new Map();

        myMap.add(0, "Ronaldo");

        myMap.add(1, "Ishwar");

        myMap.add(2, "Mohit");

        myMap.add(3, "Deepak");

        myMap.add(4, "Lalit");

        myMap.add(5, "Suresh");

        myMap.add(7, "Jack");

        myMap.add(7, "David");

        myMap.add(7, "Rock");

        myMap.add(8, "Tarzen");

        myMap.add(8, "Tommy");

        myMap.add(9, "Dhoni");

        myMap.add(10, "Sachin");

        for (int i = 0; i < 10; i++) {

            if (myMap.myNode[i] != null)

                System.out.println(i+". "+myMap.myNode[i].toString());

            else

                System.out.println(i+". "+"null");

        }

        System.out.println("Value of key 1 : "+myMap.findValueByKey(1));
        System.out.println("Value of key 10 : "+myMap.findValueByKey(10));
        System.out.println("Value of key 5 : "+myMap.findValueByKey(5));
        System.out.println("Value of key 77 : "+myMap.findValueByKey(77));

    }

}

class Map {

    Node[] myNode = new Node[10];

    public void add(Integer key, String value) {

        int hash = key.hashCode();

        if (hash < 0) {

            hash = hash * -1;

        }

        int hashIndex = hash % (10 - 1);

        Node curr = myNode[hashIndex];

        while(true){

            if(curr==null){

                curr=new Node(key,value,hash);

                myNode[hashIndex]=curr;

                break;

            }

            else if( curr.key==key){

                curr=replaceNode(curr,new Node(key,value,hash));

                myNode[hashIndex]=curr;

                break;

            }

            else{

                if(curr.next==null) {

                    curr.next = new Node(key, value, hash);

                    break;

                }

                else

                    curr=curr.next;

            }

        }

    }
    public String findValueByKey(Integer key){
        int hashindex= key.hashCode()%(10-1);
        if(myNode[hashindex]==null){
            return null;
        }
        else {
            Node currNode = myNode[hashindex];
            while (true) {
                if (currNode.key == key) {
                    return currNode.value;
                } else if (currNode.next == null) {
                    return null;
                } else {
                    currNode = currNode.next;
                }
            }
        }
    }

    Node replaceNode(Node curr, Node newNode ){

        newNode.next=curr.next;

        curr=newNode;

        return curr;

    }

    class Node {

        int key;

        String value;

        long hash;

        Node next;

        Node(int key, String value, long hash) {

            this.key = key;

            this.value = value;

            this.hash = hash;

            this.next = null;

        }

        @Override

        public String toString() {

            return "Node{" +

                    "key='" + key + '\'' +

                    ", value='" + value + '\'' +

                    ", hash=" + hash +

                    ", next=" + next +

                    '}';

        }

    }

}
