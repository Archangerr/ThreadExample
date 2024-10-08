import java.util.ArrayList;
import java.util.List;

public class evenNumber implements Runnable{
    private List<Integer> evenList;
    private final Object LOCK = new Object();
    private int start;

    public evenNumber(List<Integer> evenList, int start) {
        this.evenList = evenList;
        this.start = start;
    }

    public List<Integer> getEvenList() {
        return evenList;
    }

    public void setEvenList(ArrayList<Integer> evenList) {
        this.evenList = evenList;
    }

    public evenNumber(ArrayList<Integer> evenList) {
        this.evenList = evenList;
    }

    @Override
    public void run() {
        int end = this.start +2500;
        while (end!=start){
            if(this.start%2==0){
                synchronized (evenList){
                    evenList.add(this.start);
                }
            }
            start++;
        }

    }
}
