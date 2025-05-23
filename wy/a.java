package wy;

import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi.event.WSComboProfilePageChangeEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.verticalvideo.h;
import com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\f\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R0\u0010\u0014\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lwy/a;", "Lwz/c;", "Lcom/tencent/biz/pubaccount/weishi/event/WSComboProfilePageChangeEvent;", "", "a", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/biz/pubaccount/weishi/event/WSSimpleBaseEvent;", "event", "b", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/presenter/j;", "kotlin.jvm.PlatformType", "d", "Ljava/lang/ref/WeakReference;", "getPresenterWeakReference", "()Ljava/lang/ref/WeakReference;", "setPresenterWeakReference", "(Ljava/lang/ref/WeakReference;)V", "presenterWeakReference", "presenter", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/verticalvideo/presenter/j;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a implements wz.c<WSComboProfilePageChangeEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private WeakReference<j> presenterWeakReference;

    public a(j presenter) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.presenterWeakReference = new WeakReference<>(presenter);
    }

    private final void a() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j L2;
        j jVar = this.presenterWeakReference.get();
        stSimpleMetaFeed e16 = (jVar == null || (L2 = jVar.L2()) == null) ? null : L2.e();
        j jVar2 = this.presenterWeakReference.get();
        Map<String, String> h06 = jVar2 != null ? jVar2.h0() : null;
        j jVar3 = this.presenterWeakReference.get();
        h O0 = jVar3 != null ? jVar3.O0() : null;
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.p(O0 != null ? O0.getFrom() : null, O0 != null ? O0.getPlayScene() : null, "left_slide", 1007007, e16, h06);
    }

    @Override // wz.c
    public void b(WSSimpleBaseEvent event) {
        if (event instanceof WSComboProfilePageChangeEvent) {
            j jVar = this.presenterWeakReference.get();
            if (jVar != null) {
                jVar.M2(!((WSComboProfilePageChangeEvent) event).getSelectedProfile());
            }
            WSComboProfilePageChangeEvent wSComboProfilePageChangeEvent = (WSComboProfilePageChangeEvent) event;
            if (!wSComboProfilePageChangeEvent.getSelectedProfile() || wSComboProfilePageChangeEvent.getIsSelectedByClickAvatar()) {
                return;
            }
            a();
        }
    }

    @Override // wz.c
    public ArrayList<Class<WSComboProfilePageChangeEvent>> getEventClass() {
        ArrayList<Class<WSComboProfilePageChangeEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(WSComboProfilePageChangeEvent.class);
        return arrayListOf;
    }
}
