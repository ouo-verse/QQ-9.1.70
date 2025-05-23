package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class az implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f442360a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final GuildUserAvatarView f442361b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f442362c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final View f442363d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f442364e;

    az(@NonNull View view, @NonNull GuildUserAvatarView guildUserAvatarView, @NonNull View view2, @NonNull View view3, @NonNull ImageView imageView) {
        this.f442360a = view;
        this.f442361b = guildUserAvatarView;
        this.f442362c = view2;
        this.f442363d = view3;
        this.f442364e = imageView;
    }

    @NonNull
    public static az e(@NonNull View view) {
        int i3 = R.id.f163955sa3;
        GuildUserAvatarView guildUserAvatarView = (GuildUserAvatarView) ViewBindings.findChildViewById(view, R.id.f163955sa3);
        if (guildUserAvatarView != null) {
            i3 = R.id.f163956sa4;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.f163956sa4);
            if (findChildViewById != null) {
                i3 = R.id.sa5;
                View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.sa5);
                if (findChildViewById2 != null) {
                    i3 = R.id.trs;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.trs);
                    if (imageView != null) {
                        return new az(view, guildUserAvatarView, findChildViewById, findChildViewById2, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static az f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.etd, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f442360a;
    }
}
