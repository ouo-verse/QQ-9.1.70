package rn;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes36.dex */
public class f {

    /* renamed from: h, reason: collision with root package name */
    private static final int f431712h = ar.e(90.0f);

    /* renamed from: a, reason: collision with root package name */
    private ViewGroup f431713a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f431714b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f431715c;

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f431716d;

    /* renamed from: e, reason: collision with root package name */
    private QZoneUserAvatarView f431717e;

    /* renamed from: f, reason: collision with root package name */
    private QZoneUserAvatarView f431718f;

    /* renamed from: g, reason: collision with root package name */
    private int f431719g;

    public f(ViewGroup viewGroup) {
        this.f431713a = viewGroup;
        b();
    }

    private void b() {
        ViewGroup viewGroup = this.f431713a;
        if (viewGroup == null) {
            return;
        }
        this.f431714b = (ImageView) viewGroup.findViewById(R.id.f67873ei);
        this.f431715c = (TextView) this.f431713a.findViewById(R.id.f67953eq);
        this.f431716d = (FrameLayout) this.f431713a.findViewById(R.id.f67863eh);
        this.f431717e = (QZoneUserAvatarView) this.f431713a.findViewById(R.id.f67963er);
        this.f431718f = (QZoneUserAvatarView) this.f431713a.findViewById(R.id.f67973es);
    }

    private void c() {
        d();
        f(false);
    }

    private void d() {
        TextView textView = this.f431715c;
        if (textView == null) {
            return;
        }
        b.s(textView, null);
        this.f431715c.setVisibility(4);
    }

    private void f(boolean z16) {
        e(this.f431716d, z16);
        e(this.f431714b, !z16);
    }

    private void i() {
        ViewGroup viewGroup = this.f431713a;
        if (viewGroup == null) {
            return;
        }
        try {
            viewGroup.measure(0, 0);
            this.f431719g = this.f431713a.getMeasuredWidth();
        } catch (Exception e16) {
            QLog.e("QZMTitleBarCopyEntranceViewHelper", 1, "measure width exception is " + e16);
            this.f431719g = f431712h;
        }
    }

    public int a() {
        return this.f431719g;
    }

    public void h(QZoneCountInfo qZoneCountInfo) {
        if (qZoneCountInfo == null) {
            c();
        } else {
            b.s(this.f431715c, qZoneCountInfo);
            g(qZoneCountInfo);
        }
        i();
    }

    private void g(QZoneCountInfo qZoneCountInfo) {
        if (qZoneCountInfo == null) {
            f(false);
            return;
        }
        ArrayList<QZoneCountUserInfo> arrayList = qZoneCountInfo.friendList;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                QZoneCountUserInfo qZoneCountUserInfo = arrayList.get(i3);
                if (qZoneCountUserInfo != null) {
                    arrayList2.add(Long.valueOf(qZoneCountUserInfo.uin));
                }
            }
            if (arrayList2.isEmpty()) {
                QLog.e("QZMTitleBarCopyEntranceViewHelper", 1, "invalidate uin list");
                f(false);
                return;
            }
            if (arrayList2.size() == 1) {
                b.k(this.f431717e, ((Long) arrayList2.get(0)).longValue());
                b.n(this.f431718f, false);
            } else {
                b.k(this.f431717e, ((Long) arrayList2.get(0)).longValue());
                b.k(this.f431718f, ((Long) arrayList2.get(1)).longValue());
            }
            f(true);
            return;
        }
        QLog.e("QZMTitleBarCopyEntranceViewHelper", 1, "invalidate list");
        f(false);
    }

    private void e(View view, boolean z16) {
        if (view == null) {
            return;
        }
        view.setVisibility(z16 ? 4 : 8);
    }
}
