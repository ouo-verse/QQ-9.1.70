package zt3;

import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ads.data.AdParam;
import com.tencent.qqlive.superplayer.tools.utils.ITVKHttpProcessor;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCKeyGenerator;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Document;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {

    /* renamed from: m, reason: collision with root package name */
    private static int f453331m = yt3.a.c().a();

    /* renamed from: c, reason: collision with root package name */
    private d f453334c;

    /* renamed from: j, reason: collision with root package name */
    private xt3.b f453341j;

    /* renamed from: a, reason: collision with root package name */
    private boolean f453332a = false;

    /* renamed from: b, reason: collision with root package name */
    private int f453333b = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f453335d = 0;

    /* renamed from: e, reason: collision with root package name */
    private String f453336e = "";

    /* renamed from: f, reason: collision with root package name */
    private long f453337f = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f453338g = true;

    /* renamed from: h, reason: collision with root package name */
    private int f453339h = 0;

    /* renamed from: i, reason: collision with root package name */
    private boolean f453340i = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f453342k = false;

    /* renamed from: l, reason: collision with root package name */
    private ITVKHttpProcessor.b f453343l = new a();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements ITVKHttpProcessor.b {
        a() {
        }

        @Override // com.tencent.qqlive.superplayer.tools.utils.ITVKHttpProcessor.b
        public void onFailure(IOException iOException) {
            e.this.j(iOException);
        }

        @Override // com.tencent.qqlive.superplayer.tools.utils.ITVKHttpProcessor.b
        public void onSuccess(ITVKHttpProcessor.a aVar) {
            e.this.k(aVar);
        }
    }

    public e(d dVar, xt3.b bVar) {
        this.f453341j = null;
        this.f453334c = dVar;
        this.f453341j = bVar;
    }

    private void d(int i3) {
        if (this.f453332a && this.f453339h == f453331m) {
            int i16 = i3 + 1402000;
            l(this.f453336e, String.format("%d.%d", 103, Integer.valueOf(i16)), i16);
        } else {
            e();
        }
    }

    private static String f(d dVar) {
        int c16 = dVar.c();
        long elapsedRealtime = g.f453348a + ((SystemClock.elapsedRealtime() - g.f453349b) / 1000);
        int m3 = dVar.m();
        String o16 = dVar.o();
        String u16 = dVar.u();
        String a16 = dVar.a();
        String h16 = dVar.h();
        if (c16 <= 81) {
            return CKeyFacade.getCKey(h16, elapsedRealtime, u16, a16, String.valueOf(m3), o16, "", "");
        }
        Map<String, String> b16 = dVar.b();
        int[] iArr = {0, 0, 0};
        if (dVar.n() == 0) {
            iArr[0] = 0;
        } else {
            iArr[0] = 4;
        }
        if (b16 != null) {
            if (b16.containsKey(TVKCommonParamEnum.REQ_PARAM_KEY_TOUSHE) && b16.containsKey(TVKCommonParamEnum.REQ_PARAM_KEY_FROM_PLATFORM)) {
                iArr[0] = 16;
                iArr[1] = com.tencent.qqlive.superplayer.tools.utils.g.i(b16.get(TVKCommonParamEnum.REQ_PARAM_KEY_FROM_PLATFORM), m3);
            } else if (b16.containsKey(TVKCommonParamEnum.REQ_PARAM_KEY_SPTEST)) {
                iArr[0] = 64;
            } else if (b16.containsKey("ottflag")) {
                iArr[2] = com.tencent.qqlive.superplayer.tools.utils.g.i(b16.get("ottflag"), 0);
            }
        }
        String cKey = CKeyFacade.getCKey(h16, elapsedRealtime, u16, a16, String.valueOf(m3), o16, iArr, 3, "");
        com.tencent.qqlive.superplayer.tools.utils.d.d("MediaPlayer[TVKCGIVkeyRequest.java]", "[vinfo][getvinfo] GenCkey guid = " + h16 + " thisTime = " + elapsedRealtime + " vid = " + u16 + " appVer = " + a16 + " platform = " + m3 + " sdtFrom = " + o16 + " externs[0] = " + iArr[0] + " externs[1] = " + iArr[1] + " externs[2] = " + iArr[2] + " ckey= " + cKey);
        return cKey;
    }

    private Map<String, String> g() {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", "qqlive");
        d dVar = this.f453334c;
        if (dVar != null && !TextUtils.isEmpty(dVar.j())) {
            hashMap.put("Cookie", this.f453334c.j());
            com.tencent.qqlive.superplayer.tools.utils.d.d("MediaPlayer[TVKCGIVkeyRequest.java]", "[vinfo][getvkey]cookie:" + this.f453334c.j());
        }
        return hashMap;
    }

    private Map<String, String> h() {
        String str;
        String[] strArr;
        HashMap hashMap = new HashMap();
        hashMap.put("vid", this.f453334c.u());
        hashMap.put(TPReportKeys.PlayerStep.PLAYER_CDN_TYPE, this.f453334c.w());
        if (this.f453334c.v() == 0) {
            int p16 = this.f453334c.p();
            int d16 = this.f453334c.d();
            StringBuilder sb5 = new StringBuilder(Integer.toString(p16));
            for (int i3 = p16 + 1; i3 <= d16; i3++) {
                sb5.append("|");
                sb5.append(String.valueOf(i3));
            }
            hashMap.put("idx", sb5.toString());
        } else {
            hashMap.put("filename", this.f453334c.f());
        }
        hashMap.put("platform", String.valueOf(this.f453334c.m()));
        hashMap.put(AdParam.APPVER, this.f453334c.a());
        hashMap.put("sdtfrom", this.f453334c.o());
        hashMap.put("format", this.f453334c.g());
        if (!TextUtils.isEmpty(this.f453334c.q())) {
            if (this.f453334c.q().contains(ContainerUtils.FIELD_DELIMITER)) {
                strArr = this.f453334c.q().split(ContainerUtils.FIELD_DELIMITER);
            } else {
                strArr = new String[]{this.f453334c.q()};
            }
            for (String str2 : strArr) {
                String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split.length == 2) {
                    hashMap.put(split[0], split[1]);
                } else if (split.length == 1) {
                    hashMap.put(split[0], "");
                }
            }
            hashMap.put("path", this.f453334c.r());
            hashMap.put("spip", this.f453334c.s());
            hashMap.put("spport", this.f453334c.t());
        }
        hashMap.put("newnettype", String.valueOf(this.f453334c.l()));
        hashMap.put("qqlog", this.f453334c.k());
        if (65 == this.f453334c.c()) {
            str = TVKCKeyGenerator.ENCRYPT_VER_4;
        } else if (66 == this.f453334c.c()) {
            str = TVKCKeyGenerator.ENCRYPT_VER_4_2;
        } else {
            str = TVKCKeyGenerator.ENCRYPT_VER_5;
        }
        hashMap.put(AdParam.ENCRYPTVER, str);
        hashMap.put("cKey", f(this.f453334c));
        hashMap.put("lnk", this.f453334c.i());
        hashMap.put("linkver", String.valueOf(2));
        if (!TextUtils.isEmpty(this.f453334c.x())) {
            hashMap.put("openid", this.f453334c.x());
        }
        Map<String, String> e16 = this.f453334c.e();
        if (e16 != null && !e16.isEmpty()) {
            for (Map.Entry<String, String> entry : e16.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }

    private String i() {
        String str;
        if (this.f453334c.y()) {
            str = yt3.b.f451194m;
        } else if (this.f453332a) {
            str = yt3.b.f451193l;
        } else {
            str = yt3.b.f451192k;
        }
        if (!this.f453338g) {
            if (yt3.a.c().d() || yt3.a.c().f()) {
                return str.replaceFirst("http", "https");
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(IOException iOException) {
        int a16;
        xt3.b bVar;
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f453337f;
        if (iOException instanceof ITVKHttpProcessor.InvalidResponseCodeException) {
            a16 = ((ITVKHttpProcessor.InvalidResponseCodeException) iOException).responseCode;
        } else {
            a16 = yt3.c.a(iOException.getCause());
        }
        com.tencent.qqlive.superplayer.tools.utils.d.a("MediaPlayer[TVKCGIVkeyRequest.java]", "[vinfo][getvkey] failed, time cost:" + elapsedRealtime + "ms error:" + iOException.toString());
        if (this.f453332a && this.f453339h == f453331m && (bVar = this.f453341j) != null) {
            int i3 = 1402000 + a16;
            bVar.a(this.f453336e, String.format("%d.%d", 103, Integer.valueOf(i3)), i3);
        }
        if (a16 >= 16 && a16 <= 20) {
            this.f453338g = true;
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(ITVKHttpProcessor.a aVar) {
        String str = new String(aVar.f345470b);
        com.tencent.qqlive.superplayer.tools.utils.d.d("MediaPlayer[TVKCGIVkeyRequest.java]", "[vinfo][getvkey] success timecost:" + (SystemClock.elapsedRealtime() - this.f453337f) + " xml:" + str);
        if (!str.contains("<?xml")) {
            this.f453338g = false;
            e();
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            zt3.a aVar2 = new zt3.a(str);
            if (aVar2.c()) {
                if (this.f453335d <= 2 && (aVar2.d() || aVar2.e())) {
                    this.f453335d++;
                    com.tencent.qqlive.superplayer.tools.utils.d.a("MediaPlayer[TVKCGIVkeyRequest.java]", "[vinfo][getvkey] 85 error code, retry time" + this.f453335d);
                    this.f453333b = this.f453333b + (-1);
                    this.f453339h = this.f453339h + (-1);
                    if (this.f453335d == 2) {
                        this.f453332a = !this.f453332a;
                        this.f453339h = 0;
                    }
                    e();
                    return;
                }
                m(this.f453336e, aVar2.b(), aVar2.a());
                return;
            }
            com.tencent.qqlive.superplayer.tools.utils.d.a("MediaPlayer[TVKCGIVkeyRequest.java]", "[vinfo][getkey] xml parse error");
            d(15);
            return;
        }
        com.tencent.qqlive.superplayer.tools.utils.d.a("MediaPlayer[TVKCGIVkeyRequest.java]", "[vinfo][getvkey] response not xml");
        d(13);
    }

    private void l(String str, String str2, int i3) {
        xt3.b bVar = this.f453341j;
        if (bVar != null) {
            bVar.a(str, str2, i3);
        }
    }

    private void m(String str, String str2, Document document) {
        xt3.b bVar = this.f453341j;
        if (bVar != null) {
            bVar.b(str, str2, document);
        }
    }

    public void c() {
        this.f453340i = true;
    }

    public void e() {
        if (this.f453340i) {
            return;
        }
        boolean z16 = this.f453332a;
        if (!z16 && this.f453339h == f453331m) {
            this.f453332a = !z16;
            this.f453339h = 0;
        }
        int i3 = this.f453339h;
        if (i3 < f453331m) {
            this.f453333b++;
            this.f453339h = i3 + 1;
            Map<String, String> h16 = h();
            com.tencent.qqlive.superplayer.tools.utils.d.d("MediaPlayer[TVKCGIVkeyRequest.java]", "[vinfo][getvkey] start to request, request time = " + this.f453339h);
            this.f453337f = SystemClock.elapsedRealtime();
            yt3.d.c().a(this.f453339h, i(), h16, g(), this.f453343l);
        }
    }
}
