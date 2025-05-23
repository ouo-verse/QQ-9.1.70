package rw3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqnt.videoplay.api.view.SimpleVideoView;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f432633a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f432634b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f432635c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f432636d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f432637e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final SimpleVideoView f432638f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f432639g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f432640h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f432641i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final SimpleVideoView f432642j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f432643k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final LinearLayout f432644l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final Button f432645m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final Button f432646n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final LinearLayout f432647o;

    a(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull TextView textView3, @NonNull SimpleVideoView simpleVideoView, @NonNull TextView textView4, @NonNull ImageView imageView2, @NonNull TextView textView5, @NonNull SimpleVideoView simpleVideoView2, @NonNull TextView textView6, @NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull Button button2, @NonNull LinearLayout linearLayout2) {
        this.f432633a = constraintLayout;
        this.f432634b = textView;
        this.f432635c = textView2;
        this.f432636d = imageView;
        this.f432637e = textView3;
        this.f432638f = simpleVideoView;
        this.f432639g = textView4;
        this.f432640h = imageView2;
        this.f432641i = textView5;
        this.f432642j = simpleVideoView2;
        this.f432643k = textView6;
        this.f432644l = linearLayout;
        this.f432645m = button;
        this.f432646n = button2;
        this.f432647o = linearLayout2;
    }

    @NonNull
    public static a e(@NonNull View view) {
        int i3 = R.id.u36;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.u36);
        if (textView != null) {
            i3 = R.id.u37;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.u37);
            if (textView2 != null) {
                i3 = R.id.u38;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.u38);
                if (imageView != null) {
                    i3 = R.id.u39;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.u39);
                    if (textView3 != null) {
                        i3 = R.id.u3_;
                        SimpleVideoView simpleVideoView = (SimpleVideoView) ViewBindings.findChildViewById(view, R.id.u3_);
                        if (simpleVideoView != null) {
                            i3 = R.id.u3a;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.u3a);
                            if (textView4 != null) {
                                i3 = R.id.f2151018;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f2151018);
                                if (imageView2 != null) {
                                    i3 = R.id.f2152019;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.f2152019);
                                    if (textView5 != null) {
                                        i3 = R.id.f215301_;
                                        SimpleVideoView simpleVideoView2 = (SimpleVideoView) ViewBindings.findChildViewById(view, R.id.f215301_);
                                        if (simpleVideoView2 != null) {
                                            i3 = R.id.f215401a;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.f215401a);
                                            if (textView6 != null) {
                                                i3 = R.id.f247409y;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f247409y);
                                                if (linearLayout != null) {
                                                    i3 = R.id.f87944vq;
                                                    Button button = (Button) ViewBindings.findChildViewById(view, R.id.f87944vq);
                                                    if (button != null) {
                                                        i3 = R.id.f87954vr;
                                                        Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.f87954vr);
                                                        if (button2 != null) {
                                                            i3 = R.id.f167092kq3;
                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f167092kq3);
                                                            if (linearLayout2 != null) {
                                                                return new a((ConstraintLayout) view, textView, textView2, imageView, textView3, simpleVideoView, textView4, imageView2, textView5, simpleVideoView2, textView6, linearLayout, button, button2, linearLayout2);
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
    public static a g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static a h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dqm, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f432633a;
    }
}
