// import static org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;
import java.util.List;

import org.junit.Test;

/**
 * HeapTest class implements tester that will test the methods from heap file
 */
public class HeapTest {

	@Test
	public void testAdd() {
		Comparator<Integer> maxHeapComparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		};
		Heap<Integer, String> heap = new Heap<Integer, String>(maxHeapComparator);
		heap.add(19, "");
		heap.add(50, "10");
		heap.add(30, "10");
		heap.add(15, "10");
		heap.add(20, "10");
		heap.add(10, "10");
		heap.add(5, "");
		heap.add(2, "");
		
		assertEquals(8, heap.entries.size());
	}

@Test
    public void testAddAndPoll() {
        Comparator<Integer> comparator = Integer::compare;
        Heap<Integer, String> heap = new Heap<>(comparator);
        heap.add(3, "three");
        heap.add(1, "one");
        heap.add(2, "two");

        assertEquals("3: three", heap.poll().toString());
        assertEquals("2: two", heap.poll().toString());
        assertEquals("1: one", heap.poll().toString());
    }

    @Test
    public void testPeek() {
        Comparator<Integer> comparator = Integer::compare;
        Heap<Integer, String> heap = new Heap<>(comparator);
        heap.add(3, "three");

        assertEquals("3: three", heap.peek().toString());
    }

    @Test
    public void testIsEmpty() {
        Comparator<Integer> comparator = Integer::compare;
        Heap<Integer, String> heap = new Heap<>(comparator);
        assertTrue(heap.isEmpty());
        heap.add(1, "one");

        assertFalse(heap.isEmpty());
    }

    @Test
    public void testSize() {
        Comparator<Integer> comparator = Integer::compare;
        Heap<Integer, String> heap = new Heap<>(comparator);
        assertEquals(0, heap.size());
        heap.add(1, "one");

        assertEquals(1, heap.size());
    }

    @Test
    public void testToArray() {
        Comparator<Integer> comparator = Integer::compare;
        Heap<Integer, String> heap = new Heap<>(comparator);
        heap.add(1, "one");
        heap.add(2, "two");
        List<Entry<Integer, String>> list = heap.toArray();

        assertEquals(2, list.size());
    }


}