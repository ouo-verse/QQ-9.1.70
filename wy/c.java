package wy;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.combo.home.rightpager.WSComboVerticalVideoProgressManager;
import com.tencent.biz.pubaccount.weishi.event.WSComboMainPageChangeEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\f\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b`\tH\u0016R0\u0010\u0014\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lwy/c;", "Lwz/c;", "Lcom/tencent/biz/pubaccount/weishi/event/WSComboMainPageChangeEvent;", "Lcom/tencent/biz/pubaccount/weishi/event/WSSimpleBaseEvent;", "event", "", "b", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/presenter/j;", "kotlin.jvm.PlatformType", "d", "Ljava/lang/ref/WeakReference;", "getPresenterWeakReference", "()Ljava/lang/ref/WeakReference;", "setPresenterWeakReference", "(Ljava/lang/ref/WeakReference;)V", "presenterWeakReference", "", "e", "Ljava/lang/String;", "getBarId", "()Ljava/lang/String;", "setBarId", "(Ljava/lang/String;)V", "barId", "presenter", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/verticalvideo/presenter/j;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c implements wz.c<WSComboMainPageChangeEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private WeakReference<j> presenterWeakReference;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String barId;

    public c(j presenter) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.presenterWeakReference = new WeakReference<>(presenter);
        this.barId = uy.b.f440579a.a();
    }

    @Override // wz.c
    public void b(WSSimpleBaseEvent event) {
        Intrinsics.checkNotNull(event, "null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi.event.WSComboMainPageChangeEvent");
        String barId = ((WSComboMainPageChangeEvent) event).getBarId();
        x.i("WSComboVerticalVideoProgressManager", "[WSComboTabChangeReceiver][onReceiveEvent] barId:" + this.barId + ", curBarId:" + barId);
        if (TextUtils.equals(this.barId, "monofeed_tab") && !TextUtils.equals(barId, this.barId)) {
            WSComboVerticalVideoProgressManager.INSTANCE.a().h();
            j jVar = this.presenterWeakReference.get();
            if (jVar != null) {
                jVar.M2(false);
            }
        }
        if (!TextUtils.equals(this.barId, "monofeed_tab") && TextUtils.equals(barId, "monofeed_tab")) {
            j jVar2 = this.presenterWeakReference.get();
            if (jVar2 != null) {
                jVar2.O2();
            }
            j jVar3 = this.presenterWeakReference.get();
            if (jVar3 != null) {
                jVar3.M2(true);
            }
        }
        this.barId = barId;
    }

    @Override // wz.c
    public ArrayList<Class<WSComboMainPageChangeEvent>> getEventClass() {
        ArrayList<Class<WSComboMainPageChangeEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(WSComboMainPageChangeEvent.class);
        return arrayListOf;
    }
}
