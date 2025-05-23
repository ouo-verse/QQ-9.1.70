package ri3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerData;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerOpRspData;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerUiData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zplan.minihome.MapMode;
import com.tencent.mobileqq.zplan.minihome.ad;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fR\"\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00060\u00060\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\t0\t0\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0012R\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u00148\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018R$\u0010 \u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\f0\f0\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0012R\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u00148\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u0018R$\u0010&\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010$0$0\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u0012R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020$0\u00148\u0006\u00a2\u0006\f\n\u0004\b'\u0010\u0016\u001a\u0004\b(\u0010\u0018\u00a8\u0006."}, d2 = {"Lri3/c;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/zplan/minihome/MapMode;", "newMode", "", "S1", "Lri3/b;", "newModeInfo", "R1", "Lcom/tencent/filament/zplan/scene/xwconnect/data/e;", "newData", "Q1", "Lri3/a;", "opRsp", "P1", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "i", "Landroidx/lifecycle/MutableLiveData;", "_mapModeInfo", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "O1", "()Landroidx/lifecycle/LiveData;", "mapModeInfo", BdhLogUtil.LogTag.Tag_Conn, "_flowerUiData", "D", "N1", "flowerUiData", "E", "_flowerOpResult", UserInfo.SEX_FEMALE, "M1", "flowerOpResult", "Lcom/tencent/filament/zplan/scene/xwconnect/data/b;", "G", "_flowerData", "H", "L1", "flowerData", "<init>", "()V", "I", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private MutableLiveData<FlowerUiData> _flowerUiData;

    /* renamed from: D, reason: from kotlin metadata */
    private final LiveData<FlowerUiData> flowerUiData;

    /* renamed from: E, reason: from kotlin metadata */
    private MutableLiveData<FlowerOpRsp> _flowerOpResult;

    /* renamed from: F, reason: from kotlin metadata */
    private final LiveData<FlowerOpRsp> flowerOpResult;

    /* renamed from: G, reason: from kotlin metadata */
    private MutableLiveData<FlowerData> _flowerData;

    /* renamed from: H, reason: from kotlin metadata */
    private final LiveData<FlowerData> flowerData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<MapModeInfo> _mapModeInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<MapModeInfo> mapModeInfo;

    public c() {
        MutableLiveData<MapModeInfo> mutableLiveData = new MutableLiveData<>(new MapModeInfo(MapMode.UNKNOWN, null, null, null, 14, null));
        this._mapModeInfo = mutableLiveData;
        this.mapModeInfo = mutableLiveData;
        MutableLiveData<FlowerUiData> mutableLiveData2 = new MutableLiveData<>(new FlowerUiData(null, null, null, null, 0.0f, 31, null));
        this._flowerUiData = mutableLiveData2;
        this.flowerUiData = mutableLiveData2;
        MutableLiveData<FlowerOpRsp> mutableLiveData3 = new MutableLiveData<>(new FlowerOpRsp(null, null, 3, null));
        this._flowerOpResult = mutableLiveData3;
        this.flowerOpResult = mutableLiveData3;
        byte b16 = 0 == true ? 1 : 0;
        MutableLiveData<FlowerData> mutableLiveData4 = new MutableLiveData<>(new FlowerData(0 == true ? 1 : 0, null, b16, 7, null));
        this._flowerData = mutableLiveData4;
        this.flowerData = mutableLiveData4;
    }

    public final LiveData<FlowerData> L1() {
        return this.flowerData;
    }

    public final LiveData<FlowerOpRsp> M1() {
        return this.flowerOpResult;
    }

    public final LiveData<FlowerUiData> N1() {
        return this.flowerUiData;
    }

    public final LiveData<MapModeInfo> O1() {
        return this.mapModeInfo;
    }

    public final void P1(FlowerOpRsp opRsp) {
        FlowerData flowerData;
        Intrinsics.checkNotNullParameter(opRsp, "opRsp");
        QLog.i("MiniHomeConnectedViewModel", 1, "postUpdateFlowerOpResult, newData: " + opRsp);
        this._flowerOpResult.postValue(opRsp);
        FlowerOpRspData data = opRsp.getData();
        if (data == null || (flowerData = data.getFlowerData()) == null) {
            return;
        }
        this._flowerData.postValue(flowerData);
    }

    public final void Q1(FlowerUiData newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        QLog.i("MiniHomeConnectedViewModel", 1, "postUpdateFlowerUiData, newData: " + newData);
        this._flowerUiData.postValue(newData);
        this._flowerData.postValue(newData.getFlowerData());
    }

    public final void R1(MapModeInfo newModeInfo) {
        MapMode mode;
        Intrinsics.checkNotNullParameter(newModeInfo, "newModeInfo");
        QLog.i("MiniHomeConnectedViewModel", 1, "postUpdateMapMode2, newMode(mode: " + newModeInfo.getMode() + ", hostUin: " + newModeInfo.getHostUin() + ", hostHaveOwnRoom: " + newModeInfo.getHostHaveOwnRoom() + ")");
        if (newModeInfo.getMode() != MapMode.GLOBAL && (newModeInfo.getHostUin() == null || newModeInfo.getHostUin().longValue() < 0)) {
            QLog.e("MiniHomeConnectedViewModel", 1, "postUpdateMapMode failed, newModeInfo.mode: " + newModeInfo.getMode());
            return;
        }
        MapModeInfo value = this.mapModeInfo.getValue();
        boolean z16 = false;
        if (value != null && (mode = value.getMode()) != null && mode.getValue() == newModeInfo.getMode().getValue()) {
            z16 = true;
        }
        if (z16) {
            MapModeInfo value2 = this.mapModeInfo.getValue();
            if (Intrinsics.areEqual(value2 != null ? value2.getHostUin() : null, newModeInfo.getHostUin())) {
                QLog.e("MiniHomeConnectedViewModel", 1, "postUpdateMapMode failed, mode same: " + newModeInfo.getMode());
                return;
            }
        }
        S1(newModeInfo.getMode());
        this._mapModeInfo.postValue(newModeInfo);
    }

    private final void S1(MapMode newMode) {
        Map mapOf;
        MapMode mode;
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        MapModeInfo value = this.mapModeInfo.getValue();
        pairArr[1] = TuplesKt.to("zplan_before_state", (value == null || (mode = value.getMode()) == null) ? null : Integer.valueOf(ad.a(mode)));
        pairArr[2] = TuplesKt.to("zplan_after_state", Integer.valueOf(ad.a(newMode)));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        VideoReport.reportEvent("ev_zplan_map_state_change", mapOf);
    }
}
