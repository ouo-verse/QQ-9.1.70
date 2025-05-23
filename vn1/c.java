package vn1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\r\u001a\u00028\u0000\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\u001a\u0010\r\u001a\u00028\u00008\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lvn1/c;", "T", "Lvn1/a;", "", "getItemType", "newItem", "", "b", "", "a", "Ljava/lang/Object;", "d", "()Ljava/lang/Object;", "data", "I", "getType", "()I", "type", "<init>", "(Ljava/lang/Object;I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class c<T> implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final T data;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int type;

    public c(T t16, int i3) {
        this.data = t16;
        this.type = i3;
    }

    @Override // vn1.a
    @Nullable
    public Object a(@NotNull a newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return null;
    }

    @Override // vn1.a
    public boolean b(@NotNull a newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (getClass().isInstance(newItem) && newItem.getItemId() == getItemId()) {
            return true;
        }
        return false;
    }

    public T d() {
        return this.data;
    }

    @Override // vn1.a
    /* renamed from: getItemType, reason: from getter */
    public int getType() {
        return this.type;
    }
}
