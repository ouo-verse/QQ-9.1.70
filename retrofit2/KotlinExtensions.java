package retrofit2;

import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.KotlinNothingValueException;
import kotlin.KotlinNullPointerException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0010\u0003\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0086@\u00a2\u0006\u0002\u0010\u0004\u001a(\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0003H\u0087@\u00a2\u0006\u0004\b\u0005\u0010\u0004\u001a\u001a\u0010\u0000\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00060\u0003H\u0087@\u00a2\u0006\u0004\b\u0007\u0010\u0004\u001a$\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00010\t\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0086@\u00a2\u0006\u0002\u0010\u0004\u001a\u001e\u0010\n\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u000bH\u0086\b\u00a2\u0006\u0002\u0010\f\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0080@\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"await", "T", "", "Lretrofit2/Call;", "(Lretrofit2/Call;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitNullable", "", "awaitUnit", "awaitResponse", "Lretrofit2/Response;", OperateCustomButton.OPERATE_CREATE, "Lretrofit2/Retrofit;", "(Lretrofit2/Retrofit;)Ljava/lang/Object;", "suspendAndThrow", "", "", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retrofit"}, k = 2, mv = {1, 9, 0}, xi = 48)
@JvmName(name = "KotlinExtensions")
@SourceDebugExtension({"SMAP\nKotlinExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KotlinExtensions.kt\nretrofit2/KotlinExtensions\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,126:1\n310#2,11:127\n310#2,11:138\n310#2,11:149\n*S KotlinDebug\n*F\n+ 1 KotlinExtensions.kt\nretrofit2/KotlinExtensions\n*L\n32#1:127,11\n66#1:138,11\n93#1:149,11\n*E\n"})
/* loaded from: classes29.dex */
public final class KotlinExtensions {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016\u00a8\u0006\u000b"}, d2 = {"retrofit2/KotlinExtensions$await$2$2", "Lretrofit2/Callback;", "onFailure", "", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "retrofit"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes29.dex */
    public static final class a<T> implements f<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<T> f431186a;

        /* JADX WARN: Multi-variable type inference failed */
        a(CancellableContinuation<? super T> cancellableContinuation) {
            this.f431186a = cancellableContinuation;
        }

        @Override // retrofit2.f
        public void onFailure(@NotNull d<T> call, @NotNull Throwable t16) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t16, "t");
            CancellableContinuation<T> cancellableContinuation = this.f431186a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(t16)));
        }

        @Override // retrofit2.f
        public void onResponse(@NotNull d<T> call, @NotNull ab<T> response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (response.d()) {
                T a16 = response.a();
                if (a16 == null) {
                    Object tag = call.request().tag(q.class);
                    Intrinsics.checkNotNull(tag);
                    q qVar = (q) tag;
                    KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException("Response from " + qVar.b().getName() + '.' + qVar.a().getName() + " was null but response body type was declared as non-null");
                    CancellableContinuation<T> cancellableContinuation = this.f431186a;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(kotlinNullPointerException)));
                    return;
                }
                this.f431186a.resumeWith(Result.m476constructorimpl(a16));
                return;
            }
            CancellableContinuation<T> cancellableContinuation2 = this.f431186a;
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new HttpException(response))));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001J \u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J(\u0010\b\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\nH\u0016\u00a8\u0006\u000b"}, d2 = {"retrofit2/KotlinExtensions$await$4$2", "Lretrofit2/Callback;", "onFailure", "", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "retrofit"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes29.dex */
    public static final class b<T> implements f<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<T> f431187a;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super T> cancellableContinuation) {
            this.f431187a = cancellableContinuation;
        }

        @Override // retrofit2.f
        public void onFailure(@NotNull d<T> call, @NotNull Throwable t16) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t16, "t");
            CancellableContinuation<T> cancellableContinuation = this.f431187a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(t16)));
        }

        @Override // retrofit2.f
        public void onResponse(@NotNull d<T> call, @NotNull ab<T> response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (response.d()) {
                CancellableContinuation<T> cancellableContinuation = this.f431187a;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(response.a()));
            } else {
                CancellableContinuation<T> cancellableContinuation2 = this.f431187a;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new HttpException(response))));
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016\u00a8\u0006\u000b"}, d2 = {"retrofit2/KotlinExtensions$awaitResponse$2$2", "Lretrofit2/Callback;", "onFailure", "", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "retrofit"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes29.dex */
    public static final class c<T> implements f<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<ab<T>> f431188a;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super ab<T>> cancellableContinuation) {
            this.f431188a = cancellableContinuation;
        }

        @Override // retrofit2.f
        public void onFailure(@NotNull d<T> call, @NotNull Throwable t16) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t16, "t");
            CancellableContinuation<ab<T>> cancellableContinuation = this.f431188a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(t16)));
        }

        @Override // retrofit2.f
        public void onResponse(@NotNull d<T> call, @NotNull ab<T> response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            this.f431188a.resumeWith(Result.m476constructorimpl(response));
        }
    }

    @Nullable
    public static final <T> Object a(@NotNull final d<T> dVar, @NotNull Continuation<? super T> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$await$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                dVar.cancel();
            }
        });
        dVar.g(new a(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @JvmName(name = "awaitNullable")
    @Nullable
    public static final <T> Object b(@NotNull final d<T> dVar, @NotNull Continuation<? super T> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$await$4$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                dVar.cancel();
            }
        });
        dVar.g(new b(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Nullable
    public static final <T> Object c(@NotNull final d<T> dVar, @NotNull Continuation<? super ab<T>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                dVar.cancel();
            }
        });
        dVar.g(new c(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @JvmName(name = "awaitUnit")
    @Nullable
    public static final Object d(@NotNull d<Unit> dVar, @NotNull Continuation<? super Unit> continuation) {
        Intrinsics.checkNotNull(dVar, "null cannot be cast to non-null type retrofit2.Call<kotlin.Unit?>");
        return b(dVar, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object e(@NotNull final Throwable th5, @NotNull Continuation<?> continuation) {
        final KotlinExtensions$suspendAndThrow$1 kotlinExtensions$suspendAndThrow$1;
        Object coroutine_suspended;
        int i3;
        Object coroutine_suspended2;
        Object coroutine_suspended3;
        if (continuation instanceof KotlinExtensions$suspendAndThrow$1) {
            kotlinExtensions$suspendAndThrow$1 = (KotlinExtensions$suspendAndThrow$1) continuation;
            int i16 = kotlinExtensions$suspendAndThrow$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                kotlinExtensions$suspendAndThrow$1.label = i16 - Integer.MIN_VALUE;
                Object obj = kotlinExtensions$suspendAndThrow$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = kotlinExtensions$suspendAndThrow$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    kotlinExtensions$suspendAndThrow$1.L$0 = th5;
                    kotlinExtensions$suspendAndThrow$1.label = 1;
                    Dispatchers.getDefault().mo2047dispatch(kotlinExtensions$suspendAndThrow$1.getContext(), new Runnable() { // from class: retrofit2.KotlinExtensions$suspendAndThrow$2$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            Continuation intercepted;
                            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(kotlinExtensions$suspendAndThrow$1);
                            Result.Companion companion = Result.INSTANCE;
                            intercepted.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(th5)));
                        }
                    });
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    coroutine_suspended3 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (coroutine_suspended2 == coroutine_suspended3) {
                        DebugProbes.probeCoroutineSuspended(kotlinExtensions$suspendAndThrow$1);
                    }
                    if (coroutine_suspended2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                throw new KotlinNothingValueException();
            }
        }
        kotlinExtensions$suspendAndThrow$1 = new KotlinExtensions$suspendAndThrow$1(continuation);
        Object obj2 = kotlinExtensions$suspendAndThrow$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = kotlinExtensions$suspendAndThrow$1.label;
        if (i3 == 0) {
        }
        throw new KotlinNothingValueException();
    }
}
