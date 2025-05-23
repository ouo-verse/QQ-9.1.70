package q73;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Supplier;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter;
import com.tencent.mobileqq.wink.view.ab;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0017\u0018B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\"\u0010\r\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u001a\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014\u00a8\u0006\u0019"}, d2 = {"Lq73/a;", "Lcom/tencent/mobileqq/wink/editor/template/g;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/mobileqq/wink/view/ab$a;", "o0", "vh", "position", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "n0", "getItemViewType", UserInfo.SEX_FEMALE, "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;)V", "W", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends com.tencent.mobileqq.wink.editor.template.g {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context context, @NotNull WinkEditorViewModel.EditMode editMode) {
        super(context, editMode);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(editMode, "editMode");
        q0(0);
        this.V = 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter
    public void F(int position, @Nullable MetaMaterial material) {
        AbsWinkMaterialPanelContentAdapter.e eVar;
        if (material == null) {
            return;
        }
        if ((y(position, material) || position != this.f326745h) && (eVar = this.I) != null) {
            eVar.a(position, material);
        }
    }

    @Override // com.tencent.mobileqq.wink.view.ab, android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return Intrinsics.areEqual(B().get(position).f30533id, "star_empty_template_id") ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.template.g, com.tencent.mobileqq.wink.view.ab
    public void n0(@Nullable ab.a vh5, int position, @NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        if (!Intrinsics.areEqual(B().get(position).f30533id, "star_empty_template_id")) {
            super.n0(vh5, position, material);
        }
    }

    @Override // com.tencent.mobileqq.wink.view.ab
    @NotNull
    protected ab.a o0(@Nullable ViewGroup parent, int viewType) {
        ab.a aVar;
        Context context = null;
        if (viewType == 1) {
            if (parent != null) {
                context = parent.getContext();
            }
            View inflate = LayoutInflater.from(context).inflate(R.layout.hfi, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent?.context).in\u2026rent, false\n            )");
            aVar = new b(this, inflate);
        } else {
            if (parent != null) {
                context = parent.getContext();
            }
            aVar = new ab.a(LayoutInflater.from(context).inflate(R.layout.hfj, parent, false));
        }
        return aVar;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ8\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016JN\u0010\u0017\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016\u00a8\u0006\u001c"}, d2 = {"Lq73/a$b;", "Lcom/tencent/mobileqq/wink/view/ab$a;", "", "layoutType", "viewType", "itemMargin", "downloadProgressRadius", "downloadProgressStrokeWidth", "downloadBgWidth", "", "i", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "position", "selectIndex", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "", "resReady", "Landroidx/core/util/Supplier;", "clickable", "Lcom/tencent/mobileqq/wink/view/AbsWinkMaterialPanelContentAdapter$c;", "itemClickListener", "f", "Landroid/view/View;", "itemView", "<init>", "(Lq73/a;Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class b extends ab.a {
        final /* synthetic */ a H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull a aVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.H = aVar;
        }

        @Override // com.tencent.mobileqq.wink.view.ab.a
        public void i(int layoutType, int viewType, int itemMargin, int downloadProgressRadius, int downloadProgressStrokeWidth, int downloadBgWidth) {
        }

        @Override // com.tencent.mobileqq.wink.view.ab.a
        public void f(@Nullable MetaMaterial material, int position, int selectIndex, @Nullable WinkEditorViewModel.EditMode editMode, boolean resReady, @Nullable Supplier<Boolean> clickable, @Nullable AbsWinkMaterialPanelContentAdapter.c itemClickListener) {
        }
    }
}
