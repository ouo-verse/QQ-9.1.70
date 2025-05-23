package xs;

import android.view.View;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\u0013\u0014J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J&\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH&J.\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&\u00a2\u0006\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lxs/a;", "", "", "msgPosition", "Lxs/a$c;", "listener", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "position", "", "baseBottom", "Lxs/a$b;", "completeListener", "p", "offset", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "f", "()Ljava/lang/Long;", "b", "c", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface a {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* renamed from: xs.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C11562a {
        public static /* synthetic */ boolean a(a aVar, int i3, boolean z16, b bVar, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    z16 = false;
                }
                if ((i16 & 4) != 0) {
                    bVar = null;
                }
                return aVar.p(i3, z16, bVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollToMsgPosition");
        }

        public static /* synthetic */ boolean b(a aVar, int i3, boolean z16, int i16, b bVar, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 2) != 0) {
                    z16 = false;
                }
                if ((i17 & 8) != 0) {
                    bVar = null;
                }
                return aVar.z(i3, z16, i16, bVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollToMsgPositionWithOffset");
        }

        public static /* synthetic */ void c(a aVar, int i3, c cVar, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    cVar = null;
                }
                aVar.m(i3, cVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: smoothScrollToMsgPosition");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"Lxs/a$c;", "Lxs/a$b;", "", "onScrollStart", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public interface c extends b {

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
        /* renamed from: xs.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C11564a {
            public static void a(@NotNull c cVar) {
                b.C11563a.a(cVar);
            }
        }

        void onScrollStart();
    }

    @Nullable
    Long f();

    void m(int msgPosition, @Nullable c listener);

    boolean p(int position, boolean baseBottom, @Nullable b completeListener);

    boolean z(int position, boolean baseBottom, int offset, @Nullable b completeListener);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"Lxs/a$b;", "", "Landroid/view/View;", "targetView", "", "b", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void b(@Nullable View targetView);

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
        /* renamed from: xs.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C11563a {
            public static void a(@NotNull b bVar) {
            }
        }
    }
}
