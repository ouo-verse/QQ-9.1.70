package pv3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lpv3/a;", "", "Lcom/tencent/aio/api/runtime/a;", "context", "", "b", "nick", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: pv3.a$a, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static final class C11043a {
        @NotNull
        public static CharSequence a(@NotNull a aVar, @NotNull CharSequence nick) {
            Intrinsics.checkNotNullParameter(nick, "nick");
            return nick;
        }
    }

    @NotNull
    CharSequence a(@NotNull CharSequence nick);

    @Nullable
    CharSequence b(@Nullable com.tencent.aio.api.runtime.a context);
}
