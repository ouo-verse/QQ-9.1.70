package x81;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class h {
    public static i a(int i3) {
        return new i(i3);
    }

    public static g b(i iVar, int i3) {
        g aVar;
        if (iVar != null) {
            int i16 = iVar.f447451a;
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 != 4) {
                            if (i16 != 5) {
                                aVar = new k(i3);
                            } else if (!TextUtils.isEmpty(iVar.f447461k)) {
                                aVar = new b(i3, iVar.f447461k);
                            } else {
                                throw new RuntimeException("fragmentShader can not be empty!");
                            }
                        } else {
                            aVar = new f(i3);
                        }
                    } else {
                        aVar = new e(i3);
                    }
                } else {
                    aVar = new m(i3);
                }
            } else {
                aVar = new a(i3);
            }
            QLog.i("KeyingManager", 1, "getKeying keying: " + aVar + "  params: " + iVar.toString());
            return aVar;
        }
        throw new RuntimeException("params can not be null!");
    }
}
