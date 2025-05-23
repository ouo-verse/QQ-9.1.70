package xn1;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R#\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR#\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u000b\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lxn1/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lkotlin/Function1;", "Lvn1/b;", "a", "Lkotlin/jvm/functions/Function1;", "b", "()Lkotlin/jvm/functions/Function1;", "predicate", "modifyFun", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: xn1.d, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class ModifyFeedArgsV2 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Function1<vn1.b, Boolean> predicate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Function1<vn1.b, vn1.b> modifyFun;

    /* JADX WARN: Multi-variable type inference failed */
    public ModifyFeedArgsV2(@NotNull Function1<? super vn1.b, Boolean> predicate, @NotNull Function1<? super vn1.b, ? extends vn1.b> modifyFun) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Intrinsics.checkNotNullParameter(modifyFun, "modifyFun");
        this.predicate = predicate;
        this.modifyFun = modifyFun;
    }

    @NotNull
    public final Function1<vn1.b, vn1.b> a() {
        return this.modifyFun;
    }

    @NotNull
    public final Function1<vn1.b, Boolean> b() {
        return this.predicate;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModifyFeedArgsV2)) {
            return false;
        }
        ModifyFeedArgsV2 modifyFeedArgsV2 = (ModifyFeedArgsV2) other;
        if (Intrinsics.areEqual(this.predicate, modifyFeedArgsV2.predicate) && Intrinsics.areEqual(this.modifyFun, modifyFeedArgsV2.modifyFun)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.predicate.hashCode() * 31) + this.modifyFun.hashCode();
    }

    @NotNull
    public String toString() {
        return "ModifyFeedArgsV2(predicate=" + this.predicate + ", modifyFun=" + this.modifyFun + ")";
    }
}
