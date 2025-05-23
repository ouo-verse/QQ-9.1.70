package xg;

import android.app.Activity;
import android.view.View;
import com.qzone.reborn.feedx.util.w;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class a<T> {

    /* renamed from: a, reason: collision with root package name */
    protected Activity f447910a;

    /* renamed from: b, reason: collision with root package name */
    protected com.tencent.biz.qqcircle.richframework.widget.menu.c f447911b;

    /* renamed from: c, reason: collision with root package name */
    protected T f447912c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: xg.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public class C11544a implements w.c {
        C11544a() {
        }

        @Override // com.qzone.reborn.feedx.util.w.c
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.mil /* 1745224294 */:
                    a.this.h();
                    return;
                case R.id.n0w /* 1745224968 */:
                    a.this.g();
                    return;
                case R.id.n0y /* 1745224970 */:
                    if (a.this.e() != null) {
                        a.this.e().onCopy();
                        return;
                    }
                    return;
                case R.id.n0z /* 1745224971 */:
                    if (a.this.f() != null) {
                        a.this.f().onDelete();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final String f447914a = HardCodeUtil.qqStr(R.string.rfw);

        /* renamed from: b, reason: collision with root package name */
        public static final String f447915b = HardCodeUtil.qqStr(R.string.f133195g);

        /* renamed from: c, reason: collision with root package name */
        public static final String f447916c = HardCodeUtil.qqStr(R.string.rfx);

        /* renamed from: d, reason: collision with root package name */
        public static final String f447917d = HardCodeUtil.qqStr(R.string.rfg);
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface c {
        void onCopy();
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface d {
        void onDelete();
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface e {
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface f {
    }

    private w.c c() {
        return new C11544a();
    }

    protected abstract List<Integer> a();

    protected abstract List<String> b();

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(View view) {
        List<Integer> a16 = a();
        List<String> b16 = b();
        if (a16 != null && b16 != null) {
            if (!a16.isEmpty() && !b16.isEmpty() && a16.size() == b16.size()) {
                this.f447911b = new com.tencent.biz.qqcircle.richframework.widget.menu.c();
                for (int i3 = 0; i3 < a16.size(); i3++) {
                    this.f447911b.a(a16.get(i3).intValue(), b16.get(i3));
                }
                w.a().b(view, this.f447911b, c());
                return;
            }
            QLog.e("QZoneBaseLongClickProcess", 1, "lists are empty, or id list size not equals to title list size");
            return;
        }
        QLog.e("QZoneBaseLongClickProcess", 1, "id list or title list is null");
    }

    protected abstract c e();

    protected abstract d f();

    protected abstract e g();

    protected abstract f h();
}
