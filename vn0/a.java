package vn0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.guild.aio.reserve2.busi.chosen.view.ChosenBarView;
import com.tencent.guild.aio.reserve2.busi.chosen.view.DotAnimIndexView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.qqui.RoundRectImageView;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ChosenBarView f441888a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ChosenBarView f441889b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f441890c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f441891d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f441892e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f441893f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final RoundRectImageView f441894g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final DotAnimIndexView f441895h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final FrameLayout f441896i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f441897j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final ImageView f441898k;

    a(@NonNull ChosenBarView chosenBarView, @NonNull ChosenBarView chosenBarView2, @NonNull View view, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull RoundRectImageView roundRectImageView, @NonNull DotAnimIndexView dotAnimIndexView, @NonNull FrameLayout frameLayout, @NonNull TextView textView4, @NonNull ImageView imageView) {
        this.f441888a = chosenBarView;
        this.f441889b = chosenBarView2;
        this.f441890c = view;
        this.f441891d = textView;
        this.f441892e = textView2;
        this.f441893f = textView3;
        this.f441894g = roundRectImageView;
        this.f441895h = dotAnimIndexView;
        this.f441896i = frameLayout;
        this.f441897j = textView4;
        this.f441898k = imageView;
    }

    @NonNull
    public static a e(@NonNull View view) {
        ChosenBarView chosenBarView = (ChosenBarView) view;
        int i3 = R.id.twm;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.twm);
        if (findChildViewById != null) {
            i3 = R.id.twn;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.twn);
            if (textView != null) {
                i3 = R.id.twp;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.twp);
                if (textView2 != null) {
                    i3 = R.id.twq;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.twq);
                    if (textView3 != null) {
                        i3 = R.id.twr;
                        RoundRectImageView roundRectImageView = (RoundRectImageView) ViewBindings.findChildViewById(view, R.id.twr);
                        if (roundRectImageView != null) {
                            i3 = R.id.ukn;
                            DotAnimIndexView dotAnimIndexView = (DotAnimIndexView) ViewBindings.findChildViewById(view, R.id.ukn);
                            if (dotAnimIndexView != null) {
                                i3 = R.id.zfw;
                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.zfw);
                                if (frameLayout != null) {
                                    i3 = R.id.f24810_5;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f24810_5);
                                    if (textView4 != null) {
                                        i3 = R.id.kro;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.kro);
                                        if (imageView != null) {
                                            return new a(chosenBarView, chosenBarView, findChildViewById, textView, textView2, textView3, roundRectImageView, dotAnimIndexView, frameLayout, textView4, imageView);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static a g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ee_, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ChosenBarView getRoot() {
        return this.f441888a;
    }
}
