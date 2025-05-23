package tj3;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.zootopia.api.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pv4.j;
import qv4.ad;
import qv4.ay;
import qv4.bf;
import vb3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J \u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006H&J,\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H&J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H&J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\rH&J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0002H&J \u0010\u001e\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00022\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0006H&\u00a8\u0006\u001f"}, d2 = {"Ltj3/a;", "Lvb3/b;", "Lpv4/j;", "reserveItem", "", "needRemind", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/bf;", "callback", "", "s0", "Lqv4/b;", "J", "", "reservationType", "reserveStatus", "Lqv4/ad;", "i", "Landroidx/lifecycle/MutableLiveData;", "r0", "", "reserveId", "reserveType", "o", "Landroid/content/Context;", "context", "u0", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "E0", "Lqv4/ay;", BdhLogUtil.LogTag.Tag_Req, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface a extends b {
    void E0(j item);

    void J(j reserveItem, e<qv4.b> callback);

    void R(j item, e<ay> callback);

    void i(int reservationType, int reserveStatus, e<ad> callback);

    j o(String reserveId, int reserveType);

    MutableLiveData<ad> r0();

    void s0(j reserveItem, boolean needRemind, e<bf> callback);

    void u0(Context context);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: tj3.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11293a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(a aVar, j jVar, boolean z16, e eVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = true;
                }
                if ((i3 & 4) != 0) {
                    eVar = new b();
                }
                aVar.s0(jVar, z16, eVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reserve");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(a aVar, int i3, int i16, e eVar, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 1) != 0) {
                    i3 = 0;
                }
                if ((i17 & 2) != 0) {
                    i16 = 0;
                }
                if ((i17 & 4) != 0) {
                    eVar = new C11294a();
                }
                aVar.i(i3, i16, eVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshReservationList");
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"tj3/a$a$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/ad;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: tj3.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes36.dex */
        public static final class C11294a implements e<ad> {
            C11294a() {
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResultSuccess(ad result) {
                Intrinsics.checkNotNullParameter(result, "result");
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            public void onResultFailure(int error, String message) {
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"tj3/a$a$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/bf;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: tj3.a$a$b */
        /* loaded from: classes36.dex */
        public static final class b implements e<bf> {
            b() {
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResultSuccess(bf result) {
                Intrinsics.checkNotNullParameter(result, "result");
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            public void onResultFailure(int error, String message) {
            }
        }
    }
}
