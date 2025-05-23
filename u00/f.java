package u00;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi.player.wrapper.g;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes36.dex */
public class f implements com.tencent.biz.pubaccount.weishi.player.wrapper.g, SDKInitListener {

    /* renamed from: d, reason: collision with root package name */
    private g.a f438011d;

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.g
    public void a(Context context) {
        x.j("WS_VIDEO_PLAYER", "[SuperPlayerSdkMgr.java][initSDK]");
        QQVideoPlaySDKManager.initSDKAsync(BaseApplication.getContext(), this);
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.g
    public boolean b(Context context) {
        return QQVideoPlaySDKManager.isSDKReady();
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.g
    public void c(Context context, g.a aVar) {
        x.j("WS_VIDEO_PLAYER", "[SuperPlayerSdkMgr.java][installPlugin]");
        this.f438011d = aVar;
        QQVideoPlaySDKManager.initSDKAsync(BaseApplication.getContext(), this);
    }

    @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
    public void onSDKInited(boolean z16) {
        g.a aVar = this.f438011d;
        if (aVar == null) {
            return;
        }
        if (z16) {
            aVar.b();
        } else {
            aVar.a(0);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.g
    public void d() {
    }
}
