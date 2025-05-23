package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.main.topchannel.widget.ChannelStatusView;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class cv implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f442809a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442810b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ChannelStatusView f442811c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RoundImageView f442812d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f442813e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f442814f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f442815g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f442816h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442817i;

    cv(@NonNull View view, @NonNull RelativeLayout relativeLayout, @NonNull ChannelStatusView channelStatusView, @NonNull RoundImageView roundImageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull LinearLayout linearLayout) {
        this.f442809a = view;
        this.f442810b = relativeLayout;
        this.f442811c = channelStatusView;
        this.f442812d = roundImageView;
        this.f442813e = textView;
        this.f442814f = textView2;
        this.f442815g = textView3;
        this.f442816h = textView4;
        this.f442817i = linearLayout;
    }

    @NonNull
    public static cv e(@NonNull View view) {
        int i3 = R.id.b8q;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.b8q);
        if (relativeLayout != null) {
            i3 = R.id.wky;
            ChannelStatusView channelStatusView = (ChannelStatusView) ViewBindings.findChildViewById(view, R.id.wky);
            if (channelStatusView != null) {
                i3 = R.id.wkz;
                RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.wkz);
                if (roundImageView != null) {
                    i3 = R.id.f165545wl0;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f165545wl0);
                    if (textView != null) {
                        i3 = R.id.f165546wl1;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f165546wl1);
                        if (textView2 != null) {
                            i3 = R.id.f165547wl2;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f165547wl2);
                            if (textView3 != null) {
                                i3 = R.id.wrw;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.wrw);
                                if (textView4 != null) {
                                    i3 = R.id.jbb;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.jbb);
                                    if (linearLayout != null) {
                                        return new cv(view, relativeLayout, channelStatusView, roundImageView, textView, textView2, textView3, textView4, linearLayout);
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
    public static cv f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.f2p, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f442809a;
    }
}
