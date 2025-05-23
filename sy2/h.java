package sy2;

import com.tencent.mobileqq.data.entitymanager.Provider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lsy2/h;", "Lcom/tencent/mobileqq/data/entitymanager/Provider;", "", "Lsy2/e;", "a", "<init>", "()V", "QQCommon_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class h implements Provider<List<? extends e>> {
    @Override // com.tencent.mobileqq.data.entitymanager.Provider
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<e> get() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new f(), new b(), new c(), new g(), new d());
        return arrayListOf;
    }
}
