package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes29.dex */
abstract class BaseLinkedAtomicQueue<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> producerNode = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> consumerNode = new AtomicReference<>();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        if (lvConsumerNode() == lvProducerNode()) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> lpConsumerNode() {
        return this.consumerNode.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> lpProducerNode() {
        return this.producerNode.get();
    }

    protected final LinkedQueueNode<E> lvConsumerNode() {
        return this.consumerNode.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> lvProducerNode() {
        return this.producerNode.get();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> lvConsumerNode = lvConsumerNode();
        LinkedQueueNode<E> lvProducerNode = lvProducerNode();
        int i3 = 0;
        while (lvConsumerNode != lvProducerNode && i3 < Integer.MAX_VALUE) {
            do {
                lvNext = lvConsumerNode.lvNext();
            } while (lvNext == null);
            i3++;
            lvConsumerNode = lvNext;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void spConsumerNode(LinkedQueueNode<E> linkedQueueNode) {
        this.consumerNode.lazySet(linkedQueueNode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void spProducerNode(LinkedQueueNode<E> linkedQueueNode) {
        this.producerNode.lazySet(linkedQueueNode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> xchgProducerNode(LinkedQueueNode<E> linkedQueueNode) {
        return this.producerNode.getAndSet(linkedQueueNode);
    }
}
