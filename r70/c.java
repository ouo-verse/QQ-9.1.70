package r70;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.request.QFSGetFeedAdviceReq;
import com.tencent.biz.qqcircle.immersive.request.QFSSetFeedAdviceReq;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import e40.QFSWorkSuggestionsData;
import feedcloud.FeedCloudRead$Advice;
import feedcloud.FeedCloudRead$GetFeedAdviceRsp;
import feedcloud.FeedCloudRead$SetFeedAdviceRsp;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 02\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0016JV\u0010\u0010\u001a\u00020\u000e2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042:\u0010\u000f\u001a6\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007J\u001e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J\u001e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\bJ\b\u0010\u0019\u001a\u00020\u000eH\u0014R<\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u008c\u0001\u0010\u000f\u001a6\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00072:\u0010\u001a\u001a6\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00078\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020$0(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lr70/c;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "getLogTag", "", "", "reportBean", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "which", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "", "onSelect", "P1", "userId", "feedID", "", WadlProxyConsts.CREATE_TIME, "S1", "adviceId", "userful", "Q1", "onCleared", "<set-?>", "i", "Ljava/util/Map;", "getReportBean", "()Ljava/util/Map;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function2;", "N1", "()Lkotlin/jvm/functions/Function2;", "Landroidx/lifecycle/MutableLiveData;", "Le40/r;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_serverData", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "O1", "()Landroidx/lifecycle/LiveData;", "serverData", "<init>", "()V", "E", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class c extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<QFSWorkSuggestionsData> _serverData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<QFSWorkSuggestionsData> serverData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, Object> reportBean = new LinkedHashMap();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function2<? super Integer, ? super Bundle, Unit> onSelect;

    public c() {
        MutableLiveData<QFSWorkSuggestionsData> mutableLiveData = new MutableLiveData<>();
        this._serverData = mutableLiveData;
        this.serverData = mutableLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$SetFeedAdviceRsp feedCloudRead$SetFeedAdviceRsp) {
        String str2;
        if (baseRequest != null) {
            str2 = baseRequest.getTraceId();
        } else {
            str2 = null;
        }
        QLog.d("QFSWorkSuggestionsViewModel", 1, "QFSSetFeedAdviceReq, traceId:" + str2 + ", isSuccess:" + z16 + ", retCode:" + j3 + ", errMsg:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(c this$0, BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$GetFeedAdviceRsp feedCloudRead$GetFeedAdviceRsp) {
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (baseRequest != null) {
            str2 = baseRequest.getTraceId();
        } else {
            str2 = null;
        }
        QLog.d("QFSWorkSuggestionsViewModel", 1, "requestPlusMenuData, traceId:" + str2 + ", isSuccess:" + z16 + ", retCode:" + j3 + ", errMsg:" + str);
        if (z16 && j3 == 0 && feedCloudRead$GetFeedAdviceRsp != null) {
            MutableLiveData<QFSWorkSuggestionsData> mutableLiveData = this$0._serverData;
            List<FeedCloudRead$Advice> list = feedCloudRead$GetFeedAdviceRsp.advices.get();
            Intrinsics.checkNotNullExpressionValue(list, "rsp.advices.get()");
            String str3 = feedCloudRead$GetFeedAdviceRsp.mordata_url.get();
            Intrinsics.checkNotNullExpressionValue(str3, "rsp.mordata_url.get()");
            String str4 = feedCloudRead$GetFeedAdviceRsp.mordata_word.get();
            Intrinsics.checkNotNullExpressionValue(str4, "rsp.mordata_word.get()");
            mutableLiveData.postValue(new QFSWorkSuggestionsData(list, str3, str4));
            return;
        }
        this$0._serverData.postValue(null);
    }

    @Nullable
    public final Function2<Integer, Bundle, Unit> N1() {
        return this.onSelect;
    }

    @NotNull
    public final LiveData<QFSWorkSuggestionsData> O1() {
        return this.serverData;
    }

    public final void P1(@NotNull Map<String, Object> reportBean, @Nullable Function2<? super Integer, ? super Bundle, Unit> onSelect) {
        Intrinsics.checkNotNullParameter(reportBean, "reportBean");
        this.reportBean = reportBean;
        this.onSelect = onSelect;
    }

    public final void Q1(@NotNull String userId, @NotNull String adviceId, int userful) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(adviceId, "adviceId");
        sendRequest(new QFSSetFeedAdviceReq(userId, adviceId, userful), new VSDispatchObserver.OnVSRspCallBack() { // from class: r70.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                c.R1(baseRequest, z16, j3, str, (FeedCloudRead$SetFeedAdviceRsp) obj);
            }
        });
    }

    public final void S1(@NotNull String userId, @NotNull String feedID, long createTime) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(feedID, "feedID");
        sendRequest(new QFSGetFeedAdviceReq(userId, feedID, createTime), new VSDispatchObserver.OnVSRspCallBack() { // from class: r70.b
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                c.T1(c.this, baseRequest, z16, j3, str, (FeedCloudRead$GetFeedAdviceRsp) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "QFSWorkSuggestionsViewModel";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.onSelect = null;
    }
}
