package x12;

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
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discover.widget.GuildRoundBoardImageView;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class e implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f446912a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f446913b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f446914c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f446915d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final GuildRoundBoardImageView f446916e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f446917f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f446918g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f446919h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f446920i;

    e(@NonNull RelativeLayout relativeLayout, @NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout2, @NonNull GuildRoundBoardImageView guildRoundBoardImageView, @NonNull TextView textView2, @NonNull RelativeLayout relativeLayout3, @NonNull ImageView imageView, @NonNull TextView textView3) {
        this.f446912a = relativeLayout;
        this.f446913b = frameLayout;
        this.f446914c = textView;
        this.f446915d = relativeLayout2;
        this.f446916e = guildRoundBoardImageView;
        this.f446917f = textView2;
        this.f446918g = relativeLayout3;
        this.f446919h = imageView;
        this.f446920i = textView3;
    }

    @NonNull
    public static e e(@NonNull View view) {
        int i3 = R.id.v1m;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.v1m);
        if (frameLayout != null) {
            i3 = R.id.f165359vo0;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f165359vo0);
            if (textView != null) {
                i3 = R.id.yh5;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.yh5);
                if (relativeLayout != null) {
                    i3 = R.id.f247509z;
                    GuildRoundBoardImageView guildRoundBoardImageView = (GuildRoundBoardImageView) ViewBindings.findChildViewById(view, R.id.f247509z);
                    if (guildRoundBoardImageView != null) {
                        i3 = R.id.f26770ef;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f26770ef);
                        if (textView2 != null) {
                            i3 = R.id.f74803x9;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f74803x9);
                            if (relativeLayout2 != null) {
                                i3 = R.id.kro;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.kro);
                                if (imageView != null) {
                                    i3 = R.id.f1196477e;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f1196477e);
                                    if (textView3 != null) {
                                        return new e((RelativeLayout) view, frameLayout, textView, relativeLayout, guildRoundBoardImageView, textView2, relativeLayout2, imageView, textView3);
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
    public static e g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.epr, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f446912a;
    }
}
