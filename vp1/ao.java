package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.guild.discovery.widget.GDiscoveryLoadingView;
import com.tx.x2j.GuildDiscoveryMineLoadingAndExceptionViewBinding;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class ao implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f442265a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final GDiscoveryLoadingView f442266b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442267c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ScanningLightView f442268d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442269e;

    ao(@NonNull FrameLayout frameLayout, @NonNull GDiscoveryLoadingView gDiscoveryLoadingView, @NonNull FrameLayout frameLayout2, @NonNull ScanningLightView scanningLightView, @NonNull FrameLayout frameLayout3) {
        this.f442265a = frameLayout;
        this.f442266b = gDiscoveryLoadingView;
        this.f442267c = frameLayout2;
        this.f442268d = scanningLightView;
        this.f442269e = frameLayout3;
    }

    @NonNull
    public static ao e(@NonNull View view) {
        int i3 = R.id.w4z;
        GDiscoveryLoadingView gDiscoveryLoadingView = (GDiscoveryLoadingView) ViewBindings.findChildViewById(view, R.id.w4z);
        if (gDiscoveryLoadingView != null) {
            i3 = R.id.w5e;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.w5e);
            if (frameLayout != null) {
                i3 = R.id.wxn;
                ScanningLightView scanningLightView = (ScanningLightView) ViewBindings.findChildViewById(view, R.id.wxn);
                if (scanningLightView != null) {
                    FrameLayout frameLayout2 = (FrameLayout) view;
                    return new ao(frameLayout2, gDiscoveryLoadingView, frameLayout, scanningLightView, frameLayout2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ao g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        GuildDiscoveryMineLoadingAndExceptionViewBinding guildDiscoveryMineLoadingAndExceptionViewBinding = new GuildDiscoveryMineLoadingAndExceptionViewBinding();
        guildDiscoveryMineLoadingAndExceptionViewBinding.t(layoutInflater, viewGroup, z16);
        View u16 = guildDiscoveryMineLoadingAndExceptionViewBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.f168060el2, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f442265a;
    }
}
