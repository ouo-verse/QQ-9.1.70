package xn1;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R#\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR#\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0012\u001a\u0004\b\u000b\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lxn1/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lkotlin/Function1;", "Lvn1/b;", "a", "Lkotlin/jvm/functions/Function1;", "c", "()Lkotlin/jvm/functions/Function1;", "removePredicate", "b", "addPredicate", "Z", "()Z", "actionWhenNotExist", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: xn1.c, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class ModifyFeedArgs {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Function1<vn1.b, Boolean> removePredicate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Function1<vn1.b, Boolean> addPredicate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean actionWhenNotExist;

    /* JADX WARN: Multi-variable type inference failed */
    public ModifyFeedArgs(@NotNull Function1<? super vn1.b, Boolean> removePredicate, @NotNull Function1<? super vn1.b, Boolean> addPredicate, boolean z16) {
        Intrinsics.checkNotNullParameter(removePredicate, "removePredicate");
        Intrinsics.checkNotNullParameter(addPredicate, "addPredicate");
        this.removePredicate = removePredicate;
        this.addPredicate = addPredicate;
        this.actionWhenNotExist = z16;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getActionWhenNotExist() {
        return this.actionWhenNotExist;
    }

    @NotNull
    public final Function1<vn1.b, Boolean> b() {
        return this.addPredicate;
    }

    @NotNull
    public final Function1<vn1.b, Boolean> c() {
        return this.removePredicate;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModifyFeedArgs)) {
            return false;
        }
        ModifyFeedArgs modifyFeedArgs = (ModifyFeedArgs) other;
        if (Intrinsics.areEqual(this.removePredicate, modifyFeedArgs.removePredicate) && Intrinsics.areEqual(this.addPredicate, modifyFeedArgs.addPredicate) && this.actionWhenNotExist == modifyFeedArgs.actionWhenNotExist) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.removePredicate.hashCode() * 31) + this.addPredicate.hashCode()) * 31;
        boolean z16 = this.actionWhenNotExist;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "ModifyFeedArgs(removePredicate=" + this.removePredicate + ", addPredicate=" + this.addPredicate + ", actionWhenNotExist=" + this.actionWhenNotExist + ")";
    }
}
