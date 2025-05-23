package t92;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e extends c {
    public e(View view) {
        super(view);
    }

    public static e d(Context context, ViewGroup viewGroup, int i3) {
        return new e(LayoutInflater.from(context).inflate(i3, viewGroup, false));
    }
}
