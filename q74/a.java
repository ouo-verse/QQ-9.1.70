package q74;

import com.tencent.filament.zplan.business.api.b;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplanservice.download.ZPlanAvatarService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\nR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lq74/a;", "", "Lkotlinx/coroutines/CoroutineScope;", "a", "Lkotlinx/coroutines/CoroutineScope;", "b", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "Lcom/tencent/filament/zplan/business/api/b;", "Lcom/tencent/filament/zplan/business/api/b;", "()Lcom/tencent/filament/zplan/business/api/b;", "exeTask", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;", "c", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;", "()Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;", "service", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2;", "d", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2;", "()Lcom/tencent/filament/zplan/engine/FilamentViewerV2;", "viewerV2", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lcom/tencent/filament/zplan/business/api/b;Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;Lcom/tencent/filament/zplan/engine/FilamentViewerV2;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final CoroutineScope scope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final b exeTask;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ZPlanAvatarService service;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final FilamentViewerV2 viewerV2;

    public a(CoroutineScope scope, b bVar, ZPlanAvatarService zPlanAvatarService, FilamentViewerV2 filamentViewerV2) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        this.exeTask = bVar;
        this.service = zPlanAvatarService;
        this.viewerV2 = filamentViewerV2;
    }

    /* renamed from: a, reason: from getter */
    public final b getExeTask() {
        return this.exeTask;
    }

    /* renamed from: b, reason: from getter */
    public final CoroutineScope getScope() {
        return this.scope;
    }

    /* renamed from: c, reason: from getter */
    public final ZPlanAvatarService getService() {
        return this.service;
    }

    /* renamed from: d, reason: from getter */
    public final FilamentViewerV2 getViewerV2() {
        return this.viewerV2;
    }
}
