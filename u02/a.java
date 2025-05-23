package u02;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a implements BusinessObserver {

    /* renamed from: d, reason: collision with root package name */
    private static int f438021d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f438022e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static final int f438023f;

    static {
        int i3 = 0 + 1;
        f438021d = i3 + 1;
        f438023f = i3;
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        if (i3 == f438022e) {
            a(z16, (Bundle) obj);
        } else if (i3 == f438023f) {
            b(z16, (Bundle) obj);
        }
    }

    protected void a(boolean z16, Bundle bundle) {
    }

    protected void b(boolean z16, Bundle bundle) {
    }
}
