package zn0;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.Navigator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lzn0/a;", "Lys/a;", "", "path", "Landroidx/fragment/app/Fragment;", "fragment", "", "requestCode", "Landroid/os/Bundle;", "argument", "", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a implements ys.a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f452788a = new a();

    a() {
    }

    @Override // ys.a
    public void a(@NotNull String path, @NotNull Fragment fragment, int requestCode, @Nullable Bundle argument) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Navigator createNavigator = QRoute.createNavigator(fragment.requireContext(), path);
        Intrinsics.checkNotNullExpressionValue(createNavigator, "createNavigator(fragment.requireContext(),path)");
        Navigator.withRequestCode$default(createNavigator, fragment, requestCode, (Bundle) null, 4, (Object) null).withAll(argument).request();
    }
}
