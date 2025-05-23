package tj;

import android.app.Activity;
import android.os.Bundle;
import com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart;
import com.qzone.reborn.intimate.layer.bean.QZIntimateLayerExtraInfoBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.util.ArrayUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\b&\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0004J\b\u0010\u0013\u001a\u00020\u0012H$J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\u0016\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019H\u0014J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0003H\u0014R*\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Ltj/e;", "Lcom/qzone/reborn/albumx/common/layer/part/CommonLayerControlPart;", "Lcom/qzone/reborn/intimate/layer/bean/QZIntimateLayerExtraInfoBean;", "Lsj/b;", "Landroid/os/Bundle;", "data", "", "ha", LocaleUtils.L_JAPANESE, "", "id", "ea", "extraInfoBean", "", "ga", "initIntentData", "Lwj/d;", "ca", "Lsj/c;", "da", "fetchLeft", "fetchRight", "X9", "", "N9", "Lcom/tencent/richframework/data/base/UIStateData;", "uiStateData", "Lo9/e;", "R9", "layerListBean", "ia", "", "J", "Ljava/util/List;", "getInitExtraInfoList", "()Ljava/util/List;", "setInitExtraInfoList", "(Ljava/util/List;)V", "initExtraInfoList", "<init>", "()V", "K", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class e extends CommonLayerControlPart<QZIntimateLayerExtraInfoBean, sj.b> {

    /* renamed from: J, reason: from kotlin metadata */
    private List<QZIntimateLayerExtraInfoBean> initExtraInfoList;

    private final boolean ga(QZIntimateLayerExtraInfoBean extraInfoBean, String id5) {
        return Intrinsics.areEqual(id5, extraInfoBean.getLLoc());
    }

    private final void ja() {
        RFWLayerState data;
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        List<RFWLayerItemMediaInfo> richMediaDataList = (value == null || (data = value.getData()) == null) ? null : data.getRichMediaDataList();
        if (ArrayUtils.isOutOfArrayIndex(0, richMediaDataList)) {
            return;
        }
        Intrinsics.checkNotNull(richMediaDataList);
        for (RFWLayerItemMediaInfo rFWLayerItemMediaInfo : richMediaDataList) {
            String mediaId = rFWLayerItemMediaInfo.getMediaId();
            if (mediaId == null) {
                mediaId = "";
            }
            rFWLayerItemMediaInfo.setExtraData(ea(mediaId));
        }
        getMLayerViewModel().mRichMediaInfo.setValue(getMLayerViewModel().mRichMediaInfo.getValue());
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    protected int N9() {
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    public o9.e R9(UIStateData<sj.b> uiStateData) {
        RFWLayerState data;
        List<RFWLayerItemMediaInfo> richMediaDataList;
        RFWLayerState data2;
        List<RFWLayerItemMediaInfo> richMediaDataList2;
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        o9.e eVar = new o9.e();
        sj.b data3 = uiStateData.getData();
        if (data3 == null) {
            return eVar;
        }
        RFWLayerState rFWLayerState = new RFWLayerState();
        rFWLayerState.setMediaSum(data3.getMediumSum());
        if (data3.getIsDeleteChange()) {
            if (data3.g().isEmpty()) {
                Activity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                }
            } else {
                rFWLayerState.setRichMediaDataList(data3.g());
            }
        } else if (data3.getIsRefresh()) {
            rFWLayerState.setRichMediaDataList(data3.g());
        } else if (data3.getIsFetchLeft()) {
            ArrayList arrayList = new ArrayList(data3.g());
            UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
            if (value != null && (data2 = value.getData()) != null && (richMediaDataList2 = data2.getRichMediaDataList()) != null) {
                arrayList.addAll(richMediaDataList2);
            }
            rFWLayerState.setRichMediaDataList(arrayList);
        } else if (data3.getIsFetchRight()) {
            ArrayList arrayList2 = new ArrayList();
            UIStateData<RFWLayerState> value2 = getMLayerViewModel().mRichMediaInfo.getValue();
            if (value2 != null && (data = value2.getData()) != null && (richMediaDataList = data.getRichMediaDataList()) != null) {
                arrayList2.addAll(richMediaDataList);
            }
            arrayList2.addAll(data3.g());
            rFWLayerState.setRichMediaDataList(arrayList2);
        }
        Y9(data3.getIsLeftFinish());
        aa(data3.getIsRightFinish());
        if (data3.getIsRefresh()) {
            Z9(true);
        }
        ia(data3);
        UIStateData<RFWLayerState> rfwLayerInfoUIStateData = UIStateData.obtainSuccess(false);
        eVar.c(rFWLayerState);
        Intrinsics.checkNotNullExpressionValue(rfwLayerInfoUIStateData, "rfwLayerInfoUIStateData");
        eVar.d(rfwLayerInfoUIStateData);
        String logTag = getLogTag();
        int i3 = RFWLog.USR;
        List<RFWLayerItemMediaInfo> richMediaDataList3 = rFWLayerState.getRichMediaDataList();
        Integer valueOf = richMediaDataList3 != null ? Integer.valueOf(richMediaDataList3.size()) : null;
        RFWLog.i(logTag, i3, "media list size is " + valueOf + " is refresh " + data3.getIsRefresh());
        return eVar;
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    public void X9(boolean fetchLeft, boolean fetchRight) {
        wj.d ca5 = ca();
        sj.c da5 = da();
        da5.m(fetchLeft);
        da5.n(fetchRight);
        da5.q(fetchLeft && fetchRight);
        ca5.U1(da5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final wj.d ca() {
        q9.a<sj.b> L9 = L9();
        Intrinsics.checkNotNull(L9, "null cannot be cast to non-null type com.qzone.reborn.intimate.layer.viewmodel.QZIntimateBaseLayerDataViewModel");
        return (wj.d) L9;
    }

    protected abstract sj.c da();

    protected void ia(sj.b layerListBean) {
        Intrinsics.checkNotNullParameter(layerListBean, "layerListBean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart, com.qzone.reborn.albumx.common.layer.part.i
    public void initIntentData(Bundle data) {
        super.initIntentData(data);
        Serializable serializable = data != null ? data.getSerializable("key_init_data_list") : null;
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type java.util.ArrayList<com.qzone.reborn.intimate.layer.bean.QZIntimateLayerExtraInfoBean>{ kotlin.collections.TypeAliasesKt.ArrayList<com.qzone.reborn.intimate.layer.bean.QZIntimateLayerExtraInfoBean> }");
        this.initExtraInfoList = (ArrayList) serializable;
        ha(data);
        ja();
    }

    private final QZIntimateLayerExtraInfoBean ea(String id5) {
        if (ArrayUtils.isOutOfArrayIndex(0, this.initExtraInfoList)) {
            return null;
        }
        List<QZIntimateLayerExtraInfoBean> list = this.initExtraInfoList;
        Intrinsics.checkNotNull(list);
        for (QZIntimateLayerExtraInfoBean qZIntimateLayerExtraInfoBean : list) {
            if (ga(qZIntimateLayerExtraInfoBean, id5)) {
                return qZIntimateLayerExtraInfoBean;
            }
        }
        return null;
    }

    private final void ha(Bundle data) {
        if (data != null) {
            if (data.containsKey("key_feed_id")) {
                wj.d ca5 = ca();
                Object obj = data.get("key_feed_id");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                ca5.W1((String) obj);
            }
            if (data.containsKey("key_space_type")) {
                wj.d ca6 = ca();
                Object obj2 = data.get("key_space_type");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                ca6.a2(((Integer) obj2).intValue());
            }
            String str = "";
            if (data.containsKey("key_space_id")) {
                wj.d ca7 = ca();
                String string = data.getString("key_space_id");
                if (string == null) {
                    string = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(string, "it.getString(QZoneIntima\u2026ncher.KEY_SPACE_ID) ?: \"\"");
                }
                ca7.Z1(string);
            }
            if (data.containsKey("key_attach_info")) {
                wj.d ca8 = ca();
                String string2 = data.getString("key_attach_info");
                if (string2 != null) {
                    Intrinsics.checkNotNullExpressionValue(string2, "it.getString(QZoneIntima\u2026er.KEY_ATTACH_INFO) ?: \"\"");
                    str = string2;
                }
                ca8.X1(str);
            }
        }
    }
}
