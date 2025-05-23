package py1;

import androidx.annotation.NonNull;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f428062a;

    /* renamed from: b, reason: collision with root package name */
    public int f428063b;

    /* renamed from: c, reason: collision with root package name */
    public int f428064c;

    public a() {
        Calendar calendar = Calendar.getInstance();
        e(calendar.get(1), calendar.get(2), calendar.get(5));
    }

    public static a a(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        return new a(calendar.get(1), calendar.get(2), calendar.get(5));
    }

    public static Calendar b(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        calendar.add(14, (int) (86400000 - (calendar.get(15) + calendar.get(16))));
        return calendar;
    }

    public static long h(int i3, int i16, int i17) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(i3, i16, i17, 0, 0, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public long c() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(this.f428062a, this.f428063b, this.f428064c);
        return calendar.getTimeInMillis();
    }

    public long d() {
        return h(this.f428062a, this.f428063b, this.f428064c);
    }

    public void e(int i3, int i16, int i17) {
        this.f428062a = i3;
        this.f428063b = i16;
        this.f428064c = i17;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f428062a == aVar.f428062a && this.f428063b == aVar.f428063b && this.f428064c == aVar.f428064c) {
            return true;
        }
        return false;
    }

    public void f(a aVar) {
        if (aVar == null) {
            return;
        }
        e(aVar.f428062a, aVar.f428063b, aVar.f428064c);
    }

    public void g(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        e(calendar.get(1), calendar.get(2), calendar.get(5));
    }

    public int hashCode() {
        return (((this.f428062a * 31) + this.f428063b) * 31) + this.f428064c;
    }

    @NonNull
    public String toString() {
        return "CalendarDate{year=" + this.f428062a + ", month=" + this.f428063b + ", day=" + this.f428064c + '}';
    }

    public a(int i3, int i16, int i17) {
        e(i3, i16, i17);
    }
}
