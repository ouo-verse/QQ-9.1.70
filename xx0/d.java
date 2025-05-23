package xx0;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lxx0/d;", "Lxx0/b;", "", "k", "", "f", "Ljava/lang/String;", "getGroupId", "()Ljava/lang/String;", "groupId", "<init>", "(Ljava/lang/String;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class d extends b {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String groupId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull String groupId) {
        super(groupId);
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        this.groupId = groupId;
    }

    @Override // xx0.b
    public boolean k() {
        return true;
    }
}
