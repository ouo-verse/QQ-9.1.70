package xw1;

import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\tB'\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lxw1/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", "status", "b", "Ljava/lang/String;", "()Ljava/lang/String;", QFSSearchBaseRequest.EXTRA_KEY_PROMPT_TEXT, "c", "promptType", "promptIcon", "<init>", "(ILjava/lang/String;II)V", "e", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: xw1.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class RobotClickReply {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int status;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String promptText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int promptType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int promptIcon;

    public RobotClickReply(int i3, @NotNull String promptText, int i16, int i17) {
        Intrinsics.checkNotNullParameter(promptText, "promptText");
        this.status = i3;
        this.promptText = promptText;
        this.promptType = i16;
        this.promptIcon = i17;
    }

    /* renamed from: a, reason: from getter */
    public final int getPromptIcon() {
        return this.promptIcon;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getPromptText() {
        return this.promptText;
    }

    /* renamed from: c, reason: from getter */
    public final int getPromptType() {
        return this.promptType;
    }

    /* renamed from: d, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RobotClickReply)) {
            return false;
        }
        RobotClickReply robotClickReply = (RobotClickReply) other;
        if (this.status == robotClickReply.status && Intrinsics.areEqual(this.promptText, robotClickReply.promptText) && this.promptType == robotClickReply.promptType && this.promptIcon == robotClickReply.promptIcon) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.status * 31) + this.promptText.hashCode()) * 31) + this.promptType) * 31) + this.promptIcon;
    }

    @NotNull
    public String toString() {
        return "RobotClickReply(status=" + this.status + ", promptText=" + this.promptText + ", promptType=" + this.promptType + ", promptIcon=" + this.promptIcon + ')';
    }
}
