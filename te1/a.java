package te1;

import android.content.Context;
import android.view.LayoutInflater;
import com.tencent.mobileqq.widget.QFixToast;
import com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lte1/a;", "Lcom/tencent/mobileqq/widget/QFixToast;", "Lvp1/a;", "a", "Lvp1/a;", "viewBinding", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a extends QFixToast {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private static WeakReference<a> f435880c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final vp1.a viewBinding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lte1/a$a;", "", "Landroid/content/Context;", "context", "", IMiniCardBeancurd.SIGN_PLAIN_TEXT, "Lte1/a;", "a", "", "b", "Lmqq/util/WeakReference;", "lastToast", "Lmqq/util/WeakReference;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: te1.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final a a(@NotNull Context context, @NotNull String plainText) {
            a aVar;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(plainText, "plainText");
            WeakReference weakReference = a.f435880c;
            if (weakReference != null && (aVar = (a) weakReference.get()) != null) {
                aVar.cancel();
            }
            a aVar2 = new a(context);
            aVar2.viewBinding.f442135b.setText(plainText);
            aVar2.setDuration(1);
            a.f435880c = new WeakReference(aVar2);
            return aVar2;
        }

        public final void b(@NotNull Context context, @NotNull String plainText) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(plainText, "plainText");
            a(context, plainText).show();
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        vp1.a g16 = vp1.a.g(LayoutInflater.from(context), null, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, null, false)");
        this.viewBinding = g16;
        setGravity(17, 0, 0);
        setView(g16.getRoot());
    }
}
