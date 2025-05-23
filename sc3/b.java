package sc3;

import android.os.Handler;
import android.os.Looper;
import java.util.Observable;
import java.util.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 \u00162\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b$\u0010%J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J(\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0011H\u0016R$\u0010#\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lsc3/b;", "Ljava/util/Observer;", "Ljava/util/Observable;", "o", "", "arg", "", "update", "data", h.F, "", "status", "f", "d", "", "peerUin", "peerNickName", "", "isGroup", "", "roomId", "g", "e", "uin", "isSpeaking", "c", "isWifi", "isBad", "b", "Landroid/os/Handler;", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "setMHandler", "(Landroid/os/Handler;)V", "mHandler", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public class b implements Observer {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Handler mHandler;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(b this$0, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h(obj);
    }

    public void b(boolean isWifi, boolean isBad) {
        throw null;
    }

    public void c(long uin, boolean isSpeaking) {
        throw null;
    }

    public void d() {
        throw null;
    }

    public void e() {
        throw null;
    }

    public void f(int status) {
        throw null;
    }

    public void g(String peerUin, String peerNickName, boolean isGroup, long roomId) {
        throw null;
    }

    public final void h(Object data) {
        Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
        Object[] objArr = (Object[]) data;
        Object obj = objArr[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        switch (((Integer) obj).intValue()) {
            case 1:
                Object obj2 = objArr[1];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                f(((Integer) obj2).intValue());
                return;
            case 2:
                d();
                return;
            case 3:
                Object obj3 = objArr[1];
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
                String str = (String) obj3;
                Object obj4 = objArr[2];
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
                String str2 = (String) obj4;
                Object obj5 = objArr[3];
                Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                boolean booleanValue = ((Boolean) obj5).booleanValue();
                Object obj6 = objArr[4];
                Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Long");
                g(str, str2, booleanValue, ((Long) obj6).longValue());
                return;
            case 4:
                e();
                return;
            case 5:
                Object obj7 = objArr[1];
                Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.Long");
                long longValue = ((Long) obj7).longValue();
                Object obj8 = objArr[2];
                Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                c(longValue, ((Boolean) obj8).booleanValue());
                return;
            case 6:
                Object obj9 = objArr[1];
                Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type kotlin.Boolean");
                boolean booleanValue2 = ((Boolean) obj9).booleanValue();
                Object obj10 = objArr[2];
                Intrinsics.checkNotNull(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                b(booleanValue2, ((Boolean) obj10).booleanValue());
                return;
            default:
                return;
        }
    }

    @Override // java.util.Observer
    public void update(Observable o16, final Object arg) {
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            if (this.mHandler == null) {
                this.mHandler = new Handler(mainLooper);
            }
            Handler handler = this.mHandler;
            Intrinsics.checkNotNull(handler);
            handler.post(new Runnable() { // from class: sc3.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.i(b.this, arg);
                }
            });
            return;
        }
        h(arg);
    }
}
