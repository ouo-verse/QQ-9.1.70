package wf1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\"\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014\"\u0004\b\u0012\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lwf1/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getAnswerId", "()I", "answerId", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "answerContent", "c", "Z", "()Z", "(Z)V", "isSelected", "<init>", "(ILjava/lang/String;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: wf1.a, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class AnswerItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int answerId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String answerContent;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isSelected;

    public AnswerItem(int i3, @NotNull String answerContent, boolean z16) {
        Intrinsics.checkNotNullParameter(answerContent, "answerContent");
        this.answerId = i3;
        this.answerContent = answerContent;
        this.isSelected = z16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAnswerContent() {
        return this.answerContent;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final void c(boolean z16) {
        this.isSelected = z16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnswerItem)) {
            return false;
        }
        AnswerItem answerItem = (AnswerItem) other;
        if (this.answerId == answerItem.answerId && Intrinsics.areEqual(this.answerContent, answerItem.answerContent) && this.isSelected == answerItem.isSelected) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.answerId * 31) + this.answerContent.hashCode()) * 31;
        boolean z16 = this.isSelected;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "AnswerItem(answerId=" + this.answerId + ", answerContent=" + this.answerContent + ", isSelected=" + this.isSelected + ")";
    }

    public /* synthetic */ AnswerItem(int i3, String str, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, (i16 & 4) != 0 ? false : z16);
    }
}
