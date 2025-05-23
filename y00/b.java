package y00;

import UserGrowth.stSimpleMetaPerson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.weishi.event.WSRedDotPersonEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007H\u0016J$\u0010\u0011\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0018\u00010\u000ej\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0018\u0001`\u0010H\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0016\u0010\u0017\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Ly00/b;", "Ly00/a;", "LUserGrowth/stSimpleMetaPerson;", "p", "", "J0", "L0", "", "isFragmentVisible", "K0", "j0", "k", "fragmentVisible", "W", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/pubaccount/weishi/event/WSSimpleBaseEvent;", "event", "b", "E", "Z", "hasLoadData", UserInfo.SEX_FEMALE, "<init>", "()V", "G", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends a {

    /* renamed from: E, reason: from kotlin metadata */
    private boolean hasLoadData;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isFragmentVisible;

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void J0(stSimpleMetaPerson p16) {
        boolean z16;
        boolean isBlank;
        if (this.hasLoadData) {
            return;
        }
        stSimpleMetaPerson person = getPerson();
        String str = person != null ? person.f25130id : null;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    return;
                }
                x.f("WSMainHostProfilePresenter", "person id is null. update person data. " + (p16 != null ? p16.f25130id : null));
                if (this.isFragmentVisible) {
                    L0();
                    return;
                } else {
                    H0(p16);
                    return;
                }
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    private final void L0() {
        I0(getPerson(), r0());
        l0();
        com.tencent.biz.pubaccount.weishi.profile.d x06 = x0();
        if (x06 != null) {
            x06.k5();
        }
        this.hasLoadData = true;
    }

    @Override // y00.a, com.tencent.biz.pubaccount.weishi.profile.c
    public void W(boolean fragmentVisible) {
        boolean isBlank;
        com.tencent.biz.pubaccount.weishi.profile.d x06;
        this.isFragmentVisible = fragmentVisible;
        K0(fragmentVisible);
        if (fragmentVisible && (x06 = x0()) != null) {
            x06.x9();
        }
        if (this.hasLoadData || !fragmentVisible) {
            return;
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(q0());
        if (isBlank) {
            return;
        }
        L0();
    }

    @Override // y00.a, com.tencent.biz.pubaccount.weishi.profile.c
    public void b(WSSimpleBaseEvent event) {
        super.b(event);
        if (event instanceof WSRedDotPersonEvent) {
            J0(((WSRedDotPersonEvent) event).getPerson());
        }
    }

    @Override // y00.a, com.tencent.biz.pubaccount.weishi.profile.c
    public ArrayList<Class<?>> getEventClass() {
        ArrayList<Class<?>> eventClass = super.getEventClass();
        if (eventClass == null) {
            return null;
        }
        eventClass.add(WSRedDotPersonEvent.class);
        return eventClass;
    }

    @Override // y00.a, com.tencent.biz.pubaccount.weishi.profile.c
    public boolean j0() {
        return true;
    }

    @Override // y00.a, com.tencent.biz.pubaccount.weishi.profile.c
    public boolean k() {
        return true;
    }

    private final void K0(boolean isFragmentVisible) {
        if (isFragmentVisible) {
            com.tencent.biz.pubaccount.weishi.profile.b.t(getFrom(), q0());
        } else {
            com.tencent.biz.pubaccount.weishi.profile.b.u(getFrom(), q0());
        }
    }
}
