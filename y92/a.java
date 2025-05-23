package y92;

import android.content.Intent;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.nearbypro.base.j;
import cooperation.qzone.QzoneIPCModule;
import java.util.Iterator;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00052\u00020\u0001:\u0001\u0006B\u0019\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u00a2\u0006\u0004\b$\u0010%J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J \u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\fJ\u0006\u0010\u0012\u001a\u00020\fR\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR(\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Ly92/a;", "", "", "b", "", "d", "a", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "e", h.F, "g", "f", "i", "c", "Landroidx/fragment/app/FragmentManager;", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "Ljava/util/Stack;", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "Ljava/util/Stack;", "getStack", "()Ljava/util/Stack;", "setStack", "(Ljava/util/Stack;)V", "stack", "<init>", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FragmentManager fragmentManager;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Stack<BasePartFragment> stack;

    public a(@NotNull FragmentManager fragmentManager, @NotNull String tag) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.fragmentManager = fragmentManager;
        this.tag = tag;
        this.stack = new Stack<>();
    }

    public final boolean a() {
        Iterator<BasePartFragment> it = this.stack.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "stack.iterator()");
        while (it.hasNext()) {
            if (it.next().onBackEvent()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final String b() {
        return "FragmentNavigator-" + this.tag;
    }

    public final boolean d() {
        j.c().e(b(), "onPopTopPage stack=" + this.stack.size());
        if (this.stack.empty()) {
            return false;
        }
        this.fragmentManager.beginTransaction().remove(this.stack.pop()).commitNowAllowingStateLoss();
        return true;
    }

    public final void e(int requestCode, int resultCode, @Nullable Intent data) {
        Iterator<BasePartFragment> it = this.stack.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "stack.iterator()");
        while (it.hasNext()) {
            it.next().onActivityResult(requestCode, resultCode, data);
        }
    }

    public final void c() {
    }

    public final void f() {
    }

    public final void g() {
    }

    public final void h() {
    }

    public final void i() {
    }
}
