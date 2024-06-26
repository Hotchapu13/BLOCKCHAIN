import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class Blockchain {
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static void main(String[] args) {
        // Adding blocks to the blockchain arraylist
        blockchain.add(new Block("I'm the first block", "0"));
        blockchain.add(new Block("I'm the second block", blockchain.get(blockchain.size()-1).hash));
        blockchain.add(new Block("I'm the third block", blockchain.get(blockchain.size()-1).hash));
        
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);

    }
}
