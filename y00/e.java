package y00;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Ly00/e;", "Ly00/a;", "", ExifInterface.LATITUDE_SOUTH, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "fragmentVisible", "", "W", "E", "Z", "hasLoadData", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e extends a {

    /* renamed from: E, reason: from kotlin metadata */
    private boolean hasLoadData;

    @Override // y00.a, com.tencent.biz.pubaccount.weishi.profile.c
    public boolean S() {
        return true;
    }

    @Override // y00.a, com.tencent.biz.pubaccount.weishi.profile.c
    public void W(boolean fragmentVisible) {
        super.W(fragmentVisible);
        if (this.hasLoadData || !fragmentVisible) {
            return;
        }
        this.hasLoadData = true;
        I0(getPerson(), r0());
        l0();
    }

    @Override // y00.a, com.tencent.biz.pubaccount.weishi.profile.c
    public boolean z() {
        return true;
    }
}
