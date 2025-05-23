package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tx.x2j.GuildSettingHeadInfoLayoutBinding;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class dl implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f442933a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f442934b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RadiusFrameLayout f442935c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f442936d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f442937e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f442938f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f442939g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f442940h;

    dl(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull RadiusFrameLayout radiusFrameLayout, @NonNull ImageView imageView2, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull ImageView imageView3, @NonNull TextView textView2) {
        this.f442933a = constraintLayout;
        this.f442934b = imageView;
        this.f442935c = radiusFrameLayout;
        this.f442936d = imageView2;
        this.f442937e = constraintLayout2;
        this.f442938f = textView;
        this.f442939g = imageView3;
        this.f442940h = textView2;
    }

    @NonNull
    public static dl e(@NonNull View view) {
        int i3 = R.id.wij;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.wij);
        if (imageView != null) {
            i3 = R.id.wik;
            RadiusFrameLayout radiusFrameLayout = (RadiusFrameLayout) ViewBindings.findChildViewById(view, R.id.wik);
            if (radiusFrameLayout != null) {
                i3 = R.id.wjh;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.wjh);
                if (imageView2 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i3 = R.id.wrw;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.wrw);
                    if (textView != null) {
                        i3 = R.id.wut;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.wut);
                        if (imageView3 != null) {
                            i3 = R.id.x1h;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.x1h);
                            if (textView2 != null) {
                                return new dl(constraintLayout, imageView, radiusFrameLayout, imageView2, constraintLayout, textView, imageView3, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static dl g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        GuildSettingHeadInfoLayoutBinding guildSettingHeadInfoLayoutBinding = new GuildSettingHeadInfoLayoutBinding();
        guildSettingHeadInfoLayoutBinding.t(layoutInflater, viewGroup, z16);
        View u16 = guildSettingHeadInfoLayoutBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.f8f, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f442933a;
    }
}
