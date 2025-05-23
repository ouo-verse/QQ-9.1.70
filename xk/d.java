package xk;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final List<yk.a> f448085a;

    public d(a aVar) {
        ArrayList arrayList = new ArrayList();
        this.f448085a = arrayList;
        arrayList.add(new yk.b(aVar));
    }

    public boolean a(Intent intent) {
        if (intent == null) {
            return false;
        }
        for (int i3 = 0; i3 < this.f448085a.size(); i3++) {
            yk.a aVar = this.f448085a.get(i3);
            if (aVar.a(intent)) {
                QLog.d("QZoneMediaParseManager", 1, "dealIntentData by " + aVar.f450541b);
                return true;
            }
        }
        return false;
    }
}
