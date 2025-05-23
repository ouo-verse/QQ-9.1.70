package q92;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.h;
import com.tencent.mobileqq.nearby.now.view.widget.FitXImageView;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static float f428746a = -1.0f;

    public static boolean a(h.b bVar, float f16, float f17) {
        ImageDisplayView imageDisplayView = bVar.f252895e;
        if (imageDisplayView == null || bVar.f252894d == null || !(imageDisplayView.getContext() instanceof Activity) || f17 == 0.0f || f16 == 0.0f) {
            return false;
        }
        VideoData videoData = bVar.f252898h;
        if (videoData != null && videoData.f252693d == VideoData.f252689l0) {
            e(bVar);
            return false;
        }
        ViewGroup.LayoutParams layoutParams = bVar.f252893c.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = bVar.f252894d.getLayoutParams();
        View decorView = ((Activity) bVar.f252895e.getContext()).getWindow().getDecorView();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        float height = rect.height();
        float screenWidth = ba.getScreenWidth(bVar.f252895e.getContext());
        float f18 = height / 2.0f;
        f428746a = f18;
        if (screenWidth / height < f16 / f17) {
            float f19 = f17 * (screenWidth / f16);
            int i3 = (int) screenWidth;
            layoutParams.width = i3;
            layoutParams.height = (int) f19;
            if (f19 <= f18) {
                layoutParams2.width = i3;
                layoutParams2.height = (int) f18;
                layoutParams.width = i3;
                layoutParams.height = (int) f18;
                bVar.f252893c.setLayoutParams(layoutParams);
                bVar.f252894d.setLayoutParams(layoutParams2);
                bVar.f252894d.getRootView().setBackgroundColor(Color.parseColor("#000000"));
                bVar.f252894d.requestLayout();
                bVar.f252893c.requestLayout();
            } else {
                bVar.f252894d.setLayoutParams(layoutParams);
                bVar.f252893c.setLayoutParams(layoutParams);
                bVar.f252894d.requestLayout();
                bVar.f252893c.requestLayout();
            }
        } else {
            int i16 = (int) screenWidth;
            layoutParams.width = i16;
            int i17 = (int) height;
            layoutParams.height = i17;
            bVar.f252893c.setLayoutParams(layoutParams);
            bVar.f252893c.requestLayout();
            layoutParams2.width = i16;
            layoutParams2.height = i17;
            bVar.f252894d.setLayoutParams(layoutParams);
            bVar.f252894d.requestLayout();
        }
        ImageView imageView = (ImageView) bVar.f252893c.findViewById(R.id.duw);
        ImageView imageView2 = (ImageView) bVar.f252893c.findViewById(R.id.bo_);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return true;
    }

    public static boolean b(h.b bVar, float f16, float f17, VideoData videoData, IShortVideoCommentsView iShortVideoCommentsView) {
        ImageDisplayView imageDisplayView = bVar.f252895e;
        if (imageDisplayView == null || bVar.f252894d == null || iShortVideoCommentsView == null || !(imageDisplayView.getContext() instanceof Activity)) {
            return false;
        }
        VideoData videoData2 = bVar.f252898h;
        if (videoData2 != null && videoData2.f252693d == VideoData.f252689l0) {
            e(bVar);
            return false;
        }
        ViewGroup.LayoutParams layoutParams = bVar.f252895e.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = bVar.f252894d.getLayoutParams();
        View decorView = ((Activity) bVar.f252895e.getContext()).getWindow().getDecorView();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        float height = rect.height();
        float screenWidth = ba.getScreenWidth(bVar.f252895e.getContext());
        float f18 = height / 2.0f;
        f428746a = f18;
        if (screenWidth / height < f17 / f16) {
            float f19 = f16 * (screenWidth / f17);
            int i3 = (int) screenWidth;
            layoutParams.width = i3;
            layoutParams.height = (int) f19;
            if (f19 <= f18) {
                layoutParams2.width = i3;
                layoutParams2.height = (int) f18;
                layoutParams.width = i3;
                layoutParams.height = (int) f18;
                bVar.f252895e.setLayoutParams(layoutParams);
                bVar.f252894d.setLayoutParams(layoutParams2);
                bVar.f252894d.getRootView().setBackgroundColor(Color.parseColor("#000000"));
                bVar.f252894d.requestLayout();
                bVar.f252895e.requestLayout();
            } else {
                bVar.f252894d.setLayoutParams(layoutParams);
                bVar.f252895e.setLayoutParams(layoutParams);
                bVar.f252894d.requestLayout();
                bVar.f252895e.requestLayout();
            }
        } else {
            int i16 = (int) screenWidth;
            layoutParams.width = i16;
            int i17 = (int) height;
            layoutParams.height = i17;
            bVar.f252895e.setLayoutParams(layoutParams);
            bVar.f252895e.requestLayout();
            layoutParams2.width = i16;
            layoutParams2.height = i17;
            bVar.f252894d.setLayoutParams(layoutParams);
            bVar.f252894d.requestLayout();
            bVar.f252895e.requestLayout();
        }
        bVar.f252893c.setBackgroundDrawable(new ColorDrawable(-16777216));
        return false;
    }

    public static boolean e(h.b bVar) {
        bVar.f252893c.setVisibility(8);
        bVar.f252895e.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = bVar.f252892b.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        bVar.f252892b.setLayoutParams(layoutParams);
        return true;
    }

    public static boolean c(View view, Rect rect) {
        return (view.getTag(R.id.j3g) instanceof Integer) && ((Integer) view.getTag(R.id.j3g)).intValue() == rect.height();
    }

    public static boolean d(FitXImageView fitXImageView, int i3, int i16) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (fitXImageView == null) {
            return false;
        }
        float screenHeight = ba.getScreenHeight(fitXImageView.getContext()) - (fitXImageView.getContext() instanceof Activity ? ViewUtils.getStatusBarHeight((Activity) fitXImageView.getContext()) : 0);
        float screenWidth = ba.getScreenWidth(fitXImageView.getContext());
        float f16 = i16 * (screenWidth / i3);
        int dp2px = (int) ba.dp2px(fitXImageView.getContext(), 60.0f);
        float dp2px2 = dp2px + f16 + ((int) ba.dp2px(fitXImageView.getContext(), 72.0f)) + 10.0f;
        int i17 = (int) screenHeight;
        int dp2px3 = i17 - ((int) ba.dp2px(fitXImageView.getContext(), 50.0f));
        ViewGroup.LayoutParams layoutParams = fitXImageView.getLayoutParams();
        float f17 = dp2px3;
        if (dp2px2 >= f17) {
            if (f16 < screenHeight) {
                layoutParams.height = (int) f16;
                layoutParams.width = (int) screenWidth;
                fitXImageView.setLayoutParams(layoutParams);
                fitXImageView.requestLayout();
            } else {
                layoutParams.width = (int) screenWidth;
                layoutParams.height = i17;
                fitXImageView.setLayoutParams(layoutParams);
                fitXImageView.requestLayout();
            }
        } else if (dp2px2 < f17) {
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            marginLayoutParams.topMargin = dp2px;
            marginLayoutParams.height = (int) f16;
            marginLayoutParams.width = (int) screenWidth;
            fitXImageView.setLayoutParams(marginLayoutParams);
            fitXImageView.requestLayout();
        }
        return false;
    }
}
