package y70;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.events.QFSMixFeedSelectFeedEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSRecyclerViewScrollEvent;
import com.tencent.biz.qqcircle.immersive.views.mixfeed.QFSMixFeedRecommendView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends QFSBaseFeedChildPresenter<QQCircleDitto$StItemInfo> implements com.tencent.biz.qqcircle.immersive.scrollers.a {
    private j20.a I;

    private View g1(View view) {
        View view2;
        if (view == null || (view2 = (View) view.getParent()) == null) {
            return null;
        }
        if (view2 instanceof QFSMixFeedRecommendView) {
            return view2;
        }
        return g1(view2);
    }

    private int[] i1() {
        int[] iArr = new int[2];
        View g16 = g1(this.C);
        if (g16 != null) {
            g16.getLocationOnScreen(iArr);
        } else {
            this.C.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        this.C = view;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FeedCloudMeta$StFeed getFeed() {
        T t16 = this.f85017h;
        if (t16 != 0 && ((QQCircleDitto$StItemInfo) t16).feeds.size() != 0) {
            return ((QQCircleDitto$StItemInfo) this.f85017h).feeds.get(0);
        }
        return null;
    }

    public j20.a h1() {
        if (this.I == null) {
            this.I = (j20.a) u0(j20.a.class);
        }
        if (this.I == null) {
            QLog.w("qioc-QFSMixFeedRecommendBasePresenter", 1, "mInteract == null  | this = " + this);
        }
        return this.I;
    }

    public void j1() {
        SimpleEventBus.getInstance().dispatchEvent(new QFSMixFeedSelectFeedEvent(this.f85018i));
    }

    public void k1() {
        SimpleEventBus.getInstance().dispatchEvent(new QFSRecyclerViewScrollEvent(0.0f, i1()[1]));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSMixFeedRecommendBasePresenter";
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void a() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void pause() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void play() {
    }
}
