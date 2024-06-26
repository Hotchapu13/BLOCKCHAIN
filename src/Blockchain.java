import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class Blockchain {
    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static void main(String[] args) {
        // Adding blocks to the blockchain arraylist
        blockchain.add(new Block("I'm the first block", "0"));
        blockchain.add(new Block("I'm the second block", blockchain.get(blockchain.size() - 1).hash));
        blockchain.add(new Block("I'm the third block", blockchain.get(blockchain.size() - 1).hash));

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);
    }
    
    public boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        // Loop through the blockchain to loop through the hashes.
        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);
            // compare registered hash and calculated hash
            if (currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Current hashes not equal.");
                return false;
            }
            // compare previous hash and registered previous hash
            if (!previousBlock.hash.equals(currentBlock.prevHash)) {
                System.out.println("previous hashes not equal.");
                return false;
            }
        }
        return true;
    }
}
