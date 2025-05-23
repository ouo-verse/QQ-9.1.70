package vn0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.guild.widgets.GuildCheckBox;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class y implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f442053a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442054b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final GuildCheckBox f442055c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442056d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final URLImageView f442057e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f442058f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f442059g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f442060h;

    y(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull GuildCheckBox guildCheckBox, @NonNull FrameLayout frameLayout, @NonNull URLImageView uRLImageView, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ImageView imageView2) {
        this.f442053a = relativeLayout;
        this.f442054b = relativeLayout2;
        this.f442055c = guildCheckBox;
        this.f442056d = frameLayout;
        this.f442057e = uRLImageView;
        this.f442058f = imageView;
        this.f442059g = textView;
        this.f442060h = imageView2;
    }

    @NonNull
    public static y e(@NonNull View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i3 = R.id.dpo;
        GuildCheckBox guildCheckBox = (GuildCheckBox) ViewBindings.findChildViewById(view, R.id.dpo);
        if (guildCheckBox != null) {
            i3 = R.id.xsw;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.xsw);
            if (frameLayout != null) {
                i3 = R.id.f165862dq3;
                URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.f165862dq3);
                if (uRLImageView != null) {
                    i3 = R.id.f165863dq4;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f165863dq4);
                    if (imageView != null) {
                        i3 = R.id.drh;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.drh);
                        if (textView != null) {
                            i3 = R.id.dri;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.dri);
                            if (imageView2 != null) {
                                return new y(relativeLayout, relativeLayout, guildCheckBox, frameLayout, uRLImageView, imageView, textView, imageView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static y g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static y h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f2a, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f442053a;
    }
}
