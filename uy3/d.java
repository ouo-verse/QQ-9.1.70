package uy3;

import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.util.Random;
import mqq.app.MobileQQ;
import uy3.a;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d {

    /* renamed from: m, reason: collision with root package name */
    private static d f440626m;

    /* renamed from: b, reason: collision with root package name */
    public float f440628b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f440629c;

    /* renamed from: d, reason: collision with root package name */
    public int f440630d;

    /* renamed from: h, reason: collision with root package name */
    public a f440634h;

    /* renamed from: a, reason: collision with root package name */
    public String f440627a = "";

    /* renamed from: e, reason: collision with root package name */
    public long f440631e = 900000;

    /* renamed from: f, reason: collision with root package name */
    public float f440632f = 1.1f;

    /* renamed from: g, reason: collision with root package name */
    public float f440633g = 1.1f;

    /* renamed from: i, reason: collision with root package name */
    public boolean f440635i = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f440636j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f440637k = true;

    /* renamed from: l, reason: collision with root package name */
    public float f440638l = -1.0f;

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:10:0x0056
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    public d() {
        /*
            r7 = this;
            r7.<init>()
            java.lang.String r0 = ""
            r7.f440627a = r0
            r0 = 0
            r7.f440628b = r0
            r1 = 0
            r7.f440629c = r1
            r2 = 15
            r7.f440630d = r2
            r2 = 900000(0xdbba0, double:4.44659E-318)
            r7.f440631e = r2
            r2 = 1066192077(0x3f8ccccd, float:1.1)
            r7.f440632f = r2
            r7.f440633g = r2
            r7.f440635i = r1
            r7.f440636j = r1
            r2 = 1
            r7.f440637k = r2
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            r7.f440638l = r3
            uy3.a r3 = new uy3.a
            java.lang.String r4 = "-1"
            r3.<init>(r4)
            r7.f440634h = r3
            r3.f440614b = r2
            r7.b()
            java.lang.String r3 = "_"
            java.lang.String r4 = "0|1;15|1|0|1|1|0.00001|0.1|1;4;85,5,0.7,0.2;80,15,0.9,0.4;75,30,1,0.7_0|1;15|2|0|0.5|1|0.00001|0.1|1;4;85,5,0.7,0.2;80,15,0.9,0.4;75,30,1,0.7_0|1;15|3|0|0.25|0|0.00001|0.1|3;4;85,5,0.7,0.2;80,15,0.9,0.4;75,30,1,0.7_0|1;15|4|0|0.5|0|0.00001|0.1|4;4;85,5,0.7,0.2;80,15,0.9,0.4;75,30,1,0.7"
            java.lang.String[] r3 = r4.split(r3)
            r4 = 4
            int r5 = r3.length     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L56
            r6 = 3
            if (r5 < r6) goto L53
            java.util.Random r5 = new java.util.Random     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L56
            r5.<init>()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L56
            int r5 = r5.nextInt(r4)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L56
            r3 = r3[r5]     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L56
            goto L58
        L53:
            r3 = r3[r1]     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L56
            goto L58
        L56:
            r3 = r3[r1]
        L58:
            java.lang.String r5 = "\\|"
            java.lang.String[] r3 = r3.split(r5)     // Catch: java.lang.Exception -> Laa
            int r5 = r3.length     // Catch: java.lang.Exception -> Laa
            r6 = 7
            if (r5 >= r6) goto L64
            return
        L64:
            r5 = r3[r2]     // Catch: java.lang.Exception -> Laa
            java.lang.String r6 = ";"
            java.lang.String[] r5 = r5.split(r6)     // Catch: java.lang.Exception -> Laa
            r1 = r5[r1]     // Catch: java.lang.Exception -> Laa
            java.lang.String r6 = "1"
            boolean r1 = r1.equals(r6)     // Catch: java.lang.Exception -> Laa
            if (r1 == 0) goto L8e
            r7.f440629c = r2     // Catch: java.lang.Exception -> Laa
            r1 = r5[r2]     // Catch: java.lang.Exception -> Laa
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Exception -> Laa
            r7.f440630d = r1     // Catch: java.lang.Exception -> Laa
            r5 = 50
            if (r1 <= r5) goto L88
            r7.f440630d = r5     // Catch: java.lang.Exception -> Laa
        L88:
            int r1 = r7.f440630d     // Catch: java.lang.Exception -> Laa
            if (r1 >= r2) goto L8e
            r7.f440630d = r2     // Catch: java.lang.Exception -> Laa
        L8e:
            r1 = r3[r4]     // Catch: java.lang.Exception -> L9f
            float r1 = java.lang.Float.parseFloat(r1)     // Catch: java.lang.Exception -> L9f
            r7.f440628b = r1     // Catch: java.lang.Exception -> L9f
            r2 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto La1
            r7.f440628b = r2     // Catch: java.lang.Exception -> L9f
            goto La1
        L9f:
            r7.f440628b = r0     // Catch: java.lang.Exception -> Laa
        La1:
            int r0 = r3.length     // Catch: java.lang.Exception -> Laa
            r1 = 9
            if (r0 < r1) goto Lbb
            r7.a(r3)     // Catch: java.lang.Exception -> Laa
            goto Lbb
        Laa:
            r0 = move-exception
            boolean r1 = com.tencent.qphone.base.util.QLog.isColorLevel()
            if (r1 == 0) goto Lbb
            r1 = 2
            java.lang.String r2 = "parseDpc err"
            java.lang.String r3 = "Q.Memory.MemoryConfigs"
            com.tencent.qphone.base.util.QLog.d(r3, r1, r2, r0)
        Lbb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: uy3.d.<init>():void");
    }

    private void a(String[] strArr) {
        try {
            String[] split = strArr[8].split(";");
            if (split.length >= 5) {
                a aVar = this.f440634h;
                if (aVar == null) {
                    this.f440634h = new a(this.f440627a);
                } else {
                    aVar.f440613a = this.f440627a;
                }
                if (split[0].equals("1")) {
                    this.f440634h.f440614b = true;
                } else if (split[0].equals("0")) {
                    this.f440634h.f440614b = false;
                } else if (MobileQQ.sProcessId == 1) {
                    this.f440634h.f440614b = true;
                } else if (split[0].equals("3")) {
                    this.f440634h.f440614b = true;
                } else if (split[0].equals("4")) {
                    this.f440634h.f440614b = false;
                } else {
                    this.f440634h.f440614b = true;
                }
                this.f440634h.f440616d = Integer.parseInt(split[1]);
                String[] split2 = split[2].split(",");
                if (split2.length >= 4) {
                    this.f440634h.f440617e.put(1, new a.C11377a(Integer.parseInt(split2[0]), Integer.parseInt(split2[1]), Float.parseFloat(split2[2]), Float.parseFloat(split2[3])));
                }
                String[] split3 = split[3].split(",");
                if (split3.length >= 4) {
                    this.f440634h.f440617e.put(2, new a.C11377a(Integer.parseInt(split3[0]), Integer.parseInt(split3[1]), Float.parseFloat(split3[2]), Float.parseFloat(split3[3])));
                }
                String[] split4 = split[4].split(",");
                if (split4.length >= 4) {
                    this.f440634h.f440617e.put(3, new a.C11377a(Integer.parseInt(split4[0]), Integer.parseInt(split4[1]), Float.parseFloat(split4[2]), Float.parseFloat(split4[3])));
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.Memory.MemoryConfigs", 2, "mClearMemoryConfig= " + this.f440634h);
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void b() {
        float f16;
        boolean z16;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        if (from.decodeInt("KEY_HEAP_LEVAL_AB_RAMDOM", -1) == -1) {
            from.encodeInt("KEY_HEAP_LEVAL_AB_RAMDOM", new Random().nextInt(1000));
        }
        if (!AppSetting.isDebugVersion() && !AppSetting.isGrayVersion()) {
            if (AppSetting.isPublicVersion()) {
                f16 = 0.001f;
            } else {
                f16 = 0.0f;
            }
        } else {
            f16 = 1.0f;
        }
        if (f16 >= Math.random()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f440636j = z16;
    }

    public static synchronized d c() {
        d dVar;
        synchronized (d.class) {
            if (f440626m == null) {
                f440626m = new d();
            }
            dVar = f440626m;
        }
        return dVar;
    }
}
