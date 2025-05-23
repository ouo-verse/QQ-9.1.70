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
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.GuildSettingMuteAllItemLayout;
import com.tencent.mobileqq.guild.widget.GuildSettingNavigateMoreLayoutToken;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.widget.Switch;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class aj implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final NestedScrollView f442221a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final GuildUserAvatarView f442222b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final Switch f442223c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442224d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442225e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442226f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f442227g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f442228h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ImageView f442229i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final GuildSettingNavigateMoreLayoutToken f442230j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f442231k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final GuildSettingMuteAllItemLayout f442232l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442233m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final TextView f442234n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final Button f442235o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final Button f442236p;

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    public final TextView f442237q;

    /* renamed from: r, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442238r;

    aj(@NonNull NestedScrollView nestedScrollView, @NonNull GuildUserAvatarView guildUserAvatarView, @NonNull Switch r56, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull GuildSettingNavigateMoreLayoutToken guildSettingNavigateMoreLayoutToken, @NonNull TextView textView, @NonNull GuildSettingMuteAllItemLayout guildSettingMuteAllItemLayout, @NonNull LinearLayout linearLayout4, @NonNull TextView textView2, @NonNull Button button, @NonNull Button button2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout5) {
        this.f442221a = nestedScrollView;
        this.f442222b = guildUserAvatarView;
        this.f442223c = r56;
        this.f442224d = linearLayout;
        this.f442225e = linearLayout2;
        this.f442226f = linearLayout3;
        this.f442227g = imageView;
        this.f442228h = imageView2;
        this.f442229i = imageView3;
        this.f442230j = guildSettingNavigateMoreLayoutToken;
        this.f442231k = textView;
        this.f442232l = guildSettingMuteAllItemLayout;
        this.f442233m = linearLayout4;
        this.f442234n = textView2;
        this.f442235o = button;
        this.f442236p = button2;
        this.f442237q = textView3;
        this.f442238r = linearLayout5;
    }

    @NonNull
    public static aj e(@NonNull View view) {
        int i3 = R.id.a38;
        GuildUserAvatarView guildUserAvatarView = (GuildUserAvatarView) ViewBindings.findChildViewById(view, R.id.a38);
        if (guildUserAvatarView != null) {
            i3 = R.id.t8z;
            Switch r65 = (Switch) ViewBindings.findChildViewById(view, R.id.t8z);
            if (r65 != null) {
                i3 = R.id.f164867u30;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f164867u30);
                if (linearLayout != null) {
                    i3 = R.id.b8q;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.b8q);
                    if (linearLayout2 != null) {
                        i3 = R.id.w4d;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.w4d);
                        if (linearLayout3 != null) {
                            i3 = R.id.w4h;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.w4h);
                            if (imageView != null) {
                                i3 = R.id.wkt;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.wkt);
                                if (imageView2 != null) {
                                    i3 = R.id.wrs;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.wrs);
                                    if (imageView3 != null) {
                                        i3 = R.id.ws5;
                                        GuildSettingNavigateMoreLayoutToken guildSettingNavigateMoreLayoutToken = (GuildSettingNavigateMoreLayoutToken) ViewBindings.findChildViewById(view, R.id.ws5);
                                        if (guildSettingNavigateMoreLayoutToken != null) {
                                            i3 = R.id.x3d;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.x3d);
                                            if (textView != null) {
                                                i3 = R.id.x4g;
                                                GuildSettingMuteAllItemLayout guildSettingMuteAllItemLayout = (GuildSettingMuteAllItemLayout) ViewBindings.findChildViewById(view, R.id.x4g);
                                                if (guildSettingMuteAllItemLayout != null) {
                                                    i3 = R.id.yam;
                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.yam);
                                                    if (linearLayout4 != null) {
                                                        i3 = R.id.f5q;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f5q);
                                                        if (textView2 != null) {
                                                            i3 = R.id.f28020ht;
                                                            Button button = (Button) ViewBindings.findChildViewById(view, R.id.f28020ht);
                                                            if (button != null) {
                                                                i3 = R.id.f29310la;
                                                                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.f29310la);
                                                                if (button2 != null) {
                                                                    i3 = R.id.f29320lb;
                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f29320lb);
                                                                    if (textView3 != null) {
                                                                        i3 = R.id.f114946up;
                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f114946up);
                                                                        if (linearLayout5 != null) {
                                                                            return new aj((NestedScrollView) view, guildUserAvatarView, r65, linearLayout, linearLayout2, linearLayout3, imageView, imageView2, imageView3, guildSettingNavigateMoreLayoutToken, textView, guildSettingMuteAllItemLayout, linearLayout4, textView2, button, button2, textView3, linearLayout5);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static aj g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ekj, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f442221a;
    }
}
