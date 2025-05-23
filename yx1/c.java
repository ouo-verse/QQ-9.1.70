package yx1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B|\u0012K\u0010\u0016\u001aG\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000b0\u000e\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001d\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b(\u0010)J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016RY\u0010\u0016\u001aG\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000b0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u0019R\u0014\u0010%\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b&\u0010$\u00a8\u0006*"}, d2 = {"Lyx1/c;", "Landroidx/recyclerview/widget/ListAdapter;", "Lyx1/e;", "Lyx1/g;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "viewHolder", "position", "", "i0", "getItemViewType", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "checked", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function3;", "onItemToggleSelected", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "channelId", "D", "channelName", "", "E", "Ljava/lang/Long;", "categoryId", UserInfo.SEX_FEMALE, "categoryName", "G", "I", "TYPE_ROLE_TYPE_MEMBER_", "H", "TYPE_NORMAL_MEMBER", "<init>", "(Lkotlin/jvm/functions/Function3;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c extends ListAdapter<RoleSelectItem, g> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private final String channelId;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private final String channelName;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private final Long categoryId;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private final String categoryName;

    /* renamed from: G, reason: from kotlin metadata */
    private final int TYPE_ROLE_TYPE_MEMBER_;

    /* renamed from: H, reason: from kotlin metadata */
    private final int TYPE_NORMAL_MEMBER;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function3<RoleSelectItem, Integer, Boolean, Unit> onItemToggleSelected;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c(@NotNull Function3<? super RoleSelectItem, ? super Integer, ? super Boolean, Unit> onItemToggleSelected, @Nullable String str, @Nullable String str2, @Nullable Long l3, @Nullable String str3) {
        super(r0);
        DiffUtil.ItemCallback b16;
        Intrinsics.checkNotNullParameter(onItemToggleSelected, "onItemToggleSelected");
        b16 = d.b();
        this.onItemToggleSelected = onItemToggleSelected;
        this.channelId = str;
        this.channelName = str2;
        this.categoryId = l3;
        this.categoryName = str3;
        this.TYPE_NORMAL_MEMBER = 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (getItem(position).getRole().w() && position == getCurrentList().size() - 1) {
            return this.TYPE_NORMAL_MEMBER;
        }
        return this.TYPE_ROLE_TYPE_MEMBER_;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull g viewHolder, int position) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        RoleSelectItem item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        viewHolder.m(item, this.channelId, this.channelName, this.categoryId, this.categoryName);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public g onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == this.TYPE_NORMAL_MEMBER) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.ewd, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026al_member, parent, false)");
            return new b(inflate, this.onItemToggleSelected);
        }
        View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.ewc, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   \u2026ole_group, parent, false)");
        return new g(inflate2, this.onItemToggleSelected);
    }
}
