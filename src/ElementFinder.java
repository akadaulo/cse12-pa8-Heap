import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

public class ElementFinder {

	public static int Kth_finder(String filename, int K, String operation) {
		
		// Create a comparator depending upon the type of operation
		// Heap<Integer, Integer> heap = new Heap<Integer, Integer>(comparator);
		/** TODO **/
		Comparator<Integer> comparator;
        if (operation.equals("largest")) {
            comparator = Comparator.reverseOrder();
        } else {
            comparator = Integer::compare;
        }

        Heap<Integer, Integer> heap = new Heap<>(comparator);

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] numbers = line.split(" ");
                for (String numStr : numbers) {
                    int num = Integer.parseInt(numStr);
                    if (heap.size() < K) {
                        heap.add(num, num);
                    } else if (operation.equals("largest")) {
                        if (num > heap.peek().getKey()) {
                            heap.poll();
                            heap.add(num, num);
                        }
                    } else {
                        if (num < heap.peek().getKey()) {
                            heap.poll();
                            heap.add(num, num);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }

        return heap.isEmpty() ? -1 : heap.peek().getKey();
    }
	/* Add any helper methods you find useful */
		
}
