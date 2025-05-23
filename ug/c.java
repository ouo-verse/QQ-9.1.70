package ug;

import android.widget.ImageView;
import com.qzone.module.feedcomponent.ui.common.SuperLikeView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.service.QzoneCustomPraiseService;
import common.config.service.QZoneConfigHelper;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c implements a {
    private boolean e(BusinessFeedData businessFeedData) {
        return ((businessFeedData.isGDTAdvFeed() && businessFeedData.feedType == 2) || !businessFeedData.getFeedCommInfo().canCustomPraise() || businessFeedData.getCellDecorateInfo() == null || businessFeedData.getCellDecorateInfo().cellCustomPraise == null || businessFeedData.getCellDecorateInfo().cellCustomPraise.iItemId <= 0) ? false : true;
    }

    private boolean f(BusinessFeedData businessFeedData) {
        if (businessFeedData.getUser().customPraiseData == null || businessFeedData.getUser().customPraiseData.itemId <= 0) {
            return false;
        }
        return !e(businessFeedData) || businessFeedData.getCellDecorateInfo().cellCustomPraise.iItemId == businessFeedData.getUser().customPraiseData.itemId;
    }

    @Override // ug.a
    public boolean b(boolean z16, BusinessFeedData businessFeedData) {
        return f(businessFeedData) && QZoneConfigHelper.k();
    }

    @Override // ug.a
    public boolean c(BusinessFeedData businessFeedData) {
        return false;
    }

    @Override // ug.a
    public boolean d(SuperLikeView superLikeView, BusinessFeedData businessFeedData) {
        return f(businessFeedData) && QZoneConfigHelper.k();
    }

    @Override // ug.a
    public void a(boolean z16, SuperLikeView superLikeView, BusinessFeedData businessFeedData) {
        if (z16) {
            QzoneCustomPraiseService.i().b(null, superLikeView, businessFeedData.getUser().customPraiseData);
        } else {
            superLikeView.setScaleType(ImageView.ScaleType.FIT_XY);
            superLikeView.setAsyncImage(businessFeedData.getUser().customPraiseData.strPraisePicBefore);
        }
    }
}
