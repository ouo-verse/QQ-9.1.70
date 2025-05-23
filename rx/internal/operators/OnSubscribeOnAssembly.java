package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.AssemblyStackTraceException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeOnAssembly<T> implements Observable.OnSubscribe<T> {
    public static volatile boolean fullStackTrace;
    final Observable.OnSubscribe<T> source;
    final String stacktrace = createStacktrace();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class OnAssemblySubscriber<T> extends Subscriber<T> {
        final Subscriber<? super T> actual;
        final String stacktrace;

        public OnAssemblySubscriber(Subscriber<? super T> subscriber, String str) {
            super(subscriber);
            this.actual = subscriber;
            this.stacktrace = str;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.actual.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.actual.onError(new AssemblyStackTraceException(this.stacktrace, th5));
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            this.actual.onNext(t16);
        }
    }

    public OnSubscribeOnAssembly(Observable.OnSubscribe<T> onSubscribe) {
        this.source = onSubscribe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String createStacktrace() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuilder sb5 = new StringBuilder("Assembly trace:");
        for (StackTraceElement stackTraceElement : stackTrace) {
            String stackTraceElement2 = stackTraceElement.toString();
            if (fullStackTrace || (stackTraceElement.getLineNumber() > 1 && !stackTraceElement2.contains("RxJavaHooks.") && !stackTraceElement2.contains("OnSubscribeOnAssembly") && !stackTraceElement2.contains(".junit.runner") && !stackTraceElement2.contains(".junit4.runner") && !stackTraceElement2.contains(".junit.internal") && !stackTraceElement2.contains("sun.reflect") && !stackTraceElement2.contains("java.lang.Thread.") && !stackTraceElement2.contains("ThreadPoolExecutor") && !stackTraceElement2.contains("org.apache.catalina.") && !stackTraceElement2.contains("org.apache.tomcat."))) {
                sb5.append("\n at ");
                sb5.append(stackTraceElement2);
            }
        }
        sb5.append("\nOriginal exception:");
        return sb5.toString();
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        this.source.call(new OnAssemblySubscriber(subscriber, this.stacktrace));
    }
}
