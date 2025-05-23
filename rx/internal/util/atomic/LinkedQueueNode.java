package rx.internal.util.atomic;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
    private static final long serialVersionUID = 2404266111789071508L;
    private E value;

    public LinkedQueueNode() {
    }

    public E getAndNullValue() {
        E lpValue = lpValue();
        spValue(null);
        return lpValue;
    }

    public E lpValue() {
        return this.value;
    }

    public LinkedQueueNode<E> lvNext() {
        return get();
    }

    public void soNext(LinkedQueueNode<E> linkedQueueNode) {
        lazySet(linkedQueueNode);
    }

    public void spValue(E e16) {
        this.value = e16;
    }

    public LinkedQueueNode(E e16) {
        spValue(e16);
    }
}
