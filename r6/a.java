package r6;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qzone.business.plusunion.business.model.AppInfo;
import com.qzone.business.plusunion.ui.QZoneAppIntroActivity;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.logic.presenter.BaseFeedPresenter;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellLeftThumb;
import com.qzone.proxy.feedcomponent.model.CellOperationInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.CellReferInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.ui.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.util.QZLog;
import e8.e;
import e8.f;
import ho.i;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import yo.d;
import yo.g;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: o, reason: collision with root package name */
    private static a f430797o;

    /* renamed from: a, reason: collision with root package name */
    private Context f430798a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f430799b;

    /* renamed from: c, reason: collision with root package name */
    public long f430800c;

    /* renamed from: d, reason: collision with root package name */
    public String f430801d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f430802e;

    /* renamed from: f, reason: collision with root package name */
    public int f430803f;

    /* renamed from: g, reason: collision with root package name */
    public String f430804g;

    /* renamed from: h, reason: collision with root package name */
    public String f430805h;

    /* renamed from: i, reason: collision with root package name */
    public long f430806i;

    /* renamed from: j, reason: collision with root package name */
    private BusinessFeedData f430807j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f430808k = false;

    /* renamed from: l, reason: collision with root package name */
    private long f430809l = -1;

    /* renamed from: m, reason: collision with root package name */
    public String f430810m = "";

    /* renamed from: n, reason: collision with root package name */
    private b f430811n = null;

    /* compiled from: P */
    /* renamed from: r6.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static class C11115a {

        /* renamed from: a, reason: collision with root package name */
        public String f430812a;

        /* renamed from: b, reason: collision with root package name */
        public String f430813b;

        /* renamed from: c, reason: collision with root package name */
        public Long f430814c;

        /* renamed from: d, reason: collision with root package name */
        public int f430815d = 1;

        /* renamed from: e, reason: collision with root package name */
        public boolean f430816e = false;
    }

    a() {
    }

    public static void D(Context context, String str, C11115a c11115a, Boolean bool) {
        if (d(str, c11115a)) {
            if (!TextUtils.isEmpty(str) && (context instanceof Activity)) {
                vo.b.e((Activity) context, str, c11115a.f430813b, c11115a.f430812a, c11115a.f430814c.longValue());
                return;
            }
            int i3 = c11115a.f430815d;
            if ((i3 == 9 || i3 == 8) && !bool.booleanValue()) {
                d.d("mqzone://arouse/album?albumid=" + c11115a.f430813b + "&version=1&source=qq&uin=" + c11115a.f430814c + "&albumtype=" + c11115a.f430815d + "&syncuin=" + LoginData.getInstance().getUin() + "&individualalbum" + (c11115a.f430816e ? 1 : 0), context, null);
                return;
            }
            vo.b.c(context, c11115a.f430813b, c11115a.f430814c, c11115a.f430812a, c11115a.f430815d, c11115a.f430816e);
        }
    }

    public static void G(Context context, String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c.h(context, i3, str, null, 0, new String[0]);
    }

    public static void e(BusinessFeedData businessFeedData, int i3, int i16) {
        if (businessFeedData != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("click_scene", i3 + "");
                jSONObject.put("click_pos", i16 + "");
            } catch (JSONException e16) {
                QZLog.w("BusinessRequestController", "JSON err:" + e16);
            }
            QZoneWriteOperationService.v0().L(businessFeedData.getOperationInfo().cookie, 5001, 0, 0, 0, 0, false, false, null, null, 0L, false, false, jSONObject.toString(), false, businessFeedData);
        }
    }

    public static a o() {
        if (f430797o == null) {
            synchronized (a.class) {
                if (f430797o == null) {
                    f430797o = new a();
                }
            }
        }
        return f430797o;
    }

    private static String q(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("addr=")) {
            return null;
        }
        int indexOf = str.indexOf("addr=");
        int indexOf2 = str.substring(indexOf).indexOf(38);
        if (indexOf2 <= 0) {
            indexOf2 = str.length() - indexOf;
        }
        String substring = str.substring(indexOf + 5, indexOf + indexOf2);
        try {
            return URLDecoder.decode(substring, "UTF-8");
        } catch (Exception unused) {
            return substring;
        }
    }

    private void s() {
        if (this.f430811n == null) {
            this.f430811n = new b();
            f.a().b().g(this.f430811n);
        }
    }

    public static void y(BusinessFeedData businessFeedData, int i3, int i16, int i17, String str) {
        if (businessFeedData.getFeedCommInfo().needAdvReport()) {
            int i18 = (i16 != 22 || businessFeedData.getOperationInfo().actionType == 0) ? i17 : businessFeedData.getOperationInfo().appInstalled ? 1 : 0;
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "send detail click report,gdtfeed_feedkey:" + businessFeedData.getFeedCommInfo().feedskey + " gdtfeed_content:" + businessFeedData.getCellSummary().summary + " index=0");
            QZoneWriteOperationService.v0().L(businessFeedData.getOperationInfo().cookie, i3, 0, 0, i16, i18, true, businessFeedData.getFeedCommInfo().isInstalled, null, null, 0L, false, false, str, false, businessFeedData);
        }
    }

    protected void H(CellLeftThumb cellLeftThumb) {
        long j3;
        String str;
        String str2 = "";
        if (cellLeftThumb == null) {
            return;
        }
        try {
            j3 = Long.parseLong(cellLeftThumb.getPicActionUrl());
        } catch (NumberFormatException e16) {
            QZLog.e("", "LEFT_THUMB_PIC " + e16.toString());
            j3 = 0;
        }
        if (cellLeftThumb.getPictureItem() == null || cellLeftThumb.getPictureItem().musicInfo == null) {
            str = "";
        } else {
            str2 = cellLeftThumb.getPictureItem().musicInfo.musicMid;
            str = cellLeftThumb.getPictureItem().musicInfo.musicNUrl;
        }
        f.a().b().i(new SongInfo(j3, str2, str), cellLeftThumb.getTitle(), cellLeftThumb.getSummary(), c6.a.a(cellLeftThumb));
    }

    public void J(Context context, BusinessFeedData businessFeedData, String str, String str2) {
        boolean f16;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("mqzone://arouse/album") && businessFeedData != null && businessFeedData.getVideoInfo() != null) {
            yo.c.v(context, str);
            return;
        }
        CellFeedCommInfo feedCommInfo = businessFeedData != null ? businessFeedData.getFeedCommInfo() : null;
        boolean isFamousSpaceRecommFeed = feedCommInfo == null ? false : feedCommInfo.isFamousSpaceRecommFeed();
        if (businessFeedData != null && isFamousSpaceRecommFeed) {
            CellOperationInfo operationInfo = businessFeedData.getOperationInfo();
            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportUrlClick(operationInfo == null ? null : operationInfo.qbossTrace, null);
        }
        if (str.startsWith("mqzone://arouse/jumpqq")) {
            Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserDelegationActivity.class);
            intent.putExtra("injectrecommend", true);
            intent.putExtra("url", q(str));
            intent.putExtra("source_name", BaseApplication.getContext().getString(R.string.ghh));
            yo.b.a(intent);
            context.startActivity(intent);
            return;
        }
        ClickReport.c(302, 27, p(businessFeedData), false, null);
        if (businessFeedData != null && businessFeedData.isAdFeeds() && businessFeedData.getVideoInfo() != null) {
            f16 = f(context, businessFeedData, BaseFeedPresenter.U, com.qzone.misc.network.report.f.i(2, 27));
        } else {
            f16 = f(context, businessFeedData, BaseFeedPresenter.U, new Object[0]);
        }
        if (f16) {
            return;
        }
        d.d(str, context, str2);
    }

    public void r(Context context, Handler handler, long j3, String str, boolean z16, int i3, String str2, String str3, long j16, BusinessFeedData businessFeedData) {
        this.f430798a = context;
        this.f430800c = j3;
        this.f430801d = str;
        this.f430802e = z16;
        this.f430803f = i3;
        this.f430804g = str2;
        this.f430805h = str3;
        this.f430808k = false;
        this.f430799b = handler;
        this.f430806i = j16;
        this.f430807j = businessFeedData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class b implements e {
        b() {
        }

        @Override // e8.e
        public void a(e.a aVar) {
            SongInfo songInfo;
            if (aVar == null || (songInfo = aVar.f395852b) == null) {
                return;
            }
            int i3 = aVar.f395854d;
            if (i3 != 1 && i3 != 2) {
                a.this.f430809l = -1L;
                a aVar2 = a.this;
                aVar2.f430810m = "";
                if (aVar2.f430799b != null) {
                    a.this.f430799b.sendEmptyMessage(156);
                    return;
                }
                return;
            }
            if (songInfo.I != 7) {
                long j3 = a.this.f430809l;
                long j16 = aVar.f395852b.f251867d;
                if (j3 != j16) {
                    a.this.f430809l = j16;
                    if (a.this.f430799b != null) {
                        a.this.f430799b.sendEmptyMessage(156);
                        return;
                    }
                    return;
                }
                return;
            }
            if (a.this.f430810m.equals(songInfo.f251870h)) {
                return;
            }
            a aVar3 = a.this;
            aVar3.f430810m = aVar.f395852b.f251870h;
            if (aVar3.f430799b != null) {
                a.this.f430799b.sendEmptyMessage(156);
            }
        }
    }

    public static void K(Context context, long j3) {
        L(context, j3, null);
    }

    public void I() {
        this.f430798a = null;
        this.f430801d = null;
        this.f430802e = false;
        this.f430799b = null;
        this.f430806i = 0L;
        this.f430800c = 0L;
        this.f430807j = null;
    }

    public int j(User user) {
        return k(user, null);
    }

    public static boolean d(String str, C11115a c11115a) {
        String str2;
        if (c11115a == null || (str2 = c11115a.f430813b) == null || TextUtils.isEmpty(str2.trim()) || c11115a.f430812a == null) {
            return false;
        }
        return !TextUtils.isEmpty(str) || c11115a.f430814c.longValue() > 0;
    }

    private String n(CellLeftThumb cellLeftThumb) {
        PictureItem pictureItem;
        PictureUrl pictureUrl;
        if (cellLeftThumb != null && (pictureItem = cellLeftThumb.getPictureItem()) != null && (pictureUrl = pictureItem.bigUrl) != null) {
            return pictureUrl.url;
        }
        return "";
    }

    public void A(Context context, CellLeftThumb cellLeftThumb) {
        if (cellLeftThumb != null && (cellLeftThumb.getActionType() == 2 || cellLeftThumb.getActionType() == 23)) {
            J(context, this.f430807j, cellLeftThumb.getActionUrl(), cellLeftThumb.getPostDatas());
            return;
        }
        if (cellLeftThumb != null && cellLeftThumb.getActionType() == 45) {
            HashMap hashMap = new HashMap();
            hashMap.put("isNativeLikeWebview", Boolean.TRUE);
            d.e(cellLeftThumb.getActionUrl(), context, null, hashMap);
            return;
        }
        t(context, this.f430807j);
    }

    public void g(BusinessFeedData businessFeedData, int i3, View view) {
        if (businessFeedData == null || businessFeedData.getCellAdvContainerAttach() == null || !businessFeedData.isGDTAdvFeed() || businessFeedData.getCellAdvContainerAttach().actiontype != 20) {
            return;
        }
        f(this.f430798a, businessFeedData, 0, new Object[0]);
    }

    public int k(User user, String str) {
        if (user == null) {
            return 0;
        }
        int i3 = user.actiontype;
        if (i3 == 2) {
            d.d(user.actionurl, this.f430798a, null);
            return i3;
        }
        L(this.f430798a, user.uin, str);
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0220  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean f(Context context, BusinessFeedData businessFeedData, int i3, Object... objArr) {
        String str;
        Object obj;
        if (businessFeedData == null || businessFeedData.getOperationInfo().actionType == 0) {
            return false;
        }
        if (businessFeedData.getOperationInfo().actionType == 5 && (context instanceof Activity)) {
            i.z().s(context, businessFeedData.getUser());
        } else if (businessFeedData.getOperationInfo().actionType == 21 && (context instanceof Activity)) {
            h(businessFeedData, -1);
        } else {
            String str2 = null;
            if (businessFeedData.getOperationInfo().actionType == 23) {
                if (businessFeedData.getOperationInfo().userPost == 1 && !TextUtils.isEmpty(businessFeedData.getOperationInfo().postParams)) {
                    str2 = businessFeedData.getOperationInfo().postParams;
                }
                g gVar = new g(businessFeedData.getOperationInfo().schemaPageUrl, str2);
                HashMap hashMap = new HashMap();
                hashMap.put("key1", businessFeedData.getOperationInfo().downloadUrl);
                hashMap.put("key2", businessFeedData.getOperationInfo().click_stream_report);
                hashMap.put("key3", businessFeedData);
                gVar.f450714g = hashMap;
                d.e(businessFeedData.getOperationInfo().schemaPageUrl, context, str2, hashMap);
            } else {
                if (businessFeedData.getOperationInfo().actionType != 2) {
                    return false;
                }
                if (businessFeedData.getOperationInfo().userPost == 1 && !TextUtils.isEmpty(businessFeedData.getOperationInfo().postParams)) {
                    str2 = businessFeedData.getOperationInfo().postParams;
                }
                String str3 = "";
                if (!businessFeedData.getFeedCommInfo().needAdvReport() || businessFeedData.getOperationInfo().downloadUrl == null || objArr == null || objArr.length <= 0 || (obj = objArr[0]) == null || !(obj instanceof View) || TextUtils.isEmpty("")) {
                    str = "";
                } else {
                    str = "&s=";
                }
                if (businessFeedData.getOperationInfo().downloadUrl != null && !businessFeedData.getOperationInfo().downloadUrl.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                    StringBuilder sb5 = new StringBuilder();
                    CellOperationInfo operationInfo = businessFeedData.getOperationInfo();
                    sb5.append(operationInfo.downloadUrl);
                    sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                    operationInfo.downloadUrl = sb5.toString();
                }
                String str4 = businessFeedData.getOperationInfo().cookie.get(0);
                if (businessFeedData.getFeedCommInfo().needAdvReport() && businessFeedData.getOperationInfo().cookie != null && "outlink".equals(str4)) {
                    if (!businessFeedData.isAdFeeds() || businessFeedData.getLocalInfo() == null || !businessFeedData.getLocalInfo().canComment || !businessFeedData.getLocalInfo().canLike) {
                        if (i3 == BaseFeedPresenter.R) {
                            str3 = "&acttype=31";
                        } else if (i3 == BaseFeedPresenter.Q) {
                            str3 = "&acttype=32";
                        } else if (i3 == BaseFeedPresenter.U) {
                            str3 = "&acttype=53";
                        } else {
                            str3 = "&acttype=33";
                        }
                        HashMap hashMap2 = new HashMap();
                        if (businessFeedData.getFeedCommInfo().needAdvReport()) {
                        }
                        if (objArr == null) {
                        }
                        if (!businessFeedData.isGDTAdvFeed()) {
                        }
                        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "send click report,gdtfeed_feedkey:" + businessFeedData.getFeedCommInfo().feedskey + " gdtfeed_content:" + businessFeedData.getCellSummary().summary + " index=0 url=" + businessFeedData.getOperationInfo().downloadUrl + str3 + str);
                    }
                    str3 = "&acttype=55";
                    HashMap hashMap22 = new HashMap();
                    if (businessFeedData.getFeedCommInfo().needAdvReport()) {
                    }
                    if (objArr == null) {
                    }
                    if (!businessFeedData.isGDTAdvFeed()) {
                    }
                    QZLog.i(QZLog.TO_DEVICE_TAG, 1, "send click report,gdtfeed_feedkey:" + businessFeedData.getFeedCommInfo().feedskey + " gdtfeed_content:" + businessFeedData.getCellSummary().summary + " index=0 url=" + businessFeedData.getOperationInfo().downloadUrl + str3 + str);
                } else {
                    if ((businessFeedData.getRecommAction() != null && businessFeedData.getRecommAction().btnType == 2) || "page_outlink".equals(str4)) {
                        if (!businessFeedData.isAdFeeds() || businessFeedData.getLocalInfo() == null || !businessFeedData.getLocalInfo().canComment || !businessFeedData.getLocalInfo().canLike) {
                            if (i3 == BaseFeedPresenter.S) {
                                str3 = "&acttype=30";
                            } else {
                                str3 = "&acttype=29";
                            }
                        }
                        str3 = "&acttype=55";
                    }
                    HashMap hashMap222 = new HashMap();
                    if (businessFeedData.getFeedCommInfo().needAdvReport()) {
                        hashMap222.put("businessFeedData", businessFeedData);
                    }
                    if (objArr == null && objArr.length > 0) {
                        if (!businessFeedData.isGDTAdvFeed()) {
                            d.e(businessFeedData.getOperationInfo().downloadUrl + str3 + str + "&feeds_attachment=" + objArr[0].toString(), context, str2, hashMap222);
                        }
                    } else if (!businessFeedData.isGDTAdvFeed()) {
                        d.e(businessFeedData.getOperationInfo().downloadUrl + str3 + str, context, str2, hashMap222);
                    }
                    QZLog.i(QZLog.TO_DEVICE_TAG, 1, "send click report,gdtfeed_feedkey:" + businessFeedData.getFeedCommInfo().feedskey + " gdtfeed_content:" + businessFeedData.getCellSummary().summary + " index=0 url=" + businessFeedData.getOperationInfo().downloadUrl + str3 + str);
                }
            }
        }
        return true;
    }

    public static void w(BusinessFeedData businessFeedData, int i3, int i16, int i17) {
        if (businessFeedData != null && businessFeedData.getFeedCommInfo().needAdvReport()) {
            int i18 = (i16 != 22 || businessFeedData.getOperationInfo().actionType == 0) ? i17 : businessFeedData.getOperationInfo().appInstalled ? 1 : 0;
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "send detail click report,gdtfeed_feedkey:" + businessFeedData.getFeedCommInfo().feedskey + " gdtfeed_content:" + businessFeedData.getCellSummary().summary + " index=0");
            QZoneWriteOperationService.v0().L(businessFeedData.getOperationInfo().cookie, i3, 0, 0, i16, i18, true, businessFeedData.getFeedCommInfo().isInstalled, null, null, 0L, false, false, null, false, businessFeedData);
        }
    }

    public void F(Context context, BusinessFeedData businessFeedData, int i3, boolean z16, String str) {
        HashMap hashMap;
        if (businessFeedData == null) {
            return;
        }
        CellPictureInfo pictureInfo = businessFeedData.getPictureInfo();
        if (pictureInfo == null && businessFeedData.getOriginalInfoSafe() != null) {
            pictureInfo = businessFeedData.getOriginalInfoSafe().getPictureInfo();
        }
        if (pictureInfo != null) {
            CellPictureInfo pictureInfo2 = businessFeedData.getPictureInfo();
            if (pictureInfo2 == null) {
                pictureInfo2 = pictureInfo;
            }
            int i16 = pictureInfo.actiontype;
            int i17 = pictureInfo2.actiontype;
            if (i17 == 20) {
                if (businessFeedData.isAdFeeds() && businessFeedData.getLocalInfo() != null && businessFeedData.getLocalInfo().canLike && businessFeedData.getLocalInfo().canComment && businessFeedData.getRecommAction() != null && businessFeedData.getRecommAction().isHideActionArea == 0) {
                    f(context, businessFeedData, BaseFeedPresenter.U, com.qzone.misc.network.report.f.i(2, 5));
                } else {
                    f(context, businessFeedData, BaseFeedPresenter.U, new Object[0]);
                }
                int i18 = businessFeedData.getOperationInfo().actionType;
                if (businessFeedData.isAdFeeds()) {
                    return;
                }
                w(this.f430807j, 4, i18, 0);
                return;
            }
            if (i17 == 2) {
                if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(pictureInfo2.actionurl) && businessFeedData.isAppShareCardFeed()) {
                    hashMap = new HashMap();
                    hashMap.put("scene", 2003);
                } else {
                    hashMap = null;
                }
                d.e(pictureInfo2.actionurl, context, null, hashMap);
                w(this.f430807j, 4, i16, 0);
                return;
            }
            BusinessFeedData businessFeedData2 = this.f430807j;
            if (businessFeedData2 != null && businessFeedData2.isAdFeeds() && this.f430807j.getLocalInfo() != null && this.f430807j.getLocalInfo().canLike && this.f430807j.getLocalInfo().canComment) {
                y(this.f430807j, 5001, 0, 0, com.qzone.misc.network.report.f.i(2, 5));
            } else {
                w(this.f430807j, 4, i16, 0);
            }
        }
        if (this.f430803f == 2) {
            return;
        }
        C(context, businessFeedData, i3, z16, str);
    }

    protected void h(BusinessFeedData businessFeedData, int i3) {
        if (businessFeedData == null) {
            return;
        }
        QZoneWriteOperationService.v0().p0(businessFeedData.getUser().uin, !businessFeedData.getFeedCommInfo().isFollowed, 1, this.f430799b, businessFeedData.getFeedCommInfo().feedskey, 0, businessFeedData.getFeedCommInfo().needAdvReport(), businessFeedData.getOperationInfo().cookie, businessFeedData.getFeedCommInfo().isInstalled, businessFeedData, false, i3);
    }

    public void t(Context context, BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getFeedCommInfo().actiontype == 6) {
            return;
        }
        if (businessFeedData.getLeftThumb() == null && (businessFeedData.getOriginalInfoSafe() == null || businessFeedData.getOriginalInfoSafe().getLeftThumb() == null)) {
            if (businessFeedData.getCellSummary().actionType == 20) {
                f(context, businessFeedData, BaseFeedPresenter.U, new Object[0]);
            }
        } else {
            if (businessFeedData.getLeftThumb() != null && !TextUtils.isEmpty(businessFeedData.getLeftThumb().remark)) {
                if (businessFeedData.getLeftThumb().isUsePost()) {
                    J(context, businessFeedData, businessFeedData.getLeftThumb().getActionUrl(), businessFeedData.getLeftThumb().getPostDatas());
                    return;
                } else {
                    J(context, businessFeedData, businessFeedData.getLeftThumb().getActionUrl(), null);
                    return;
                }
            }
            if (businessFeedData.getOriginalInfoSafe().getLeftThumb() == null || TextUtils.isEmpty(businessFeedData.getOriginalInfoSafe().getLeftThumb().remark)) {
                return;
            }
            if (businessFeedData.getOriginalInfoSafe().getLeftThumb().isUsePost()) {
                J(context, businessFeedData, businessFeedData.getOriginalInfoSafe().getLeftThumb().getActionUrl(), businessFeedData.getOriginalInfoSafe().getLeftThumb().getPostDatas());
            } else {
                J(context, businessFeedData, businessFeedData.getOriginalInfoSafe().getLeftThumb().getActionUrl(), null);
            }
        }
    }

    public void z(Context context, CellLeftThumb cellLeftThumb) {
        if (cellLeftThumb == null) {
            return;
        }
        int actionType = cellLeftThumb.getActionType();
        String actionUrl = cellLeftThumb.getActionUrl();
        if (actionType == 14) {
            B(context, this.f430807j, 0, false);
            return;
        }
        if (actionType == 3) {
            try {
                Uri parse = Uri.parse(actionUrl);
                Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                intent.setDataAndType(parse, "video/mp4");
                context.startActivity(intent);
                return;
            } catch (Exception unused) {
                J(context, this.f430807j, actionUrl, cellLeftThumb.getPostDatas());
                return;
            }
        }
        if (actionType == 13) {
            G(context, actionUrl, actionType);
            return;
        }
        if (actionType == 1) {
            t(context, this.f430807j);
            return;
        }
        if (actionType == 0) {
            t(context, this.f430807j);
            return;
        }
        if (actionType == 45) {
            HashMap hashMap = new HashMap();
            hashMap.put("isNativeLikeWebview", Boolean.TRUE);
            d.e(actionUrl, context, null, hashMap);
        } else if (cellLeftThumb.getPicActionType() == 24) {
            s();
            H(cellLeftThumb);
        } else if (33 == cellLeftThumb.getPicActionType()) {
            s();
            f.a().b().e(cellLeftThumb.getPicActionUrl(), cellLeftThumb.getActionUrl(), cellLeftThumb.getTitle(), cellLeftThumb.getSummary(), n(cellLeftThumb));
        } else if (!TextUtils.isEmpty(actionUrl) && actionType != 11 && actionType != 20) {
            J(context, this.f430807j, actionUrl, cellLeftThumb.getPostDatas());
        } else {
            t(context, this.f430807j);
        }
    }

    private String p(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return null;
        }
        if (businessFeedData.isTravelAlbumFeed()) {
            return "7";
        }
        if (businessFeedData.isLoverAlbumData()) {
            return "8";
        }
        if (businessFeedData.isBabyAlbumFeed()) {
            return "6";
        }
        return "5";
    }

    public static void v(Context context, CellReferInfo cellReferInfo) {
        AppInfo appInfo;
        if (cellReferInfo == null) {
            return;
        }
        try {
            appInfo = com.qzone.business.plusunion.business.a.h().e(Integer.valueOf(cellReferInfo.appid).intValue());
        } catch (Exception unused) {
            appInfo = null;
        }
        if (appInfo == null && !TextUtils.isEmpty(cellReferInfo.actionUrl)) {
            if (cellReferInfo.actionUrl.startsWith("mqzone://arouse/app") && !cellReferInfo.actionUrl.contains("from")) {
                cellReferInfo.actionUrl += "&from=detail&appname=" + cellReferInfo.appName;
            }
            d.d(cellReferInfo.actionUrl, context, null);
            return;
        }
        if (com.qzone.business.plusunion.business.a.h().b(appInfo)) {
            com.qzone.business.plusunion.business.a.h().u(context, appInfo);
            return;
        }
        Intent c16 = ak.c(context);
        c16.putExtra(QZoneAppIntroActivity.H, cellReferInfo.appid);
        if (context instanceof Activity) {
            com.qzone.feed.utils.b.e((Activity) context, c16, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARE_FAILED);
        }
    }

    public int i(BusinessFeedData businessFeedData, int i3, Activity activity) {
        if (businessFeedData == null || businessFeedData.getCellBottomRecomm() == null) {
            return 0;
        }
        int i16 = businessFeedData.getCellBottomRecomm().actiontype;
        if (i16 == 20) {
            f(activity, businessFeedData, i3, new Object[0]);
        }
        return i16;
    }

    public int l(BusinessFeedData businessFeedData, int i3, int i16, View view, Activity activity) {
        if (businessFeedData == null || businessFeedData.getRecommAction() == null) {
            return 0;
        }
        int i17 = businessFeedData.getRecommAction().actionType;
        if (businessFeedData.getRecommAction().actionType == 20) {
            int i18 = i16 == BaseFeedPresenter.S ? 8 : 6;
            int i19 = businessFeedData.getOperationInfo().actionType;
            f(activity, businessFeedData, i16, com.qzone.misc.network.report.f.j(2, i18, 0), view, activity);
            return i19;
        }
        if (businessFeedData.getRecommAction().actionType != 21) {
            return i17;
        }
        h(businessFeedData, 2);
        return i17;
    }

    public int m(BusinessFeedData businessFeedData, int i3, int i16, View view, String str) {
        if (businessFeedData == null) {
            return 0;
        }
        int i17 = businessFeedData.getCellUserInfo().actionType;
        if (businessFeedData.getCellUserInfo().actionType == 5) {
            K(this.f430798a, businessFeedData.getUser().uin);
            return i17;
        }
        if (businessFeedData.getCellUserInfo().actionType == 20) {
            if (businessFeedData.isAdFeeds()) {
                f(this.f430798a, businessFeedData, i16, str);
            } else {
                f(this.f430798a, businessFeedData, i16, new Object[0]);
            }
            return businessFeedData.getOperationInfo().actionType;
        }
        if (businessFeedData.getCellUserInfo().actionType == 6) {
            return i17;
        }
        K(this.f430798a, businessFeedData.getUser().uin);
        return i17;
    }

    public static void x(BusinessFeedData businessFeedData, int i3, int i16, int i17, int i18, String str) {
        if (businessFeedData == null || businessFeedData.isGDTAdvFeed() || !businessFeedData.getFeedCommInfo().needAdvReport()) {
            return;
        }
        int i19 = (i16 != 22 || businessFeedData.getOperationInfo().actionType == 0) ? i17 : 0;
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "send detail click report,gdtfeed_feedkey:" + businessFeedData.getFeedCommInfo().feedskey + " gdtfeed_content:" + businessFeedData.getCellSummary().summary + " index=0");
        QZoneWriteOperationService.v0().L(businessFeedData.getOperationInfo().cookie, BaseFeedPresenter.M(businessFeedData, i3, 5), 0, i18, i16, i19, true, businessFeedData.getFeedCommInfo().isInstalled, null, null, 0L, false, false, str, false, businessFeedData);
    }

    public void u(Context context, BusinessFeedData businessFeedData, String str) {
        if (businessFeedData == null) {
            return;
        }
        if (str != null && str.equals("")) {
            t(context, businessFeedData);
        } else if (businessFeedData.getCellSummary().actionType == 20) {
            f(context, businessFeedData, BaseFeedPresenter.U, str);
        }
    }

    private void B(Context context, BusinessFeedData businessFeedData, int i3, boolean z16) {
        C(context, businessFeedData, i3, z16, null);
    }

    private void C(Context context, BusinessFeedData businessFeedData, int i3, boolean z16, String str) {
        String str2;
        ArrayList<Object> detailContent;
        if (!(context instanceof Activity) || businessFeedData == null) {
            return;
        }
        this.f430807j = businessFeedData;
        PhotoParam photoParam = new PhotoParam();
        photoParam.appid = this.f430802e ? 7035 : businessFeedData.getFeedCommInfo().appid;
        photoParam.subid = this.f430807j.getFeedCommInfo().subid;
        photoParam.ownerUin = this.f430807j.getUser().uin;
        photoParam.ugcKey = this.f430807j.getFeedCommInfo().ugckey;
        photoParam.feedUin = this.f430807j.getUser().uin;
        photoParam.isLike = this.f430807j.getLikeInfo().isLiked;
        photoParam.likeNum = this.f430807j.getLikeInfo().likeNum;
        photoParam.commentNum = this.f430807j.getCommentInfo().realCount;
        photoParam.curKey = this.f430807j.getFeedCommInfo().curlikekey;
        photoParam.orgKey = this.f430807j.getFeedCommInfo().orglikekey;
        photoParam.feedId = this.f430807j.getFeedCommInfo().ugckey;
        photoParam.cell_id = this.f430804g;
        photoParam.cell_subId = this.f430805h;
        photoParam.busi_param = this.f430807j.getOperationInfo().busiParam;
        photoParam.isTihFeed = this.f430807j.getFeedCommInfo().isTodayInHistoryFeed();
        User user = new User();
        user.set(businessFeedData.getUser().uin, businessFeedData.getUser().nickName);
        if (businessFeedData.getPictureInfo() != null) {
            if (this.f430808k) {
                return;
            }
            CellPictureInfo pictureInfo = businessFeedData.getPictureInfo();
            if (pictureInfo != null) {
                long j3 = pictureInfo.uin;
                if (j3 >= 10001 && j3 != user.uin) {
                    String str3 = businessFeedData.getUser().nickName;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = pictureInfo.uin + "";
                    }
                    user.set(pictureInfo.uin, str3);
                }
            }
            if (pictureInfo != null) {
                photoParam.albumid = pictureInfo.albumid;
                photoParam.albumnum = pictureInfo.albumnum;
                photoParam.uploadnum = pictureInfo.uploadnum;
            }
            int i16 = photoParam.appid;
            if (i16 != 311 && i16 != 6100) {
                photoParam.ownerUin = user.uin;
            }
            if (i16 == 202) {
                photoParam.ownerUin = this.f430806i;
            }
            this.f430808k = true;
            photoParam.canAddFavor = (this.f430802e || (businessFeedData.getFeedCommInfo().operatemask & 131072) == 0) ? false : true;
            photoParam.qzoneUserType = businessFeedData.getUser().famousSpaceMedal.userTypeReport;
            PictureViewerFactory.M((Activity) context, pictureInfo, businessFeedData.getFeedCommInfo(), i3, photoParam, -1, businessFeedData.getUser().isSafeModeUser != 0, str, null);
            return;
        }
        if ((businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().getDetailContent() != null && businessFeedData.getOriginalInfo().getDetailContent().size() > 0) || (businessFeedData.getDetailContent() != null && businessFeedData.getDetailContent().size() > 0)) {
            if (this.f430808k) {
                return;
            }
            if (businessFeedData.getDetailContent() == null) {
                detailContent = businessFeedData.getOriginalInfo().getDetailContent();
            } else {
                detailContent = businessFeedData.getDetailContent();
            }
            CellPictureInfo cellPictureInfo = new CellPictureInfo();
            cellPictureInfo.pics = new ArrayList<>();
            if (detailContent != null) {
                for (int i17 = 0; i17 < detailContent.size(); i17++) {
                    if (detailContent.get(i17) instanceof PictureItem) {
                        PictureItem pictureItem = (PictureItem) detailContent.get(i17);
                        if (pictureItem.bigUrl.url != null) {
                            cellPictureInfo.pics.add(pictureItem);
                        }
                    }
                }
            }
            long j16 = user.uin;
            if (j16 != 0) {
                photoParam.ownerUin = j16;
            }
            this.f430808k = true;
            photoParam.canAddFavor = (photoParam.appid == 7035 || (businessFeedData.getFeedCommInfo().operatemask & 131072) == 0) ? false : true;
            PictureViewerFactory.M((Activity) context, cellPictureInfo, businessFeedData.getFeedCommInfo(), i3, photoParam, -1, businessFeedData.getUser().isSafeModeUser != 0, str, null);
            return;
        }
        if (businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().getPictureInfo() != null) {
            if (this.f430808k) {
                return;
            }
            CellPictureInfo pictureInfo2 = businessFeedData.getOriginalInfo().getPictureInfo();
            if (pictureInfo2 != null) {
                long j17 = pictureInfo2.uin;
                if (j17 >= 10001 && j17 != user.uin) {
                    String str4 = businessFeedData.getUser().nickName;
                    if (TextUtils.isEmpty(str4)) {
                        str4 = pictureInfo2.uin + "";
                    }
                    user.set(pictureInfo2.uin, str4);
                }
            }
            if (pictureInfo2 != null) {
                photoParam.albumid = pictureInfo2.albumid;
                photoParam.albumnum = pictureInfo2.albumnum;
                photoParam.uploadnum = pictureInfo2.uploadnum;
            }
            int i18 = photoParam.appid;
            if (i18 != 311 && i18 != 6100) {
                photoParam.ownerUin = user.uin;
            }
            if (i18 == 202) {
                photoParam.ownerUin = this.f430806i;
            }
            this.f430808k = true;
            photoParam.canAddFavor = (this.f430802e || (businessFeedData.getFeedCommInfo().operatemask & 131072) == 0) ? false : true;
            PictureViewerFactory.L((Activity) context, pictureInfo2, businessFeedData.getFeedCommInfo(), i3, photoParam, -1, businessFeedData.getUser().isSafeModeUser != 0);
            return;
        }
        if (businessFeedData.getMusicInfo() == null && businessFeedData.getOriginalInfo().getMusicInfo() == null) {
            return;
        }
        if (z16) {
            if (businessFeedData.getOriginalInfo().getMusicInfo() != null) {
                str2 = businessFeedData.getOriginalInfo().getMusicInfo().musicUrl;
            }
            str2 = null;
        } else {
            if (businessFeedData.getMusicInfo() != null) {
                str2 = businessFeedData.getMusicInfo().musicUrl;
            }
            str2 = null;
        }
        if (TextUtils.isEmpty(str2) || this.f430808k) {
            return;
        }
        this.f430808k = true;
        d.d(str2, this.f430798a, null);
    }

    public void E(Context context, BusinessFeedData businessFeedData, int i3, boolean z16) {
        F(context, businessFeedData, i3, z16, null);
    }

    public static void L(Context context, long j3, String str) {
        if (j3 >= 10000 && (context instanceof Activity)) {
            i.z().m(context, j3);
        }
    }
}
