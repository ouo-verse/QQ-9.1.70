package q80;

import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.ad.u;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.widgets.QFSPressEffectTextView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {
    private View I;
    private SquareImageView J;
    private TextView K;
    private TextView L;
    private QFSPressEffectTextView M;
    private GdtAd N;

    private void h1(View view, int i3) {
        p.E(this.E, view, this.f85018i, i3);
    }

    private void i1(String str) {
        float measureText = new TextPaint().measureText(str);
        ViewGroup.LayoutParams layoutParams = this.M.getLayoutParams();
        if (measureText > 44.0f) {
            layoutParams.width = ViewUtils.dip2px(77.0f);
        } else {
            layoutParams.width = ViewUtils.dip2px(64.0f);
        }
        this.M.setLayoutParams(layoutParams);
        this.M.setText(str);
    }

    private void j1(String str) {
        if (!TextUtils.isEmpty(str) && this.J != null) {
            String uniKeyFromUrl = QCircleFeedPicLoader.getUniKeyFromUrl(str);
            if (TextUtils.equals(uniKeyFromUrl, (String) this.J.getTag())) {
                return;
            }
            this.J.setTag(uniKeyFromUrl);
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(this.J).setUrl(str).setRequestWidth(this.J.getWidth()).setRequestHeight(this.J.getHeight()).setLoadingDrawableColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_tag_selected)));
        }
    }

    private void k1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Size r16 = ad.r(feedCloudMeta$StFeed, this.C, com.tencent.biz.qqcircle.immersive.utils.a.g());
        ViewGroup.LayoutParams layoutParams = this.I.getLayoutParams();
        layoutParams.width = r16.getWidth();
        this.I.setLayoutParams(layoutParams);
    }

    private void updateView() {
        if (this.N.info != null) {
            this.I.setVisibility(0);
            j1(this.N.info.display_info.advertiser_info.corporate_logo.get());
            this.K.setText(this.N.info.display_info.basic_info.txt.get());
            this.L.setText(this.N.info.display_info.advertiser_info.corporate_image_name.get());
            for (int i3 = 0; i3 < this.N.info.display_info.button_info.get().size(); i3++) {
                qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo buttonInfo = this.N.info.display_info.button_info.get(i3);
                if (buttonInfo.pos.get() == 2 && !TextUtils.isEmpty(buttonInfo.txt.get())) {
                    i1(buttonInfo.txt.get());
                }
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        View findViewById = view.findViewById(R.id.f52602a9);
        this.I = findViewById;
        this.J = (SquareImageView) findViewById.findViewById(R.id.f52612a_);
        this.K = (TextView) this.I.findViewById(R.id.f52622aa);
        this.L = (TextView) this.I.findViewById(R.id.f52632ab);
        this.M = (QFSPressEffectTextView) this.I.findViewById(R.id.f52592a8);
        this.J.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.M.setOnClickListener(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        k1(feedCloudMeta$StFeed);
        this.I.setVisibility(8);
        if (feedCloudMeta$StFeed != null && this.E != null) {
            if (!p.w(feedCloudMeta$StFeed)) {
                return;
            }
            this.N = new GdtAd(u.e(this.E));
            updateView();
            return;
        }
        QLog.w("QFSSearchFeedResultDownloadCardPresenter", 1, "[onBindData] data should not be null.");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.J) {
            i3 = 43;
        } else if (view == this.K) {
            i3 = 45;
        } else if (view == this.L) {
            i3 = 44;
        } else if (view == this.M) {
            i3 = 46;
        } else {
            i3 = 1000;
        }
        h1(view, i3);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSSearchFeedResultDownloadCardPresenter";
    }
}
