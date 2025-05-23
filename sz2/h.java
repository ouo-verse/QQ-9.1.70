package sz2;

import android.app.Activity;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ark.ark;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.pb.adv_report;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get;
import com.tencent.mobileqq.vas.adv.reward.callback.VasRewardAdCallback;
import com.tencent.mobileqq.vas.adv.reward.data.VasRewardAdParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sz2.d;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\r\u0018\u0000 K2\u00020\u0001:\u0001LB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010.\u001a\u00020'\u0012\u0006\u00105\u001a\u00020/\u00a2\u0006\u0004\bI\u0010JJ2\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\b\u0010\u001a\u001a\u00020\u0018H\u0014J\b\u0010\u001b\u001a\u00020\u0018H\u0014J\b\u0010\u001d\u001a\u00020\u001cH\u0014J\b\u0010\u001f\u001a\u00020\u001eH\u0014J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 H\u0014J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020#H\u0014J\u0018\u0010&\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\bH\u0014R\"\u0010.\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00105\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u00107R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010:R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010BR\u0016\u0010H\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010G\u00a8\u0006M"}, d2 = {"Lsz2/h;", "Lsz2/d;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "adInfo", "Lsz2/a;", "profitableCallback", "", "rewardText", ark.APP_SPECIFIC_BIZSRC, "", "D", "Lsz2/d$b;", "showAdCallback", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "serviceCode", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "retCode", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B", ReportConstant.COSTREPORT_PREFIX, "", "g", tl.h.F, "f", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvReq;", "j", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$MobileAdvReportReq;", "i", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvRsp;", "rsp", "r", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$MobileAdvReportRsp;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "errMsg", "p", "Lcom/tencent/mobileqq/vas/adv/reward/data/VasRewardAdParams;", "e", "Lcom/tencent/mobileqq/vas/adv/reward/data/VasRewardAdParams;", "getRewardParams", "()Lcom/tencent/mobileqq/vas/adv/reward/data/VasRewardAdParams;", "setRewardParams", "(Lcom/tencent/mobileqq/vas/adv/reward/data/VasRewardAdParams;)V", "rewardParams", "Lcom/tencent/mobileqq/vas/adv/reward/callback/VasRewardAdCallback;", "Lcom/tencent/mobileqq/vas/adv/reward/callback/VasRewardAdCallback;", "getCallback", "()Lcom/tencent/mobileqq/vas/adv/reward/callback/VasRewardAdCallback;", IECSearchBar.METHOD_SET_CALLBACK, "(Lcom/tencent/mobileqq/vas/adv/reward/callback/VasRewardAdCallback;)V", "callback", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "deviceInfo", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "activityRef", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$RewardRspInfo;", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$RewardRspInfo;", "rewardRspInfo", "", "k", "[B", "requestBizBuff", "l", "reportBizBuff", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isAdConsumed", "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/vas/adv/reward/data/VasRewardAdParams;Lcom/tencent/mobileqq/vas/adv/reward/callback/VasRewardAdCallback;)V", DomainData.DOMAIN_NAME, "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class h extends d {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private VasRewardAdParams rewardParams;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private VasRewardAdCallback callback;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private qq_ad_get.QQAdGet.DeviceInfo deviceInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WeakReference<Activity> activityRef;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private qq_ad_get.QQAdGetRsp.AdInfo adInfo;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private vac_adv_get.RewardRspInfo rewardRspInfo;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private byte[] requestBizBuff;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private byte[] reportBizBuff;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isAdConsumed;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f435061a;

        static {
            int[] iArr = new int[VasAdvServiceCode.values().length];
            try {
                iArr[VasAdvServiceCode.SUCCEED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VasAdvServiceCode.CREATE_REQUEST_ERR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VasAdvServiceCode.CREATE_REPORT_ERR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VasAdvServiceCode.REQUEST_CMD_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[VasAdvServiceCode.REQUEST_RSP_PARSE_ERR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[VasAdvServiceCode.REQUEST_RSP_FAIL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[VasAdvServiceCode.REPORT_CMD_ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[VasAdvServiceCode.REPORT_RSP_PARSE_ERR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[VasAdvServiceCode.REPORT_RSP_FAIL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f435061a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"sz2/h$c", "Lsz2/a;", "", "profitable", "", "onResult", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.b f435062a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f435063b;

        c(d.b bVar, h hVar) {
            this.f435062a = bVar;
            this.f435063b = hVar;
        }

        @Override // sz2.a
        public void onResult(boolean profitable) {
            this.f435062a.a(true);
            if (QLog.isColorLevel()) {
                QLog.d("VasRewardAdService", 2, "showRewardAdv onResult profitable: " + profitable);
            }
            if (profitable) {
                this.f435063b.t();
            } else if (!profitable) {
                this.f435063b.z(4);
            }
        }
    }

    public h(@NotNull Activity activity, @NotNull VasRewardAdParams rewardParams, @NotNull VasRewardAdCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rewardParams, "rewardParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.rewardParams = rewardParams;
        this.callback = callback;
        this.activityRef = new WeakReference<>(activity);
        this.isAdConsumed = true;
    }

    private final int A(VasAdvServiceCode serviceCode) {
        switch (b.f435061a[serviceCode.ordinal()]) {
            case 1:
                return 0;
            case 2:
            case 3:
                return 5;
            case 4:
                return 2;
            case 5:
            case 6:
                return 6;
            case 7:
                return 3;
            case 8:
            case 9:
                return 7;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void B() {
        if (this.deviceInfo == null) {
            this.deviceInfo = k();
        }
    }

    private final a C(d.b showAdCallback) {
        return new c(showAdCallback, this);
    }

    private final void D(Activity activity, qq_ad_get.QQAdGetRsp.AdInfo adInfo, a profitableCallback, String rewardText, String bizSrc) {
        VasAdvSupport.INSTANCE.a().h(activity, adInfo, profitableCallback, rewardText, bizSrc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(int retCode) {
        if (QLog.isColorLevel()) {
            QLog.d("VasRewardAdService", 2, "callRewardResult retCode:" + retCode);
        }
        this.callback.onReward(retCode, this.requestBizBuff, this.reportBizBuff);
        this.isAdConsumed = true;
    }

    @Override // sz2.d
    protected boolean f() {
        B();
        if (this.rewardRspInfo != null) {
            return true;
        }
        return false;
    }

    @Override // sz2.d
    protected boolean g() {
        if (this.isAdConsumed) {
            B();
            this.adInfo = null;
            this.rewardRspInfo = null;
            this.requestBizBuff = null;
            this.reportBizBuff = null;
            this.isAdConsumed = false;
            return true;
        }
        z(9);
        return false;
    }

    @Override // sz2.d
    protected boolean h() {
        if (this.adInfo != null && this.rewardRspInfo != null) {
            return true;
        }
        z(1);
        return false;
    }

    @Override // sz2.d
    @NotNull
    protected adv_report.MobileAdvReportReq i() {
        adv_report.MobileAdvReportReq mobileAdvReportReq = new adv_report.MobileAdvReportReq();
        mobileAdvReportReq.f308016qq.set(this.rewardParams.getUin());
        mobileAdvReportReq.adv_pos.set(this.rewardParams.getAdvPos());
        qq_ad_get.QQAdGet.DeviceInfo deviceInfo = mobileAdvReportReq.device_info;
        qq_ad_get.QQAdGet.DeviceInfo deviceInfo2 = this.deviceInfo;
        if (deviceInfo2 != null) {
            deviceInfo.set(deviceInfo2);
            mobileAdvReportReq.action_type.set(4);
            adv_report.RewardReportInfo rewardReportInfo = mobileAdvReportReq.reward_report_info;
            adv_report.RewardReportInfo rewardReportInfo2 = new adv_report.RewardReportInfo();
            rewardReportInfo2.reward_type.set(this.rewardParams.getRewardType());
            rewardReportInfo2.reward_item.set(ByteStringMicro.copyFromUtf8(this.rewardParams.getRewardItem()));
            vac_adv_get.RewardRspInfo rewardRspInfo = this.rewardRspInfo;
            if (rewardRspInfo != null) {
                rewardReportInfo2.time.set(rewardRspInfo.time.get());
                rewardReportInfo2.nonce.set(rewardRspInfo.nonce.get());
                rewardReportInfo2.signature.set(rewardRspInfo.signature.get());
            }
            rewardReportInfo.set(rewardReportInfo2);
            return mobileAdvReportReq;
        }
        throw new IllegalArgumentException("device info is null, report ad abort");
    }

    @Override // sz2.d
    @NotNull
    protected vac_adv_get.VacAdvReq j() {
        vac_adv_get.VacAdvReq vacAdvReq = new vac_adv_get.VacAdvReq();
        vacAdvReq.f308018qq.set(this.rewardParams.getUin());
        vacAdvReq.adv_pos.set(this.rewardParams.getAdvPos());
        vacAdvReq.client_mod.set(vz2.d.f443778a.a());
        qq_ad_get.QQAdGet.DeviceInfo deviceInfo = vacAdvReq.device_info;
        qq_ad_get.QQAdGet.DeviceInfo deviceInfo2 = this.deviceInfo;
        if (deviceInfo2 != null) {
            deviceInfo.set(deviceInfo2);
            vac_adv_get.RewardReqInfo rewardReqInfo = vacAdvReq.reward_req_info;
            vac_adv_get.RewardReqInfo rewardReqInfo2 = new vac_adv_get.RewardReqInfo();
            rewardReqInfo2.reward_type.set(this.rewardParams.getRewardType());
            rewardReqInfo2.reward_item.set(ByteStringMicro.copyFromUtf8(this.rewardParams.getRewardItem()));
            rewardReqInfo.set(rewardReqInfo2);
            return vacAdvReq;
        }
        throw new IllegalArgumentException("device info is null, request ad abort");
    }

    @Override // sz2.d
    protected void p(@NotNull VasAdvServiceCode serviceCode, @NotNull String errMsg) {
        Intrinsics.checkNotNullParameter(serviceCode, "serviceCode");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        z(A(serviceCode));
        if (QLog.isColorLevel()) {
            QLog.d("VasRewardAdService", 2, "onError errMsg:" + errMsg);
        }
    }

    @Override // sz2.d
    protected void q(@NotNull adv_report.MobileAdvReportRsp rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        this.reportBizBuff = rsp.busi_buffer.get().toByteArray();
        z(0);
    }

    @Override // sz2.d
    protected void r(@NotNull vac_adv_get.VacAdvRsp rsp) {
        Object firstOrNull;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        List<vac_adv_get.VacAdvMetaMsg> list = rsp.vac_adv_msgs.get();
        Intrinsics.checkNotNullExpressionValue(list, "rsp.vac_adv_msgs.get()");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
        vac_adv_get.VacAdvMetaMsg vacAdvMetaMsg = (vac_adv_get.VacAdvMetaMsg) firstOrNull;
        if (vacAdvMetaMsg != null) {
            adInfo = vacAdvMetaMsg.adv_rsp;
        } else {
            adInfo = null;
        }
        this.adInfo = adInfo;
        this.rewardRspInfo = rsp.reward_rsp_info;
        this.requestBizBuff = rsp.busi_buffer.get().toByteArray();
        x();
    }

    @Override // sz2.d
    protected void s(@NotNull d.b showAdCallback) {
        Intrinsics.checkNotNullParameter(showAdCallback, "showAdCallback");
        a C = C(showAdCallback);
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = this.adInfo;
        if (adInfo != null) {
            Activity activity = this.activityRef.get();
            if (activity != null) {
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                D(activity, adInfo, C, this.rewardParams.getRewardText(), this.rewardParams.getBizSrcId());
            } else {
                activity = null;
            }
            if (activity == null) {
                showAdCallback.a(false);
                z(8);
                return;
            }
            return;
        }
        showAdCallback.a(false);
        z(1);
    }
}
