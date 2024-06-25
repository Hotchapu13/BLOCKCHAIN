import java.util.Date;

public class Block{
    private String data;
    public String hash;
    public String prevHash;
    private long timeStamp; // this will be as a number of milliseconds from 1/1/1970

    public Block(String data, String prevHash) {
        this.data = data;
        this.prevHash = prevHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        String calculatedHash = StringUtil.applySha256(prevHash + Long.toString(timeStamp) + data);
        return calculatedHash;
    }

}