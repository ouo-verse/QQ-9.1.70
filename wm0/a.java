package wm0;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004\u00a8\u0006\f"}, d2 = {"Lwm0/a;", "", "", "groupId", "", "isSwitchOnDefault", "c", "isRenderTypeKuikly", "a", "b", "<init>", "()V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f445800a = new a();

    a() {
    }

    private final boolean c(String groupId, boolean isSwitchOnDefault) {
        try {
            return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(groupId, isSwitchOnDefault);
        } catch (Throwable th5) {
            QLog.e("AdConfigManager", 1, "isSwitchOn groupId:" + groupId, th5);
            return isSwitchOnDefault;
        }
    }

    public final boolean a(boolean isRenderTypeKuikly) {
        if (!c("103003", true)) {
            return false;
        }
        return isRenderTypeKuikly;
    }

    public final boolean b(boolean isRenderTypeKuikly) {
        if (!c("103064", true)) {
            return false;
        }
        return isRenderTypeKuikly;
    }
}
