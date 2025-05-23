package rn;

import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static ThreadLocal<StringBuilder> f431694a = new C11148a();

    /* renamed from: b, reason: collision with root package name */
    private static ThreadLocal<Calendar> f431695b = new b();

    /* compiled from: P */
    /* renamed from: rn.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    class C11148a extends ThreadLocal<StringBuilder> {
        C11148a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public synchronized StringBuilder initialValue() {
            return new StringBuilder(32);
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class b extends ThreadLocal<Calendar> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public synchronized Calendar initialValue() {
            return Calendar.getInstance();
        }
    }

    private static String a(long j3, long j16, boolean z16) {
        Object valueOf;
        Object valueOf2;
        Object valueOf3;
        Object valueOf4;
        Calendar calendar = f431695b.get();
        if (calendar == null) {
            QLog.e("QZMDateUtils", 1, "calendar from tl is null");
            return "";
        }
        calendar.setTimeInMillis(j3);
        int i3 = calendar.get(5);
        int i16 = calendar.get(11);
        int i17 = calendar.get(12);
        int i18 = calendar.get(1);
        int i19 = calendar.get(2) + 1;
        int i26 = calendar.get(6);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j16);
        int i27 = calendar2.get(1);
        int d16 = d(i18, i26, i27, calendar2.get(6));
        StringBuilder sb5 = f431694a.get();
        if (sb5 == null) {
            QLog.e("QZMDateUtils", 1, "date util string builder is null");
            return "";
        }
        sb5.delete(0, sb5.length());
        if (d16 == 1) {
            sb5.append("\u6628\u5929 ");
            if (i16 < 10) {
                valueOf3 = "0" + i16;
            } else {
                valueOf3 = Integer.valueOf(i16);
            }
            sb5.append(valueOf3);
            sb5.append(":");
            if (i17 < 10) {
                valueOf4 = "0" + i17;
            } else {
                valueOf4 = Integer.valueOf(i17);
            }
            sb5.append(valueOf4);
            return sb5.toString();
        }
        if (d16 == 2) {
            sb5.append("\u524d\u5929 ");
            if (i16 < 10) {
                valueOf = "0" + i16;
            } else {
                valueOf = Integer.valueOf(i16);
            }
            sb5.append(valueOf);
            sb5.append(":");
            if (i17 < 10) {
                valueOf2 = "0" + i17;
            } else {
                valueOf2 = Integer.valueOf(i17);
            }
            sb5.append(valueOf2);
            return sb5.toString();
        }
        return c(i3, i18, i19, i27, z16, sb5);
    }

    public static String b(long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        String a16 = l.a(R.string.ih9);
        String a17 = l.a(R.string.ih_);
        String a18 = l.a(R.string.ih8);
        long j16 = (currentTimeMillis - j3) / 1000;
        if (j16 < 60) {
            return a16;
        }
        if (j16 < 3600) {
            return String.format(a17, Long.valueOf(j16 / 60));
        }
        if (j16 < 86400) {
            return String.format(a18, Long.valueOf((j16 / 60) / 60));
        }
        return a(j3, currentTimeMillis, false);
    }

    private static String c(int i3, int i16, int i17, int i18, boolean z16, StringBuilder sb5) {
        Object valueOf;
        Object valueOf2;
        Object valueOf3;
        Object valueOf4;
        if (z16) {
            if (i18 != i16) {
                sb5.append(i16);
                sb5.append("\u5e74");
                sb5.append(i17);
                sb5.append("\u6708");
                sb5.append(i3);
                sb5.append("\u65e5");
                return sb5.toString();
            }
            sb5.append(i17);
            sb5.append("\u6708");
            sb5.append(i3);
            sb5.append("\u65e5");
            return sb5.toString();
        }
        if (i18 != i16) {
            sb5.append(i16);
            sb5.append("-");
            if (i17 < 10) {
                valueOf3 = "0" + i17;
            } else {
                valueOf3 = Integer.valueOf(i17);
            }
            sb5.append(valueOf3);
            sb5.append("-");
            if (i3 < 10) {
                valueOf4 = "0" + i3;
            } else {
                valueOf4 = Integer.valueOf(i3);
            }
            sb5.append(valueOf4);
            return sb5.toString();
        }
        if (i17 < 10) {
            valueOf = "0" + i17;
        } else {
            valueOf = Integer.valueOf(i17);
        }
        sb5.append(valueOf);
        sb5.append("-");
        if (i3 < 10) {
            valueOf2 = "0" + i3;
        } else {
            valueOf2 = Integer.valueOf(i3);
        }
        sb5.append(valueOf2);
        return sb5.toString();
    }

    private static int d(int i3, int i16, int i17, int i18) {
        if (i17 == i3) {
            return i18 - i16;
        }
        int i19 = 0;
        while (i3 < i17) {
            i19 = ((i3 % 4 != 0 || i3 % 100 == 0) && i3 % 400 != 0) ? i19 + 365 : i19 + 366;
            i3++;
        }
        return i19 + (i18 - i16);
    }
}
