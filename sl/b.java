package sl;

import androidx.lifecycle.MutableLiveData;
import cooperation.qzone.LbsDataV2;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends ql.a {

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<LbsDataV2.PoiInfo> f433941m = new MutableLiveData<>(null);

    @Override // ql.a
    public boolean M1() {
        return false;
    }

    public MutableLiveData<LbsDataV2.PoiInfo> O1() {
        return this.f433941m;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZoneSyncFriendFeedViewModel";
    }
}
