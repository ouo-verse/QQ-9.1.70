package yx1;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\\\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012K\u0010\u000e\u001aG\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012RY\u0010\u000e\u001aG\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lyx1/b;", "Lyx1/g;", "Lkotlin/Function3;", "Lyx1/e;", "Lkotlin/ParameterName;", "name", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", "checked", "", "K", "Lkotlin/jvm/functions/Function3;", "onItemToggleSelected", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function3;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b extends g {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Function3<RoleSelectItem, Integer, Boolean, Unit> onItemToggleSelected;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull final View view, @NotNull Function3<? super RoleSelectItem, ? super Integer, ? super Boolean, Unit> onItemToggleSelected) {
        super(view, onItemToggleSelected);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(onItemToggleSelected, "onItemToggleSelected");
        this.onItemToggleSelected = onItemToggleSelected;
        view.postDelayed(new Runnable() { // from class: yx1.a
            @Override // java.lang.Runnable
            public final void run() {
                b.s(view);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(View view) {
        Intrinsics.checkNotNullParameter(view, "$view");
        ((TextView) view.findViewById(R.id.f97615kv)).setText(R.string.f15015148);
        ((TextView) view.findViewById(R.id.f97625kw)).setText(R.string.f15016149);
    }
}
