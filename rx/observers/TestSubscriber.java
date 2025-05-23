package rx.observers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.Observer;
import rx.Subscriber;
import rx.annotations.Experimental;
import rx.exceptions.CompositeException;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TestSubscriber<T> extends Subscriber<T> {
    private static final Observer<Object> INERT = new Observer<Object>() { // from class: rx.observers.TestSubscriber.1
        @Override // rx.Observer
        public void onCompleted() {
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
        }

        @Override // rx.Observer
        public void onNext(Object obj) {
        }
    };
    private int completions;
    private final Observer<T> delegate;
    private final List<Throwable> errors;
    private volatile Thread lastSeenThread;
    private final CountDownLatch latch;
    private volatile int valueCount;
    private final List<T> values;

    public TestSubscriber(long j3) {
        this(INERT, j3);
    }

    public static <T> TestSubscriber<T> create() {
        return new TestSubscriber<>();
    }

    public void assertCompleted() {
        int i3 = this.completions;
        if (i3 == 0) {
            assertionError("Not completed!");
        } else if (i3 > 1) {
            assertionError("Completed multiple times: " + i3);
        }
    }

    public void assertError(Class<? extends Throwable> cls) {
        List<Throwable> list = this.errors;
        if (list.isEmpty()) {
            assertionError("No errors");
            return;
        }
        if (list.size() <= 1) {
            if (cls.isInstance(list.get(0))) {
                return;
            }
            AssertionError assertionError = new AssertionError("Exceptions differ; expected: " + cls + ", actual: " + list.get(0));
            assertionError.initCause(list.get(0));
            throw assertionError;
        }
        AssertionError assertionError2 = new AssertionError("Multiple errors: " + list.size());
        assertionError2.initCause(new CompositeException(list));
        throw assertionError2;
    }

    public void assertNoErrors() {
        if (!getOnErrorEvents().isEmpty()) {
            assertionError("Unexpected onError events");
        }
    }

    public void assertNoTerminalEvent() {
        List<Throwable> list = this.errors;
        int i3 = this.completions;
        if (!list.isEmpty() || i3 > 0) {
            if (list.isEmpty()) {
                assertionError("Found " + list.size() + " errors and " + i3 + " completion events instead of none");
                return;
            }
            if (list.size() == 1) {
                assertionError("Found " + list.size() + " errors and " + i3 + " completion events instead of none");
                return;
            }
            assertionError("Found " + list.size() + " errors and " + i3 + " completion events instead of none");
        }
    }

    public void assertNoValues() {
        int size = this.values.size();
        if (size != 0) {
            assertionError("No onNext events expected yet some received: " + size);
        }
    }

    public void assertNotCompleted() {
        int i3 = this.completions;
        if (i3 == 1) {
            assertionError("Completed!");
        } else if (i3 > 1) {
            assertionError("Completed multiple times: " + i3);
        }
    }

    public void assertReceivedOnNext(List<T> list) {
        String str;
        if (this.values.size() != list.size()) {
            assertionError("Number of items does not match. Provided: " + list.size() + "  Actual: " + this.values.size() + ".\nProvided values: " + list + "\nActual values: " + this.values + "\n");
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            T t16 = list.get(i3);
            T t17 = this.values.get(i3);
            if (t16 == null) {
                if (t17 != null) {
                    assertionError("Value at index: " + i3 + " expected to be [null] but was: [" + t17 + "]\n");
                }
            } else if (!t16.equals(t17)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Value at index: ");
                sb5.append(i3);
                sb5.append(" expected to be [");
                sb5.append(t16);
                sb5.append("] (");
                sb5.append(t16.getClass().getSimpleName());
                sb5.append(") but was: [");
                sb5.append(t17);
                sb5.append("] (");
                if (t17 != null) {
                    str = t17.getClass().getSimpleName();
                } else {
                    str = "null";
                }
                sb5.append(str);
                sb5.append(")\n");
                assertionError(sb5.toString());
            }
        }
    }

    public void assertTerminalEvent() {
        if (this.errors.size() > 1) {
            assertionError("Too many onError events: " + this.errors.size());
        }
        if (this.completions > 1) {
            assertionError("Too many onCompleted events: " + this.completions);
        }
        if (this.completions == 1 && this.errors.size() == 1) {
            assertionError("Received both an onError and onCompleted. Should be one or the other.");
        }
        if (this.completions == 0 && this.errors.isEmpty()) {
            assertionError("No terminal events received.");
        }
    }

    public void assertUnsubscribed() {
        if (!isUnsubscribed()) {
            assertionError("Not unsubscribed.");
        }
    }

    public void assertValue(T t16) {
        assertReceivedOnNext(Collections.singletonList(t16));
    }

    public void assertValueCount(int i3) {
        int size = this.values.size();
        if (size != i3) {
            assertionError("Number of onNext events differ; expected: " + i3 + ", actual: " + size);
        }
    }

    public void assertValues(T... tArr) {
        assertReceivedOnNext(Arrays.asList(tArr));
    }

    final void assertionError(String str) {
        StringBuilder sb5 = new StringBuilder(str.length() + 32);
        sb5.append(str);
        sb5.append(" (");
        int i3 = this.completions;
        sb5.append(i3);
        sb5.append(" completion");
        if (i3 != 1) {
            sb5.append('s');
        }
        sb5.append(')');
        if (!this.errors.isEmpty()) {
            int size = this.errors.size();
            sb5.append(" (+");
            sb5.append(size);
            sb5.append(" error");
            if (size != 1) {
                sb5.append('s');
            }
            sb5.append(')');
        }
        AssertionError assertionError = new AssertionError(sb5.toString());
        if (!this.errors.isEmpty()) {
            if (this.errors.size() == 1) {
                assertionError.initCause(this.errors.get(0));
                throw assertionError;
            }
            assertionError.initCause(new CompositeException(this.errors));
            throw assertionError;
        }
        throw assertionError;
    }

    public void awaitTerminalEvent() {
        try {
            this.latch.await();
        } catch (InterruptedException e16) {
            throw new IllegalStateException("Interrupted", e16);
        }
    }

    public void awaitTerminalEventAndUnsubscribeOnTimeout(long j3, TimeUnit timeUnit) {
        try {
            if (!this.latch.await(j3, timeUnit)) {
                unsubscribe();
            }
        } catch (InterruptedException unused) {
            unsubscribe();
        }
    }

    @Experimental
    public final boolean awaitValueCount(int i3, long j3, TimeUnit timeUnit) throws InterruptedException {
        while (j3 != 0 && this.valueCount < i3) {
            timeUnit.sleep(1L);
            j3--;
        }
        if (this.valueCount >= i3) {
            return true;
        }
        return false;
    }

    @Experimental
    public final int getCompletions() {
        return this.completions;
    }

    public Thread getLastSeenThread() {
        return this.lastSeenThread;
    }

    @Deprecated
    public List<Notification<T>> getOnCompletedEvents() {
        int i3;
        int i16 = this.completions;
        if (i16 != 0) {
            i3 = i16;
        } else {
            i3 = 1;
        }
        ArrayList arrayList = new ArrayList(i3);
        for (int i17 = 0; i17 < i16; i17++) {
            arrayList.add(Notification.createOnCompleted());
        }
        return arrayList;
    }

    public List<Throwable> getOnErrorEvents() {
        return this.errors;
    }

    public List<T> getOnNextEvents() {
        return this.values;
    }

    public final int getValueCount() {
        return this.valueCount;
    }

    @Override // rx.Observer
    public void onCompleted() {
        try {
            this.completions++;
            this.lastSeenThread = Thread.currentThread();
            this.delegate.onCompleted();
        } finally {
            this.latch.countDown();
        }
    }

    @Override // rx.Observer
    public void onError(Throwable th5) {
        try {
            this.lastSeenThread = Thread.currentThread();
            this.errors.add(th5);
            this.delegate.onError(th5);
        } finally {
            this.latch.countDown();
        }
    }

    @Override // rx.Observer
    public void onNext(T t16) {
        this.lastSeenThread = Thread.currentThread();
        this.values.add(t16);
        this.valueCount = this.values.size();
        this.delegate.onNext(t16);
    }

    public void requestMore(long j3) {
        request(j3);
    }

    public TestSubscriber(Observer<T> observer, long j3) {
        this.latch = new CountDownLatch(1);
        observer.getClass();
        this.delegate = observer;
        if (j3 >= 0) {
            request(j3);
        }
        this.values = new ArrayList();
        this.errors = new ArrayList();
    }

    public static <T> TestSubscriber<T> create(long j3) {
        return new TestSubscriber<>(j3);
    }

    public static <T> TestSubscriber<T> create(Observer<T> observer, long j3) {
        return new TestSubscriber<>(observer, j3);
    }

    public void awaitTerminalEvent(long j3, TimeUnit timeUnit) {
        try {
            this.latch.await(j3, timeUnit);
        } catch (InterruptedException e16) {
            throw new IllegalStateException("Interrupted", e16);
        }
    }

    public static <T> TestSubscriber<T> create(Subscriber<T> subscriber) {
        return new TestSubscriber<>((Subscriber) subscriber);
    }

    public static <T> TestSubscriber<T> create(Observer<T> observer) {
        return new TestSubscriber<>(observer);
    }

    public TestSubscriber(Subscriber<T> subscriber) {
        this(subscriber, -1L);
    }

    public TestSubscriber(Observer<T> observer) {
        this(observer, -1L);
    }

    public TestSubscriber() {
        this(-1L);
    }

    public void assertError(Throwable th5) {
        List<Throwable> list = this.errors;
        if (list.isEmpty()) {
            assertionError("No errors");
            return;
        }
        if (list.size() > 1) {
            assertionError("Multiple errors");
            return;
        }
        if (th5.equals(list.get(0))) {
            return;
        }
        assertionError("Exceptions differ; expected: " + th5 + ", actual: " + list.get(0));
    }
}
