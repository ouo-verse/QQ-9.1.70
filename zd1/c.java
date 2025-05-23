package zd1;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.span.AlignmentSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.util.Paragraph;
import com.tencent.mobileqq.gamecenter.qa.util.GameQAUtil;
import com.tencent.mobileqq.gamecenter.qa.view.GameStrategyEditTextView;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c extends a implements LeadingMarginSpan, e<Boolean>, d<Boolean> {
    private Paragraph C;

    /* renamed from: d, reason: collision with root package name */
    private final int f452359d;

    /* renamed from: e, reason: collision with root package name */
    private final int f452360e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f452361f;

    /* renamed from: h, reason: collision with root package name */
    private float f452362h;

    /* renamed from: i, reason: collision with root package name */
    private AlignmentSpan f452363i;

    /* renamed from: m, reason: collision with root package name */
    private GameStrategyEditTextView f452364m;

    public c(int i3, int i16, boolean z16, boolean z17, boolean z18) {
        this.f452359d = i3;
        this.f452360e = i16;
        this.f452361f = z16 && z18 && !z17;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i3, int i16, int i17, int i18, int i19, CharSequence charSequence, int i26, int i27, boolean z16, Layout layout) {
        Spanned spanned = (Spanned) charSequence;
        if (!this.f452361f && spanned.getSpanStart(this) == i26) {
            float a16 = GameQAUtil.a(this.f452363i, this.C, this.f452364m, this.f452360e);
            canvas.save();
            if (a16 > 0.0f) {
                canvas.translate(a16, 0.0f);
            }
            Paint.Style style = paint.getStyle();
            float textSize = paint.getTextSize();
            paint.setStyle(Paint.Style.FILL);
            paint.setTextSize(b(spanned, i26, i27, textSize));
            this.f452362h = paint.measureText(this.f452359d + ".");
            canvas.drawText(this.f452359d + ".", i3, i18, paint);
            paint.setStyle(style);
            paint.setTextSize(textSize);
            canvas.restore();
        }
    }

    @Override // zd1.d
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public c a() {
        return new c(this.f452359d, this.f452360e, this.f452361f);
    }

    public int f() {
        return this.f452360e;
    }

    public int g() {
        return this.f452359d;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z16) {
        AlignmentSpan alignmentSpan = this.f452363i;
        if ((alignmentSpan != null && alignmentSpan.getValue() == Layout.Alignment.ALIGN_CENTER) || this.f452361f) {
            return 0;
        }
        return Math.max(Math.round(this.f452362h + 2.0f), this.f452360e);
    }

    @Override // zd1.e
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public Boolean getValue() {
        return Boolean.TRUE;
    }

    public boolean i() {
        return this.f452361f;
    }

    public void j(GameStrategyEditTextView gameStrategyEditTextView, Paragraph paragraph, AlignmentSpan alignmentSpan) {
        this.f452363i = alignmentSpan;
        this.f452364m = gameStrategyEditTextView;
        this.C = paragraph;
    }

    public c(int i3, int i16, boolean z16) {
        this.f452359d = i3;
        this.f452360e = i16;
        this.f452361f = z16;
    }
}
