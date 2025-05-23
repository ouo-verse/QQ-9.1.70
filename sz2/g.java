package sz2;

import android.app.Activity;
import android.content.Context;
import com.tencent.ark.ark;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.pb.adv_report;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;
import uz2.VasRewardAdReportParams;
import uz2.VasRewardAdReqParams;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b7\u00108J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0010J\u001c\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J6\u0010 \u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u001dJ\u001c\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020!0\u0012J\u0010\u0010%\u001a\u0004\u0018\u00010\u00022\u0006\u0010$\u001a\u00020#J\u0018\u0010'\u001a\u0004\u0018\u00010\u00062\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0013J\u0016\u0010)\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0013J\u0010\u0010*\u001a\u0004\u0018\u00010\u00132\u0006\u0010(\u001a\u00020\u0010J\u000e\u0010+\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u0010R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u00100R6\u00106\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001303j\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0013`4028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u00105\u00a8\u00069"}, d2 = {"Lsz2/g;", "", "Luz2/b;", "rewardParams", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvReq;", "e", "Luz2/a;", "param", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$MobileAdvReportReq;", "d", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "j", "Landroid/content/Context;", "i", "", "f", "", "c", "Lbz2/a;", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvRsp;", "callback", "p", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "adInfo", "Ljava/lang/ref/WeakReference;", "Ltz2/a;", "profitableCallbackRef", "", "rewardText", ark.APP_SPECIFIC_BIZSRC, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$MobileAdvReportRsp;", DomainData.DOMAIN_NAME, "Lorg/json/JSONObject;", "paramsJson", "l", "adRsp", "k", "adSequence", "r", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/atomic/AtomicInteger;", "b", "Ljava/util/concurrent/atomic/AtomicInteger;", "AD_SEQUENCE_ATOMIC_INTEGER", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "deviceInfo", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "rewardAdRspMapList", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static qq_ad_get.QQAdGet.DeviceInfo deviceInfo;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f435047a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicInteger AD_SEQUENCE_ATOMIC_INTEGER = new AtomicInteger(10000);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<HashMap<Long, vac_adv_get.VacAdvRsp>> rewardAdRspMapList = new CopyOnWriteArrayList<>();

    g() {
    }

    private final adv_report.MobileAdvReportReq d(VasRewardAdReportParams param) {
        boolean z16;
        String str;
        PBStringField pBStringField;
        adv_report.MobileAdvReportReq mobileAdvReportReq = new adv_report.MobileAdvReportReq();
        mobileAdvReportReq.adv_pos.set(7);
        PBRepeatMessageField<vac_adv_get.VacAdvMetaMsg> pBRepeatMessageField = param.getAdRsp().vac_adv_msgs;
        PBStringField pBStringField2 = mobileAdvReportReq.recomm_cookie;
        List<vac_adv_get.VacAdvMetaMsg> list = pBRepeatMessageField.get();
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            vac_adv_get.VacAdvMetaMsg vacAdvMetaMsg = pBRepeatMessageField.get(0);
            if (vacAdvMetaMsg != null && (pBStringField = vacAdvMetaMsg.recomm_cookie) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            pBStringField2.set(str);
        }
        mobileAdvReportReq.action_type.set(4);
        mobileAdvReportReq.action_value.set(param.getActionValue());
        qq_ad_get.QQAdGet.DeviceInfo deviceInfo2 = deviceInfo;
        if (deviceInfo2 != null) {
            mobileAdvReportReq.device_info.set(deviceInfo2);
        }
        adv_report.RewardReportInfo rewardReportInfo = mobileAdvReportReq.reward_report_info;
        adv_report.RewardReportInfo rewardReport = param.getRewardReport();
        if (rewardReport == null) {
            rewardReport = new adv_report.RewardReportInfo();
            rewardReport.reward_type.set(param.getRewardType());
            rewardReport.reward_item.set(ByteStringMicro.copyFromUtf8(param.getRewardItem()));
            rewardReport.time.set(param.getAdRsp().reward_rsp_info.time.get());
            rewardReport.nonce.set(param.getAdRsp().reward_rsp_info.nonce.get());
            rewardReport.signature.set(param.getAdRsp().reward_rsp_info.signature.get());
        }
        rewardReportInfo.set(rewardReport);
        return mobileAdvReportReq;
    }

    private final vac_adv_get.VacAdvReq e(VasRewardAdReqParams rewardParams) {
        if (deviceInfo == null) {
            f();
            return null;
        }
        vac_adv_get.VacAdvReq vacAdvReq = new vac_adv_get.VacAdvReq();
        vacAdvReq.adv_pos.set(7);
        vacAdvReq.client_mod.set(vz2.d.f443778a.a());
        vacAdvReq.device_info.set(deviceInfo);
        vac_adv_get.RewardReqInfo rewardReqInfo = vacAdvReq.reward_req_info;
        vac_adv_get.RewardReqInfo rewardReqInfo2 = new vac_adv_get.RewardReqInfo();
        rewardReqInfo2.reward_type.set(rewardParams.getRewardType());
        rewardReqInfo2.reward_item.set(ByteStringMicro.copyFromUtf8(rewardParams.getRewardItem()));
        vacAdvReq.source_from.set(rewardParams.getSourceFrom());
        vacAdvReq.attach_info.set(rewardParams.getAttachInfo());
        rewardReqInfo.set(rewardReqInfo2);
        return vacAdvReq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        deviceInfo = f435047a.j();
    }

    private final Context i() {
        return MobileQQ.sMobileQQ.getApplicationContext();
    }

    private final qq_ad_get.QQAdGet.DeviceInfo j() {
        try {
            GdtDeviceInfoHelper.Params params = new GdtDeviceInfoHelper.Params();
            params.supportOpenMotiveAd = true;
            GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(BaseApplication.getContext(), params);
            if (create != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("VasRewardAdHelper", 2, "gdt device info init success");
                }
                return create.deviceInfo;
            }
            return null;
        } catch (Exception e16) {
            QLog.e("VasRewardAdHelper", 1, "Error when get gdt device info:", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(adv_report.MobileAdvReportReq reportReq, bz2.a callback) {
        Intrinsics.checkNotNullParameter(reportReq, "$reportReq");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        com.tencent.mobileqq.vas.adv.base.service.e.f307985a.r(reportReq, callback);
    }

    public final long c() {
        return AD_SEQUENCE_ATOMIC_INTEGER.getAndIncrement();
    }

    public final void f() {
        if (deviceInfo == null) {
            ThreadManagerV2.excute(new Runnable() { // from class: sz2.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.g();
                }
            }, 16, null, false);
        }
    }

    @Nullable
    public final vac_adv_get.VacAdvRsp h(long adSequence) {
        if (adSequence == 0) {
            return null;
        }
        Iterator<HashMap<Long, vac_adv_get.VacAdvRsp>> it = rewardAdRspMapList.iterator();
        while (it.hasNext()) {
            HashMap<Long, vac_adv_get.VacAdvRsp> next = it.next();
            if (next.containsKey(Long.valueOf(adSequence))) {
                return next.get(Long.valueOf(adSequence));
            }
        }
        return null;
    }

    @Nullable
    public final VasRewardAdReportParams k(@NotNull JSONObject paramsJson, @NotNull vac_adv_get.VacAdvRsp adRsp) {
        Intrinsics.checkNotNullParameter(paramsJson, "paramsJson");
        Intrinsics.checkNotNullParameter(adRsp, "adRsp");
        try {
            VasRewardAdReportParams.C11382a c11382a = new VasRewardAdReportParams.C11382a();
            c11382a.d(paramsJson.optLong("adSequence"));
            c11382a.e(paramsJson.optBoolean("isFinished"));
            c11382a.h(paramsJson.optInt("rewardType"));
            String optString = paramsJson.optString("rewardItem");
            Intrinsics.checkNotNullExpressionValue(optString, "paramsJson.optString(\"rewardItem\")");
            c11382a.f(optString);
            c11382a.b(paramsJson.optInt("actionValue"));
            c11382a.c(adRsp);
            return c11382a.a();
        } catch (Throwable th5) {
            QLog.e("VasRewardAdHelper", 1, "getRewardAdReportParams error invalid args", th5);
            return null;
        }
    }

    @Nullable
    public final VasRewardAdReqParams l(@NotNull JSONObject paramsJson) {
        Intrinsics.checkNotNullParameter(paramsJson, "paramsJson");
        try {
            VasRewardAdReqParams.a aVar = new VasRewardAdReqParams.a();
            aVar.d(paramsJson.optInt("rewardType"));
            String optString = paramsJson.optString("rewardItem");
            Intrinsics.checkNotNullExpressionValue(optString, "paramsJson.optString(\"rewardItem\")");
            aVar.c(optString);
            aVar.e(paramsJson.optInt(GetAdInfoRequest.SOURCE_FROM));
            String optString2 = paramsJson.optString("attachInfo");
            Intrinsics.checkNotNullExpressionValue(optString2, "paramsJson.optString(\"attachInfo\")");
            aVar.b(optString2);
            return aVar.a();
        } catch (Throwable th5) {
            QLog.e("VasRewardAdHelper", 1, "getRewardAdRequestParams error invalid args", th5);
            return null;
        }
    }

    public final void m(long adSequence) {
        if (adSequence == 0) {
            return;
        }
        Iterator<HashMap<Long, vac_adv_get.VacAdvRsp>> it = rewardAdRspMapList.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                int i16 = i3 + 1;
                HashMap<Long, vac_adv_get.VacAdvRsp> next = it.next();
                if (next.containsKey(Long.valueOf(adSequence))) {
                    next.remove(Long.valueOf(adSequence));
                    break;
                }
                i3 = i16;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 >= 0) {
            rewardAdRspMapList.remove(i3);
        }
    }

    public final void n(@NotNull VasRewardAdReportParams param, @NotNull final bz2.a<adv_report.MobileAdvReportRsp> callback) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final adv_report.MobileAdvReportReq d16 = d(param);
        if (d16 == null) {
            callback.b(VasAdvServiceCode.REPORT_RSP_FAIL, "reportRewardAd error: reportReq is null", null);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: sz2.e
                @Override // java.lang.Runnable
                public final void run() {
                    g.o(adv_report.MobileAdvReportReq.this, callback);
                }
            }, 128, null, false);
        }
    }

    public final void p(@NotNull VasRewardAdReqParams rewardParams, @NotNull bz2.a<vac_adv_get.VacAdvRsp> callback) {
        Intrinsics.checkNotNullParameter(rewardParams, "rewardParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!NetworkUtil.isNetSupport(i())) {
            callback.b(VasAdvServiceCode.REQUEST_CMD_ERROR, "network is not support", null);
            return;
        }
        vac_adv_get.VacAdvReq e16 = e(rewardParams);
        if (e16 == null) {
            callback.b(VasAdvServiceCode.CREATE_REQUEST_ERR, "requestRewardAd req return null", null);
        } else {
            com.tencent.mobileqq.vas.adv.base.service.e.f307985a.u(e16, callback);
        }
    }

    public final void q(@NotNull Activity activity, @NotNull qq_ad_get.QQAdGetRsp.AdInfo adInfo, @NotNull WeakReference<tz2.a> profitableCallbackRef, @Nullable String rewardText, @NotNull String bizSrc) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        Intrinsics.checkNotNullParameter(profitableCallbackRef, "profitableCallbackRef");
        Intrinsics.checkNotNullParameter(bizSrc, "bizSrc");
        VasAdvSupport.INSTANCE.a().e(activity, adInfo, profitableCallbackRef, rewardText, bizSrc);
    }

    public final void r(long adSequence, @NotNull vac_adv_get.VacAdvRsp adRsp) {
        HashMap<Long, vac_adv_get.VacAdvRsp> hashMapOf;
        Intrinsics.checkNotNullParameter(adRsp, "adRsp");
        while (true) {
            CopyOnWriteArrayList<HashMap<Long, vac_adv_get.VacAdvRsp>> copyOnWriteArrayList = rewardAdRspMapList;
            if (copyOnWriteArrayList.size() > 10) {
                CollectionsKt__MutableCollectionsKt.removeFirst(copyOnWriteArrayList);
            } else {
                m(adSequence);
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(Long.valueOf(adSequence), adRsp));
                copyOnWriteArrayList.add(hashMapOf);
                return;
            }
        }
    }
}
