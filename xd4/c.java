package xd4;

import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0006\u0010\t\u001a\u00020\u0007\u00a8\u0006\f"}, d2 = {"Lxd4/c;", "Lxd4/f;", "", "name", "", "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "components", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "a", "b", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class c implements f {

    /* renamed from: a, reason: collision with root package name */
    public static final c f447837a = new c();

    c() {
    }

    @Override // xd4.f
    @NotNull
    public Entity a(@NotNull String name, @NotNull List<IdentifyComponent> components) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(components, "components");
        return new Entity(0, name, null, components, false, 0, 53, null);
    }

    @NotNull
    public final Entity b() {
        ArrayList arrayListOf;
        b bVar = b.f447836a;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new IdentifyComponent(bVar.t("", 0L)), new IdentifyComponent(bVar.m()), new IdentifyComponent(bVar.a("transition")));
        return a("transition", arrayListOf);
    }
}
