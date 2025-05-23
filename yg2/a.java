package yg2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import java.io.File;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends RecyclerView.ViewHolder implements View.OnTouchListener {
    private final int C;

    /* renamed from: d, reason: collision with root package name */
    URLImageView f450253d;

    /* renamed from: e, reason: collision with root package name */
    TextView f450254e;

    /* renamed from: f, reason: collision with root package name */
    RelativeLayout f450255f;

    /* renamed from: h, reason: collision with root package name */
    RecyclerView f450256h;

    /* renamed from: i, reason: collision with root package name */
    private final int f450257i;

    /* renamed from: m, reason: collision with root package name */
    private final com.tencent.mobileqq.qqexpand.fragment.f f450258m;

    public a(View view, RecyclerView recyclerView, int i3, com.tencent.mobileqq.qqexpand.fragment.f fVar, int i16) {
        super(view);
        this.f450256h = recyclerView;
        this.C = i16;
        this.f450255f = (RelativeLayout) view;
        this.f450253d = (URLImageView) view.findViewById(R.id.icon);
        this.f450254e = (TextView) view.findViewById(R.id.jfb);
        this.f450257i = i3;
        this.f450258m = fVar;
        view.setOnTouchListener(this);
    }

    public void b(a aVar, com.tencent.mobileqq.qqexpand.bean.feed.b bVar, int i3) {
        int i16;
        ViewGroup.LayoutParams layoutParams = aVar.f450255f.getLayoutParams();
        int height = this.f450256h.getHeight();
        int i17 = this.f450257i;
        layoutParams.height = height - i17;
        if (layoutParams instanceof RecyclerView.LayoutParams) {
            ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) layoutParams)).topMargin = i17;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        String e16 = com.tencent.mobileqq.qqexpand.utils.e.e("expand_square_blank.png");
        if (new File(e16).exists()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            aVar.f450253d.setImageDrawable(new BitmapDrawable(com.tencent.mobileqq.qqexpand.utils.e.a(e16, options)));
        }
        if (i3 == 1) {
            i16 = this.C == 0 ? R.string.fif : R.string.fib;
        } else {
            i16 = this.C == 0 ? R.string.fie : R.string.fia;
        }
        this.f450254e.setText(i16);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f450258m == null || motionEvent.getAction() != 0) {
            return false;
        }
        this.f450258m.n6();
        return false;
    }
}
