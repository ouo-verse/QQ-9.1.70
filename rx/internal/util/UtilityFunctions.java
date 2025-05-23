package rx.internal.util;

import rx.functions.Func1;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UtilityFunctions {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    enum AlwaysFalse implements Func1<Object, Boolean> {
        INSTANCE;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // rx.functions.Func1
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    enum AlwaysTrue implements Func1<Object, Boolean> {
        INSTANCE;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // rx.functions.Func1
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }

    UtilityFunctions() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Func1<? super T, Boolean> alwaysFalse() {
        return AlwaysFalse.INSTANCE;
    }

    public static <T> Func1<? super T, Boolean> alwaysTrue() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> Func1<T, T> identity() {
        return new Func1<T, T>() { // from class: rx.internal.util.UtilityFunctions.1
            @Override // rx.functions.Func1
            public T call(T t16) {
                return t16;
            }
        };
    }
}
