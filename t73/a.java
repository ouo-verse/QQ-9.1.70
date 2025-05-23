package t73;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00028\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006R*\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0006@BX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\n\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lt73/a;", "T", "", "a", "()Ljava/lang/Object;", "b", "Ljava/lang/Object;", "content", "", "<set-?>", "Z", "getHasBeenHandled", "()Z", "getHasBeenHandled$annotations", "()V", "hasBeenHandled", "<init>", "(Ljava/lang/Object;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final T content;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean hasBeenHandled;

    public a(T t16) {
        this.content = t16;
    }

    @Nullable
    public final T a() {
        if (this.hasBeenHandled) {
            return null;
        }
        this.hasBeenHandled = true;
        return this.content;
    }

    public final T b() {
        return this.content;
    }
}
