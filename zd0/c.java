package zd0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.richframework.widget.RFWRoundImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0016\u0010\r\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016R\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R&\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0019j\b\u0012\u0004\u0012\u00020\u000b`\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lzd0/c;", "Lzd0/b;", "Lcom/tencent/biz/qui/noticebar/c;", "", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "size", "B", "j", "", "Landroid/graphics/drawable/Drawable;", "avatarDrawables", "i", "", "sizeDp", "startDp", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "o", "I", "avatarSize", "p", "avatarOverlaySize", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "borderSize", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "r", "Ljava/util/ArrayList;", "avatarDrawableList", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "QUINoticeBar_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class c extends b<com.tencent.biz.qui.noticebar.c> implements com.tencent.biz.qui.noticebar.c {

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final int avatarSize;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final int avatarOverlaySize;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final int borderSize;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private ArrayList<Drawable> avatarDrawableList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull Context context) {
        super(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.avatarSize = com.tencent.biz.qui.quicommon.e.c(24.0f);
        this.avatarOverlaySize = com.tencent.biz.qui.quicommon.e.c(8.0f);
        this.borderSize = com.tencent.biz.qui.quicommon.e.c(0.5f);
        this.avatarDrawableList = new ArrayList<>();
    }

    private final void B(int size) {
        int childCount = getIconLayout().getChildCount();
        if (childCount > size) {
            getIconLayout().removeViews(size, childCount - size);
        } else if (childCount < size) {
            int color = getContext().getColor(R.color.qui_common_border_superlight);
            while (childCount < size) {
                FrameLayout iconLayout = getIconLayout();
                RFWRoundImageView rFWRoundImageView = new RFWRoundImageView(getContext());
                int i3 = this.avatarSize;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i3);
                layoutParams.gravity = 16;
                rFWRoundImageView.setLayoutParams(layoutParams);
                rFWRoundImageView.setBorderWidth(this.borderSize);
                rFWRoundImageView.setBorderColor(color);
                rFWRoundImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                Unit unit = Unit.INSTANCE;
                iconLayout.addView(rFWRoundImageView);
                childCount++;
            }
        }
        if (size > 0) {
            int i16 = 0;
            View childAt = getIconLayout().getChildAt(0);
            if (childAt != null) {
                RFWRoundImageView rFWRoundImageView2 = (RFWRoundImageView) childAt;
                if (size != 1) {
                    i16 = this.borderSize;
                }
                rFWRoundImageView2.setBorderWidth(i16);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.richframework.widget.RFWRoundImageView");
        }
    }

    private final void C() {
        int childCount = getIconLayout().getChildCount();
        int i3 = (this.avatarSize * childCount) - (this.avatarOverlaySize * (childCount - 1));
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getIconLayout().getChildAt(i16);
            Intrinsics.checkNotNullExpressionValue(childAt, "iconLayout.getChildAt(i)");
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams != null) {
                ((FrameLayout.LayoutParams) layoutParams).setMarginStart(((getIconLayoutSize() - i3) / 2) + ((this.avatarSize - this.avatarOverlaySize) * i16));
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
        }
    }

    private final void z() {
        int size = this.avatarDrawableList.size();
        for (int i3 = 0; i3 < size; i3++) {
            View childAt = getIconLayout().getChildAt(i3);
            if (childAt != null) {
                ((RFWRoundImageView) childAt).setImageDrawable(this.avatarDrawableList.get(i3));
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.richframework.widget.RFWRoundImageView");
            }
        }
    }

    @Override // zd0.a, com.tencent.biz.qui.noticebar.b
    @NotNull
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public com.tencent.biz.qui.noticebar.c a(float sizeDp, float startDp) {
        com.tencent.biz.qui.noticebar.c cVar = (com.tencent.biz.qui.noticebar.c) super.a(sizeDp, startDp);
        C();
        return cVar;
    }

    @Override // com.tencent.biz.qui.noticebar.c
    @NotNull
    public com.tencent.biz.qui.noticebar.c i(@NotNull List<? extends Drawable> avatarDrawables) {
        Intrinsics.checkNotNullParameter(avatarDrawables, "avatarDrawables");
        this.avatarDrawableList.clear();
        if (avatarDrawables.size() > 3) {
            for (int i3 = 0; i3 < 3; i3++) {
                this.avatarDrawableList.add(avatarDrawables.get(i3));
            }
        } else {
            this.avatarDrawableList.addAll(avatarDrawables);
        }
        B(this.avatarDrawableList.size());
        C();
        z();
        return this;
    }

    @Override // com.tencent.biz.qui.noticebar.b
    public int j() {
        return 2;
    }
}
