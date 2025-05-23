package um4;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import um4.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004J\u0006\u0010\b\u001a\u00020\u0002J\b\u0010\n\u001a\u0004\u0018\u00010\tR \u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lum4/k;", "", "", "c", "Landroidx/lifecycle/LiveData;", "", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "b", "e", "Lnh2/c;", "d", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "mGiftDataLiveData", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f439239a = new k();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<List<com.tencent.mobileqq.qqgift.data.service.d>> mGiftDataLiveData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"um4/k$a", "Lrh2/e;", "", "errCode", "", "errMsg", "", "onFailed", "", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "giftList", "onReceive", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements rh2.e {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Ref.ObjectRef filterData) {
            Intrinsics.checkNotNullParameter(filterData, "$filterData");
            k.mGiftDataLiveData.setValue(filterData.element);
        }

        @Override // qh2.d
        public void onFailed(int errCode, @Nullable String errMsg) {
            l.c("TeamGiftDataManager_", 1, "requestTeamGift#getGiftList#onFailed: " + errCode + "; " + errMsg);
        }

        /* JADX WARN: Type inference failed for: r3v10, types: [java.util.List, T] */
        /* JADX WARN: Type inference failed for: r4v0, types: [T, java.util.Collection, java.util.ArrayList] */
        @Override // rh2.e
        public void onReceive(@Nullable List<com.tencent.mobileqq.qqgift.data.service.d> giftList) {
            if (giftList == null) {
                l.c("TeamGiftDataManager_", 1, "requestTeamGift#getGiftList#onReceive: giftList == null");
                return;
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? arrayList = new ArrayList();
            Iterator<T> it = giftList.iterator();
            while (true) {
                boolean z16 = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((com.tencent.mobileqq.qqgift.data.service.d) next).F == 0) {
                    z16 = true;
                }
                if (z16) {
                    arrayList.add(next);
                }
            }
            objectRef.element = arrayList;
            if (((List) arrayList).size() > 20) {
                l.c("TeamGiftDataManager_", 1, "requestTeamGift#getGiftList#onReceive: list size too big!");
                objectRef.element = ((List) objectRef.element).subList(0, 20);
            }
            l.a("TeamGiftDataManager_", 1, "giftList size:" + giftList.size() + ", filterData size:" + ((List) objectRef.element).size());
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: um4.j
                @Override // java.lang.Runnable
                public final void run() {
                    k.a.b(Ref.ObjectRef.this);
                }
            });
        }
    }

    k() {
    }

    @NotNull
    public final LiveData<List<com.tencent.mobileqq.qqgift.data.service.d>> b() {
        return mGiftDataLiveData;
    }

    public final void c() {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.timi.game.initer.impl.b.f377190a.f(10007);
        l.a("TeamGiftDataManager_", 1, "initGiftSdk time: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
    }

    @Nullable
    public final nh2.c d() {
        nh2.c c16 = com.tencent.timi.game.initer.impl.b.f377190a.c(10007);
        if (c16 != null && !c16.isDestroyed() && c16.isInited()) {
            return c16;
        }
        l.k("TeamGiftDataManager_", 1, "obtainGiftSdk giftSdk is null or bad state!");
        return null;
    }

    public final void e() {
        nh2.c d16 = d();
        if (d16 == null) {
            return;
        }
        d16.a().P(new com.tencent.mobileqq.qqgift.data.service.a(1, "10007", "", ""), new a());
    }
}
