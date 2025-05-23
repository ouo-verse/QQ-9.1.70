package vn0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class t implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442026a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442027b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f442028c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final GuildUserAvatarView f442029d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f442030e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f442031f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442032g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442033h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f442034i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f442035j;

    t(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull View view, @NonNull GuildUserAvatarView guildUserAvatarView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f442026a = linearLayout;
        this.f442027b = linearLayout2;
        this.f442028c = view;
        this.f442029d = guildUserAvatarView;
        this.f442030e = textView;
        this.f442031f = textView2;
        this.f442032g = linearLayout3;
        this.f442033h = linearLayout4;
        this.f442034i = textView3;
        this.f442035j = textView4;
    }

    @NonNull
    public static t e(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i3 = R.id.f165441w10;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.f165441w10);
        if (findChildViewById != null) {
            i3 = R.id.f165653x53;
            GuildUserAvatarView guildUserAvatarView = (GuildUserAvatarView) ViewBindings.findChildViewById(view, R.id.f165653x53);
            if (guildUserAvatarView != null) {
                i3 = R.id.x55;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.x55);
                if (textView != null) {
                    i3 = R.id.x56;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.x56);
                    if (textView2 != null) {
                        i3 = R.id.yog;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.yog);
                        if (linearLayout2 != null) {
                            i3 = R.id.yoh;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.yoh);
                            if (linearLayout3 != null) {
                                i3 = R.id.f108406d1;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f108406d1);
                                if (textView3 != null) {
                                    i3 = R.id.f108416d2;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f108416d2);
                                    if (textView4 != null) {
                                        return new t(linearLayout, linearLayout, findChildViewById, guildUserAvatarView, textView, textView2, linearLayout2, linearLayout3, textView3, textView4);
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
    public static t g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static t h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eki, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442026a;
    }
}
