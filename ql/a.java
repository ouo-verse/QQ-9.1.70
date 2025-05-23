package ql;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class a<T> extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<T> f429043i = new MutableLiveData<>(null);

    public MutableLiveData<T> L1() {
        return this.f429043i;
    }

    public abstract boolean M1();

    public void N1(T t16) {
        this.f429043i.postValue(t16);
    }
}
