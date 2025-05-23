package qs0;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0010\u0010\u0011R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lqs0/a;", "", "", "a", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "c", "(Ljava/lang/Integer;)V", "curPanelId", "", "b", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "d", "(Ljava/lang/Boolean;)V", "isKeyboardShow", "<init>", "(Ljava/lang/Integer;Ljava/lang/Boolean;)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer curPanelId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean isKeyboardShow;

    public a(@Nullable Integer num, @Nullable Boolean bool) {
        this.curPanelId = num;
        this.isKeyboardShow = bool;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Integer getCurPanelId() {
        return this.curPanelId;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Boolean getIsKeyboardShow() {
        return this.isKeyboardShow;
    }

    public final void c(@Nullable Integer num) {
        this.curPanelId = num;
    }

    public final void d(@Nullable Boolean bool) {
        this.isKeyboardShow = bool;
    }
}
