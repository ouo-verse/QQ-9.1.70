package xz4;

import androidx.annotation.NonNull;
import c05.c;
import com.xingin.xhssharesdk.XhsSdkInject;
import com.xingin.xhssharesdk.core.XhsShareSdk;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class i {
    public static /* synthetic */ Map a(c05.a aVar) {
        HashMap hashMap = new HashMap();
        try {
            aVar.a(hashMap);
        } catch (NoSuchAlgorithmException e16) {
            XhsShareSdk.d("XhsShare_XhsShareApi", "Calculate md5 error!", e16);
        }
        return hashMap;
    }

    public static void b(@NonNull final c05.a aVar, @NonNull b bVar) {
        c05.c.a(XhsSdkInject.getCheckTokenRequestPath(), new c.b() { // from class: xz4.h
            @Override // c05.c.b
            public final Map a() {
                return i.a(c05.a.this);
            }
        }, new g(bVar));
    }
}
