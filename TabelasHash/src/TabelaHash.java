import java.util.LinkedList;


public abstract class TabelaHash {

    private int size;
    private LinkedList[] hashTable;
    private int numberOfCollisions;
    private int[] distribution;


    public TabelaHash (int size) {
        this.size = size;
        this.hashTable = new LinkedList[size];
        this.distribution = new int[size];
    }


    public int verifyDistribution (int value) {
        return distribution[value];
    }


    public int getSize () {
        return size;
    }


    public int getNumberOfCollisions() {
        return numberOfCollisions;
    }


    public abstract int calculeHash (String name);


    public void add (String name) {
        int value = calculeHash(name);
        this.distribution[value]++;
        if (hashTable[value] == null) {
            LinkedList<String> linkedList = new LinkedList<>();
            linkedList.add(name);
            hashTable[value] = linkedList;
            return;
        }
        LinkedList<String> linkedList = hashTable[value];
        linkedList.add(name);
        numberOfCollisions++;
    }


    public long search(String name) {
        long startTime = System.currentTimeMillis();
        int value = calculeHash(name);
        if (this.hashTable[value] == null) {
            System.out.println("Nome não encontrado");
            long endTime = System.currentTimeMillis();
            return endTime - startTime;
        }
        for (Object n : this.hashTable[value]) {
            if (n.equals(name)) {
                System.out.println("Nome encontrado");
                long endTime = System.currentTimeMillis();
                return endTime - startTime;
            }
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
    
}
