package qz;

import UserGrowth.stDrama;
import UserGrowth.stDramaFeed;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import mz.d;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class a extends com.tencent.biz.pubaccount.weishi.baseui.b<d> {
    protected stDrama C;
    protected stDramaFeed D;
    protected stSimpleMetaFeed E;

    public a(Context context) {
        super(context);
    }

    private stDrama u() {
        d c16 = c();
        if (c16 != null) {
            return c16.e();
        }
        return null;
    }

    private stDramaFeed v() {
        d c16 = c();
        if (c16 != null) {
            return c16.h();
        }
        return null;
    }

    private stSimpleMetaFeed w() {
        stDramaFeed v3 = v();
        if (v3 != null) {
            return v3.feed;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    public void g() {
        this.C = u();
        this.D = v();
        this.E = w();
    }

    public abstract void x(int i3);
}
