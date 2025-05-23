package ro;

import android.content.Intent;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f431771a;

    public String b() {
        return this.f431771a;
    }

    public String c() {
        String str = this.f431771a;
        this.f431771a = null;
        return str;
    }

    public static a a(Intent intent) {
        if (intent == null) {
            return null;
        }
        String stringExtra = intent.getStringExtra("refer");
        if (TextUtils.isEmpty(stringExtra)) {
            return null;
        }
        a aVar = new a();
        aVar.f431771a = stringExtra;
        return aVar;
    }
}
