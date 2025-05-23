package ra0;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.publish.plusmenu.request.QFSPlusMenuGetReq;
import com.tencent.biz.qqcircle.publish.plusmenu.vm.QFSPlusMenuViewModel;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudPubGuideSvr$PlusEntryGuideRsp;
import feedcloud.FeedCloudPubGuideSvr$ResourceInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pa0.PlusMenuServerData;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007R.\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@BX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lra0/c;", "", "", "pageId", "", "lightSdkVersion", "", "e", "Lpa0/d;", "value", "b", "Lpa0/d;", "()Lpa0/d;", h.F, "(Lpa0/d;)V", "serverData", "Landroidx/lifecycle/MutableLiveData;", "c", "Landroidx/lifecycle/MutableLiveData;", "_serverDataLiveData", "Landroidx/lifecycle/LiveData;", "d", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "serverDataLiveData", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f430999a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static PlusMenuServerData serverData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<PlusMenuServerData> _serverDataLiveData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LiveData<PlusMenuServerData> serverDataLiveData;

    static {
        MutableLiveData<PlusMenuServerData> mutableLiveData = new MutableLiveData<>();
        _serverDataLiveData = mutableLiveData;
        serverDataLiveData = mutableLiveData;
    }

    c() {
    }

    public static /* synthetic */ void f(c cVar, int i3, String str, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            str = QFSPlusMenuViewModel.INSTANCE.a();
        }
        cVar.e(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudPubGuideSvr$PlusEntryGuideRsp feedCloudPubGuideSvr$PlusEntryGuideRsp) {
        String str2;
        if (baseRequest != null) {
            str2 = baseRequest.getTraceId();
        } else {
            str2 = null;
        }
        QLog.d("QFSPlusMenuDataHelper", 1, "requestPlusMenuData, traceId:" + str2 + ", isSuccess:" + z16 + ", retCode:" + j3 + ", errMsg:" + str);
        if (z16 && j3 == 0 && feedCloudPubGuideSvr$PlusEntryGuideRsp != null) {
            c cVar = f430999a;
            List<FeedCloudPubGuideSvr$ResourceInfo> list = feedCloudPubGuideSvr$PlusEntryGuideRsp.resources.get();
            Intrinsics.checkNotNullExpressionValue(list, "rsp.resources.get()");
            cVar.h(new PlusMenuServerData(list, feedCloudPubGuideSvr$PlusEntryGuideRsp.show_first_pub_animation.get()));
        }
    }

    private final void h(PlusMenuServerData plusMenuServerData) {
        serverData = plusMenuServerData;
        if (plusMenuServerData != null) {
            _serverDataLiveData.postValue(plusMenuServerData);
        }
    }

    @Nullable
    public final PlusMenuServerData b() {
        return serverData;
    }

    @NotNull
    public final LiveData<PlusMenuServerData> c() {
        return serverDataLiveData;
    }

    @JvmOverloads
    public final void d(int i3) {
        f(this, i3, null, 2, null);
    }

    @JvmOverloads
    public final void e(int pageId, @NotNull String lightSdkVersion) {
        Intrinsics.checkNotNullParameter(lightSdkVersion, "lightSdkVersion");
        QLog.d("QFSPlusMenuDataHelper", 1, "requestPlusMenuData ");
        VSNetworkHelper.getInstance().sendRequest(new QFSPlusMenuGetReq(null, null, pageId, lightSdkVersion, 3, null), new VSDispatchObserver.OnVSRspCallBack() { // from class: ra0.b
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                c.g(baseRequest, z16, j3, str, (FeedCloudPubGuideSvr$PlusEntryGuideRsp) obj);
            }
        });
    }
}
