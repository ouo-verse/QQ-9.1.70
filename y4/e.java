package y4;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class e extends PagerAdapter {

    /* renamed from: d, reason: collision with root package name */
    private final FragmentManager f449320d;

    /* renamed from: e, reason: collision with root package name */
    private FragmentTransaction f449321e = null;

    /* renamed from: f, reason: collision with root package name */
    private Fragment f449322f = null;

    public e(FragmentManager fragmentManager) {
        this.f449320d = fragmentManager;
    }

    public static String makeFragmentName(int i3, long j3) {
        return "android:switcher:" + i3 + ":" + j3;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        if (this.f449321e == null) {
            this.f449321e = this.f449320d.beginTransaction();
        }
        this.f449321e.detach((Fragment) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f449321e;
        if (fragmentTransaction != null) {
            fragmentTransaction.commitAllowingStateLoss();
            this.f449321e = null;
            this.f449320d.executePendingTransactions();
        }
    }

    public abstract Fragment getItem(int i3);

    public long getItemId(int i3) {
        return i3;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        if (this.f449321e == null) {
            this.f449321e = this.f449320d.beginTransaction();
        }
        long itemId = getItemId(i3);
        Fragment findFragmentByTag = this.f449320d.findFragmentByTag(makeFragmentName(viewGroup.getId(), itemId));
        if (findFragmentByTag != null) {
            this.f449321e.attach(findFragmentByTag);
        } else {
            findFragmentByTag = getItem(i3);
            this.f449321e.add(viewGroup.getId(), findFragmentByTag, makeFragmentName(viewGroup.getId(), itemId));
        }
        if (findFragmentByTag != this.f449322f) {
            a.b(findFragmentByTag, false);
            a.c(findFragmentByTag, false);
        }
        return findFragmentByTag;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i3, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f449322f;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                a.b(fragment2, false);
                a.c(this.f449322f, false);
            }
            if (fragment != null) {
                a.b(fragment, true);
                a.c(fragment, true);
            }
            this.f449322f = fragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }
}
