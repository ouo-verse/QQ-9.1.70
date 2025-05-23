package rr2;

import android.text.TextUtils;
import android.webkit.WebSettings;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.timiqqid.helper.YoloLog;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;
import rr2.z;

/* compiled from: P */
/* loaded from: classes18.dex */
public class z {

    /* renamed from: i, reason: collision with root package name */
    public static final MediaType f432077i = MediaType.parse("application/json;");

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private b f432078a;

    /* renamed from: e, reason: collision with root package name */
    private boolean f432082e;

    /* renamed from: f, reason: collision with root package name */
    private String f432083f;

    /* renamed from: g, reason: collision with root package name */
    private ag f432084g;

    /* renamed from: h, reason: collision with root package name */
    private af f432085h;

    /* renamed from: c, reason: collision with root package name */
    private String f432080c = "";

    /* renamed from: d, reason: collision with root package name */
    private String f432081d = "";

    /* renamed from: b, reason: collision with root package name */
    private OkHttpClient f432079b = new OkHttpClient.Builder().callTimeout(10000, TimeUnit.MILLISECONDS).build();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements pr2.c {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String e(int i3, String str) {
            return "fetch yuekangma onWxLoginError: retCode:" + i3 + ",msg:" + str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String f(String str) {
            return "fetch yuekangma wx.login code result: " + str;
        }

        @Override // pr2.c
        public void a(final int i3, final String str) {
            YoloLog.d("YuekangmaDataFetcher", new Function0() { // from class: rr2.x
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String e16;
                    e16 = z.a.e(i3, str);
                    return e16;
                }
            });
            z.this.f432078a.a(i3, str);
        }

        @Override // pr2.c
        public void b(final String str) {
            YoloLog.d("YuekangmaDataFetcher", new Function0() { // from class: rr2.y
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String f16;
                    f16 = z.a.f(str);
                    return f16;
                }
            });
            z.this.E(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface b {
        void a(int i3, String str);

        void b(af afVar);

        void c(ag agVar);

        void d(ag agVar);

        void e(int i3, String str);

        void f(int i3, String str);
    }

    public z(boolean z16, String str, @NonNull b bVar) {
        this.f432082e = z16;
        this.f432083f = str;
        this.f432078a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String A() {
        return "get yuekangma login rsp:" + this.f432084g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(RequestBody requestBody) {
        final Request build = p().url("https://zwms.gdbs.gov.cn/api/mp/login").addHeader("x-tif-did", this.f432080c).addHeader("x-ysshint", this.f432081d).post(requestBody).build();
        Call newCall = this.f432079b.newCall(build);
        try {
            YoloLog.d("YuekangmaDataFetcher", new Function0() { // from class: rr2.o
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String x16;
                    x16 = z.this.x();
                    return x16;
                }
            });
            YoloLog.d("YuekangmaDataFetcher", new Function0() { // from class: rr2.p
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String y16;
                    y16 = z.this.y();
                    return y16;
                }
            });
            YoloLog.d("YuekangmaDataFetcher", new Function0() { // from class: rr2.q
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String z16;
                    z16 = z.z(Request.this);
                    return z16;
                }
            });
            this.f432084g = new ag(newCall.execute().body().string());
            YoloLog.d("YuekangmaDataFetcher", new Function0() { // from class: rr2.r
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String A;
                    A = z.this.A();
                    return A;
                }
            });
            ag agVar = this.f432084g;
            if (agVar.f432040a == 0 && !TextUtils.isEmpty(agVar.f432044e)) {
                this.f432078a.d(this.f432084g);
                if (this.f432082e) {
                    ThreadManagerV2.excute(new Runnable() { // from class: rr2.s
                        @Override // java.lang.Runnable
                        public final void run() {
                            z.this.q();
                        }
                    }, 16, null, false);
                } else {
                    this.f432078a.c(this.f432084g);
                }
            } else {
                this.f432078a.f(-1, this.f432084g.f432041b);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            final String str = "yueshengshiLogin failed,message:" + e16.getMessage();
            YoloLog.e("YuekangmaDataFetcher", new Function0() { // from class: rr2.t
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String B;
                    B = z.B(str);
                    return B;
                }
            });
            this.f432078a.f(-1, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", "wx82d43fee89cdc7df");
            jSONObject.put("code", str);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        final RequestBody create = RequestBody.create(f432077i, jSONObject.toString());
        this.f432080c = String.valueOf((int) (Math.random() * 2.147483647E9d));
        this.f432081d = this.f432080c + System.currentTimeMillis();
        ThreadManagerV2.excute(new Runnable() { // from class: rr2.k
            @Override // java.lang.Runnable
            public final void run() {
                z.this.C(create);
            }
        }, 16, null, false);
    }

    private Request.Builder p() {
        return new Request.Builder().removeHeader("User-Agent").addHeader("User-Agent", WebSettings.getDefaultUserAgent(BaseApplication.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        final Request build = p().url("https://zwms.gdbs.gov.cn/ebus/minshengwxmp/api/r/healthcodereport/QueryFamilyList").addHeader("x-tif-did", this.f432080c).addHeader("x-ysshint", this.f432081d).addHeader("x-tif-sid", this.f432084g.f432042c).post(RequestBody.create(f432077i, "{}")).build();
        Call newCall = this.f432079b.newCall(build);
        try {
            YoloLog.d("YuekangmaDataFetcher", new Function0() { // from class: rr2.u
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String t16;
                    t16 = z.this.t();
                    return t16;
                }
            });
            YoloLog.d("YuekangmaDataFetcher", new Function0() { // from class: rr2.v
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String u16;
                    u16 = z.this.u();
                    return u16;
                }
            });
            YoloLog.d("YuekangmaDataFetcher", new Function0() { // from class: rr2.w
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String v3;
                    v3 = z.this.v();
                    return v3;
                }
            });
            YoloLog.d("YuekangmaDataFetcher", new Function0() { // from class: rr2.l
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String w3;
                    w3 = z.w(Request.this);
                    return w3;
                }
            });
            this.f432085h = new af(newCall.execute().body().string());
            YoloLog.d("YuekangmaDataFetcher", new Function0() { // from class: rr2.m
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String r16;
                    r16 = z.this.r();
                    return r16;
                }
            });
            af afVar = this.f432085h;
            if (afVar.f432028a == 0) {
                this.f432078a.b(afVar);
            } else {
                this.f432078a.e(-1, afVar.f432029b);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            final String str = "yueshengshiLogin failed,message:" + e16.getMessage();
            YoloLog.e("YuekangmaDataFetcher", new Function0() { // from class: rr2.n
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String s16;
                    s16 = z.s(str);
                    return s16;
                }
            });
            this.f432078a.e(-1, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String r() {
        return "get yuekangma family list rsp:" + this.f432085h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String t() {
        return "x-tif-did header value:" + this.f432080c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String u() {
        return "x-ysshint header value:" + this.f432081d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String v() {
        return "x-tif-sid header value:" + this.f432084g.f432042c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String w(Request request) {
        return "start request:" + request;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String x() {
        return "x-tif-did header value:" + this.f432080c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String y() {
        return "x-ysshint header value:" + this.f432081d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String z(Request request) {
        return "start request:" + request;
    }

    public void D() {
        new j("wx82d43fee89cdc7df", this.f432083f, new a()).r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String B(String str) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String s(String str) {
        return str;
    }
}
