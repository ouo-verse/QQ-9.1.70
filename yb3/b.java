package yb3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0006\u0010\t\u001a\u00020\bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lyb3/b;", "", "", "d", "", "Lyb3/h;", "zootopiaTabItemConfigList", "c", "", "b", "Ljava/util/ArrayList;", "a", "Ljava/util/ArrayList;", "bottomTabConfigList", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<ZootopiaTabItemConfig> bottomTabConfigList = new ArrayList<>();

    private final void d() {
        CollectionsKt__MutableCollectionsJVMKt.sortWith(this.bottomTabConfigList, new Comparator() { // from class: yb3.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int e16;
                e16 = b.e((ZootopiaTabItemConfig) obj, (ZootopiaTabItemConfig) obj2);
                return e16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int e(ZootopiaTabItemConfig zootopiaTabItemConfig, ZootopiaTabItemConfig zootopiaTabItemConfig2) {
        return zootopiaTabItemConfig.getIndex() - zootopiaTabItemConfig2.getIndex();
    }

    public final boolean b() {
        for (ZootopiaTabItemConfig zootopiaTabItemConfig : this.bottomTabConfigList) {
            if (zootopiaTabItemConfig.getIsShow() && zootopiaTabItemConfig.getId() == 1002) {
                return true;
            }
        }
        return false;
    }

    public final void c(@NotNull List<ZootopiaTabItemConfig> zootopiaTabItemConfigList) {
        Intrinsics.checkNotNullParameter(zootopiaTabItemConfigList, "zootopiaTabItemConfigList");
        this.bottomTabConfigList.clear();
        for (ZootopiaTabItemConfig zootopiaTabItemConfig : zootopiaTabItemConfigList) {
            if (zootopiaTabItemConfig.getIsShow()) {
                this.bottomTabConfigList.add(zootopiaTabItemConfig);
            }
        }
        d();
    }
}
