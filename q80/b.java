package q80;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ad.tangram.views.feedback.AdFeedbackParams;
import com.tencent.biz.qqcircle.immersive.events.QFSSearchAdFeedbackEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.ad.u;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {
    private LinearLayout I;
    private int J;
    private GdtAd K;
    private final AdFeedbackDialogFragment.Listener L = new AdFeedbackDialogFragment.Listener() { // from class: q80.a
        @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
        public final void onResult(AdFeedbackDialogFragment.Result result) {
            b.this.h1(result);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h1(AdFeedbackDialogFragment.Result result) {
        QLog.e("QFSSearchFeedResultAdFeedbackPresenter", 1, String.valueOf(result.result.getErrorCode()));
        if (result.action != 3) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSSearchAdFeedbackEvent(this.J));
    }

    private void j1(View view) {
        AdFeedbackParams adFeedbackParams = new AdFeedbackParams();
        adFeedbackParams.activity = new WeakReference<>((Activity) view.getContext());
        adFeedbackParams.listener = new WeakReference<>(this.L);
        adFeedbackParams.isDarkMode = QCircleSkinHelper.getInstance().isDarkMode();
        adFeedbackParams.f61346ad = this.K;
        adFeedbackParams.styleId = 0;
        if (view.getContext().getResources().getConfiguration().orientation == 2) {
            adFeedbackParams.styleId = 1;
        }
        QLog.i("QFSSearchFeedResultAdFeedbackPresenter", 1, "AdFeedbackDialogFragment.start");
        try {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).showFeedbackDialogFragment(adFeedbackParams);
        } catch (Throwable th5) {
            QLog.e("QFSSearchFeedResultAdFeedbackPresenter", 1, "showFeedbackDialog", th5);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.f81034d3);
        this.I = linearLayout;
        linearLayout.setOnClickListener(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.I.setVisibility(8);
        if (feedCloudMeta$StFeed != null && this.E != null) {
            this.J = i3;
            if (!p.w(feedCloudMeta$StFeed)) {
                return;
            }
            this.I.setVisibility(0);
            this.K = new GdtAd(u.e(this.E));
            return;
        }
        QLog.w("QFSSearchFeedResultAdFeedbackPresenter", 1, "[onBindData] data should not be null.");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QLog.i("QFSSearchFeedResultAdFeedbackPresenter", 1, NodeProps.ON_CLICK);
        if (view.getContext() != null && this.K != null) {
            j1(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSSearchFeedResultAdFeedbackPresenter";
    }
}
