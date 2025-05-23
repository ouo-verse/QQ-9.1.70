package sm3;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.now.linkpkanchorplay.mainpage.model.LinkPKTabData;
import com.tencent.now.linkpkanchorplay.mainpage.model.b;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR \u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lsm3/a;", "Landroidx/lifecycle/ViewModel;", "", "N1", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/now/linkpkanchorplay/mainpage/model/LinkPKTabData;", "M1", "", "selectedId", "O1", "Landroid/content/Context;", "i", "Landroid/content/Context;", "context", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "tabInfoLiveData", "Lcom/tencent/now/linkpkanchorplay/mainpage/model/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/now/linkpkanchorplay/mainpage/model/b;", "dataMode", "<init>", "(Landroid/content/Context;)V", "D", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.now.linkpkanchorplay.mainpage.model.b dataMode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<LinkPKTabData>> tabInfoLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"sm3/a$b", "Lcom/tencent/now/linkpkanchorplay/mainpage/model/b$b;", "", "Lcom/tencent/now/linkpkanchorplay/mainpage/model/LinkPKTabData;", "tabList", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements b.InterfaceC9245b {
        b() {
        }

        @Override // com.tencent.now.linkpkanchorplay.mainpage.model.b.InterfaceC9245b
        public void a(@Nullable List<LinkPKTabData> tabList) {
            if (tabList != null) {
                a aVar = a.this;
                AegisLogger.INSTANCE.i("PK_Biz|LinkAndPKTabViewModel", "tab list updated,size = " + tabList.size());
                aVar.tabInfoLiveData.setValue(tabList);
            }
        }
    }

    public a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.tabInfoLiveData = new MutableLiveData<>();
        this.dataMode = new com.tencent.now.linkpkanchorplay.mainpage.model.b();
    }

    @NotNull
    public final MutableLiveData<List<LinkPKTabData>> M1() {
        return this.tabInfoLiveData;
    }

    public final void N1() {
        this.dataMode.b(new b());
    }

    public final void O1(int selectedId) {
        this.dataMode.d(selectedId);
    }
}
