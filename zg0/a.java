package zg0;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.ticket.api.IECPSKeyCallback;
import com.tencent.ecommerce.base.ticket.api.IECTicketManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import yg0.ECPsKey;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J%\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ#\u0010\n\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\n\u0010\tJ'\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lzg0/a;", "", "", "", "domains", "Lcom/tencent/ecommerce/base/ticket/api/IECPSKeyCallback;", "callback", "", "d", "([Ljava/lang/String;Lcom/tencent/ecommerce/base/ticket/api/IECPSKeyCallback;)V", "b", "", "Lyg0/b;", "c", "([Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/base/ticket/api/IECTicketManager;", "a", "Lcom/tencent/ecommerce/base/ticket/api/IECTicketManager;", "ticketProxy", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f452502b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final IECTicketManager ticketProxy = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getTicket();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"zg0/a$a", "Lcom/tencent/ecommerce/base/ticket/api/IECPSKeyCallback;", "", "Lyg0/b;", "pSKeys", "", "onSuccess", "", "msg", "onFailed", "onTimeout", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: zg0.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11679a implements IECPSKeyCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation f452503a;

        C11679a(CancellableContinuation cancellableContinuation) {
            this.f452503a = cancellableContinuation;
        }

        @Override // com.tencent.ecommerce.base.ticket.api.IECPSKeyCallback
        public void onFailed(String msg2) {
            List emptyList;
            cg0.a.a("ECTicketManager", "getPsKeysAsyncNoCache", "getPsKeysAsync onFailed: " + msg2);
            CancellableContinuation cancellableContinuation = this.f452503a;
            Result.Companion companion = Result.INSTANCE;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            cancellableContinuation.resumeWith(Result.m476constructorimpl(emptyList));
        }

        @Override // com.tencent.ecommerce.base.ticket.api.IECPSKeyCallback
        public void onSuccess(List<ECPsKey> pSKeys) {
            this.f452503a.resumeWith(Result.m476constructorimpl(pSKeys));
        }

        @Override // com.tencent.ecommerce.base.ticket.api.IECPSKeyCallback
        public void onTimeout(String msg2) {
            List emptyList;
            cg0.a.a("ECTicketManager", "getPsKeysAsyncNoCache", "getPsKeysAsync timeout: " + msg2);
            CancellableContinuation cancellableContinuation = this.f452503a;
            Result.Companion companion = Result.INSTANCE;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            cancellableContinuation.resumeWith(Result.m476constructorimpl(emptyList));
        }
    }

    a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(String[] domains, IECPSKeyCallback callback) {
        ticketProxy.getPsKeysAsyncNoCache(domains, callback);
    }

    public final void b(String[] domains, IECPSKeyCallback callback) {
        ticketProxy.getPsKeysAsync(domains, callback);
    }

    public final Object c(String[] strArr, Continuation<? super List<ECPsKey>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        f452502b.d(strArr, new C11679a(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
