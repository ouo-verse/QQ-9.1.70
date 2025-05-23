package zg1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\r\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u000e\u001a\u00028\u0000\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\u001a\u0010\u000e\u001a\u00028\u00008\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lzg1/b;", "T", "Lzg1/a;", "", "getItemType", "newItem", "", "a", "", "c", "b", "Ljava/lang/Object;", "d", "()Ljava/lang/Object;", "data", "I", "e", "()I", "type", "<init>", "(Ljava/lang/Object;I)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class b<T> implements a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final T data;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int type;

    public b(T t16, int i3) {
        this.data = t16;
        this.type = i3;
    }

    @Override // zg1.a
    public boolean a(@NotNull a newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (getClass().isInstance(newItem) && newItem.getItemId() == getItemId()) {
            return true;
        }
        return false;
    }

    @Override // zg1.a
    @Nullable
    public Object c(@NotNull a newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return null;
    }

    public T d() {
        return this.data;
    }

    /* renamed from: e, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @Override // zg1.a
    /* renamed from: getItemType */
    public int getType() {
        return this.type;
    }
}
