package sn;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import androidx.core.graphics.PathParser;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c extends a {
    protected static final Region J = new Region();
    protected static final Region K = new Region(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected int C;
    protected List<Path> D;
    protected List<Integer> E;
    protected List<Path> F;
    protected List<String> G;
    private Bitmap H;
    private boolean I;

    /* renamed from: e, reason: collision with root package name */
    protected int f433983e = 1;

    /* renamed from: f, reason: collision with root package name */
    protected int f433984f = 1;

    /* renamed from: h, reason: collision with root package name */
    protected int f433985h = 0;

    /* renamed from: i, reason: collision with root package name */
    protected int f433986i = 0;

    /* renamed from: m, reason: collision with root package name */
    protected int f433987m;

    private void a(int i3, int i16) {
        Bitmap bitmap = this.H;
        if (bitmap != null && i3 == bitmap.getWidth() && i16 == this.H.getHeight()) {
            return;
        }
        this.H = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        this.I = true;
    }

    private void b(Canvas canvas) {
        canvas.translate(-this.f433985h, -this.f433986i);
        if (this.D != null) {
            for (int i3 = 0; i3 < this.D.size(); i3++) {
                List<Integer> list = this.E;
                if (list != null && i3 < list.size()) {
                    this.f433982d.setColor(this.E.get(i3).intValue());
                }
                canvas.drawPath(this.D.get(i3), this.f433982d);
            }
        }
    }

    protected boolean d() {
        Integer num;
        Integer num2;
        Integer num3;
        int i3;
        int intValue;
        int intValue2;
        int intValue3;
        int intValue4;
        List<Path> list = this.D;
        Integer num4 = null;
        if (list != null) {
            Integer num5 = null;
            num2 = null;
            num3 = null;
            for (Path path : list) {
                Region region = J;
                region.setPath(path, K);
                Rect bounds = region.getBounds();
                if (num4 == null) {
                    intValue = bounds.top;
                } else {
                    intValue = num4.intValue();
                }
                num4 = Integer.valueOf(Math.min(intValue, bounds.top));
                if (num5 == null) {
                    intValue2 = bounds.left;
                } else {
                    intValue2 = num5.intValue();
                }
                num5 = Integer.valueOf(Math.min(intValue2, bounds.left));
                if (num2 == null) {
                    intValue3 = bounds.right;
                } else {
                    intValue3 = num2.intValue();
                }
                num2 = Integer.valueOf(Math.max(intValue3, bounds.right));
                if (num3 == null) {
                    intValue4 = bounds.bottom;
                } else {
                    intValue4 = num3.intValue();
                }
                num3 = Integer.valueOf(Math.max(intValue4, bounds.bottom));
            }
            num = num4;
            num4 = num5;
        } else {
            num = null;
            num2 = null;
            num3 = null;
        }
        this.f433985h = num4 == null ? 0 : num4.intValue();
        this.f433986i = num == null ? 0 : num.intValue();
        this.f433983e = num2 == null ? 0 : num2.intValue() - this.f433985h;
        int intValue5 = num3 == null ? 0 : num3.intValue() - this.f433986i;
        this.f433984f = intValue5;
        if (this.f433987m == 0) {
            this.f433987m = this.f433983e;
        }
        if (this.C == 0) {
            this.C = intValue5;
        }
        Rect bounds2 = getBounds();
        int i16 = this.f433983e;
        if (i16 != 0 && (i3 = this.f433984f) != 0) {
            int i17 = bounds2.left;
            int i18 = bounds2.top;
            super.setBounds(i17, i18, i16 + i17, i3 + i18);
            return true;
        }
        if (this.f433987m == 0) {
            this.f433987m = 1;
        }
        if (this.C == 0) {
            this.C = 1;
        }
        this.f433984f = 1;
        this.f433983e = 1;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (this.f433982d.getAlpha() == 255) {
            canvas.save();
            canvas.translate(bounds.left - this.f433985h, bounds.top - this.f433986i);
            if (this.D != null) {
                for (int i3 = 0; i3 < this.D.size(); i3++) {
                    List<Integer> list = this.E;
                    if (list != null && i3 < list.size()) {
                        this.f433982d.setColor(this.E.get(i3).intValue());
                    }
                    canvas.drawPath(this.D.get(i3), this.f433982d);
                }
                this.f433982d.setAlpha(255);
            }
            canvas.restore();
            return;
        }
        a(width, height);
        if (this.I) {
            this.H.eraseColor(0);
            b(new Canvas(this.H));
            this.I = false;
        }
        canvas.drawBitmap(this.H, bounds.left, bounds.top, this.f433982d);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i3, int i16, int i17, int i18) {
        int i19 = i17 - i3;
        int i26 = i18 - i16;
        List<Path> list = this.F;
        if (list != null && list.size() > 0 && (i19 != this.f433983e || i26 != this.f433984f)) {
            int i27 = this.f433985h;
            int i28 = this.f433986i;
            float f16 = i19;
            float f17 = i26;
            this.D = b.a((f16 * 1.0f) / this.f433987m, (f17 * 1.0f) / this.C, this.F, this.G);
            if (d()) {
                return;
            }
            this.f433983e = i19;
            this.f433984f = i26;
            this.f433985h = (int) (((i27 * 1.0f) * f16) / this.f433987m);
            this.f433986i = (int) (((i28 * 1.0f) * f17) / this.C);
            super.setBounds(i3, i16, i17, i18);
            return;
        }
        super.setBounds(i3, i16, i17, i18);
    }

    public boolean e(String... strArr) {
        this.C = 0;
        this.f433987m = 0;
        this.G = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.F = arrayList;
        this.D = arrayList;
        for (String str : strArr) {
            this.G.add(str);
            this.F.add(PathParser.createPathFromPathData(str));
        }
        return d();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        setBounds(rect.left, rect.top, rect.right, rect.bottom);
    }
}
