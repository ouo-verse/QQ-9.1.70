package rw4;

import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import com.tencent.vas.update.module.impl.b;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.List;
import sw4.h;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected BaseUpdateBusiness[] f432648a;

    /* renamed from: b, reason: collision with root package name */
    protected b f432649b = new b();

    public a() {
        VasUpdateWrapper.setVasUpdateWrapper(b());
        f();
        VasUpdateWrapper.getVasUpdateSystem().c(this.f432649b);
    }

    private void a(BaseUpdateBusiness[] baseUpdateBusinessArr) {
        for (BaseUpdateBusiness baseUpdateBusiness : baseUpdateBusinessArr) {
            if (baseUpdateBusiness != null && baseUpdateBusiness.getBid() > 0) {
                this.f432649b.e(baseUpdateBusiness.getBid(), baseUpdateBusiness);
            }
        }
    }

    protected abstract h b();

    public List<IBusinessCallback> c() {
        return this.f432649b.f();
    }

    public BaseUpdateBusiness d(long j3) {
        if (this.f432649b.a(j3) != null) {
            return (BaseUpdateBusiness) this.f432649b.a(j3);
        }
        throw new NullPointerException("bid doesn't resiter or has been register,you need to reuse the same bid callback,bid = " + j3);
    }

    public <T extends IBusinessCallback> T e(Class<T> cls) {
        if (this.f432649b.g(cls) != null) {
            return (T) this.f432649b.g(cls);
        }
        throw new NullPointerException("bid has been register , you need to reuse the same bid callback\uff0cclass = " + cls);
    }

    public void f() {
        BaseUpdateBusiness[] g16 = g();
        this.f432648a = g16;
        a(g16);
        BaseUpdateBusiness h16 = h();
        if (h16 != null) {
            this.f432649b.h(h16);
        }
    }

    public abstract BaseUpdateBusiness[] g();

    protected abstract BaseUpdateBusiness h();

    public void i() {
        VasUpdateWrapper.getVasUpdateSystem().e();
    }
}
