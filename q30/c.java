package q30;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qqnt.avatar.core.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0013"}, d2 = {"Lq30/c;", "Lcom/tencent/qqnt/avatar/core/a;", "Lcom/tencent/qqnt/avatar/layer/c;", "e", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/avatar/bean/a;", "bean", "Lcom/tencent/qqnt/avatar/core/a$a;", "callback", "", "forceRefresh", "Lcom/tencent/qqnt/avatar/fetch/b;", "a", "Lcom/tencent/qqnt/avatar/fetch/d;", "c", "<init>", "()V", "b", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class c extends com.tencent.qqnt.avatar.core.a {
    public c() {
        super(5);
    }

    private final com.tencent.qqnt.avatar.layer.c e() {
        ViewUtils viewUtils = ViewUtils.f352270a;
        int a16 = viewUtils.a(4.0f);
        int a17 = viewUtils.a(56.0f) - a16;
        return new com.tencent.qqnt.avatar.layer.c(new Rect(a16, a16, a17, a17), true, null);
    }

    @Override // com.tencent.qqnt.avatar.core.a
    @NotNull
    public com.tencent.qqnt.avatar.fetch.b a(@NotNull Context context, @NotNull com.tencent.qqnt.avatar.bean.a bean, @NotNull a.InterfaceC9507a callback, boolean forceRefresh) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bean, "bean");
        Intrinsics.checkNotNullParameter(callback, "callback");
        b bVar = new b();
        if (!(bean instanceof com.tencent.mobileqq.proavatar.bean.a)) {
            return bVar;
        }
        callback.a(new com.tencent.qqnt.avatar.fetch.d(bean, true, new com.tencent.qqnt.avatar.layer.b(bean, new q30.b(((com.tencent.mobileqq.proavatar.bean.a) bean).f()), e()), null, 8, null));
        return bVar;
    }

    @Override // com.tencent.qqnt.avatar.core.a
    @Nullable
    public com.tencent.qqnt.avatar.fetch.d c(@NotNull com.tencent.qqnt.avatar.bean.a bean, boolean forceRefresh) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        return null;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"q30/c$b", "Lcom/tencent/qqnt/avatar/fetch/b;", "", "cancel", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements com.tencent.qqnt.avatar.fetch.b {
        b() {
        }

        @Override // com.tencent.qqnt.avatar.fetch.b
        public void cancel() {
        }
    }
}
