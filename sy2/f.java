package sy2;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.util.privacy.PackageInstallMonitorKt;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sy2.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ9\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0006\"\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lsy2/f;", "Lsy2/e;", "Landroid/content/Context;", "context", "", "methodName", "", "args", "", "a", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/Object;", "<init>", "()V", "QQCommon_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class f implements e {
    @Override // sy2.e
    @Nullable
    public Object a(@NotNull Context context, @NotNull String methodName, @NotNull String... args) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(args, "args");
        QLog.d("IJSPackageInfoHandler", 1, "IsAppInstallHandler handleJsPackageInfoRequest");
        if (TextUtils.equals(methodName, "isAppInstalledAuthorized")) {
            if (args.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                BusinessData b16 = b(args[0]);
                return Boolean.valueOf(PackageInstallMonitorKt.f(context, b16.getPackageName(), b16.getBusiness()));
            }
            return null;
        }
        return null;
    }

    @NotNull
    public BusinessData b(@Nullable String str) {
        return e.a.a(this, str);
    }
}
