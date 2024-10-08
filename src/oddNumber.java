import java.util.ArrayList;
import java.util.List;

public class oddNumber implements Runnable{
    private List<Integer> oddList;
    private final Object LOCK = new Object();
    private int start;

    public oddNumber(List<Integer> oddList, int start) {
        this.oddList = oddList;
        this.start = start;
    }

    public List<Integer> getOddList() {
        return oddList;
    }

    public void setOddList(ArrayList<Integer> oddList) {
        this.oddList = oddList;
    }

    @Override
    public void run() {
        int end = this.start +2500;
        while (end!=start){
            if(this.start%2==1){
                synchronized (oddList){
                    oddList.add(this.start);
                }
            }
            start++;
        }

    }
}