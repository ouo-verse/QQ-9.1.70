package tk3;

import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.common.soloader.b;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0002\u000e\u000fB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0010"}, d2 = {"Ltk3/b;", "Lcom/tencent/zplan/common/soloader/b;", "", "soNickname", "Lcom/tencent/zplan/common/soloader/a;", "load", "prepare", "", "getPriority", "()I", "priority", "<init>", "()V", "d", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b implements com.tencent.zplan.common.soloader.b {

    /* renamed from: e, reason: collision with root package name */
    private static final Set<String> f436474e;

    static {
        Set<String> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{SoLoadConstants.APNG_SO, "SharpPEnc", SoLoadConstants.SONAME_SHARPDEC, SoLoadConstants.SONAME_X264, SoLoadConstants.SONAME_MP4V2, SoLoadConstants.SONAME_MP4_SYNTHESIZER});
        f436474e = of5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Integer] */
    public static final void e(Ref.ObjectRef resCode, Ref.ObjectRef loadExtResult, String soNickname, CountDownLatch done, int i3, LoadExtResult loadExtResult2) {
        Intrinsics.checkNotNullParameter(resCode, "$resCode");
        Intrinsics.checkNotNullParameter(loadExtResult, "$loadExtResult");
        Intrinsics.checkNotNullParameter(soNickname, "$soNickname");
        Intrinsics.checkNotNullParameter(done, "$done");
        resCode.element = Integer.valueOf(i3);
        loadExtResult.element = loadExtResult2;
        QLog.i("QQSoLoadManagerWrapper", 1, "prepare callback end soName=" + soNickname + " result=" + loadExtResult2);
        done.countDown();
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(com.tencent.zplan.common.soloader.b bVar) {
        return b.a.a(this, bVar);
    }

    @Override // com.tencent.zplan.common.soloader.b
    public int getPriority() {
        return 90;
    }

    @Override // com.tencent.zplan.common.soloader.b
    public com.tencent.zplan.common.soloader.a load(String soNickname) {
        Intrinsics.checkNotNullParameter(soNickname, "soNickname");
        if (!f436474e.contains(soNickname)) {
            return null;
        }
        LoadExtResult loadSync = SoLoadManager.getInstance().loadSync(soNickname);
        if (loadSync == null) {
            QLog.e("QQSoLoadManagerWrapper", 1, "load failed soName=" + soNickname + " result=null");
            return null;
        }
        QLog.i("QQSoLoadManagerWrapper", 1, "load soName=" + soNickname + " ver:" + loadSync.getVer(soNickname));
        if (!loadSync.isSucc()) {
            QLog.e("QQSoLoadManagerWrapper", 1, "load failed soName=" + soNickname + " result=" + loadSync);
            return null;
        }
        return new LoadedItem(loadSync);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.zplan.common.soloader.b
    public com.tencent.zplan.common.soloader.a prepare(final String soNickname) {
        T t16;
        Intrinsics.checkNotNullParameter(soNickname, "soNickname");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        SoLoadManager.getInstance().download(soNickname, new OnLoadListener() { // from class: tk3.a
            @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
            public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                b.e(Ref.ObjectRef.this, objectRef2, soNickname, countDownLatch, i3, loadExtResult);
            }
        });
        QLog.i("QQSoLoadManagerWrapper", 1, "prepare await start soName=" + soNickname);
        countDownLatch.await();
        QLog.i("QQSoLoadManagerWrapper", 1, "prepare await end soName=" + soNickname);
        Integer num = (Integer) objectRef.element;
        if (num == null || num.intValue() != 0 || (t16 = objectRef2.element) == 0) {
            return null;
        }
        Intrinsics.checkNotNull(t16);
        return new LoadedItem((LoadExtResult) t16);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Ltk3/b$b;", "Lcom/tencent/zplan/common/soloader/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/soload/biz/entity/LoadExtResult;", "a", "Lcom/tencent/mobileqq/soload/biz/entity/LoadExtResult;", "getResult", "()Lcom/tencent/mobileqq/soload/biz/entity/LoadExtResult;", "result", "<init>", "(Lcom/tencent/mobileqq/soload/biz/entity/LoadExtResult;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tk3.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class LoadedItem implements com.tencent.zplan.common.soloader.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final LoadExtResult result;

        public LoadedItem(LoadExtResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.result = result;
        }

        public int hashCode() {
            return this.result.hashCode();
        }

        public String toString() {
            return "LoadedItem(result=" + this.result + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof LoadedItem) && Intrinsics.areEqual(this.result, ((LoadedItem) other).result);
        }
    }
}
