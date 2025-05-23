package wy;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.combo.home.rightpager.WSComboVerticalVideoProgressManager;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.j;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\"\u001a\u00020\u0012\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J$\u0010\u0010\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\rj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e`\u000fH\u0016R0\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u00120\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010!\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lwy/b;", "Lwz/c;", "Lcom/tencent/biz/pubaccount/weishi/event/WSComboHomePageChangeEvent;", "changeEvent", "", "c", "", "state", "index", "a", "Lcom/tencent/biz/pubaccount/weishi/event/WSSimpleBaseEvent;", "event", "b", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/presenter/j;", "kotlin.jvm.PlatformType", "d", "Ljava/lang/ref/WeakReference;", "getPresenterWeakReference", "()Ljava/lang/ref/WeakReference;", "setPresenterWeakReference", "(Ljava/lang/ref/WeakReference;)V", "presenterWeakReference", "e", "I", "getScrollState", "()I", "setScrollState", "(I)V", HippyTKDListViewAdapter.SCROLL_STATE, "presenter", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/verticalvideo/presenter/j;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b implements wz.c<WSComboHomePageChangeEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private WeakReference<j> presenterWeakReference;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int scrollState;

    public b(j presenter) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.presenterWeakReference = new WeakReference<>(presenter);
    }

    private final void a(WSComboHomePageChangeEvent changeEvent, int state, int index) {
        if (Intrinsics.areEqual(changeEvent.getPageChangeEvent(), "onPageScrollStateChanged") && this.scrollState != state) {
            this.scrollState = state;
            if (index == 1 && state == 0) {
                j jVar = this.presenterWeakReference.get();
                if (jVar != null) {
                    jVar.O2();
                    return;
                }
                return;
            }
            if (index == 1 && (state == 1 || state == 2)) {
                WSComboVerticalVideoProgressManager.INSTANCE.a().h();
            } else if (index == 0 && state == 0) {
                WSComboVerticalVideoProgressManager.INSTANCE.a().h();
            }
        }
    }

    private final void c(WSComboHomePageChangeEvent changeEvent) {
        j jVar;
        if (!Intrinsics.areEqual(changeEvent.getPageChangeEvent(), "onPageSelected") || (jVar = this.presenterWeakReference.get()) == null) {
            return;
        }
        jVar.M2(changeEvent.getPageIndex() == 1);
    }

    @Override // wz.c
    public void b(WSSimpleBaseEvent event) {
        Intrinsics.checkNotNull(event, "null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent");
        WSComboHomePageChangeEvent wSComboHomePageChangeEvent = (WSComboHomePageChangeEvent) event;
        if (TextUtils.equals(wSComboHomePageChangeEvent.getBottomBarId(), "monofeed_tab")) {
            int scrollState = wSComboHomePageChangeEvent.getScrollState();
            int pageIndex = wSComboHomePageChangeEvent.getPageIndex();
            x.i("WSComboVerticalVideoProgressManager", "[WSComboScrollStateChangeReceiver][onReceiveEvent] pageIndex:" + pageIndex + ", scrollState:" + scrollState);
            c(wSComboHomePageChangeEvent);
            a(wSComboHomePageChangeEvent, scrollState, pageIndex);
        }
    }

    @Override // wz.c
    public ArrayList<Class<WSComboHomePageChangeEvent>> getEventClass() {
        ArrayList<Class<WSComboHomePageChangeEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(WSComboHomePageChangeEvent.class);
        return arrayListOf;
    }
}
