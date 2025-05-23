package ug0;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0007J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0005H\u0007J\b\u0010\u000b\u001a\u00020\tH\u0007R\u0014\u0010\u0007\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\rR0\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u000ej\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lug0/a;", "", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "schemeCallback", "", "", "c", "callbackId", "b", "", "d", "a", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "callbackMap", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f438929c = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final AtomicInteger callbackId = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, IECSchemeCallback> callbackMap = new HashMap<>();

    a() {
    }

    @JvmStatic
    public static final void a() {
        callbackMap.clear();
        QQEcommerceSdk.INSTANCE.releaseAllSchemeCallbacks();
        cg0.a.b("ECSchemeCallbackManager", "[unRegisterSchemeCallback]");
    }

    @JvmStatic
    public static final IECSchemeCallback b(String callbackId2) {
        return callbackMap.get(callbackId2);
    }

    @JvmStatic
    public static final void d(String callbackId2) {
        callbackMap.remove(callbackId2);
        cg0.a.b("ECSchemeCallbackManager", "[unRegisterSchemeCallback] callbackId = " + callbackId2);
    }

    @JvmStatic
    public static final Map<String, String> c(IECSchemeCallback schemeCallback) {
        Map<String, String> mapOf;
        Map<String, String> emptyMap;
        if (schemeCallback == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        AtomicInteger atomicInteger = callbackId;
        String valueOf = String.valueOf(atomicInteger.getAndIncrement());
        callbackMap.put(valueOf, schemeCallback);
        cg0.a.b("ECSchemeCallbackManager", "[registerSchemeCallback] callbackId = " + atomicInteger);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("scheme_callback_id", valueOf));
        return mapOf;
    }
}
