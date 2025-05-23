package qw0;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.sso.request.QQLiveCancelKickoutRequest;
import com.tencent.icgame.game.sso.request.QQLiveGetAdminSubMenuRequest;
import com.tencent.icgame.game.sso.request.QQLiveGetBannedListRequest;
import com.tencent.icgame.game.sso.request.QQLiveGetChatStatusRequest;
import com.tencent.icgame.game.sso.request.QQLiveGetKickoutListRequest;
import com.tencent.icgame.game.sso.request.QQLiveIsRoomAdminRequest;
import com.tencent.icgame.game.sso.request.QQLiveKickoutRequest;
import com.tencent.icgame.game.sso.request.QQLiveSetChatStatusRequest;
import com.tencent.icgame.game.sso.request.QQLiveSetRoomAdminRequest;
import com.tencent.icgame.trpcprotocol.qlive.livechatcheck.LiveChatCheck$AdminMenu;
import com.tencent.icgame.trpcprotocol.qlive.livechatcheck.LiveChatCheck$AdminMenuListRsp;
import com.tencent.icgame.trpcprotocol.qlive.livechatcheck.LiveChatCheck$BatchGetBannedChatUserRsp;
import com.tencent.icgame.trpcprotocol.qlive.livechatcheck.LiveChatCheck$BatchGetKickOutUserRsp;
import com.tencent.icgame.trpcprotocol.qlive.livechatcheck.LiveChatCheck$CancleKickOutSomebodyRsp;
import com.tencent.icgame.trpcprotocol.qlive.livechatcheck.LiveChatCheck$ChatCheckRspBody;
import com.tencent.icgame.trpcprotocol.qlive.livechatcheck.LiveChatCheck$IsRoomAdminRsp;
import com.tencent.icgame.trpcprotocol.qlive.livechatcheck.LiveChatCheck$KickOutSomebodyRsp;
import com.tencent.icgame.trpcprotocol.qlive.livechatcheck.LiveChatCheck$QueryChatStatusRsp;
import com.tencent.icgame.trpcprotocol.qlive.livechatcheck.LiveChatCheck$RoomUserInfo;
import com.tencent.icgame.trpcprotocol.qlive.livechatcheck.LiveChatCheck$SetChatStatusRsp;
import com.tencent.icgame.trpcprotocol.qlive.livechatcheck.LiveChatCheck$SetRoomAdminRsp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.icgame.api.ILiveNetRequest;
import com.tencent.mobileqq.icgame.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import qw0.k;

