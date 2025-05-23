package vu1;

import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0004\u001a\u0004\b\t\u0010\u0005\u00a8\u0006\r"}, d2 = {"Lvu1/a;", "", "", "b", "I", "()I", "c", "(I)V", "missionListWidth", "a", "missionListHeight", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f443516a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int missionListWidth = ViewUtils.dpToPx(300.0f);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int missionListHeight = ViewUtils.dpToPx(70.0f);

    a() {
    }

    public final int a() {
        return missionListHeight;
    }

    public final int b() {
        return missionListWidth;
    }

    public final void c(int i3) {
        missionListWidth = i3;
    }
}
