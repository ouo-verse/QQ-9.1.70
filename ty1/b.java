package ty1;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.smtt.sdk.URLUtil;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b extends ClickableSpan {

    /* renamed from: d, reason: collision with root package name */
    private Context f437907d;

    /* renamed from: e, reason: collision with root package name */
    private String f437908e;

    /* renamed from: f, reason: collision with root package name */
    private int f437909f;

    public b(Context context, String str, int i3) {
        this.f437907d = context;
        this.f437908e = str;
        this.f437909f = i3;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NonNull View view) {
        cx.a(this.f437907d, URLUtil.guessUrl(this.f437908e));
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
        textPaint.setColor(this.f437909f);
    }
}
