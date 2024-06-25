import java.util.ArrayList;

public class Blockchain {
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static void main(String[] args) {
        Block firstBlock = new Block("I'm the first block", "0");
        System.out.println("Hash for block 1: " + firstBlock.hash);

        Block secondBlock = new Block("I'm the second block", firstBlock.hash);
        System.out.println("Hash for block 2: " + secondBlock.hash);

        Block thirdBlock = new Block("I'm the first block", secondBlock.hash);
        System.out.println("Hash for block 3: " + thirdBlock.hash);

    }
}
