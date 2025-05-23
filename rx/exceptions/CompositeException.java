package rx.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import rx.annotations.Experimental;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class CompositeExceptionCausalChain extends RuntimeException {
        static final String MESSAGE = "Chain of Causes for CompositeException In Order Received =>";
        private static final long serialVersionUID = 3875212506787802066L;

        CompositeExceptionCausalChain() {
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return MESSAGE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static abstract class PrintStreamOrWriter {
        PrintStreamOrWriter() {
        }

        abstract Object lock();

        abstract void println(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class WrappedPrintStream extends PrintStreamOrWriter {
        private final PrintStream printStream;

        WrappedPrintStream(PrintStream printStream) {
            this.printStream = printStream;
        }

        @Override // rx.exceptions.CompositeException.PrintStreamOrWriter
        Object lock() {
            return this.printStream;
        }

        @Override // rx.exceptions.CompositeException.PrintStreamOrWriter
        void println(Object obj) {
            this.printStream.println(obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class WrappedPrintWriter extends PrintStreamOrWriter {
        private final PrintWriter printWriter;

        WrappedPrintWriter(PrintWriter printWriter) {
            this.printWriter = printWriter;
        }

        @Override // rx.exceptions.CompositeException.PrintStreamOrWriter
        Object lock() {
            return this.printWriter;
        }

        @Override // rx.exceptions.CompositeException.PrintStreamOrWriter
        void println(Object obj) {
            this.printWriter.println(obj);
        }
    }

    @Deprecated
    public CompositeException(String str, Collection<? extends Throwable> collection) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            for (Throwable th5 : collection) {
                if (th5 instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th5).getExceptions());
                } else if (th5 != null) {
                    linkedHashSet.add(th5);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        arrayList.addAll(linkedHashSet);
        List<Throwable> unmodifiableList = Collections.unmodifiableList(arrayList);
        this.exceptions = unmodifiableList;
        this.message = unmodifiableList.size() + " exceptions occurred. ";
    }

    private void appendStackTrace(StringBuilder sb5, Throwable th5, String str) {
        sb5.append(str);
        sb5.append(th5);
        sb5.append('\n');
        for (StackTraceElement stackTraceElement : th5.getStackTrace()) {
            sb5.append("\t\tat ");
            sb5.append(stackTraceElement);
            sb5.append('\n');
        }
        if (th5.getCause() != null) {
            sb5.append("\tCaused by: ");
            appendStackTrace(sb5, th5.getCause(), "");
        }
    }

    private List<Throwable> getListOfCauses(Throwable th5) {
        ArrayList arrayList = new ArrayList();
        Throwable cause = th5.getCause();
        if (cause != null && cause != th5) {
            while (true) {
                arrayList.add(cause);
                Throwable cause2 = cause.getCause();
                if (cause2 == null || cause2 == cause) {
                    break;
                }
                cause = cause.getCause();
            }
        }
        return arrayList;
    }

    private Throwable getRootCause(Throwable th5) {
        Throwable cause = th5.getCause();
        if (cause != null && cause != th5) {
            while (true) {
                Throwable cause2 = cause.getCause();
                if (cause2 == null || cause2 == cause) {
                    break;
                }
                cause = cause.getCause();
            }
            return cause;
        }
        return th5;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        if (this.cause == null) {
            CompositeExceptionCausalChain compositeExceptionCausalChain = new CompositeExceptionCausalChain();
            HashSet hashSet = new HashSet();
            Iterator<Throwable> it = this.exceptions.iterator();
            Throwable th5 = compositeExceptionCausalChain;
            while (it.hasNext()) {
                Throwable next = it.next();
                if (!hashSet.contains(next)) {
                    hashSet.add(next);
                    for (Throwable th6 : getListOfCauses(next)) {
                        if (hashSet.contains(th6)) {
                            next = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            hashSet.add(th6);
                        }
                    }
                    try {
                        th5.initCause(next);
                    } catch (Throwable unused) {
                    }
                    th5 = getRootCause(th5);
                }
            }
            this.cause = compositeExceptionCausalChain;
        }
        return this.cause;
    }

    public List<Throwable> getExceptions() {
        return this.exceptions;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        printStackTrace(new WrappedPrintStream(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        printStackTrace(new WrappedPrintWriter(printWriter));
    }

    private void printStackTrace(PrintStreamOrWriter printStreamOrWriter) {
        StringBuilder sb5 = new StringBuilder(128);
        sb5.append(this);
        sb5.append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb5.append("\tat ");
            sb5.append(stackTraceElement);
            sb5.append('\n');
        }
        int i3 = 1;
        for (Throwable th5 : this.exceptions) {
            sb5.append("  ComposedException ");
            sb5.append(i3);
            sb5.append(" :\n");
            appendStackTrace(sb5, th5, "\t");
            i3++;
        }
        synchronized (printStreamOrWriter.lock()) {
            printStreamOrWriter.println(sb5.toString());
        }
    }

    public CompositeException(Collection<? extends Throwable> collection) {
        this(null, collection);
    }

    @Experimental
    public CompositeException(Throwable... thArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (thArr != null) {
            for (Throwable th5 : thArr) {
                if (th5 instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th5).getExceptions());
                } else if (th5 != null) {
                    linkedHashSet.add(th5);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        arrayList.addAll(linkedHashSet);
        List<Throwable> unmodifiableList = Collections.unmodifiableList(arrayList);
        this.exceptions = unmodifiableList;
        this.message = unmodifiableList.size() + " exceptions occurred. ";
    }
}
