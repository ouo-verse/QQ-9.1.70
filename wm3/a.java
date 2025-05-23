package wm3;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.component.callback.ITimedCallback;
import com.tencent.component.core.log.LogUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.now.linkpkanchorplay.rankpkhistory.model.RankPKHistoryModel;
import g55.at;
import g55.u;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lwm3/a;", "Landroidx/lifecycle/ViewModel;", "", "pkType", "Landroidx/lifecycle/MutableLiveData;", "Lg55/u;", "O1", "", "roomId", "", "extra", "", "N1", "Lcom/tencent/now/linkpkanchorplay/rankpkhistory/model/RankPKHistoryModel;", "i", "Lcom/tencent/now/linkpkanchorplay/rankpkhistory/model/RankPKHistoryModel;", "rankPKHistoryModel", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "rankLinkPKHistoryLiveData", BdhLogUtil.LogTag.Tag_Conn, "rankNormalPKHistoryLiveData", "<init>", "()V", "D", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RankPKHistoryModel rankPKHistoryModel = new RankPKHistoryModel();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<u> rankLinkPKHistoryLiveData = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<u> rankNormalPKHistoryLiveData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"wm3/a$b", "Lcom/tencent/component/callback/ITimedCallback;", "Lg55/u;", "data", "", "a", "", "code", "", "msg", "fail", WadlProxyConsts.PARAM_TIME_OUT, "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements ITimedCallback<u> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f445829a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f445830b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f445831c;

        b(long j3, int i3, a aVar) {
            this.f445829a = j3;
            this.f445830b = i3;
            this.f445831c = aVar;
        }

        @Override // com.tencent.component.callback.ITimedCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(@NotNull u data) {
            Integer num;
            Intrinsics.checkNotNullParameter(data, "data");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getRankPKHistory success, roomId:");
            sb5.append(this.f445829a);
            sb5.append(", pkType:");
            sb5.append(this.f445830b);
            sb5.append(", size:");
            at[] atVarArr = data.f401395b;
            if (atVarArr != null) {
                num = Integer.valueOf(atVarArr.length);
            } else {
                num = null;
            }
            sb5.append(num);
            LogUtil.i("RankPKHistoryViewModel", sb5.toString(), new Object[0]);
            if (this.f445830b == 2) {
                this.f445831c.rankLinkPKHistoryLiveData.setValue(data);
            } else {
                this.f445831c.rankNormalPKHistoryLiveData.setValue(data);
            }
        }

        @Override // com.tencent.component.callback.ITimedCallback
        public void fail(int code, @Nullable String msg2) {
            LogUtil.e("RankPKHistoryViewModel", "getRankPKHistory fail, code:" + code + ", msg:" + msg2 + ", pkType:" + this.f445830b, new Object[0]);
        }

        @Override // com.tencent.component.callback.ITimedCallback
        public void timeOut() {
            LogUtil.e("RankPKHistoryViewModel", "getRankPKHistory timeOut, pkType:" + this.f445830b, new Object[0]);
        }
    }

    public final void N1(long roomId, @NotNull String extra, int pkType) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        LogUtil.i("RankPKHistoryViewModel", "getRankPKHistory, roomId:" + roomId + ", pkType:" + pkType, new Object[0]);
        this.rankPKHistoryModel.a(roomId, extra, pkType, new b(roomId, pkType, this));
    }

    @NotNull
    public final MutableLiveData<u> O1(int pkType) {
        if (pkType == 2) {
            return this.rankLinkPKHistoryLiveData;
        }
        return this.rankNormalPKHistoryLiveData;
    }
}
