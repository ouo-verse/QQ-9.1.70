package q80;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.bean.JumpInfo;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchGoodsCardData;
import com.tencent.biz.qqcircle.immersive.bean.UIInfo;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {
    private View I;
    private SquareImageView J;
    private TextView K;
    private TextView L;
    private TextView M;
    private p70.i N;
    private volatile QFSSearchGoodsCardData P;
    private String Q;

    /* JADX WARN: Multi-variable type inference failed */
    private void g1() {
        if (((FeedCloudMeta$StFeed) this.f85017h).has() && this.P != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("xsj_feed_id", ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_GOODS_ID, this.P.getBasic().getAdId());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_GOODS_NAME, this.P.getSearchAd().getUi().getSmallCardProduct().getTitle());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_GOODS_CATEGORY, Integer.valueOf(this.P.getBasic().getAdRecallChannel()));
            ua0.i.k(this.I, QCircleDaTongConstant.ElementId.EM_XSJ_SEARCH_PAGE_SHOPPING_GUIDE_PANEL, hashMap, this.P.hashCode());
        }
    }

    private static String i1(Iterable<JumpInfo> iterable) {
        String str = "";
        if (iterable == null) {
            return "";
        }
        for (JumpInfo jumpInfo : iterable) {
            String url = jumpInfo.getUrl();
            if (!TextUtils.isEmpty(url)) {
                int jumpType = jumpInfo.getJumpType();
                if (jumpType != 2) {
                    if (jumpType == 30) {
                        return url;
                    }
                } else {
                    str = url;
                }
            }
        }
        return str;
    }

    private void j1(String str) {
        if (!TextUtils.isEmpty(str) && this.J != null) {
            String uniKeyFromUrl = QCircleFeedPicLoader.getUniKeyFromUrl(str);
            if (TextUtils.equals(uniKeyFromUrl, (String) this.J.getTag())) {
                return;
            }
            this.J.setTag(uniKeyFromUrl);
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(this.J).setUrl(str).setLoadingDrawableColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_tag_selected)));
        }
    }

    private void k1(String str) {
        if (TextUtils.isEmpty(str)) {
            this.M.setVisibility(8);
        } else {
            this.M.setVisibility(0);
            this.M.setText(str);
        }
    }

    private void l1(UIInfo uIInfo) {
        this.I.setVisibility(0);
        j1(uIInfo.getPicUrl());
        this.K.setText(uIInfo.getButtonText());
        this.L.setText(uIInfo.getTitle());
        k1(uIInfo.getTag().getText());
        this.Q = i1(uIInfo.getJumpInfoArray());
        g1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        View findViewById = view.findViewById(R.id.f52642ac);
        this.I = findViewById;
        this.J = (SquareImageView) findViewById.findViewById(R.id.f52652ad);
        this.K = (TextView) this.I.findViewById(R.id.f52672af);
        this.L = (TextView) this.I.findViewById(R.id.f52682ag);
        this.M = (TextView) this.I.findViewById(R.id.f52662ae);
        this.I.setOnClickListener(this);
        this.M.setBackground(ie0.a.f().k(m0(), R.color.qui_common_fill_standard_primary, 2.0f, 1000));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.I.setVisibility(8);
        if (feedCloudMeta$StFeed == null) {
            QLog.w("QFSSearchFeedResultGoodsCardPresenter", 1, "[onBindData] data should not be null.");
            return;
        }
        if (this.N == null) {
            this.N = (p70.i) A0(p70.i.class);
        }
        this.P = this.N.d2(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
        if (this.P != null && this.P.getSearchAd().getUi().getUiType() == 500) {
            UIInfo smallCardProduct = this.P.getSearchAd().getUi().getSmallCardProduct();
            if (!TextUtils.isEmpty(smallCardProduct.getButtonText()) && !TextUtils.isEmpty(smallCardProduct.getTitle())) {
                QLog.d("QFSSearchFeedResultGoodsCardPresenter", 1, "[onBindData] buttonText: " + smallCardProduct.getButtonText() + " title: " + smallCardProduct.getTitle());
                l1(smallCardProduct);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.I && !TextUtils.isEmpty(this.Q)) {
            QCircleSchemeLauncher.f(m0(), this.Q);
            EventCollector.getInstance().onViewClicked(this.I);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSSearchFeedResultGoodsCardPresenter";
    }
}
