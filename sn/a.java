package sn;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class a extends Drawable {

    /* renamed from: d, reason: collision with root package name */
    protected Paint f433982d;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        Paint paint = new Paint();
        this.f433982d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f433982d.setAntiAlias(true);
        this.f433982d.setColor(-5592406);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f433982d.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f433982d.setColorFilter(colorFilter);
    }
}
