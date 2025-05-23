package tp;

import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c {

    /* renamed from: o, reason: collision with root package name */
    private static volatile c f437032o;

    /* renamed from: p, reason: collision with root package name */
    private static final int[] f437033p = {500, 1000, 2000, 3000, 4000, 5000, 6000, 10000000};

    /* renamed from: q, reason: collision with root package name */
    private static final int[] f437034q = {5, 10, 20, 30, 50, 100, 200, 10000000};

    /* renamed from: r, reason: collision with root package name */
    private static final int[] f437035r = {2000, 3000, 4000, 5000, 6000, 8000, 10000, 10000000};

    /* renamed from: s, reason: collision with root package name */
    private static final int[] f437036s = {12000, 15000, 20000, 30000, 40000, 50000, 60000, 10000000};

    /* renamed from: a, reason: collision with root package name */
    private long f437037a = 0;

    /* renamed from: b, reason: collision with root package name */
    private long f437038b = 0;

    /* renamed from: c, reason: collision with root package name */
    private long f437039c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f437040d = 0;

    /* renamed from: e, reason: collision with root package name */
    private long f437041e = 0;

    /* renamed from: f, reason: collision with root package name */
    private String f437042f = null;

    /* renamed from: g, reason: collision with root package name */
    private a f437043g = new a(4);

    /* renamed from: h, reason: collision with root package name */
    private a f437044h = new a(5);

    /* renamed from: i, reason: collision with root package name */
    private a f437045i = new a(6);

    /* renamed from: j, reason: collision with root package name */
    private a f437046j = new a(10);

    /* renamed from: k, reason: collision with root package name */
    private a f437047k = new a(0);

    /* renamed from: l, reason: collision with root package name */
    private a f437048l = new a(0);

    /* renamed from: m, reason: collision with root package name */
    private int f437049m = -1;

    /* renamed from: n, reason: collision with root package name */
    private long f437050n = 0;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        private int f437051a;

        /* renamed from: b, reason: collision with root package name */
        private double f437052b = 0.0d;

        /* renamed from: c, reason: collision with root package name */
        private int f437053c = 0;

        /* renamed from: d, reason: collision with root package name */
        private int[] f437054d = new int[c.f437033p.length];

        /* renamed from: e, reason: collision with root package name */
        private boolean f437055e;

        public a(int i3) {
            this.f437051a = 0;
            this.f437051a = i3;
            this.f437055e = false;
            if (i3 == 4) {
                this.f437055e = true;
            }
            int i16 = 0;
            while (true) {
                int[] iArr = this.f437054d;
                if (i16 >= iArr.length) {
                    return;
                }
                iArr[i16] = 0;
                i16++;
            }
        }

        public void a(int i3) {
            this.f437053c++;
            this.f437052b += i3;
            int[] iArr = c.f437033p;
            if (this.f437055e) {
                iArr = c.f437034q;
            }
            for (int i16 = 0; i16 < c.f437033p.length; i16++) {
                if (iArr[i16] >= i3) {
                    int[] iArr2 = this.f437054d;
                    iArr2[i16] = iArr2[i16] + 1;
                    return;
                }
            }
        }

        public void b(int i3, int i16) {
            this.f437053c++;
            this.f437052b += i3;
            int[] iArr = c.f437035r;
            if (i16 != 2) {
                iArr = c.f437036s;
            }
            for (int i17 = 0; i17 < c.f437033p.length; i17++) {
                if (iArr[i17] >= i3) {
                    int[] iArr2 = this.f437054d;
                    iArr2[i17] = iArr2[i17] + 1;
                    return;
                }
            }
        }

        public int c() {
            int i3 = this.f437053c;
            if (i3 <= 0) {
                return 0;
            }
            return (int) (this.f437052b / i3);
        }

        public int d() {
            return this.f437053c;
        }

        public String e() {
            StringBuilder sb5 = new StringBuilder();
            AVCoreLog.i("AdelieAVQualityReport", "Stat info: " + Arrays.toString(this.f437054d) + ", count: " + this.f437053c + ", sum: " + this.f437052b);
            if (this.f437053c <= 0) {
                sb5.append("000;000;000;000;000;000;000;000;");
            } else {
                for (int i3 = 0; i3 < c.f437033p.length; i3++) {
                    sb5.append((this.f437054d[i3] * 10000) / this.f437053c);
                    sb5.append(";");
                }
            }
            return sb5.toString();
        }
    }

    public static void f() {
        synchronized (c.class) {
            f437032o = null;
        }
    }

    public static c g() {
        if (f437032o == null) {
            synchronized (c.class) {
                if (f437032o == null) {
                    f437032o = new c();
                }
            }
        }
        return f437032o;
    }

    public void i() {
        QQBeaconReport.start();
        HashMap hashMap = new HashMap();
        hashMap.put("self_uin", String.valueOf(this.f437037a));
        hashMap.put("aibot_uin", String.valueOf(this.f437038b));
        hashMap.put("start_ts", String.valueOf(this.f437039c));
        hashMap.put("enter_room_ts", String.valueOf(this.f437040d));
        hashMap.put("quit_room_ts", String.valueOf(this.f437041e));
        String[] split = this.f437042f.split("\\|");
        for (int i3 = 0; i3 < split.length - 1; i3 += 2) {
            hashMap.put(split[i3], split[i3 + 1]);
        }
        hashMap.put("asr_time_stat", this.f437043g.e());
        hashMap.put("asr_time_avg", String.valueOf(this.f437043g.c()));
        hashMap.put("qpilot_llm_stat", this.f437044h.e());
        hashMap.put("qpilot_llm_avg", String.valueOf(this.f437044h.c()));
        hashMap.put("tts_stat", this.f437045i.e());
        hashMap.put("tts_avg", String.valueOf(this.f437045i.c()));
        hashMap.put("text_to_voice_stat", this.f437046j.e());
        hashMap.put("text_to_voice_avg", String.valueOf(this.f437046j.c()));
        hashMap.put("aibot_audio_reply_wait_time_avg", String.valueOf(this.f437047k.c()));
        hashMap.put("aibot_audio_reply_wait_time_stat", this.f437047k.e());
        hashMap.put("aibot_audio_reply_count", String.valueOf(this.f437047k.d()));
        hashMap.put("except_aibot_audio_reply_wait_time_stat", this.f437048l.e());
        hashMap.put("except_aibot_audio_reply_count", String.valueOf(this.f437048l.d()));
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry entry : hashMap.entrySet()) {
            sb5.append(entry.getKey());
            sb5.append(":");
            sb5.append(entry.getValue());
            sb5.append("; ");
        }
        AVCoreLog.i("AdelieAVQualityReport", "Report Aibot quality info: " + sb5.toString());
        QQBeaconReport.reportWithAppKey("0DOU0EDF8O4GDAXD", "", "adelie_av_quality_report", true, hashMap, true);
    }

    public void j(long j3) {
        this.f437038b = j3;
    }

    public void k(long j3) {
        this.f437040d = j3;
    }

    public void l(long j3) {
        this.f437041e = j3;
    }

    public void m(String str) {
        this.f437042f = str;
    }

    public void n(long j3) {
        this.f437037a = j3;
    }

    public void o(long j3) {
        this.f437039c = j3;
    }

    public void h(int i3) {
        if (i3 == 3 && this.f437050n > 0) {
            int currentTimeMillis = (int) (System.currentTimeMillis() - this.f437050n);
            int i16 = this.f437049m;
            if (i16 == 2) {
                if (currentTimeMillis > 0 && currentTimeMillis < 10000) {
                    this.f437047k.b(currentTimeMillis, i16);
                }
            } else if (currentTimeMillis >= 10000) {
                this.f437048l.b(currentTimeMillis, i16);
            }
            this.f437050n = 0L;
            AVCoreLog.i("AdelieAVQualityReport", "Report Aibot receiveStatus: " + i3 + ", prevStatus: " + this.f437049m + ", waitTime: " + currentTimeMillis);
        }
        this.f437049m = i3;
        if (i3 == 2) {
            this.f437050n = System.currentTimeMillis();
        }
    }

    public void e(int i3, int i16) {
        if (i16 <= 0) {
            return;
        }
        if (i3 == 4) {
            this.f437043g.a(i16);
            return;
        }
        if (i3 == 5) {
            this.f437044h.a(i16);
        } else if (i3 == 6) {
            this.f437045i.a(i16);
        } else {
            if (i3 != 10) {
                return;
            }
            this.f437046j.a(i16);
        }
    }
}
