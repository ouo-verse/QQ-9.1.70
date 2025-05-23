package ya4;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.w;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qv4.z;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u000b"}, d2 = {"Lya4/b;", "", "", "b", "Lqv4/z;", "rsp", "", "c", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f449938a = new b();

    b() {
    }

    private final String b() {
        return "zplan_role_data_" + w.f373306a.b();
    }

    public final z a() {
        String b16 = b();
        byte[] bytes = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBytes(b16, new byte[0]);
        QLog.i("ZPlanRoleDataCacheManager_", 1, "getCache key:" + b16 + ", bytes size:" + bytes.length);
        if (bytes.length == 0) {
            return null;
        }
        z zVar = new z();
        try {
            MessageNano.mergeFrom(zVar, bytes);
            return zVar;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void c(z rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        String b16 = b();
        byte[] bytes = MessageNano.toByteArray(rsp);
        QLog.i("ZPlanRoleDataCacheManager_", 1, "saveCache key:" + b16 + ", bytes size:" + bytes.length);
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).remove(b16);
        IZPlanMMKVApi iZPlanMMKVApi = (IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class);
        Intrinsics.checkNotNullExpressionValue(bytes, "bytes");
        iZPlanMMKVApi.setBytes(b16, bytes);
    }
}
