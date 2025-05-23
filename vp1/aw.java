package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.view.FormSwitchWithSubTitle;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.view.WheelViewWrapper;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class aw implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f442328a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FormSwitchWithSubTitle f442329b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final WheelViewWrapper f442330c;

    aw(@NonNull View view, @NonNull FormSwitchWithSubTitle formSwitchWithSubTitle, @NonNull WheelViewWrapper wheelViewWrapper) {
        this.f442328a = view;
        this.f442329b = formSwitchWithSubTitle;
        this.f442330c = wheelViewWrapper;
    }

    @NonNull
    public static aw e(@NonNull View view) {
        int i3 = R.id.f165976ya1;
        FormSwitchWithSubTitle formSwitchWithSubTitle = (FormSwitchWithSubTitle) ViewBindings.findChildViewById(view, R.id.f165976ya1);
        if (formSwitchWithSubTitle != null) {
            i3 = R.id.f165977ya2;
            WheelViewWrapper wheelViewWrapper = (WheelViewWrapper) ViewBindings.findChildViewById(view, R.id.f165977ya2);
            if (wheelViewWrapper != null) {
                return new aw(view, formSwitchWithSubTitle, wheelViewWrapper);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static aw f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.f168094es1, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f442328a;
    }
}
