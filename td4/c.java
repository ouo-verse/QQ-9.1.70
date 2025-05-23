package td4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.Component;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0006\u0010\t\u001a\u00020\u0007\u00a8\u0006\f"}, d2 = {"Ltd4/c;", "Ltd4/f;", "", "name", "", "Lorg/light/lightAssetKit/components/Component;", "components", "Lorg/light/lightAssetKit/Entity;", "a", "b", "<init>", "()V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class c implements f {

    /* renamed from: a, reason: collision with root package name */
    public static final c f435876a = new c();

    c() {
    }

    @Override // td4.f
    @NotNull
    public Entity a(@NotNull String name, @NotNull List<? extends Component> components) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(components, "components");
        Entity entity = new Entity();
        entity.reset();
        Iterator<T> it = components.iterator();
        while (it.hasNext()) {
            entity.addComponent((Component) it.next());
        }
        return entity;
    }

    @NotNull
    public final Entity b() {
        ArrayList arrayListOf;
        b bVar = b.f435875a;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(bVar.o("", 0L), bVar.a("transition"));
        return a("transition", arrayListOf);
    }
}
