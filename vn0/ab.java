package vn0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.component.qrcode.QUIColorfulQRCodeView;
import com.tencent.mobileqq.guild.widget.qqui.RoundRectImageView;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class ab implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f441905a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final QUIColorfulQRCodeView f441906b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RoundRectImageView f441907c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f441908d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinearLayout f441909e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f441910f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayout f441911g;

    ab(@NonNull LinearLayout linearLayout, @NonNull QUIColorfulQRCodeView qUIColorfulQRCodeView, @NonNull RoundRectImageView roundRectImageView, @NonNull AppCompatTextView appCompatTextView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull LinearLayout linearLayout3) {
        this.f441905a = linearLayout;
        this.f441906b = qUIColorfulQRCodeView;
        this.f441907c = roundRectImageView;
        this.f441908d = appCompatTextView;
        this.f441909e = linearLayout2;
        this.f441910f = textView;
        this.f441911g = linearLayout3;
    }

    @NonNull
    public static ab e(@NonNull View view) {
        int i3 = R.id.s5w;
        QUIColorfulQRCodeView qUIColorfulQRCodeView = (QUIColorfulQRCodeView) ViewBindings.findChildViewById(view, R.id.s5w);
        if (qUIColorfulQRCodeView != null) {
            i3 = R.id.f164769ts2;
            RoundRectImageView roundRectImageView = (RoundRectImageView) ViewBindings.findChildViewById(view, R.id.f164769ts2);
            if (roundRectImageView != null) {
                i3 = R.id.ato;
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, R.id.ato);
                if (appCompatTextView != null) {
                    i3 = R.id.wjk;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.wjk);
                    if (linearLayout != null) {
                        i3 = R.id.yz7;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.yz7);
                        if (textView != null) {
                            i3 = R.id.f95195eb;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f95195eb);
                            if (linearLayout2 != null) {
                                return new ab((LinearLayout) view, qUIColorfulQRCodeView, roundRectImageView, appCompatTextView, linearLayout, textView, linearLayout2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ab g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f8t, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f441905a;
    }
}
