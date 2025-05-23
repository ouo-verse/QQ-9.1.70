package x12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.video.GuildFeedListBaseVideoView;
import com.tencent.mobileqq.guild.media.widget.RoundCornerLayout;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class t implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f447011a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f447012b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RoundCornerLayout f447013c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f447014d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f447015e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f447016f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final FrameLayout f447017g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f447018h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final GuildFeedListBaseVideoView f447019i;

    t(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull RoundCornerLayout roundCornerLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView3, @NonNull GuildFeedListBaseVideoView guildFeedListBaseVideoView) {
        this.f447011a = constraintLayout;
        this.f447012b = constraintLayout2;
        this.f447013c = roundCornerLayout;
        this.f447014d = imageView;
        this.f447015e = imageView2;
        this.f447016f = textView;
        this.f447017g = frameLayout;
        this.f447018h = imageView3;
        this.f447019i = guildFeedListBaseVideoView;
    }

    @NonNull
    public static t e(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i3 = R.id.wb_;
        RoundCornerLayout roundCornerLayout = (RoundCornerLayout) ViewBindings.findChildViewById(view, R.id.wb_);
        if (roundCornerLayout != null) {
            i3 = R.id.wbk;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.wbk);
            if (imageView != null) {
                i3 = R.id.wbl;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.wbl);
                if (imageView2 != null) {
                    i3 = R.id.wbm;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.wbm);
                    if (textView != null) {
                        i3 = R.id.wfk;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.wfk);
                        if (frameLayout != null) {
                            i3 = R.id.wfl;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.wfl);
                            if (imageView3 != null) {
                                i3 = R.id.x4k;
                                GuildFeedListBaseVideoView guildFeedListBaseVideoView = (GuildFeedListBaseVideoView) ViewBindings.findChildViewById(view, R.id.x4k);
                                if (guildFeedListBaseVideoView != null) {
                                    return new t(constraintLayout, constraintLayout, roundCornerLayout, imageView, imageView2, textView, frameLayout, imageView3, guildFeedListBaseVideoView);
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
    public static t g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.exe, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f447011a;
    }
}
