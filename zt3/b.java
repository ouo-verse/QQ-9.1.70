package zt3;

import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ads.data.AdParam;
import com.tencent.qqlive.superplayer.tools.utils.ITVKHttpProcessor;
import com.tencent.qqlive.superplayer.vinfo.vod.TVKVideoInfoDnsQuery;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.RSAUtils;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCKeyGenerator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: m, reason: collision with root package name */
    private static int f453219m = yt3.a.c().a();

    /* renamed from: a, reason: collision with root package name */
    private boolean f453220a;

    /* renamed from: b, reason: collision with root package name */
    private int f453221b;

    /* renamed from: c, reason: collision with root package name */
    private c f453222c;

    /* renamed from: d, reason: collision with root package name */
    private String f453223d;

    /* renamed from: k, reason: collision with root package name */
    private xt3.a f453230k;

    /* renamed from: e, reason: collision with root package name */
    private String f453224e = "";

    /* renamed from: f, reason: collision with root package name */
    private int f453225f = 0;

    /* renamed from: g, reason: collision with root package name */
    private long f453226g = 0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f453227h = true;

    /* renamed from: i, reason: collision with root package name */
    private int f453228i = 0;

    /* renamed from: j, reason: collision with root package name */
    private boolean f453229j = false;

    /* renamed from: l, reason: collision with root package name */
    private ITVKHttpProcessor.b f453231l = new a();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements ITVKHttpProcessor.b {
        a() {
        }

        @Override // com.tencent.qqlive.superplayer.tools.utils.ITVKHttpProcessor.b
        public void onFailure(IOException iOException) {
            b.this.l(iOException);
        }

        @Override // com.tencent.qqlive.superplayer.tools.utils.ITVKHttpProcessor.b
        public void onSuccess(ITVKHttpProcessor.a aVar) {
            b.this.m(aVar);
        }
    }

    public b(c cVar, xt3.a aVar) {
        this.f453222c = null;
        this.f453223d = "";
        this.f453222c = cVar;
        this.f453230k = aVar;
        this.f453223d = cVar.n();
    }

    private void c(int i3) {
        xt3.a aVar;
        if (this.f453220a && this.f453228i == f453219m && (aVar = this.f453230k) != null) {
            int i16 = i3 + TVKCommonErrorCodeUtil.CODE.VOD.CGI_GETVINFO_NETWORK_BASE_ERR;
            aVar.b(this.f453223d, String.format("%d.%d", 101, Integer.valueOf(i16)), i16);
        } else {
            d();
        }
    }

    private void e(Map<String, String> map) {
        c cVar;
        if (map != null && (cVar = this.f453222c) != null) {
            if (cVar.c() == 0) {
                map.put("clip", "0");
                map.put(AdParam.DTYPE, "3");
                return;
            }
            if (this.f453222c.c() == 4) {
                map.put("clip", "2");
                map.put(AdParam.DTYPE, "1");
                return;
            }
            if (this.f453222c.c() == 5) {
                map.put("clip", "3");
                map.put(AdParam.DTYPE, "1");
            } else if (this.f453222c.c() == 1) {
                map.put("clip", "4");
                map.put(AdParam.DTYPE, "1");
            } else if (this.f453222c.c() == 3) {
                map.put("clip", "0");
                map.put(AdParam.DTYPE, "3");
            } else {
                map.put("clip", "0");
                map.put(AdParam.DTYPE, String.valueOf(this.f453222c.c()));
            }
        }
    }

    private void f(Map<String, String> map) {
        if (65 == this.f453222c.e()) {
            map.put(AdParam.ENCRYPTVER, TVKCKeyGenerator.ENCRYPT_VER_4);
        } else if (66 == this.f453222c.e()) {
            map.put(AdParam.ENCRYPTVER, TVKCKeyGenerator.ENCRYPT_VER_4_2);
        } else {
            map.put(AdParam.ENCRYPTVER, TVKCKeyGenerator.ENCRYPT_VER_5);
        }
    }

    private void g(Map<String, String> map) {
        String[] strArr;
        if (!TextUtils.isEmpty(this.f453222c.q())) {
            if (this.f453222c.q().contains(ContainerUtils.FIELD_DELIMITER)) {
                strArr = this.f453222c.q().split(ContainerUtils.FIELD_DELIMITER);
            } else {
                strArr = new String[]{this.f453222c.q()};
            }
            for (String str : strArr) {
                String[] split = str.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split.length == 2) {
                    map.put(split[0], split[1]);
                } else if (split.length == 1) {
                    map.put(split[0], "");
                }
            }
        }
    }

    private int h(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return 0;
        }
        int i3 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                try {
                    if (entry.getKey() != null && entry.getValue() != null) {
                        if (entry.getKey().equalsIgnoreCase(TVKCommonParamEnum.REQ_PARAM_KEY_DRM)) {
                            i3 = com.tencent.qqlive.superplayer.tools.utils.g.i(entry.getValue(), 0);
                        } else {
                            map.put(entry.getKey(), entry.getValue());
                        }
                    }
                } catch (Throwable th5) {
                    com.tencent.qqlive.superplayer.tools.utils.d.c("MediaPlayerMgr[TVKCGIVInfoRequest.java]", th5, "packRequestParams failed");
                }
            }
        }
        return i3;
    }

    private String i(c cVar, Map<String, String> map) {
        cVar.e();
        int l3 = cVar.l();
        String p16 = cVar.p();
        String r16 = cVar.r();
        String a16 = cVar.a();
        cVar.g();
        String i3 = cVar.i();
        if (map != null && map.containsKey("previd") && !TextUtils.isEmpty(map.get("previd"))) {
            r16 = RSAUtils.getNewVid(map.get("previd"));
        }
        String str = r16;
        long elapsedRealtime = g.f453348a + ((SystemClock.elapsedRealtime() - g.f453349b) / 1000);
        Map<String, String> b16 = cVar.b();
        int[] iArr = {0, 0, 0};
        if (cVar.o() == 0) {
            iArr[0] = 0;
        } else {
            iArr[0] = 4;
        }
        if (b16 != null) {
            if (b16.containsKey(TVKCommonParamEnum.REQ_PARAM_KEY_TOUSHE) && b16.containsKey(TVKCommonParamEnum.REQ_PARAM_KEY_FROM_PLATFORM)) {
                iArr[0] = 16;
                iArr[1] = com.tencent.qqlive.superplayer.tools.utils.g.i(b16.get(TVKCommonParamEnum.REQ_PARAM_KEY_FROM_PLATFORM), l3);
            } else if (b16.containsKey(TVKCommonParamEnum.REQ_PARAM_KEY_SPTEST)) {
                iArr[0] = 64;
            } else if (b16.containsKey("ottflag")) {
                iArr[2] = com.tencent.qqlive.superplayer.tools.utils.g.i(b16.get("ottflag"), 0);
            } else if (b16.containsKey("dlna")) {
                iArr[0] = 1;
            }
        }
        this.f453224e = CKeyFacade.getCKey(i3, elapsedRealtime, str, a16, String.valueOf(l3), p16, iArr, 3, "");
        com.tencent.qqlive.superplayer.tools.utils.d.d("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "[vinfo][getvinfo] GenCkey guid = " + i3 + " thisTime = " + elapsedRealtime + " vid = " + str + " appVer = " + a16 + " platform = " + l3 + " sdtFrom = " + p16 + " externs[0] = " + iArr[0] + " externs[1] = " + iArr[1] + " externs[2] = " + iArr[2] + " ckey= " + this.f453224e);
        return this.f453224e;
    }

    private Map<String, String> j() {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", "qqlive");
        if (this.f453222c.v()) {
            hashMap.put("Host", yt3.b.f451187f);
        } else if (this.f453220a) {
            hashMap.put("Host", yt3.b.f451186e);
        } else {
            hashMap.put("Host", yt3.b.f451185d);
        }
        if (3 == this.f453222c.c()) {
            hashMap.put("Accept-Encoding", "gzip");
        }
        if (this.f453222c.c() == 0) {
            hashMap.put("Accept-Encoding", "gzip");
        }
        if (!TextUtils.isEmpty(this.f453222c.j())) {
            hashMap.put("Cookie", this.f453222c.j());
        }
        return hashMap;
    }

    private String k() {
        String str;
        String str2;
        if (this.f453222c.v()) {
            str = yt3.b.f451184c;
            str2 = yt3.b.f451187f;
        } else if (this.f453220a) {
            str = yt3.b.f451183b;
            str2 = yt3.b.f451186e;
        } else {
            str = yt3.b.f451182a;
            str2 = yt3.b.f451185d;
        }
        if (this.f453222c.v() && !f.a().b()) {
            TVKVideoInfoDnsQuery tVKVideoInfoDnsQuery = new TVKVideoInfoDnsQuery(str2);
            tVKVideoInfoDnsQuery.start();
            try {
                tVKVideoInfoDnsQuery.join(2000L);
            } catch (Exception unused) {
                com.tencent.qqlive.superplayer.tools.utils.d.a("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "DNS Exception");
            }
            ArrayList<String> o16 = tVKVideoInfoDnsQuery.o();
            if (o16.size() > 0) {
                str = "http://[" + o16.get(0) + "]/getvinfo";
            }
        }
        if (!this.f453227h) {
            if (yt3.a.c().d() || yt3.a.c().e()) {
                return str.replaceFirst("http", "https");
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(IOException iOException) {
        int a16;
        xt3.a aVar;
        com.tencent.qqlive.superplayer.tools.utils.d.d("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "getvinfo onFailure, e:" + iOException.toString());
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f453226g;
        if (iOException instanceof ITVKHttpProcessor.InvalidResponseCodeException) {
            a16 = ((ITVKHttpProcessor.InvalidResponseCodeException) iOException).responseCode;
        } else {
            a16 = yt3.c.a(iOException.getCause());
        }
        com.tencent.qqlive.superplayer.tools.utils.d.a("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "[vinfo][getvinfo] failed, time cost:" + elapsedRealtime + "ms error:" + iOException.toString());
        if (this.f453220a && this.f453228i == f453219m && (aVar = this.f453230k) != null) {
            int i3 = TVKCommonErrorCodeUtil.CODE.VOD.CGI_GETVINFO_NETWORK_BASE_ERR + a16;
            aVar.b(this.f453223d, String.format("%d.%d", 101, Integer.valueOf(i3)), i3);
        }
        if (a16 >= 16 && a16 <= 20) {
            this.f453227h = true;
        }
        if (this.f453222c.v()) {
            f.a().c(true);
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(ITVKHttpProcessor.a aVar) {
        String str;
        com.tencent.qqlive.superplayer.tools.utils.d.d("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "getvinfo onSuccess.");
        try {
            if (aVar.f345469a.containsKey("Content-Encoding") && aVar.f345469a.get("Content-Encoding").contains("gzip")) {
                byte[] e16 = com.tencent.qqlive.superplayer.tools.utils.g.e(aVar.f345470b);
                if (e16 != null) {
                    str = new String(e16, "UTF-8");
                } else {
                    str = "";
                }
            } else {
                str = new String(aVar.f345470b, "UTF-8");
            }
            com.tencent.qqlive.superplayer.tools.utils.d.d("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "[vinfo][getvinfo] success time cost:" + (SystemClock.elapsedRealtime() - this.f453226g) + " xml:" + str);
            if (!str.contains("<?xml")) {
                this.f453227h = false;
                d();
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                zt3.a aVar2 = new zt3.a(str);
                if (aVar2.c()) {
                    if (this.f453225f <= 2 && (aVar2.d() || aVar2.e())) {
                        com.tencent.qqlive.superplayer.tools.utils.d.d("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "[vinfo][getvinfo] cgi return retry or 85 error");
                        int i3 = this.f453225f + 1;
                        this.f453225f = i3;
                        this.f453228i--;
                        this.f453221b--;
                        if (i3 == 2) {
                            this.f453220a = !this.f453220a;
                            this.f453228i = 0;
                        }
                        d();
                        return;
                    }
                    xt3.a aVar3 = this.f453230k;
                    if (aVar3 != null) {
                        aVar3.a(this.f453223d, aVar2.b(), aVar2.a());
                        return;
                    }
                    return;
                }
                com.tencent.qqlive.superplayer.tools.utils.d.a("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "[vinfo][getvinfo] xml parse error");
                c(15);
                return;
            }
            com.tencent.qqlive.superplayer.tools.utils.d.a("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "[vinfo][getvinfo] return xml error!");
            c(13);
        } catch (Exception e17) {
            com.tencent.qqlive.superplayer.tools.utils.d.b("MediaPlayerMgr[TVKCGIVInfoRequest.java]", e17);
            c(23);
        }
    }

    private Map<String, String> n() {
        boolean z16;
        HashMap hashMap = new HashMap();
        hashMap.put("vid", this.f453222c.r());
        hashMap.put("charge", String.valueOf(this.f453222c.u()));
        hashMap.put("platform", String.valueOf(this.f453222c.l()));
        hashMap.put("sdtfrom", this.f453222c.p());
        hashMap.put("fhdswitch", "0");
        hashMap.put(TVKCommonParamEnum.REQ_PARAM_KEY_SPHLS, "1");
        hashMap.put("defn", this.f453222c.h());
        hashMap.put(TVKCommonParamEnum.REQ_PARAM_KEY_IPSTACK, String.valueOf(this.f453222c.t()));
        e(hashMap);
        if (this.f453222c.c() == 0 || this.f453222c.c() == 3) {
            if (this.f453222c.b() != null && !this.f453222c.b().isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                hashMap.put(TVKCommonParamEnum.REQ_PARAM_KEY_SPHLS, "2");
                hashMap.put("spgzip", "1");
            }
        }
        if (this.f453222c.m() > 0) {
            hashMap.put("device", String.valueOf(this.f453222c.m()));
        }
        if (this.f453222c.a() != null) {
            hashMap.put(AdParam.APPVER, this.f453222c.a());
        }
        f(hashMap);
        g(hashMap);
        Map<String, String> f16 = this.f453222c.f();
        hashMap.put(TVKCommonParamEnum.REQ_PARAM_KEY_DRM, String.valueOf(this.f453222c.d() + h(f16)));
        hashMap.put("cKey", i(this.f453222c, f16));
        hashMap.put("newnettype", String.valueOf(this.f453222c.k()));
        hashMap.put(AdParam.OTYPE, "xml");
        if (!TextUtils.isEmpty(this.f453222c.s())) {
            hashMap.put("openid", this.f453222c.s());
        }
        hashMap.put(TVKCommonParamEnum.REQ_PARAM_KEY_INNER_LOGO_TAG, "1");
        return hashMap;
    }

    public void d() {
        if (this.f453229j) {
            return;
        }
        boolean z16 = this.f453220a;
        if (!z16 && this.f453228i == f453219m) {
            this.f453220a = !z16;
            this.f453228i = 0;
        }
        int i3 = this.f453228i;
        if (i3 < f453219m) {
            this.f453221b++;
            this.f453228i = i3 + 1;
            Map<String, String> n3 = n();
            com.tencent.qqlive.superplayer.tools.utils.d.d("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "[vinfo][getvinfo] start to request, request time:" + this.f453228i);
            this.f453226g = SystemClock.elapsedRealtime();
            yt3.d.c().a(this.f453228i, k(), n3, j(), this.f453231l);
        }
    }
}
