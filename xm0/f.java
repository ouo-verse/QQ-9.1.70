package xm0;

import android.os.Bundle;
import com.tencent.gdtad.api.wxmini.GdtWXMiniJumpController;
import com.tencent.gdtad.wxmini.GdtWXMiniData;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes6.dex */
public class f extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private static f f448157d;

    f(String str) {
        super(str);
    }

    public static synchronized f b() {
        f fVar;
        synchronized (f.class) {
            if (f448157d == null) {
                synchronized (f.class) {
                    if (f448157d == null) {
                        f448157d = new f("GdtWXMiniIPCModule");
                    }
                }
            }
            fVar = f448157d;
        }
        return fVar;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if ("handle_wxmini_jump".equals(str)) {
            bundle.setClassLoader(GdtWXMiniData.class.getClassLoader());
            GdtWXMiniData gdtWXMiniData = (GdtWXMiniData) bundle.getParcelable(GdtWXMiniData.IPC_DATA_NAME);
            if (gdtWXMiniData == null) {
                return null;
            }
            GdtWXMiniJumpController.f108657a.s(gdtWXMiniData);
            callbackResult(i3, EIPCResult.createResult(0, new Bundle()));
        }
        return null;
    }
}
