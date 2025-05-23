package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.guild.aio.title.GuildImmersiveTitleBar;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class e implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f443003a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f443004b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f443005c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final GuildImmersiveTitleBar f443006d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f443007e;

    e(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull GuildImmersiveTitleBar guildImmersiveTitleBar, @NonNull TextView textView) {
        this.f443003a = linearLayout;
        this.f443004b = imageView;
        this.f443005c = imageView2;
        this.f443006d = guildImmersiveTitleBar;
        this.f443007e = textView;
    }

    @NonNull
    public static e e(@NonNull View view) {
        int i3 = R.id.w1y;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.w1y);
        if (imageView != null) {
            i3 = R.id.w29;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.w29);
            if (imageView2 != null) {
                i3 = R.id.xl7;
                GuildImmersiveTitleBar guildImmersiveTitleBar = (GuildImmersiveTitleBar) ViewBindings.findChildViewById(view, R.id.xl7);
                if (guildImmersiveTitleBar != null) {
                    i3 = R.id.jj7;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.jj7);
                    if (textView != null) {
                        return new e((LinearLayout) view, imageView, imageView2, guildImmersiveTitleBar, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static e g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.efk, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f443003a;
    }
}
