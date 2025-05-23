package vb3;

import aj3.c;
import com.tencent.mobileqq.zplan.authorize.impl.EntranceCheckImpl;
import com.tencent.mobileqq.zplan.avatar.impl.cache.UECacheInfoManager;
import com.tencent.mobileqq.zplan.avatar.impl.scene.UESceneEnterRecorder;
import com.tencent.mobileqq.zplan.cloudmod.impl.CloudModApiImpl;
import com.tencent.mobileqq.zplan.mod.impl.ModComponentsApiImpl;
import com.tencent.mobileqq.zplan.mod.impl.d;
import com.tencent.mobileqq.zplan.reservation.impl.ReservationImpl;
import com.tencent.mobileqq.zplan.room.impl.trtc.ZpanTRTCImpl;
import com.tencent.mobileqq.zplan.video.impl.plugin.TXVideoApiImpl;
import com.tencent.mobileqq.zplan.web.impl.ZplanWebImpl;
import com.tencent.mobileqq.zplan.web.impl.g;
import com.tencent.mobileqq.zplan.widget.impl.control.MediaPlayControlApiImpl;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ \u0010\u0006\u001a\u00020\u0002\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002J%\u0010\u0007\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ(\u0010\t\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086\u0002\u00a2\u0006\u0004\b\t\u0010\bR(\u0010\f\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0004\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lvb3/a;", "", "Lvb3/b;", "T", "Ljava/lang/Class;", "apiClass", "c", "a", "(Ljava/lang/Class;)Lvb3/b;", "b", "", "Ljava/util/Map;", "M_SERVICE_MAP", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f441346a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<Class<? extends b>, b> M_SERVICE_MAP = new LinkedHashMap();

    a() {
    }

    private final <T extends b> b c(Class<T> apiClass) {
        if (Intrinsics.areEqual(apiClass, com.tencent.mobileqq.zplan.authorize.api.b.class)) {
            return new com.tencent.mobileqq.zplan.authorize.impl.a();
        }
        if (Intrinsics.areEqual(apiClass, qg3.a.class)) {
            return new rg3.a();
        }
        if (Intrinsics.areEqual(apiClass, nf3.a.class)) {
            return new of3.a();
        }
        if (Intrinsics.areEqual(apiClass, cl3.b.class)) {
            return new ZplanWebImpl();
        }
        if (Intrinsics.areEqual(apiClass, gl3.a.class)) {
            return new MediaPlayControlApiImpl();
        }
        if (Intrinsics.areEqual(apiClass, el3.a.class)) {
            return new il3.a();
        }
        if (Intrinsics.areEqual(apiClass, si3.b.class)) {
            return new ModComponentsApiImpl();
        }
        if (Intrinsics.areEqual(apiClass, yg3.b.class)) {
            return new ah3.a();
        }
        if (Intrinsics.areEqual(apiClass, ye3.a.class)) {
            return new if3.a();
        }
        if (Intrinsics.areEqual(apiClass, xe3.a.class)) {
            return UESceneEnterRecorder.f331958b;
        }
        if (Intrinsics.areEqual(apiClass, zk3.a.class)) {
            return new TXVideoApiImpl();
        }
        if (Intrinsics.areEqual(apiClass, tj3.a.class)) {
            return new ReservationImpl();
        }
        if (Intrinsics.areEqual(apiClass, ue3.b.class)) {
            return UECacheInfoManager.f331873b;
        }
        if (Intrinsics.areEqual(apiClass, zi3.a.class)) {
            return new c();
        }
        if (Intrinsics.areEqual(apiClass, vj3.a.class)) {
            return new xj3.a();
        }
        if (Intrinsics.areEqual(apiClass, bk3.a.class)) {
            return new dk3.a();
        }
        if (Intrinsics.areEqual(apiClass, cl3.a.class)) {
            return new g();
        }
        if (Intrinsics.areEqual(apiClass, com.tencent.mobileqq.zplan.cloudmod.api.a.class)) {
            return new CloudModApiImpl();
        }
        if (Intrinsics.areEqual(apiClass, te3.a.class)) {
            return new af3.a();
        }
        if (Intrinsics.areEqual(apiClass, gi3.a.class)) {
            return new hi3.a();
        }
        if (Intrinsics.areEqual(apiClass, com.tencent.mobileqq.zplan.authorize.api.c.class)) {
            return new EntranceCheckImpl();
        }
        if (Intrinsics.areEqual(apiClass, si3.c.class)) {
            return new d();
        }
        if (Intrinsics.areEqual(apiClass, gk3.a.class)) {
            return new ik3.a();
        }
        if (Intrinsics.areEqual(apiClass, gk3.b.class)) {
            return new ZpanTRTCImpl();
        }
        if (Intrinsics.areEqual(apiClass, si3.a.class)) {
            return new com.tencent.mobileqq.zplan.mod.impl.a();
        }
        throw new Exception("can not find target implement class");
    }

    public final synchronized <T extends b> T a(Class<T> apiClass) {
        T t16;
        Intrinsics.checkNotNullParameter(apiClass, "apiClass");
        Map<Class<? extends b>, b> map = M_SERVICE_MAP;
        t16 = (T) map.get(apiClass);
        if (t16 == null) {
            t16 = (T) c(apiClass);
            map.put(apiClass, t16);
        }
        Intrinsics.checkNotNull(t16, "null cannot be cast to non-null type T of com.tencent.mobileqq.zootopia.base.ZRoute.api");
        return t16;
    }

    public final <T extends b> T b(Class<T> apiClass) {
        Intrinsics.checkNotNullParameter(apiClass, "apiClass");
        return (T) a(apiClass);
    }
}
