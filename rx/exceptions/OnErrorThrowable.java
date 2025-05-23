package rx.exceptions;

import java.util.HashSet;
import java.util.Set;
import rx.plugins.RxJavaPlugins;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnErrorThrowable extends RuntimeException {
    private static final long serialVersionUID = -569558213262703934L;
    private final boolean hasValue;
    private final Object value;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class OnNextValue extends RuntimeException {
        private static final long serialVersionUID = -3454462756050397899L;
        private final Object value;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class Primitives {
            static final Set<Class<?>> INSTANCE = create();

            Primitives() {
            }

            private static Set<Class<?>> create() {
                HashSet hashSet = new HashSet();
                hashSet.add(Boolean.class);
                hashSet.add(Character.class);
                hashSet.add(Byte.class);
                hashSet.add(Short.class);
                hashSet.add(Integer.class);
                hashSet.add(Long.class);
                hashSet.add(Float.class);
                hashSet.add(Double.class);
                return hashSet;
            }
        }

        public OnNextValue(Object obj) {
            super("OnError while emitting onNext value: " + renderValue(obj));
            this.value = obj;
        }

        static String renderValue(Object obj) {
            if (obj == null) {
                return "null";
            }
            if (Primitives.INSTANCE.contains(obj.getClass())) {
                return obj.toString();
            }
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof Enum) {
                return ((Enum) obj).name();
            }
            String handleOnNextValueRendering = RxJavaPlugins.getInstance().getErrorHandler().handleOnNextValueRendering(obj);
            if (handleOnNextValueRendering != null) {
                return handleOnNextValueRendering;
            }
            return obj.getClass().getName() + ".class";
        }

        public Object getValue() {
            return this.value;
        }
    }

    OnErrorThrowable(Throwable th5) {
        super(th5);
        this.hasValue = false;
        this.value = null;
    }

    public static Throwable addValueAsLastCause(Throwable th5, Object obj) {
        if (th5 == null) {
            th5 = new NullPointerException();
        }
        Throwable finalCause = Exceptions.getFinalCause(th5);
        if ((finalCause instanceof OnNextValue) && ((OnNextValue) finalCause).getValue() == obj) {
            return th5;
        }
        Exceptions.addCause(th5, new OnNextValue(obj));
        return th5;
    }

    public static OnErrorThrowable from(Throwable th5) {
        if (th5 == null) {
            th5 = new NullPointerException();
        }
        Throwable finalCause = Exceptions.getFinalCause(th5);
        if (finalCause instanceof OnNextValue) {
            return new OnErrorThrowable(th5, ((OnNextValue) finalCause).getValue());
        }
        return new OnErrorThrowable(th5);
    }

    public Object getValue() {
        return this.value;
    }

    public boolean isValueNull() {
        return this.hasValue;
    }

    OnErrorThrowable(Throwable th5, Object obj) {
        super(th5);
        this.hasValue = true;
        this.value = obj;
    }
}
