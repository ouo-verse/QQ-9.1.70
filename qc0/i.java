package qc0;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.util.Consumer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.events.QFSPersonalEmptyProductPymkRefreshEvent;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StUserRecomInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qc0.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 !2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001d\u00a8\u0006#"}, d2 = {"Lqc0/i;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "Lfeedcloud/FeedCloudMeta$StUserRecomInfo;", "stUserRecomInfo", "u", "Lqc0/n$c;", "mListener", "v", "", com.tencent.luggage.wxa.c8.c.G, "w", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "mIvAvatar", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "mTvSee", "G", "mCloseButton", "H", "Lqc0/n$c;", "I", "mPos", "<init>", "(Landroid/view/View;)V", "J", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class i extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView mIvAvatar;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mTvSee;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView mCloseButton;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private n.c mListener;

    /* renamed from: I, reason: from kotlin metadata */
    private int mPos;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        r(itemView);
    }

    private final void o() {
        if (this.itemView.getContext() instanceof Activity) {
            com.tencent.biz.qqcircle.helpers.k kVar = com.tencent.biz.qqcircle.helpers.k.f84627a;
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            com.tencent.biz.qqcircle.helpers.k.k(kVar, (Activity) context, false, new Consumer() { // from class: qc0.h
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    i.p((Boolean) obj);
                }
            }, 2, null);
        } else {
            RFWLog.e("QFSPYMKRecommendListContratItemViewHolder", RFWLog.USR, "[handleClickSee] itemView.context is not Activity. itemView=" + this.itemView);
        }
        com.tencent.biz.qqcircle.helpers.k kVar2 = com.tencent.biz.qqcircle.helpers.k.f84627a;
        TextView textView = this.mTvSee;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvSee");
            textView = null;
        }
        kVar2.e(textView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Boolean allowed) {
        Intrinsics.checkNotNullExpressionValue(allowed, "allowed");
        if (allowed.booleanValue()) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSPersonalEmptyProductPymkRefreshEvent());
        }
    }

    private final void q() {
        uq3.k.a().j("qfs_need_show_personal_contract_guide", false);
        com.tencent.biz.qqcircle.helpers.k kVar = com.tencent.biz.qqcircle.helpers.k.f84627a;
        ImageView imageView = this.mCloseButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseButton");
            imageView = null;
        }
        kVar.e(imageView, false);
    }

    private final void r(View itemView) {
        View findViewById = itemView.findViewById(R.id.f165909du3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.iv_avatar)");
        this.mIvAvatar = (ImageView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.f111026k4);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.tv_see)");
        this.mTvSee = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.f32390tm);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026cle_recommend_item_close)");
        this.mCloseButton = (ImageView) findViewById3;
        Option obtain = Option.obtain();
        ImageView imageView = this.mIvAvatar;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvAvatar");
            imageView = null;
        }
        QCircleFeedPicLoader.g().loadImage(obtain.setTargetView(imageView).setUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_skin_icon_msgpage_services_address_book")));
        ImageView imageView2 = this.mCloseButton;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseButton");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: qc0.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.s(i.this, view);
            }
        });
        TextView textView2 = this.mTvSee;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvSee");
        } else {
            textView = textView2;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: qc0.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.t(i.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q();
        n.c cVar = this$0.mListener;
        if (cVar != null) {
            cVar.onClick(this$0.mPos);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o();
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void u(@NotNull FeedCloudMeta$StUserRecomInfo stUserRecomInfo) {
        Intrinsics.checkNotNullParameter(stUserRecomInfo, "stUserRecomInfo");
        com.tencent.biz.qqcircle.helpers.k kVar = com.tencent.biz.qqcircle.helpers.k.f84627a;
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        kVar.d(itemView);
    }

    public final void v(@Nullable n.c mListener) {
        this.mListener = mListener;
    }

    public final void w(int pos) {
        this.mPos = pos;
    }
}
