package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.homev2.parts.title.view.GuildHomeV2CoverTopCenterCropImageView;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class bl implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f442501a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final GuildHomeV2CoverTopCenterCropImageView f442502b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442503c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f442504d;

    bl(@NonNull FrameLayout frameLayout, @NonNull GuildHomeV2CoverTopCenterCropImageView guildHomeV2CoverTopCenterCropImageView, @NonNull FrameLayout frameLayout2, @NonNull ImageView imageView) {
        this.f442501a = frameLayout;
        this.f442502b = guildHomeV2CoverTopCenterCropImageView;
        this.f442503c = frameLayout2;
        this.f442504d = imageView;
    }

    @NonNull
    public static bl e(@NonNull View view) {
        int i3 = R.id.f165453w30;
        GuildHomeV2CoverTopCenterCropImageView guildHomeV2CoverTopCenterCropImageView = (GuildHomeV2CoverTopCenterCropImageView) ViewBindings.findChildViewById(view, R.id.f165453w30);
        if (guildHomeV2CoverTopCenterCropImageView != null) {
            i3 = R.id.f165454w31;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f165454w31);
            if (frameLayout != null) {
                i3 = R.id.f165458w35;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f165458w35);
                if (imageView != null) {
                    return new bl((FrameLayout) view, guildHomeV2CoverTopCenterCropImageView, frameLayout, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static bl g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eu8, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f442501a;
    }
}
