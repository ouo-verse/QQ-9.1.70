package zo3;

import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.j;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001b\u0010\b\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R+\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lzo3/e;", "Lzo3/a;", "", "toString", "Lcom/tencent/kuikly/core/base/Direction;", "b", "Lkotlin/Lazy;", "()Lcom/tencent/kuikly/core/base/Direction;", "direction", "Ljava/util/ArrayList;", "Lcom/tencent/kuikly/core/base/j;", "Lkotlin/collections/ArrayList;", "c", "a", "()Ljava/util/ArrayList;", "colorStops", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy direction;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy colorStops;

    public final ArrayList<j> a() {
        return (ArrayList) this.colorStops.getValue();
    }

    public final Direction b() {
        return (Direction) this.direction.getValue();
    }

    public String toString() {
        return "";
    }
}
