package ub3;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import zb3.ZootopiaBannerItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J \u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J,\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u0004\u001a\u00020\u0002J\u001e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012\u00a8\u0006\u0017"}, d2 = {"Lub3/d;", "", "", "adId", "needCnt", "", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", "d", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "Lzb3/c;", "e", "Lkotlin/Function1;", "", "callback", "g", "advId", "actionId", "", "triggerInfo", "f", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f438772a = new d();

    d() {
    }

    private final List<TianShuAdPosItemData> d(int adId, int needCnt) {
        ArrayList arrayList = new ArrayList();
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mNeedCnt = needCnt;
        tianShuAdPosItemData.mPosId = adId;
        arrayList.add(tianShuAdPosItemData);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(int i3, int i16, final Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).requestAdv(f438772a.d(i3, i16), new TianShuGetAdvCallback() { // from class: ub3.b
            @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
            public final void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
                d.j(Function1.this, z16, getAdsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final Function1 callback, boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.i("ZootopiaTianShuAdManager", 1, "sendZootopiaAdRequest result:" + z16 + ", getAdsRsp:" + getAdsRsp);
        d dVar = f438772a;
        Intrinsics.checkNotNullExpressionValue(getAdsRsp, "getAdsRsp");
        final zb3.c e16 = dVar.e(getAdsRsp);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ub3.c
            @Override // java.lang.Runnable
            public final void run() {
                d.k(Function1.this, e16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 callback, zb3.c data) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(data, "$data");
        callback.invoke(data);
    }

    public final void f(int advId, int actionId, String triggerInfo) {
        Intrinsics.checkNotNullParameter(triggerInfo, "triggerInfo");
        TianShuReportData tianShuReportData = new TianShuReportData();
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        tianShuReportData.mToUid = account;
        tianShuReportData.mAppId = "tianshu.271";
        tianShuReportData.mPageId = "tianshu.271";
        tianShuReportData.mTraceId = account + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mModuleId = "1";
        tianShuReportData.mItemId = String.valueOf(advId);
        tianShuReportData.mOperTime = serverTimeMillis;
        tianShuReportData.mActionId = actionId;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mTriggerInfo = triggerInfo;
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
    }

    public final void g(final int adId, final Function1<? super zb3.c, Unit> callback, final int needCnt) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.excute(new Runnable() { // from class: ub3.a
            @Override // java.lang.Runnable
            public final void run() {
                d.i(adId, needCnt, callback);
            }
        }, 128, null, false);
    }

    private final zb3.c e(TianShuAccess.GetAdsRsp getAdsRsp) {
        Integer intOrNull;
        Integer intOrNull2;
        zb3.c cVar = new zb3.c(0, null, 3, null);
        if (getAdsRsp.code.get() != 0 || getAdsRsp.mapAds.isEmpty() || getAdsRsp.mapAds.size() <= 0) {
            return cVar;
        }
        TianShuAccess.RspEntry rspEntry = getAdsRsp.mapAds.get(0);
        int i3 = rspEntry.key.get();
        TianShuAccess.AdPlacementInfo adPlacementInfo = rspEntry.value.get();
        ArrayList arrayList = new ArrayList();
        for (TianShuAccess.AdItem adItem : adPlacementInfo.lst.get()) {
            List<TianShuAccess.MapEntry> list = adItem.argList.get();
            ZootopiaBannerItem zootopiaBannerItem = new ZootopiaBannerItem(0, null, null, false, 0, null, null, 0, 255, null);
            zootopiaBannerItem.n(adItem.iAdId.get());
            String str = adItem.traceinfo.get();
            Intrinsics.checkNotNullExpressionValue(str, "adItem.traceinfo.get()");
            zootopiaBannerItem.r(str);
            for (TianShuAccess.MapEntry mapEntry : list) {
                String str2 = mapEntry.key.get();
                if (str2 != null) {
                    switch (str2.hashCode()) {
                        case -1255161247:
                            if (str2.equals(WadlProxyConsts.KEY_JUMP_URL)) {
                                String str3 = mapEntry.value.get();
                                Intrinsics.checkNotNullExpressionValue(str3, "arg.value.get()");
                                zootopiaBannerItem.o(str3);
                                break;
                            } else {
                                break;
                            }
                        case -1180685742:
                            if (str2.equals("isAPNG")) {
                                String str4 = mapEntry.value.get();
                                zootopiaBannerItem.m(str4 != null ? Boolean.parseBoolean(str4) : false);
                                break;
                            } else {
                                break;
                            }
                        case -618653741:
                            if (str2.equals("videoCoverUrl")) {
                                String str5 = mapEntry.value.get();
                                Intrinsics.checkNotNullExpressionValue(str5, "arg.value.get()");
                                zootopiaBannerItem.q(str5);
                                break;
                            } else {
                                break;
                            }
                        case 3575610:
                            if (str2.equals("type")) {
                                String str6 = mapEntry.value.get();
                                Intrinsics.checkNotNullExpressionValue(str6, "arg.value.get()");
                                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str6);
                                zootopiaBannerItem.s(intOrNull != null ? intOrNull.intValue() : -1);
                                break;
                            } else {
                                break;
                            }
                        case 1151378164:
                            if (str2.equals(AppConstants.Key.KEY_QZONE_VIDEO_URL)) {
                                String str7 = mapEntry.value.get();
                                Intrinsics.checkNotNullExpressionValue(str7, "arg.value.get()");
                                zootopiaBannerItem.t(str7);
                                break;
                            } else {
                                break;
                            }
                        case 1234288984:
                            if (str2.equals("orderNum")) {
                                String str8 = mapEntry.value.get();
                                Intrinsics.checkNotNullExpressionValue(str8, "arg.value.get()");
                                intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(str8);
                                zootopiaBannerItem.p(intOrNull2 != null ? intOrNull2.intValue() : -1);
                                break;
                            } else {
                                break;
                            }
                    }
                }
            }
            arrayList.add(zootopiaBannerItem);
        }
        CollectionsKt__MutableCollectionsJVMKt.sort(arrayList);
        if (arrayList.size() == 0) {
            QLog.e("ZootopiaTianShuAdManager", 1, "empty ad:" + i3);
            return cVar;
        }
        zb3.c cVar2 = new zb3.c(i3, arrayList);
        QLog.d("ZootopiaTianShuAdManager", 1, "ad(" + i3 + "):" + cVar2);
        return cVar2;
    }

    public static /* synthetic */ void h(d dVar, int i3, Function1 function1, int i16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i16 = 1;
        }
        dVar.g(i3, function1, i16);
    }
}
