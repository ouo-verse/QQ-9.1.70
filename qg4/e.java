package qg4;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qg4.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lqg4/e;", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J4\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0007\u00a8\u0006\u0010"}, d2 = {"Lqg4/e$a;", "", "", "punishDesc", "Landroid/content/DialogInterface$OnClickListener;", "callback", "", "d", "tip", "positiveTxt", "positiveClickListener", "negativeTxt", "negativeClickListener", "e", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qg4.e$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(DialogInterface.OnClickListener onClickListener, DialogInterface dialogInterface, int i3) {
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i3);
            }
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(DialogInterface.OnClickListener onClickListener, DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(DialogInterface.OnClickListener onClickListener, DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i3);
            }
        }

        @JvmStatic
        public final void d(@Nullable String punishDesc, @Nullable final DialogInterface.OnClickListener callback) {
            Activity topActivity = Foreground.getTopActivity();
            if (topActivity != null && !topActivity.isDestroyed() && !topActivity.isFinishing()) {
                if (TextUtils.isEmpty(punishDesc)) {
                    punishDesc = topActivity.getResources().getString(R.string.f210155hc);
                }
                DialogUtil.createCustomDialog(topActivity, topActivity.getResources().getString(R.string.f23112710), punishDesc, null, topActivity.getResources().getString(R.string.zgi), new DialogInterface.OnClickListener() { // from class: qg4.d
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        e.Companion.f(callback, dialogInterface, i3);
                    }
                }, null).show();
            }
        }

        @JvmStatic
        public final void e(@NotNull String tip, @NotNull String positiveTxt, @Nullable final DialogInterface.OnClickListener positiveClickListener, @NotNull String negativeTxt, @Nullable final DialogInterface.OnClickListener negativeClickListener) {
            DialogInterface.OnClickListener onClickListener;
            DialogInterface.OnClickListener onClickListener2;
            Intrinsics.checkNotNullParameter(tip, "tip");
            Intrinsics.checkNotNullParameter(positiveTxt, "positiveTxt");
            Intrinsics.checkNotNullParameter(negativeTxt, "negativeTxt");
            Activity topActivity = Foreground.getTopActivity();
            if (topActivity != null && !topActivity.isDestroyed() && !topActivity.isFinishing()) {
                if (TextUtils.isEmpty(positiveTxt) && positiveClickListener == null) {
                    onClickListener = null;
                } else {
                    onClickListener = new DialogInterface.OnClickListener() { // from class: qg4.b
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            e.Companion.g(positiveClickListener, dialogInterface, i3);
                        }
                    };
                }
                if (TextUtils.isEmpty(negativeTxt) && negativeClickListener == null) {
                    onClickListener2 = null;
                } else {
                    onClickListener2 = new DialogInterface.OnClickListener() { // from class: qg4.c
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            e.Companion.h(negativeClickListener, dialogInterface, i3);
                        }
                    };
                }
                DialogUtil.createCustomDialog(topActivity, 230, (String) null, tip, negativeTxt, positiveTxt, onClickListener, onClickListener2).show();
            }
        }

        Companion() {
        }
    }

    @JvmStatic
    public static final void a(@Nullable String str, @Nullable DialogInterface.OnClickListener onClickListener) {
        INSTANCE.d(str, onClickListener);
    }

    @JvmStatic
    public static final void b(@NotNull String str, @NotNull String str2, @Nullable DialogInterface.OnClickListener onClickListener, @NotNull String str3, @Nullable DialogInterface.OnClickListener onClickListener2) {
        INSTANCE.e(str, str2, onClickListener, str3, onClickListener2);
    }
}
