package pu;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.av.config.api.IConfigParser;
import com.tencent.av.core.f;
import com.tencent.av.utils.ad;
import com.tencent.avcore.config.Common;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.avcore.jni.config.ConfigInfoJni;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.qphone.base.util.QLog;
import java.util.Objects;
import pu.b;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {
    static byte A = 0;
    static byte B = 0;
    static int C = 1;
    static byte D = 0;
    static byte E = 0;
    static volatile boolean F = false;
    static byte G = 1;
    static volatile boolean H = false;
    static int I = -1;
    static byte J = 1;
    static byte K = 0;
    static boolean L = false;

    /* renamed from: f, reason: collision with root package name */
    static byte f427351f = 0;

    /* renamed from: g, reason: collision with root package name */
    static byte f427352g = 0;

    /* renamed from: h, reason: collision with root package name */
    static byte f427353h = 0;

    /* renamed from: i, reason: collision with root package name */
    static byte f427354i = 0;

    /* renamed from: j, reason: collision with root package name */
    static byte f427355j = 0;

    /* renamed from: k, reason: collision with root package name */
    static byte f427356k = 0;

    /* renamed from: l, reason: collision with root package name */
    static byte f427357l = 0;

    /* renamed from: m, reason: collision with root package name */
    static byte f427358m = 0;

    /* renamed from: n, reason: collision with root package name */
    static byte f427359n = 0;

    /* renamed from: o, reason: collision with root package name */
    static byte f427360o = 0;

    /* renamed from: p, reason: collision with root package name */
    static byte f427361p = 0;

    /* renamed from: q, reason: collision with root package name */
    static int f427362q = 1;

    /* renamed from: r, reason: collision with root package name */
    static byte f427363r;

    /* renamed from: s, reason: collision with root package name */
    static byte f427364s;

    /* renamed from: t, reason: collision with root package name */
    static byte f427365t;

    /* renamed from: u, reason: collision with root package name */
    static byte f427366u;

    /* renamed from: v, reason: collision with root package name */
    static byte f427367v;

    /* renamed from: w, reason: collision with root package name */
    static byte f427368w;

    /* renamed from: x, reason: collision with root package name */
    static byte f427369x;

    /* renamed from: y, reason: collision with root package name */
    static byte f427370y;

    /* renamed from: z, reason: collision with root package name */
    static byte f427371z;

    /* renamed from: a, reason: collision with root package name */
    f f427372a;

    /* renamed from: b, reason: collision with root package name */
    String f427373b;

    /* renamed from: c, reason: collision with root package name */
    b f427374c;

    /* renamed from: d, reason: collision with root package name */
    byte[] f427375d = null;

    /* renamed from: e, reason: collision with root package name */
    Context f427376e;

    public c(String str, Context context) {
        this.f427372a = null;
        this.f427374c = null;
        this.f427373b = str;
        this.f427376e = context;
        this.f427372a = new f();
        AVCoreSystemInfo.getCpuInfo();
        this.f427374c = new b();
    }

    private static byte a(boolean z16, byte b16, byte b17) {
        if (!z16) {
            return b17;
        }
        return b16;
    }

    public static int b(Context context, boolean z16, boolean z17, byte b16, boolean z18) {
        byte e16 = e(context, false, z16, z17, b16, z18);
        if (z18) {
            if (H) {
                if (QLog.isColorLevel()) {
                    QLog.d("ConfigSystemImpl", 2, "server config enabled");
                }
                return e16;
            }
            return l(context);
        }
        return e16;
    }

    static void c(Context context) {
        boolean z16;
        b.C11041b b16;
        IConfigParser b17 = du.a.b(context);
        if (b17 != null && !b17.isEmpty()) {
            ou.b bVar = new ou.b();
            H = bVar.d(b17);
            if (H) {
                f427351f = bVar.f424062b;
                f427352g = bVar.f424063c;
                f427353h = bVar.f424064d;
                f427354i = bVar.f424065e;
                f427355j = bVar.f424066f;
                f427356k = bVar.f424067g;
                f427357l = bVar.f424068h;
                f427358m = bVar.f424069i;
                f427359n = bVar.f424070j;
                f427360o = bVar.f424071k;
                f427361p = bVar.f424072l;
                f427362q = bVar.f424073m;
                if (QLog.isColorLevel()) {
                    QLog.d("ConfigSystemImpl", 2, "angle_local_front: " + ((int) f427351f) + ", angle_local_background: " + ((int) f427352g) + ", angle_remote_front_0: " + ((int) f427353h) + ", angle_remote_front_90: " + ((int) f427354i) + ", angle_remote_front_180: " + ((int) f427355j) + ", angle_remote_front_270: " + ((int) f427356k) + ", angle_remote_background_0: " + ((int) f427357l) + ", angle_remote_background_90: " + ((int) f427358m) + ", angle_remote_background_180: " + ((int) f427359n) + ", angle_remote_background_270: " + ((int) f427360o) + ", angle_sensor: " + ((int) f427361p) + ", angle_mini_sdk:" + f427362q);
                }
            }
            z16 = bVar.e(b17);
            if (z16) {
                f427363r = bVar.f424075o;
                f427364s = bVar.f424076p;
                f427365t = bVar.f424077q;
                f427366u = bVar.f424078r;
                f427367v = bVar.f424079s;
                f427368w = bVar.f424080t;
                f427369x = bVar.f424081u;
                f427370y = bVar.f424082v;
                f427371z = bVar.f424083w;
                A = bVar.f424084x;
                B = bVar.f424085y;
                C = bVar.f424086z;
                if (QLog.isColorLevel()) {
                    QLog.d("ConfigSystemImpl", 2, "angle_landscape_local_front: " + ((int) f427363r) + ", angle_landscape_local_back: " + ((int) f427364s) + ", angle_landscape_remote_front_0: " + ((int) f427365t) + ", angle_landscape_remote_front_90: " + ((int) f427366u) + ", angle_landscape_remote_front_180: " + ((int) f427367v) + ", angle_landscape_remote_front_270: " + ((int) f427368w) + ", angle_landscape_remote_back_0: " + ((int) f427369x) + ", angle_landscape_remote_back_90: " + ((int) f427370y) + ", angle_landscape_remote_back_180: " + ((int) f427371z) + ", angle_landscape_remote_back_270: " + ((int) A) + ", angle_landscape_sensor: " + ((int) B) + ", angle_landscape_mini_sdk:" + C);
                }
            }
        } else {
            z16 = false;
        }
        if (H) {
            if (QLog.isColorLevel()) {
                QLog.d("ConfigSystemImpl", 2, "using new camera angle config");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ConfigSystemImpl", 2, "using old camera angle config");
        }
        if (z16 && QLog.isColorLevel()) {
            QLog.d("ConfigSystemImpl", 2, "using new camera angle landscape config");
        }
        byte[] readFile = Common.readFile(context, Common.FILE_NAME);
        if (readFile == null) {
            return;
        }
        b bVar2 = new b();
        if (bVar2.d(readFile) == 0 && (b16 = bVar2.b()) != null) {
            b.C11041b.a aVar = b16.f427259d;
            byte b18 = aVar.f427266a;
            f427351f = b18;
            f427352g = b18;
            f427353h = aVar.f427268c;
            f427354i = aVar.f427270e;
            f427355j = aVar.f427272g;
            f427356k = aVar.f427274i;
            f427357l = aVar.f427269d;
            f427358m = aVar.f427271f;
            f427359n = aVar.f427273h;
            f427360o = aVar.f427275j;
            D = aVar.f427276k;
            E = aVar.f427277l;
            if (QLog.isColorLevel()) {
                QLog.d("ConfigSystemImpl", 2, "angle_local_front: " + ((int) f427351f) + ", angle_local_background: " + ((int) f427352g) + ", angle_remote_front_0: " + ((int) f427353h) + ", angle_remote_front_90: " + ((int) f427354i) + ", angle_remote_front_180: " + ((int) f427355j) + ", angle_remote_front_270: " + ((int) f427356k) + ", angle_remote_background_0: " + ((int) f427357l) + ", angle_remote_background_90: " + ((int) f427358m) + ", angle_remote_background_180: " + ((int) f427359n) + ", angle_remote_background_270: " + ((int) f427360o));
            }
        }
    }

    private static byte d(boolean z16, boolean z17, byte b16) {
        if (z17) {
            if (b16 == 0) {
                return a(z16, f427365t, f427353h);
            }
            if (b16 == 1) {
                return a(z16, f427366u, f427354i);
            }
            if (b16 == 2) {
                return a(z16, f427367v, f427355j);
            }
            if (b16 == 3) {
                return a(z16, f427368w, f427356k);
            }
        } else {
            if (b16 == 0) {
                return a(z16, f427369x, f427357l);
            }
            if (b16 == 1) {
                return a(z16, f427370y, f427358m);
            }
            if (b16 == 2) {
                return a(z16, f427371z, f427359n);
            }
            if (b16 == 3) {
                return a(z16, A, f427360o);
            }
        }
        return (byte) 0;
    }

    static byte e(Context context, boolean z16, boolean z17, boolean z18, byte b16, boolean z19) {
        if (!F) {
            synchronized (c.class) {
                if (!F) {
                    c(context);
                    F = true;
                }
            }
        }
        if (z18) {
            if (z17) {
                return a(z16, f427363r, f427351f);
            }
            return a(z16, f427364s, f427352g);
        }
        if (z19) {
            return a(z16, B, f427361p);
        }
        return d(z16, z17, b16);
    }

    public static byte[] g(long j3, String str, Context context) {
        zv.c.c().a(Const.BUNDLE_KEY_REQUEST, -1);
        return new c(str, context).f(j3);
    }

    public static String h(Context context) {
        byte[] readFile = Common.readFile(context, Common.FILE_NAME);
        if (readFile == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ConfigSystemImpl", 2, "getHWCodecTestPayload not have config file");
            }
            return "";
        }
        b bVar = new b();
        if (bVar.d(readFile) != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("ConfigSystemImpl", 2, "getHWCodecTestPayload unPack TLV video config err");
            }
            return "";
        }
        b.C11041b b16 = bVar.b();
        if (b16 == null) {
            return "";
        }
        return b16.f427258c;
    }

    public static int i(Context context, boolean z16, boolean z17, byte b16, boolean z18) {
        byte e16 = e(context, true, z16, z17, b16, z18);
        if (z18) {
            if (H) {
                return e16;
            }
            return l(context);
        }
        return e16;
    }

    public static int[] j(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        b bVar = new b();
        if (bVar.d(bArr) != 0) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("ConfigSystemImpl", 2, "unPack PB err");
            return null;
        }
        b.C11041b b16 = bVar.b();
        if (b16 == null) {
            return null;
        }
        b.C11041b.c cVar = b16.f427262g;
        if (!cVar.f427290a) {
            return null;
        }
        return new int[]{cVar.f427291b, cVar.f427292c, cVar.f427293d, cVar.f427294e, cVar.f427295f, cVar.f427296g, cVar.f427297h, cVar.f427298i, cVar.f427299j, cVar.f427300k, cVar.f427301l, cVar.f427302m};
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003a, code lost:
    
        if (pu.c.I < 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0066, code lost:
    
        return pu.c.I;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0062, code lost:
    
        pu.c.I = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0060, code lost:
    
        if (pu.c.I >= 0) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int l(Context context) {
        int i3 = I;
        if (i3 >= 0) {
            return i3;
        }
        try {
            try {
                String a16 = ad.a(context, "ro.qq.camera.sensor");
                if (!TextUtils.isEmpty(a16)) {
                    I = Integer.parseInt(a16);
                }
                QLog.i("ConfigSystemImpl", 1, "getSystemSenorProperty, value[" + a16 + "]");
            } catch (Exception e16) {
                I = 0;
                QLog.i("ConfigSystemImpl", 1, "getSystemSenorProperty, error[" + e16.getMessage() + "]");
            }
        } catch (Throwable th5) {
            if (I < 0) {
                I = 0;
            }
            throw th5;
        }
    }

    public static boolean m(Context context) {
        if (!L) {
            r(context, null);
        }
        if (QLog.isColorLevel()) {
            QLog.w("ConfigSystemImpl", 1, "isAudioHowlingEnable[" + ((int) K) + "]");
        }
        if (K != 1) {
            return true;
        }
        return false;
    }

    public static boolean n(Context context) {
        if (QLog.isColorLevel()) {
            QLog.d("ConfigSystemImpl", 2, "isDAudioEnable:" + ((int) G));
        }
        if (G == 1) {
            return true;
        }
        return false;
    }

    public static boolean o() {
        if (J == 1) {
            return true;
        }
        return false;
    }

    public static void p(String str, Context context, byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.d("ConfigSystemImpl", 2, "saveConfig");
        }
        if (bArr != null) {
            c cVar = new c(str, context);
            cVar.q(bArr);
            cVar.s();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void r(Context context, byte[] bArr) {
        b.C11041b.e eVar;
        boolean z16;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateAVSwitchTypeTLV, msg[");
            if (bArr != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append("]");
            QLog.w("ConfigSystemImpl", 1, sb5.toString());
        }
        if (bArr == null) {
            bArr = Common.readFile(context, Common.FILE_NAME);
        }
        if (bArr == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ConfigSystemImpl", 2, "updateAVSwitchTypeTLV, not config");
            }
        } else {
            b bVar = new b();
            int d16 = bVar.d(bArr);
            if (d16 != 0) {
                if (QLog.isColorLevel()) {
                    QLog.w("ConfigSystemImpl", 1, "updateAVSwitchTypeTLV err, ret[" + d16 + "]");
                }
            } else {
                b.C11041b b16 = bVar.b();
                if (b16 != null) {
                    eVar = b16.f427261f;
                    if (eVar == null) {
                        G = eVar.f427316a;
                        J = eVar.f427323h;
                        K = eVar.f427324i;
                        L = true;
                        if (QLog.isColorLevel()) {
                            QLog.w("ConfigSystemImpl", 1, "updateAVSwitchTypeTLV, dAudio_enable[" + ((int) G) + "], dSmallScrren_enable[" + ((int) J) + "], dAudioHowlingEnable[" + ((int) K) + "]");
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ConfigSystemImpl", 2, "updateAVSwitchTypeTLV info == null");
                        return;
                    }
                    return;
                }
            }
        }
        eVar = null;
        if (eVar == null) {
        }
    }

    public byte[] f(long j3) {
        b bVar = this.f427374c;
        Objects.requireNonNull(bVar);
        b.d dVar = new b.d();
        dVar.f427332a = 201;
        dVar.f427333b = this.f427372a.getOsType();
        dVar.f427334c = AVCoreSystemInfo.getCpuArchitecture();
        dVar.f427335d = AVCoreSystemInfo.getNumCores();
        dVar.f427336e = (int) (AVCoreSystemInfo.getMaxCpuFreq() / 1000);
        dVar.f427337f = 0;
        dVar.f427338g = 0;
        dVar.f427339h = 0;
        f fVar = this.f427372a;
        dVar.f427340i = fVar.mScreenWidth;
        dVar.f427341j = fVar.mScreenHeight;
        dVar.f427342k = 22;
        dVar.f427343l = ConfigInfoJni.getSharpConfigVersionFromFile(this.f427376e);
        dVar.f427344m = 37;
        dVar.f427345n = this.f427373b;
        dVar.f427346o = "android_" + Build.VERSION.RELEASE;
        dVar.f427347p = AVCoreSystemInfo.getDeviceNameForConfigSystem();
        dVar.f427348q = Build.VERSION.INCREMENTAL;
        dVar.f427349r = Common.getVersion(this.f427376e);
        this.f427374c.c(j3, dVar);
        return this.f427374c.a();
    }

    public String k(byte[] bArr) {
        if (bArr == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ConfigSystemImpl", 2, "getSharpConfigPayload not have config file");
            }
            return "";
        }
        b bVar = new b();
        if (bVar.d(bArr) != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("ConfigSystemImpl", 2, "getSharpConfigPayload unPack TLV video config err");
            }
            return "";
        }
        b.C11041b b16 = bVar.b();
        if (b16 == null) {
            return "";
        }
        QLog.w("ConfigSystemImpl", 1, "getSharpConfigPayload, Content[\n" + b16.f427257b + "\n], test[\n" + b16.f427258c + "\n]");
        return b16.f427257b;
    }

    void q(byte[] bArr) {
        this.f427375d = bArr;
    }

    public void s() {
        Integer num;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("WriteConfigInfoToFile begin, configMsg[");
            byte[] bArr = this.f427375d;
            if (bArr != null) {
                num = Integer.valueOf(bArr.length);
            } else {
                num = null;
            }
            sb5.append(num);
            sb5.append("]");
            QLog.w("ConfigSystemImpl", 1, sb5.toString());
        }
        byte[] bArr2 = this.f427375d;
        if (bArr2 != null && bArr2.length > 0) {
            Common.writeFile(this.f427376e, Common.FILE_NAME, bArr2);
            G = (byte) 1;
            r(this.f427376e, this.f427375d);
            String k3 = k(this.f427375d);
            if (k3 != null && k3.length() > 0) {
                String substring = k3.substring(0, 1);
                if (QLog.isColorLevel()) {
                    QLog.w("ConfigSystemImpl", 1, "WriteConfigInfoToFile, sharpConfigType[" + substring + "]");
                }
                if (substring.equals("0")) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ConfigSystemImpl", 2, "WriteConfigInfoToFile, SHARP_CONFIG_TYPE_CLEAR");
                    }
                    Common.writeFile(this.f427376e, Common.SHARP_CONFIG_PAYLOAD_FILE_NAME, "".getBytes());
                    this.f427376e.sendBroadcast(new Intent("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE"));
                    return;
                }
                if (substring.equals("1")) {
                    String substring2 = k3.substring(2);
                    if (QLog.isColorLevel()) {
                        QLog.w("ConfigSystemImpl", 1, "WriteConfigInfoToFile, FileName[" + Common.SHARP_CONFIG_PAYLOAD_FILE_NAME + "], payload[\n" + substring2 + "\n]");
                    }
                    Common.writeFile(this.f427376e, Common.SHARP_CONFIG_PAYLOAD_FILE_NAME, substring2.getBytes());
                    this.f427376e.sendBroadcast(new Intent("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE"));
                    return;
                }
                if (substring.equals("2") && QLog.isColorLevel()) {
                    QLog.d("ConfigSystemImpl", 2, "WriteConfigInfoToFile SharpConfigPayload url");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ConfigSystemImpl", 2, "WriteConfigInfoToFile, sharpConfigPayload\u4e3a\u7a7a");
            }
            Common.writeFile(this.f427376e, Common.SHARP_CONFIG_PAYLOAD_FILE_NAME, "".getBytes());
            this.f427376e.sendBroadcast(new Intent("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE"));
        }
    }
}
