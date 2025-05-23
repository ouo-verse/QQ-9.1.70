package sh3;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.zplan.event.impl.db.ZPlanRealtimeEventEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"Lsh3/c;", "Lsh3/b;", "Lvu4/c;", "Lcom/tencent/mobileqq/zplan/event/impl/db/ZPlanRealtimeEventEntity;", "originData", "l", "Ljava/lang/Class;", "f", "Lcom/tencent/mobileqq/persistence/Entity;", "entity", "", h.F, "", "g", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends b<vu4.c, ZPlanRealtimeEventEntity> {

    /* renamed from: b, reason: collision with root package name */
    public static final c f433814b = new c();

    c() {
    }

    @Override // sh3.b
    public Class<ZPlanRealtimeEventEntity> f() {
        return ZPlanRealtimeEventEntity.class;
    }

    @Override // sh3.b
    public String g() {
        return "ZPlanEventDBHelper_";
    }

    @Override // sh3.b
    public boolean h(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        return ((entity instanceof ZPlanRealtimeEventEntity ? (ZPlanRealtimeEventEntity) entity : null) == null || ((ZPlanRealtimeEventEntity) entity).eventData == null) ? false : true;
    }

    @Override // sh3.b
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public ZPlanRealtimeEventEntity b(vu4.c originData) {
        Intrinsics.checkNotNullParameter(originData, "originData");
        return com.tencent.mobileqq.zplan.event.impl.a.f333441a.b(originData);
    }
}
