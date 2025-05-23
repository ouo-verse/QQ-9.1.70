package sh3;

import com.google.protobuf.nano.ExtendableMessageNano;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.database.ZplanDataBaseHelper;
import com.tencent.sqshow.zootopia.database.base.BaseZplanEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import uh3.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0017\u0010\f\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH&J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0015\u001a\u00020\u0014H&J\u0014\u0010\u0016\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006J\u0014\u0010\u0019\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lsh3/b;", "Lcom/google/protobuf/nano/ExtendableMessageNano;", "T", "Lcom/tencent/sqshow/zootopia/database/base/BaseZplanEntity;", "G", "", "", "dataList", "", "k", "d", "originData", "b", "(Lcom/google/protobuf/nano/ExtendableMessageNano;)Lcom/tencent/sqshow/zootopia/database/base/BaseZplanEntity;", "Ljava/lang/Class;", "f", "Lcom/tencent/mobileqq/persistence/Entity;", "entity", "", h.F, "", "g", "i", "e", "entityList", "c", "Lcom/tencent/sqshow/zootopia/database/ZplanDataBaseHelper;", "a", "Lcom/tencent/sqshow/zootopia/database/ZplanDataBaseHelper;", "mDataBaseHelper", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class b<T extends ExtendableMessageNano<T>, G extends BaseZplanEntity> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ZplanDataBaseHelper mDataBaseHelper;

    private final void d() {
        if (this.mDataBaseHelper == null) {
            this.mDataBaseHelper = ZplanDataBaseHelper.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(b this$0, List dataList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataList, "$dataList");
        this$0.k(dataList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final synchronized void k(List<? extends T> dataList) {
        int collectionSizeOrDefault;
        QLog.i(g(), 1, "saveInner in dataList:" + dataList);
        List<? extends T> list = dataList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(b((ExtendableMessageNano) it.next()));
        }
        d();
        ZplanDataBaseHelper zplanDataBaseHelper = this.mDataBaseHelper;
        Boolean valueOf = zplanDataBaseHelper != null ? Boolean.valueOf(zplanDataBaseHelper.j(arrayList)) : null;
        if (Intrinsics.areEqual(valueOf, Boolean.TRUE)) {
            e.f438965d.k();
        }
        QLog.i(g(), 1, "saveInner out saveResult:" + valueOf);
    }

    public abstract G b(T originData);

    public final synchronized void c(List<? extends G> entityList) {
        Intrinsics.checkNotNullParameter(entityList, "entityList");
        d();
        Iterator<T> it = entityList.iterator();
        while (it.hasNext()) {
            BaseZplanEntity baseZplanEntity = (BaseZplanEntity) it.next();
            ZplanDataBaseHelper zplanDataBaseHelper = this.mDataBaseHelper;
            if (zplanDataBaseHelper != null) {
                zplanDataBaseHelper.n(baseZplanEntity);
            }
        }
        QLog.i(g(), 1, "delete ");
    }

    public final synchronized List<G> e() {
        ArrayList arrayList;
        List<? extends Entity> k3;
        arrayList = new ArrayList();
        d();
        ZplanDataBaseHelper zplanDataBaseHelper = this.mDataBaseHelper;
        if (zplanDataBaseHelper != null && (k3 = zplanDataBaseHelper.k(f())) != null) {
            for (Entity it : k3) {
                if ((it instanceof BaseZplanEntity ? (BaseZplanEntity) it : null) != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (h(it)) {
                        arrayList.add(it);
                    }
                }
            }
        }
        QLog.i(g(), 1, "getCurrentEntity result:" + arrayList);
        return arrayList;
    }

    public abstract Class<G> f();

    public abstract String g();

    public abstract boolean h(Entity entity);

    public final void i(final List<? extends T> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        if (dataList.isEmpty()) {
            QLog.i(g(), 1, "save dataList is empty");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: sh3.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.j(b.this, dataList);
                }
            }, 32, null, false);
        }
    }
}
