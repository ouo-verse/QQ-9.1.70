package wt1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes14.dex */
public class f extends ImageSpan {
    private static String E = "GuildUrlCenterImageSpan";
    private int C;
    private int D;

    /* renamed from: d, reason: collision with root package name */
    private String f446493d;

    /* renamed from: e, reason: collision with root package name */
    private int f446494e;

    /* renamed from: f, reason: collision with root package name */
    private int f446495f;

    /* renamed from: h, reason: collision with root package name */
    private URLDrawable f446496h;

    /* renamed from: i, reason: collision with root package name */
    private WeakReference<Drawable.Callback> f446497i;

    /* renamed from: m, reason: collision with root package name */
    private int f446498m;

    public f(Context context, String str, int i3, int i16, int i17) {
        this(context, str, i3, i3, i16, i17, 0);
    }

    public void c(Drawable.Callback callback) {
        this.f446497i = new WeakReference<>(callback);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        canvas.save();
        canvas.translate(this.f446498m + f16, (((i19 - i17) - drawable.getBounds().bottom) / 2) + i17 + this.D);
        drawable.draw(canvas);
        canvas.restore();
        String str = this.f446493d;
        if (str != null) {
            if (str.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END) || this.f446493d.endsWith(".apng")) {
                Drawable.Callback callback = drawable.getCallback();
                if (callback instanceof View) {
                    ((View) callback).invalidate();
                }
            }
        }
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        int i3;
        if (this.f446493d != null) {
            URLDrawable uRLDrawable = this.f446496h;
            if (uRLDrawable != null) {
                return uRLDrawable;
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            int i16 = this.f446494e;
            if (i16 > 0 && (i3 = this.f446495f) > 0) {
                obtain.mRequestWidth = i16;
                obtain.mRequestHeight = i3;
            }
            if (this.f446493d.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END)) {
                obtain.mPlayGifImage = true;
            } else if (this.f446493d.endsWith(".apng")) {
                obtain.mUseApngImage = true;
            }
            URLDrawable drawable = URLDrawable.getDrawable(this.f446493d, obtain);
            this.f446496h = drawable;
            if (drawable != null) {
                WeakReference<Drawable.Callback> weakReference = this.f446497i;
                if (weakReference != null) {
                    drawable.setCallback(weakReference.get());
                }
                this.f446496h.setURLDrawableListener(new a());
                this.f446496h.setBounds(0, 0, this.f446494e, this.f446495f);
                this.f446496h.startDownload();
            }
            return this.f446496h;
        }
        return super.getDrawable();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return 0;
        }
        Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
        int i17 = fontMetricsInt2.bottom - fontMetricsInt2.top;
        Rect bounds = drawable.getBounds();
        if (fontMetricsInt != null) {
            int i18 = (bounds.bottom - bounds.top) / 2;
            int i19 = i17 / 4;
            int i26 = i18 - i19;
            int i27 = -(i18 + i19);
            fontMetricsInt.ascent = i27;
            fontMetricsInt.top = i27;
            fontMetricsInt.bottom = i26;
            fontMetricsInt.descent = i26;
        }
        return this.f446498m + bounds.right + this.C;
    }

    public f(Context context, String str, int i3, int i16, int i17, int i18) {
        this(context, str, i3, i16, i17, i18, 0);
    }

    public f(Context context, String str, int i3, int i16, int i17, int i18, int i19) {
        super(context, 0, 1);
        this.f446493d = str;
        this.f446494e = i3;
        this.f446495f = i16;
        this.f446498m = i17;
        this.C = i18;
        this.D = i19;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements URLDrawable.URLDrawableListener {
        a() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            QLog.i(f.E, 1, "onLoadSuccess url:" + f.this.f446493d);
            Drawable.Callback callback = uRLDrawable.getCallback();
            if (callback instanceof View) {
                View view = (View) callback;
                view.invalidate();
                view.requestLayout();
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
