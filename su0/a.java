package su0;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.utils.f;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J$\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lsu0/a;", "", "", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "", "c", "eventCode", "", "params", "d", "Ljava/lang/String;", "uid", "qqVersion", "", "Z", "paramInit", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uid = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String qqVersion = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean paramInit;

    public a() {
        QQBeaconReport.start();
    }

    private final String a() {
        return "0DOU01LRZK4W1PR7";
    }

    private final HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap<>();
        if (!this.paramInit) {
            c();
        }
        hashMap.put("uid", this.uid);
        hashMap.put(AppConstants.Preferences.QQ_VERSION, this.qqVersion);
        hashMap.put("k_net_state", String.valueOf(NetConnInfoCenter.isWifiOrMobileConn()));
        return hashMap;
    }

    private final void c() {
        String B = ((mx0.a) qx0.a.b(mx0.a.class)).B();
        Intrinsics.checkNotNullExpressionValue(B, "getService(ILoginCoreSer\u2026:class.java).userIdString");
        this.uid = B;
        String b16 = f.b(BaseApplication.context);
        Intrinsics.checkNotNullExpressionValue(b16, "getVersionName(BaseApplication.context)");
        this.qqVersion = b16;
        this.paramInit = true;
    }

    public final void d(@NotNull String eventCode, @Nullable Map<String, String> params) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        HashMap<String, String> b16 = b();
        if (params != null) {
            b16.putAll(params);
        }
        QQBeaconReport.reportWithAppKey(a(), this.uid, eventCode, true, b16, true);
    }
}
