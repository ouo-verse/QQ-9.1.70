package zy3;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.HexUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.manager.WtloginManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lmqq/app/AppRuntime;", "a", "", "c", "", "b", "qqprotect-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    @Nullable
    public static final AppRuntime a() {
        AppRuntime appRuntime;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            appRuntime = peekAppRuntime.getAppRuntime("modular_web");
        } else {
            appRuntime = null;
        }
        if (!(appRuntime instanceof AppInterface)) {
            return null;
        }
        return (AppInterface) appRuntime;
    }

    @NotNull
    public static final String b() {
        WtloginManager wtloginManager;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return "";
        }
        Manager manager = peekAppRuntime.getManager(1);
        if (manager instanceof WtloginManager) {
            wtloginManager = (WtloginManager) manager;
        } else {
            wtloginManager = null;
        }
        if (wtloginManager == null || wtloginManager.getGUID() == null) {
            return "";
        }
        String bytes2HexStr = HexUtil.bytes2HexStr(wtloginManager.getGUID());
        Intrinsics.checkNotNullExpressionValue(bytes2HexStr, "bytes2HexStr(manager.guid)");
        return bytes2HexStr;
    }

    public static final long c() {
        return NetConnInfoCenter.getServerTime() * 1000;
    }
}
