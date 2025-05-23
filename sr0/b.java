package sr0;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;
import sr0.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b3\u00104R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0005R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0007\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001f\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0013\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010%\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010!\u001a\u0004\b\u000b\u0010\"\"\u0004\b#\u0010$R$\u0010,\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b'\u0010)\"\u0004\b*\u0010+R$\u00102\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010.\u001a\u0004\b\u001a\u0010/\"\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lsr0/b;", "", "", "a", "I", "()I", "elementType", "b", "getElementId", "elementId", "Lsr0/a$e;", "c", "Lsr0/a$e;", "f", "()Lsr0/a$e;", "l", "(Lsr0/a$e;)V", "textElement", "Lsr0/a$b;", "d", "Lsr0/a$b;", "()Lsr0/a$b;", h.F, "(Lsr0/a$b;)V", "faceElement", "Lsr0/a$a;", "e", "Lsr0/a$a;", "()Lsr0/a$a;", "j", "(Lsr0/a$a;)V", "picElement", "Lsr0/a$c;", "Lsr0/a$c;", "()Lsr0/a$c;", "i", "(Lsr0/a$c;)V", "fileElement", "Lsr0/a$f;", "g", "Lsr0/a$f;", "()Lsr0/a$f;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lsr0/a$f;)V", "videoElement", "Lsr0/a$d;", "Lsr0/a$d;", "()Lsr0/a$d;", "k", "(Lsr0/a$d;)V", "replyElement", "<init>", "(II)V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int elementType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int elementId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a.TextElement textElement;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a.FaceElement faceElement;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a.AIOPicElement picElement;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a.FileElement fileElement;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a.VideoElement videoElement;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a.ReplyElement replyElement;

    public b(int i3, int i16) {
        this.elementType = i3;
        this.elementId = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getElementType() {
        return this.elementType;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final a.FaceElement getFaceElement() {
        return this.faceElement;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final a.FileElement getFileElement() {
        return this.fileElement;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final a.AIOPicElement getPicElement() {
        return this.picElement;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final a.ReplyElement getReplyElement() {
        return this.replyElement;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final a.TextElement getTextElement() {
        return this.textElement;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final a.VideoElement getVideoElement() {
        return this.videoElement;
    }

    public final void h(@Nullable a.FaceElement faceElement) {
        this.faceElement = faceElement;
    }

    public final void i(@Nullable a.FileElement fileElement) {
        this.fileElement = fileElement;
    }

    public final void j(@Nullable a.AIOPicElement aIOPicElement) {
        this.picElement = aIOPicElement;
    }

    public final void k(@Nullable a.ReplyElement replyElement) {
        this.replyElement = replyElement;
    }

    public final void l(@Nullable a.TextElement textElement) {
        this.textElement = textElement;
    }

    public final void m(@Nullable a.VideoElement videoElement) {
        this.videoElement = videoElement;
    }

    public /* synthetic */ b(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i17 & 2) != 0 ? 0 : i16);
    }
}
