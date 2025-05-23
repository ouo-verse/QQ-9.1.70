package w62;

import com.tencent.mobileqq.data.MessageRecord;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f444665a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f444666b = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f444667c = "";

    /* renamed from: d, reason: collision with root package name */
    public long f444668d = 0;

    /* renamed from: e, reason: collision with root package name */
    public List<b> f444669e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public WeakReference<MessageRecord> f444670f = null;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.f444667c;
        String str2 = ((a) obj).f444667c;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f444667c;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
