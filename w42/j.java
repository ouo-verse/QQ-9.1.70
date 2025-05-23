package w42;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\nR\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\f\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lw42/j;", "", "", "a", "Ljava/lang/CharSequence;", "b", "()Ljava/lang/CharSequence;", "systemNotice", "", "I", "()I", "sysMsgType", "c", "txtColor", "<init>", "(Ljava/lang/CharSequence;II)V", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence systemNotice;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int sysMsgType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int txtColor;

    public j(@NotNull CharSequence systemNotice, int i3, int i16) {
        Intrinsics.checkNotNullParameter(systemNotice, "systemNotice");
        this.systemNotice = systemNotice;
        this.sysMsgType = i3;
        this.txtColor = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getSysMsgType() {
        return this.sysMsgType;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final CharSequence getSystemNotice() {
        return this.systemNotice;
    }

    /* renamed from: c, reason: from getter */
    public final int getTxtColor() {
        return this.txtColor;
    }

    public /* synthetic */ j(CharSequence charSequence, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) != 0 ? 0 : i16);
    }
}
