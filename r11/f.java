package r11;

import android.content.Context;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class f implements c {

    /* renamed from: a, reason: collision with root package name */
    private a f430497a = new d();

    /* renamed from: b, reason: collision with root package name */
    private h f430498b;

    public f(Context context) {
        this.f430498b = new g(new File(context.getCacheDir(), "_andserver_session_"));
    }

    @Override // r11.c
    public void a(@NonNull b bVar) throws IOException {
        if ((bVar instanceof e) && bVar.a()) {
            e eVar = (e) bVar;
            eVar.c(false);
            this.f430498b.a(eVar);
        }
    }
}
