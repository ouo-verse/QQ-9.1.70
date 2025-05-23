package xm2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QFixToast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\n\u00a8\u0006\u000e"}, d2 = {"Lxm2/b;", "", "Landroid/content/Context;", "context", "", "msg", "Landroid/widget/TextView;", "b", "", "d", "", "c", "<init>", "()V", "qq-richmediabrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f448169a = new b();

    b() {
    }

    private final TextView b(Context context, String msg2) {
        TextView textView = new TextView(context);
        textView.setPadding(ViewUtils.dpToPx(12.0f), ViewUtils.dpToPx(6.0f), ViewUtils.dpToPx(12.0f), ViewUtils.dpToPx(6.0f));
        textView.setTextColor(-1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(8.0f);
        gradientDrawable.setColor(Color.parseColor("#80000000"));
        textView.setBackground(gradientDrawable);
        textView.setText(msg2);
        textView.setTextSize(14.0f);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(TextView toastView) {
        Intrinsics.checkNotNullParameter(toastView, "$toastView");
        QFixToast qFixToast = new QFixToast(com.tencent.open.adapter.a.f().e());
        qFixToast.setView(toastView);
        qFixToast.setDuration(0);
        qFixToast.setGravity(17, 0, -200);
        qFixToast.show();
    }

    public final void c(@NotNull Context context, int msg2) {
        Intrinsics.checkNotNullParameter(context, "context");
        String qqStr = HardCodeUtil.qqStr(msg2);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(msg)");
        d(context, qqStr);
    }

    public final void d(@NotNull Context context, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        final TextView b16 = b(context, msg2);
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: xm2.a
            @Override // java.lang.Runnable
            public final void run() {
                b.e(b16);
            }
        }, 500L);
    }
}
