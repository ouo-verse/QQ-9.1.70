package rx.internal.util.unsafe;

/* loaded from: classes29.dex */
public interface MessagePassingQueue<M> {
    boolean isEmpty();

    boolean offer(M m3);

    M peek();

    M poll();

    int size();
}
