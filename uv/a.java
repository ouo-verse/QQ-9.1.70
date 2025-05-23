package uv;

import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f440088a = -1;

    /* renamed from: b, reason: collision with root package name */
    private long f440089b = 0;

    /* renamed from: c, reason: collision with root package name */
    private final int f440090c;

    public a(int i3) {
        this.f440090c = i3;
    }

    public boolean a(VideoAppInterface videoAppInterface) {
        if (this.f440088a == 1) {
            return true;
        }
        if (!b()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (videoAppInterface != null && currentTimeMillis > this.f440089b) {
                long a16 = QQAudioHelper.a();
                if (b.j(this.f440090c)) {
                    this.f440088a = videoAppInterface.I() ? 1 : 0;
                } else {
                    b.n(videoAppInterface.getApp(), this.f440090c);
                }
                QLog.w("PtuResChecker", 1, "check, packageIdx[" + this.f440090c + "], isResReady[" + this.f440088a + "], cost[" + ((QQAudioHelper.a() - a16) / 1000000) + "ms]");
                this.f440089b = currentTimeMillis + 30000;
            } else if (QLog.isDevelopLevel()) {
                QLog.w("PtuResChecker", 1, "check, call too frequency or app is null.");
            }
        } else {
            this.f440088a = 1;
        }
        if (this.f440088a == 1) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (b.j(this.f440090c)) {
            return b.h();
        }
        return ((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(b.e(this.f440090c).agentType, QQWinkConstants.ENTRY_QQ_VIDEO);
    }

    public boolean c() {
        if (this.f440088a == 1) {
            return true;
        }
        return false;
    }
}
