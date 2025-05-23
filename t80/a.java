package t80;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import java.util.ArrayList;
import java.util.List;
import p70.i;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends com.tencent.biz.qqcircle.viewmodels.a implements IDataDisplaySurface<e30.b>, Observer<UIStateData<List<e30.b>>> {
    private final List<e30.b> C = new ArrayList();
    private final MutableLiveData<UIStateData<List<e30.b>>> D = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    private i f435595m;

    private void L1() {
        UIStateData<List<e30.b>> value = this.f435595m.h2().getValue();
        if (value == null) {
            UIStateData<List<e30.b>> obtainSuccess = UIStateData.obtainSuccess(true);
            obtainSuccess.setData(false, this.C);
            obtainSuccess.setFinish(true);
            this.D.setValue(obtainSuccess);
            return;
        }
        ArrayList arrayList = new ArrayList(this.C);
        arrayList.addAll(value.getData());
        UIStateData<List<e30.b>> obtainEmpty = UIStateData.obtainEmpty();
        obtainEmpty.setState(value.getState());
        obtainEmpty.setData(false, arrayList);
        obtainEmpty.setFinish(value.getIsFinish());
        this.D.setValue(obtainEmpty);
    }

    public String M1() {
        return String.valueOf(hashCode());
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: N1, reason: merged with bridge method [inline-methods] */
    public void onChanged(UIStateData<List<e30.b>> uIStateData) {
        L1();
    }

    public void O1(i iVar, List<e30.b> list) {
        this.C.clear();
        if (list != null && !list.isEmpty()) {
            this.C.addAll(list);
        }
        this.f435595m = iVar;
        iVar.h2().removeObserver(this);
        iVar.h2().observeForever(this);
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<e30.b>>> getDisplaySurfaceData(Object... objArr) {
        return this.D;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QFSSearchFeedConcatViewModel";
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
        this.f435595m.loadMoreForDisplaySurface(objArr);
    }
}
