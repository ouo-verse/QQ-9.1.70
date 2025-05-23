package x20;

import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.personal.data.w;
import com.tencent.richframework.data.idata.IDataConverter;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d implements IDataConverter<w> {
    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getObserverKey(w wVar) {
        return wVar.L();
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(w wVar, w wVar2) {
        if (wVar != null && wVar2 != null) {
            wVar.o(wVar2);
        }
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public w cloneConvertData(w wVar) {
        return wVar;
    }
}
