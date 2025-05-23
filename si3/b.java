package si3;

import android.app.Activity;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H&J\"\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u000bH&J\u001a\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u000bH&J&\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H&J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H&J\"\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\b\b\u0002\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u001d"}, d2 = {"Lsi3/b;", "Lvb3/b;", "", "mapId", "", "mapVersion", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lnw4/d;", "callback", "", "G0", "Lti3/a;", "H0", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "E", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "code", "Lkotlin/Function0;", "onHandleFinish", "A0", "sceneName", "", "forceRefresh", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "isAfterPortalLoading", "forceDownload", "silentDownloadModInZPlan", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface b extends vb3.b {
    void A0(Activity activity, int code, Function0<Unit> onHandleFinish);

    void E(ZootopiaEnterParams enterParams, ti3.a callback);

    void G0(int mapId, String mapVersion, com.tencent.mobileqq.zootopia.api.e<nw4.d> callback);

    void H0(int mapId, String mapVersion, ti3.a callback);

    void Q(String sceneName, boolean forceRefresh);

    void silentDownloadModInZPlan(boolean isAfterPortalLoading, boolean forceDownload, int mapId);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes36.dex */
    public static final class a {
        public static /* synthetic */ void a(b bVar, boolean z16, boolean z17, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    i3 = AdMetricID.Click.SUCCESS;
                }
                bVar.silentDownloadModInZPlan(z16, z17, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: silentDownloadModInZPlan");
        }
    }
}
