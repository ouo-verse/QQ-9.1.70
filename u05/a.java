package u05;

import android.os.Handler;
import com.tencent.mobileqq.app.BusinessObserver;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a implements BusinessObserver {

    /* renamed from: d, reason: collision with root package name */
    private Handler f438032d;

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        Handler handler = this.f438032d;
        if (handler == null) {
            return;
        }
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            return;
        }
        handler.obtainMessage(i3, z16 ? 1 : 0, 0, obj).sendToTarget();
    }
}
