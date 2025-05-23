package xg;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.logic.clickprocessor.BaseFeedClickProcessor;
import com.qzone.module.feedcomponent.ui.TitleAttachArea;
import com.qzone.personalize.model.CustomHighFiveData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellDecorateInfo;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.CustomPraiseData;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.service.QzoneCustomPraiseService;
import com.qzone.reborn.feedx.util.ad;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e {
    private void b(BusinessFeedData businessFeedData, boolean z16) {
        CustomPraiseData g16;
        businessFeedData.getLikeInfo().isLiked = z16;
        ArrayList<CellLikeInfo.LikeMan> arrayList = businessFeedData.getLikeInfo().likeMans;
        businessFeedData.getLikeInfoV2().isFakeOperation = true;
        int i3 = 0;
        if (z16) {
            User user = new User();
            user.uin = LoginData.getInstance().getUin();
            user.nickName = LoginData.getInstance().getNickName(null);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<CellLikeInfo.LikeMan> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().user.uin == LoginData.getInstance().getUin()) {
                        return;
                    }
                }
            } else {
                arrayList = new ArrayList<>();
                businessFeedData.getLikeInfo().likeMans = arrayList;
            }
            if (businessFeedData.isGDTAdvFeed()) {
                g16 = (businessFeedData.getCellDecorateInfo() == null || businessFeedData.getCellDecorateInfo().cellCustomPraise == null) ? null : com.qzone.proxy.feedcomponent.service.a.b().c(businessFeedData.getCellDecorateInfo().cellCustomPraise);
            } else {
                g16 = QzoneCustomPraiseService.i().g();
                if (businessFeedData.getUser().customPraiseData != null && businessFeedData.getUser().customPraiseData.itemId != -1) {
                    g16 = businessFeedData.getUser().customPraiseData;
                }
            }
            if (g16 != null) {
                if (g16.praiseType == 1) {
                    g16.comboCount = 20L;
                }
                arrayList.add(0, new CellLikeInfo.LikeMan(user, 2, g16));
                if (!businessFeedData.isGDTAdvFeed()) {
                    CellDecorateInfo cellDecorateInfo = businessFeedData.getCellDecorateInfo();
                    if (cellDecorateInfo == null) {
                        cellDecorateInfo = new CellDecorateInfo();
                    }
                    cellDecorateInfo.cellCustomPraise = g16.toCellCustomPraise();
                    cellDecorateInfo.cellPolymorphicPraise = null;
                    businessFeedData.cellDecorateInfo = cellDecorateInfo;
                }
            } else {
                if (businessFeedData.cellDecorateInfo != null && !businessFeedData.isGDTAdvFeed()) {
                    CellDecorateInfo cellDecorateInfo2 = businessFeedData.cellDecorateInfo;
                    cellDecorateInfo2.cellCustomPraise = null;
                    cellDecorateInfo2.cellPolymorphicPraise = null;
                }
                arrayList.add(0, new CellLikeInfo.LikeMan(user, 0, null));
            }
            businessFeedData.getLikeInfo().likeNum++;
        } else if (businessFeedData.isSecretFeed()) {
            if (arrayList != null) {
                arrayList.clear();
            }
            if (!businessFeedData.cellLikeInfo.isLiked) {
                businessFeedData.getLikeInfo().likeNum--;
            }
        } else if (arrayList != null) {
            while (true) {
                if (i3 >= arrayList.size()) {
                    break;
                }
                if (arrayList.get(i3).user.uin == LoginData.getInstance().getUin()) {
                    arrayList.remove(i3);
                    d(businessFeedData);
                    break;
                }
                i3++;
            }
        }
        if (businessFeedData.getFeedCommInfo().isBizRecomFeeds() && businessFeedData.getCellCount() != null && businessFeedData.getCellCount().type == 1) {
            if (businessFeedData.getLikeInfo().isLiked) {
                businessFeedData.getCellCount().num++;
            } else {
                businessFeedData.getCellCount().num--;
            }
        }
        QLog.d("QZoneFeedLikeClickProcess", 1, "operateLikeFakeInfo  | businessfeedData.getLikeInfo().likeNum = " + businessFeedData.getLikeInfo().likeNum);
    }

    public void c(BusinessFeedData businessFeedData, boolean z16, Activity activity) {
        int i3;
        QZoneWriteOperationService.m mVar = new QZoneWriteOperationService.m();
        mVar.f45734a = businessFeedData.getFeedCommInfo().ugckey;
        mVar.f45735b = businessFeedData.getFeedCommInfo().curlikekey;
        mVar.f45736c = businessFeedData.getFeedCommInfo().orglikekey;
        mVar.f45738e = z16;
        boolean z17 = false;
        mVar.f45747n = User.getLikeType(0, z16);
        mVar.f45739f = businessFeedData.getFeedCommInfo().appid;
        Map<Integer, String> map = businessFeedData.getOperationInfo().busiParam;
        if (map != null) {
            mVar.f45740g = new HashMap(map);
        }
        mVar.f45742i = -1;
        mVar.f45744k = businessFeedData.getFeedCommInfo().isTodayInHistoryFeed();
        mVar.f45746m = 0;
        mVar.f45754u = businessFeedData;
        mVar.f45755v = businessFeedData.feedType;
        mVar.f45759z = false;
        if (BaseFeedClickProcessor.y(businessFeedData) && businessFeedData.getUser() != null) {
            z17 = true;
        }
        if (z17) {
            mVar.f45737d = businessFeedData.getFeedCommInfo().feedskey;
            if (TitleAttachArea.showHigh5Button(businessFeedData)) {
                mVar.f45750q = true;
            } else if (TitleAttachArea.canMultipleHighFive(businessFeedData) && TitleAttachArea.showMultipleHighFiveIcon(businessFeedData)) {
                mVar.f45751r = true;
            }
            mVar.f45752s = businessFeedData.getUser().uin;
            if (mVar.f45753t == null) {
                mVar.f45753t = new HashMap();
            }
            mVar.f45753t.put("praise_ctime", String.valueOf(businessFeedData.getFeedCommInfo().getTime() / 1000));
            if (businessFeedData.getCellDecorateInfo() != null && businessFeedData.getCellDecorateInfo().cellCustomPraise != null && businessFeedData.getCellDecorateInfo().cellCustomPraise.uiComboCount > 0) {
                r3 = CustomPraiseData.createFrom(businessFeedData.getCellDecorateInfo().cellCustomPraise);
                mVar.f45749p = (int) r3.comboCount;
                if (businessFeedData.getFeedCommInfo().extendInfo != null) {
                    r3.praiseSummery = businessFeedData.getFeedCommInfo().extendInfo.get("custom_praise_document");
                }
            }
            if (businessFeedData.getCellHighFiveInfo() != null) {
                mVar.f45753t.put("high_five_combo_counts", String.valueOf(businessFeedData.getCellHighFiveInfo().highFiveCount));
                CustomHighFiveData e16 = com.qzone.personalize.business.b.n().e(LoginData.getInstance().getUin());
                if (e16 != null && (i3 = e16.itemId) != -1) {
                    mVar.f45753t.put("personal_like_id", String.valueOf(i3));
                }
            } else {
                w5.b.i("QZoneFeedLikeClickProcess", 1, "[highFive].onLikeClick, combo_counts was not delivered to server");
            }
            mVar.f45753t.put("high_five_from", "1");
            mVar.f45753t.put("high_five_to", "1");
        } else {
            r3 = businessFeedData.getFeedCommInfo().canCustomPraise() ? QzoneCustomPraiseService.i().g() : null;
            CustomPraiseData b16 = ug.b.f438918a.b();
            if (businessFeedData.getUser().customPraiseData != null && businessFeedData.getUser().customPraiseData.itemId != -1) {
                r3 = businessFeedData.getUser().customPraiseData;
            }
            if (r3 == null && b16 != null) {
                r3 = b16;
            }
        }
        mVar.f45748o = r3;
        QZoneWriteOperationService.v0().u1(new a(), mVar);
        ad.e(businessFeedData, r3, z16, z17, activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            QZoneResult unpack = QZoneResult.unpack(message);
            if (message.what == 999906) {
                a(unpack);
            }
        }

        private void a(QZoneResult qZoneResult) {
            if (qZoneResult == null || qZoneResult.getSucceed()) {
                return;
            }
            c6.a.i(qZoneResult.getMessage());
        }
    }

    private void d(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getLikeInfoV2() == null || businessFeedData.getFeedCommInfo() == null) {
            return;
        }
        CellLikeInfo likeInfo = businessFeedData.getLikeInfo();
        likeInfo.likeNum--;
    }

    public void a(BusinessFeedData businessFeedData, Activity activity) {
        if (businessFeedData == null || !businessFeedData.getLocalInfo().canLike || businessFeedData.getIdInfo() == null || TextUtils.isEmpty(businessFeedData.getIdInfo().cellId)) {
            return;
        }
        boolean z16 = !businessFeedData.getLikeInfo().isLiked;
        businessFeedData.getLikeInfo().stateChanged = !z16;
        b(businessFeedData, z16);
        ze.a.a().initOrUpdateGlobalState((ze.a) new af.c(ef.b.a(businessFeedData), businessFeedData.cellLikeInfo), true);
        c(businessFeedData, z16, activity);
    }
}
