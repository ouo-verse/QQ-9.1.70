package z12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.guild.aio.msglist.holder.template.BubbleLayoutCompatPress;
import com.tencent.guildlive.widget.GuildLiveMsgItemRelativeLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class g implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final GuildLiveMsgItemRelativeLayout f451762a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f451763b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f451764c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f451765d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final BubbleLayoutCompatPress f451766e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f451767f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayout f451768g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayout f451769h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f451770i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final LinearLayout f451771j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f451772k;

    g(@NonNull GuildLiveMsgItemRelativeLayout guildLiveMsgItemRelativeLayout, @NonNull RelativeLayout relativeLayout, @NonNull View view, @NonNull FrameLayout frameLayout, @NonNull BubbleLayoutCompatPress bubbleLayoutCompatPress, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull LinearLayout linearLayout5, @NonNull TextView textView) {
        this.f451762a = guildLiveMsgItemRelativeLayout;
        this.f451763b = relativeLayout;
        this.f451764c = view;
        this.f451765d = frameLayout;
        this.f451766e = bubbleLayoutCompatPress;
        this.f451767f = linearLayout;
        this.f451768g = linearLayout2;
        this.f451769h = linearLayout3;
        this.f451770i = linearLayout4;
        this.f451771j = linearLayout5;
        this.f451772k = textView;
    }

    @NonNull
    public static g e(@NonNull View view) {
        int i3 = R.id.b9t;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.b9t);
        if (relativeLayout != null) {
            i3 = R.id.wri;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.wri);
            if (findChildViewById != null) {
                i3 = R.id.zfr;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.zfr);
                if (frameLayout != null) {
                    i3 = R.id.zfv;
                    BubbleLayoutCompatPress bubbleLayoutCompatPress = (BubbleLayoutCompatPress) ViewBindings.findChildViewById(view, R.id.zfv);
                    if (bubbleLayoutCompatPress != null) {
                        i3 = R.id.zg7;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.zg7);
                        if (linearLayout != null) {
                            i3 = R.id.zg8;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.zg8);
                            if (linearLayout2 != null) {
                                i3 = R.id.zgk;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.zgk);
                                if (linearLayout3 != null) {
                                    i3 = R.id.zgm;
                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.zgm);
                                    if (linearLayout4 != null) {
                                        i3 = R.id.zgs;
                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.zgs);
                                        if (linearLayout5 != null) {
                                            i3 = R.id.f73133sq;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f73133sq);
                                            if (textView != null) {
                                                return new g((GuildLiveMsgItemRelativeLayout) view, relativeLayout, findChildViewById, frameLayout, bubbleLayoutCompatPress, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, textView);
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
    public static g g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ewk, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public GuildLiveMsgItemRelativeLayout getRoot() {
        return this.f451762a;
    }
}
