package zu1;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.lang.reflect.Field;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0002H\u0007J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002\u00a8\u0006\f"}, d2 = {"Lzu1/a;", "", "", "d", "c", "e", "b", "Landroid/content/Context;", "context", "a", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f453420a = new a();

    a() {
    }

    private final String a(Context context) {
        if (context != null) {
            Object systemService = context.getSystemService("wifi");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            try {
                WifiInfo connectionInfo = LocationMonitor.getConnectionInfo((WifiManager) systemService);
                if (connectionInfo != null) {
                    String macAddress = NetworkMonitor.getMacAddress(connectionInfo);
                    Intrinsics.checkNotNullExpressionValue(macAddress, "info.macAddress");
                    return macAddress;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return "";
    }

    @JvmStatic
    @NotNull
    public static final String b() {
        Object m476constructorimpl;
        boolean equals;
        String a16 = f453420a.a(MobileQQ.sMobileQQ);
        try {
            Result.Companion companion = Result.INSTANCE;
            WifiInfo wifiInfo = (WifiInfo) WifiInfo.class.newInstance();
            Field field = wifiInfo.getClass().getField("DEFAULT_MAC_ADDRESS");
            field.setAccessible(true);
            Object obj = field.get(wifiInfo);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            m476constructorimpl = Result.m476constructorimpl((String) obj);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = "";
        }
        String str = (String) m476constructorimpl;
        if (!TextUtils.isEmpty(str) && Intrinsics.areEqual(str, a16)) {
            try {
                ArrayList<NetworkInterface> list = Collections.list(NetworkMonitor.getNetworkInterfaces());
                Intrinsics.checkNotNullExpressionValue(list, "list(NetworkInterface.getNetworkInterfaces())");
                for (NetworkInterface networkInterface : list) {
                    equals = StringsKt__StringsJVMKt.equals(networkInterface.getName(), "wlan0", true);
                    if (equals) {
                        byte[] hardwareAddress = NetworkMonitor.getHardwareAddress(networkInterface);
                        if (hardwareAddress == null) {
                            return "";
                        }
                        StringBuilder sb5 = new StringBuilder();
                        for (byte b16 : hardwareAddress) {
                            sb5.append(Integer.toHexString((byte) (b16 & (-1))) + ':');
                        }
                        if (sb5.length() > 0) {
                            sb5.deleteCharAt(sb5.length() - 1);
                        }
                        String sb6 = sb5.toString();
                        Intrinsics.checkNotNullExpressionValue(sb6, "res1.toString()");
                        return sb6;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return a16;
    }

    @JvmStatic
    @NotNull
    public static final String c() {
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        return MANUFACTURER;
    }

    @JvmStatic
    @NotNull
    public static final String d() {
        String MODEL = DeviceInfoMonitor.getModel();
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        return MODEL;
    }

    @JvmStatic
    @NotNull
    public static final String e() {
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        return RELEASE;
    }
}
