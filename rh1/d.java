package rh1;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J8\u0010\u0011\u001a\u00020\u00102\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u000bH\u0002J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\u0006\u0010\u0015\u001a\u00020\u0014J.\u0010\u0018\u001a\u00020\u00172\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lrh1/d;", "", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "g", "", "", "invalidAIdList", "Ltencent/gdt/qq_ad_get$QQAdGet$ContextInfo$InvalidLastAds$Ad;", h.F, "", QZoneDTLoginReporter.SCHEMA, "", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "", "isContractAd", "adCount", "Ltencent/gdt/access$AdGetReq;", "c", "j", "i", "", "l", "schemaSource", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "f", "b", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "mDeviceInfo", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f431454a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static qq_ad_get.QQAdGet.DeviceInfo mDeviceInfo;

    d() {
    }

    private final access.AdGetReq c(List<qq_ad_get.QQAdGet.ContextInfo.InvalidLastAds.Ad> invalidAIdList, String schema, int busiType, boolean isContractAd, int adCount) {
        access.AdGetReq adGetReq = new access.AdGetReq();
        qq_ad_get.QQAdGet qQAdGet = new qq_ad_get.QQAdGet();
        try {
            adGetReq.busi_type.set(busiType);
            adGetReq.client_mod.set(i());
            adGetReq.schema_source.set(schema);
            qq_ad_get.QQAdGet.PositionInfo positionInfo = new qq_ad_get.QQAdGet.PositionInfo();
            positionInfo.pos_id.set(k(this, busiType, false, 2, null));
            positionInfo.ad_count.set(adCount);
            qq_ad_get.QQAdGet.PositionInfo.PositionExt positionExt = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
            positionExt.deep_link_version.set(1);
            positionInfo.pos_ext.set(positionExt);
            qQAdGet.position_info.add(positionInfo);
            if (isContractAd) {
                qq_ad_get.QQAdGet.PositionInfo positionInfo2 = new qq_ad_get.QQAdGet.PositionInfo();
                positionInfo2.pos_id.set(j(busiType, isContractAd));
                positionInfo2.ad_count.set(adCount);
                positionInfo2.pos_ext.set(positionExt);
                qQAdGet.position_info.add(positionInfo2);
            }
            qq_ad_get.QQAdGet.DeviceInfo deviceInfo = mDeviceInfo;
            if (deviceInfo != null) {
                qQAdGet.device_info.set(deviceInfo);
            }
            qq_ad_get.QQAdGet.ContextInfo contextInfo = new qq_ad_get.QQAdGet.ContextInfo();
            qq_ad_get.QQAdGet.ContextInfo.InvalidLastAds invalidLastAds = new qq_ad_get.QQAdGet.ContextInfo.InvalidLastAds();
            invalidLastAds.ads.set(invalidAIdList);
            contextInfo.invalid_last_ads.set(invalidLastAds);
            qQAdGet.context_info.set(contextInfo);
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: rh1.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.e();
                }
            });
            qQAdGet.support_https.set(true);
        } catch (Throwable th5) {
            QLog.e("GuildDiscAdUtils", 1, "create ad req failed", th5);
        }
        adGetReq.qq_ad_get.set(qQAdGet);
        return adGetReq;
    }

    static /* synthetic */ access.AdGetReq d(d dVar, List list, String str, int i3, boolean z16, int i16, int i17, Object obj) {
        if ((i17 & 16) != 0) {
            i16 = 1;
        }
        return dVar.c(list, str, i3, z16, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e() {
        mDeviceInfo = f431454a.g();
    }

    private final qq_ad_get.QQAdGet.DeviceInfo g() {
        try {
            GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(RFWApplication.getApplication(), new GdtDeviceInfoHelper.Params());
            if (create != null) {
                QLog.d("GuildDiscAdUtils", 2, "gdt device info init success");
                return create.deviceInfo;
            }
            return null;
        } catch (Exception e16) {
            QLog.e("GuildDiscAdUtils", 1, "Error when get gdt device info", e16);
            return null;
        }
    }

    private final List<qq_ad_get.QQAdGet.ContextInfo.InvalidLastAds.Ad> h(List<Long> invalidAIdList) {
        List<qq_ad_get.QQAdGet.ContextInfo.InvalidLastAds.Ad> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new qq_ad_get.QQAdGet.ContextInfo.InvalidLastAds.Ad());
        Iterator<Long> it = invalidAIdList.iterator();
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            qq_ad_get.QQAdGet.ContextInfo.InvalidLastAds.Ad ad5 = new qq_ad_get.QQAdGet.ContextInfo.InvalidLastAds.Ad();
            ad5.adgroup_id.set(longValue);
            mutableListOf.add(ad5);
        }
        return mutableListOf;
    }

    private final String i() {
        String str;
        if (SimpleUIUtil.isNowElderMode()) {
            str = PlatformInfor.ELDER_MODE;
        } else {
            str = "default";
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return "teenager";
        }
        return str;
    }

    private final String j(int busiType, boolean isContractAd) {
        if (isContractAd) {
            if (busiType == 81) {
                return "3152067232881042";
            }
            return "5192065282484014";
        }
        if (busiType == 81) {
            return "7182430672214746";
        }
        return "1132333652016246";
    }

    static /* synthetic */ String k(d dVar, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        return dVar.j(i3, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m() {
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).initGdtContext(RFWApplication.getApplication(), new InitGdtContextParams());
        mDeviceInfo = f431454a.g();
    }

    @NotNull
    public final ByteStringMicro f(@NotNull List<Long> invalidAIdList, @NotNull String schemaSource, int busiType, boolean isContractAd) {
        Intrinsics.checkNotNullParameter(invalidAIdList, "invalidAIdList");
        Intrinsics.checkNotNullParameter(schemaSource, "schemaSource");
        ByteStringMicro copyFrom = ByteStringMicro.copyFrom(d(this, h(invalidAIdList), schemaSource, busiType, isContractAd, 0, 16, null).toByteArray());
        Intrinsics.checkNotNullExpressionValue(copyFrom, "copyFrom(createAdReq(get\u2026ontractAd).toByteArray())");
        return copyFrom;
    }

    public final void l() {
        QLog.d("GuildDiscAdUtils", 1, "initDeviceInfo");
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: rh1.b
            @Override // java.lang.Runnable
            public final void run() {
                d.m();
            }
        });
    }
}
