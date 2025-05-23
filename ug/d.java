package ug;

import android.app.Activity;
import android.text.TextUtils;
import com.qzone.module.feedcomponent.ui.common.SuperLikeView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CustomPraiseData;
import com.qzone.proxy.feedcomponent.service.QzoneCustomPraiseService;
import com.qzone.reborn.feedx.util.ad;
import com.tencent.mobileqq.vas.VasToggle;
import common.config.service.QZoneConfigHelper;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d implements a {

    /* renamed from: a, reason: collision with root package name */
    private final ad f438920a = new ad();

    /* renamed from: b, reason: collision with root package name */
    private Activity f438921b;

    public d(Activity activity) {
        this.f438921b = activity;
    }

    private boolean e(BusinessFeedData businessFeedData) {
        return ((businessFeedData.isGDTAdvFeed() && businessFeedData.feedType == 2) || !businessFeedData.getFeedCommInfo().canCustomPraise() || businessFeedData.getCellDecorateInfo() == null || businessFeedData.getCellDecorateInfo().cellCustomPraise == null || businessFeedData.getCellDecorateInfo().cellCustomPraise.iItemId <= 0 || businessFeedData.getCellDecorateInfo().cellCustomPraise.subType == 4) ? false : true;
    }

    @Override // ug.a
    public boolean b(boolean z16, BusinessFeedData businessFeedData) {
        if (!QZoneConfigHelper.m()) {
            return false;
        }
        if (z16) {
            return e(businessFeedData);
        }
        return (xe.a.f447839a.c() || businessFeedData.getUser().customPraiseData == null || businessFeedData.getUser().customPraiseData.itemId <= 0 || TextUtils.isEmpty(businessFeedData.getUser().customPraiseData.strPraisePicBefore)) ? false : true;
    }

    @Override // ug.a
    public boolean c(BusinessFeedData businessFeedData) {
        if (VasToggle.BUG_105413094.isEnable(false)) {
            return (businessFeedData.getFeedCommInfo().canCustomPraise() && QzoneCustomPraiseService.i().g() != null) || !(!businessFeedData.isGDTAdvFeed() || businessFeedData.getCellDecorateInfo() == null || com.qzone.proxy.feedcomponent.service.a.b().c(businessFeedData.getCellDecorateInfo().cellCustomPraise) == null);
        }
        return false;
    }

    @Override // ug.a
    public boolean d(SuperLikeView superLikeView, BusinessFeedData businessFeedData) {
        CustomPraiseData g16;
        if (QZoneConfigHelper.m() && !superLikeView.isSelected() && businessFeedData != null) {
            if (businessFeedData.isGDTAdvFeed()) {
                g16 = (businessFeedData.getCellDecorateInfo() == null || businessFeedData.getCellDecorateInfo().cellCustomPraise == null) ? null : com.qzone.proxy.feedcomponent.service.a.b().c(businessFeedData.getCellDecorateInfo().cellCustomPraise);
            } else {
                g16 = QzoneCustomPraiseService.i().g();
            }
            if (businessFeedData.getUser().customPraiseData != null && businessFeedData.getUser().customPraiseData.itemId > 0) {
                g16 = businessFeedData.getUser().customPraiseData;
            }
            if (g16 != null) {
                this.f438920a.j(businessFeedData, superLikeView, this.f438921b);
                superLikeView.setAsyncImage(g16.praiseIconUrl);
                return true;
            }
        }
        return false;
    }

    @Override // ug.a
    public void a(boolean z16, SuperLikeView superLikeView, BusinessFeedData businessFeedData) {
        if (z16) {
            superLikeView.setAsyncImage(businessFeedData.getCellDecorateInfo().cellCustomPraise.strPraiseButton);
        } else {
            superLikeView.setAsyncImage(businessFeedData.getUser().customPraiseData.strPraisePicBefore);
        }
    }
}
