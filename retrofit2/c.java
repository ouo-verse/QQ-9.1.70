package retrofit2;

import android.annotation.TargetApi;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import retrofit2.e;
import retrofit2.h;

/* compiled from: P */
/* loaded from: classes29.dex */
class c {

    /* compiled from: P */
    @TargetApi(24)
    /* loaded from: classes29.dex */
    static final class a extends c {
        @Override // retrofit2.c
        List<? extends e.a> a(@Nullable Executor executor) {
            return Arrays.asList(new g(), new i(executor));
        }

        @Override // retrofit2.c
        List<? extends h.a> b() {
            return Collections.singletonList(new s());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<? extends e.a> a(@Nullable Executor executor) {
        return Collections.singletonList(new i(executor));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<? extends h.a> b() {
        return Collections.emptyList();
    }
}
