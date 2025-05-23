package rx.internal.util.unsafe;

import rx.internal.util.atomic.LinkedQueueNode;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SpscLinkedQueue<E> extends BaseLinkedQueue<E> {
    public SpscLinkedQueue() {
        spProducerNode(new LinkedQueueNode<>());
        spConsumerNode(this.producerNode);
        this.consumerNode.soNext(null);
    }

    @Override // java.util.Queue
    public boolean offer(E e16) {
        if (e16 != null) {
            LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e16);
            this.producerNode.soNext(linkedQueueNode);
            this.producerNode = linkedQueueNode;
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    @Override // java.util.Queue
    public E peek() {
        LinkedQueueNode<E> lvNext = this.consumerNode.lvNext();
        if (lvNext != null) {
            return lvNext.lpValue();
        }
        return null;
    }

    @Override // java.util.Queue
    public E poll() {
        LinkedQueueNode<E> lvNext = this.consumerNode.lvNext();
        if (lvNext != null) {
            E andNullValue = lvNext.getAndNullValue();
            this.consumerNode = lvNext;
            return andNullValue;
        }
        return null;
    }
}
