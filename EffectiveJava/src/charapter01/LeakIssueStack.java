package charapter01;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * 一般来说, 只要类是自己管理内存, 程序员就应该警惕内存泄漏问题 进一步引申, 只要是自己的类是容器, 就需要注意内存泄漏问题
 * 
 * 针对缓存产生的内存泄漏问题, 可以使用WeakHashMap
 * 
 * @author LENOVO
 *
 */
// Can you spot the "memory stack" ?
public class LeakIssueStack {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public LeakIssueStack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public Object pop() {
		if (size == 0)
			throw new EmptyStackException();
		Object result = elements[--size];
		elements[--size] = null;
		return result;
	}

	/**
	 * Ensure space for at least one more element, roughly doubling the capacity
	 * each time the array needs to grow
	 */
	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}

	public static void main(String[] args) {
		// 代表缓存
		// 记住: 只有当所要的缓存项的生命周期是由该键的外部引用而不是由值决定时,
		// WeakHashMap才有用
		WeakHashMap map = new WeakHashMap();
		LinkedHashMap linkedMap = new LinkedHashMap();
		// linkedMap.removeEldestEntry();
		
	}
}

class MyLinkedHashMap extends LinkedHashMap {
	private static final int MAX_ENTRIES = 100;

	@Override
	protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > MAX_ENTRIES;
       }
}

class EmptyStackException extends RuntimeException {

}
