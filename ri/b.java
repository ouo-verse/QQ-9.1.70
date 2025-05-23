package ri;

import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import fj.s;
import kotlin.Metadata;
import u9.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lri/b;", "Lu9/d;", "", "T", "W", "<init>", "()V", "L", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends d {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // u9.d
    public void T() {
        C().setText(C().getResources().getString(R.string.spb, Long.valueOf(((CommonGridItemData) this.mData).getBatchBean().getBatchInfo().getUploadNumber())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u9.d
    public void W() {
        try {
            y().setUser(Long.parseLong(((CommonGridItemData) this.mData).getBatchBean().getBatchInfo().getUser().getUin()));
        } catch (NumberFormatException e16) {
            QLog.e("GroupAlbumDetailBatchHeadSection", 1, "updateUserData  e = " + e16);
        }
        D().setText(s.f399470a.a(((CommonGridItemData) this.mData).getBatchBean().getBatchInfo().getUser().getUin(), ((CommonGridItemData) this.mData).getBatchBean().getBatchInfo().getUser().getNick()));
    }
}
