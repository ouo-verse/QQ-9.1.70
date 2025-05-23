package xg4;

import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lxg4/k;", "", "Lxg4/a;", "a", "Lxg4/a;", "getPanelInfo", "()Lxg4/a;", "panelInfo", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "b", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "()Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "qqEmoInfo", "<init>", "(Lxg4/a;Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a panelInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EmoticonInfo qqEmoInfo;

    public k(@NotNull a panelInfo, @NotNull EmoticonInfo qqEmoInfo) {
        Intrinsics.checkNotNullParameter(panelInfo, "panelInfo");
        Intrinsics.checkNotNullParameter(qqEmoInfo, "qqEmoInfo");
        this.panelInfo = panelInfo;
        this.qqEmoInfo = qqEmoInfo;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final EmoticonInfo getQqEmoInfo() {
        return this.qqEmoInfo;
    }
}
