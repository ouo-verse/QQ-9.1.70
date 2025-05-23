package x12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildFeedSquareTabBarV2;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class q implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f446990a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f446991b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final GuildFeedSquareTabBarV2 f446992c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f446993d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final FrameLayout f446994e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f446995f;

    q(@NonNull FrameLayout frameLayout, @NonNull View view, @NonNull GuildFeedSquareTabBarV2 guildFeedSquareTabBarV2, @NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout2, @NonNull ImageView imageView) {
        this.f446990a = frameLayout;
        this.f446991b = view;
        this.f446992c = guildFeedSquareTabBarV2;
        this.f446993d = linearLayout;
        this.f446994e = frameLayout2;
        this.f446995f = imageView;
    }

    @NonNull
    public static q e(@NonNull View view) {
        int i3 = R.id.f165386vs0;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.f165386vs0);
        if (findChildViewById != null) {
            i3 = R.id.wcl;
            GuildFeedSquareTabBarV2 guildFeedSquareTabBarV2 = (GuildFeedSquareTabBarV2) ViewBindings.findChildViewById(view, R.id.wcl);
            if (guildFeedSquareTabBarV2 != null) {
                i3 = R.id.f74553wk;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f74553wk);
                if (linearLayout != null) {
                    i3 = R.id.f83724kb;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f83724kb);
                    if (frameLayout != null) {
                        i3 = R.id.f83754ke;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f83754ke);
                        if (imageView != null) {
                            return new q((FrameLayout) view, findChildViewById, guildFeedSquareTabBarV2, linearLayout, frameLayout, imageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static q g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.erc, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f446990a;
    }
}
