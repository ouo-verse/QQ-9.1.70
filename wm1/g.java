package wm1;

import com.tencent.mobileqq.text.style.EmoticonSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lwm1/g;", "Lwm1/i;", "", "c", "I", "a", "()I", "type", "Lcom/tencent/mobileqq/text/style/EmoticonSpan;", "d", "Lcom/tencent/mobileqq/text/style/EmoticonSpan;", "b", "()Lcom/tencent/mobileqq/text/style/EmoticonSpan;", "emoticonSpan", "<init>", "(ILcom/tencent/mobileqq/text/style/EmoticonSpan;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g extends i {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EmoticonSpan emoticonSpan;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(int i3, @NotNull EmoticonSpan emoticonSpan) {
        super(i3);
        Intrinsics.checkNotNullParameter(emoticonSpan, "emoticonSpan");
        this.type = i3;
        this.emoticonSpan = emoticonSpan;
    }

    @Override // wm1.i
    /* renamed from: a, reason: from getter */
    public int getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final EmoticonSpan getEmoticonSpan() {
        return this.emoticonSpan;
    }
}
