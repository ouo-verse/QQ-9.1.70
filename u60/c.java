package u60;

import androidx.collection.ArraySet;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Set;
import ua0.j;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private Set<String> f438469a = new ArraySet();

    /* renamed from: b, reason: collision with root package name */
    private long f438470b;

    public void a(String str) {
        b(true, str);
    }

    public void b(boolean z16, String str) {
        String str2;
        if (this.f438469a.contains(str)) {
            return;
        }
        this.f438469a.add(str);
        if (this.f438470b == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f438470b;
        if (currentTimeMillis <= 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("pageName", str);
        if (z16) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put("hasData", str2);
        hashMap.put("firstFrameTime", String.valueOf(currentTimeMillis));
        j.e(true, hashMap);
        QLog.d("SearchPagePerfReporter", 1, "#reportFirstFrameEnd: pageName=" + str + ", frameTime=" + currentTimeMillis + ", hasData=" + z16);
    }

    public void c() {
        this.f438470b = System.currentTimeMillis();
    }
}
