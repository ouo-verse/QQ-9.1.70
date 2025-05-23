package zy;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\n\u0010\u0014R\"\u0010\u0018\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0010\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lzy/g;", "", "Landroid/content/Intent;", "d", "Landroid/content/Context;", "a", "Landroid/content/Context;", "()Landroid/content/Context;", "context", "", "b", "Ljava/lang/String;", "getFromScene", "()Ljava/lang/String;", "fromScene", "", "c", "I", "getSubjectID", "()I", "(I)V", "subjectID", "getTitle", "(Ljava/lang/String;)V", "title", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "e", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String fromScene;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int subjectID;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String title;

    public g(Context context, String fromScene) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fromScene, "fromScene");
        this.context = context;
        this.fromScene = fromScene;
        this.title = "";
    }

    /* renamed from: a, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    public final void b(int i3) {
        this.subjectID = i3;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final Intent d() {
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", this.fromScene);
        intent.putExtra("key_subject_id", this.subjectID);
        intent.putExtra("key_title", this.title);
        return intent;
    }
}
