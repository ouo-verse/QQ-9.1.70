package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tx.x2j.GuildHomeSpaceCardLayoutBinding;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class bk implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f442500a;

    bk(@NonNull ConstraintLayout constraintLayout) {
        this.f442500a = constraintLayout;
    }

    @NonNull
    public static bk e(@NonNull View view) {
        if (view != null) {
            return new bk((ConstraintLayout) view);
        }
        throw new NullPointerException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
    }

    @NonNull
    public static bk g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        GuildHomeSpaceCardLayoutBinding guildHomeSpaceCardLayoutBinding = new GuildHomeSpaceCardLayoutBinding();
        guildHomeSpaceCardLayoutBinding.t(layoutInflater, viewGroup, z16);
        View u16 = guildHomeSpaceCardLayoutBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.etz, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f442500a;
    }
}
