package q92;

import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.utils.bv;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0xada.oidb_0xada$ReqBody;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b {

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a implements MainTicketCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppInterface f428731a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ oidb_0xada$ReqBody f428732b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.nearby.now.b f428733c;

        a(AppInterface appInterface, oidb_0xada$ReqBody oidb_0xada_reqbody, com.tencent.mobileqq.nearby.now.b bVar) {
            this.f428731a = appInterface;
            this.f428732b = oidb_0xada_reqbody;
            this.f428733c = bVar;
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(MainTicketInfo mainTicketInfo) {
            QLog.i("ConfigReqBodyCommonFiledsUtil", 1, "configCommonFileds async get login ticket success");
            b.c(this.f428731a, this.f428732b, mainTicketInfo.getA2());
            this.f428733c.onResult(true);
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int i3, String str) {
            QLog.d("ConfigReqBodyCommonFiledsUtil", 1, "configCommonFileds async get login ticket fail errorCode=", Integer.valueOf(i3), ", errorMsg=", str);
            this.f428733c.onResult(false);
        }
    }

    public static void b(AppInterface appInterface, oidb_0xada$ReqBody oidb_0xada_reqbody, com.tencent.mobileqq.nearby.now.b bVar) {
        if (appInterface != null && oidb_0xada_reqbody != null && bVar != null) {
            oidb_0xada_reqbody.uid.set(Long.parseLong(appInterface.getCurrentAccountUin()));
            oidb_0xada_reqbody.tinyid.set(Long.parseLong(appInterface.getCurrentAccountUin()));
            TicketManager ticketManager = (TicketManager) appInterface.getManager(2);
            if (ticketManager.useAsyncTicketInterface()) {
                ticketManager.getA2(bv.b(appInterface.getCurrentUin(), 0L), 16, new a(appInterface, oidb_0xada_reqbody, bVar));
                return;
            }
            c(appInterface, oidb_0xada_reqbody, ticketManager.getA2(appInterface.getCurrentAccountUin()));
            QLog.i("ConfigReqBodyCommonFiledsUtil", 1, "configCommonFileds sync get login ticket");
            bVar.onResult(true);
            return;
        }
        QLog.e("ConfigReqBodyCommonFiledsUtil", 1, "configCommonFileds invalid param");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(AppInterface appInterface, oidb_0xada$ReqBody oidb_0xada_reqbody, String str) {
        oidb_0xada_reqbody.f435982a2.set(str);
        oidb_0xada_reqbody.platform.set(1);
        oidb_0xada_reqbody.version.set(AppSetting.f99551k);
        oidb_0xada_reqbody.original_id.set(appInterface.getCurrentAccountUin());
        oidb_0xada_reqbody.original_key.set("");
        oidb_0xada_reqbody.original_id_type.set(1);
    }
}
