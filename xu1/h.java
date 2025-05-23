package xu1;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.v;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lxu1/h;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lxu1/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "title", UserInfo.SEX_FEMALE, "desc", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "image", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class h extends RecyclerView.ViewHolder {
    private static final int I = bi.d();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final TextView title;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView desc;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ImageView image;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.title)");
        this.title = (TextView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.bg6);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.desc)");
        this.desc = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.image);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.image)");
        ImageView imageView = (ImageView) findViewById3;
        this.image = imageView;
        imageView.getLayoutParams().height = (int) (I * 0.74454826f);
    }

    public final void l(@NotNull MissionPresentItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.title.setText(item.getTitle());
        this.desc.setText(item.getDesc());
        v.k(item.getImageUrl(), this.image, new ColorDrawable(this.itemView.getResources().getColor(R.color.ajr)));
    }
}
