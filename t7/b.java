package t7;

import com.qzone.common.account.LoginData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lt7/b;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "setUid", "(Ljava/lang/String;)V", "uid", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String uid;

    public b() {
        String uinString = LoginData.getInstance().getUinString();
        Intrinsics.checkNotNullExpressionValue(uinString, "getInstance().uinString");
        this.uid = uinString;
    }

    /* renamed from: a, reason: from getter */
    public final String getUid() {
        return this.uid;
    }
}
