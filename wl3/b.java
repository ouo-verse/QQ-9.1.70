package wl3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b extends a {
    public b(View view) {
        super(view);
    }

    public static b n(Context context, ViewGroup viewGroup, @LayoutRes int i3) {
        return new b(LayoutInflater.from(context).inflate(i3, viewGroup, false));
    }
}
