package tr2;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;

/* compiled from: P */
/* loaded from: classes9.dex */
public class d implements BusinessObserver {
    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        c(z16, (Bundle) obj);
                        return;
                    }
                    return;
                } else {
                    if (z16) {
                        a();
                        return;
                    }
                    return;
                }
            }
            Object[] objArr = (Object[]) obj;
            b(z16, (f) objArr[0], ((Integer) objArr[1]).intValue(), (String) objArr[2]);
            return;
        }
        Object[] objArr2 = (Object[]) obj;
        d((f) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2], ((Long) objArr2[3]).longValue(), ((Long) objArr2[4]).longValue(), objArr2[5]);
    }

    protected void a() {
    }

    protected void c(boolean z16, Bundle bundle) {
    }

    protected void b(boolean z16, f fVar, int i3, String str) {
    }

    protected void d(f fVar, int i3, String str, long j3, long j16, Object obj) {
    }
}
