package qs;

import android.app.Activity;
import android.content.Intent;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface c {
    String getRefer();

    void onActivityResult(Activity activity, int i3, int i16, Intent intent);

    void sendClick(Activity activity, Intent intent);

    void setRefer(String str);
}
