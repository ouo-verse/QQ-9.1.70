package u00;

import android.content.Context;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.superplayer.api.SuperPlayerFactory;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a implements com.tencent.biz.pubaccount.weishi.player.wrapper.d {
    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.d
    public com.tencent.biz.pubaccount.weishi.player.wrapper.f a(Context context) {
        return new e(QQVideoPlaySDKManager.isSDKReady() ? SuperPlayerFactory.createPreDownloader(BaseApplication.getContext(), 112) : null);
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.d
    public com.tencent.biz.pubaccount.weishi.player.wrapper.a b() {
        return new d();
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.d
    public com.tencent.biz.pubaccount.weishi.player.wrapper.b c(Context context, com.tencent.biz.pubaccount.weishi.player.wrapper.h hVar) {
        return new c(QQVideoPlaySDKManager.isSDKReady() ? SuperPlayerFactory.createMediaPlayer(context, 112, null) : null);
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.d
    public com.tencent.biz.pubaccount.weishi.player.wrapper.h d(Context context, boolean z16) {
        return new h(QQVideoPlaySDKManager.isSDKReady() ? SuperPlayerFactory.createPlayerVideoView(context) : null);
    }
}
