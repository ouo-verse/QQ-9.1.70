package wh1;

import com.tencent.mobileqq.guild.discoveryv2.content.base.h;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002R \u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00070\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lwh1/b;", "", "", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", "contentData", "", "a", "Lwh1/a;", "b", "Ljava/util/List;", "processors", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f445644a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<a<h>> processors;

    static {
        List<a<h>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new a[]{new d(), new f()});
        processors = listOf;
    }

    b() {
    }

    public final void a(@Nullable List<? extends h> contentData) {
        if (contentData == null) {
            return;
        }
        for (h hVar : contentData) {
            Iterator<T> it = processors.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(hVar);
            }
        }
    }
}
