package y72;

import android.app.Activity;
import android.app.Dialog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.matchfriend.reborn.content.main.matching.ac;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$GetDatingPurposesReq;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$GetDatingPurposesRsp;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$SetUserMatchReq;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$SetUserMatchRsp;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$UpdateDatingPurposesReq;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;
import y72.f;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Ly72/f;", "", "Ly72/a;", "listener", "", "i", "l", "", "isSuccess", "k", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, h.F, "Ly72/g;", "model", "f", "Landroid/app/Dialog;", "b", "Landroid/app/Dialog;", "matchSettingDialog", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f449542a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static Dialog matchSettingDialog;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"y72/f$a", "Ly72/a;", "Ly72/g;", "data", "", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a implements y72.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f449544a;

        a(Activity activity) {
            this.f449544a = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Activity activity, g data) {
            Intrinsics.checkNotNullParameter(activity, "$activity");
            Intrinsics.checkNotNullParameter(data, "$data");
            if (activity.isFinishing()) {
                return;
            }
            if (f.matchSettingDialog != null) {
                Dialog dialog = f.matchSettingDialog;
                boolean z16 = false;
                if (dialog != null && !dialog.isShowing()) {
                    z16 = true;
                }
                if (!z16) {
                    return;
                }
            }
            f.matchSettingDialog = new ac(activity, data);
            Dialog dialog2 = f.matchSettingDialog;
            if (dialog2 != null) {
                dialog2.show();
            }
        }

        @Override // y72.a
        public void a(final g data) {
            Intrinsics.checkNotNullParameter(data, "data");
            final Activity activity = this.f449544a;
            activity.runOnUiThread(new Runnable() { // from class: y72.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.a.c(activity, data);
                }
            });
        }
    }

    f() {
    }

    private final void i(final y72.a listener) {
        PBStringField pBStringField;
        PBEnumField pBEnumField;
        Object a16 = com.tencent.mobileqq.matchfriend.reborn.utils.d.f245469a.a("loginUserInfoKey");
        userInfo$MiniInfo userinfo_miniinfo = a16 instanceof userInfo$MiniInfo ? (userInfo$MiniInfo) a16 : null;
        final int i3 = (userinfo_miniinfo == null || (pBEnumField = userinfo_miniinfo.match_obj) == null) ? 0 : pBEnumField.get();
        userInfo$GetDatingPurposesReq userinfo_getdatingpurposesreq = new userInfo$GetDatingPurposesReq();
        String str = (userinfo_miniinfo == null || (pBStringField = userinfo_miniinfo.open_id) == null) ? null : pBStringField.get();
        if (str == null) {
            return;
        }
        userinfo_getdatingpurposesreq.open_id.set(str);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        Object businessHandler = appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.relation.common.servlet.IRelationRequestHandler");
        ((com.tencent.relation.common.servlet.a) businessHandler).Z0("QQStranger.UserInfo.SsoGetDatingPurposes", userinfo_getdatingpurposesreq.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: y72.d
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i16, boolean z16, Object obj) {
                f.j(i3, listener, i16, z16, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(int i3, y72.a listener, int i16, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        if (z16 && obj != null) {
            userInfo$GetDatingPurposesRsp userinfo_getdatingpurposesrsp = new userInfo$GetDatingPurposesRsp();
            try {
                userinfo_getdatingpurposesrsp.mergeFrom((byte[]) obj);
                g gVar = new g(i3, new ArrayList(userinfo_getdatingpurposesrsp.pick_ids.get()));
                listener.a(gVar);
                QLog.i("QQStrangerMatchSettingHelper", 1, "[fetchMatchSettingConfig] success, model=" + gVar);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQStrangerMatchSettingHelper", 1, "[fetchMatchSettingConfig] error", e16);
                f449542a.l();
                return;
            }
        }
        QLog.e("QQStrangerMatchSettingHelper", 1, "[fetchMatchSettingConfig] isSuccess:" + z16 + ", data:" + obj);
        f449542a.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        QQToast.makeText(activity, 1, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5\u3002", 0).show();
    }

    public final void f(g model) {
        PBStringField pBStringField;
        PBEnumField pBEnumField;
        Intrinsics.checkNotNullParameter(model, "model");
        com.tencent.mobileqq.matchfriend.reborn.utils.d dVar = com.tencent.mobileqq.matchfriend.reborn.utils.d.f245469a;
        Object a16 = dVar.a("loginUserInfoKey");
        userInfo$MiniInfo userinfo_miniinfo = a16 instanceof userInfo$MiniInfo ? (userInfo$MiniInfo) a16 : null;
        if (userinfo_miniinfo != null && (pBEnumField = userinfo_miniinfo.match_obj) != null) {
            pBEnumField.set(model.getMatchGender());
        }
        dVar.c("loginUserInfoKey", userinfo_miniinfo);
        String str = (userinfo_miniinfo == null || (pBStringField = userinfo_miniinfo.open_id) == null) ? null : pBStringField.get();
        if (str == null) {
            return;
        }
        QLog.i("QQStrangerMatchSettingHelper", 1, "[commitMatchSettingConfig] invoke, model=" + model);
        userInfo$SetUserMatchReq userinfo_setusermatchreq = new userInfo$SetUserMatchReq();
        userinfo_setusermatchreq.match_obj.set(model.getMatchGender());
        userInfo$UpdateDatingPurposesReq userinfo_updatedatingpurposesreq = new userInfo$UpdateDatingPurposesReq();
        userinfo_updatedatingpurposesreq.open_id.set(str);
        userinfo_updatedatingpurposesreq.pick_ids.set(model.b());
        userinfo_setusermatchreq.update_dating_purposes_req.set(userinfo_updatedatingpurposesreq);
        userinfo_setusermatchreq.is_new_kuolie_req.set(true);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        Object businessHandler = appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.relation.common.servlet.IRelationRequestHandler");
        ((com.tencent.relation.common.servlet.a) businessHandler).Z0("QQStranger.UserInfo.SsoSetUserMatch", userinfo_setusermatchreq.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: y72.b
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                f.g(i3, z16, obj);
            }
        });
    }

    public final void h() {
        Dialog dialog;
        Dialog dialog2 = matchSettingDialog;
        boolean z16 = false;
        if (dialog2 != null && dialog2.isShowing()) {
            z16 = true;
        }
        if (z16 && (dialog = matchSettingDialog) != null) {
            dialog.dismiss();
        }
        matchSettingDialog = null;
    }

    public final void m(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!NetworkUtil.isNetworkAvailable()) {
            activity.runOnUiThread(new Runnable() { // from class: y72.c
                @Override // java.lang.Runnable
                public final void run() {
                    f.n(activity);
                }
            });
        } else {
            i(new a(activity));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(int i3, boolean z16, Object obj) {
        if (z16 && obj != null) {
            userInfo$SetUserMatchRsp userinfo_setusermatchrsp = new userInfo$SetUserMatchRsp();
            try {
                userinfo_setusermatchrsp.mergeFrom((byte[]) obj);
                if (userinfo_setusermatchrsp.ret_code.get() == 0) {
                    QLog.i("QQStrangerMatchSettingHelper", 1, "[commitMatchSettingConfig] success");
                    f449542a.k(true);
                    return;
                }
                f449542a.k(false);
                QLog.e("QQStrangerMatchSettingHelper", 1, "[commitMatchSettingConfig] fail, retCode=" + userinfo_setusermatchrsp.ret_code.get() + ", errMsg=" + userinfo_setusermatchrsp.err_msg.get());
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQStrangerMatchSettingHelper", 1, "[commitMatchSettingConfig] error", e16);
                f449542a.k(false);
                return;
            }
        }
        QLog.e("QQStrangerMatchSettingHelper", 1, "[commitMatchSettingConfig] isSuccess:" + z16 + ", data:" + obj);
        f449542a.k(false);
    }

    private final void l() {
        QQToastUtil.showQQToastInUiThread(1, "\u7b5b\u9009\u8bbe\u7f6e \u62c9\u53d6\u4ea4\u53cb\u76ee\u7684\u5931\u8d25\u3002");
    }

    private final void k(boolean isSuccess) {
        if (isSuccess) {
            QQToastUtil.showQQToastInUiThread(2, "\u8bbe\u7f6e\u6210\u529f");
        } else {
            QQToastUtil.showQQToastInUiThread(1, "\u8bbe\u7f6e\u5931\u8d25");
        }
    }
}
