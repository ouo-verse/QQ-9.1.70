package rx.functions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Actions {
    private static final EmptyAction EMPTY_ACTION = new EmptyAction();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Action1CallsAction0<T> implements Action1<T> {
        final Action0 action;

        public Action1CallsAction0(Action0 action0) {
            this.action = action0;
        }

        @Override // rx.functions.Action1
        public void call(T t16) {
            this.action.call();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class EmptyAction<T0, T1, T2, T3, T4, T5, T6, T7, T8> implements Action0, Action1<T0>, Action2<T0, T1>, Action3<T0, T1, T2>, Action4<T0, T1, T2, T3>, Action5<T0, T1, T2, T3, T4>, Action6<T0, T1, T2, T3, T4, T5>, Action7<T0, T1, T2, T3, T4, T5, T6>, Action8<T0, T1, T2, T3, T4, T5, T6, T7>, Action9<T0, T1, T2, T3, T4, T5, T6, T7, T8>, ActionN {
        EmptyAction() {
        }

        @Override // rx.functions.Action0
        public void call() {
        }

        @Override // rx.functions.Action1
        public void call(T0 t06) {
        }

        @Override // rx.functions.Action2
        public void call(T0 t06, T1 t16) {
        }

        @Override // rx.functions.Action3
        public void call(T0 t06, T1 t16, T2 t26) {
        }

        @Override // rx.functions.Action4
        public void call(T0 t06, T1 t16, T2 t26, T3 t36) {
        }

        @Override // rx.functions.Action5
        public void call(T0 t06, T1 t16, T2 t26, T3 t36, T4 t46) {
        }

        @Override // rx.functions.Action6
        public void call(T0 t06, T1 t16, T2 t26, T3 t36, T4 t46, T5 t56) {
        }

        @Override // rx.functions.Action7
        public void call(T0 t06, T1 t16, T2 t26, T3 t36, T4 t46, T5 t56, T6 t65) {
        }

        @Override // rx.functions.Action8
        public void call(T0 t06, T1 t16, T2 t26, T3 t36, T4 t46, T5 t56, T6 t65, T7 t75) {
        }

        @Override // rx.functions.Action9
        public void call(T0 t06, T1 t16, T2 t26, T3 t36, T4 t46, T5 t56, T6 t65, T7 t75, T8 t85) {
        }

        @Override // rx.functions.ActionN
        public void call(Object... objArr) {
        }
    }

    Actions() {
        throw new IllegalStateException("No instances!");
    }

    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8> EmptyAction<T0, T1, T2, T3, T4, T5, T6, T7, T8> empty() {
        return EMPTY_ACTION;
    }

    public static <T> Action1<T> toAction1(Action0 action0) {
        return new Action1CallsAction0(action0);
    }

    public static Func0<Void> toFunc(Action0 action0) {
        return toFunc(action0, (Object) null);
    }

    public static <T1> Func1<T1, Void> toFunc(Action1<T1> action1) {
        return toFunc(action1, (Object) null);
    }

    public static <T1, T2> Func2<T1, T2, Void> toFunc(Action2<T1, T2> action2) {
        return toFunc(action2, (Object) null);
    }

    public static <T1, T2, T3> Func3<T1, T2, T3, Void> toFunc(Action3<T1, T2, T3> action3) {
        return toFunc(action3, (Object) null);
    }

    public static <T1, T2, T3, T4> Func4<T1, T2, T3, T4, Void> toFunc(Action4<T1, T2, T3, T4> action4) {
        return toFunc(action4, (Object) null);
    }

    public static <T1, T2, T3, T4, T5> Func5<T1, T2, T3, T4, T5, Void> toFunc(Action5<T1, T2, T3, T4, T5> action5) {
        return toFunc(action5, (Object) null);
    }

    public static <T1, T2, T3, T4, T5, T6> Func6<T1, T2, T3, T4, T5, T6, Void> toFunc(Action6<T1, T2, T3, T4, T5, T6> action6) {
        return toFunc(action6, (Object) null);
    }

    public static <T1, T2, T3, T4, T5, T6, T7> Func7<T1, T2, T3, T4, T5, T6, T7, Void> toFunc(Action7<T1, T2, T3, T4, T5, T6, T7> action7) {
        return toFunc(action7, (Object) null);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8> Func8<T1, T2, T3, T4, T5, T6, T7, T8, Void> toFunc(Action8<T1, T2, T3, T4, T5, T6, T7, T8> action8) {
        return toFunc(action8, (Object) null);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Void> toFunc(Action9<T1, T2, T3, T4, T5, T6, T7, T8, T9> action9) {
        return toFunc(action9, (Object) null);
    }

    public static FuncN<Void> toFunc(ActionN actionN) {
        return toFunc(actionN, (Object) null);
    }

    public static <R> Func0<R> toFunc(final Action0 action0, final R r16) {
        return new Func0<R>() { // from class: rx.functions.Actions.1
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public R call() {
                Action0.this.call();
                return (R) r16;
            }
        };
    }

    public static <T1, R> Func1<T1, R> toFunc(final Action1<T1> action1, final R r16) {
        return new Func1<T1, R>() { // from class: rx.functions.Actions.2
            @Override // rx.functions.Func1
            public R call(T1 t16) {
                Action1.this.call(t16);
                return (R) r16;
            }
        };
    }

    public static <T1, T2, R> Func2<T1, T2, R> toFunc(final Action2<T1, T2> action2, final R r16) {
        return new Func2<T1, T2, R>() { // from class: rx.functions.Actions.3
            @Override // rx.functions.Func2
            public R call(T1 t16, T2 t26) {
                Action2.this.call(t16, t26);
                return (R) r16;
            }
        };
    }

    public static <T1, T2, T3, R> Func3<T1, T2, T3, R> toFunc(final Action3<T1, T2, T3> action3, final R r16) {
        return new Func3<T1, T2, T3, R>() { // from class: rx.functions.Actions.4
            @Override // rx.functions.Func3
            public R call(T1 t16, T2 t26, T3 t36) {
                Action3.this.call(t16, t26, t36);
                return (R) r16;
            }
        };
    }

    public static <T1, T2, T3, T4, R> Func4<T1, T2, T3, T4, R> toFunc(final Action4<T1, T2, T3, T4> action4, final R r16) {
        return new Func4<T1, T2, T3, T4, R>() { // from class: rx.functions.Actions.5
            @Override // rx.functions.Func4
            public R call(T1 t16, T2 t26, T3 t36, T4 t46) {
                Action4.this.call(t16, t26, t36, t46);
                return (R) r16;
            }
        };
    }

    public static <T1, T2, T3, T4, T5, R> Func5<T1, T2, T3, T4, T5, R> toFunc(final Action5<T1, T2, T3, T4, T5> action5, final R r16) {
        return new Func5<T1, T2, T3, T4, T5, R>() { // from class: rx.functions.Actions.6
            @Override // rx.functions.Func5
            public R call(T1 t16, T2 t26, T3 t36, T4 t46, T5 t56) {
                Action5.this.call(t16, t26, t36, t46, t56);
                return (R) r16;
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, R> Func6<T1, T2, T3, T4, T5, T6, R> toFunc(final Action6<T1, T2, T3, T4, T5, T6> action6, final R r16) {
        return new Func6<T1, T2, T3, T4, T5, T6, R>() { // from class: rx.functions.Actions.7
            @Override // rx.functions.Func6
            public R call(T1 t16, T2 t26, T3 t36, T4 t46, T5 t56, T6 t65) {
                Action6.this.call(t16, t26, t36, t46, t56, t65);
                return (R) r16;
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Func7<T1, T2, T3, T4, T5, T6, T7, R> toFunc(final Action7<T1, T2, T3, T4, T5, T6, T7> action7, final R r16) {
        return new Func7<T1, T2, T3, T4, T5, T6, T7, R>() { // from class: rx.functions.Actions.8
            @Override // rx.functions.Func7
            public R call(T1 t16, T2 t26, T3 t36, T4 t46, T5 t56, T6 t65, T7 t75) {
                Action7.this.call(t16, t26, t36, t46, t56, t65, t75);
                return (R) r16;
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Func8<T1, T2, T3, T4, T5, T6, T7, T8, R> toFunc(final Action8<T1, T2, T3, T4, T5, T6, T7, T8> action8, final R r16) {
        return new Func8<T1, T2, T3, T4, T5, T6, T7, T8, R>() { // from class: rx.functions.Actions.9
            @Override // rx.functions.Func8
            public R call(T1 t16, T2 t26, T3 t36, T4 t46, T5 t56, T6 t65, T7 t75, T8 t85) {
                Action8.this.call(t16, t26, t36, t46, t56, t65, t75, t85);
                return (R) r16;
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> toFunc(final Action9<T1, T2, T3, T4, T5, T6, T7, T8, T9> action9, final R r16) {
        return new Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>() { // from class: rx.functions.Actions.10
            @Override // rx.functions.Func9
            public R call(T1 t16, T2 t26, T3 t36, T4 t46, T5 t56, T6 t65, T7 t75, T8 t85, T9 t95) {
                Action9.this.call(t16, t26, t36, t46, t56, t65, t75, t85, t95);
                return (R) r16;
            }
        };
    }

    public static <R> FuncN<R> toFunc(final ActionN actionN, final R r16) {
        return new FuncN<R>() { // from class: rx.functions.Actions.11
            @Override // rx.functions.FuncN
            public R call(Object... objArr) {
                ActionN.this.call(objArr);
                return (R) r16;
            }
        };
    }
}
