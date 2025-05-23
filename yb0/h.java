package yb0;

import com.tencent.mobileqq.multishare.action.ShareActionLine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u0016\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lyb0/h;", "Lcom/tencent/mobileqq/multishare/action/b;", "", "e", "", "d", "a", "Lcom/tencent/mobileqq/multishare/action/ShareActionLine;", "b", "Lcom/tencent/mobileqq/multishare/action/ShareActionLine;", "getLine", "()Lcom/tencent/mobileqq/multishare/action/ShareActionLine;", "line", "I", "getDrawableId", "()I", "drawableId", "c", "Ljava/lang/String;", "getLabel", "()Ljava/lang/String;", "label", "getId", "id", "<init>", "(Lcom/tencent/mobileqq/multishare/action/ShareActionLine;ILjava/lang/String;I)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class h extends com.tencent.mobileqq.multishare.action.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ShareActionLine line;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int drawableId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String label;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int id;

    public h(@NotNull ShareActionLine line, int i3, @NotNull String label, int i16) {
        Intrinsics.checkNotNullParameter(line, "line");
        Intrinsics.checkNotNullParameter(label, "label");
        this.line = line;
        this.drawableId = i3;
        this.label = label;
        this.id = i16;
    }

    @Override // com.tencent.mobileqq.multishare.action.a
    /* renamed from: a, reason: from getter */
    public int getId() {
        return this.id;
    }

    @Override // com.tencent.mobileqq.multishare.action.a
    @NotNull
    /* renamed from: b, reason: from getter */
    public ShareActionLine getLine() {
        return this.line;
    }

    @Override // com.tencent.mobileqq.multishare.action.b
    @NotNull
    /* renamed from: d, reason: from getter */
    public String getLabel() {
        return this.label;
    }

    @Override // com.tencent.mobileqq.multishare.action.b
    /* renamed from: e, reason: from getter */
    public int getDrawableId() {
        return this.drawableId;
    }
}
