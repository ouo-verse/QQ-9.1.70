package t30;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.helpers.QFSFetchFeedCountsHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class a extends com.tencent.biz.qqcircle.viewmodels.a implements b {

    /* renamed from: m, reason: collision with root package name */
    protected MutableLiveData<UIStateData<List<e30.b>>> f435354m = new MutableLiveData<>();
    private boolean C = false;

    private boolean M1() {
        String tag = getTAG();
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qcircle_config_feedcount_update_black_list", "");
        if (TextUtils.equals(loadAsString, "*")) {
            return false;
        }
        for (String str : loadAsString.split(";")) {
            if (!TextUtils.isEmpty(tag) && TextUtils.equals(str, tag)) {
                return false;
            }
        }
        return true;
    }

    @Override // t30.b
    public int F0() {
        String loadAsString;
        try {
            if (L1() == 1) {
                loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qcircle_config_feed_count_req_limit_double_page", String.valueOf(40));
            } else {
                loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qcircle_config_feed_count_req_limit_default", String.valueOf(20));
            }
            return Integer.parseInt(loadAsString);
        } catch (Exception unused) {
            return 20;
        }
    }

    public int L1() {
        return 0;
    }

    public void N1(MutableLiveData<UIStateData<List<e30.b>>> mutableLiveData) {
        this.f435354m = mutableLiveData;
    }

    public void O1(boolean z16) {
        this.C = z16;
    }

    public boolean R() {
        return this.C;
    }

    public boolean R0() {
        return false;
    }

    public void U0(@NonNull List<e30.b> list) {
        UIStateData<List<e30.b>> dataList = UIStateData.obtainModify().setLoadMore(false).setDataList(list);
        UIStateData<List<e30.b>> value = this.f435354m.getValue();
        if (value != null) {
            dataList.setPos(value.getPos());
            dataList.setFinish(value.getIsFinish());
        }
        this.f435354m.postValue(dataList);
    }

    public boolean Z() {
        return false;
    }

    @Override // t30.b
    public List<e30.b> getFeedList() {
        UIStateData<List<e30.b>> value = this.f435354m.getValue();
        if (value != null && value.getData() != null) {
            return new ArrayList(value.getData());
        }
        return Collections.emptyList();
    }

    @Override // t30.b
    public boolean m1() {
        return M1();
    }

    public void onPause() {
        if (m1()) {
            QFSFetchFeedCountsHelper.n().y();
        }
    }

    public void onResume() {
        if (m1()) {
            QFSFetchFeedCountsHelper.n().x(this);
        }
    }
}
