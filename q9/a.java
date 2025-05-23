package q9;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 #*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0016J8\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0004R\"\u0010\u0017\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R.\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00190\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lq9/a;", "T", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "getLogTag", "msg", "", "isSuccess", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "req", "", "retCode", "errMsg", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "N1", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "i", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "L1", "()Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "setLoadInfo", "(Lcom/tencent/biz/richframework/part/block/base/LoadInfo;)V", "loadInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "M1", "()Landroidx/lifecycle/MutableLiveData;", "setResponseData", "(Landroidx/lifecycle/MutableLiveData;)V", WebViewPlugin.KEY_RESPONSE, "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public class a<T> extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LoadInfo loadInfo = new LoadInfo();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<UIStateData<T>> responseData = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: L1, reason: from getter */
    public final LoadInfo getLoadInfo() {
        return this.loadInfo;
    }

    public final MutableLiveData<UIStateData<T>> M1() {
        return this.responseData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void N1(String msg2, boolean isSuccess, BaseRequest req, long retCode, String errMsg, boolean isLoadMore) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.i(getLogTag(), 1, msg2 + " responseLog onReceive, isSuccess: " + isSuccess + " | traceId: " + req.getTraceId() + " | seqId:" + req.getCurrentSeq() + " | cmdName:" + req.getCmdName() + " | retCode:" + retCode + " | retMessage:" + errMsg + " | isLoadMore:" + isLoadMore);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZoneBaseLayerViewModel";
    }
}
