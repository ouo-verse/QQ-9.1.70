package vz2;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdClickHelper;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdRenderProxy;
import com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJF\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002JR\u0010\u0019\u001a\u00020\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ \u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u00a8\u0006\u001f"}, d2 = {"Lvz2/c;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "resPath", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "maskAd", "Ltencent/gdt/access$UserActionReportInfo;", "userActionReportInfo", "", "isTianShuAd", "Lcom/tencent/mobileqq/vas/adv/common/data/MaskAdvName;", "maskAdvName", "Landroid/view/ViewGroup;", "parentView", "", "b", "Lcom/tencent/gdtad/aditem/GdtAd;", "ad", "maskPosId", "tianShuPosId", "adResPath", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "Lorg/json/JSONObject;", "c", "eventId", "params", "a", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f443777a = new c();

    c() {
    }

    private final void b(Activity activity, String resPath, qq_ad_get.QQAdGetRsp.AdInfo maskAd, access.UserActionReportInfo userActionReportInfo, boolean isTianShuAd, MaskAdvName maskAdvName, ViewGroup parentView) {
        if (maskAd == null) {
            return;
        }
        if (resPath == null) {
            resPath = "";
        }
        MaskAdRenderProxy maskAdRenderProxy = new MaskAdRenderProxy(activity, maskAdvName, resPath, maskAd);
        if (userActionReportInfo != null) {
            maskAdRenderProxy.setUserActionReportInfo(userActionReportInfo);
        }
        maskAdRenderProxy.setIsTianShuAd(isTianShuAd);
        maskAdRenderProxy.startShow(parentView);
    }

    public final void a(@NotNull MaskAdvName businessName, @NotNull String eventId, @Nullable JSONObject params) {
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).reportEventToBeacon(businessName, eventId, params);
    }

    @NotNull
    public final JSONObject c(@Nullable Activity activity, @NotNull GdtAd ad5, @Nullable access.UserActionReportInfo userActionReportInfo, @NotNull String maskPosId, @NotNull String tianShuPosId, @NotNull String adResPath, @NotNull String businessName, @NotNull MaskAdvName maskAdvName, @NotNull ViewGroup parentView) {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        String str;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo2;
        boolean z16;
        String str2;
        Intrinsics.checkNotNullParameter(ad5, "ad");
        Intrinsics.checkNotNullParameter(maskPosId, "maskPosId");
        Intrinsics.checkNotNullParameter(tianShuPosId, "tianShuPosId");
        Intrinsics.checkNotNullParameter(adResPath, "adResPath");
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(maskAdvName, "maskAdvName");
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("weather", 0);
        if (activity == null) {
            QLog.d("MaskAdShowHelper", 1, "cancel show maskAd, activity is null");
            return jSONObject;
        }
        String posId = ad5.getPosId();
        if (jSONObject.has(businessName)) {
            jSONObject.put(businessName, 1);
        }
        if (TextUtils.equals(maskPosId, posId) && MaskAdClickHelper.INSTANCE.isMaskAd(ad5.getInnerShowType())) {
            adInfo = ad5.info;
            str = adResPath;
        } else {
            adInfo = null;
            str = "";
        }
        if (TextUtils.equals(tianShuPosId, posId)) {
            adInfo2 = ad5.info;
            str2 = adResPath;
            z16 = true;
        } else {
            adInfo2 = adInfo;
            z16 = false;
            str2 = str;
        }
        if (adInfo2 != null) {
            b(activity, str2, adInfo2, userActionReportInfo, z16, maskAdvName, parentView);
        }
        return jSONObject;
    }
}
