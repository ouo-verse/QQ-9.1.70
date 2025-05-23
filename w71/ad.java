package w71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.edit.AIOEditText;
import com.tencent.widget.PatchedButton;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class ad implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f444725a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f444726b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final AIOEditText f444727c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final PatchedButton f444728d;

    ad(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull AIOEditText aIOEditText, @NonNull PatchedButton patchedButton) {
        this.f444725a = linearLayout;
        this.f444726b = imageView;
        this.f444727c = aIOEditText;
        this.f444728d = patchedButton;
    }

    @NonNull
    public static ad e(@NonNull View view) {
        int i3 = R.id.emo_btn;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.emo_btn);
        if (imageView != null) {
            i3 = R.id.input;
            AIOEditText aIOEditText = (AIOEditText) ViewBindings.findChildViewById(view, R.id.input);
            if (aIOEditText != null) {
                i3 = R.id.send_btn;
                PatchedButton patchedButton = (PatchedButton) ViewBindings.findChildViewById(view, R.id.send_btn);
                if (patchedButton != null) {
                    return new ad((LinearLayout) view, imageView, aIOEditText, patchedButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ad g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static ad h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.fjr, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f444725a;
    }
}
