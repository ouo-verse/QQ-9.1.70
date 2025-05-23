package ul;

import androidx.lifecycle.MutableLiveData;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d extends ql.a<Boolean> {

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<Boolean> f439132m = new MutableLiveData<>(Boolean.FALSE);

    @Override // ql.a
    public boolean M1() {
        return false;
    }

    public MutableLiveData<Boolean> O1() {
        return this.f439132m;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZoneSyncFriendFeedViewModel";
    }
}
