package vm;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ&\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004\u00a8\u0006\n"}, d2 = {"Lvm/a;", "", "", "uin", "", "data", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f441845a = new a();

    a() {
    }

    public final void a(String uin, Map<String, String> data) {
        if (!(uin == null || uin.length() == 0) && data != null) {
            String str = data.get("subtype");
            String str2 = data.get("busidata");
            RFWLog.i("QZoneSilentPushManager", RFWLog.USR, "receive a silent push, pushSubType: " + str + ", pushInfo: " + str2);
            if (Intrinsics.areEqual(str, "1")) {
                xj.a.f448035a.b(str2);
                return;
            }
            return;
        }
        RFWLog.e("QZoneSilentPushManager", RFWLog.USR, "handleSilentPush fail: uin is not match, data: " + data);
    }
}
