package qa3;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.MaterialType;
import com.tencent.mobileqq.wink.editor.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\n\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a8\u0006\r"}, d2 = {"Lqa3/b;", "", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "categories", "", "hasFavoriteTab", "", "b", "metaCategory", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f428767a = new b();

    b() {
    }

    public final void a(@Nullable MetaCategory metaCategory) {
        if (metaCategory == null) {
            return;
        }
        try {
            ArrayList<MetaMaterial> arrayList = metaCategory.materials;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            String a16 = WinkContext.INSTANCE.d().k().a();
            Iterator<MetaMaterial> it = arrayList.iterator();
            while (it.hasNext()) {
                MetaMaterial material = it.next();
                Intrinsics.checkNotNullExpressionValue(material, "material");
                String str = metaCategory.f30532id;
                Intrinsics.checkNotNullExpressionValue(str, "metaCategory.id");
                c.o1(material, str);
                String str2 = metaCategory.name;
                Intrinsics.checkNotNullExpressionValue(str2, "metaCategory.name");
                c.p1(material, str2);
                String C = c.C(material);
                if (Intrinsics.areEqual(c.j(material), "1")) {
                    linkedHashSet.add(material);
                } else if (Intrinsics.areEqual(C, "only_for_qzone") && !Intrinsics.areEqual(a16, "QZONE")) {
                    linkedHashSet.add(material);
                    w53.b.a("WinkTemplateLibHelper", "delete material ONLY_FOR_QZONE: " + material.f30533id + "," + c.a0(material));
                } else if (Intrinsics.areEqual(C, "only_for_qcircle") && !Intrinsics.areEqual(a16, "QCIRCLE")) {
                    linkedHashSet.add(material);
                    w53.b.a("WinkTemplateLibHelper", "delete material ONLY_FOR_QCIRCLE: " + material.f30533id + "," + c.a0(material));
                } else if (Intrinsics.areEqual(a16, "QZONE") && c.T(material) == MaterialType.H5) {
                    linkedHashSet.add(material);
                    w53.b.a("WinkTemplateLibHelper", "delete material H5: " + material.f30533id + "," + c.a0(material));
                }
            }
            arrayList.removeAll(linkedHashSet);
        } catch (Exception e16) {
            w53.b.d("WinkTemplateLibHelper", "filterMaterialsByBusinessType exception", e16);
        }
    }

    public final void b(@NotNull List<MetaCategory> categories, boolean hasFavoriteTab) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        Iterator<MetaCategory> it = categories.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            MetaCategory next = it.next();
            if (com.tencent.mobileqq.wink.editor.b.e(next)) {
                it.remove();
            } else {
                a(next);
                if ((!hasFavoriteTab || i3 != 0) && next.materials.size() == 0) {
                    it.remove();
                }
            }
            i3++;
        }
    }
}
