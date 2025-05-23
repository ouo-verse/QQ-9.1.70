package xk;

import android.text.TextUtils;
import com.qzone.adapter.feedcomponent.FakeShuoShuoDataCacheHelper;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.process.base.a;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b implements a.InterfaceC0438a<ShuoshuoVideoInfo> {
    @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void d(com.qzone.publish.business.process.base.a aVar, ShuoshuoVideoInfo shuoshuoVideoInfo, ShuoshuoVideoInfo shuoshuoVideoInfo2) {
        String str;
        String str2 = "";
        if (shuoshuoVideoInfo == null) {
            str = "";
        } else {
            str = shuoshuoVideoInfo.mVideoPath;
        }
        if (shuoshuoVideoInfo2 != null) {
            str2 = shuoshuoVideoInfo2.mVideoPath;
        }
        QZLog.d("QCircleEntranceProcessListener", 1, "onProcessSucceed, originVideoPath: " + str + ", endVideoPath: " + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.equals(str, str2)) {
            return;
        }
        FakeShuoShuoDataCacheHelper.g(str, str2);
    }

    @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void b(com.qzone.publish.business.process.base.a aVar, ShuoshuoVideoInfo shuoshuoVideoInfo) {
    }

    @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void e(com.qzone.publish.business.process.base.a aVar, ShuoshuoVideoInfo shuoshuoVideoInfo) {
    }

    @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void c(com.qzone.publish.business.process.base.a aVar, ShuoshuoVideoInfo shuoshuoVideoInfo, ShuoshuoVideoInfo shuoshuoVideoInfo2) {
    }

    @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void f(com.qzone.publish.business.process.base.a aVar, ShuoshuoVideoInfo shuoshuoVideoInfo, int i3, String str) {
    }

    @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void a(com.qzone.publish.business.process.base.a aVar, ShuoshuoVideoInfo shuoshuoVideoInfo, ShuoshuoVideoInfo shuoshuoVideoInfo2, float f16) {
    }
}
