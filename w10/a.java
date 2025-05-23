package w10;

import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0004B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0004\u0010\u0010R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u000e\u0010\u0013R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\b\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0012\u0010\u000b\u00a8\u0006\u001d"}, d2 = {"Lw10/a;", "", "", "kotlin.jvm.PlatformType", "a", "Ljava/lang/String;", "shakeStyle", "", "b", "Z", "e", "()Z", "showShakeIcon", "", "c", "I", "()I", "shakeDelayTime", "d", "()Ljava/lang/String;", "shakeIconUrl", "shakeIconTitle", "f", "showBtnIconNow", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "<init>", "(Lcom/tencent/gdtad/aditem/GdtAd;)V", "g", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String shakeStyle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean showShakeIcon;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int shakeDelayTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String shakeIconUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String shakeIconTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean showBtnIconNow;

    public a(GdtAd gdtAd) {
        int i3;
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo displayInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.Interactive interactive;
        PBStringField pBStringField;
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo displayInfo2;
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.Interactive interactive2;
        PBStringField pBStringField2;
        int i16;
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        String experimentParam = gdtAd.getExperimentParam(123029);
        this.shakeStyle = experimentParam;
        this.showShakeIcon = (Intrinsics.areEqual(experimentParam, "2") || Intrinsics.areEqual(experimentParam, "3")) ? false : true;
        if (Intrinsics.areEqual(experimentParam, "3")) {
            try {
                String experimentParam2 = gdtAd.getExperimentParam(123030);
                Intrinsics.checkNotNullExpressionValue(experimentParam2, "gdtAd.getExperimentParam(KEY_SHAKE_DELAY_TIME)");
                i16 = (int) Double.parseDouble(experimentParam2);
            } catch (NumberFormatException e16) {
                QLog.d("VasAdvShakeConfig", 1, e16, new Object[0]);
                i16 = 0;
            }
            i3 = RangesKt___RangesKt.coerceIn(i16, 0, 6);
        } else {
            i3 = 0;
        }
        this.shakeDelayTime = i3;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = gdtAd.info;
        String str = null;
        String str2 = (adInfo == null || (displayInfo2 = adInfo.display_info) == null || (interactive2 = displayInfo2.interactive) == null || (pBStringField2 = interactive2.icon_url) == null) ? null : pBStringField2.get();
        this.shakeIconUrl = str2;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo2 = gdtAd.info;
        if (adInfo2 != null && (displayInfo = adInfo2.display_info) != null && (interactive = displayInfo.interactive) != null && (pBStringField = interactive.icon_title) != null) {
            str = pBStringField.get();
        }
        this.shakeIconTitle = str;
        this.showBtnIconNow = i3 == 0;
        QLog.i("VasAdvShakeConfig", 2, "shakeStyle=" + this.shakeStyle + " showShakeIcon=" + this.showShakeIcon + " shakeDelayTime=" + i3 + " shakeIconUrl=" + str2 + " shakeIconTitle=" + str);
    }

    /* renamed from: a, reason: from getter */
    public final int getShakeDelayTime() {
        return this.shakeDelayTime;
    }

    /* renamed from: b, reason: from getter */
    public final String getShakeIconTitle() {
        return this.shakeIconTitle;
    }

    /* renamed from: c, reason: from getter */
    public final String getShakeIconUrl() {
        return this.shakeIconUrl;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getShowBtnIconNow() {
        return this.showBtnIconNow;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getShowShakeIcon() {
        return this.showShakeIcon;
    }
}
