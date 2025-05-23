package wy2;

import android.os.IBinder;
import android.telephony.TelephonyManager;
import com.tencent.qphone.base.util.BaseApplication;
import n.a;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {

    /* renamed from: e, reason: collision with root package name */
    private static b f446740e = null;

    /* renamed from: f, reason: collision with root package name */
    public static int f446741f = -1;

    /* renamed from: g, reason: collision with root package name */
    public static String f446742g = null;

    /* renamed from: h, reason: collision with root package name */
    public static String f446743h = "1";

    /* renamed from: a, reason: collision with root package name */
    private Object f446744a = null;

    /* renamed from: b, reason: collision with root package name */
    private TelephonyManager[] f446745b = null;

    /* renamed from: c, reason: collision with root package name */
    private Object f446746c = null;

    /* renamed from: d, reason: collision with root package name */
    private n.a[] f446747d = null;

    b() {
        try {
            c();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static b a() {
        if (f446740e == null) {
            synchronized (b.class) {
                f446740e = new b();
            }
        }
        return f446740e;
    }

    private void c() {
        n.a[] aVarArr = new n.a[2];
        this.f446747d = aVarArr;
        int i3 = f446741f;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 == 5) {
                    try {
                        this.f446744a = BaseApplication.getContext().getSystemService("phone");
                        this.f446747d[0] = a.AbstractBinderC10813a.j((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "isms"));
                        return;
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                        return;
                    }
                }
                return;
            }
            try {
                aVarArr[0] = a.AbstractBinderC10813a.j(g.a("isms"));
                this.f446747d[1] = a.AbstractBinderC10813a.j(g.a("isms2"));
                if (this.f446745b == null) {
                    TelephonyManager[] telephonyManagerArr = new TelephonyManager[2];
                    this.f446745b = telephonyManagerArr;
                    telephonyManagerArr[0] = (TelephonyManager) f.e("android.telephony.TelephonyManager", "getDefault");
                    this.f446745b[1] = (TelephonyManager) f.e("android.telephony.TelephonyManager", "getSecondary");
                    return;
                }
                return;
            } catch (Error e16) {
                e16.printStackTrace();
                return;
            } catch (Exception e17) {
                e17.printStackTrace();
                return;
            }
        }
        try {
            this.f446744a = f.g("android.telephony.MSimTelephonyManager", "getDefault", null, null);
            this.f446746c = f.g("android.telephony.MSimSmsManager", "getDefault", null, null);
        } catch (Exception e18) {
            e18.printStackTrace();
        }
    }

    public int b(int i3) {
        Object obj;
        int i16 = f446741f;
        int i17 = 1;
        if (i16 != 2) {
            if (i16 != 3) {
                if (i16 == 5 && (obj = this.f446744a) != null) {
                    try {
                        Object[] objArr = new Object[1];
                        if (i3 != 0) {
                            i17 = 5;
                        }
                        objArr[0] = Integer.valueOf(i17);
                        return ((Integer) f.d(obj, "getIccState", objArr)).intValue();
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            } else {
                TelephonyManager[] telephonyManagerArr = this.f446745b;
                if (telephonyManagerArr != null) {
                    return telephonyManagerArr[i3].getSimState();
                }
            }
        } else {
            Object obj2 = this.f446744a;
            if (obj2 != null) {
                try {
                    return ((Integer) f.d(obj2, "getSimState", new Object[]{Integer.valueOf(i3)})).intValue();
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
        }
        return 0;
    }

    public boolean d(int i3) {
        if (b(i3) == 5) {
            return true;
        }
        return false;
    }
}
