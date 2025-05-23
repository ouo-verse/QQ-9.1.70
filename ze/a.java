package ze;

import bf.b;
import bf.c;
import bf.d;
import com.tencent.richframework.data.base.BaseDataCenter;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends BaseDataCenter {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f452399a;

    a() {
        addDataConverter(new c());
        addDataConverter(new b());
        addDataConverter(new d());
        addDataConverter(new bf.a());
        addDataConverter(new ae.a());
        addDataConverter(new ae.d());
        addDataConverter(new ae.c());
        addDataConverter(new ae.b());
    }

    public static a a() {
        if (f452399a == null) {
            synchronized (a.class) {
                if (f452399a == null) {
                    f452399a = new a();
                }
            }
        }
        return f452399a;
    }

    @Override // com.tencent.richframework.data.base.BaseDataCenter
    public void clearAll() {
        super.clearAll();
        f452399a = null;
    }
}
