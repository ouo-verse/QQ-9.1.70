package zd0;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lzd0/f;", "Lzd0/a;", "Lcom/tencent/biz/qui/noticebar/f;", "", "j", "Landroid/widget/ImageView;", DomainData.DOMAIN_NAME, "Landroid/widget/ImageView;", "iconView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "QUINoticeBar_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class f extends a<com.tencent.biz.qui.noticebar.f> implements com.tencent.biz.qui.noticebar.f {

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final ImageView iconView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull Context context) {
        super(context, new yd0.d(context));
        Intrinsics.checkNotNullParameter(context, "context");
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(getRes().e());
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int c16 = com.tencent.biz.qui.quicommon.e.c(24.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c16, c16);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        imageView.setLayoutParams(layoutParams);
        getIconLayout().addView(imageView);
        this.iconView = imageView;
    }

    @Override // com.tencent.biz.qui.noticebar.b
    public int j() {
        return 1;
    }
}
