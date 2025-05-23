package ug;

import android.app.Activity;
import com.qzone.module.feedcomponent.ui.common.SuperLikeView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.bean.QZoneSpringLikeInfoBean;
import com.qzone.reborn.feedx.util.ad;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001b\u0010\u0016J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lug/g;", "Lug/a;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "Lcom/qzone/reborn/feedx/bean/d;", "f", "likeInfo", "", "e", "isLike", "b", "Lcom/qzone/module/feedcomponent/ui/common/SuperLikeView;", "likeView", "", "a", "d", "c", "Landroid/app/Activity;", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/qzone/reborn/feedx/util/ad;", "Lcom/qzone/reborn/feedx/util/ad;", "praiseAnimHelper", "<init>", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ad praiseAnimHelper;

    public g(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.praiseAnimHelper = new ad();
    }

    @Override // ug.a
    public boolean c(BusinessFeedData feedData) {
        return false;
    }

    @Override // ug.a
    public boolean d(SuperLikeView likeView, BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(likeView, "likeView");
        if (feedData == null || f(feedData) == null || likeView.isSelected()) {
            return false;
        }
        ad adVar = this.praiseAnimHelper;
        Activity activity = this.activity;
        com.tencent.mobileqq.service.qzone.e eVar = com.tencent.mobileqq.service.qzone.e.f286406a;
        QZoneSpringLikeInfoBean f16 = f(feedData);
        Intrinsics.checkNotNull(f16);
        adVar.i(likeView, activity, eVar.a(f16.getClick()));
        return true;
    }

    private final QZoneSpringLikeInfoBean f(BusinessFeedData feedData) {
        if (feedData != null) {
            return ef.b.b(feedData);
        }
        return null;
    }

    @Override // ug.a
    public void a(boolean isLike, SuperLikeView likeView, BusinessFeedData feedData) {
        if (isLike && e(feedData, f(feedData))) {
            Option targetView = Option.obtain().setTargetView(likeView);
            com.tencent.mobileqq.service.qzone.e eVar = com.tencent.mobileqq.service.qzone.e.f286406a;
            QZoneSpringLikeInfoBean f16 = f(feedData);
            Intrinsics.checkNotNull(f16);
            com.tencent.mobileqq.qzone.picload.c.a().h(targetView.setUrl(eVar.a(f16.getLike())).setLoadingDrawableId(R.drawable.f153142).setFailedDrawableId(R.drawable.f153142));
        }
    }

    @Override // ug.a
    public boolean b(boolean isLike, BusinessFeedData feedData) {
        return isLike && e(feedData, f(feedData));
    }

    private final boolean e(BusinessFeedData feedData, QZoneSpringLikeInfoBean likeInfo) {
        if (feedData == null || likeInfo == null) {
            return false;
        }
        if (likeInfo.getLike().length() > 0) {
            return likeInfo.getClick().length() > 0;
        }
        return false;
    }
}
