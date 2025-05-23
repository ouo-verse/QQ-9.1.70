package ug;

import android.app.Activity;
import com.qzone.module.feedcomponent.ui.common.SuperLikeView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellDecorateInfo;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.reborn.feedx.util.ad;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001a\u0010\u0015J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lug/f;", "Lug/a;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "Lcom/tencent/mobileqq/service/qzone/bean/b;", "likeConf", "", "e", "isLike", "b", "Lcom/qzone/module/feedcomponent/ui/common/SuperLikeView;", "likeView", "", "a", "d", "c", "Landroid/app/Activity;", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/qzone/reborn/feedx/util/ad;", "Lcom/qzone/reborn/feedx/util/ad;", "praiseAnimHelper", "<init>", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ad praiseAnimHelper;

    public f(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.praiseAnimHelper = new ad();
    }

    @Override // ug.a
    public void a(boolean isLike, SuperLikeView likeView, BusinessFeedData feedData) {
        com.tencent.mobileqq.service.qzone.bean.b b16 = com.tencent.mobileqq.service.qzone.a.f286399a.b();
        if (isLike && e(feedData, b16)) {
            Option targetView = Option.obtain().setTargetView(likeView);
            com.tencent.mobileqq.service.qzone.e eVar = com.tencent.mobileqq.service.qzone.e.f286406a;
            Intrinsics.checkNotNull(b16);
            com.tencent.mobileqq.qzone.picload.c.a().h(targetView.setUrl(eVar.a(b16.e())).setLoadingDrawableId(R.drawable.f153142).setFailedDrawableId(R.drawable.f153142));
        }
    }

    @Override // ug.a
    public boolean b(boolean isLike, BusinessFeedData feedData) {
        return isLike && e(feedData, com.tencent.mobileqq.service.qzone.a.f286399a.b());
    }

    @Override // ug.a
    public boolean c(BusinessFeedData feedData) {
        return false;
    }

    @Override // ug.a
    public boolean d(SuperLikeView likeView, BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(likeView, "likeView");
        com.tencent.mobileqq.service.qzone.bean.b b16 = com.tencent.mobileqq.service.qzone.a.f286399a.b();
        if (feedData == null || b16 == null || likeView.isSelected()) {
            return false;
        }
        this.praiseAnimHelper.i(likeView, this.activity, com.tencent.mobileqq.service.qzone.e.f286406a.a(b16.b()));
        return true;
    }

    private final boolean e(BusinessFeedData feedData, com.tencent.mobileqq.service.qzone.bean.b likeConf) {
        CellDecorateInfo.CellCustomPraise cellCustomPraise;
        if (feedData == null || likeConf == null) {
            return false;
        }
        CellDecorateInfo cellDecorateInfo = feedData.cellDecorateInfo;
        if (!((cellDecorateInfo == null || (cellCustomPraise = cellDecorateInfo.cellCustomPraise) == null || cellCustomPraise.cmShowActionId != likeConf.d()) ? false : true)) {
            b bVar = b.f438918a;
            CellFeedCommInfo cellFeedCommInfo = feedData.cellFeedCommInfo;
            if (!bVar.c(cellFeedCommInfo != null ? cellFeedCommInfo.ugckey : null)) {
                return false;
            }
        }
        return true;
    }
}
