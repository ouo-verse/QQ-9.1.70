package ua1;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lua1/c;", "", "Lua1/b;", "a", "", "b", "Ljava/lang/String;", "lastReqUid", "c", "Lua1/b;", "cacheBean", "d", "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f438640a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String lastReqUid = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static b cacheBean = new b();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Object lock = new Object();

    c() {
    }

    @NotNull
    public final b a() {
        synchronized (lock) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return cacheBean;
            }
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "MobileQQ.sMobileQQ.peekA\u2026ime() ?: return cacheBean");
            String currentReqUid = peekAppRuntime.getCurrentUid();
            if (!Intrinsics.areEqual(currentReqUid, lastReqUid)) {
                IConfigData loadConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("yqh_entrance_config");
                Intrinsics.checkNotNull(loadConfig, "null cannot be cast to non-null type com.tencent.mobileqq.config.business.together.TogetherEntryConfigData");
                cacheBean = (b) loadConfig;
                Intrinsics.checkNotNullExpressionValue(currentReqUid, "currentReqUid");
                lastReqUid = currentReqUid;
            }
            return cacheBean;
        }
    }
}
