package vy4;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.vivo.datashare.permission.PermissionRequest;
import com.vivo.datashare.permission.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class b extends com.vivo.datashare.permission.a<a> {
    public b(Context context) {
        super(context);
    }

    public int e(Context context, int i3) {
        String a16 = d.a(i3);
        String packageName = b().getPackageName();
        if (!TextUtils.isEmpty(a16) && !TextUtils.isEmpty(packageName)) {
            return c().a(context, a16, packageName);
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.datashare.permission.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public a d() {
        return new a();
    }

    public void g(Context context, int i3) {
        String a16 = d.a(i3);
        String packageName = b().getPackageName();
        if (!TextUtils.isEmpty(a16) && !TextUtils.isEmpty(packageName)) {
            if (wy4.a.a()) {
                Log.d("SportPermissionManager", "key=" + a16 + ",appId=" + packageName);
            }
            c().d(context, new PermissionRequest.b().b(0).a(packageName).e(a16).d(com.vivo.datashare.permission.c.f387544a).c());
        }
    }
}
