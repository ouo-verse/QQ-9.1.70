package tz1;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.widget.listitem.x.b;
import com.tencent.widget.Switch;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003B\u0017\u0012\u0006\u0010\u000e\u001a\u00028\u0000\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0014\u00a8\u0006\u0012"}, d2 = {"Ltz1/a;", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "L", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "view", "", "position", "", "", "payloads", "", "P", "left", "right", "<init>", "(Lcom/tencent/mobileqq/widget/listitem/x$b;Lcom/tencent/mobileqq/widget/listitem/x$c$f;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a<L extends x.b> extends x<L, x.c.f> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull L left, @NotNull x.c.f right) {
        super(left, right);
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.x, com.tencent.mobileqq.widget.listitem.w
    /* renamed from: P */
    public void F(@NotNull QUISingleLineListItem view, int position, @NotNull List<? extends Object> payloads) {
        Switch r26;
        int i3;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.F(view, position, payloads);
        if (!getGrayed() && getEnabled() && (r26 = (Switch) view.findViewById(R.id.f66283a8)) != null) {
            r26.setEnabled(true);
            Drawable trackDrawable = r26.getTrackDrawable();
            if (trackDrawable != null) {
                if (O().getIsEnabled()) {
                    i3 = 255;
                } else {
                    i3 = 127;
                }
                trackDrawable.setAlpha(i3);
            }
            r26.setClickable(O().getIsEnabled());
        }
    }
}
