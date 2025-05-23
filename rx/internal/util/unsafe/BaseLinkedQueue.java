package rx.internal.util.unsafe;

import java.util.Iterator;
import rx.internal.util.SuppressAnimalSniffer;
import rx.internal.util.atomic.LinkedQueueNode;

/* compiled from: P */
@SuppressAnimalSniffer
/* loaded from: classes29.dex */
abstract class BaseLinkedQueue<E> extends BaseLinkedQueueConsumerNodeRef<E> {

    /* renamed from: p00, reason: collision with root package name */
    long f432692p00;

    /* renamed from: p01, reason: collision with root package name */
    long f432693p01;

    /* renamed from: p02, reason: collision with root package name */
    long f432694p02;

    /* renamed from: p03, reason: collision with root package name */
    long f432695p03;

    /* renamed from: p04, reason: collision with root package name */
    long f432696p04;

    /* renamed from: p05, reason: collision with root package name */
    long f432697p05;
    long p06;
    long p07;

    /* renamed from: p30, reason: collision with root package name */
    long f432698p30;

    /* renamed from: p31, reason: collision with root package name */
    long f432699p31;

    /* renamed from: p32, reason: collision with root package name */
    long f432700p32;

    /* renamed from: p33, reason: collision with root package name */
    long f432701p33;

    /* renamed from: p34, reason: collision with root package name */
    long f432702p34;

    /* renamed from: p35, reason: collision with root package name */
    long f432703p35;
    long p36;
    long p37;

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
}
