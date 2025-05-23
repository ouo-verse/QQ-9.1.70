package sv2;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.AdReportParamsKey;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qzone.remote.ServiceConst;
import java.util.HashMap;
import java.util.Map;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f434832a;

    /* renamed from: b, reason: collision with root package name */
    public long f434833b;

    /* renamed from: c, reason: collision with root package name */
    public long f434834c;

    /* renamed from: d, reason: collision with root package name */
    public long f434835d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f434836e;

    /* renamed from: f, reason: collision with root package name */
    public Map<String, Object> f434837f;

    /* renamed from: g, reason: collision with root package name */
    public String f434838g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f434839h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f434840i;

    /* renamed from: j, reason: collision with root package name */
    public int f434841j;

    /* renamed from: k, reason: collision with root package name */
    public String f434842k;

    /* renamed from: l, reason: collision with root package name */
    public long f434843l;

    /* renamed from: m, reason: collision with root package name */
    public String f434844m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f434845n;

    /* renamed from: o, reason: collision with root package name */
    public long f434846o = 0;

    /* renamed from: p, reason: collision with root package name */
    public long f434847p = 0;

    /* renamed from: q, reason: collision with root package name */
    public int f434848q = 0;

    /* renamed from: r, reason: collision with root package name */
    public boolean f434849r = true;

    /* compiled from: P */
    /* renamed from: sv2.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class C11255a {

        /* renamed from: a, reason: collision with root package name */
        private a f434850a = new a();

        public a a() {
            return this.f434850a;
        }

        public C11255a b(String str) {
            this.f434850a.f434838g = str;
            return this;
        }

        public C11255a c(boolean z16) {
            this.f434850a.f434839h = z16;
            return this;
        }

        public C11255a d(int i3) {
            this.f434850a.f434841j = i3;
            return this;
        }

        public C11255a e(long j3) {
            this.f434850a.f434833b = j3;
            return this;
        }

        public C11255a f(long j3) {
            this.f434850a.f434835d = j3;
            return this;
        }

        public C11255a g(int i3) {
            this.f434850a.f434832a = i3;
            return this;
        }

        public C11255a h(String str) {
            this.f434850a.f434842k = str;
            return this;
        }

        public C11255a i(int i3) {
            this.f434850a.f434848q = i3;
            return this;
        }

        public C11255a j(boolean z16) {
            this.f434850a.f434840i = z16;
            return this;
        }

        public C11255a k(boolean z16) {
            this.f434850a.f434845n = z16;
            return this;
        }

        public C11255a l(long j3) {
            this.f434850a.f434846o = j3;
            return this;
        }

        public C11255a m(long j3) {
            this.f434850a.f434843l = j3;
            return this;
        }

        public C11255a n(String str) {
            this.f434850a.f434844m = str;
            return this;
        }

        public C11255a o(long j3) {
            this.f434850a.f434847p = j3;
            return this;
        }

        public C11255a p(long j3) {
            this.f434850a.f434834c = j3;
            return this;
        }

        public C11255a q(boolean z16) {
            this.f434850a.f434836e = z16;
            return this;
        }
    }

    private void a(int i3, Map<String, Object> map) {
        map.put(TPReportKeys.LiveExKeys.LIVE_EX_PLAY_TIME, String.valueOf(this.f434846o));
        map.put("ad_exit_position", String.valueOf(this.f434833b));
        if (i3 == 5) {
            map.put("ad_playtime", "0");
            map.put("error_code", String.valueOf(this.f434832a));
        } else {
            map.put("ad_playtime", String.valueOf(this.f434843l));
        }
    }

    private void b(int i3, Map<String, Object> map) {
        map.put(TPReportKeys.LiveExKeys.LIVE_EX_PLAY_TIME, String.valueOf(this.f434846o));
        map.put("ad_playtime", String.valueOf(this.f434843l));
        map.put("ad_exit_position", String.valueOf(this.f434833b));
    }

    private void c(int i3, @NonNull Map<String, Object> map) {
        if (1 != i3 && 3 != i3 && 8 != i3) {
            if (2 == i3) {
                b(i3, map);
                return;
            } else {
                if (4 == i3 || 9 == i3 || 5 == i3) {
                    a(i3, map);
                    return;
                }
                return;
            }
        }
        d(i3, map);
    }

    private void d(int i3, Map<String, Object> map) {
        long j3 = this.f434847p;
        if (j3 > -1) {
            map.put("ad_play_start_time", String.valueOf(j3));
        }
    }

    public Map<String, Object> e(int i3) {
        Object obj;
        HashMap hashMap = new HashMap();
        if (!y.i(this.f434837f)) {
            hashMap.putAll(this.f434837f);
        }
        if (!TextUtils.isEmpty(this.f434838g)) {
            hashMap.put(AdReportParamsKey.AD_VID, this.f434838g);
        }
        hashMap.put("ad_duration", String.valueOf(this.f434834c));
        String str = "1";
        if (this.f434839h) {
            obj = "1";
        } else {
            obj = "0";
        }
        hashMap.put("auto_mute", obj);
        if (!this.f434840i) {
            str = "0";
        }
        hashMap.put(QAdVrReportParams.ParamKey.IS_FULLSCREEN, str);
        hashMap.put("content_type_ad", String.valueOf(this.f434841j));
        hashMap.put("flow_id", this.f434842k);
        hashMap.put(ServiceConst.PARA_SESSION_ID, this.f434844m);
        hashMap.put("biz_type", "ad");
        hashMap.put(QAdVrReportParams.ParamKey.AD_SHOW_TYPE, String.valueOf(this.f434848q));
        c(i3, hashMap);
        return hashMap;
    }

    public String toString() {
        return "AdPlayerData{mErrorCode=" + this.f434832a + ", mCurrentTime=" + this.f434833b + ", mTotalTime=" + this.f434834c + ", mDisplayTime=" + this.f434835d + ", isVideoPlayFinish=" + this.f434836e + ", mVrScene=" + this.f434837f + ", mAdVid='" + this.f434838g + "', mAutoMute=" + this.f434839h + ", mIsFullScreen=" + this.f434840i + ", mContentTypeAd=" + this.f434841j + ", mFlowId='" + this.f434842k + "', mRealPlayTime=" + this.f434843l + ", mFrom=" + this.f434848q + '}';
    }
}
