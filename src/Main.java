import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int i1=0;
        int i2=2500;
        int i3=5000;
        int i4=7500;
        //List<Integer> evenSharedList= Collections.synchronizedList(new ArrayList<>());
        List<Integer> evenSharedList = new ArrayList<>();
        List<Integer> oddSharedList = new ArrayList<>();

        // Sample inputs
        int[] inputs = {i1, i2, i3, i4};  // Assuming i1, i2, etc., are integers

        // Create threads for even numbers
        Thread[] evenThreads = new Thread[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            evenThreads[i] = new Thread(new evenNumber(evenSharedList, inputs[i]));
        }

        // Create threads for odd numbers
        Thread[] oddThreads = new Thread[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            oddThreads[i] = new Thread(new oddNumber(oddSharedList, inputs[i]));
        }

        // Start all even threads
        for (Thread t : evenThreads) {
            t.start();
        }

        // Start all odd threads
        for (Thread t : oddThreads) {
            t.start();
        }

        // Wait for all even threads to finish
        for (Thread t : evenThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Wait for all odd threads to finish (optional, based on your logic)
        for (Thread t : oddThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // You can now process or print the results from the shared lists
        System.out.println("Even Numbers: " + evenSharedList);
        System.out.println("Odd Numbers: " + oddSharedList);

        System.out.println("Even Numbers: " + evenSharedList.size());
        System.out.println("Odd Numbers: " + oddSharedList.size());
    }

}
