package rn;

import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import common.config.service.QzoneConfig;
import qzonemoment.QZMomentMeta$StFeed;

/* compiled from: P */
/* loaded from: classes36.dex */
public class g {
    private static boolean a() {
        String model = DeviceInfoMonitor.getModel();
        String b16 = b();
        if (TextUtils.isEmpty(b16)) {
            return false;
        }
        String[] split = b16.split(",");
        if (split.length < 1) {
            return false;
        }
        for (String str : split) {
            if (TextUtils.equals(model, str)) {
                return true;
            }
        }
        return false;
    }

    private static String b() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_MOMENT_DISABLE_MODEL, QzoneConfig.DEFAULT_KEY_MOMENT_DISABLE_MODEL);
    }

    public static boolean d() {
        if (pl.a.f426446a.y() || a()) {
            return false;
        }
        if (e()) {
            return true;
        }
        gd.a aVar = gd.a.f401926a;
        return aVar.b() && aVar.c("KEY_OPEN_QZMOMENT_ENTRANCE", false);
    }

    private static boolean e() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QZONE_MOMENT_ENTRANCE_SWITCH, 1) == 1;
    }

    public static QZMomentMeta$StFeed c(QZMomentMeta$StFeed qZMomentMeta$StFeed) {
        if (qZMomentMeta$StFeed == null) {
            return null;
        }
        QZMomentMeta$StFeed qZMomentMeta$StFeed2 = new QZMomentMeta$StFeed();
        qZMomentMeta$StFeed2.f430362id.set(qZMomentMeta$StFeed.f430362id.get());
        qZMomentMeta$StFeed2.createTime.set(qZMomentMeta$StFeed.createTime.get());
        qZMomentMeta$StFeed2.poster.set(qZMomentMeta$StFeed.poster.get());
        return qZMomentMeta$StFeed2;
    }
}
