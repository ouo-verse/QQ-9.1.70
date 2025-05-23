package zr;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import zr.c;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f453017a;

    /* renamed from: b, reason: collision with root package name */
    public static int f453018b;

    public static int a(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void b(Canvas canvas, c cVar, c.a aVar, int i3, int i16, int i17) {
        float d16 = d() / aVar.b();
        canvas.concat(cVar.i(aVar));
        float f16 = aVar.f453051g;
        float f17 = aVar.f453046b;
        float f18 = aVar.f453055k;
        int i18 = aVar.f453058n;
        int i19 = ((int) (f16 * f17 * f18)) + (i18 * 2);
        int i26 = ((int) (aVar.f453052h * f17 * f18)) + (i18 * 2);
        float f19 = -i26;
        canvas.translate(((-i19) * 1.0f) / 2.0f, (f19 * 1.0f) / 2.0f);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.ale));
        paint.setStrokeWidth(a(BaseApplicationImpl.getApplication().getBaseContext(), 1.0f));
        float f26 = i19;
        float f27 = i26;
        float a16 = a(BaseApplicationImpl.getApplication().getBaseContext(), 3.0f);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, f26, f27), a16, a16, paint);
        float f28 = (-d16) / 2.0f;
        canvas.translate(f28, f28);
        if (i3 > 0) {
            Drawable drawable = BaseApplicationImpl.getApplication().getResources().getDrawable(i3);
            int i27 = (int) d16;
            drawable.setBounds(0, 0, i27, i27);
            drawable.draw(canvas);
        }
        canvas.translate(f26, f27);
        if (i17 > 0) {
            Drawable drawable2 = BaseApplicationImpl.getApplication().getResources().getDrawable(i17);
            int i28 = (int) d16;
            drawable2.setBounds(0, 0, i28, i28);
            drawable2.draw(canvas);
        }
        canvas.translate(0.0f, f19);
        if (i16 > 0) {
            Drawable drawable3 = BaseApplicationImpl.getApplication().getResources().getDrawable(i16);
            int i29 = (int) d16;
            drawable3.setBounds(0, 0, i29, i29);
            drawable3.draw(canvas);
        }
    }

    public static float c(int i3, int i16, int i17, int i18) {
        if (i16 < i18) {
            return 1.0f;
        }
        return i18 / i16;
    }

    public static int d() {
        return a(BaseApplicationImpl.getApplication().getBaseContext(), 30.0f);
    }

    public static int e(Context context) {
        int i3 = f453018b;
        if (i3 > 0) {
            return i3;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        int i16 = point.y;
        f453018b = i16;
        return i16;
    }

    public static int f(Context context) {
        int i3 = f453017a;
        if (i3 > 0) {
            return i3;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        int i16 = point.x;
        f453017a = i16;
        return i16;
    }

    public static int g(Context context, float f16) {
        return (int) ((f16 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
