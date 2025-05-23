package so1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lso1/l;", "Lso1/h;", "", "other", "", "e", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class l extends h {
    public l() {
        super(null, null, null, 7, null);
    }

    @Override // so1.h
    public boolean e(@NotNull Object other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (!(other instanceof l)) {
            return false;
        }
        l lVar = (l) other;
        if (!Intrinsics.areEqual(lVar.getGuildId(), getGuildId()) || !Intrinsics.areEqual(lVar.getChannelId(), getChannelId()) || !Intrinsics.areEqual(lVar.getTitle(), getTitle())) {
            return false;
        }
        return true;
    }
}
