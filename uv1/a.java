package uv1;

import android.widget.CompoundButton;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Luv1/a;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "", "isChecked", "", "a", "Landroid/widget/CompoundButton;", "buttonView", "onCheckedChanged", "Lcom/tencent/widget/Switch;", "d", "Lcom/tencent/widget/Switch;", "getSwitchView", "()Lcom/tencent/widget/Switch;", "switchView", "e", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "getCheckChangedListener", "()Landroid/widget/CompoundButton$OnCheckedChangeListener;", "checkChangedListener", "f", "Z", "getNeedNotify", "()Z", "setNeedNotify", "(Z)V", "needNotify", "<init>", "(Lcom/tencent/widget/Switch;Landroid/widget/CompoundButton$OnCheckedChangeListener;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Switch switchView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CompoundButton.OnCheckedChangeListener checkChangedListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean needNotify;

    public a(@NotNull Switch switchView, @NotNull CompoundButton.OnCheckedChangeListener checkChangedListener) {
        Intrinsics.checkNotNullParameter(switchView, "switchView");
        Intrinsics.checkNotNullParameter(checkChangedListener, "checkChangedListener");
        this.switchView = switchView;
        this.checkChangedListener = checkChangedListener;
        this.needNotify = true;
        switchView.setOnCheckedChangeListener(this);
    }

    public final void a(boolean isChecked) {
        if (isChecked == this.switchView.isChecked()) {
            return;
        }
        this.needNotify = false;
        this.switchView.setChecked(isChecked);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(@Nullable CompoundButton buttonView, boolean isChecked) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(buttonView, isChecked);
        if (!this.needNotify) {
            this.needNotify = true;
        } else {
            this.checkChangedListener.onCheckedChanged(buttonView, isChecked);
        }
        EventCollector.getInstance().onCompoundButtonChecked(buttonView, isChecked);
    }
}
