package vm2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\t\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lvm2/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "e", "(Z)V", "isMuteWhenOpen", "b", "I", "()I", "d", "(I)V", "bubbleShowTimes", "f", "subtitleDialogShowTimes", "<init>", "(ZII)V", "qq-richmediabrowser-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: vm2.b, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class SubtitleGuideData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isMuteWhenOpen;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int bubbleShowTimes;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int subtitleDialogShowTimes;

    public SubtitleGuideData() {
        this(false, 0, 0, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getBubbleShowTimes() {
        return this.bubbleShowTimes;
    }

    /* renamed from: b, reason: from getter */
    public final int getSubtitleDialogShowTimes() {
        return this.subtitleDialogShowTimes;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsMuteWhenOpen() {
        return this.isMuteWhenOpen;
    }

    public final void d(int i3) {
        this.bubbleShowTimes = i3;
    }

    public final void e(boolean z16) {
        this.isMuteWhenOpen = z16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubtitleGuideData)) {
            return false;
        }
        SubtitleGuideData subtitleGuideData = (SubtitleGuideData) other;
        if (this.isMuteWhenOpen == subtitleGuideData.isMuteWhenOpen && this.bubbleShowTimes == subtitleGuideData.bubbleShowTimes && this.subtitleDialogShowTimes == subtitleGuideData.subtitleDialogShowTimes) {
            return true;
        }
        return false;
    }

    public final void f(int i3) {
        this.subtitleDialogShowTimes = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.isMuteWhenOpen;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + this.bubbleShowTimes) * 31) + this.subtitleDialogShowTimes;
    }

    @NotNull
    public String toString() {
        return "SubtitleGuideData(isMuteWhenOpen=" + this.isMuteWhenOpen + ", bubbleShowTimes=" + this.bubbleShowTimes + ", subtitleDialogShowTimes=" + this.subtitleDialogShowTimes + ')';
    }

    public SubtitleGuideData(boolean z16, int i3, int i16) {
        this.isMuteWhenOpen = z16;
        this.bubbleShowTimes = i3;
        this.subtitleDialogShowTimes = i16;
    }

    public /* synthetic */ SubtitleGuideData(boolean z16, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? false : z16, (i17 & 2) != 0 ? 1 : i3, (i17 & 4) != 0 ? 1 : i16);
    }
}
