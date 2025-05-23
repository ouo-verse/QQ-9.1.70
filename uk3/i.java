package uk3;

import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import kotlin.Metadata;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0005\u00a8\u0006\r"}, d2 = {"Luk3/i;", "", "", "mmkvKey", "logTag", "", "a", "b", "d", "c", "e", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f439124a = new i();

    i() {
    }

    private final boolean a(String mmkvKey, String logTag) {
        String b16 = b();
        if (AppSetting.isPublicVersion()) {
            return false;
        }
        boolean a16 = j74.a.f409621a.a(b16, mmkvKey, false);
        if (a16) {
            QLog.e("ZPlanDebugAccessible", 2, logTag + " is true");
        }
        return a16;
    }

    private final String b() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentUin();
    }

    public final boolean c() {
        return a("zplan_aigc_20_force_open", "isForceAIGC20Accessible");
    }

    public final boolean d() {
        return a("zplan_force_open", "isForceAccessible");
    }

    public final boolean e() {
        return a("zplan_avatar_upload", "isUploadAvatarChecked");
    }
}
