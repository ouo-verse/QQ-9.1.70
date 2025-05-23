package te1;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012JF\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f\u00a8\u0006\u0013"}, d2 = {"Lte1/d;", "", "Landroid/content/Context;", "context", "", "type", "", "titleText", "", "contentText", "cancelBtnText", "confirmBtnText", "Landroid/content/DialogInterface$OnClickListener;", "onConfirm", "onCancel", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f435883a = new d();

    d() {
    }

    @NotNull
    public final QQCustomDialog a(@NotNull Context context, int type, @NotNull String titleText, @NotNull CharSequence contentText, @NotNull String cancelBtnText, @NotNull String confirmBtnText, @NotNull DialogInterface.OnClickListener onConfirm, @NotNull DialogInterface.OnClickListener onCancel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(titleText, "titleText");
        Intrinsics.checkNotNullParameter(contentText, "contentText");
        Intrinsics.checkNotNullParameter(cancelBtnText, "cancelBtnText");
        Intrinsics.checkNotNullParameter(confirmBtnText, "confirmBtnText");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        QQCustomDialog dialog = DialogUtil.createCustomDialog(context, type, titleText, contentText, cancelBtnText, confirmBtnText, onConfirm, onCancel);
        dialog.getBtnight().setTextColor(context.getColor(R.color.qui_common_feedback_error_selector));
        Intrinsics.checkNotNullExpressionValue(dialog, "dialog");
        return dialog;
    }
}
