package yw0;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.icgame.game.liveroom.impl.room.audience.event.RoomCloseEvent;
import com.tencent.icgame.game.liveroom.impl.room.event.OnActivityResultEvent;
import com.tencent.icgame.game.liveroom.impl.room.share.timishare.ShareHandler;
import com.tencent.icgame.game.liveroom.impl.room.share.timishare.report.GetShareTokenRequest;
import com.tencent.icgame.game.liveroom.impl.room.share.timishare.report.ShareLiveReportRequest;
import com.tencent.mobileqq.icgame.api.ILiveNetRequest;
import com.tencent.mobileqq.icgame.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom;
import com.tencent.mobileqq.icgame.api.sso.QQLiveResponse;
import com.tencent.mobileqq.icgame.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.icgame.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.icgame.data.room.EnterRoomInfo;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes7.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static WeakReference<ShareActionSheet> f451362a;

    /* renamed from: b, reason: collision with root package name */
    private static ShareHandler f451363b = new ShareHandler();

    /* renamed from: c, reason: collision with root package name */
    private static IAegisLogApi f451364c = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* renamed from: d, reason: collision with root package name */
    private static final SimpleEventReceiver f451365d = new a();

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements SimpleEventReceiver {
        a() {
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public ArrayList<Class> getEventClass() {
            ArrayList<Class> arrayList = new ArrayList<>();
            arrayList.add(RoomCloseEvent.class);
            arrayList.add(OnActivityResultEvent.class);
            return arrayList;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
            if (simpleBaseEvent instanceof RoomCloseEvent) {
                h.k();
            } else if (simpleBaseEvent instanceof OnActivityResultEvent) {
                OnActivityResultEvent onActivityResultEvent = (OnActivityResultEvent) simpleBaseEvent;
                h.f451363b.g(onActivityResultEvent.getRequestCode(), onActivityResultEvent.getResultCode(), onActivityResultEvent.getData());
            }
        }
    }

    private static void A() {
        SimpleEventBus.getInstance().unRegisterReceiver(f451365d);
    }

    public static com.tencent.icgame.game.liveroom.impl.room.share.timishare.d j(long j3, LiveRoomExtraInfo liveRoomExtraInfo, String str) {
        String str2;
        QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr;
        Bundle bundle;
        com.tencent.icgame.game.liveroom.impl.room.share.timishare.c cVar = new com.tencent.icgame.game.liveroom.impl.room.share.timishare.c();
        cVar.f115618a = j3;
        cVar.f115632o = str;
        LiveUserInfo selfUserInfo = ((fu0.c) qx0.a.b(fu0.c.class)).getSelfUserInfo();
        if (selfUserInfo != null) {
            str2 = selfUserInfo.nick;
        } else {
            str2 = "\u6211";
        }
        cVar.f115624g = str2;
        fu0.e n3 = ((fu0.c) qx0.a.b(fu0.c.class)).n(j3);
        if (n3 != null) {
            cVar.f115621d = n3.f400636a;
            cVar.f115622e = n3.f400638c;
            cVar.f115623f = n3.f400637b;
        }
        IAudienceRoom N = ((fu0.c) qx0.a.b(fu0.c.class)).N(j3);
        QQLiveAnchorRoomInfo x16 = ((fu0.c) qx0.a.b(fu0.c.class)).x(j3);
        if (N != null) {
            LiveInfo roomLiveInfo = N.getRoomLiveInfo();
            if (roomLiveInfo != null) {
                LiveRoomInfo liveRoomInfo = roomLiveInfo.roomInfo;
                cVar.f115619b = liveRoomInfo.roomLogo;
                cVar.f115620c = liveRoomInfo.roomName;
            }
            ILiveAudienceTPPlayerRoom a16 = com.tencent.icgame.game.liveroom.impl.room.definition.b.a(j3);
            if (a16 != null) {
                String targetUrl = a16.getTargetUrl(EnterRoomInfo.VideoDefinition.SHD);
                rt0.a.f("ICGameShare|ICGameShareUtil", "createShareParam", "shdUrl: " + targetUrl);
                if (!TextUtils.isEmpty(targetUrl)) {
                    cVar.f115630m = targetUrl;
                }
                if (roomLiveInfo != null) {
                    cVar.f115631n = roomLiveInfo.streamType;
                }
            }
            if (TextUtils.isEmpty(cVar.f115623f) && roomLiveInfo != null) {
                cVar.f115623f = roomLiveInfo.roomInfo.roomName;
            }
            if (TextUtils.isEmpty(cVar.f115620c) && roomLiveInfo != null) {
                cVar.f115620c = roomLiveInfo.roomInfo.roomName;
            }
            if (liveRoomExtraInfo != null) {
                cVar.f115625h = String.valueOf(liveRoomExtraInfo.f114882f);
                cVar.f115626i = String.valueOf(liveRoomExtraInfo.f114885m);
                cVar.f115627j = String.valueOf(liveRoomExtraInfo.f114883h);
                cVar.f115628k = String.valueOf(liveRoomExtraInfo.f114884i);
            } else {
                if (roomLiveInfo != null) {
                    bundle = roomLiveInfo.roomInfo.extData;
                } else {
                    bundle = null;
                }
                if (bundle != null && !bundle.isEmpty()) {
                    cVar.f115625h = n(bundle);
                    cVar.f115626i = p(bundle);
                    cVar.f115627j = l(bundle);
                    cVar.f115628k = m(bundle);
                }
            }
        } else if (x16 != null && (qQLiveAnchorDataRoomAttr = x16.roomAttr) != null) {
            cVar.f115619b = qQLiveAnchorDataRoomAttr.poster16v9;
            cVar.f115620c = qQLiveAnchorDataRoomAttr.roomName;
            cVar.f115625h = String.valueOf(qQLiveAnchorDataRoomAttr.liveRoomType);
            cVar.f115626i = QQLiveSDKConfigHelper.getQQLiveAppId();
            QQLiveAnchorRoomGameInfo qQLiveAnchorRoomGameInfo = x16.roomAttr.gameInfo;
            if (qQLiveAnchorRoomGameInfo != null) {
                cVar.f115627j = String.valueOf(qQLiveAnchorRoomGameInfo.f271211id);
                cVar.f115628k = String.valueOf(x16.roomAttr.gameInfo.secondTagId);
            }
        }
        String str3 = cVar.f115623f;
        String str4 = cVar.f115620c;
        com.tencent.icgame.game.liveroom.impl.room.share.timishare.d dVar = new com.tencent.icgame.game.liveroom.impl.room.share.timishare.d();
        dVar.f115633a = cVar;
        dVar.f115641i = false;
        dVar.f115640h = "\u4e92\u52a8\u4e91\u73a9\u6cd5";
        dVar.f115634b = str3;
        dVar.f115635c = str4;
        dVar.f115636d = cVar.d();
        dVar.f115637e = cVar.c();
        dVar.f115638f = cVar.f115619b;
        rt0.a.e("ICGameShare|ICGameShareUtil", "tg share param:" + dVar);
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k() {
        WeakReference<ShareActionSheet> weakReference = f451362a;
        if (weakReference != null) {
            ShareActionSheet shareActionSheet = weakReference.get();
            if (shareActionSheet != null) {
                shareActionSheet.dismiss();
                f451362a = null;
            }
            A();
        }
    }

    private static String l(Bundle bundle) {
        int i3 = 1;
        if (bundle != null) {
            i3 = bundle.getInt(VirtualAppProxy.KEY_GAME_ID, 1);
        }
        return String.valueOf(i3);
    }

    private static String m(Bundle bundle) {
        int i3 = 1;
        if (bundle != null) {
            i3 = bundle.getInt("gameTagId", 1);
        }
        return String.valueOf(i3);
    }

    private static String n(Bundle bundle) {
        int i3 = 1;
        if (bundle != null) {
            i3 = bundle.getInt("roomType", 1);
        }
        return String.valueOf(i3);
    }

    private static void o(final Context context, final long j3, final LiveRoomExtraInfo liveRoomExtraInfo) {
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new GetShareTokenRequest(j3), new ILiveNetRequest.Callback() { // from class: yw0.a
            @Override // com.tencent.mobileqq.icgame.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                h.q(context, j3, liveRoomExtraInfo, qQLiveResponse);
            }
        });
    }

    private static String p(Bundle bundle) {
        long j3 = 0;
        if (bundle != null) {
            j3 = bundle.getLong("videoSource", 0L);
        }
        return String.valueOf(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(Context context, long j3, LiveRoomExtraInfo liveRoomExtraInfo, QQLiveResponse qQLiveResponse) {
        if (qQLiveResponse.isSuccess()) {
            ap4.d dVar = (ap4.d) qQLiveResponse.getRsp();
            if (dVar != null) {
                y(context, j3, liveRoomExtraInfo, dVar.f26701a);
                return;
            }
            f451364c.a("ICGameShare|ICGameShareUtil", "get shareToken rsp is null:code" + qQLiveResponse.getRetCode() + ",msg:" + qQLiveResponse.getErrMsg());
            return;
        }
        f451364c.a("ICGameShare|ICGameShareUtil", "get shareToken failed, code:" + qQLiveResponse.getRetCode() + ",msg:" + qQLiveResponse.getErrMsg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r(View view, ConcurrentHashMap concurrentHashMap, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        String str;
        int i3 = actionSheetItem.action;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 9) {
                    if (i3 != 10) {
                        if (i3 != 26 && i3 != 72 && i3 != 73) {
                            str = "";
                        }
                    } else {
                        str = "3";
                    }
                } else {
                    str = "2";
                }
            } else {
                str = "1";
            }
            ((ru0.a) qx0.a.b(ru0.a.class)).reportEvent("imp_end", view, concurrentHashMap);
            concurrentHashMap.put("icgame_share_channel", str);
            ((ru0.a) qx0.a.b(ru0.a.class)).c(view, false, null, "em_icgame_share_panel", concurrentHashMap);
            ((ru0.a) qx0.a.b(ru0.a.class)).reportEvent("clck", view, concurrentHashMap);
        }
        str = "0";
        ((ru0.a) qx0.a.b(ru0.a.class)).reportEvent("imp_end", view, concurrentHashMap);
        concurrentHashMap.put("icgame_share_channel", str);
        ((ru0.a) qx0.a.b(ru0.a.class)).c(view, false, null, "em_icgame_share_panel", concurrentHashMap);
        ((ru0.a) qx0.a.b(ru0.a.class)).reportEvent("clck", view, concurrentHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s(View view, ConcurrentHashMap concurrentHashMap, DialogInterface dialogInterface) {
        ((ru0.a) qx0.a.b(ru0.a.class)).reportEvent("imp", view, concurrentHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(View view, ConcurrentHashMap concurrentHashMap, DialogInterface dialogInterface) {
        f451362a = null;
        A();
        ((ru0.a) qx0.a.b(ru0.a.class)).reportEvent("imp_end", view, concurrentHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(View view, ConcurrentHashMap concurrentHashMap, DialogInterface dialogInterface) {
        f451362a = null;
        A();
        ((ru0.a) qx0.a.b(ru0.a.class)).reportEvent("imp_end", view, concurrentHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(QQLiveResponse qQLiveResponse) {
        rt0.a.f("ICGameShare|ICGameShareUtil", "reportShareResult", "isSuccess=" + qQLiveResponse.isSuccess() + ", errCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(String str, int i3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("sharePlatformType=");
        sb5.append(i3);
        sb5.append("hasShareToken:");
        sb5.append(!TextUtils.isEmpty(str));
        rt0.a.f("ICGameShare|ICGameShareUtil", "reportShareResult", sb5.toString());
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new ShareLiveReportRequest(str), new ILiveNetRequest.Callback() { // from class: yw0.g
            @Override // com.tencent.mobileqq.icgame.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                h.v(qQLiveResponse);
            }
        });
    }

    public static void x(Context context, long j3, LiveRoomExtraInfo liveRoomExtraInfo) {
        o(context, j3, liveRoomExtraInfo);
    }

    private static void y(Context context, long j3, LiveRoomExtraInfo liveRoomExtraInfo, final String str) {
        String str2;
        k();
        ConcurrentHashMap b16 = kw0.a.b(j3, liveRoomExtraInfo);
        FrameLayout frameLayout = new FrameLayout(context);
        boolean b17 = ((fu0.c) qx0.a.b(fu0.c.class)).s().b();
        ru0.a aVar = (ru0.a) qx0.a.b(ru0.a.class);
        if (b17) {
            str2 = "pg_icgame_anchorlive";
        } else {
            str2 = "pg_icgame_audience";
        }
        aVar.b(frameLayout, str2, b16);
        final View view = new View(context);
        frameLayout.addView(view);
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("zengzhi_moduleid", "em_icgame_share");
        ((ru0.a) qx0.a.b(ru0.a.class)).c(view, false, null, "em_icgame_share_panel", concurrentHashMap);
        f451362a = new WeakReference<>(f451363b.h(context, j(j3, liveRoomExtraInfo, str), new ShareActionSheet.OnItemClickListener() { // from class: yw0.b
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
            public final void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                h.r(view, concurrentHashMap, actionSheetItem, shareActionSheet);
            }
        }, new DialogInterface.OnShowListener() { // from class: yw0.c
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                h.s(view, concurrentHashMap, dialogInterface);
            }
        }, new DialogInterface.OnCancelListener() { // from class: yw0.d
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                h.t(view, concurrentHashMap, dialogInterface);
            }
        }, new DialogInterface.OnDismissListener() { // from class: yw0.e
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                h.u(view, concurrentHashMap, dialogInterface);
            }
        }, new ShareHandler.f() { // from class: yw0.f
            @Override // com.tencent.icgame.game.liveroom.impl.room.share.timishare.ShareHandler.f
            public final void a(int i3) {
                h.w(str, i3);
            }
        }));
        z();
    }

    private static void z() {
        SimpleEventBus.getInstance().registerReceiver(f451365d);
    }
}
