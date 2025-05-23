package y00;

import UserGrowth.stSimpleMetaPerson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Ly00/d;", "Ly00/a;", "", "isSelectedByClickAvatar", "", "J0", "LUserGrowth/stSimpleMetaPerson;", "person", "", "feedId", "T", "u", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d extends a {
    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
    @Override // y00.a, com.tencent.biz.pubaccount.weishi.profile.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void T(stSimpleMetaPerson person, String feedId) {
        boolean z16;
        boolean isBlank;
        com.tencent.biz.pubaccount.weishi.profile.d x06 = x0();
        if (x06 == null) {
            return;
        }
        String str = person != null ? person.f25130id : null;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    F0();
                    return;
                }
                if (person != null) {
                    if (Intrinsics.areEqual(person.f25130id, q0())) {
                        x06.ba(feedId, true);
                        return;
                    }
                    F0();
                    H0(person);
                    I0(person, r0());
                    x06.ba(feedId, false);
                    return;
                }
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @Override // y00.a, com.tencent.biz.pubaccount.weishi.profile.c
    public void u(boolean isSelectedByClickAvatar) {
        J0(isSelectedByClickAvatar);
        l0();
    }

    private final void J0(boolean isSelectedByClickAvatar) {
        String str;
        if (isSelectedByClickAvatar) {
            str = "click_avatar";
        } else {
            str = "slide_enter";
        }
        G0(str);
        com.tencent.biz.pubaccount.weishi.profile.d x06 = x0();
        if (x06 != null) {
            x06.oh(getFrom());
        }
    }
}
