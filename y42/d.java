package y42;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010%\u001a\u00020\u0006\u0012\u0006\u0010&\u001a\u00020\u0006\u0012\u0006\u0010'\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000e\u00a2\u0006\u0004\b(\u0010)J4\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016JP\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001dR\u0016\u0010$\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001d\u00a8\u0006*"}, d2 = {"Ly42/d;", "Landroid/text/style/ReplacementSpan;", "Landroid/graphics/Paint;", "paint", "", "text", "", "start", "end", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "getSize", "Landroid/graphics/Canvas;", PM.CANVAS, "", HippyTKDListViewAdapter.X, "top", "y", "bottom", "", "draw", "", "d", "Z", "bold", "e", UserInfo.SEX_FEMALE, "textSize", "f", "I", "mSize", h.F, "mBgColor", "i", "mTextColor", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mRadius", "bgColor", "textColor", "radius", "<init>", "(IIIZF)V", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d extends ReplacementSpan {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean bold;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final float textSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mBgColor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mTextColor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mRadius;

    public /* synthetic */ d(int i3, int i16, int i17, boolean z16, float f16, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, i17, (i18 & 8) != 0 ? false : z16, (i18 & 16) != 0 ? -1.0f : f16);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NotNull Canvas canvas, @NotNull CharSequence text, int start, int end, float x16, int top, int y16, int bottom, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        int color = paint.getColor();
        paint.setColor(this.mBgColor);
        float textSize = paint.getTextSize();
        Paint.Style style = paint.getStyle();
        float strokeWidth = paint.getStrokeWidth();
        float f16 = this.textSize;
        if (f16 > 0.0f) {
            paint.setTextSize(f16);
        }
        if (this.bold) {
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setStrokeWidth(0.5f);
        }
        paint.setAntiAlias(true);
        float f17 = y16;
        float descent = ((this.mRadius * 2) - (paint.descent() - paint.ascent())) / 2;
        RectF rectF = new RectF(x16, (paint.ascent() + f17) - descent, this.mSize + x16, paint.descent() + f17 + descent);
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        paint.setColor(this.mTextColor);
        canvas.drawText(text, start, end, x16 + this.mRadius, f17, paint);
        paint.setStrokeWidth(strokeWidth);
        paint.setStyle(style);
        paint.setColor(color);
        paint.setTextSize(textSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NotNull Paint paint, @Nullable CharSequence text, int start, int end, @Nullable Paint.FontMetricsInt fm5) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        float textSize = paint.getTextSize();
        paint.setTextSize(this.textSize);
        this.mSize = (int) (paint.measureText(text, start, end) + (this.mRadius * 2));
        paint.setTextSize(textSize);
        return this.mSize;
    }

    public d(int i3, int i16, int i17, boolean z16, float f16) {
        this.bold = z16;
        this.textSize = f16;
        this.mBgColor = i3;
        this.mTextColor = i16;
        this.mRadius = i17;
    }
}
