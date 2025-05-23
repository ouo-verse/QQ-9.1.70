package tg;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.ui.common.SuperLikeView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellIntimateSpaceInfo;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.ui.SuperLikeAnimator$Event;
import com.qzone.util.l;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nk.as;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 62\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00017B\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J!\u0010\u0010\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0016\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\fH\u0002J\u0019\u0010\u0018\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\u000eH\u0014J\b\u0010\u001b\u001a\u00020\fH\u0014J\b\u0010\u001c\u001a\u00020\u0014H\u0014J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0012H\u0014J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0014J\u0012\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0003H\u0016R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00100\u00a8\u00068"}, d2 = {"Ltg/g;", "Lvg/a;", "Landroidx/lifecycle/Observer;", "Laf/c;", "", ExifInterface.LATITUDE_SOUTH, "Y", BdhLogUtil.LogTag.Tag_Req, "M", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "a0", "", "spaceType", "", "spaceId", "O", "(Ljava/lang/Integer;Ljava/lang/String;)I", "Landroid/view/View;", "view", "", "isEnable", "X", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "(Ljava/lang/Integer;)I", "k", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "containerView", BdhLogUtil.LogTag.Tag_Conn, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "likeInfoBean", "T", "Lnk/as;", UserInfo.SEX_FEMALE, "Lnk/as;", "mLikeViewModel", "Lgf/a;", "G", "Lgf/a;", "mCommentIoc", "Lcom/qzone/module/feedcomponent/ui/common/SuperLikeView;", "H", "Lcom/qzone/module/feedcomponent/ui/common/SuperLikeView;", "mPraiseView", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "mCommentView", "J", "mForwardView", "<init>", "()V", "K", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g extends vg.a implements Observer<af.c> {

    /* renamed from: F, reason: from kotlin metadata */
    private as mLikeViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    private gf.a mCommentIoc;

    /* renamed from: H, reason: from kotlin metadata */
    private SuperLikeView mPraiseView;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView mCommentView;

    /* renamed from: J, reason: from kotlin metadata */
    private ImageView mForwardView;

    private final void M() {
        final String a16 = ef.b.a(this.f441565h);
        RFWIocAbilityProvider.g().getIoc(gf.e.class).originView(this.f441563e).done(new OnPromiseResolved() { // from class: tg.b
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                g.N(g.this, a16, (gf.e) obj);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(g this$0, String str, gf.e reportIoc) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportIoc, "reportIoc");
        if (this$0.mPraiseView != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String spaceId = this$0.f441565h.cellIntimateSpaceInfo.spaceId;
            bk.a aVar = bk.a.f28490a;
            Intrinsics.checkNotNullExpressionValue(spaceId, "spaceId");
            linkedHashMap.put("icontype", Integer.valueOf(aVar.c(spaceId) ? 2 : 1));
            SuperLikeView superLikeView = this$0.mPraiseView;
            Intrinsics.checkNotNull(superLikeView);
            reportIoc.G3(superLikeView, "em_qz_like_icon", str, this$0.f441565h, linkedHashMap);
        }
        ImageView imageView = this$0.mCommentView;
        if (imageView != null) {
            Intrinsics.checkNotNull(imageView);
            reportIoc.k5(imageView, "em_qz_comment_icon", str, this$0.f441565h);
        }
    }

    private final int O(Integer spaceType, String spaceId) {
        bk.a aVar = bk.a.f28490a;
        if (aVar.c(spaceId)) {
            return aVar.a(spaceType);
        }
        mk.d dVar = mk.d.f416875a;
        return dVar.y(spaceType) ? R.drawable.f15768l : dVar.w(spaceType) ? R.drawable.f15748j : dVar.H(spaceType) ? R.drawable.f15758k : dVar.t(spaceType) ? R.drawable.f15738i : dVar.F(spaceType) ? R.drawable.qui_like_filled_brand : R.drawable.f15768l;
    }

    private final int P() {
        return R.drawable.qui_heart_qzone;
    }

    private final void R() {
        if (this.mCommentIoc == null) {
            this.mCommentIoc = (gf.a) j(gf.a.class);
        }
        com.qzone.reborn.feedx.bean.b bVar = new com.qzone.reborn.feedx.bean.b(this.f441565h);
        bVar.f54740a = this.f441567m;
        bVar.f54741b = 4;
        gf.a aVar = this.mCommentIoc;
        if (aVar != null) {
            aVar.f6(bVar);
        }
        gf.a aVar2 = this.mCommentIoc;
        if (aVar2 != null) {
            aVar2.c1(this.f441565h, null, this.f441567m);
        }
    }

    private final void S() {
        CellLikeInfo cellLikeInfo;
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData == null) {
            return;
        }
        if (businessFeedData != null && (cellLikeInfo = businessFeedData.cellLikeInfo) != null && !cellLikeInfo.isLiked) {
            Y();
        }
        if (this.mLikeViewModel == null) {
            this.mLikeViewModel = (as) r(as.class);
        }
        as asVar = this.mLikeViewModel;
        if (asVar != null) {
            BusinessFeedData mFeedData = this.f441565h;
            Intrinsics.checkNotNullExpressionValue(mFeedData, "mFeedData");
            asVar.M1(mFeedData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.S();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(SuperLikeAnimator$Event superLikeAnimator$Event, View view) {
        if (superLikeAnimator$Event == SuperLikeAnimator$Event.CLICK) {
            view.performClick();
        }
    }

    private final void Y() {
        RFWIocAbilityProvider.g().getIoc(gf.c.class).originView(this.f441563e).done(new OnPromiseResolved() { // from class: tg.f
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                g.Z(g.this, (gf.c) obj);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(g this$0, gf.c cVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        cVar.r4(this$0.mPraiseView, this$0.f441565h);
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        if (feedData.isFakeFeed()) {
            X(this.mPraiseView, false);
            SuperLikeView superLikeView = this.mPraiseView;
            if (superLikeView != null) {
                CellIntimateSpaceInfo cellIntimateSpaceInfo = feedData.cellIntimateSpaceInfo;
                superLikeView.setImageResource(Q(cellIntimateSpaceInfo != null ? Integer.valueOf(cellIntimateSpaceInfo.spaceType) : null));
            }
            X(this.mCommentView, false);
            return;
        }
        X(this.mPraiseView, true);
        X(this.mCommentView, true);
        a0(feedData);
        if (!TextUtils.isEmpty(ef.b.a(feedData))) {
            ze.a.a().observerGlobalState(new af.c(ef.b.a(feedData), feedData.cellLikeInfo), this);
        } else {
            QLog.e("QZoneFeedIntimateOperatePresenter", 1, "ugcKey is empty");
        }
        M();
    }

    @Override // vg.a
    protected void C(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.mPraiseView = (SuperLikeView) containerView.findViewById(R.id.n9l);
        this.mCommentView = (ImageView) containerView.findViewById(R.id.mt7);
        ImageView imageView = (ImageView) containerView.findViewById(R.id.n2a);
        this.mForwardView = imageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.mCommentView;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: tg.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.U(g.this, view);
                }
            });
        }
        SuperLikeView superLikeView = this.mPraiseView;
        if (superLikeView != null) {
            superLikeView.setImageResource(P());
        }
        SuperLikeView superLikeView2 = this.mPraiseView;
        if (superLikeView2 != null) {
            superLikeView2.setOnClickListener(new View.OnClickListener() { // from class: tg.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.V(g.this, view);
                }
            });
        }
        SuperLikeView superLikeView3 = this.mPraiseView;
        if (superLikeView3 != null) {
            superLikeView3.setOnEventBack(new SuperLikeView.OnEventBack() { // from class: tg.e
                @Override // com.qzone.module.feedcomponent.ui.common.SuperLikeView.OnEventBack
                public final void onEventBack(SuperLikeAnimator$Event superLikeAnimator$Event, View view) {
                    g.W(superLikeAnimator$Event, view);
                }
            });
        }
        AccessibilityUtil.s(this.mPraiseView, l.a(R.string.f2202368k));
        AccessibilityUtil.s(this.mCommentView, l.a(R.string.f2201868f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFeedIntimateOperatePresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nnt;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public void onChanged(af.c likeInfoBean) {
        if (likeInfoBean == null || !TextUtils.equals(likeInfoBean.a(), ef.b.a(this.f441565h))) {
            return;
        }
        this.f441565h.cellLikeInfo = likeInfoBean.b();
        a0(this.f441565h);
    }

    private final int Q(Integer spaceType) {
        return (spaceType != null && spaceType.intValue() == 4) ? R.drawable.f153142 : R.drawable.qui_heart_qzone;
    }

    private final void a0(BusinessFeedData feedData) {
        if ((feedData != null ? feedData.getLikeInfo() : null) == null) {
            return;
        }
        boolean z16 = feedData.getLikeInfo().isLiked;
        SuperLikeView superLikeView = this.mPraiseView;
        if (superLikeView != null) {
            superLikeView.setVisibility(0);
        }
        SuperLikeView superLikeView2 = this.mPraiseView;
        if (superLikeView2 != null) {
            superLikeView2.setSelected(z16);
        }
        if (z16) {
            SuperLikeView superLikeView3 = this.mPraiseView;
            if (superLikeView3 != null) {
                CellIntimateSpaceInfo cellIntimateSpaceInfo = feedData.cellIntimateSpaceInfo;
                Integer valueOf = cellIntimateSpaceInfo != null ? Integer.valueOf(cellIntimateSpaceInfo.spaceType) : null;
                CellIntimateSpaceInfo cellIntimateSpaceInfo2 = feedData.cellIntimateSpaceInfo;
                String str = cellIntimateSpaceInfo2 != null ? cellIntimateSpaceInfo2.spaceId : null;
                if (str == null) {
                    str = "";
                }
                superLikeView3.setImageResource(O(valueOf, str));
                return;
            }
            return;
        }
        SuperLikeView superLikeView4 = this.mPraiseView;
        if (superLikeView4 != null) {
            CellIntimateSpaceInfo cellIntimateSpaceInfo3 = feedData.cellIntimateSpaceInfo;
            superLikeView4.setImageResource(Q(cellIntimateSpaceInfo3 != null ? Integer.valueOf(cellIntimateSpaceInfo3.spaceType) : null));
        }
    }

    private final void X(View view, boolean isEnable) {
        if (isEnable) {
            if (view != null) {
                view.setAlpha(1.0f);
            }
        } else if (view != null) {
            view.setAlpha(0.3f);
        }
        if (view == null) {
            return;
        }
        view.setEnabled(isEnable);
    }
}
