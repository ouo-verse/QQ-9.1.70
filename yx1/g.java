package yx1;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\\\u0012\u0006\u0010/\u001a\u00020.\u0012K\u0010\u001d\u001aG\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u000b0\u0016\u00a2\u0006\u0004\b0\u00101J?\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0002\u00a2\u0006\u0004\b\f\u0010\rJ-\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002J?\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u0011\u0010\rJ\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016RY\u0010\u001d\u001aG\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u000b0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010 \u00a8\u00062"}, d2 = {"Lyx1/g;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/base/extension/f;", "Lyx1/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "channelId", "channelName", "", "categoryId", "categoryName", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lyx1/e;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "o", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "viewType", "", "c", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "position", "checked", "E", "Lkotlin/jvm/functions/Function3;", "onItemToggleSelected", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "title", "G", "channelNameTextView", "Landroid/widget/CheckBox;", "H", "Landroid/widget/CheckBox;", "checkSelected", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "imageRoleColor", "J", "adminRoleColor", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function3;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class g extends RecyclerView.ViewHolder implements com.tencent.mobileqq.guild.base.extension.f {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Function3<RoleSelectItem, Integer, Boolean, Unit> onItemToggleSelected;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView title;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final TextView channelNameTextView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final CheckBox checkSelected;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ImageView imageRoleColor;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final TextView adminRoleColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull View view, @NotNull Function3<? super RoleSelectItem, ? super Integer, ? super Boolean, Unit> onItemToggleSelected) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(onItemToggleSelected, "onItemToggleSelected");
        this.onItemToggleSelected = onItemToggleSelected;
        View findViewById = this.itemView.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.title)");
        this.title = (TextView) findViewById;
        View findViewById2 = this.itemView.findViewById(R.id.w26);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.guild_channel_name)");
        this.channelNameTextView = (TextView) findViewById2;
        View findViewById3 = this.itemView.findViewById(R.id.ax9);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.check_selected)");
        this.checkSelected = (CheckBox) findViewById3;
        View findViewById4 = this.itemView.findViewById(R.id.xdq);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.icon_dot_role_color)");
        this.imageRoleColor = (ImageView) findViewById4;
        View findViewById5 = this.itemView.findViewById(R.id.xda);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.icon_admin_role_color)");
        this.adminRoleColor = (TextView) findViewById5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(RoleSelectItem item, g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (item.getIsEnable()) {
            this$0.onItemToggleSelected.invoke(item, Integer.valueOf(this$0.getAdapterPosition()), Boolean.valueOf(!item.getIsSelect()));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void o(String channelId, Long categoryId, String categoryName) {
        boolean z16;
        boolean z17;
        boolean z18 = true;
        if (channelId != null && channelId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.channelNameTextView.setVisibility(0);
            this.channelNameTextView.setText("\u8bf7\u5230\u5bf9\u5e94\u5b50\u9891\u9053\u8bbe\u7f6e");
            return;
        }
        if (categoryId != null && categoryId.longValue() != 0) {
            if (categoryName != null && categoryName.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                if (categoryName != null && categoryName.length() != 0) {
                    z18 = false;
                }
                if (!z18) {
                    this.channelNameTextView.setVisibility(0);
                    this.channelNameTextView.setText(categoryName);
                    return;
                } else {
                    this.channelNameTextView.setVisibility(8);
                    return;
                }
            }
        }
        this.channelNameTextView.setVisibility(0);
        this.channelNameTextView.setText("\u5f53\u524d\u5b50\u9891\u9053\u6682\u65e0\u5206\u7ec4");
    }

    private final void p(String channelId, String channelName) {
        boolean z16;
        boolean z17;
        if (channelId != null && channelId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.channelNameTextView.setVisibility(0);
            this.channelNameTextView.setText("\u8bf7\u5230\u5bf9\u5e94\u5b50\u9891\u9053\u8bbe\u7f6e");
            return;
        }
        if (channelName != null && channelName.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17) {
            this.channelNameTextView.setVisibility(0);
            TextView textView = this.channelNameTextView;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("#%s", Arrays.copyOf(new Object[]{channelName}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
            return;
        }
        this.channelNameTextView.setVisibility(8);
    }

    private final void q(RoleSelectItem item, String channelId, String channelName, Long categoryId, String categoryName) {
        RoleGroupModel role = item.getRole();
        if (role.t()) {
            o(channelId, categoryId, categoryName);
        } else if (role.u()) {
            p(channelId, channelName);
        }
    }

    @Override // com.tencent.mobileqq.guild.base.extension.f
    public boolean c(int viewType) {
        return true;
    }

    public void m(@NotNull final RoleSelectItem item, @Nullable String channelId, @Nullable String channelName, @Nullable Long categoryId, @Nullable String categoryName) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.title.setText(item.getRole().getName());
        this.checkSelected.setChecked(item.getIsSelect());
        this.checkSelected.setEnabled(item.getIsEnable());
        dy1.a aVar = dy1.a.f395200a;
        int color = item.getRole().getColor();
        int roleType = item.getRole().getRoleType();
        boolean b16 = aVar.b(item.getRole().getLvRole());
        ImageView imageView = this.imageRoleColor;
        TextView textView = this.adminRoleColor;
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        aVar.d(color, roleType, b16, imageView, textView, context);
        q(item, channelId, channelName, categoryId, categoryName);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: yx1.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.n(RoleSelectItem.this, this, view);
            }
        });
    }
}
