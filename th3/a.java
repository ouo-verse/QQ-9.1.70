package th3;

import av4.d;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.event.impl.db.reportMsg.ZPlanReportMsgEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sh3.b;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016\u00a8\u0006\u0017"}, d2 = {"Lth3/a;", "Lsh3/b;", "Lav4/d;", "Lcom/tencent/mobileqq/zplan/event/impl/db/reportMsg/ZPlanReportMsgEntity;", "msgInfo", "l", "", "entityList", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/util/List;)[Lav4/d;", "originData", DomainData.DOMAIN_NAME, "Ljava/lang/Class;", "f", "Lcom/tencent/mobileqq/persistence/Entity;", "entity", "", h.F, "", "g", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends b<d, ZPlanReportMsgEntity> {

    /* renamed from: b, reason: collision with root package name */
    public static final a f436337b = new a();

    a() {
    }

    private final ZPlanReportMsgEntity l(d msgInfo) {
        ZPlanReportMsgEntity zPlanReportMsgEntity = new ZPlanReportMsgEntity();
        zPlanReportMsgEntity.msgId = msgInfo.f27014a;
        zPlanReportMsgEntity.msgType = msgInfo.f27015b;
        zPlanReportMsgEntity.msgBody = msgInfo.f27016c;
        return zPlanReportMsgEntity;
    }

    @Override // sh3.b
    public Class<ZPlanReportMsgEntity> f() {
        return ZPlanReportMsgEntity.class;
    }

    @Override // sh3.b
    public String g() {
        return "ZPlanReportMsgDBHelper_";
    }

    @Override // sh3.b
    public boolean h(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        return ((entity instanceof ZPlanReportMsgEntity ? (ZPlanReportMsgEntity) entity : null) == null || ((ZPlanReportMsgEntity) entity).msgBody == null) ? false : true;
    }

    public final d[] m(List<ZPlanReportMsgEntity> entityList) {
        Intrinsics.checkNotNullParameter(entityList, "entityList");
        int size = entityList.size();
        if (size <= 0) {
            return new d[0];
        }
        ArrayList arrayList = new ArrayList();
        d dVar = new d();
        for (int i3 = 0; i3 < size; i3++) {
            dVar.f27014a = entityList.get(i3).msgId;
            dVar.f27015b = entityList.get(i3).msgType;
            dVar.f27016c = entityList.get(i3).msgBody;
            arrayList.add(dVar);
        }
        Object[] array = arrayList.toArray(new d[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (d[]) array;
    }

    @Override // sh3.b
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public ZPlanReportMsgEntity b(d originData) {
        Intrinsics.checkNotNullParameter(originData, "originData");
        return l(originData);
    }
}