/* compiled from: P */
/* loaded from: classes7.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static IAegisLogApi f430238a = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f430239d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f430240e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f430241f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f430242h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f430243i;

        a(long j3, long j16, long j17, long j18, int i3) {
            this.f430239d = j3;
            this.f430240e = j16;
            this.f430241f = j17;
            this.f430242h = j18;
            this.f430243i = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            k.A(this.f430239d, this.f430240e, this.f430241f, this.f430242h, this.f430243i);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface c {
        void a(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface d {
        void a(LinkedHashMap<String, Integer> linkedHashMap);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface e {
        void onResult(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface f {
        void onFail();

        void onSuccess(List<sw0.a> list, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface g {
        void onResult(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface h {
        void onResult(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface i {
        void a(boolean z16, long j3, long j16, int i3, int i16, String str);
    }

    public static void A(long j3, long j16, long j17, long j18, int i3) {
        f430238a.i("ICGameRoomAdminHelper", "[performKickOut] anchorId=" + j3 + ",adminUin=" + j16 + ",targetUin=" + j17 + ",roomId=" + j18);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveKickoutRequest(j18, j3, j16, j17, i3), new ILiveNetRequest.Callback() { // from class: qw0.j
            @Override // com.tencent.mobileqq.icgame.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                k.x(qQLiveResponse);
            }
        });
    }

    public static void B(long j3, long j16, int i3, boolean z16, final h hVar) {
        f430238a.i("ICGameRoomAdminHelper", "setChatStatus uin=" + j3 + ",roomId=" + j16 + ",menuId=" + i3 + ",isAllowChat=" + z16);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveSetChatStatusRequest(j16, j3, z16, i3), new ILiveNetRequest.Callback() { // from class: qw0.d
            @Override // com.tencent.mobileqq.icgame.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                k.y(k.h.this, qQLiveResponse);
            }
        });
    }

    public static void C(Activity activity, final boolean z16, final long j3, final long j16, long j17, final i iVar, int i3) {
        f430238a.i("ICGameRoomAdminHelper", "[setRoomAdmin] setAdmin= " + z16 + ",anchorUin=" + j3 + ",uin=" + j16 + ",roomId=" + j17);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveSetRoomAdminRequest(j17, j3, j16, z16), new ILiveNetRequest.Callback(iVar, z16, j3, j16) { // from class: qw0.f

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f430226a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f430227b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ long f430228c;

            {
                this.f430226a = z16;
                this.f430227b = j3;
                this.f430228c = j16;
            }

            @Override // com.tencent.mobileqq.icgame.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                k.z(null, this.f430226a, this.f430227b, this.f430228c, qQLiveResponse);
            }
        });
    }

    public static void D(Activity activity, String str) {
        if (activity == null) {
            return;
        }
        DialogUtil.createCustomDialog(activity, 230, (String) null, str, activity.getString(R.string.zgi), (String) null, (DialogInterface.OnClickListener) null, new b()).show();
    }

    public static void E(Activity activity, long j3, long j16, long j17, String str, long j18, int i3, String str2) {
        f430238a.i("ICGameRoomAdminHelper", "showKickoutDialogEx anchorUin=" + j3 + ",adminId=" + j16 + ",uin=" + j17 + ",roomId" + j18);
        if (activity == null) {
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, activity.getString(R.string.f161741yj, "\"" + str + "\"").replace("$MENUSTRING$", "\"" + str2 + "\""), activity.getString(R.string.f159361s4), activity.getString(R.string.cancel), activity.getString(R.string.f171151ok), new a(j3, j16, j17, j18, i3), (DialogInterface.OnClickListener) null);
        TextView textView = (TextView) createCustomDialog.findViewById(R.id.dialogTitle);
        if (textView != null) {
            textView.setGravity(3);
            textView.setSingleLine(false);
        }
        createCustomDialog.show();
    }

    public static void j(long j3, long j16, long j17, long j18, final g gVar) {
        f430238a.i("ICGameRoomAdminHelper", "[cancelKickOut] anchorId=" + j3 + ",adminUin=" + j16 + ",targetUin=" + j17 + ",roomId=" + j18);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveCancelKickoutRequest(j18, j3, j16, j17), new ILiveNetRequest.Callback() { // from class: qw0.e
            @Override // com.tencent.mobileqq.icgame.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                k.r(k.g.this, qQLiveResponse);
            }
        });
    }

    private static boolean k(QQLiveResponse<LiveChatCheck$ChatCheckRspBody> qQLiveResponse, int i3, String str) {
        LiveChatCheck$ChatCheckRspBody rsp = qQLiveResponse.getRsp();
        if (!qQLiveResponse.isFailed() && rsp != null) {
            if (!rsp.has()) {
                f430238a.w("ICGameRoomAdminHelper", str + "rspBody not has");
                return true;
            }
            if (rsp.result.has() && rsp.result.get() == 0) {
                if (rsp.submcd.has() && rsp.submcd.get() == i3) {
                    return false;
                }
                f430238a.w("ICGameRoomAdminHelper", str + "invalid subCmd, " + rsp.submcd.get());
                return true;
            }
            f430238a.w("ICGameRoomAdminHelper", str + "rspBody failed, " + rsp.result.get());
            return true;
        }
        f430238a.w("ICGameRoomAdminHelper", str + "response failed, errCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
        return true;
    }

    public static void l(int i3, final d dVar) {
        f430238a.i("ICGameRoomAdminHelper", "[getAdminSubmenus] source = " + i3);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveGetAdminSubMenuRequest(i3), new ILiveNetRequest.Callback() { // from class: qw0.g
            @Override // com.tencent.mobileqq.icgame.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                k.s(k.d.this, qQLiveResponse);
            }
        });
    }

    public static void m(final long j3, final long j16, final long j17, int i3, final f fVar) {
        f430238a.i("ICGameRoomAdminHelper", "[getBannedList] roomID=" + j3 + ",subRoomID=" + j16 + ",anchorID=" + j17 + ",dataSize=" + i3);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveGetBannedListRequest(j3, i3), new ILiveNetRequest.Callback() { // from class: qw0.h
            @Override // com.tencent.mobileqq.icgame.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                k.t(k.f.this, j3, j16, j17, qQLiveResponse);
            }
        });
    }

    public static void n(final long j3, long j16, final e eVar) {
        f430238a.i("ICGameRoomAdminHelper", "[getChatStatus] uin=" + j3 + ",roomId=" + j16);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveGetChatStatusRequest(j16, j3), new ILiveNetRequest.Callback() { // from class: qw0.b
            @Override // com.tencent.mobileqq.icgame.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                k.u(k.e.this, j3, qQLiveResponse);
            }
        });
    }

    private static LinkedHashMap<String, Integer> o() {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(BaseApplication.getContext().getResources().getString(R.string.ylr), 1);
        linkedHashMap.put(BaseApplication.getContext().getResources().getString(R.string.yls), 2);
        linkedHashMap.put(BaseApplication.getContext().getResources().getString(R.string.ylt), 3);
        linkedHashMap.put(BaseApplication.getContext().getResources().getString(R.string.ylu), 4);
        return linkedHashMap;
    }

    public static void p(final long j3, final long j16, final long j17, int i3, final f fVar) {
        f430238a.i("ICGameRoomAdminHelper", "[getRemoveHistoryList] roomID=" + j3 + ",subRoomID=" + j16 + ",anchorID=" + j17 + ",dataSize=" + i3);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveGetKickoutListRequest(j3, j17, i3), new ILiveNetRequest.Callback() { // from class: qw0.i
            @Override // com.tencent.mobileqq.icgame.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                k.v(k.f.this, j3, j16, j17, qQLiveResponse);
            }
        });
    }

    public static void q(long j3, long j16, long j17, final c cVar) {
        if (cVar == null) {
            return;
        }
        f430238a.i("ICGameRoomAdminHelper", "[isRoomAdmin] anchorUin=" + j3 + ",uin=" + j16 + ",roomId=" + j17);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveIsRoomAdminRequest(j3, j16, j17), new ILiveNetRequest.Callback() { // from class: qw0.c
            @Override // com.tencent.mobileqq.icgame.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                k.w(k.c.this, qQLiveResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r(g gVar, QQLiveResponse qQLiveResponse) {
        String str;
        LiveChatCheck$CancleKickOutSomebodyRsp liveChatCheck$CancleKickOutSomebodyRsp = (LiveChatCheck$CancleKickOutSomebodyRsp) qQLiveResponse.getRsp();
        if (!qQLiveResponse.isFailed() && liveChatCheck$CancleKickOutSomebodyRsp != null) {
            if (liveChatCheck$CancleKickOutSomebodyRsp.retcode.get() != 0) {
                if (liveChatCheck$CancleKickOutSomebodyRsp.f116230msg.has()) {
                    str = liveChatCheck$CancleKickOutSomebodyRsp.f116230msg.get().toStringUtf8();
                } else {
                    str = "";
                }
                f430238a.w("ICGameRoomAdminHelper", "[cancelKickOut] rsp failed, retCode=" + liveChatCheck$CancleKickOutSomebodyRsp.retcode.get() + ", msg=" + str);
                m.f(str, false, 0);
                gVar.onResult(false);
                return;
            }
            f430238a.i("ICGameRoomAdminHelper", "[cancelKickOut] success");
            m.f(BaseApplication.getContext().getString(R.string.f237297go), false, 2);
            gVar.onResult(true);
            return;
        }
        f430238a.w("ICGameRoomAdminHelper", "[cancelKickOut] response failed, errCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
        m.h(R.string.f223786h6, false, 0);
        gVar.onResult(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s(d dVar, QQLiveResponse qQLiveResponse) {
        LiveChatCheck$AdminMenuListRsp liveChatCheck$AdminMenuListRsp = (LiveChatCheck$AdminMenuListRsp) qQLiveResponse.getRsp();
        if (!qQLiveResponse.isFailed() && liveChatCheck$AdminMenuListRsp != null) {
            if (!liveChatCheck$AdminMenuListRsp.menu_list.has() || liveChatCheck$AdminMenuListRsp.menu_list.get().isEmpty()) {
                f430238a.w("ICGameRoomAdminHelper", "[getAdminSubmenus] no menu list");
                dVar.a(o());
            }
            LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
            for (LiveChatCheck$AdminMenu liveChatCheck$AdminMenu : liveChatCheck$AdminMenuListRsp.menu_list.get()) {
                if (liveChatCheck$AdminMenu.menu_id.has() && liveChatCheck$AdminMenu.menu_msg.has()) {
                    linkedHashMap.put(liveChatCheck$AdminMenu.menu_msg.get().toStringUtf8(), Integer.valueOf(liveChatCheck$AdminMenu.menu_id.get()));
                }
            }
            if (linkedHashMap.isEmpty()) {
                f430238a.i("ICGameRoomAdminHelper", "[getAdminSubmenus] empty menu list");
                dVar.a(o());
                return;
            }
            f430238a.i("ICGameRoomAdminHelper", "[getAdminSubmenus] success, size=" + linkedHashMap.size());
            dVar.a(linkedHashMap);
            return;
        }
        f430238a.w("ICGameRoomAdminHelper", "[getAdminSubmenus] response failed, errCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
        dVar.a(o());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(f fVar, long j3, long j16, long j17, QQLiveResponse qQLiveResponse) {
        LiveChatCheck$BatchGetBannedChatUserRsp liveChatCheck$BatchGetBannedChatUserRsp = (LiveChatCheck$BatchGetBannedChatUserRsp) qQLiveResponse.getRsp();
        if (!qQLiveResponse.isFailed() && liveChatCheck$BatchGetBannedChatUserRsp != null) {
            if (liveChatCheck$BatchGetBannedChatUserRsp.retcode.get() != 0) {
                f430238a.w("ICGameRoomAdminHelper", "[getBannedList] rsp failed, retCode=" + liveChatCheck$BatchGetBannedChatUserRsp.retcode.get());
                fVar.onFail();
                return;
            }
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            boolean z16 = true;
            if (liveChatCheck$BatchGetBannedChatUserRsp.is_end.get() != 1) {
                z16 = false;
            }
            for (LiveChatCheck$RoomUserInfo liveChatCheck$RoomUserInfo : liveChatCheck$BatchGetBannedChatUserRsp.userlist.get()) {
                sw0.a aVar = new sw0.a();
                aVar.f434873f = i3;
                aVar.f434875h = j3;
                aVar.f434874g = j16;
                aVar.f434876i = j17;
                aVar.f434868a = liveChatCheck$RoomUserInfo.face_url.get().toStringUtf8();
                aVar.f434869b = liveChatCheck$RoomUserInfo.nick_name.get().toStringUtf8();
                aVar.f434870c = liveChatCheck$RoomUserInfo.gender.get();
                aVar.f434872e = liveChatCheck$RoomUserInfo.uid.get();
                aVar.f434871d = "\u5904\u7f5a\u81f3" + new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date(liveChatCheck$RoomUserInfo.op_time.get() * 1000));
                arrayList.add(aVar);
                z16 = z16;
                i3 = 0;
            }
            f430238a.i("ICGameRoomAdminHelper", "[getBannedList] success, size=" + arrayList.size());
            fVar.onSuccess(arrayList, z16);
            return;
        }
        f430238a.w("ICGameRoomAdminHelper", "[getBannedList] response failed, errCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
        fVar.onFail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(e eVar, long j3, QQLiveResponse qQLiveResponse) {
        if (k(qQLiveResponse, 2, "[getChatStatus]")) {
            eVar.onResult(false);
            return;
        }
        LiveChatCheck$QueryChatStatusRsp liveChatCheck$QueryChatStatusRsp = ((LiveChatCheck$ChatCheckRspBody) qQLiveResponse.getRsp()).query_rsp;
        if (!liveChatCheck$QueryChatStatusRsp.has()) {
            f430238a.w("ICGameRoomAdminHelper", "[getChatStatus] rsp failed");
            eVar.onResult(false);
            return;
        }
        f430238a.i("ICGameRoomAdminHelper", "[getChatStatus] success");
        if (liveChatCheck$QueryChatStatusRsp.uin.has()) {
            Iterator<Long> it = liveChatCheck$QueryChatStatusRsp.uin.get().iterator();
            while (it.hasNext()) {
                if (it.next().longValue() == j3) {
                    eVar.onResult(true);
                    f430238a.i("ICGameRoomAdminHelper", "[getChatStatus] " + j3 + " is chat forbidden");
                    return;
                }
            }
        }
        eVar.onResult(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(f fVar, long j3, long j16, long j17, QQLiveResponse qQLiveResponse) {
        String str;
        LiveChatCheck$BatchGetKickOutUserRsp liveChatCheck$BatchGetKickOutUserRsp = (LiveChatCheck$BatchGetKickOutUserRsp) qQLiveResponse.getRsp();
        if (!qQLiveResponse.isFailed() && liveChatCheck$BatchGetKickOutUserRsp != null) {
            boolean z16 = false;
            int i3 = 1;
            if (liveChatCheck$BatchGetKickOutUserRsp.retcode.get() != 0) {
                f430238a.w("ICGameRoomAdminHelper", "[getRemoveHistoryList] rsp failed, retCode=" + liveChatCheck$BatchGetKickOutUserRsp.retcode.get());
                if (liveChatCheck$BatchGetKickOutUserRsp.f116229msg.has()) {
                    str = liveChatCheck$BatchGetKickOutUserRsp.f116229msg.get().toStringUtf8();
                } else {
                    str = "";
                }
                if (!TextUtils.isEmpty(str) && liveChatCheck$BatchGetKickOutUserRsp.retcode.get() == 404) {
                    m.f(str, false, 1);
                }
                fVar.onFail();
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (liveChatCheck$BatchGetKickOutUserRsp.is_end.get() == 1) {
                z16 = true;
            }
            for (LiveChatCheck$RoomUserInfo liveChatCheck$RoomUserInfo : liveChatCheck$BatchGetKickOutUserRsp.userlist.get()) {
                sw0.a aVar = new sw0.a();
                aVar.f434873f = i3;
                aVar.f434875h = j3;
                aVar.f434874g = j16;
                aVar.f434876i = j17;
                aVar.f434868a = liveChatCheck$RoomUserInfo.face_url.get().toStringUtf8();
                aVar.f434869b = liveChatCheck$RoomUserInfo.nick_name.get().toStringUtf8();
                aVar.f434870c = liveChatCheck$RoomUserInfo.gender.get();
                aVar.f434872e = liveChatCheck$RoomUserInfo.uid.get();
                aVar.f434871d = "\u5904\u7f5a\u81f3" + new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date(liveChatCheck$RoomUserInfo.op_time.get() * 1000));
                arrayList.add(aVar);
                i3 = 1;
            }
            f430238a.i("ICGameRoomAdminHelper", "[getRemoveHistoryList] success, size=" + arrayList.size());
            fVar.onSuccess(arrayList, z16);
            return;
        }
        f430238a.w("ICGameRoomAdminHelper", "[getRemoveHistoryList] response failed, errCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
        fVar.onFail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(c cVar, QQLiveResponse qQLiveResponse) {
        if (k(qQLiveResponse, 4, "[isRoomAdmin]")) {
            cVar.a(false);
            return;
        }
        LiveChatCheck$IsRoomAdminRsp liveChatCheck$IsRoomAdminRsp = ((LiveChatCheck$ChatCheckRspBody) qQLiveResponse.getRsp()).isadmin_rsp;
        if (liveChatCheck$IsRoomAdminRsp.has() && liveChatCheck$IsRoomAdminRsp.retcode.get() == 0) {
            f430238a.i("ICGameRoomAdminHelper", "[isRoomAdmin] success, isAdmin=" + liveChatCheck$IsRoomAdminRsp.is_admin.get());
            cVar.a(liveChatCheck$IsRoomAdminRsp.is_admin.get());
            return;
        }
        f430238a.w("ICGameRoomAdminHelper", "[isRoomAdmin] rsp failed, retCode=" + liveChatCheck$IsRoomAdminRsp.retcode.get());
        cVar.a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(QQLiveResponse qQLiveResponse) {
        String str;
        if (k(qQLiveResponse, 7, "[performKickOut]")) {
            m.h(R.string.f225226l2, false, 2);
            return;
        }
        LiveChatCheck$KickOutSomebodyRsp liveChatCheck$KickOutSomebodyRsp = ((LiveChatCheck$ChatCheckRspBody) qQLiveResponse.getRsp()).kickout_rsp;
        if (liveChatCheck$KickOutSomebodyRsp.f116232msg.has()) {
            str = liveChatCheck$KickOutSomebodyRsp.f116232msg.get().toStringUtf8();
        } else {
            str = "";
        }
        if (liveChatCheck$KickOutSomebodyRsp.has() && liveChatCheck$KickOutSomebodyRsp.retcode.get() != 1014) {
            if (liveChatCheck$KickOutSomebodyRsp.retcode.get() != 0) {
                if (TextUtils.isEmpty(str)) {
                    str = BaseApplication.getContext().getString(R.string.f168162ew);
                }
                m.f(str, false, 0);
                f430238a.w("ICGameRoomAdminHelper", "[performKickOut] rsp failed, retCode= " + liveChatCheck$KickOutSomebodyRsp.retcode + ", msg=" + str);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = BaseApplication.getContext().getString(R.string.f168182ey);
            }
            f430238a.i("ICGameRoomAdminHelper", "[performKickOut] success, msg=" + str);
            m.f(str, false, 2);
            return;
        }
        m.f(str, false, 2);
        f430238a.w("ICGameRoomAdminHelper", "[performKickOut] retCode=" + liveChatCheck$KickOutSomebodyRsp.retcode.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y(h hVar, QQLiveResponse qQLiveResponse) {
        String str;
        if (k(qQLiveResponse, 1, "[setChatStatus]")) {
            m.h(R.string.ci7, false, 1);
            hVar.onResult(false);
            return;
        }
        LiveChatCheck$SetChatStatusRsp liveChatCheck$SetChatStatusRsp = ((LiveChatCheck$ChatCheckRspBody) qQLiveResponse.getRsp()).set_rsp;
        if (liveChatCheck$SetChatStatusRsp.f116234msg.has()) {
            str = liveChatCheck$SetChatStatusRsp.f116234msg.get().toStringUtf8();
        } else {
            str = "";
        }
        if (liveChatCheck$SetChatStatusRsp.has() && liveChatCheck$SetChatStatusRsp.result.get() == 0) {
            f430238a.i("ICGameRoomAdminHelper", "[setChatStatus] success, " + liveChatCheck$SetChatStatusRsp.allow_chat.get());
            if (liveChatCheck$SetChatStatusRsp.allow_chat.get()) {
                m.f(BaseApplication.getContext().getString(R.string.f237177gc), false, 2);
                hVar.onResult(true);
                return;
            } else {
                m.f(BaseApplication.getContext().getString(R.string.f13566022), false, 2);
                hVar.onResult(false);
                return;
            }
        }
        f430238a.e("ICGameRoomAdminHelper", "[setChatStatus] rsp failed, result=" + liveChatCheck$SetChatStatusRsp.result.get() + ", msg=" + str);
        m.h(R.string.f225226l2, false, 2);
        hVar.onResult(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(i iVar, boolean z16, long j3, long j16, QQLiveResponse qQLiveResponse) {
        String str;
        if (k(qQLiveResponse, 3, "[setRoomAdmin]")) {
            m.h(R.string.ci7, false, 1);
            return;
        }
        LiveChatCheck$SetRoomAdminRsp liveChatCheck$SetRoomAdminRsp = ((LiveChatCheck$ChatCheckRspBody) qQLiveResponse.getRsp()).roomadmin_rsp;
        if (liveChatCheck$SetRoomAdminRsp.f116235msg.has()) {
            str = liveChatCheck$SetRoomAdminRsp.f116235msg.get().toStringUtf8();
        } else {
            str = "";
        }
        String str2 = str;
        int i3 = liveChatCheck$SetRoomAdminRsp.max_allow_admin.get();
        if (liveChatCheck$SetRoomAdminRsp.has() && liveChatCheck$SetRoomAdminRsp.retcode.get() == 0) {
            m.f(str2, false, 2);
        } else {
            f430238a.w("ICGameRoomAdminHelper", "[setRoomAdmin] rsp failed, retCode= " + liveChatCheck$SetRoomAdminRsp.retcode + ", msg=" + str2);
            m.f(str2, false, 1);
        }
        f430238a.i("ICGameRoomAdminHelper", "[setRoomAdmin] success, maxAllowAdmin=" + i3);
        if (iVar != null) {
            iVar.a(z16, j3, j16, liveChatCheck$SetRoomAdminRsp.retcode.get(), i3, str2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
