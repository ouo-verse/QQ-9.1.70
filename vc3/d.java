package vc3;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lvc3/d;", "", "Landroid/view/View;", "root", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f441387a = new d();

    d() {
    }

    public final void a(View root) {
        Intrinsics.checkNotNullParameter(root, "root");
        ViewCompat.setTransitionName(root.findViewById(R.id.r5v), "zootopia_share_bg");
    }
}
