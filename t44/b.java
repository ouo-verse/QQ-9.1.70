package t44;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.widget.listitem.x.b;
import com.tencent.mobileqq.widget.listitem.x.c;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b<L extends x.b, R extends x.c> extends x {

    /* renamed from: q, reason: collision with root package name */
    public QUISingleLineListItem f435389q;

    /* renamed from: r, reason: collision with root package name */
    private WeakReference<QUIListItemAdapter> f435390r;

    /* renamed from: s, reason: collision with root package name */
    private String f435391s;

    /* renamed from: t, reason: collision with root package name */
    private QUIListItemBackgroundType f435392t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f435393u;

    /* renamed from: v, reason: collision with root package name */
    private String f435394v;

    public b(@NonNull x.b bVar, @NonNull x.c cVar, QUIListItemAdapter qUIListItemAdapter) {
        super(bVar, cVar);
        this.f435393u = true;
        this.f435390r = new WeakReference<>(qUIListItemAdapter);
    }

    private void X() {
        if (this.f435390r.get() == null) {
            return;
        }
        this.f435390r.get().l0(this);
    }

    private void d0() {
        if (AppSetting.f99565y && this.f435389q != null && !TextUtils.isEmpty(this.f435394v)) {
            AccessibilityUtil.c(this.f435389q, this.f435391s, this.f435394v);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.x
    /* renamed from: P */
    public void F(@NonNull QUISingleLineListItem qUISingleLineListItem, int i3, @NonNull List list) {
        super.F(qUISingleLineListItem, i3, list);
        qUISingleLineListItem.setContentDescription(this.f435391s);
        QUIListItemBackgroundType qUIListItemBackgroundType = this.f435392t;
        if (qUIListItemBackgroundType != null) {
            qUISingleLineListItem.setBackgroundType(qUIListItemBackgroundType);
        }
        d0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.x, com.tencent.mobileqq.widget.listitem.w
    @NonNull
    /* renamed from: Q */
    public QUISingleLineListItem H(@NonNull ViewGroup viewGroup) {
        QUISingleLineListItem H = super.H(viewGroup);
        this.f435389q = H;
        return H;
    }

    public QUISingleLineListItem V() {
        return this.f435389q;
    }

    public boolean W() {
        if (O() instanceof x.c.f) {
            return ((x.c.f) O()).getIsChecked();
        }
        return false;
    }

    public void Y(boolean z16) {
        if (O() instanceof x.c.f) {
            ((x.c.f) O()).f(z16);
            X();
        }
    }

    public void Z(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (O() instanceof x.c.f) {
            ((x.c.f) O()).h(onCheckedChangeListener);
            X();
        }
    }

    public void a0(String str) {
        if (O() instanceof x.c.g) {
            ((x.c.g) O()).h(str);
            X();
        }
    }

    public void b0(View.OnClickListener onClickListener) {
        x(onClickListener);
        X();
    }

    public void c0(int i3) {
        boolean z16;
        if (this.f435390r.get() == null) {
            return;
        }
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f435393u = z16;
        this.f435390r.get().m0(this, this.f435393u);
    }
}
