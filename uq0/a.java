package uq0;

import android.widget.ImageView;
import com.tencent.aio.data.AIOContact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Luq0/a;", "Lol3/a;", "Lcom/tencent/aio/data/AIOContact;", "a", "Lcom/tencent/aio/data/AIOContact;", "()Lcom/tencent/aio/data/AIOContact;", "contact", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "view", "<init>", "(Lcom/tencent/aio/data/AIOContact;Landroid/widget/ImageView;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a implements ol3.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOContact contact;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView view;

    public a(@NotNull AIOContact contact, @NotNull ImageView view) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(view, "view");
        this.contact = contact;
        this.view = view;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final AIOContact getContact() {
        return this.contact;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final ImageView getView() {
        return this.view;
    }
}
