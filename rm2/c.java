package rm2;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c implements BusinessObserver {
    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        com.tencent.mobileqq.richmedia.conn.a aVar;
        if (QLog.isColorLevel()) {
            QLog.d("TransObserver", 2, "onUpdate, type=", Integer.valueOf(i3), ", isSuccess=", Boolean.valueOf(z16));
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            if (obj instanceof Object[]) {
                                Object[] objArr = (Object[]) obj;
                                a(((Long) objArr[0]).longValue(), ((Integer) objArr[1]).intValue());
                                return;
                            } else {
                                c(-1L, -1);
                                return;
                            }
                        }
                        return;
                    }
                    if (obj instanceof Object[]) {
                        Object[] objArr2 = (Object[]) obj;
                        c(((Long) objArr2[0]).longValue(), ((Integer) objArr2[1]).intValue());
                        return;
                    } else {
                        c(-1L, -1);
                        return;
                    }
                }
                if (obj instanceof Object[]) {
                    Object[] objArr3 = (Object[]) obj;
                    b(((Long) objArr3[0]).longValue(), ((Integer) objArr3[1]).intValue());
                    return;
                } else {
                    c(-1L, -1);
                    return;
                }
            }
            if (obj instanceof Object[]) {
                Object[] objArr4 = (Object[]) obj;
                long longValue = ((Long) objArr4[0]).longValue();
                int intValue = ((Integer) objArr4[1]).intValue();
                int intValue2 = ((Integer) objArr4[2]).intValue();
                Object obj2 = objArr4[3];
                if (obj2 != null) {
                    aVar = (com.tencent.mobileqq.richmedia.conn.a) obj2;
                } else {
                    aVar = null;
                }
                d(longValue, intValue, intValue2, aVar);
                return;
            }
            c(-1L, -1);
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr5 = (Object[]) obj;
            e(((Long) objArr5[0]).longValue(), ((Integer) objArr5[1]).intValue(), ((Integer) objArr5[2]).intValue(), ((Integer) objArr5[3]).intValue(), (String) objArr5[4], (String) objArr5[5]);
        } else {
            c(-1L, -1);
        }
    }

    protected void a(long j3, int i3) {
    }

    protected void b(long j3, int i3) {
    }

    protected void c(long j3, int i3) {
    }

    protected void d(long j3, int i3, int i16, com.tencent.mobileqq.richmedia.conn.a aVar) {
    }

    protected void e(long j3, int i3, int i16, int i17, String str, String str2) {
    }
}
