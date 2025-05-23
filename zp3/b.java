package zp3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.ax;
import com.tencent.open.model.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.Foreground;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.appauth_comm$AuthGroupTuple;
import tencent.im.oidb.oidb_0xd55$CheckUserAuthRsp;
import tencent.im.oidb.oidb_0xd55$DecryptRsp;
import tencent.im.oidb.oidb_0xd55$RspBody;
import tencent.im.oidb.oidb_0xd55$UserAuthResult;
import tencent.im.oidb.qqconnect$Appinfo;
import zp3.d;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b implements d {

    /* renamed from: a, reason: collision with root package name */
    private yp3.b f452980a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.b f452981d;

        a(d.b bVar) {
            this.f452981d = bVar;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            Object valueOf;
            hd0.c.k("CommonChannelJumpActionHandlerHelper", "checkAppSignAndOpenidDiff onResult: code= " + i3);
            try {
                oidb_0xd55$RspBody c16 = xp3.b.c(bArr);
                if (c16 == null) {
                    hd0.c.g("CommonChannelJumpActionHandlerHelper", "checkAppSignAndOpenidDiff onResult 0xd55 rspBody null");
                    this.f452981d.a(-1, bArr, bundle, null);
                    return;
                }
                qqconnect$Appinfo qqconnect_appinfo = c16.appinfo.get();
                if (qqconnect_appinfo == null) {
                    hd0.c.g("CommonChannelJumpActionHandlerHelper", "checkAppSignAndOpenidDiff onResult 0xd55 appInfo null");
                    this.f452981d.a(-1, bArr, bundle, null);
                    return;
                }
                oidb_0xd55$CheckUserAuthRsp oidb_0xd55_checkuserauthrsp = c16.check_user_auth_rsp.get();
                if (oidb_0xd55_checkuserauthrsp != null) {
                    List<oidb_0xd55$UserAuthResult> list = oidb_0xd55_checkuserauthrsp.auth_results.get();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("onResult checkUserAuthRsp user size: ");
                    if (list == null) {
                        valueOf = "null";
                    } else {
                        valueOf = Integer.valueOf(list.size());
                    }
                    sb5.append(valueOf);
                    hd0.c.k("CommonChannelJumpActionHandlerHelper", sb5.toString());
                    if (list != null) {
                        for (oidb_0xd55$UserAuthResult oidb_0xd55_userauthresult : list) {
                            hd0.c.k("CommonChannelJumpActionHandlerHelper", "onResult userAuthResult: " + oidb_0xd55_userauthresult.openid.get() + "[" + oidb_0xd55_userauthresult.uin.get() + "]: " + oidb_0xd55_userauthresult.result.get() + "");
                        }
                    }
                } else {
                    hd0.c.g("CommonChannelJumpActionHandlerHelper", "onResult checkUserAuthRsp null");
                }
                this.f452981d.a(i3, bArr, bundle, new AppInfo(qqconnect_appinfo));
            } catch (Exception e16) {
                hd0.c.h("CommonChannelJumpActionHandlerHelper", "checkAppSignAndOpenidDiff onResult exception!", e16);
                b.this.c(Foreground.getTopActivity(), i3, "Handle Exception");
            }
        }
    }

    public b(yp3.b bVar) {
        this.f452980a = bVar;
    }

    private d.a f() {
        List<appauth_comm$AuthGroupTuple> a16;
        String E = ax.E(this.f452980a.f("opensdk_ext_data"));
        if (TextUtils.isEmpty(E)) {
            return null;
        }
        try {
            d.a.C11709a c11709a = new d.a.C11709a();
            JSONObject jSONObject = new JSONObject(E);
            JSONArray optJSONArray = jSONObject.optJSONArray("open_id_list");
            hd0.c.k("CommonChannelJumpActionHandlerHelper", "findCheckAppParams openIdList: " + optJSONArray);
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    String optString = optJSONArray.optString(i3);
                    if (optString != null && !optString.isEmpty()) {
                        arrayList.add(optString);
                    }
                }
            }
            if (!arrayList.isEmpty() && (a16 = xp3.d.a(Integer.parseInt(this.f452980a.f("src_id")))) != null && !a16.isEmpty()) {
                c11709a.d(arrayList).b(a16);
            }
            String optString2 = jSONObject.optString("encrypt_str");
            if (!TextUtils.isEmpty(optString2)) {
                hd0.c.k("CommonChannelJumpActionHandlerHelper", "getEncryptStr: [" + optString2 + "]");
                c11709a.c(optString2);
            }
            return c11709a.a();
        } catch (Exception e16) {
            hd0.c.h("CommonChannelJumpActionHandlerHelper", "findCheckAppParams Exception", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(xp3.c cVar, d.b bVar) {
        xp3.b.a(this.f452980a.f307436a, cVar, 0L, new a(bVar));
    }

    @Override // zp3.d
    public void a(final d.b bVar) {
        boolean z16;
        if (bVar == null) {
            return;
        }
        String E = ax.E(this.f452980a.f("open_id"));
        String f16 = this.f452980a.f("app_id");
        String f17 = this.f452980a.f("src_id");
        if (E != null && !E.isEmpty()) {
            z16 = true;
        } else {
            z16 = false;
        }
        d.a f18 = f();
        String E2 = ax.E(this.f452980a.f("sdk_version"));
        hd0.c.k("CommonChannelJumpActionHandlerHelper", "checkAppSignAndOpenidDiff openId: " + E + ", sdkVersion: " + E2);
        final xp3.c cVar = new xp3.c();
        if (!TextUtils.isEmpty(E2)) {
            cVar.sdkVersion = E2;
        }
        cVar.needCheckSameUser = z16;
        if (E == null) {
            E = "";
        }
        cVar.openid = E;
        cVar.needCheckMiniApp = false;
        cVar.miniAppId = 0L;
        cVar.appid = Long.parseLong(f16);
        cVar.apptype = 1;
        cVar.srcId = Integer.parseInt(f17);
        cVar.packageName = this.f452980a.f307444i;
        cVar.isNeedAppInfo = true;
        cVar.rawUrl = null;
        cVar.checkAppParams = f18;
        try {
            ThreadManagerV2.excute(new Runnable() { // from class: zp3.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.g(cVar, bVar);
                }
            }, 128, null, true);
        } catch (Exception e16) {
            hd0.c.g("CommonChannelJumpActionHandlerHelper", "checkAppSignAndOpenidDiff exception: " + e16.getMessage());
        }
    }

    @Override // zp3.d
    public String b(byte[] bArr) {
        oidb_0xd55$RspBody c16 = xp3.b.c(bArr);
        if (c16 == null) {
            QLog.e("CommonChannelJumpActionHandlerHelper", 1, "parse0xd55Uid rspBody is null");
            return null;
        }
        oidb_0xd55$DecryptRsp oidb_0xd55_decryptrsp = c16.decrypt_rsp.get();
        if (oidb_0xd55_decryptrsp == null) {
            QLog.e("CommonChannelJumpActionHandlerHelper", 1, "parse0xd55Uid decryptRsp is null");
            return null;
        }
        String str = oidb_0xd55_decryptrsp.plain_text.get();
        QLog.i("CommonChannelJumpActionHandlerHelper", 1, "parse0xd55Uid: " + str);
        return str;
    }

    @Override // zp3.d
    public void c(Activity activity, int i3, String str) {
        boolean z16;
        String f16 = this.f452980a.f("app_id");
        String str2 = this.f452980a.f307444i;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        xp3.b.e(activity, str2, z16, Long.parseLong(f16), str);
    }

    @Override // zp3.d
    public void d(Intent intent) {
        if (intent == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putString(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT, this.f452980a.f307438c);
        extras.putString("pkg_name", this.f452980a.f307444i);
        intent.putExtras(extras);
    }

    @Override // zp3.d
    public String getAppId() {
        return this.f452980a.f("app_id");
    }

    @Override // zp3.d
    public Context getContext() {
        return this.f452980a.f307437b;
    }

    @Override // zp3.d
    public String getOpenId() {
        return ax.E(this.f452980a.f("open_id"));
    }

    @Override // zp3.d
    public String getPackageName() {
        return this.f452980a.f307444i;
    }
}
