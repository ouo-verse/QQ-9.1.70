package z5;

import NS_CLIENT_SHOW_ALL_INFO.AllInfo;
import NS_COMM_VIP_GROWTH.IconInfo;
import NS_COMM_VIP_GROWTH.SearchClientShowInfoRsp;
import NS_COMM_VIP_GROWTH.UserClientShowInfo;
import NS_MOBILE_COMM.combine_diamond_info;
import NS_MOBILE_COMM.star_info;
import NS_MOBILE_FEEDS.FunnySpace;
import NS_MOBILE_MAIN_PAGE.mobile_main_page_req;
import NS_MOBILE_MAIN_PAGE.mobile_main_page_rsp;
import NS_MOBILE_MAIN_PAGE.mobile_sub_del_friendreq_rsp;
import NS_MOBILE_MAIN_PAGE.mobile_sub_setspecial_rsp;
import NS_MOBILE_MAIN_PAGE.s_part_error;
import NS_MOBILE_MAIN_PAGE.s_profile;
import NS_MOBILE_MAIN_PAGE.s_space_event;
import NS_MOBILE_MATERIAL.material_report_rsp;
import SWEET_NEW_BASE.sweet_rsp_comm;
import SWEET_NEW_COMM_SVR.guest_mainpage_rsp;
import SWEET_NEW_PRIVILEGE.sweet_style_info_item;
import android.os.Handler;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.EventCenter;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.component.cache.database.c;
import com.qzone.cover.business.protocol.QzoneReportCustomBannerRequest;
import com.qzone.detail.business.protocol.QZoneMobileSetVisitreqReq;
import com.qzone.homepage.business.protocol.QZoneAnswerQuestionRequest;
import com.qzone.homepage.business.protocol.QZoneDelVisitorRequest;
import com.qzone.homepage.business.protocol.QZoneGetUserInfoRequest;
import com.qzone.homepage.business.protocol.QZoneInviteOpenUpRequest;
import com.qzone.homepage.business.protocol.QZoneSetSpecialCareRequest;
import com.qzone.proxy.personalitycomponent.manager.QzoneWidgetService;
import com.qzone.proxy.personalitycomponent.model.KapuEventDbCacheData;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheQzoneVipData;
import com.qzone.proxy.vipcomponent.IVipComponentService;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.util.al;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasAdv;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.MapUtil;
import cooperation.vip.manager.MonitorManager;
import cooperation.vip.vipcomponent.util.a;
import java.util.ArrayList;
import java.util.Map;
import n7.a;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a implements IQZoneServiceListener {

    /* renamed from: e, reason: collision with root package name */
    private static final al<a, Void> f451931e = new C11652a();

    /* renamed from: d, reason: collision with root package name */
    private final b f451932d = new b("user_info");

    /* compiled from: P */
    /* renamed from: z5.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    class C11652a extends al<a, Void> {
        C11652a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(Void r16) {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        long f451933a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f451934b;

        /* renamed from: c, reason: collision with root package name */
        String f451935c;

        /* renamed from: d, reason: collision with root package name */
        a.InterfaceC10828a f451936d = new C11653a();

        /* compiled from: P */
        /* renamed from: z5.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes36.dex */
        class C11653a implements a.InterfaceC10828a {
            C11653a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                b bVar = b.this;
                bVar.f451933a = 0L;
                bVar.f451934b = null;
            }
        }

        public b(String str) {
            this.f451935c = str;
        }
    }

    public static a f() {
        return f451931e.get(null);
    }

    private void u(long j3, Handler handler, int i3, int i16) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneSetSpecialCareRequest(j3, i3), handler, this, i16));
    }

    private void w(WidgetCacheQzoneVipData widgetCacheQzoneVipData) {
        int i3;
        if (widgetCacheQzoneVipData.isVip) {
            i3 = widgetCacheQzoneVipData.isSuperVip ? 2 : 1;
        } else {
            i3 = 0;
        }
        star_info star_infoVar = new star_info(widgetCacheQzoneVipData.starVipStatus, widgetCacheQzoneVipData.starVipLevel, widgetCacheQzoneVipData.isStarAnnualVip ? (byte) 1 : (byte) 0, widgetCacheQzoneVipData.isHighStarVip ? (byte) 1 : (byte) 0);
        combine_diamond_info combine_diamond_infoVar = new combine_diamond_info(widgetCacheQzoneVipData.comVipType, widgetCacheQzoneVipData.comViplevel, widgetCacheQzoneVipData.isComAnnualVip ? (byte) 1 : (byte) 0, widgetCacheQzoneVipData.isComAnnualVipEver ? (byte) 1 : (byte) 0);
        VipComponentProxy vipComponentProxy = VipComponentProxy.f50997g;
        vipComponentProxy.getServiceInterface().updateVipInfo(String.valueOf(widgetCacheQzoneVipData.uin), i3, widgetCacheQzoneVipData.vipLevel, widgetCacheQzoneVipData.isAnnualVip != 0, star_infoVar, combine_diamond_infoVar, widgetCacheQzoneVipData.personalizedYellowVipUrl, true);
        vipComponentProxy.getServiceInterface().updateVipInfoDiamondUrl(String.valueOf(widgetCacheQzoneVipData.uin), widgetCacheQzoneVipData.isCustomDiamondUser, widgetCacheQzoneVipData.customDiamondUrl);
    }

    public void b(long j3, long j16, String str, String str2, Handler handler) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneAnswerQuestionRequest(j3, j16, str, str2), handler, this, 10));
    }

    public void c(long j3, String str, Handler handler) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneMobileSetVisitreqReq(0, j3, str), handler, this, 13));
    }

    public x6.a g(long j3) {
        synchronized (this.f451932d) {
            e(this.f451932d);
            DbCacheManager dbCacheManager = this.f451932d.f451934b;
            if (dbCacheManager == null) {
                return null;
            }
            return (x6.a) dbCacheManager.k0("uin=?", new String[]{x6.a.encryptUin(j3)});
        }
    }

    public void h(long j3, long j16, Handler handler) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneInviteOpenUpRequest(j3, j16), handler, this, 11));
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        int i3 = qZoneTask.mType;
        if (i3 == 2) {
            n(qZoneTask);
            return;
        }
        if (i3 == 6) {
            k(qZoneTask);
            return;
        }
        if (i3 == 10) {
            i(qZoneTask);
            return;
        }
        if (i3 != 11) {
            switch (i3) {
                case 13:
                    if (QZLog.isDevelopLevel()) {
                        QZLog.d("access_apply", 4, qZoneTask.f45835msg);
                    }
                    j(qZoneTask);
                    return;
                case 14:
                    l(qZoneTask);
                    return;
                case 15:
                case 16:
                    p(qZoneTask);
                    return;
                case 17:
                    o(qZoneTask);
                    return;
                default:
                    return;
            }
        }
        m(qZoneTask);
    }

    public void r(long j3, Handler handler, String str) {
        Map<Integer, Long> stringToMap = MapUtil.stringToMap(u5.b.h0("qzone_bar_time_stamp" + LoginData.getInstance().getUin(), ""));
        if (!stringToMap.containsKey(22)) {
            stringToMap.put(22, 0L);
        }
        if (!stringToMap.containsKey(25)) {
            stringToMap.put(25, 0L);
        }
        if (!stringToMap.containsKey(28)) {
            stringToMap.put(28, 0L);
        }
        stringToMap.put(40, Long.valueOf(u5.b.K("photo_red_dot_sp" + j3, QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_VISIT_GUEST_ALBUM_TIME, QzoneConfig.DefaultValue.DEFAULT_VISIT_GUEST_ALBUM_TIME), LoginData.getInstance().getUin())));
        QZoneGetUserInfoRequest qZoneGetUserInfoRequest = new QZoneGetUserInfoRequest(LoginData.getInstance().getUin(), j3, stringToMap);
        if (str != null) {
            qZoneGetUserInfoRequest.setRefer(str);
        }
        ((IVasAdv) QRoute.api(IVasAdv.class)).requestQzoneWidget();
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(qZoneGetUserInfoRequest, handler, this, 2));
    }

    public void s(Handler handler, long j3, String str, int i3, int i16, int i17) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneReportCustomBannerRequest(j3, i3, i16, i17, str), handler, this, 17));
    }

    public void t(x6.a aVar) {
        synchronized (this.f451932d) {
            e(this.f451932d);
            DbCacheManager dbCacheManager = this.f451932d.f451934b;
            if (dbCacheManager == null) {
                return;
            }
            dbCacheManager.o0(aVar, 1);
        }
    }

    public void q(long j3, Handler handler) {
        r(j3, handler, null);
    }

    private void p(QZoneTask qZoneTask) {
        if (qZoneTask == null || qZoneTask.mRequest == null) {
            return;
        }
        QZoneResult result = qZoneTask.getResult(1000116);
        mobile_sub_setspecial_rsp mobile_sub_setspecial_rspVar = (mobile_sub_setspecial_rsp) qZoneTask.mRequest.rsp;
        if (mobile_sub_setspecial_rspVar != null) {
            result.setSucceed(mobile_sub_setspecial_rspVar.ret == 0);
            result.setReturnCode(mobile_sub_setspecial_rspVar.ret);
            result.setData(Integer.valueOf(mobile_sub_setspecial_rspVar.carestatus));
        }
        qZoneTask.sendResultMsg(result);
    }

    public void d(long j3, long j16, byte b16, long j17, byte b17, Handler handler, String str) {
        QZoneDelVisitorRequest qZoneDelVisitorRequest = new QZoneDelVisitorRequest(j3, j16, b16, j17, b17);
        if (str != null) {
            qZoneDelVisitorRequest.setRefer(str);
        }
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(qZoneDelVisitorRequest, handler, this, 14));
    }

    public void o(QZoneTask qZoneTask) {
        if (qZoneTask == null || qZoneTask.mRequest == null) {
            return;
        }
        QZoneResult result = qZoneTask.getResult(1000193);
        material_report_rsp material_report_rspVar = (material_report_rsp) qZoneTask.mRequest.rsp;
        if (!result.getSucceed() && material_report_rspVar != null) {
            QZLog.i("QzoneFriendService", "@reportBaner +rsperros msg =" + material_report_rspVar.strErrMsg + " rsp.icode =" + material_report_rspVar.iCode);
        }
        qZoneTask.sendResultMsg(result);
    }

    private void e(b bVar) {
        DbCacheManager dbCacheManager;
        if (bVar == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (uin != bVar.f451933a || (dbCacheManager = bVar.f451934b) == null || dbCacheManager.isClosed()) {
            bVar.f451933a = uin;
            DbCacheManager e16 = c.g().e(x6.a.class, uin, bVar.f451935c);
            bVar.f451934b = e16;
            e16.U(bVar.f451936d);
        }
    }

    private void i(QZoneTask qZoneTask) {
        qZoneTask.sendResultMsg(qZoneTask.getResult(999929));
    }

    private void j(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(1000042);
        if (result.getReturnCode() != 0) {
            result.setSucceed(false);
        }
        qZoneTask.sendResultMsg(result);
    }

    private void k(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(999937);
        mobile_sub_del_friendreq_rsp mobile_sub_del_friendreq_rspVar = (mobile_sub_del_friendreq_rsp) qZoneTask.mRequest.rsp;
        if (mobile_sub_del_friendreq_rspVar != null) {
            result.setSucceed(mobile_sub_del_friendreq_rspVar.ret == 0);
            result.setReturnCode(mobile_sub_del_friendreq_rspVar.ret);
            result.setMessage(mobile_sub_del_friendreq_rspVar.f25004msg);
        }
        qZoneTask.sendResultMsg(result);
    }

    private void l(QZoneTask qZoneTask) {
        qZoneTask.sendResultMsg(qZoneTask.getResult(1000105));
    }

    private void m(QZoneTask qZoneTask) {
        qZoneTask.sendResultMsg(qZoneTask.getResult(999946));
    }

    public void a(long j3, Handler handler) {
        u(j3, handler, 1, 15);
    }

    public void v(long j3, Handler handler) {
        u(j3, handler, 0, 16);
    }

    private void n(QZoneTask qZoneTask) {
        WidgetCacheQzoneVipData widgetCacheQzoneVipData;
        s_profile s_profileVar;
        sweet_style_info_item sweet_style_info_itemVar;
        sweet_rsp_comm sweet_rsp_commVar;
        UserClientShowInfo userClientShowInfo;
        UserClientShowInfo userClientShowInfo2;
        s_profile s_profileVar2;
        QZoneResult result = qZoneTask.getResult(999924);
        mobile_main_page_rsp response = ((QZoneGetUserInfoRequest) qZoneTask.mRequest).getResponse();
        if (response != null) {
            x6.a createFrom = x6.a.createFrom(response);
            result.setData(createFrom);
            s_part_error s_part_errorVar = response.part_error;
            if (!((s_part_errorVar != null && s_part_errorVar.is_happen == 1 && (s_part_errorVar.part_error_place & 5) == 5) ? false : true) || (s_profileVar2 = response.profile) == null) {
                widgetCacheQzoneVipData = null;
            } else {
                widgetCacheQzoneVipData = WidgetCacheQzoneVipData.createFromResponse(s_profileVar2);
                WidgetCacheQzoneVipData widgetVipDataFromCache = widgetCacheQzoneVipData != null ? QzoneWidgetService.getInstance().getWidgetVipDataFromCache(widgetCacheQzoneVipData.uin) : null;
                if (widgetVipDataFromCache != null) {
                    WidgetCacheQzoneVipData.mergeWithOldCacheForQQUnionVip(widgetCacheQzoneVipData, widgetVipDataFromCache);
                }
                if (widgetCacheQzoneVipData != null && widgetCacheQzoneVipData.uin == 0) {
                    widgetCacheQzoneVipData.uin = ((mobile_main_page_req) qZoneTask.mRequest.req).uin;
                }
            }
            byte[] bArr = response.stShangchengInfo;
            if (bArr != null) {
                AllInfo allInfo = (AllInfo) t5.b.b(AllInfo.class, bArr);
                if (allInfo != null) {
                    if (widgetCacheQzoneVipData == null) {
                        widgetCacheQzoneVipData = new WidgetCacheQzoneVipData();
                    }
                    byte[] bArr2 = allInfo.vecQQBigVipInfo;
                    if (bArr2 != null && (userClientShowInfo2 = (UserClientShowInfo) t5.b.b(UserClientShowInfo.class, bArr2)) != null) {
                        if (createFrom != null) {
                            VipComponentProxy.f50997g.getServiceInterface().updateQQUnionVip(String.valueOf(createFrom.uin), (userClientShowInfo2.iVip == 0 || userClientShowInfo2.iIsUseVipIcon == 0) ? false : true, userClientShowInfo2.iLevel, userClientShowInfo2.mapIconInfo);
                        }
                        WidgetCacheQzoneVipData.updateQQUnionVip(widgetCacheQzoneVipData, userClientShowInfo2);
                    }
                    SearchClientShowInfoRsp searchClientShowInfoRsp = allInfo.stYellowVipInfo;
                    if (searchClientShowInfoRsp != null && searchClientShowInfoRsp.iCode == 0 && (userClientShowInfo = searchClientShowInfoRsp.stUserClientShowInfo) != null) {
                        Map<String, IconInfo> map = userClientShowInfo.mapIconInfo;
                        if (map != null && map.size() != 0) {
                            searchClientShowInfoRsp.stUserClientShowInfo.iIsUseVipIcon = 1;
                        } else {
                            searchClientShowInfoRsp.stUserClientShowInfo.iIsUseVipIcon = 0;
                        }
                        if (createFrom != null) {
                            IVipComponentService serviceInterface = VipComponentProxy.f50997g.getServiceInterface();
                            String valueOf = String.valueOf(createFrom.uin);
                            UserClientShowInfo userClientShowInfo3 = searchClientShowInfoRsp.stUserClientShowInfo;
                            serviceInterface.updateQQNewVip(valueOf, userClientShowInfo3.iIsUseVipIcon != 0, userClientShowInfo3.mapIconInfo);
                        }
                        WidgetCacheQzoneVipData.updateNewVip(widgetCacheQzoneVipData, searchClientShowInfoRsp.stUserClientShowInfo);
                    }
                    guest_mainpage_rsp guest_mainpage_rspVar = allInfo.stGuestMainpageRsp;
                    if (guest_mainpage_rspVar != null && (sweet_rsp_commVar = guest_mainpage_rspVar.rsp_comm) != null && sweet_rsp_commVar.retcode == 0 && !TextUtils.isEmpty(guest_mainpage_rspVar.jump_url) && createFrom != null) {
                        createFrom.jumpUrlParamsForLoveZone = guest_mainpage_rspVar.jump_url;
                    }
                    byte[] bArr3 = allInfo.vecSweetStyleInfo;
                    if (bArr3 != null && (sweet_style_info_itemVar = (sweet_style_info_item) t5.b.b(sweet_style_info_item.class, bArr3)) != null && createFrom != null) {
                        VipComponentProxy.f50997g.getServiceInterface().updateLoveVipInfo(String.valueOf(createFrom.uin), sweet_style_info_itemVar);
                    }
                } else {
                    MonitorManager.f().h(23, 2, "parse user vecQQBigVipInfo data fail", false);
                }
            }
            if (widgetCacheQzoneVipData != null) {
                QzoneWidgetService.getInstance().saveQzoneVipCacheData(widgetCacheQzoneVipData);
                w(widgetCacheQzoneVipData);
            }
            if (createFrom != null && createFrom.uin == LoginData.getInstance().getUin() && (s_profileVar = response.profile) != null) {
                star_info star_infoVar = s_profileVar.stuStarInfo;
                star_info star_infoVar2 = star_infoVar != null ? new star_info(star_infoVar.iStarStatus, star_infoVar.iStarLevel, star_infoVar.isAnnualVip, star_infoVar.isHighStarVip) : null;
                combine_diamond_info combine_diamond_infoVar = response.profile.stuCombineDiamondInfo;
                combine_diamond_info combine_diamond_infoVar2 = combine_diamond_infoVar != null ? new combine_diamond_info(combine_diamond_infoVar.iShowType, combine_diamond_infoVar.iVipLevel, combine_diamond_infoVar.isAnnualVip, combine_diamond_infoVar.isAnnualVipEver) : null;
                if (createFrom.isVip) {
                    LoginData.getInstance().updateVipInfos(createFrom.vipType + 1, createFrom.vipLevel, createFrom.isAnnualVip, star_infoVar2, combine_diamond_infoVar2, VipComponentProxy.f50997g.getServiceInterface().getVipInfo(LoginData.getInstance().getUinString()).getPersonalizedYellowVipUrl(), true);
                } else {
                    LoginData.getInstance().updateVipInfos(createFrom.vipType, createFrom.vipLevel, createFrom.isAnnualVip, star_infoVar2, combine_diamond_infoVar2, VipComponentProxy.f50997g.getServiceInterface().getVipInfo(LoginData.getInstance().getUinString()).getPersonalizedYellowVipUrl(), true);
                }
            }
            FunnySpace funnySpace = response.StuFunnySpace;
            if (funnySpace != null && !TextUtils.isEmpty(funnySpace.host_message)) {
                KapuEventDbCacheData kapuEventDbCacheData = new KapuEventDbCacheData();
                kapuEventDbCacheData.uin = LoginData.getInstance().getUin();
                kapuEventDbCacheData.strHostCustomMsgTxt = response.StuFunnySpace.host_message;
                QzoneWidgetService.getInstance().saveKapuEventCacheData(kapuEventDbCacheData);
                EventCenter.getInstance().post("KapuQzoneEvent", 1);
            } else {
                ArrayList<s_space_event> arrayList = response.vec_event;
                if (arrayList != null && arrayList.size() > 0) {
                    s_space_event s_space_eventVar = response.vec_event.get(0);
                    KapuEventDbCacheData kapuEventDbCacheData2 = new KapuEventDbCacheData();
                    kapuEventDbCacheData2.uin = LoginData.getInstance().getUin();
                    kapuEventDbCacheData2.strEventPic = s_space_eventVar.strEventPic;
                    kapuEventDbCacheData2.strJumpType = s_space_eventVar.strJumpType;
                    kapuEventDbCacheData2.strJumpUrl = s_space_eventVar.strJumpUrl;
                    kapuEventDbCacheData2.strEventTxt = s_space_eventVar.strEventTxt;
                    kapuEventDbCacheData2.traceinfo = s_space_eventVar.traceinfo;
                    kapuEventDbCacheData2.iAdID = s_space_eventVar.iAdID;
                    QzoneWidgetService.getInstance().saveKapuEventCacheData(kapuEventDbCacheData2);
                    EventCenter.getInstance().post("KapuQzoneEvent", 1);
                }
            }
            FunnySpace funnySpace2 = response.StuFunnySpace;
            if (funnySpace2 != null) {
                LocalMultiProcConfig.putLong4Uin("qzone_homepage_kapu_fire_power_count", funnySpace2.uFirePowerCount, LoginData.getInstance().getUin());
                EventCenter.getInstance().post("KapuQzoneEvent", 2);
            }
            EventCenter.getInstance().post(a.C10129a.f391398a, 11);
            qZoneTask.sendResultMsg(result);
            t(createFrom);
            return;
        }
        EventCenter.getInstance().post(a.C10129a.f391398a, 12);
        result.setSucceed(false);
        qZoneTask.sendResultMsg(result);
    }
}
