package structures;

// CS-2920
// Quick Union UF ADT

public class QuickUnionUF {
    private int[] id;
    private int[] sz; // WEIGHTED QU

    //constructor
    public QuickUnionUF(int N){
        id = new int[N];
        sz = new int[N];
        for(int i = 0; i < N; i++){id[i] = i;}
    }

    // void union
    public void union(int p, int q){
        int i = find(p);
        int j = find(q);
        /** id[i] = j; <- replaced in Weighted QU **/
        if(i == j) return;

        // Weighted QU - link root of smaller tree to root of larger tree
        if(sz[i] < sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        }
        else{
            id[j] = i;
            sz[i] += sz[j];
        }

    }

    // int find
    public int find(int i){

        /** Replaced in Weighted QU
        while(i != id[i]){
            i = id[i];
        }**/

        // Weighted QU - path compression - make every other node in path point to its grandparent
        while(i != id[i]){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    // bool connected
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int j : id) {
            if(j == 1){
                out.append(j);
            }
            else{
            out.append(" ").append(j);
            }
        }
        return out.toString();
    }
}
