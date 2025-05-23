package r44;

import android.view.View;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.UnderlineTextView;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotQzoneData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J*\u0010\u000f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lr44/d;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotQzoneData;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/text/UnderlineTextView;", "d", "Lcom/tencent/mobileqq/text/UnderlineTextView;", "p", "()Lcom/tencent/mobileqq/text/UnderlineTextView;", "r", "(Lcom/tencent/mobileqq/text/UnderlineTextView;)V", "textTv", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d extends Section<GroupRobotQzoneData> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public UnderlineTextView textTv;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.dkr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026nfo_card_qzone_blog_text)");
        r((UnderlineTextView) findViewById);
    }

    @NotNull
    public final UnderlineTextView p() {
        UnderlineTextView underlineTextView = this.textTv;
        if (underlineTextView != null) {
            return underlineTextView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("textTv");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable GroupRobotQzoneData data, int position, @Nullable List<Object> payload) {
        if (data == null) {
            return;
        }
        p().setMaxLines(3);
        p().setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
        p().setText(data.text);
    }

    public final void r(@NotNull UnderlineTextView underlineTextView) {
        Intrinsics.checkNotNullParameter(underlineTextView, "<set-?>");
        this.textTv = underlineTextView;
    }
}
