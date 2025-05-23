package y05;

import android.app.Activity;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.report.ReportField;
import com.tencent.mobileqq.qwallet.report.beacon.IQWalletCommonReport;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.dtreport.api.DefaultTVKDataProvider;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import ml2.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007\u00a8\u0006\u000f"}, d2 = {"Ly05/a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/ResultReceiver;", "receiver", "Landroid/os/Bundle;", "payBundle", "", "a", "Ly05/a$a;", CacheTable.TABLE_NAME, "b", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f449242a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b(\u0010)J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u001a\u0010\u001b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\fR\u001a\u0010\u001e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001d\u0010\fR\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b \u0010\u0011R\u001c\u0010$\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b%\u0010\u000f\u001a\u0004\b&\u0010\u0011\u00a8\u0006*"}, d2 = {"Ly05/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getInvokeId", "()I", "invokeId", "b", "Ljava/lang/String;", "getOfferId", "()Ljava/lang/String;", "offerId", "c", "getSessionType", ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "d", "getPf", AdParam.PF, "e", "getComeForms", "comeForms", "f", "getPayType", "payType", "g", "getH5Url", "h5Url", h.F, "getActivity", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "i", "getReceiver", "receiver", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: y05.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes28.dex */
    public static final /* data */ class MidasPayReportInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "invoke_id")
        private final int invokeId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "offer_id")
        @Nullable
        private final String offerId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "session_type")
        @Nullable
        private final String sessionType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = AdParam.PF)
        @Nullable
        private final String pf;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "come_from")
        private final int comeForms;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = DefaultTVKDataProvider.KEY_PAY_TYPE)
        private final int payType;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "h5_url")
        @Nullable
        private final String h5Url;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)
        @Nullable
        private final String activity;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "receiver")
        @Nullable
        private final String receiver;

        public MidasPayReportInfo(int i3, @Nullable String str, @Nullable String str2, @Nullable String str3, int i16, int i17, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
            this.invokeId = i3;
            this.offerId = str;
            this.sessionType = str2;
            this.pf = str3;
            this.comeForms = i16;
            this.payType = i17;
            this.h5Url = str4;
            this.activity = str5;
            this.receiver = str6;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MidasPayReportInfo)) {
                return false;
            }
            MidasPayReportInfo midasPayReportInfo = (MidasPayReportInfo) other;
            if (this.invokeId == midasPayReportInfo.invokeId && Intrinsics.areEqual(this.offerId, midasPayReportInfo.offerId) && Intrinsics.areEqual(this.sessionType, midasPayReportInfo.sessionType) && Intrinsics.areEqual(this.pf, midasPayReportInfo.pf) && this.comeForms == midasPayReportInfo.comeForms && this.payType == midasPayReportInfo.payType && Intrinsics.areEqual(this.h5Url, midasPayReportInfo.h5Url) && Intrinsics.areEqual(this.activity, midasPayReportInfo.activity) && Intrinsics.areEqual(this.receiver, midasPayReportInfo.receiver)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            int i3 = this.invokeId * 31;
            String str = this.offerId;
            int i16 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i17 = (i3 + hashCode) * 31;
            String str2 = this.sessionType;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i18 = (i17 + hashCode2) * 31;
            String str3 = this.pf;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i19 = (((((i18 + hashCode3) * 31) + this.comeForms) * 31) + this.payType) * 31;
            String str4 = this.h5Url;
            if (str4 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str4.hashCode();
            }
            int i26 = (i19 + hashCode4) * 31;
            String str5 = this.activity;
            if (str5 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = str5.hashCode();
            }
            int i27 = (i26 + hashCode5) * 31;
            String str6 = this.receiver;
            if (str6 != null) {
                i16 = str6.hashCode();
            }
            return i27 + i16;
        }

        @NotNull
        public String toString() {
            return "MidasPayReportInfo(invokeId=" + this.invokeId + ", offerId=" + this.offerId + ", sessionType=" + this.sessionType + ", pf=" + this.pf + ", comeForms=" + this.comeForms + ", payType=" + this.payType + ", h5Url=" + this.h5Url + ", activity=" + this.activity + ", receiver=" + this.receiver + ')';
        }
    }

    a() {
    }

    @JvmStatic
    public static final void a(@Nullable Activity activity, @Nullable ResultReceiver receiver, @NotNull Bundle payBundle) {
        String obj;
        String str;
        String str2;
        String obj2;
        String substringBefore$default;
        Intrinsics.checkNotNullParameter(payBundle, "payBundle");
        int i3 = payBundle.getInt(QWalletPayBridge.Key.PAY_INVOKER_ID, -1);
        String string = payBundle.getString("offerId");
        String string2 = payBundle.getString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE);
        String string3 = payBundle.getString(AdParam.PF);
        int i16 = payBundle.getInt("comeForms", -1);
        int i17 = payBundle.getInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, -1);
        String string4 = payBundle.getString("payparmas_h5_url");
        if (activity instanceof QPublicFragmentActivity) {
            QPublicBaseFragment fragment = ((QPublicFragmentActivity) activity).getFragment();
            if (fragment != null) {
                obj = fragment.getClass().getName();
                str = obj;
            }
            str = null;
        } else {
            if (activity != null) {
                obj = activity.toString();
                str = obj;
            }
            str = null;
        }
        if (receiver != null && (obj2 = receiver.toString()) != null) {
            substringBefore$default = StringsKt__StringsKt.substringBefore$default(obj2, "@", (String) null, 2, (Object) null);
            str2 = substringBefore$default;
        } else {
            str2 = null;
        }
        b(new MidasPayReportInfo(i3, string, string2, string3, i16, i17, string4, str, str2));
    }

    @JvmStatic
    public static final void b(@NotNull MidasPayReportInfo reportInfo) {
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(d.f416922a.a(reportInfo));
        ((IQWalletCommonReport) QRoute.api(IQWalletCommonReport.class)).report("e_midas_monitor", (Map<String, String>) linkedHashMap);
    }
}
