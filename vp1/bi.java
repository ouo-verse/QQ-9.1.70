package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.home.views.widget.GuildHomeHeaderGroupChatLayout;
import com.tencent.mobileqq.guild.main.view.GuildSummaryView;
import com.tencent.mobileqq.guild.mainframe.view.GuildDragTextView;
import com.tencent.mobileqq.guild.widget.RadiusConstraintLayout;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class bi implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final GuildHomeHeaderGroupChatLayout f442478a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442479b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f442480c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f442481d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final GuildHomeHeaderGroupChatLayout f442482e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442483f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final View f442484g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final RadiusConstraintLayout f442485h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ImageView f442486i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f442487j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f442488k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final GuildDragTextView f442489l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f442490m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final GuildSummaryView f442491n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final GuildDragTextView f442492o;

    bi(@NonNull GuildHomeHeaderGroupChatLayout guildHomeHeaderGroupChatLayout, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull GuildHomeHeaderGroupChatLayout guildHomeHeaderGroupChatLayout2, @NonNull FrameLayout frameLayout, @NonNull View view, @NonNull RadiusConstraintLayout radiusConstraintLayout, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull GuildDragTextView guildDragTextView, @NonNull TextView textView4, @NonNull GuildSummaryView guildSummaryView, @NonNull GuildDragTextView guildDragTextView2) {
        this.f442478a = guildHomeHeaderGroupChatLayout;
        this.f442479b = linearLayout;
        this.f442480c = imageView;
        this.f442481d = textView;
        this.f442482e = guildHomeHeaderGroupChatLayout2;
        this.f442483f = frameLayout;
        this.f442484g = view;
        this.f442485h = radiusConstraintLayout;
        this.f442486i = imageView2;
        this.f442487j = textView2;
        this.f442488k = textView3;
        this.f442489l = guildDragTextView;
        this.f442490m = textView4;
        this.f442491n = guildSummaryView;
        this.f442492o = guildDragTextView2;
    }

    @NonNull
    public static bi e(@NonNull View view) {
        int i3 = R.id.acl;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.acl);
        if (linearLayout != null) {
            i3 = R.id.trz;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.trz);
            if (imageView != null) {
                i3 = R.id.ato;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ato);
                if (textView != null) {
                    GuildHomeHeaderGroupChatLayout guildHomeHeaderGroupChatLayout = (GuildHomeHeaderGroupChatLayout) view;
                    i3 = R.id.x8f;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.x8f);
                    if (frameLayout != null) {
                        i3 = R.id.x8g;
                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.x8g);
                        if (findChildViewById != null) {
                            i3 = R.id.x8h;
                            RadiusConstraintLayout radiusConstraintLayout = (RadiusConstraintLayout) ViewBindings.findChildViewById(view, R.id.x8h);
                            if (radiusConstraintLayout != null) {
                                i3 = R.id.x8i;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.x8i);
                                if (imageView2 != null) {
                                    i3 = R.id.x8j;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.x8j);
                                    if (textView2 != null) {
                                        i3 = R.id.x8k;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.x8k);
                                        if (textView3 != null) {
                                            i3 = R.id.x8l;
                                            GuildDragTextView guildDragTextView = (GuildDragTextView) ViewBindings.findChildViewById(view, R.id.x8l);
                                            if (guildDragTextView != null) {
                                                i3 = R.id.ycw;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.ycw);
                                                if (textView4 != null) {
                                                    i3 = R.id.j8_;
                                                    GuildSummaryView guildSummaryView = (GuildSummaryView) ViewBindings.findChildViewById(view, R.id.j8_);
                                                    if (guildSummaryView != null) {
                                                        i3 = R.id.f114296sy;
                                                        GuildDragTextView guildDragTextView2 = (GuildDragTextView) ViewBindings.findChildViewById(view, R.id.f114296sy);
                                                        if (guildDragTextView2 != null) {
                                                            return new bi(guildHomeHeaderGroupChatLayout, linearLayout, imageView, textView, guildHomeHeaderGroupChatLayout, frameLayout, findChildViewById, radiusConstraintLayout, imageView2, textView2, textView3, guildDragTextView, textView4, guildSummaryView, guildDragTextView2);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static bi g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.etp, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public GuildHomeHeaderGroupChatLayout getRoot() {
        return this.f442478a;
    }
}
