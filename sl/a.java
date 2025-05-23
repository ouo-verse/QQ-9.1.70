package sl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import com.qzone.common.activities.base.ak;
import com.qzone.reborn.base.k;
import com.qzone.widget.MoodPicLabel;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import fo.c;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends k implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private MoodPicLabel f433938d;

    /* renamed from: e, reason: collision with root package name */
    private b f433939e;

    /* renamed from: f, reason: collision with root package name */
    private String f433940f;

    private void D9(View view) {
        LbsDataV2.PoiInfo value = this.f433939e.O1().getValue();
        Intent l3 = ak.l(getActivity(), QZoneHelper.MOOD_SELECT_LOCATION);
        l3.putExtra("key_from_album", true);
        l3.putExtra("key_current_poi", value);
        l3.putExtra("key_lbs_state", value == null ? 0 : 1);
        getActivity().startActivityForResult(l3, 1208);
    }

    private void E9(LbsDataV2.PoiInfo poiInfo) {
        String str;
        boolean z16 = true;
        QZLog.d("QZoneLocationPart", 1, "onUserPickLocationChange poiInfo:" + poiInfo);
        if (poiInfo == null) {
            str = getContext().getResources().getString(R.string.f2197767b);
            z16 = false;
        } else {
            str = poiInfo.poiName;
        }
        this.f433939e.O1().postValue(poiInfo);
        MoodPicLabel moodPicLabel = this.f433938d;
        if (moodPicLabel != null) {
            moodPicLabel.setText(str);
            this.f433938d.setCheck(z16);
        }
    }

    public void C9(String str) {
        this.f433940f = str;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneLocationPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 != 1208 || i16 != -1 || intent == null || intent.getExtras() == null) {
            return;
        }
        LbsDataV2.PoiInfo poiInfo = (LbsDataV2.PoiInfo) intent.getExtras().getParcelable(QZoneHelper.INDEX_MOOD_SELECT_LOCATION_ITEM_SELECT_POI);
        if (poiInfo == null || TextUtils.isEmpty(poiInfo.poiId) || TextUtils.equals(poiInfo.poiId, "invalide_poi_id")) {
            poiInfo = null;
        }
        E9(poiInfo);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f433938d) {
            D9(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f69213i5);
        if (viewStub != null) {
            MoodPicLabel moodPicLabel = (MoodPicLabel) viewStub.inflate().findViewById(R.id.f0z);
            this.f433938d = moodPicLabel;
            moodPicLabel.setOnClickListener(this);
            if (TextUtils.isEmpty(this.f433940f)) {
                return;
            }
            RFWLog.d("QZoneLocationPart", RFWLog.USR, "bindReport mReportId:" + this.f433940f);
            c.o(this.f433938d, this.f433940f, null);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        this.f433939e = (b) getViewModel(b.class);
    }
}
