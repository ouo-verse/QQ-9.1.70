package wf4;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.base.TimiGameBaseActivity;
import com.tencent.timi.game.base.TimiGameBaseFragment;
import com.tencent.timi.game.ui.widget.k;
import gh4.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0018\u0010\r\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a8\u0006\u0011"}, d2 = {"Lwf4/a;", "", "Landroid/content/Context;", "context", "", "c", "", "loadingText", "d", "a", "Landroid/content/DialogInterface;", "dialogInterface", "e", "f", "b", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f445618a = new a();

    a() {
    }

    public final void a(@Nullable Context context) {
        if (context == null) {
            return;
        }
        if (context instanceof TimiGameBaseActivity) {
            ((TimiGameBaseActivity) context).hideLoadingView();
            return;
        }
        if (context instanceof QPublicFragmentActivity) {
            QPublicFragmentActivity qPublicFragmentActivity = (QPublicFragmentActivity) context;
            if (qPublicFragmentActivity.getFragment() instanceof TimiGameBaseFragment) {
                QPublicBaseFragment fragment = qPublicFragmentActivity.getFragment();
                Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.tencent.timi.game.base.TimiGameBaseFragment");
                ((TimiGameBaseFragment) fragment).hideLoadingView();
                return;
            }
        }
        QBaseActivity b16 = vf4.a.b();
        if (b16 instanceof TimiGameBaseActivity) {
            ((TimiGameBaseActivity) b16).hideLoadingView();
            return;
        }
        Object I0 = ((f) mm4.b.b(f.class)).I0();
        if (I0 instanceof TimiGameBaseFragment) {
            ((TimiGameBaseFragment) I0).hideLoadingView();
        }
    }

    public final void b(@Nullable DialogInterface dialogInterface) {
        if (dialogInterface instanceof k) {
            ((k) dialogInterface).hideLoadingView();
        }
    }

    public final void c(@Nullable Context context) {
        String str;
        Resources resources;
        if (context != null && (resources = context.getResources()) != null) {
            str = resources.getString(R.string.f23156727);
        } else {
            str = null;
        }
        d(context, str);
    }

    public final void d(@Nullable Context context, @Nullable String loadingText) {
        if (context != null && !TextUtils.isEmpty(loadingText)) {
            if (context instanceof TimiGameBaseActivity) {
                ((TimiGameBaseActivity) context).G2(loadingText);
                return;
            }
            if (context instanceof QPublicFragmentActivity) {
                QPublicFragmentActivity qPublicFragmentActivity = (QPublicFragmentActivity) context;
                if (qPublicFragmentActivity.getFragment() instanceof TimiGameBaseFragment) {
                    QPublicBaseFragment fragment = qPublicFragmentActivity.getFragment();
                    Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.tencent.timi.game.base.TimiGameBaseFragment");
                    TimiGameBaseFragment timiGameBaseFragment = (TimiGameBaseFragment) fragment;
                    if (loadingText == null) {
                        loadingText = "";
                    }
                    timiGameBaseFragment.th(loadingText);
                    return;
                }
            }
            QBaseActivity b16 = vf4.a.b();
            if (b16 instanceof TimiGameBaseActivity) {
                ((TimiGameBaseActivity) b16).G2(loadingText);
                return;
            }
            Object I0 = ((f) mm4.b.b(f.class)).I0();
            if (I0 instanceof TimiGameBaseFragment) {
                TimiGameBaseFragment timiGameBaseFragment2 = (TimiGameBaseFragment) I0;
                if (loadingText == null) {
                    loadingText = "";
                }
                timiGameBaseFragment2.th(loadingText);
            }
        }
    }

    public final void e(@Nullable DialogInterface dialogInterface) {
        String string = BaseApplication.getContext().getResources().getString(R.string.f23156727);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().resources.g\u2026ame_loading_hint_default)");
        f(dialogInterface, string);
    }

    public final void f(@Nullable DialogInterface dialogInterface, @NotNull String loadingText) {
        Intrinsics.checkNotNullParameter(loadingText, "loadingText");
        if (dialogInterface instanceof k) {
            ((k) dialogInterface).K(loadingText);
        }
    }
}
