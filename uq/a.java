package uq;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private static boolean f439775d = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: uq.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static class C11361a {

        /* renamed from: a, reason: collision with root package name */
        public static a f439776a = new a("ae_camera_get_info_client");
    }

    public a(String str) {
        super(str);
    }

    public static a b() {
        return C11361a.f439776a;
    }

    public static void registerModule() {
        if (f439775d) {
            return;
        }
        QIPCClientHelper.getInstance().getClient().registerModule(b());
        f439775d = true;
    }

    public static void unRegisterModule() {
        if (f439775d) {
            QIPCClientHelper.getInstance().getClient().unRegisterModule(b());
            f439775d = false;
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if ("action_get_send_to_info".equals(str)) {
            com.tencent.aelight.camera.ae.report.b.b().D1(Long.valueOf(bundle.getLong("key_receiver_type")));
            return null;
        }
        if (!"action_get_cancle_send_info".equals(str)) {
            return null;
        }
        com.tencent.aelight.camera.ae.report.b.b().K1();
        return null;
    }
}
