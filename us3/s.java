package us3;

import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterBroadcastReceiver;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007\u00a8\u0006\u0011"}, d2 = {"Lus3/s;", "", "", "c", "", "time", "e", "", "b", "Lcom/tencent/gamecenter/wadl/biz/entity/WadlParams;", "wadlParams", "", "a", "pattern", "d", "<init>", "()V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final s f440005a = new s();

    s() {
    }

    @JvmStatic
    public static final boolean c() {
        return f440005a.e(m.f439991a.i("detain_dialog_show_toady"));
    }

    private final boolean e(long time) {
        return d(time, TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
    }

    public final void a(@NotNull WadlParams wadlParams) {
        Intrinsics.checkNotNullParameter(wadlParams, "wadlParams");
        GameCenterUtil.addAppidToList(wadlParams.appId, "VM_DELAY_LIST");
        GameCenterUtil.saveAppDetail(wadlParams.appId, wadlParams.parseToJsonStr(), "VM_DELAY_APPID_DETAIL_");
        GameCenterBroadcastReceiver.c();
        m.f439991a.n("detain_dialog_show_toady", System.currentTimeMillis());
    }

    @NotNull
    public final String b() {
        int systemNetwork = NetworkUtil.getSystemNetwork(MobileQQ.sMobileQQ);
        if (systemNetwork != 1) {
            if (systemNetwork != 2) {
                if (systemNetwork != 3) {
                    if (systemNetwork == 4 || systemNetwork != 6) {
                        return "4G";
                    }
                    return "5G";
                }
                return "3G";
            }
            return "2G";
        }
        return Global.TRACKING_WIFI;
    }

    public final boolean d(long time, @NotNull String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Date date = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.SIMPLIFIED_CHINESE);
        return Intrinsics.areEqual(simpleDateFormat.format(date), simpleDateFormat.format(new Date(NetConnInfoCenter.getServerTimeMillis())));
    }
}
