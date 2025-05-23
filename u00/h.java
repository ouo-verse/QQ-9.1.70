package u00;

import android.view.View;
import com.tencent.superplayer.view.ISPlayerVideoView;

/* compiled from: P */
/* loaded from: classes36.dex */
public class h implements com.tencent.biz.pubaccount.weishi.player.wrapper.h {

    /* renamed from: a, reason: collision with root package name */
    private ISPlayerVideoView f438013a;

    public h(ISPlayerVideoView iSPlayerVideoView) {
        this.f438013a = iSPlayerVideoView;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.h
    public View a() {
        Object obj = this.f438013a;
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.h
    public void setFixedSize(int i3, int i16) {
        ISPlayerVideoView iSPlayerVideoView = this.f438013a;
        if (iSPlayerVideoView != null) {
            iSPlayerVideoView.setFixedSize(i3, i16);
        }
    }
}
