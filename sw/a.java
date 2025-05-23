package sw;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends ViewModel {

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<Boolean> f434866i;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<Boolean> f434867m;

    public a() {
        Boolean bool = Boolean.FALSE;
        this.f434866i = new MutableLiveData<>(bool);
        this.f434867m = new MutableLiveData<>(bool);
    }

    public void L1() {
        this.f434866i.setValue(Boolean.TRUE);
    }

    public LiveData<Boolean> M1() {
        return this.f434866i;
    }

    public LiveData<Boolean> N1() {
        return this.f434867m;
    }

    public void O1() {
        this.f434866i.setValue(Boolean.FALSE);
    }

    public void P1() {
        this.f434867m.setValue(Boolean.TRUE);
    }
}
