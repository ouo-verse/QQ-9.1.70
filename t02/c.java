package t02;

import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private List<a> f435233a = new ArrayList();

    public c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (String str2 : str.split(",")) {
            if (c(str2)) {
                this.f435233a.add(new a(str2));
            }
        }
    }

    public static boolean c(String str) {
        String[] split = str.split(":");
        if (!TextUtils.isEmpty(str) && split.length == 2) {
            try {
                new BigDecimal(split[0]);
                Long.parseLong(split[1]);
                return true;
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    private void d(String str) {
        Iterator<a> it = this.f435233a.iterator();
        while (it.hasNext()) {
            if (it.next().f435234a.equals(str)) {
                it.remove();
            }
        }
    }

    public void a(String str) {
        d(str);
        this.f435233a.add(0, new a(str, System.currentTimeMillis()));
        if (this.f435233a.size() > 5) {
            this.f435233a.remove(r5.size() - 1);
        }
    }

    public List<a> b() {
        return new ArrayList(this.f435233a);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        Iterator<a> it = this.f435233a.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().toString());
        }
        return sb5.toString();
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f435234a;

        /* renamed from: b, reason: collision with root package name */
        public long f435235b;

        a(String str) {
            this.f435234a = str.split(":")[0];
            this.f435235b = Long.parseLong(str.split(":")[1]);
        }

        public String toString() {
            return String.format("%s:%d,", this.f435234a, Long.valueOf(this.f435235b));
        }

        a(String str, long j3) {
            this.f435234a = str;
            this.f435235b = j3;
        }
    }
}
