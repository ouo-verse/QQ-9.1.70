package tk1;

import android.content.Context;
import android.view.View;
import androidx.annotation.CallSuper;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.api.FeedListSectionType;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tk1.b;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b8\u00109J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0015J0\u0010\u000f\u001a\u00020\u00072\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0015R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00058\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010*\u001a\u00020#8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u00101\u001a\u00028\u00008\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u0010\u000b\u001a\u00020\n8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107\u00a8\u0006:"}, d2 = {"Ltk1/a;", "Ltk1/b;", "Ext", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Ltk1/c;", "Landroid/view/View;", "initContainerView", "", "onInitView", "bindData", "", "position", "", "", "payload", "u", "Lcom/tencent/mobileqq/guild/api/FeedListSectionType;", "d", "Lcom/tencent/mobileqq/guild/api/FeedListSectionType;", "type", "e", "Landroid/view/View;", "p", "()Landroid/view/View;", "v", "(Landroid/view/View;)V", "containerView", "Landroid/content/Context;", "f", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/content/Context;", "w", "(Landroid/content/Context;)V", "context", "Lqj1/h;", h.F, "Lqj1/h;", "r", "()Lqj1/h;", HippyTKDListViewAdapter.X, "(Lqj1/h;)V", "data", "i", "Ltk1/b;", ReportConstant.COSTREPORT_PREFIX, "()Ltk1/b;", "y", "(Ltk1/b;)V", "ext", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "t", "()I", "setPosition", "(I)V", "<init>", "(Lcom/tencent/mobileqq/guild/api/FeedListSectionType;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class a<Ext extends b> extends Section<c<Ext>> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FeedListSectionType type;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    protected View containerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    protected Context context;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    protected qj1.h data;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    protected Ext ext;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int position;

    public a(@NotNull FeedListSectionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @CallSuper
    public void onInitView(@Nullable View initContainerView) {
        if (initContainerView == null) {
            return;
        }
        v(initContainerView);
        Context context = p().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "containerView.context");
        w(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final View p() {
        View view = this.containerView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Context q() {
        Context context = this.context;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final qj1.h r() {
        qj1.h hVar = this.data;
        if (hVar != null) {
            return hVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Ext s() {
        Ext ext = this.ext;
        if (ext != null) {
            return ext;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ext");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: t, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @CallSuper
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable c<Ext> bindData, int position, @Nullable List<Object> payload) {
        if (bindData == null) {
            return;
        }
        x(bindData.getData());
        y(bindData.a());
        this.position = position;
    }

    protected final void v(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.containerView = view;
    }

    protected final void w(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    protected final void x(@NotNull qj1.h hVar) {
        Intrinsics.checkNotNullParameter(hVar, "<set-?>");
        this.data = hVar;
    }

    protected final void y(@NotNull Ext ext) {
        Intrinsics.checkNotNullParameter(ext, "<set-?>");
        this.ext = ext;
    }
}
