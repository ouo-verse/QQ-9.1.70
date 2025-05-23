package qr2;

import android.os.Bundle;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.timiqqid.api.ITimiQQIDApi;
import com.tencent.mobileqq.timiqqid.helper.YoloLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import org.json.JSONArray;
import org.json.JSONObject;
import qr2.d;
import rr2.af;
import rr2.ag;
import rr2.j;
import rr2.z;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends QIPCModule {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements pr2.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f429360a;

        b(int i3) {
            this.f429360a = i3;
        }

        @Override // pr2.c
        public void a(int i3, String str) {
            Bundle bundle = new Bundle();
            bundle.putInt("error_code", i3);
            d.this.callbackResult(this.f429360a, EIPCResult.createResult(0, bundle));
        }

        @Override // pr2.c
        public void b(String str) {
            Bundle bundle = new Bundle();
            bundle.putString("wx_code", str);
            d.this.callbackResult(this.f429360a, EIPCResult.createResult(0, bundle));
        }
    }

    public d() {
        super(ITimiQQIDApi.QQID_QIPC_SERVER_NAME);
    }

    private void b(Bundle bundle, int i3) {
        JSONObject jSONObject = new JSONObject();
        boolean z16 = true;
        if (bundle.getInt("type") != 1) {
            z16 = false;
        }
        new z(z16, bundle.getString(QCircleScheme.AttrQQPublish.BUSINESS_RETURN_SCHEME), new a(i3, jSONObject, z16)).D();
    }

    private void c(Bundle bundle, int i3) {
        new j(bundle.getString("wx_app_id"), bundle.getString(QCircleScheme.AttrQQPublish.BUSINESS_RETURN_SCHEME), new b(i3)).r();
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if ("fetch_yuekangma".equals(str)) {
            b(bundle, i3);
            return null;
        }
        if ("wx_login".equals(str)) {
            c(bundle, i3);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements z.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f429356a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f429357b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f429358c;

        a(int i3, JSONObject jSONObject, boolean z16) {
            this.f429356a = i3;
            this.f429357b = jSONObject;
            this.f429358c = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String j(Exception exc) {
            return "onFamilyListSuccess json error," + exc.getMessage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String k(Exception exc) {
            return "onFamilyListSuccess json error," + exc.getMessage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String l(Exception exc) {
            return "onYuekangmaLoginSuccess json error," + exc.getMessage();
        }

        @Override // rr2.z.b
        public void a(int i3, String str) {
            Bundle bundle = new Bundle();
            bundle.putInt("error_domain", 1);
            bundle.putInt("error_code", i3);
            bundle.putInt("family_list_success", 2);
            d.this.callbackResult(this.f429356a, EIPCResult.createResult(0, bundle));
        }

        @Override // rr2.z.b
        public void b(af afVar) {
            JSONArray jSONArray = new JSONArray();
            String optString = this.f429357b.optString("cid");
            ArrayList<af.a> arrayList = afVar.f432032e;
            if (arrayList != null) {
                Iterator<af.a> it = arrayList.iterator();
                while (it.hasNext()) {
                    af.a next = it.next();
                    JSONObject jSONObject = new JSONObject();
                    if (optString.equals(next.f432035c)) {
                        try {
                            this.f429357b.put("encryptCid", next.f432034b);
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            YoloLog.e("QQIDQipcServer", new Function0() { // from class: qr2.b
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    String j3;
                                    j3 = d.a.j(e16);
                                    return j3;
                                }
                            });
                        }
                    } else {
                        try {
                            jSONObject.put("name", next.f432036d);
                            jSONObject.put("cid", next.f432035c);
                            jSONObject.put("encryptCid", next.f432034b);
                            jSONObject.put("cardType", next.f432037e);
                            jSONObject.put("certified", next.f432039g);
                            jSONObject.put("isSelf", 0);
                            jSONArray.mo162put(jSONObject);
                        } catch (Exception e17) {
                            e17.printStackTrace();
                            YoloLog.e("QQIDQipcServer", new Function0() { // from class: qr2.c
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    String k3;
                                    k3 = d.a.k(e17);
                                    return k3;
                                }
                            });
                        }
                    }
                }
            }
            Bundle bundle = new Bundle();
            bundle.putInt("family_list_success", 1);
            bundle.putString("selfInfo", this.f429357b.toString());
            bundle.putString("family_list_info", jSONArray.toString());
            d.this.callbackResult(this.f429356a, EIPCResult.createResult(0, bundle));
        }

        @Override // rr2.z.b
        public void d(ag agVar) {
            try {
                this.f429357b.put("name", agVar.f432044e);
                this.f429357b.put("cid", agVar.f432043d);
                this.f429357b.put("encryptCid", "");
                this.f429357b.put("cardType", agVar.f432046g);
                this.f429357b.put("isSelf", 1);
            } catch (Exception e16) {
                e16.printStackTrace();
                YoloLog.e("QQIDQipcServer", new Function0() { // from class: qr2.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        String l3;
                        l3 = d.a.l(e16);
                        return l3;
                    }
                });
            }
            if (!this.f429358c) {
                Bundle bundle = new Bundle();
                bundle.putInt("family_list_success", 2);
                bundle.putString("selfInfo", this.f429357b.toString());
                d.this.callbackResult(this.f429356a, EIPCResult.createResult(0, bundle));
            }
        }

        @Override // rr2.z.b
        public void e(int i3, String str) {
            Bundle bundle = new Bundle();
            bundle.putString("selfInfo", this.f429357b.toString());
            d.this.callbackResult(this.f429356a, EIPCResult.createResult(0, bundle));
        }

        @Override // rr2.z.b
        public void f(int i3, String str) {
            Bundle bundle = new Bundle();
            bundle.putInt("error_domain", 2);
            bundle.putInt("error_code", i3);
            bundle.putInt("family_list_success", 2);
            d.this.callbackResult(this.f429356a, EIPCResult.createResult(0, bundle));
        }

        @Override // rr2.z.b
        public void c(ag agVar) {
        }
    }
}
