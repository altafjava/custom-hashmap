package com.altafjava.util;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AltafHashMap {

	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	private Node[] buckets;
	private int size;
	private float loadFactor;

	public AltafHashMap() {
		buckets = new Node[DEFAULT_INITIAL_CAPACITY];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean containsKey(Object key) {
		if (key == null)
			throw new RuntimeException("null key is not allowed");
		return false;
	}

	public boolean containsValue(Object value) {
		return false;
	}

	public Object get(Object key) {
		Object returnValue = null;
		int hashcode = key.hashCode();
		int index = hashcode % DEFAULT_INITIAL_CAPACITY;
		Node currentNode = buckets[index];
		if (currentNode == null) {
			return null;
		} else {
			while (currentNode != null) {
				Object oldKey = currentNode.getKey();
				if (oldKey == key || oldKey.equals(key)) {
					returnValue = currentNode.getValue();
					break;
				}
				currentNode = currentNode.next;
			}
		}
		return returnValue;
	}

	public Object put(Object key, Object value) {
		int hashcode = key.hashCode();
		int index = Math.abs(hashcode) % DEFAULT_INITIAL_CAPACITY;
		System.out.println(key + "  " + index);
		Node previousNode = null;
		Node currentNode = buckets[index];
		Node node = new Node(hashcode, key, value, null);
		if (currentNode == null) {
			buckets[index] = node;
			size++;
			return value;
		} else {
			while (currentNode != null) {
				Object oldKey = currentNode.getKey();
				if (oldKey == key || oldKey.equals(key)) {
					Object oldValue = currentNode.getValue();
					currentNode.setValue(value);
					previousNode.next = node;
					return oldValue;
				}
				previousNode = currentNode;
				currentNode = currentNode.next;
			}
			previousNode.next = node;
		}
		return value;

	}

	public Object remove(Object key) {
		return null;
	}

	public void putAll(Map<? extends Object, ? extends Object> m) {

	}

	public void clear() {

	}

	public Set<Object> keySet() {
		return null;
	}

	public Collection<Object> values() {
		return null;
	}

	public Set<Entry<Object, Object>> entrySet() {
		return null;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("{");
		for (Node node : buckets) {
			if (node != null) {
				stringBuilder.append(node + ",");
				Node nextNode = node.next;
				while (nextNode != null) {
					stringBuilder.append(nextNode + ",");
					nextNode = nextNode.next;
				}
			}
		}
		stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "");
		stringBuilder.append("}");
		return stringBuilder.toString();
	}

	static class Node {
		private int hash;
		private Object key;
		private Object value;
		private Node next;

		public Node() {
		}

		public Node(int hash, Object key, Object value, Node next) {
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public int getHash() {
			return hash;
		}

		public void setHash(int hash) {
			this.hash = hash;
		}

		public Object getKey() {
			return key;
		}

		public void setKey(Object key) {
			this.key = key;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return key + "=" + value;
		}

	}

}
