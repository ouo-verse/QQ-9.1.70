package zd1;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.span.AlignmentSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.util.Paragraph;
import com.tencent.mobileqq.gamecenter.qa.util.GameQAUtil;
import com.tencent.mobileqq.gamecenter.qa.view.GameStrategyEditTextView;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b extends a implements LeadingMarginSpan, e<Boolean>, d<Boolean> {

    /* renamed from: m, reason: collision with root package name */
    private static Path f452353m;

    /* renamed from: d, reason: collision with root package name */
    private final int f452354d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f452355e;

    /* renamed from: f, reason: collision with root package name */
    private AlignmentSpan f452356f;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<GameStrategyEditTextView> f452357h;

    /* renamed from: i, reason: collision with root package name */
    private Paragraph f452358i;

    public b(int i3, boolean z16, boolean z17, boolean z18) {
        this.f452354d = i3;
        this.f452355e = z16 && z18 && !z17;
        if (f452353m == null) {
            f452353m = new Path();
        }
    }

    private void f(Canvas canvas, Paint paint, int i3, int i16, int i17, int i18, int i19) {
        f452353m.reset();
        f452353m.addCircle(0.0f, 0.0f, i19, Path.Direction.CW);
        canvas.save();
        float a16 = GameQAUtil.a(this.f452356f, this.f452358i, g(), this.f452354d);
        if (a16 > 0.0f) {
            canvas.translate(a16, 0.0f);
        }
        canvas.translate(i3 + (i16 * i19), (i17 + i18) / 2.0f);
        canvas.drawPath(f452353m, paint);
        canvas.restore();
    }

    private GameStrategyEditTextView g() {
        WeakReference<GameStrategyEditTextView> weakReference = this.f452357h;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i3, int i16, int i17, int i18, int i19, CharSequence charSequence, int i26, int i27, boolean z16, Layout layout) {
        Spanned spanned = (Spanned) charSequence;
        if (!this.f452355e && spanned.getSpanStart(this) == i26) {
            Paint.Style style = paint.getStyle();
            paint.setStyle(Paint.Style.FILL);
            f(canvas, paint, i3, i16, i17, i19, Math.max(Math.round(b(spanned, i26, i27, paint.getTextSize()) / 9.0f), 4));
            paint.setStyle(style);
        }
    }

    @Override // zd1.d
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public b a() {
        return new b(this.f452354d, this.f452355e);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z16) {
        AlignmentSpan alignmentSpan = this.f452356f;
        if ((alignmentSpan != null && alignmentSpan.getValue() == Layout.Alignment.ALIGN_CENTER) || this.f452355e) {
            return 0;
        }
        return this.f452354d;
    }

    public int h() {
        return this.f452354d;
    }

    @Override // zd1.e
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Boolean getValue() {
        return Boolean.TRUE;
    }

    public boolean j() {
        return this.f452355e;
    }

    public void k(GameStrategyEditTextView gameStrategyEditTextView, Paragraph paragraph, AlignmentSpan alignmentSpan) {
        this.f452356f = alignmentSpan;
        this.f452357h = new WeakReference<>(gameStrategyEditTextView);
        this.f452358i = paragraph;
    }

    public b(int i3, boolean z16) {
        this.f452354d = i3;
        this.f452355e = z16;
    }
}
