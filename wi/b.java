package wi;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\n\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lwi/b;", "", "", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "childNode", "", "Z", "isOnShow", "()Z", "c", "(Z)V", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<b> childNode = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isOnShow = true;

    public List<b> b() {
        return this.childNode;
    }

    public final void c(boolean z16) {
        this.isOnShow = z16;
    }
}
