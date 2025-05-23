package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.guild.aio.title.GuildImmersiveTitleBar;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class ak implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f442239a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f442240b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f442241c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f442242d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f442243e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final Button f442244f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f442245g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final GuildImmersiveTitleBar f442246h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f442247i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442248j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f442249k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final ImageView f442250l;

    ak(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull Button button, @NonNull TextView textView, @NonNull GuildImmersiveTitleBar guildImmersiveTitleBar, @NonNull TextView textView2, @NonNull LinearLayout linearLayout, @NonNull TextView textView3, @NonNull ImageView imageView4) {
        this.f442239a = constraintLayout;
        this.f442240b = imageView;
        this.f442241c = constraintLayout2;
        this.f442242d = imageView2;
        this.f442243e = imageView3;
        this.f442244f = button;
        this.f442245g = textView;
        this.f442246h = guildImmersiveTitleBar;
        this.f442247i = textView2;
        this.f442248j = linearLayout;
        this.f442249k = textView3;
        this.f442250l = imageView4;
    }

    @NonNull
    public static ak e(@NonNull View view) {
        int i3 = R.id.uj7;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.uj7);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i3 = R.id.w1y;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.w1y);
            if (imageView2 != null) {
                i3 = R.id.w29;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.w29);
                if (imageView3 != null) {
                    i3 = R.id.f165590wu0;
                    Button button = (Button) ViewBindings.findChildViewById(view, R.id.f165590wu0);
                    if (button != null) {
                        i3 = R.id.wzs;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.wzs);
                        if (textView != null) {
                            i3 = R.id.xl7;
                            GuildImmersiveTitleBar guildImmersiveTitleBar = (GuildImmersiveTitleBar) ViewBindings.findChildViewById(view, R.id.xl7);
                            if (guildImmersiveTitleBar != null) {
                                i3 = R.id.f235406p;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f235406p);
                                if (textView2 != null) {
                                    i3 = R.id.f74563wl;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f74563wl);
                                    if (linearLayout != null) {
                                        i3 = R.id.f87724v5;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f87724v5);
                                        if (textView3 != null) {
                                            i3 = R.id.kab;
                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.kab);
                                            if (imageView4 != null) {
                                                return new ak(constraintLayout, imageView, constraintLayout, imageView2, imageView3, button, textView, guildImmersiveTitleBar, textView2, linearLayout, textView3, imageView4);
                                            }
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
    public static ak g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ekk, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f442239a;
    }
}
