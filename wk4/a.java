package wk4;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.api.impl.RoomServiceConstants;
import com.tencent.mobileqq.qqlive.business.QQLiveConfigConst;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.qqlive.sail.model.audience.StreamDefinition;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.liveroom.impl.room.audience.event.RoomCloseEvent;
import com.tencent.timi.game.liveroom.impl.room.event.OnActivityResultEvent;
import com.tencent.timi.game.liveroom.impl.room.share.timishare.TgLiveShareParam;
import com.tencent.timi.game.liveroom.impl.room.share.timishare.TgShareParam;
import com.tencent.timi.game.liveroom.impl.room.share.timishare.TimiGameShareUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static WeakReference<ShareActionSheet> f445774a;

    /* renamed from: b, reason: collision with root package name */
    private static final SimpleEventReceiver f445775b = new C11491a();

    /* compiled from: P */
    /* renamed from: wk4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C11491a implements SimpleEventReceiver {
        C11491a() {
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
                a.e();
            } else if (simpleBaseEvent instanceof OnActivityResultEvent) {
                OnActivityResultEvent onActivityResultEvent = (OnActivityResultEvent) simpleBaseEvent;
                TimiGameShareUtil.i(onActivityResultEvent.getRequestCode(), onActivityResultEvent.getResultCode(), onActivityResultEvent.getData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements ShareActionSheet.OnItemClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TgShareParam f445776d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f445777e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ConcurrentHashMap f445778f;

        b(TgShareParam tgShareParam, View view, ConcurrentHashMap concurrentHashMap) {
            this.f445776d = tgShareParam;
            this.f445777e = view;
            this.f445778f = concurrentHashMap;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x001e, code lost:
        
            if (r7 != 73) goto L20;
         */
        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            String str;
            int i3 = actionSheetItem.action;
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 9) {
                        if (i3 != 10) {
                            if (i3 != 26) {
                                if (i3 != 211) {
                                    if (i3 != 72) {
                                    }
                                } else {
                                    ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleScheme(this.f445776d.promotionUrl, null);
                                }
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
                ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("imp_end", this.f445777e, this.f445778f);
                this.f445778f.put("qqlive_share_channel", str);
                ((ug4.a) mm4.b.b(ug4.a.class)).c(this.f445777e, false, null, "em_qqlive_share_panel", this.f445778f);
                ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("clck", this.f445777e, this.f445778f);
            }
            str = "0";
            ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("imp_end", this.f445777e, this.f445778f);
            this.f445778f.put("qqlive_share_channel", str);
            ((ug4.a) mm4.b.b(ug4.a.class)).c(this.f445777e, false, null, "em_qqlive_share_panel", this.f445778f);
            ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("clck", this.f445777e, this.f445778f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements DialogInterface.OnShowListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f445779d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ConcurrentHashMap f445780e;

        c(View view, ConcurrentHashMap concurrentHashMap) {
            this.f445779d = view;
            this.f445780e = concurrentHashMap;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("imp", this.f445779d, this.f445780e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d implements DialogInterface.OnCancelListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f445781d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ConcurrentHashMap f445782e;

        d(View view, ConcurrentHashMap concurrentHashMap) {
            this.f445781d = view;
            this.f445782e = concurrentHashMap;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            a.f445774a = null;
            a.j();
            ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("imp_end", this.f445781d, this.f445782e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class e implements DialogInterface.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f445783d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ConcurrentHashMap f445784e;

        e(View view, ConcurrentHashMap concurrentHashMap) {
            this.f445783d = view;
            this.f445784e = concurrentHashMap;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            a.f445774a = null;
            a.j();
            ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("imp_end", this.f445783d, this.f445784e);
        }
    }

    public static TgShareParam d(long j3, LiveRoomExtraInfo liveRoomExtraInfo) {
        String str;
        TgLiveShareParam tgLiveShareParam = new TgLiveShareParam();
        tgLiveShareParam.roomId = j3;
        String g16 = g();
        tgLiveShareParam.liveProductType = g16;
        if (liveRoomExtraInfo != null) {
            Bundle bundle = liveRoomExtraInfo.E;
            if (bundle != null) {
                String string = bundle.getString(RoomServiceConstants.PARAMS_QQ_LIVE_PRODUCT_TYPE);
                if (!TextUtils.isEmpty(string)) {
                    tgLiveShareParam.liveProductType = string;
                }
            } else {
                QLog.i("TgLiveShareUtil", 1, "extra is null");
            }
        } else {
            QLog.i("TgLiveShareUtil", 1, "liveRoomExtraInfo is null");
        }
        QLog.i("TgLiveShareUtil", 1, "share live_p_type=" + tgLiveShareParam.liveProductType + ",support_p_type=" + g16);
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        LiveLoginInfo u16 = cVar.u();
        if (u16 != null) {
            str = u16.m();
        } else {
            str = "\u6211";
        }
        tgLiveShareParam.selfNick = str;
        tgLiveShareParam.anchorUid = cVar.k(j3, 0);
        tgLiveShareParam.anchorAvatarUrl = cVar.e(j3, 0);
        tgLiveShareParam.anchorNick = cVar.g(j3, 0);
        tgLiveShareParam.roomCoverUrl = cVar.n(j3, 0);
        tgLiveShareParam.roomTitle = cVar.B(j3, 0);
        tgLiveShareParam.roomType = String.valueOf(cVar.E(j3, 0));
        tgLiveShareParam.videoSource = QQLiveBusinessConfig.QQLIVE_APP_ID;
        tgLiveShareParam.gameId = "0";
        tgLiveShareParam.gameTagId = "0";
        tgLiveShareParam.platform = cVar.D(j3, 0);
        tgLiveShareParam.huYaAnchorId = cVar.t(j3, 0);
        if (cVar.m().B(j3, 0)) {
            try {
                tgLiveShareParam.flvUrl = cVar.m().y(j3, StreamDefinition.SHD, 0);
            } catch (Exception e16) {
                QLog.e("TgLiveShareUtil", 1, "get url failed", e16);
            }
        }
        String str2 = tgLiveShareParam.anchorNick;
        String str3 = tgLiveShareParam.roomTitle;
        TgShareParam tgShareParam = new TgShareParam();
        tgShareParam.tgLiveShareParam = tgLiveShareParam;
        tgShareParam.showReport = false;
        tgShareParam.shareAppName = "QQ\u76f4\u64ad";
        tgShareParam.simpleTitle = str2;
        tgShareParam.mainName = str3;
        tgShareParam.originSummary = tgLiveShareParam.getShareSummary();
        tgShareParam.singleSummaryOnly = tgLiveShareParam.getShareSingleOnlySummary();
        tgShareParam.coverImgUrl = tgLiveShareParam.roomCoverUrl;
        tgShareParam.promotionUrl = f(tgLiveShareParam.anchorUid, tgLiveShareParam.anchorNick, j3);
        QLog.i("TgLiveShareUtil", 1, "tg share param:" + tgShareParam);
        return tgShareParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e() {
        WeakReference<ShareActionSheet> weakReference = f445774a;
        if (weakReference != null) {
            ShareActionSheet shareActionSheet = weakReference.get();
            if (shareActionSheet != null) {
                shareActionSheet.dismiss();
                f445774a = null;
            }
            j();
        }
    }

    private static String f(long j3, String str, long j16) {
        boolean z16 = false;
        if (((Integer) ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).getAladdinConfig(100474, "open_switch", 0)).intValue() == 1) {
            z16 = true;
        }
        if (z16) {
            return "mqqapi://ecommerce/open?target=52&page_name=qplus_promotion_setting&target_uin=" + j3 + "&target_nick=" + str + "&room_id=" + j16 + "&source_from=1&channel=8&src_type=internal&version=1";
        }
        return "";
    }

    private static String g() {
        if (TextUtils.equals(QQLiveConfigConst.APP_ID, QQLiveSDKConfigHelper.getQQLiveAppId())) {
            return "1";
        }
        return "0";
    }

    public static void h(Context context, long j3, LiveRoomExtraInfo liveRoomExtraInfo) {
        String str;
        e();
        ConcurrentHashMap b16 = com.tencent.timi.game.liveroom.impl.room.more.d.b(j3, liveRoomExtraInfo);
        FrameLayout frameLayout = new FrameLayout(context);
        boolean J = com.tencent.mobileqq.qqlive.sail.c.f272176a.J(j3, 0);
        ug4.a aVar = (ug4.a) mm4.b.b(ug4.a.class);
        if (J) {
            str = IMultiAvChatReporter.PageId.ANCHOR_PAGE_ID;
        } else {
            str = IMultiAvChatReporter.PageId.AUDIENCE_PAGE_ID;
        }
        aVar.b(frameLayout, str, b16);
        View view = new View(context);
        frameLayout.addView(view);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("zengzhi_moduleid", "em_qqlive_share");
        ((ug4.a) mm4.b.b(ug4.a.class)).c(view, false, null, "em_qqlive_share_panel", concurrentHashMap);
        TgShareParam d16 = d(j3, liveRoomExtraInfo);
        f445774a = new WeakReference<>(TimiGameShareUtil.j(context, d16, new b(d16, view, concurrentHashMap), new c(view, concurrentHashMap), new d(view, concurrentHashMap), new e(view, concurrentHashMap)));
        i();
    }

    private static void i() {
        SimpleEventBus.getInstance().registerReceiver(f445775b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j() {
        SimpleEventBus.getInstance().unRegisterReceiver(f445775b);
    }
}
