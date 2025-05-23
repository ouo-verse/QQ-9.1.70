package td;

import android.app.Activity;
import android.content.Context;
import com.qzone.reborn.feedpro.banner.topbanner.constant.FeedProTopBannerType;
import com.qzone.reborn.feedpro.banner.topbanner.item.FeedProBaseTopBanner;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ&\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Ltd/a;", "Lsd/a;", "", "Lcom/qzone/reborn/feedpro/banner/topbanner/item/FeedProBaseTopBanner;", "targetList", "newBanner", "Lqd/a;", "bannerData", "", "c", "d", "Landroid/content/Context;", "context", "b", "Lcom/qzone/reborn/feedpro/banner/topbanner/constant/FeedProTopBannerType;", WadlProxyConsts.BANNER_TYPE, "a", "Landroid/app/Activity;", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lsd/b;", "Lsd/b;", "bannerPageIoc", "Ljava/util/List;", "topBannerList", "<init>", "(Landroid/app/Activity;Lsd/b;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a implements sd.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final sd.b bannerPageIoc;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final List<FeedProBaseTopBanner> topBannerList;

    public a(Activity activity, sd.b bannerPageIoc) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bannerPageIoc, "bannerPageIoc");
        this.activity = activity;
        this.bannerPageIoc = bannerPageIoc;
        this.topBannerList = new CopyOnWriteArrayList();
    }

    private final void d() {
        this.bannerPageIoc.J4(this.topBannerList.get(0));
    }

    @Override // sd.a
    public void a(FeedProTopBannerType bannerType) {
        Unit unit;
        Object obj;
        Intrinsics.checkNotNullParameter(bannerType, "bannerType");
        Iterator<T> it = this.topBannerList.iterator();
        while (true) {
            unit = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((FeedProBaseTopBanner) obj).o0() == bannerType) {
                    break;
                }
            }
        }
        FeedProBaseTopBanner feedProBaseTopBanner = (FeedProBaseTopBanner) obj;
        if (feedProBaseTopBanner != null) {
            this.topBannerList.remove(feedProBaseTopBanner);
            this.bannerPageIoc.e2(feedProBaseTopBanner);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.e("FeedProTopBannerManager", 1, "cannot find banner to hide: type=" + bannerType);
        }
    }

    @Override // sd.a
    public void b(qd.a bannerData, Context context) {
        Intrinsics.checkNotNullParameter(bannerData, "bannerData");
        FeedProBaseTopBanner d16 = b.INSTANCE.a().d(bannerData.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.BANNER_TYPE java.lang.String().getBannerType(), context);
        if (d16 == null) {
            QLog.e("FeedProTopBannerManager", 1, "banner to show is null, banner type is " + bannerData.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.BANNER_TYPE java.lang.String().getBannerType());
            return;
        }
        c(this.topBannerList, d16, bannerData);
    }

    private final void c(List<FeedProBaseTopBanner> targetList, FeedProBaseTopBanner newBanner, qd.a bannerData) {
        Object obj;
        Iterator<T> it = targetList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                int n06 = ((FeedProBaseTopBanner) next).n0();
                do {
                    Object next2 = it.next();
                    int n07 = ((FeedProBaseTopBanner) next2).n0();
                    if (n06 < n07) {
                        next = next2;
                        n06 = n07;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        FeedProBaseTopBanner feedProBaseTopBanner = (FeedProBaseTopBanner) obj;
        if (feedProBaseTopBanner == null) {
            newBanner.setData(bannerData);
            targetList.add(newBanner);
            d();
            return;
        }
        if (newBanner.n0() > feedProBaseTopBanner.n0()) {
            targetList.clear();
            newBanner.setData(bannerData);
            targetList.add(newBanner);
            d();
            return;
        }
        if (newBanner.n0() == feedProBaseTopBanner.n0() && newBanner.o0() == feedProBaseTopBanner.o0()) {
            feedProBaseTopBanner.setData(bannerData);
            return;
        }
        QLog.i("FeedProTopBannerManager", 1, "priority of banner to show is " + newBanner.n0() + ", lower than " + feedProBaseTopBanner.n0());
    }
}
