package u70;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a implements ViewPager2.PageTransformer {

    /* renamed from: a, reason: collision with root package name */
    private float f438518a = 0.8f;

    private ViewPager2 a(@NonNull View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return (ViewPager2) parent2;
        }
        return null;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f16) {
        ViewPager2 a16 = a(view);
        if (a16 == null) {
            return;
        }
        float paddingLeft = a16.getPaddingLeft();
        float measuredWidth = f16 - (paddingLeft / ((a16.getMeasuredWidth() - paddingLeft) - a16.getPaddingRight()));
        float width = view.getWidth();
        float f17 = this.f438518a;
        float f18 = ((1.0f - f17) * width) / 2.0f;
        if (measuredWidth <= -1.0f) {
            view.setTranslationX(f18);
            view.setScaleX(this.f438518a);
            view.setScaleY(this.f438518a);
            return;
        }
        double d16 = measuredWidth;
        if (d16 <= 1.0d) {
            float abs = (1.0f - f17) * Math.abs(1.0f - Math.abs(measuredWidth));
            float f19 = (-f18) * measuredWidth;
            if (d16 <= -0.5d) {
                view.setTranslationX(f19 + (Math.abs(Math.abs(measuredWidth) - 0.5f) / 0.5f));
            } else if (measuredWidth <= 0.0f) {
                view.setTranslationX(f19);
            } else if (d16 >= 0.5d) {
                view.setTranslationX(f19 - (Math.abs(Math.abs(measuredWidth) - 0.5f) / 0.5f));
            } else {
                view.setTranslationX(f19);
            }
            view.setScaleX(this.f438518a + abs);
            view.setScaleY(abs + this.f438518a);
            return;
        }
        view.setScaleX(f17);
        view.setScaleY(this.f438518a);
        view.setTranslationX(-f18);
    }
}
