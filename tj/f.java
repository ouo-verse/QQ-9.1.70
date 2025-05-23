package tj;

import android.os.Bundle;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b&\u0018\u0000 \u0011*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Ltj/f;", "T", "Lcom/qzone/reborn/albumx/common/layer/part/i;", "Landroid/os/Bundle;", "data", "", "initIntentData", "", tl.h.F, "Ljava/lang/String;", "D9", "()Ljava/lang/String;", "setSpaceId", "(Ljava/lang/String;)V", "spaceId", "<init>", "()V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class f<T> extends com.qzone.reborn.albumx.common.layer.part.i<T> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String spaceId = "";

    /* renamed from: D9, reason: from getter */
    public final String getSpaceId() {
        return this.spaceId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void initIntentData(Bundle data) {
        super.initIntentData(data);
        String string = data != null ? data.getString("key_space_id") : null;
        if (string == null) {
            string = "";
        }
        this.spaceId = string;
    }
}
