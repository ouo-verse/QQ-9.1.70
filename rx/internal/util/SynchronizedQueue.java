package rx.internal.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SynchronizedQueue<T> implements Queue<T>, Cloneable {
    private final Queue<T> list;
    private final int size;

    public SynchronizedQueue() {
        this.list = new LinkedList();
        this.size = -1;
    }

    @Override // java.util.Queue, java.util.Collection
    public synchronized boolean add(T t16) {
        return this.list.add(t16);
    }

    @Override // java.util.Collection
    public synchronized boolean addAll(Collection<? extends T> collection) {
        return this.list.addAll(collection);
    }

    @Override // java.util.Collection
    public synchronized void clear() {
        this.list.clear();
    }

    public synchronized Object clone() {
        SynchronizedQueue synchronizedQueue;
        synchronizedQueue = new SynchronizedQueue(this.size);
        synchronizedQueue.addAll(this.list);
        return synchronizedQueue;
    }

    @Override // java.util.Collection
    public synchronized boolean contains(Object obj) {
        return this.list.contains(obj);
    }

    @Override // java.util.Collection
    public synchronized boolean containsAll(Collection<?> collection) {
        return this.list.containsAll(collection);
    }

    @Override // java.util.Queue
    public synchronized T element() {
        return this.list.element();
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.list.equals(((SynchronizedQueue) obj).list);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override // java.util.Collection
    public synchronized boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public synchronized Iterator<T> iterator() {
        return this.list.iterator();
    }

    @Override // java.util.Queue
    public synchronized boolean offer(T t16) {
        if (this.size > -1 && this.list.size() + 1 > this.size) {
            return false;
        }
        return this.list.offer(t16);
    }

    @Override // java.util.Queue
    public synchronized T peek() {
        return this.list.peek();
    }

    @Override // java.util.Queue
    public synchronized T poll() {
        return this.list.poll();
    }

    @Override // java.util.Collection
    public synchronized boolean remove(Object obj) {
        return this.list.remove(obj);
    }

    @Override // java.util.Collection
    public synchronized boolean removeAll(Collection<?> collection) {
        return this.list.removeAll(collection);
    }

    @Override // java.util.Collection
    public synchronized boolean retainAll(Collection<?> collection) {
        return this.list.retainAll(collection);
    }

    @Override // java.util.Collection
    public synchronized int size() {
        return this.list.size();
    }

    @Override // java.util.Collection
    public synchronized Object[] toArray() {
        return this.list.toArray();
    }

    public synchronized String toString() {
        return this.list.toString();
    }

    @Override // java.util.Queue
    public synchronized T remove() {
        return this.list.remove();
    }

    @Override // java.util.Collection
    public synchronized <R> R[] toArray(R[] rArr) {
        return (R[]) this.list.toArray(rArr);
    }

    public SynchronizedQueue(int i3) {
        this.list = new LinkedList();
        this.size = i3;
    }
}
