package uj1;

import android.view.View;
import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0012\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b6\u00107J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J4\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J>\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012H\u0002JZ\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u001b2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012H\u0002J$\u0010 \u001a\u00020\u00192\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J\u0006\u0010!\u001a\u00020\u0019J\u0016\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010%\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rJ*\u0010'\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0012J*\u0010(\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0012J2\u0010*\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u00062\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0012J2\u0010+\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0012JF\u0010,\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u001b2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0012J\u001a\u0010-\u001a\u00020\u00192\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0012J\u001a\u0010.\u001a\u00020\u00192\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0012J\u001a\u0010/\u001a\u00020\u00192\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0012J\u0010\u00102\u001a\u0004\u0018\u00010\r2\u0006\u00101\u001a\u000200R\u0018\u00105\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u00068"}, d2 = {"Luj1/d;", "", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "p", "", QZoneDTLoginReporter.SCHEMA, "", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "adCount", "Ltencent/gdt/access$AdGetReq;", "c", "t", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/gdtad/aditem/GdtAd;", "ad", "pageId", "rank", "channelId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/View;", ParseCommon.CONTAINER, "elementId", "eventKey", "dtReportParams", "", "f", "", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "g", "reportMap", "actionId", h.F, "u", "schemaSource", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", DomainData.DOMAIN_NAME, "o", "params", "i", "j", "feedbackType", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "y", "w", HippyTKDListViewAdapter.X, "", "adByteArray", "r", "b", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "mDeviceInfo", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f439072a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static qq_ad_get.QQAdGet.DeviceInfo mDeviceInfo;

    d() {
    }

    private final access.AdGetReq c(String schema, int busiType, int adCount) {
        access.AdGetReq adGetReq = new access.AdGetReq();
        qq_ad_get.QQAdGet qQAdGet = new qq_ad_get.QQAdGet();
        try {
            adGetReq.busi_type.set(busiType);
            adGetReq.client_mod.set(s());
            adGetReq.schema_source.set(schema);
            qq_ad_get.QQAdGet.PositionInfo positionInfo = new qq_ad_get.QQAdGet.PositionInfo();
            positionInfo.pos_id.set(t(busiType));
            positionInfo.ad_count.set(adCount);
            qq_ad_get.QQAdGet.PositionInfo.PositionExt positionExt = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
            positionExt.deep_link_version.set(1);
            positionInfo.pos_ext.set(positionExt);
            qQAdGet.position_info.add(positionInfo);
            qq_ad_get.QQAdGet.DeviceInfo deviceInfo = mDeviceInfo;
            if (deviceInfo != null) {
                qQAdGet.device_info.set(deviceInfo);
            }
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: uj1.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.e();
                }
            });
            qQAdGet.support_https.set(true);
        } catch (Throwable th5) {
            QLog.e("GuildFeedAdUtils", 1, "create ad req failed", th5);
        }
        adGetReq.qq_ad_get.set(qQAdGet);
        return adGetReq;
    }

    static /* synthetic */ access.AdGetReq d(d dVar, String str, int i3, int i16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i16 = 1;
        }
        return dVar.c(str, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e() {
        mDeviceInfo = f439072a.p();
    }

    private final void f(View container, GdtAd ad5, String elementId, String eventKey, Map<String, String> dtReportParams) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (dtReportParams != null) {
            linkedHashMap.putAll(dtReportParams);
        }
        linkedHashMap.put("sgrp_ad_id", String.valueOf(ad5.getAId()));
        String traceId = ad5.getTraceId();
        if (traceId == null) {
            traceId = "";
        }
        linkedHashMap.put("sgrp_ad_trace_id", traceId);
        linkedHashMap.put("sgrp_ad_content_type", Integer.valueOf(o(ad5)));
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(container, elementId, eventKey, linkedHashMap);
    }

    private final void g(View container, GdtAd ad5, String pageId, Map<String, ? extends Object> pageParams, String elementId, String eventKey, Map<String, String> dtReportParams) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (dtReportParams != null) {
            linkedHashMap.putAll(dtReportParams);
        }
        linkedHashMap.put("sgrp_ad_id", String.valueOf(ad5.getAId()));
        String traceId = ad5.getTraceId();
        if (traceId == null) {
            traceId = "";
        }
        linkedHashMap.put("sgrp_ad_trace_id", traceId);
        linkedHashMap.put("sgrp_ad_content_type", Integer.valueOf(o(ad5)));
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(container, elementId, pageId, "", eventKey, linkedHashMap, pageParams);
    }

    private final void h(Map<String, String> reportMap, int actionId) {
        String str = reportMap.get("ad_id");
        if (str == null) {
            str = "";
        }
        String str2 = reportMap.get("trace_info");
        if (str2 == null) {
            str2 = "";
        }
        String str3 = reportMap.get("trace_id");
        if (str3 == null) {
            str3 = "";
        }
        String str4 = reportMap.get("guild_id");
        if (str4 == null) {
            str4 = "";
        }
        String str5 = reportMap.get(INetChannelCallback.KEY_TINY_ID);
        if (str5 == null) {
            str5 = "";
        }
        QLog.d("GuildFeedAdUtils", 1, "reportTianShu traceId=" + str3 + ",guildId=" + str4 + ",tinyId=" + str5 + ",actionId=" + actionId);
        TianShuReportData tianShuReportData = new TianShuReportData();
        tianShuReportData.mAppId = "tianshu.269";
        tianShuReportData.mAdSpace = 1462;
        tianShuReportData.mActionId = actionId;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mTraceId = str3;
        tianShuReportData.mItemId = str;
        tianShuReportData.mTriggerInfo = str2;
        tianShuReportData.mOperTime = NetConnInfoCenter.getServerTime();
        tianShuReportData.mModuleId = "";
        tianShuReportData.mPageId = "tianshu.269";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("channel_id", str4);
            jSONObject.put("channel_owner_uin", str5);
            tianShuReportData.mBusiInfo = jSONObject.toString();
        } catch (JSONException e16) {
            QLog.e("GuildFeedAdUtils", 1, "reportTianShu exception", e16);
        }
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
    }

    private final qq_ad_get.QQAdGet.DeviceInfo p() {
        try {
            GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(RFWApplication.getApplication(), new GdtDeviceInfoHelper.Params());
            if (create != null) {
                QLog.d("GuildFeedAdUtils", 2, "gdt device info init success");
                return create.deviceInfo;
            }
            return null;
        } catch (Exception e16) {
            QLog.e("GuildFeedAdUtils", 1, "Error when get gdt device info", e16);
            return null;
        }
    }

    private final Map<String, String> q(GdtAd ad5, String pageId, String rank, String channelId) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sgrp_eid", "em_sgrp_feed_section_ad");
        String traceId = ad5.getTraceId();
        String str = "";
        if (traceId == null) {
            traceId = "";
        }
        linkedHashMap.put(JumpGuildParam.EXTRA_KEY_TRACE_ID, traceId);
        linkedHashMap.put("sgrp_rank", rank);
        linkedHashMap.put("sgrp_video_id", String.valueOf(ad5.getAId()));
        linkedHashMap.put("sgrp_channel_id", channelId);
        String traceId2 = ad5.getTraceId();
        if (traceId2 != null) {
            str = traceId2;
        }
        linkedHashMap.put(DTParamKey.REPORT_KEY_VIDEO_CONTENTID, str);
        linkedHashMap.put(DTParamKey.REPORT_KEY_VIDEO_CONTENT_TYPE, "1");
        linkedHashMap.put(DTParamKey.REPORT_KEY_VIDEO_LENGTH, String.valueOf(ad5.getVideoDuration()));
        linkedHashMap.put("dt_pgid", pageId);
        return linkedHashMap;
    }

    private final String s() {
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

    private final String t(int busiType) {
        if (busiType == 79) {
            return "5121394530341950";
        }
        return "4151694500957883";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v() {
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).initGdtContext(RFWApplication.getApplication(), new InitGdtContextParams());
        mDeviceInfo = f439072a.p();
    }

    public final void i(@NotNull View container, @NotNull GdtAd ad5, @NotNull Map<String, String> params) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(ad5, "ad");
        Intrinsics.checkNotNullParameter(params, "params");
        f(container, ad5, "em_sgrp_feed_section_ad", "clck", params);
    }

    public final void j(@NotNull View container, @NotNull GdtAd ad5, @NotNull Map<String, String> params) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(ad5, "ad");
        Intrinsics.checkNotNullParameter(params, "params");
        f(container, ad5, "em_sgrp_feed_section_ad_feedback", "clck", params);
        f(container, ad5, "em_sgrp_feed_section_ad_feedback_float", "imp", params);
    }

    public final void k(@NotNull View container, @NotNull GdtAd ad5, int feedbackType, @NotNull Map<String, String> params) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(ad5, "ad");
        Intrinsics.checkNotNullParameter(params, "params");
        params.put("sgrp_btn_type", String.valueOf(feedbackType));
        f(container, ad5, "em_sgrp_feed_section_ad_feedback_float", "clck", params);
    }

    public final void l(@NotNull View container, @NotNull GdtAd ad5, @NotNull String pageId, @NotNull Map<String, ? extends Object> pageParams, @NotNull Map<String, String> params) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(ad5, "ad");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(pageParams, "pageParams");
        Intrinsics.checkNotNullParameter(params, "params");
        String str = params.get("guild_id");
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String str3 = params.get("sgrp_rank");
        if (str3 != null) {
            str2 = str3;
        }
        g(container, ad5, pageId, pageParams, "em_sgrp_feed_section_ad", "dt_video_end", q(ad5, pageId, str2, str));
    }

    public final void m(@NotNull View container, @NotNull GdtAd ad5, @NotNull String pageId, @NotNull Map<String, String> params) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(ad5, "ad");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(params, "params");
        String str = params.get("guild_id");
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String str3 = params.get("sgrp_rank");
        if (str3 != null) {
            str2 = str3;
        }
        f(container, ad5, "em_sgrp_feed_section_ad", "dt_video_start", q(ad5, pageId, str2, str));
    }

    @NotNull
    public final ByteStringMicro n(@NotNull String schemaSource, int busiType) {
        Intrinsics.checkNotNullParameter(schemaSource, "schemaSource");
        ByteStringMicro copyFrom = ByteStringMicro.copyFrom(d(this, schemaSource, busiType, 0, 4, null).toByteArray());
        Intrinsics.checkNotNullExpressionValue(copyFrom, "copyFrom(createAdReq(sch\u2026 busiType).toByteArray())");
        return copyFrom;
    }

    public final int o(@NotNull GdtAd ad5) {
        Intrinsics.checkNotNullParameter(ad5, "ad");
        if (ad5.getInnerShowType() != 3 && ad5.getInnerShowType() != 4) {
            return 1;
        }
        return 2;
    }

    @Nullable
    public final GdtAd r(@NotNull byte[] adByteArray) {
        Intrinsics.checkNotNullParameter(adByteArray, "adByteArray");
        try {
            qq_ad_get.QQAdGetRsp.AdInfo adInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
            adInfo.mergeFrom(adByteArray);
            return new GdtAd(adInfo);
        } catch (Exception e16) {
            QLog.d("GuildFeedAdUtils", 1, "parse adInfo error: " + e16);
            return null;
        }
    }

    public final void u() {
        QLog.d("GuildFeedAdUtils", 1, "GuildFeedAd initDeviceInfo");
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: uj1.b
            @Override // java.lang.Runnable
            public final void run() {
                d.v();
            }
        });
    }

    public final void w(@NotNull Map<String, String> reportMap) {
        Intrinsics.checkNotNullParameter(reportMap, "reportMap");
        h(reportMap, 102);
    }

    public final void x(@NotNull Map<String, String> reportMap) {
        Intrinsics.checkNotNullParameter(reportMap, "reportMap");
        h(reportMap, 122);
    }

    public final void y(@NotNull Map<String, String> reportMap) {
        Intrinsics.checkNotNullParameter(reportMap, "reportMap");
        h(reportMap, 101);
    }
}
