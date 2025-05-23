package rr2;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.timiqqid.helper.YoloLog;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.jvm.functions.Function0;
import mqq.app.MobileQQ;
import rr2.j;

/* compiled from: P */
/* loaded from: classes18.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private String f432056a;

    /* renamed from: b, reason: collision with root package name */
    private String f432057b;

    /* renamed from: c, reason: collision with root package name */
    private pr2.c f432058c;

    public j(String str, String str2, pr2.c cVar) {
        this.f432056a = str;
        this.f432057b = str2;
        this.f432058c = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        YoloLog.d("WxLoginer", new Function0() { // from class: rr2.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String k3;
                k3 = j.k();
                return k3;
            }
        });
        ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).login(this.f432056a, new com.tencent.mobileqq.wxmini.api.data.b() { // from class: rr2.c
            @Override // com.tencent.mobileqq.wxmini.api.data.b
            public final void onCallback(boolean z16, Bundle bundle) {
                j.this.p(z16, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String k() {
        return "start doWxLogin";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String l(String str) {
        return "fetch yuekangma wx.login code result: " + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String m() {
        return "data is null";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String n(int i3, String str) {
        return "ret_code: " + i3 + ", ret_message: " + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String o() {
        return "start jump,url:" + this.f432057b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(boolean z16, Bundle bundle) {
        if (z16) {
            final String string = bundle.getString("code", "");
            YoloLog.d("WxLoginer", new Function0() { // from class: rr2.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String l3;
                    l3 = j.l(string);
                    return l3;
                }
            });
            this.f432058c.b(string);
        } else if (bundle == null) {
            YoloLog.e("WxLoginer", new Function0() { // from class: rr2.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String m3;
                    m3 = j.m();
                    return m3;
                }
            });
            this.f432058c.a(-1, "login returns null data");
            return;
        } else {
            final int i3 = bundle.getInt("ret_code", 0);
            final String string2 = bundle.getString("ret_message", "");
            YoloLog.e("WxLoginer", new Function0() { // from class: rr2.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String n3;
                    n3 = j.n(i3, string2);
                    return n3;
                }
            });
            this.f432058c.a(i3, string2);
        }
        if (!TextUtils.isEmpty(this.f432057b)) {
            YoloLog.e("WxLoginer", new Function0() { // from class: rr2.g
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String o16;
                    o16 = j.this.o();
                    return o16;
                }
            });
            ax c16 = bi.c((BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), BaseApplication.context, this.f432057b);
            if (c16 != null) {
                c16.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String q() {
        return "start wxLogin";
    }

    public void r() {
        YoloLog.d("WxLoginer", new Function0() { // from class: rr2.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String q16;
                q16 = j.q();
                return q16;
            }
        });
        ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).loadDynamicPackage(new a());
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements com.tencent.mobileqq.wxmini.api.data.b {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String c(boolean z16) {
            return "loadDynamicPackage finish,success:" + z16;
        }

        @Override // com.tencent.mobileqq.wxmini.api.data.b
        public void onCallback(final boolean z16, Bundle bundle) {
            YoloLog.d("WxLoginer", new Function0() { // from class: rr2.h
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String c16;
                    c16 = j.a.c(z16);
                    return c16;
                }
            });
            if (z16) {
                j.this.j();
                return;
            }
            final String str = "prepare wx mini runtime failed";
            YoloLog.d("WxLoginer", new Function0() { // from class: rr2.i
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String d16;
                    d16 = j.a.d(str);
                    return d16;
                }
            });
            j.this.f432058c.a(-1, "prepare wx mini runtime failed");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String d(String str) {
            return str;
        }
    }
}
