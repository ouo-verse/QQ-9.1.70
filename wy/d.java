package wy;

import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.event.WSVerticalFloatWindowEvent;
import com.tencent.biz.pubaccount.weishi.verticalvideo.h;
import com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\f\u00a2\u0006\u0004\b\u0016\u0010\u0017J$\u0010\u0006\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\u0003j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0004`\u0005H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R0\u0010\u0014\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lwy/d;", "Lwz/c;", "Lcom/tencent/biz/pubaccount/weishi/event/WSVerticalFloatWindowEvent;", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/pubaccount/weishi/event/WSSimpleBaseEvent;", "event", "", "b", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/presenter/j;", "kotlin.jvm.PlatformType", "d", "Ljava/lang/ref/WeakReference;", "getPresenterWeakReference", "()Ljava/lang/ref/WeakReference;", "setPresenterWeakReference", "(Ljava/lang/ref/WeakReference;)V", "presenterWeakReference", "presenter", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/verticalvideo/presenter/j;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d implements wz.c<WSVerticalFloatWindowEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private WeakReference<j> presenterWeakReference;

    public d(j presenter) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.presenterWeakReference = new WeakReference<>(presenter);
    }

    @Override // wz.c
    public void b(WSSimpleBaseEvent event) {
        if (event instanceof WSVerticalFloatWindowEvent) {
            WSVerticalFloatWindowEvent wSVerticalFloatWindowEvent = (WSVerticalFloatWindowEvent) event;
            j jVar = this.presenterWeakReference.get();
            h O0 = jVar != null ? jVar.O0() : null;
            int type = wSVerticalFloatWindowEvent.getType();
            if (type != 1) {
                if (type == 2 && O0 != null && O0.D()) {
                    String from = O0.getFrom();
                    String playScene = O0.getPlayScene();
                    stSimpleMetaFeed Tc = O0.Tc();
                    j jVar2 = this.presenterWeakReference.get();
                    com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.G(from, playScene, Tc, jVar2 != null ? jVar2.h0() : null);
                    return;
                }
                return;
            }
            boolean isNotNeedSeamLess = wSVerticalFloatWindowEvent.getIsNotNeedSeamLess();
            if (O0 != null) {
                O0.K3(isNotNeedSeamLess);
            }
        }
    }

    @Override // wz.c
    public ArrayList<Class<WSVerticalFloatWindowEvent>> getEventClass() {
        ArrayList<Class<WSVerticalFloatWindowEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(WSVerticalFloatWindowEvent.class);
        return arrayListOf;
    }
}
