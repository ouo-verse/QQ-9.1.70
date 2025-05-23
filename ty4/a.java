package ty4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes27.dex */
public class a extends LayoutInflater {

    /* renamed from: a, reason: collision with root package name */
    private c f437917a;

    public a(Context context, c cVar) {
        super(context);
        this.f437917a = cVar;
    }

    @Override // android.view.LayoutInflater
    public LayoutInflater cloneInContext(Context context) {
        return new a(this, context);
    }

    @Override // android.view.LayoutInflater
    public View inflate(int i3, @Nullable ViewGroup viewGroup, boolean z16) {
        d.b("ViewStubLayoutInflater mTargetBinding=" + this.f437917a.getClass().getName());
        return b.d(i3, getContext(), viewGroup, z16, this.f437917a);
    }

    public a(LayoutInflater layoutInflater, Context context) {
        super(layoutInflater, context);
        if (layoutInflater instanceof a) {
            this.f437917a = ((a) layoutInflater).f437917a;
        }
    }
}
