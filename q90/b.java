package q90;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.beans.QCircleAlbumBean;
import com.tencent.biz.qqcircle.beans.QCircleFeedAlbumInfo;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$FeedAlbumInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StCollectionDetail;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001@B\u000f\u0012\u0006\u0010<\u001a\u00020\u0010\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0016\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0015R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\"R\"\u0010/\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00107\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010;\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010*\u001a\u0004\b9\u0010,\"\u0004\b:\u0010.\u00a8\u0006A"}, d2 = {"Lq90/b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Landroid/graphics/drawable/Drawable;", "o", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "Lfeedcloud/FeedCloudRead$StCollectionDetail;", "detail", "", com.tencent.luggage.wxa.c8.c.G, "l", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroid/widget/LinearLayout;", "E", "Landroid/widget/LinearLayout;", "itemLayout", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "coverIv", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "G", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "contentTv", "H", "moreHintLl", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "albumIv", "J", "Lfeedcloud/FeedCloudRead$StCollectionDetail;", "K", "", "L", "Ljava/lang/String;", "getAlbumScheme", "()Ljava/lang/String;", "r", "(Ljava/lang/String;)V", "albumScheme", "Lcom/tencent/biz/qqcircle/immersive/bean/QFSSearchInfo;", "M", "Lcom/tencent/biz/qqcircle/immersive/bean/QFSSearchInfo;", "getSearchInfo", "()Lcom/tencent/biz/qqcircle/immersive/bean/QFSSearchInfo;", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/biz/qqcircle/immersive/bean/QFSSearchInfo;)V", "searchInfo", "N", "getAlbumId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "albumId", "itemView", "<init>", "(Landroid/view/View;)V", "P", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b extends RecyclerView.ViewHolder implements View.OnClickListener {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout itemLayout;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final RoundCornerImageView coverIv;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final QCircleAsyncTextView contentTv;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout moreHintLl;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ImageView albumIv;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private FeedCloudRead$StCollectionDetail detail;

    /* renamed from: K, reason: from kotlin metadata */
    private int pos;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private String albumScheme;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private QFSSearchInfo searchInfo;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private String albumId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.albumScheme = "";
        this.albumId = "";
        View findViewById = itemView.findViewById(R.id.f54182ei);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026arch_result_episode_item)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.itemLayout = linearLayout;
        View findViewById2 = itemView.findViewById(R.id.f54192ej);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026esult_episode_item_cover)");
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) findViewById2;
        this.coverIv = roundCornerImageView;
        View findViewById3 = itemView.findViewById(R.id.f54222em);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026result_episode_item_text)");
        QCircleAsyncTextView qCircleAsyncTextView = (QCircleAsyncTextView) findViewById3;
        this.contentTv = qCircleAsyncTextView;
        View findViewById4 = itemView.findViewById(R.id.f54202ek);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.\u2026result_episode_item_more)");
        LinearLayout linearLayout2 = (LinearLayout) findViewById4;
        this.moreHintLl = linearLayout2;
        View findViewById5 = itemView.findViewById(R.id.f54212el);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.\u2026lt_episode_item_more_img)");
        this.albumIv = (ImageView) findViewById5;
        qCircleAsyncTextView.setSpecialClickAreaColor(QFSQUIUtilsKt.d(itemView.getContext(), R.color.qui_common_text_primary), true);
        roundCornerImageView.setCorner(ViewUtils.dip2px(8.0f));
        linearLayout.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
    }

    private final void m() {
        String str;
        int i3;
        Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, this.albumId);
        QFSSearchInfo qFSSearchInfo = this.searchInfo;
        if (qFSSearchInfo != null) {
            str = qFSSearchInfo.f();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        map.put("xsj_query_text", str);
        QFSSearchInfo qFSSearchInfo2 = this.searchInfo;
        if (qFSSearchInfo2 != null) {
            i3 = qFSSearchInfo2.e();
        } else {
            i3 = 0;
        }
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_QUERY_SOURCE, Integer.valueOf(i3));
        VideoReport.setElementId(this.itemLayout, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_CHOICE_LIST);
        VideoReport.setElementReuseIdentifier(this.itemLayout, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_CHOICE_LIST + this.albumId);
        VideoReport.setElementParams(this.itemLayout, map);
        VideoReport.setElementExposePolicy(this.itemLayout, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.itemLayout, ClickPolicy.REPORT_ALL);
    }

    private final void n(FeedCloudMeta$StFeed feed) {
        FeedCloudMeta$FeedAlbumInfo feedCloudMeta$FeedAlbumInfo;
        int i3;
        PBUInt32Field pBUInt32Field;
        String str = feed.content.get();
        if (feed.album_infos.get() != null && feed.album_infos.get().size() > 0) {
            feedCloudMeta$FeedAlbumInfo = feed.album_infos.get().get(0);
        } else {
            feedCloudMeta$FeedAlbumInfo = null;
        }
        if (feedCloudMeta$FeedAlbumInfo != null && (pBUInt32Field = feedCloudMeta$FeedAlbumInfo.feed_serial_number) != null) {
            i3 = pBUInt32Field.get();
        } else {
            i3 = this.pos;
        }
        String string = this.itemView.getContext().getResources().getString(R.string.f195764fh, Integer.valueOf(i3));
        Intrinsics.checkNotNullExpressionValue(string, "itemView.context.resourc\u2026tem_empty_content, index)");
        if (!TextUtils.isEmpty(str)) {
            string = string + "\uff1a" + str;
        }
        this.contentTv.setText((CharSequence) string, false);
    }

    private final Drawable o() {
        Drawable o16 = ie0.a.f().o(this.itemView.getContext(), R.drawable.qui_video_collection, R.color.qui_common_text_secondary, 1000);
        Intrinsics.checkNotNullExpressionValue(o16, "getInstances().getQuiTok\u2026Constants.SKIN,\n        )");
        return o16;
    }

    private final void p() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
        FeedCloudRead$StCollectionDetail feedCloudRead$StCollectionDetail = this.detail;
        if (feedCloudRead$StCollectionDetail != null && (feedCloudMeta$StFeed2 = feedCloudRead$StCollectionDetail.feed) != null) {
            feedCloudMeta$StFeed = feedCloudMeta$StFeed2.get();
        } else {
            feedCloudMeta$StFeed = null;
        }
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(feedCloudMeta$StFeed.album_infos.get(), "feed.album_infos.get()");
        if (!r1.isEmpty()) {
            FeedCloudMeta$FeedAlbumInfo feedCloudMeta$FeedAlbumInfo = feedCloudMeta$StFeed.album_infos.get().get(0);
            Intrinsics.checkNotNullExpressionValue(feedCloudMeta$FeedAlbumInfo, "feed.album_infos.get()[0]");
            QCircleFeedAlbumInfo qCircleFeedAlbumInfo = new QCircleFeedAlbumInfo(feedCloudMeta$FeedAlbumInfo.album.f398441id.get());
            qCircleFeedAlbumInfo.isDraft = false;
            QCircleAlbumBean qCircleAlbumBean = new QCircleAlbumBean(qCircleFeedAlbumInfo);
            qCircleAlbumBean.setNeedShowAlbumPanel(false);
            qCircleAlbumBean.setSourceType(52);
            qCircleAlbumBean.setDataPosInList(this.pos);
            qCircleAlbumBean.setFeed(feedCloudMeta$StFeed);
            qCircleAlbumBean.setPreRenderType(10011);
            com.tencent.biz.qqcircle.launcher.c.u(this.itemView.getContext(), qCircleAlbumBean);
        }
    }

    public final void l(@NotNull FeedCloudRead$StCollectionDetail detail, int pos) {
        Intrinsics.checkNotNullParameter(detail, "detail");
        this.detail = detail;
        this.pos = pos;
        if (TextUtils.isEmpty(detail.feed.f398449id.get())) {
            this.coverIv.setVisibility(8);
            this.contentTv.setVisibility(8);
            this.moreHintLl.setVisibility(0);
            this.albumIv.setImageDrawable(o());
            return;
        }
        this.coverIv.setVisibility(0);
        this.contentTv.setVisibility(0);
        this.moreHintLl.setVisibility(8);
        FeedCloudMeta$StFeed feed = detail.feed.get();
        Intrinsics.checkNotNullExpressionValue(feed, "feed");
        n(feed);
        Option targetView = Option.obtain().setUrl(feed.cover.picUrl.get()).setTargetView(this.coverIv);
        targetView.setSupportRecycler(true);
        QCircleFeedPicLoader.g().loadImage(targetView);
        m();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.f54182ei) {
            p();
        } else if (num != null && num.intValue() == R.id.f54202ek) {
            QCircleSchemeLauncher.f(this.itemView.getContext(), this.albumScheme);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void q(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final void r(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumScheme = str;
    }

    public final void s(@Nullable QFSSearchInfo qFSSearchInfo) {
        this.searchInfo = qFSSearchInfo;
    }
}
