package w6;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends ClickableSpan {

    /* renamed from: d, reason: collision with root package name */
    private String f444619d;

    /* renamed from: e, reason: collision with root package name */
    private String f444620e;

    /* renamed from: f, reason: collision with root package name */
    private int f444621f = Integer.MIN_VALUE;

    /* compiled from: P */
    /* renamed from: w6.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public interface InterfaceC11463a {
    }

    public a(String str, String str2, InterfaceC11463a interfaceC11463a) {
        this.f444619d = str;
        this.f444620e = str2;
    }

    public void a(int i3) {
        this.f444621f = i3;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        int i3 = this.f444621f;
        if (i3 != Integer.MIN_VALUE) {
            textPaint.setColor(i3);
        } else {
            super.updateDrawState(textPaint);
        }
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
    }
}
