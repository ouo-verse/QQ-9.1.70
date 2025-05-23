package zu3;

import com.tencent.mobileqq.emotionintegrate.p;
import com.tencent.richframework.data.base.BaseDataStore;
import java.util.LinkedHashMap;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\b\u00a8\u0006\f"}, d2 = {"Lzu3/a;", "Lcom/tencent/richframework/data/base/BaseDataStore;", "Lcom/tencent/mobileqq/emotionintegrate/p;", "Ljava/util/LinkedHashMap;", "", "a", "data", "b", "Ljava/util/LinkedHashMap;", "richMediaStore", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends BaseDataStore<p> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final LinkedHashMap<String, p> richMediaStore = new LinkedHashMap<>();

    @Override // com.tencent.richframework.data.idata.IDataStore
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LinkedHashMap<String, p> getAllData() {
        return this.richMediaStore;
    }

    @Override // com.tencent.richframework.data.idata.IDataStore
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getKeyFromData(p data) {
        return String.valueOf(data != null ? Long.valueOf(data.k()) : null);
    }
}
