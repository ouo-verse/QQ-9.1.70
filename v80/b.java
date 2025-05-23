package v80;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class b<T> extends RecyclerView.ViewHolder {
    protected T E;
    protected int F;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(@NonNull View view) {
        super(view);
    }

    public final void l(T t16, int i3) {
        this.E = t16;
        this.F = i3;
        m(t16, i3);
    }

    protected abstract void m(T t16, int i3);
}
