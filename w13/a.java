package w13;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vas.IConfigProxy;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.mobileqq.vas.VipNtMMKV;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bR\u0016\u0010\u000f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lw13/a;", "", "", "d", h.F, "", "g", "e", "f", "", "a", "", "c", "b", "I", "praiseId", "likeAreaId", "Z", "isEnableSwitch", "isEnableConfig", "isEnd", "Ljava/lang/String;", "url", "curUin", "<init>", "()V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f444413a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int praiseId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int likeAreaId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isEnableSwitch;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean isEnableConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean isEnd;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String url;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String curUin;

    static {
        String str;
        a aVar = new a();
        f444413a = aVar;
        isEnableConfig = isEnableSwitch;
        String str2 = "";
        url = "";
        curUin = "";
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str != null) {
            str2 = str;
        }
        curUin = str2;
        aVar.d();
    }

    a() {
    }

    private final void d() {
        boolean z16;
        IConfigProxy iConfigProxy = VasNtToggle.VAS_LUCKY_BAG_CONFIG_SWITCH;
        boolean z17 = false;
        boolean isEnable = iConfigProxy.isEnable(false);
        isEnableSwitch = isEnable;
        if (isEnable) {
            JSONObject json = iConfigProxy.getJson();
            long optLong = json.optLong("start_time");
            long optLong2 = json.optLong("end_time");
            praiseId = json.optInt("praise_id");
            likeAreaId = json.optInt("like_area_id");
            String optString = json.optString("end_url");
            Intrinsics.checkNotNullExpressionValue(optString, "resultJson.optString(\"end_url\")");
            url = optString;
            long serverTime = NetConnInfoCenter.getServerTime();
            if (serverTime >= optLong && serverTime <= optLong2) {
                z16 = true;
            } else {
                z16 = false;
            }
            isEnableConfig = z16;
            if (serverTime > optLong2) {
                z17 = true;
            }
            isEnd = z17;
        }
    }

    @NotNull
    public final String a() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return "";
        }
        if (!peekAppRuntime.getCurrentAccountUin().equals(curUin)) {
            d();
        }
        return url;
    }

    public final int b() {
        return likeAreaId;
    }

    public final int c() {
        return praiseId;
    }

    public final boolean e() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        if (!peekAppRuntime.getCurrentAccountUin().equals(curUin)) {
            d();
        }
        return isEnableConfig;
    }

    public final boolean f() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        if (!peekAppRuntime.getCurrentAccountUin().equals(curUin)) {
            d();
        }
        return isEnd;
    }

    public final boolean g() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        if (!peekAppRuntime.getCurrentAccountUin().equals(curUin)) {
            d();
        }
        if (!isEnableConfig || VipNtMMKV.INSTANCE.getCommon(peekAppRuntime.getCurrentAccountUin()).decodeInt("vas_profile_lucky_bag_first_show_window", 0) >= 2) {
            return false;
        }
        return true;
    }

    public final void h() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        VipNtMMKV.Companion companion = VipNtMMKV.INSTANCE;
        companion.getCommon(peekAppRuntime.getCurrentAccountUin()).encodeInt("vas_profile_lucky_bag_first_show_window", companion.getCommon(peekAppRuntime.getCurrentAccountUin()).decodeInt("vas_profile_lucky_bag_first_show_window", 0) + 1);
    }
}
