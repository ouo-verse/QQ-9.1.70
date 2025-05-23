package y4;

import androidx.fragment.app.Fragment;

/* compiled from: P */
/* loaded from: classes36.dex */
class d {
    public static void a(Fragment fragment, boolean z16) {
        if (fragment.getParentFragmentManager() != null) {
            fragment.setUserVisibleHint(z16);
        }
    }
}
