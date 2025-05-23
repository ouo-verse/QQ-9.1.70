package w5;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f444600a;

    /* renamed from: b, reason: collision with root package name */
    public String f444601b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<String> f444602c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<String> f444603d;

    /* renamed from: e, reason: collision with root package name */
    private StringBuilder f444604e = new StringBuilder(64);

    a(String str) {
        this.f444600a = str;
    }

    public static a c(String str) {
        return new a(str);
    }

    public a a(String str) {
        if (this.f444602c == null) {
            this.f444602c = new ArrayList<>();
        }
        this.f444602c.add(str);
        return this;
    }

    public a b(String str) {
        if (this.f444603d == null) {
            this.f444603d = new ArrayList<>();
        }
        this.f444603d.add(str);
        return this;
    }

    public String toString() {
        StringBuilder sb5 = this.f444604e;
        int i3 = 0;
        sb5.delete(0, sb5.length());
        StringBuilder sb6 = this.f444604e;
        sb6.append(" TAG:");
        sb6.append(this.f444600a);
        if (this.f444601b != null) {
            StringBuilder sb7 = this.f444604e;
            sb7.append(" DESC:[");
            sb7.append(this.f444601b);
            sb7.append("]");
        }
        ArrayList<String> arrayList = this.f444602c;
        if (arrayList != null && arrayList.size() != 0) {
            this.f444604e.append(" reasons:[");
            int i16 = 0;
            while (i16 < this.f444602c.size()) {
                StringBuilder sb8 = this.f444604e;
                int i17 = i16 + 1;
                sb8.append(i17);
                sb8.append(MsgSummary.STR_COLON);
                sb8.append(this.f444602c.get(i16));
                sb8.append("; ");
                i16 = i17;
            }
            this.f444604e.append("]\n\t");
        }
        ArrayList<String> arrayList2 = this.f444603d;
        if (arrayList2 != null && arrayList2.size() != 0) {
            this.f444604e.append(" solves:[");
            while (i3 < this.f444603d.size()) {
                StringBuilder sb9 = this.f444604e;
                int i18 = i3 + 1;
                sb9.append(i18);
                sb9.append(MsgSummary.STR_COLON);
                sb9.append(this.f444603d.get(i3));
                sb9.append("; ");
                i3 = i18;
            }
            this.f444604e.append("]");
        }
        return this.f444604e.toString();
    }

    public a d(String str, Object... objArr) {
        if (str == null) {
            this.f444601b = str;
        } else {
            this.f444601b = String.format(str, objArr);
        }
        return this;
    }
}
