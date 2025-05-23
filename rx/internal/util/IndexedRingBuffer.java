package rx.internal.util;

import androidx.lifecycle.c;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.Subscription;
import rx.functions.Func1;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class IndexedRingBuffer<E> implements Subscription {
    private static final ObjectPool<IndexedRingBuffer<?>> POOL = new ObjectPool<IndexedRingBuffer<?>>() { // from class: rx.internal.util.IndexedRingBuffer.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // rx.internal.util.ObjectPool
        public IndexedRingBuffer<?> createObject() {
            return new IndexedRingBuffer<>();
        }
    };
    static final int SIZE;
    static int defaultSize;
    private final ElementSection<E> elements = new ElementSection<>();
    private final IndexSection removed = new IndexSection();
    final AtomicInteger index = new AtomicInteger();
    final AtomicInteger removedIndex = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ElementSection<E> {
        final AtomicReferenceArray<E> array = new AtomicReferenceArray<>(IndexedRingBuffer.SIZE);
        final AtomicReference<ElementSection<E>> next = new AtomicReference<>();

        ElementSection() {
        }

        ElementSection<E> getNext() {
            if (this.next.get() != null) {
                return this.next.get();
            }
            ElementSection<E> elementSection = new ElementSection<>();
            if (c.a(this.next, null, elementSection)) {
                return elementSection;
            }
            return this.next.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class IndexSection {
        private final AtomicIntegerArray unsafeArray = new AtomicIntegerArray(IndexedRingBuffer.SIZE);
        private final AtomicReference<IndexSection> _next = new AtomicReference<>();

        IndexSection() {
        }

        public int getAndSet(int i3, int i16) {
            return this.unsafeArray.getAndSet(i3, i16);
        }

        IndexSection getNext() {
            if (this._next.get() != null) {
                return this._next.get();
            }
            IndexSection indexSection = new IndexSection();
            if (c.a(this._next, null, indexSection)) {
                return indexSection;
            }
            return this._next.get();
        }

        public void set(int i3, int i16) {
            this.unsafeArray.set(i3, i16);
        }
    }

    static {
        defaultSize = 256;
        if (PlatformDependent.isAndroid()) {
            defaultSize = 8;
        }
        String property = System.getProperty("rx.indexed-ring-buffer.size");
        if (property != null) {
            try {
                defaultSize = Integer.parseInt(property);
            } catch (NumberFormatException e16) {
                System.err.println("Failed to set 'rx.indexed-ring-buffer.size' with value " + property + " => " + e16.getMessage());
            }
        }
        SIZE = defaultSize;
    }

    IndexedRingBuffer() {
    }

    private ElementSection<E> getElementSection(int i3) {
        int i16 = SIZE;
        if (i3 < i16) {
            return this.elements;
        }
        int i17 = i3 / i16;
        ElementSection<E> elementSection = this.elements;
        for (int i18 = 0; i18 < i17; i18++) {
            elementSection = elementSection.getNext();
        }
        return elementSection;
    }

    private synchronized int getIndexForAdd() {
        int andIncrement;
        int indexFromPreviouslyRemoved = getIndexFromPreviouslyRemoved();
        if (indexFromPreviouslyRemoved >= 0) {
            int i3 = SIZE;
            if (indexFromPreviouslyRemoved < i3) {
                andIncrement = this.removed.getAndSet(indexFromPreviouslyRemoved, -1);
            } else {
                andIncrement = getIndexSection(indexFromPreviouslyRemoved).getAndSet(indexFromPreviouslyRemoved % i3, -1);
            }
            if (andIncrement == this.index.get()) {
                this.index.getAndIncrement();
            }
        } else {
            andIncrement = this.index.getAndIncrement();
        }
        return andIncrement;
    }

    private synchronized int getIndexFromPreviouslyRemoved() {
        int i3;
        int i16;
        do {
            i3 = this.removedIndex.get();
            if (i3 > 0) {
                i16 = i3 - 1;
            } else {
                return -1;
            }
        } while (!this.removedIndex.compareAndSet(i3, i16));
        return i16;
    }

    private IndexSection getIndexSection(int i3) {
        int i16 = SIZE;
        if (i3 < i16) {
            return this.removed;
        }
        int i17 = i3 / i16;
        IndexSection indexSection = this.removed;
        for (int i18 = 0; i18 < i17; i18++) {
            indexSection = indexSection.getNext();
        }
        return indexSection;
    }

    public static <T> IndexedRingBuffer<T> getInstance() {
        return (IndexedRingBuffer) POOL.borrowObject();
    }

    private synchronized void pushRemovedIndex(int i3) {
        int andIncrement = this.removedIndex.getAndIncrement();
        int i16 = SIZE;
        if (andIncrement < i16) {
            this.removed.set(andIncrement, i3);
        } else {
            getIndexSection(andIncrement).set(andIncrement % i16, i3);
        }
    }

    public int add(E e16) {
        int indexForAdd = getIndexForAdd();
        int i3 = SIZE;
        if (indexForAdd < i3) {
            this.elements.array.set(indexForAdd, e16);
            return indexForAdd;
        }
        getElementSection(indexForAdd).array.set(indexForAdd % i3, e16);
        return indexForAdd;
    }

    public int forEach(Func1<? super E, Boolean> func1) {
        return forEach(func1, 0);
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return false;
    }

    public void releaseToPool() {
        int i3 = this.index.get();
        int i16 = 0;
        loop0: for (ElementSection<E> elementSection = this.elements; elementSection != null; elementSection = elementSection.next.get()) {
            int i17 = 0;
            while (i17 < SIZE) {
                if (i16 >= i3) {
                    break loop0;
                }
                elementSection.array.set(i17, null);
                i17++;
                i16++;
            }
        }
        this.index.set(0);
        this.removedIndex.set(0);
        POOL.returnObject(this);
    }

    public E remove(int i3) {
        E andSet;
        int i16 = SIZE;
        if (i3 < i16) {
            andSet = this.elements.array.getAndSet(i3, null);
        } else {
            andSet = getElementSection(i3).array.getAndSet(i3 % i16, null);
        }
        pushRemovedIndex(i3);
        return andSet;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        releaseToPool();
    }

    public int forEach(Func1<? super E, Boolean> func1, int i3) {
        int forEach = forEach(func1, i3, this.index.get());
        if (i3 > 0 && forEach == this.index.get()) {
            return forEach(func1, 0, i3);
        }
        if (forEach == this.index.get()) {
            return 0;
        }
        return forEach;
    }

    private int forEach(Func1<? super E, Boolean> func1, int i3, int i16) {
        ElementSection<E> elementSection;
        int i17;
        int i18 = this.index.get();
        ElementSection<E> elementSection2 = this.elements;
        int i19 = SIZE;
        if (i3 >= i19) {
            ElementSection<E> elementSection3 = getElementSection(i3);
            i17 = i3;
            i3 %= i19;
            elementSection = elementSection3;
        } else {
            elementSection = elementSection2;
            i17 = i3;
        }
        loop0: while (elementSection != null) {
            while (i3 < SIZE) {
                if (i17 >= i18 || i17 >= i16) {
                    break loop0;
                }
                E e16 = elementSection.array.get(i3);
                if (e16 != null && !func1.call(e16).booleanValue()) {
                    return i17;
                }
                i3++;
                i17++;
            }
            elementSection = elementSection.next.get();
            i3 = 0;
        }
        return i17;
    }
}
