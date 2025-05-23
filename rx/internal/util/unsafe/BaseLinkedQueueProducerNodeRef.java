package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;
import rx.internal.util.atomic.LinkedQueueNode;

@SuppressAnimalSniffer
/* loaded from: classes29.dex */
abstract class BaseLinkedQueueProducerNodeRef<E> extends BaseLinkedQueuePad0<E> {
    protected static final long P_NODE_OFFSET = UnsafeAccess.addressOf(BaseLinkedQueueProducerNodeRef.class, "producerNode");
    protected LinkedQueueNode<E> producerNode;

    protected final LinkedQueueNode<E> lpProducerNode() {
        return this.producerNode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> lvProducerNode() {
        return (LinkedQueueNode) UnsafeAccess.UNSAFE.getObjectVolatile(this, P_NODE_OFFSET);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void spProducerNode(LinkedQueueNode<E> linkedQueueNode) {
        this.producerNode = linkedQueueNode;
    }
}
