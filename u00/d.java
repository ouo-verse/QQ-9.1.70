package u00;

import com.tencent.biz.pubaccount.weishi.player.i;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d extends com.tencent.biz.pubaccount.weishi.player.wrapper.a {
    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public SuperPlayerVideoInfo c() {
        return SuperPlayerFactory.createVideoInfoForUrl(new String[]{this.f81192a}, g(this.f81194c), this.f81195d, i.q(this.f81192a, this.f81196e));
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public SuperPlayerVideoInfo d() {
        return SuperPlayerFactory.createVideoInfoForUrl(new String[]{this.f81192a}, g(this.f81194c), this.f81195d, i.q(this.f81192a, this.f81196e));
    }

    public int g(int i3) {
        if (i3 == 101) {
            return 101;
        }
        return 103;
    }
}
