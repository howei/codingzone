package other;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private int capacity = 0;
	private CacheEntry head = null;
	private CacheEntry tail = null;
	private Map<Integer, CacheEntry> map = new HashMap<Integer, CacheEntry>();
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		CacheEntry ce = map.get(key);
		if (ce.next != null) {
			ce.next.prev = ce.prev;
		} else {
			return ce.value;
		}
		if (ce.prev != null) {
			ce.prev.next = ce.next;
		} else {
			head = ce.next;
		}

		tail.next = ce;
		ce.prev = tail;
		ce.next = null;
		tail = ce;
		map.put(key, tail);
		return ce.value;
	}

	public void set(int key, int value) {
		if (!map.containsKey(key)) {
			CacheEntry ce = new CacheEntry(key, value);
			if (tail == null) {
				head = ce;
				tail = head;
			} else {
				tail.next = ce;
				ce.prev = tail;
				tail = ce;
			}
			map.put(key, tail);
		
			if (map.size() > capacity) {
				CacheEntry tmp = head;
				head = head.next;
				head.prev = null;
				map.remove(tmp.key);
			}
		} else {
			CacheEntry ce = map.get(key);
			ce.value = value;
			if (ce.next != null) {
				ce.next.prev = ce.prev;
			} else {
				return;
			}
			if (ce.prev != null) {
				ce.prev.next = ce.next;
			} else {
				head = ce.next;
			}

			tail.next = ce;
			ce.prev = tail;
			ce.next = null;
			tail = ce;
			map.put(key, tail);
		}
	}

}

class CacheEntry {
	int key;
	int value;
	CacheEntry(int key, int value) {
		this.key = key;
		this.value = value;
	}
	CacheEntry next;
	CacheEntry prev;
}