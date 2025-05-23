package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import rx.Notification;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.util.RxRingBuffer;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class BlockingOperatorToIterator {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubscriberIterator<T> extends Subscriber<Notification<? extends T>> implements Iterator<T> {
        static final int LIMIT = (RxRingBuffer.SIZE * 3) / 4;
        private Notification<? extends T> buf;
        private final BlockingQueue<Notification<? extends T>> notifications = new LinkedBlockingQueue();
        private int received;

        private Notification<? extends T> take() {
            try {
                Notification<? extends T> poll = this.notifications.poll();
                if (poll != null) {
                    return poll;
                }
                return this.notifications.take();
            } catch (InterruptedException e16) {
                unsubscribe();
                throw Exceptions.propagate(e16);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.buf == null) {
                this.buf = take();
                int i3 = this.received + 1;
                this.received = i3;
                if (i3 >= LIMIT) {
                    request(i3);
                    this.received = 0;
                }
            }
            if (!this.buf.isOnError()) {
                return !this.buf.isOnCompleted();
            }
            throw Exceptions.propagate(this.buf.getThrowable());
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T value = this.buf.getValue();
                this.buf = null;
                return value;
            }
            throw new NoSuchElementException();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.notifications.offer(Notification.createOnError(th5));
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(RxRingBuffer.SIZE);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator");
        }

        @Override // rx.Observer
        public void onNext(Notification<? extends T> notification) {
            this.notifications.offer(notification);
        }

        @Override // rx.Observer
        public void onCompleted() {
        }
    }

    BlockingOperatorToIterator() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterator<T> toIterator(Observable<? extends T> observable) {
        SubscriberIterator subscriberIterator = new SubscriberIterator();
        observable.materialize().subscribe((Subscriber<? super Notification<? extends T>>) subscriberIterator);
        return subscriberIterator;
    }
}
