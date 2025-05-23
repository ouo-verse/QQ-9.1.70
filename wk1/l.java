package wk1;

import com.tencent.biz.richframework.part.Part;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lwk1/l;", "Lwk1/i;", "", "key", "", "msg", "", "lh", "action", "I2", "Lcom/tencent/biz/richframework/part/Part;", "d", "Lcom/tencent/biz/richframework/part/Part;", "part", "<init>", "(Lcom/tencent/biz/richframework/part/Part;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class l implements i {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Part part;

    public l(@NotNull Part part) {
        Intrinsics.checkNotNullParameter(part, "part");
        this.part = part;
    }

    @Override // wk1.i
    @Nullable
    public Object I2(@NotNull String action, @Nullable Object msg2) {
        Intrinsics.checkNotNullParameter(action, "action");
        return this.part.broadcastGetMessage(action, msg2);
    }

    @Override // wk1.i
    public void lh(@NotNull String key, @Nullable Object msg2) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.part.broadcastMessage(key, msg2);
    }
}
