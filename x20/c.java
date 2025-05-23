package x20;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.richframework.data.idata.IDataConverter;
import cooperation.qqcircle.utils.QCircleCommonUtil;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c implements IDataConverter<y20.a> {
    /* JADX WARN: Multi-variable type inference failed */
    private static void d(String str, int i3) {
        MutableLiveData globalData = w20.a.j().getGlobalData(y20.a.class, str);
        if (globalData != null && globalData.getValue() != 0) {
            y20.a aVar = (y20.a) globalData.getValue();
            if (aVar.f(i3)) {
                globalData.setValue(aVar);
                f(str, i3);
                return;
            }
            return;
        }
        w20.a.j().initOrUpdateGlobalState((w20.a) new y20.a(str, i3), true);
    }

    public static void e(y20.a aVar) {
        if (aVar.e()) {
            d(aVar.c(), aVar.b());
        } else {
            w20.a.j().initOrUpdateGlobalState((w20.a) aVar, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void f(String str, int i3) {
        MutableLiveData globalData = w20.a.j().getGlobalData(y20.a.class, QCircleCommonUtil.getCurrentAccount());
        if (globalData != null && globalData.getValue() != 0) {
            y20.a aVar = (y20.a) globalData.getValue();
            aVar.f(i3);
            globalData.setValue(aVar);
        }
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public y20.a cloneConvertData(y20.a aVar) {
        y20.a aVar2 = new y20.a(aVar.c(), aVar.b());
        aVar2.a(aVar);
        return aVar2;
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getObserverKey(y20.a aVar) {
        return aVar.c();
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(y20.a aVar, y20.a aVar2) {
        if (aVar != null && aVar2 != null) {
            aVar.a(aVar2);
        }
    }
}
