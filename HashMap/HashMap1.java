
public class HashMap1 {
    public static void main(String[] args) {
        Map myMap = new Map();
        myMap.add("Ishwar", "APS");
        myMap.add("Ishwar", "KVS");
        myMap.add("Ishwar", "GBPIET");
        myMap.add("Ishwar", "TCS");
        myMap.add("Deepak", "KVS");
        myMap.add("Deepak", "GBPIET");
        myMap.add("Deepak", "Mindtree");
        myMap.add("Mohit", "KVS");
        myMap.add("Mohit", "Amarpali");
        myMap.add("Mohit", "Wipro");

        for (int i = 0; i < 10; i++) {
            if (myMap.myNode[i] != null)
                System.out.println(i+". "+myMap.myNode[i].toString());
            else
                System.out.println(i+". "+"null");

        }
    }
}

    class Map {
        Node myNode[] = new Node[10];

        public void add(String key, String value) {
            int hash = key.hashCode();
            if (hash < 0) {
                hash = hash * -1;
            }
            int hashIndex = hash % (10 - 1);
            if (myNode[hashIndex] == null) {
                myNode[hashIndex] = new Node(key, value, hash);
            } else {
                Node currNode = myNode[hashIndex];
                while (true) {
                    if(currNode.next==null){
                        currNode.next=new Node(key, value, hash);
                        break;
                    }
                    else{
                        currNode=currNode.next;
                    }
            }
        }
        }


        class Node {
            String key;
            String value;
            long hash;
            Node next;

            Node(String key, String value, long hash) {
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

