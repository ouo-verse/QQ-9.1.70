package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tx.x2j.GuildSettingMemberLayoutBinding;

/* compiled from: P */
/* renamed from: vp1.do, reason: invalid class name */
/* loaded from: classes13.dex */
public final class Cdo implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442958a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f442959b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442960c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RecyclerView f442961d;

    Cdo(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull RecyclerView recyclerView) {
        this.f442958a = linearLayout;
        this.f442959b = textView;
        this.f442960c = linearLayout2;
        this.f442961d = recyclerView;
    }

    @NonNull
    public static Cdo e(@NonNull View view) {
        int i3 = R.id.wqp;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.wqp);
        if (textView != null) {
            i3 = R.id.wqq;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.wqq);
            if (linearLayout != null) {
                i3 = R.id.wqw;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.wqw);
                if (recyclerView != null) {
                    return new Cdo((LinearLayout) view, textView, linearLayout, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static Cdo g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        GuildSettingMemberLayoutBinding guildSettingMemberLayoutBinding = new GuildSettingMemberLayoutBinding();
        guildSettingMemberLayoutBinding.t(layoutInflater, viewGroup, z16);
        View u16 = guildSettingMemberLayoutBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.f8i, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442958a;
    }
}
