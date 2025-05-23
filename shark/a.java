package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import shark.HeapObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"Lshark/a;", "", "Lshark/HeapObject$HeapClass;", "a", "Lshark/HeapObject$HeapClass;", "()Lshark/HeapObject$HeapClass;", "declaringClass", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "name", "Lshark/c;", "c", "Lshark/c;", "()Lshark/c;", "value", "shark-graph"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes29.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HeapObject.HeapClass declaringClass;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c value;

    @NotNull
    /* renamed from: a, reason: from getter */
    public final HeapObject.HeapClass getDeclaringClass() {
        return this.declaringClass;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final c getValue() {
        return this.value;
    }
}
