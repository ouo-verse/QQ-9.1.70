package rx.observers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Notification;
import rx.Observer;
import rx.exceptions.CompositeException;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class TestObserver<T> implements Observer<T> {
    private static final Observer<Object> INERT = new Observer<Object>() { // from class: rx.observers.TestObserver.1
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
    private final Observer<T> delegate;
    private final List<Notification<T>> onCompletedEvents;
    private final List<Throwable> onErrorEvents;
    private final List<T> onNextEvents;

    public TestObserver(Observer<T> observer) {
        this.onNextEvents = new ArrayList();
        this.onErrorEvents = new ArrayList();
        this.onCompletedEvents = new ArrayList();
        this.delegate = observer;
    }

    public void assertReceivedOnNext(List<T> list) {
        String str;
        if (this.onNextEvents.size() != list.size()) {
            assertionError("Number of items does not match. Provided: " + list.size() + "  Actual: " + this.onNextEvents.size() + ".\nProvided values: " + list + "\nActual values: " + this.onNextEvents + "\n");
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            T t16 = list.get(i3);
            T t17 = this.onNextEvents.get(i3);
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
        if (this.onErrorEvents.size() > 1) {
            assertionError("Too many onError events: " + this.onErrorEvents.size());
        }
        if (this.onCompletedEvents.size() > 1) {
            assertionError("Too many onCompleted events: " + this.onCompletedEvents.size());
        }
        if (this.onCompletedEvents.size() == 1 && this.onErrorEvents.size() == 1) {
            assertionError("Received both an onError and onCompleted. Should be one or the other.");
        }
        if (this.onCompletedEvents.isEmpty() && this.onErrorEvents.isEmpty()) {
            assertionError("No terminal events received.");
        }
    }

    final void assertionError(String str) {
        StringBuilder sb5 = new StringBuilder(str.length() + 32);
        sb5.append(str);
        sb5.append(" (");
        int size = this.onCompletedEvents.size();
        sb5.append(size);
        sb5.append(" completion");
        if (size != 1) {
            sb5.append('s');
        }
        sb5.append(')');
        if (!this.onErrorEvents.isEmpty()) {
            int size2 = this.onErrorEvents.size();
            sb5.append(" (+");
            sb5.append(size2);
            sb5.append(" error");
            if (size2 != 1) {
                sb5.append('s');
            }
            sb5.append(')');
        }
        AssertionError assertionError = new AssertionError(sb5.toString());
        if (!this.onErrorEvents.isEmpty()) {
            if (this.onErrorEvents.size() == 1) {
                assertionError.initCause(this.onErrorEvents.get(0));
                throw assertionError;
            }
            assertionError.initCause(new CompositeException(this.onErrorEvents));
            throw assertionError;
        }
        throw assertionError;
    }

    public List<Object> getEvents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.onNextEvents);
        arrayList.add(this.onErrorEvents);
        arrayList.add(this.onCompletedEvents);
        return Collections.unmodifiableList(arrayList);
    }

    public List<Notification<T>> getOnCompletedEvents() {
        return Collections.unmodifiableList(this.onCompletedEvents);
    }

    public List<Throwable> getOnErrorEvents() {
        return Collections.unmodifiableList(this.onErrorEvents);
    }

    public List<T> getOnNextEvents() {
        return Collections.unmodifiableList(this.onNextEvents);
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.onCompletedEvents.add(Notification.createOnCompleted());
        this.delegate.onCompleted();
    }

    @Override // rx.Observer
    public void onError(Throwable th5) {
        this.onErrorEvents.add(th5);
        this.delegate.onError(th5);
    }

    @Override // rx.Observer
    public void onNext(T t16) {
        this.onNextEvents.add(t16);
        this.delegate.onNext(t16);
    }

    public TestObserver() {
        this.onNextEvents = new ArrayList();
        this.onErrorEvents = new ArrayList();
        this.onCompletedEvents = new ArrayList();
        this.delegate = (Observer<T>) INERT;
    }
}
