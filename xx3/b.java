package xx3;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.action.api.IRobotActionApi;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import n14.AIOSchemeActionContext;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ9\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lxx3/b;", "Lwx3/a;", "", "source", "Lcom/tencent/aio/api/runtime/a;", "aioContext", QZoneDTLoginReporter.SCHEMA, "", "", "otherArgs", "", "doSchemaAction", "(Ljava/lang/String;Lcom/tencent/aio/api/runtime/a;Ljava/lang/String;[Ljava/lang/Object;)V", "<init>", "()V", "d", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b implements wx3.a {
    public void doSchemaAction(String source, com.tencent.aio.api.runtime.a aioContext, String schema, Object[] otherArgs) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(schema, "schema");
        QLog.i("RobotCommandActionCompatApiImpl", 1, "[doSchemaAction]: source=" + source + ", schema=" + schema);
        Object firstOrNull = otherArgs != null ? ArraysKt___ArraysKt.firstOrNull(otherArgs) : null;
        AIOMsgItem aIOMsgItem = firstOrNull instanceof AIOMsgItem ? (AIOMsgItem) firstOrNull : null;
        ((IRobotActionApi) QRoute.api(IRobotActionApi.class)).doSchemeAction(new AIOSchemeActionContext(aioContext, aIOMsgItem, aIOMsgItem != null ? aIOMsgItem.getMsgRecord() : null, null, 8, null), schema);
    }
}
