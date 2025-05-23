package s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* compiled from: P */
/* loaded from: classes.dex */
public interface a {

    /* compiled from: P */
    /* renamed from: s.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC11197a {
        @Nullable
        a build();
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface b {
        boolean write(@NonNull File file);
    }

    void a(com.bumptech.glide.load.c cVar, b bVar);

    @Nullable
    File b(com.bumptech.glide.load.c cVar);
}
