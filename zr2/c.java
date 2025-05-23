package zr2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u0003\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lzr2/c;", "Lzv3/a;", "", "a", "Z", "c", "()Z", "isEnter", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "troopUin", "", "I", "()I", "aiChatType", "<init>", "(ZLjava/lang/String;I)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c implements zv3.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isEnter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String troopUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int aiChatType;

    public c(boolean z16, String troopUin, int i3) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        this.isEnter = z16;
        this.troopUin = troopUin;
        this.aiChatType = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getAiChatType() {
        return this.aiChatType;
    }

    /* renamed from: b, reason: from getter */
    public final String getTroopUin() {
        return this.troopUin;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsEnter() {
        return this.isEnter;
    }

    public /* synthetic */ c(boolean z16, String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, str, (i16 & 4) != 0 ? 0 : i3);
    }
}
