package r12;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import aw1.MedalItem;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lr12/e;", "Landroid/widget/PopupWindow;", "Landroid/view/View;", "viewBottom", "", "b", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "medalIcon", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "toastTips", "Law1/m;", "medalItem", "<init>", "(Landroid/content/Context;Law1/m;)V", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e extends PopupWindow {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View rootView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView medalIcon;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView toastTips;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull Context context, @NotNull MedalItem medalItem) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(medalItem, "medalItem");
        this.context = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.exs, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026medal_toast_layout, null)");
        this.rootView = inflate;
        View findViewById = inflate.findViewById(R.id.wpo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.guild_medal_icon)");
        ImageView imageView = (ImageView) findViewById;
        this.medalIcon = imageView;
        View findViewById2 = inflate.findViewById(R.id.x2l);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.guild_toast_tip)");
        TextView textView = (TextView) findViewById2;
        this.toastTips = textView;
        setWidth(bi.d());
        setHeight(bi.b(48));
        setBackgroundDrawable(new ColorDrawable(0));
        u.r(medalItem.getMedalUrl(), imageView, false, null);
        textView.setText(medalItem.getMedalDesc());
        setContentView(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public final void b(@NotNull View viewBottom) {
        Intrinsics.checkNotNullParameter(viewBottom, "viewBottom");
        showAtLocation(viewBottom, 48, 0, -((int) (ScreenUtil.getInstantScreenHeight(this.context) * 0.1f)));
        this.rootView.postDelayed(new Runnable() { // from class: r12.d
            @Override // java.lang.Runnable
            public final void run() {
                e.c(e.this);
            }
        }, 2000L);
    }
}
