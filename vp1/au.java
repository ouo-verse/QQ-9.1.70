package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tx.x2j.GuildFeedTopCardMessageItemBinding;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class au implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442313a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442314b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f442315c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ViewStub f442316d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ViewStub f442317e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ViewStub f442318f;

    au(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull ViewStub viewStub, @NonNull ViewStub viewStub2, @NonNull ViewStub viewStub3) {
        this.f442313a = linearLayout;
        this.f442314b = linearLayout2;
        this.f442315c = textView;
        this.f442316d = viewStub;
        this.f442317e = viewStub2;
        this.f442318f = viewStub3;
    }

    @NonNull
    public static au e(@NonNull View view) {
        int i3 = R.id.v3n;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.v3n);
        if (linearLayout != null) {
            i3 = R.id.v3o;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.v3o);
            if (textView != null) {
                i3 = R.id.v3q;
                ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, R.id.v3q);
                if (viewStub != null) {
                    i3 = R.id.v3r;
                    ViewStub viewStub2 = (ViewStub) ViewBindings.findChildViewById(view, R.id.v3r);
                    if (viewStub2 != null) {
                        i3 = R.id.v3s;
                        ViewStub viewStub3 = (ViewStub) ViewBindings.findChildViewById(view, R.id.v3s);
                        if (viewStub3 != null) {
                            return new au((LinearLayout) view, linearLayout, textView, viewStub, viewStub2, viewStub3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static au g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        GuildFeedTopCardMessageItemBinding guildFeedTopCardMessageItemBinding = new GuildFeedTopCardMessageItemBinding();
        guildFeedTopCardMessageItemBinding.t(layoutInflater, viewGroup, z16);
        View u16 = guildFeedTopCardMessageItemBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.erj, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442313a;
    }
}
