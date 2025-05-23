package xn1;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\t\u0010\fR%\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0012\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lxn1/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", "scrollPos", "b", "Z", "()Z", "needInsertAnimator", "c", "index", "Lkotlin/Function1;", "Lvn1/b;", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "predicate", "<init>", "(IZILkotlin/jvm/functions/Function1;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: xn1.b, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class InsertFeedArgs {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int scrollPos;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean needInsertAnimator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int index;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Function1<vn1.b, Boolean> predicate;

    public InsertFeedArgs() {
        this(0, false, 0, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getNeedInsertAnimator() {
        return this.needInsertAnimator;
    }

    @Nullable
    public final Function1<vn1.b, Boolean> c() {
        return this.predicate;
    }

    /* renamed from: d, reason: from getter */
    public final int getScrollPos() {
        return this.scrollPos;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InsertFeedArgs)) {
            return false;
        }
        InsertFeedArgs insertFeedArgs = (InsertFeedArgs) other;
        if (this.scrollPos == insertFeedArgs.scrollPos && this.needInsertAnimator == insertFeedArgs.needInsertAnimator && this.index == insertFeedArgs.index && Intrinsics.areEqual(this.predicate, insertFeedArgs.predicate)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int i3 = this.scrollPos * 31;
        boolean z16 = this.needInsertAnimator;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (((i3 + i16) * 31) + this.index) * 31;
        Function1<vn1.b, Boolean> function1 = this.predicate;
        if (function1 == null) {
            hashCode = 0;
        } else {
            hashCode = function1.hashCode();
        }
        return i17 + hashCode;
    }

    @NotNull
    public String toString() {
        return "InsertFeedArgs(scrollPos=" + this.scrollPos + ", needInsertAnimator=" + this.needInsertAnimator + ", index=" + this.index + ", predicate=" + this.predicate + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InsertFeedArgs(int i3, boolean z16, int i16, @Nullable Function1<? super vn1.b, Boolean> function1) {
        this.scrollPos = i3;
        this.needInsertAnimator = z16;
        this.index = i16;
        this.predicate = function1;
    }

    public /* synthetic */ InsertFeedArgs(int i3, boolean z16, int i16, Function1 function1, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? -1 : i3, (i17 & 2) != 0 ? false : z16, (i17 & 4) != 0 ? 0 : i16, (i17 & 8) != 0 ? null : function1);
    }
}
