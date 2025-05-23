package qc0;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lqc0/q;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "", "l", "", "title", "", "showDivider", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "E", "Landroid/view/View;", "mViewLeft", UserInfo.SEX_FEMALE, "mViewRight", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "mTvTitle", "<init>", "(Landroid/view/View;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class q extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private View mViewLeft;

    /* renamed from: F, reason: from kotlin metadata */
    private View mViewRight;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView mTvTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        l(itemView);
    }

    private final void l(View itemView) {
        View findViewById = itemView.findViewById(R.id.f11839741);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.view1)");
        this.mViewLeft = findViewById;
        View findViewById2 = itemView.findViewById(R.id.f11840742);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.view2)");
        this.mViewRight = findViewById2;
        View findViewById3 = itemView.findViewById(R.id.f56662l8);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.qfs_tv_title)");
        this.mTvTitle = (TextView) findViewById3;
    }

    public final void m(@NotNull String title, boolean showDivider) {
        int i3;
        Intrinsics.checkNotNullParameter(title, "title");
        TextView textView = this.mTvTitle;
        View view = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
            textView = null;
        }
        textView.setText(title);
        View view2 = this.mViewLeft;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewLeft");
            view2 = null;
        }
        int i16 = 0;
        if (showDivider) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view2.setVisibility(i3);
        View view3 = this.mViewRight;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewRight");
        } else {
            view = view3;
        }
        if (!showDivider) {
            i16 = 8;
        }
        view.setVisibility(i16);
    }
}
