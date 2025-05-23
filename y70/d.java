package y70;

import android.util.Size;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QFSVipNickNameAndIconView;
import com.tencent.mobileqq.R;
import feedcloud.FeedCloudMeta$StFeed;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends a {
    private QCircleAvatarView J;
    private QFSVipNickNameAndIconView K;
    private TextView L;
    private Size M;

    @Override // y70.a, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull @NotNull View view) {
        super.N0(view);
        this.J = (QCircleAvatarView) view.findViewById(R.id.f516628p);
        this.K = (QFSVipNickNameAndIconView) view.findViewById(R.id.f517028t);
        this.L = (TextView) view.findViewById(R.id.f57272mv);
        this.M = n.a(view.getContext(), R.dimen.d4p);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public void L0(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, int i3) {
        super.L0(qQCircleDitto$StItemInfo, i3);
        if (qQCircleDitto$StItemInfo == null && getFeed() == null) {
            return;
        }
        FeedCloudMeta$StFeed feed = getFeed();
        this.J.setUser(feed.poster, this.M);
        this.L.setText(r.f(feed.visitorInfo.viewCount.get()));
        this.K.setUser(feed.poster);
        this.K.setReportData(new QFSVipNickNameAndIconView.b().g(feed).h(89));
        this.K.w0(feed.poster.nick.get());
    }

    @Override // y70.a, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSMixFeedRecommendTopPresenter";
    }
}
