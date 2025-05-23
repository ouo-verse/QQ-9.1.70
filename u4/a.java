package u4;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.qzone.adapter.feedcomponent.e;
import com.qzone.album.base.Service.QzoneAlbumPicDownloadService;
import com.qzone.album.business.albumlist.activity.QZonePersonalAlbumActivity;
import com.qzone.album.business.photolist.activity.QZonePersonalPhotoListActivity;
import com.qzone.album.data.AlbumCacheDataManager;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.AlbumSocialInfoCacheData;
import com.qzone.album.data.model.LoveAlbumTimeEvent;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.PhotoPoiArea;
import com.qzone.album.data.model.PoiInfo;
import com.qzone.album.data.model.PublicShareCacheData;
import com.qzone.album.data.model.TravelAlbumData;
import com.qzone.app.ImageEnvImpl;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.FeedActionPanelActivity;
import com.qzone.common.activities.base.ak;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.misc.network.downloader.i;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.preview.BasePictureViewer;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.qzone.util.ToastUtil;
import com.qzone.util.ar;
import com.qzone.util.image.NetImageInfo;
import com.qzone.util.l;
import com.qzone.util.p;
import com.qzone.util.v;
import com.qzone.util.x;
import com.qzone.widget.QzoneGuideBubbleHelper;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.sharpP.SharpPUtils;
import com.tencent.widget.AbsListView;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.model.LocalImageShootInfo;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends b {

    /* renamed from: b, reason: collision with root package name */
    private static a f438204b;

    public static a z() {
        if (f438204b == null) {
            f438204b = new a();
        }
        return f438204b;
    }

    public boolean A(String str, boolean z16) {
        return u5.b.D(str, z16);
    }

    public Context B() {
        return BaseApplication.getContext();
    }

    public int C() {
        return u5.a.b();
    }

    public com.qzone.album.base.Service.b D() {
        return com.qzone.album.base.Service.c.G();
    }

    public e.a E() {
        return com.qzone.album.base.Service.c.G().F();
    }

    public int F(String str, int i3, long j3) {
        return LocalMultiProcConfig.getInt4Uin(str, i3, j3);
    }

    public int G() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONESETTINGS_SHAREMAXSELECTCOUNT, 30);
    }

    public int H() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONESETTINGS_MULTISHAREMAXCOUNR, 99);
    }

    public Intent J(Activity activity, String str, String str2, Long l3, String str3, Map<Integer, String> map, int i3, String str4, int i16, boolean z16) {
        return ak.H(activity, str, str2, l3, str3, map, i3, str4, i16, z16);
    }

    public Resources K() {
        return BaseApplication.getContext().getResources();
    }

    public String L(String str, String str2) {
        return u5.b.h0(str, str2);
    }

    public void M(Activity activity, String str, Bundle bundle) {
        Intent i3 = ak.i(activity, str, "");
        if (bundle != null) {
            i3.putExtras(bundle);
        }
        com.qzone.feed.utils.b.e(activity, i3, 1);
    }

    public void N(Activity activity, String str, long j3, long j16, PublicShareCacheData publicShareCacheData) {
        Intent M = ak.M(activity, str, j3, j16);
        if (publicShareCacheData != null) {
            M.putExtra("hasInviteTroopSetting", true);
            M.putExtra("inviteTroopCover", publicShareCacheData.cover);
            M.putExtra("inviteTroopDesc", publicShareCacheData.desc);
            M.putExtra("inviteTroopH5Url", publicShareCacheData.h5url);
            M.putExtra("inviteTroopSchema", publicShareCacheData.schema);
        }
        com.qzone.feed.utils.b.e(activity, M, 20);
    }

    public void O(int i3) {
        AlbumCacheDataManager.J().X(LoginData.getInstance().getUin());
        AlbumCacheDataManager.J().Y(LoginData.getInstance().getUin(), i3);
    }

    public String P(String str) {
        return BasePictureViewer.p4(str);
    }

    public void Q(Activity activity, String str) {
        vo.c.C(activity, LoginData.getInstance().getUin(), str, "photolist", -1);
    }

    public void R(Activity activity, long j3, String str, int i3, String str2, int i16) {
        vo.c.B(activity, j3, str, i3, str2, i16);
    }

    public void S(Activity activity, AlbumCacheData albumCacheData) {
        if (!(activity instanceof QZonePersonalPhotoListActivity)) {
            throw new RuntimeException("jumpToAlbumRecomPhotoList | is not jump from QZonePersonalPhotoListActivity or QZoneRecommendAlbumListActivity");
        }
        if (albumCacheData == null || activity == null) {
            return;
        }
        com.qzone.feed.utils.b.d(activity, t4.a.N().P(activity, albumCacheData, albumCacheData.ownerUin));
        int albumThemeTypeValue = albumCacheData.getAlbumThemeTypeValue();
        if (albumThemeTypeValue == 1) {
            ClickReport.r("", "", "", true, "56", "1");
        } else if (albumThemeTypeValue == 8) {
            ClickReport.r("", "", "", true, "56", "2");
        } else {
            if (albumThemeTypeValue != 9) {
                return;
            }
            ClickReport.r("", "", "", true, "56", "3");
        }
    }

    public void T(Activity activity, long j3, String str) {
        String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.QZONE_ALBUM_COMMENTS_URL, "https://h5.qzone.qq.com/album/comment/{aid}/{uin}/ac?_wv=1027&_proxy=1");
        if (!TextUtils.isEmpty(config)) {
            config = yo.f.j(yo.f.w(yo.f.t(config), j3), "{aid}", str);
        }
        yo.d.b(activity, new yo.g(config));
    }

    public void U(Activity activity, long j3, String str) {
        String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_ALBUM_LIKE_LIST, "https://qzs.qzone.qq.com/qzone/hybrid/module/albumlike/index.html?_bid=364&hostuin={uin}&aid={aid}&QUA={QUA}&starttime={starttime}&islike=1");
        if (!TextUtils.isEmpty(config)) {
            config = yo.f.j(yo.f.w(yo.f.t(config), j3), "{aid}", str);
        }
        yo.d.b(activity, new yo.g(config));
    }

    public void V(Context context, Long l3, String str) {
        String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.QZONE_ALBUM_VISITORS_URL, "https://qzs.qzone.qq.com/qzone/hybrid/module/albumvisitor/index.html?hostuin={uin}&aid={aid}&QUA={QUA}&starttime={starttime}&_wv=1027");
        if (!TextUtils.isEmpty(config)) {
            config = yo.f.j(yo.f.j(yo.f.w(yo.f.t(config), l3.longValue()), "{aid}", str), "{starttime}", String.valueOf(((float) System.currentTimeMillis()) / 1000.0f));
        }
        yo.d.b(context, new yo.g(config));
    }

    public void X(Handler handler, String str, AlbumSocialInfoCacheData albumSocialInfoCacheData) {
        QZoneWriteOperationService.m mVar = new QZoneWriteOperationService.m();
        mVar.f45734a = str;
        String str2 = albumSocialInfoCacheData.albumLikeKey;
        mVar.f45735b = str2;
        mVar.f45736c = str2;
        mVar.f45738e = !albumSocialInfoCacheData.isLiked;
        mVar.f45739f = 4;
        QZoneWriteOperationService.v0().u1(handler, mVar);
    }

    public void Y(Activity activity, Context context, String str) {
        ClickReport.r("", "", "", true, "328", "16", "2");
        com.qzone.feed.utils.b.e(activity, ak.r(context, "jhan_xiangce", str, false, LoginData.getInstance().getUin(), LoginData.getInstance().isQzoneVip()), 5);
    }

    public void a0(Activity activity, boolean z16) {
        Intent intent = new Intent(activity, (Class<?>) FeedActionPanelActivity.class);
        intent.putExtra("extraRequestCode", 9);
        if (z16) {
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.SHOW_KEY_ICON, FeedActionPanelActivity.J1);
        } else {
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.SHOW_KEY_ICON, FeedActionPanelActivity.I1);
        }
        intent.putExtra("extrauserapidcomment", false);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_SYSTEM_TRANSPARENTBAR, 0);
        com.qzone.feed.utils.b.e(activity, intent, 9);
    }

    public void b(Activity activity, PhotoPoiArea photoPoiArea, Long l3) {
        Intent intent = new Intent(activity, (Class<?>) FeedActionPanelActivity.class);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.FEED_TEXT_AUTOFILL_INTENT_KEY, photoPoiArea.description);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.NEEDTRANSEMOJ, 1);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY, l3 + "_" + photoPoiArea.hashCode());
        intent.putExtra("inputmax", 500);
        intent.putExtra("showaticon", 0);
        intent.putExtra("canVertical", true);
        com.qzone.feed.utils.b.e(activity, intent, 7);
    }

    public void b0(Activity activity, Bundle bundle) {
        Intent intent = new Intent(activity, (Class<?>) FeedActionPanelActivity.class);
        intent.putExtra("extraRequestCode", 11);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.SHOW_KEY_ICON, FeedActionPanelActivity.J1);
        intent.putExtra("extrauserapidcomment", false);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_SYSTEM_TRANSPARENTBAR, 0);
        intent.putExtra("extra_key_bundle_within_intent", bundle);
        com.qzone.feed.utils.b.e(activity, intent, 11);
    }

    public void c(Activity activity, LoveAlbumTimeEvent loveAlbumTimeEvent, long j3, int i3) {
        String str;
        Intent intent = new Intent(activity, (Class<?>) FeedActionPanelActivity.class);
        if (loveAlbumTimeEvent != null) {
            str = loveAlbumTimeEvent.content;
        } else {
            str = "";
        }
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.FEED_TEXT_AUTOFILL_INTENT_KEY, str);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.NEEDTRANSEMOJ, 1);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY, j3 + "_" + (loveAlbumTimeEvent != null ? loveAlbumTimeEvent.time : 0L));
        intent.putExtra("inputmax", 500);
        intent.putExtra("showaticon", 0);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_SYSTEM_TRANSPARENTBAR, 0);
        intent.putExtra("canVertical", true);
        com.qzone.feed.utils.b.e(activity, intent, i3);
    }

    public void c0(Activity activity, PhotoPoiArea photoPoiArea) {
        PoiInfo poiInfo;
        Intent l3 = ak.l(activity, QZoneHelper.MOOD_SELECT_LOCATION);
        if (photoPoiArea != null && (poiInfo = photoPoiArea.poiInfo) != null && !TextUtils.isEmpty(poiInfo.poiY) && !TextUtils.isEmpty(photoPoiArea.poiInfo.poiX)) {
            LocalImageShootInfo localImageShootInfo = new LocalImageShootInfo();
            localImageShootInfo.gpsInfo = new GpsInfo4LocalImage(z().w(photoPoiArea.poiInfo.poiY), z().w(photoPoiArea.poiInfo.poiX));
            l3.putExtra("key_current_img_shoot_info", localImageShootInfo);
        }
        l3.putExtra("key_show_first_line", 0);
        if (photoPoiArea != null) {
            l3.putExtra("key_search_keyword", photoPoiArea.sceneryName);
        }
        l3.putExtra("key_from_album", true);
        com.qzone.feed.utils.b.e(activity, l3, 1208);
    }

    public void d(Activity activity, PhotoCacheData photoCacheData, long j3, int i3) {
        Intent intent = new Intent(activity, (Class<?>) FeedActionPanelActivity.class);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.FEED_TEXT_AUTOFILL_INTENT_KEY, photoCacheData.desc);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.NEEDTRANSEMOJ, 1);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY, j3 + "_" + photoCacheData.albumid + "_" + photoCacheData.lloc);
        intent.putExtra("inputmax", 500);
        intent.putExtra("showaticon", 0);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_SYSTEM_TRANSPARENTBAR, 0);
        intent.putExtra("canVertical", true);
        com.qzone.feed.utils.b.e(activity, intent, i3);
    }

    public void d0(Handler handler, PhotoCacheData photoCacheData, int i3) {
        QZoneWriteOperationService.m mVar = new QZoneWriteOperationService.m();
        mVar.f45734a = "";
        mVar.f45735b = photoCacheData.curkey;
        mVar.f45736c = photoCacheData.unikey;
        mVar.f45738e = photoCacheData.mylike != 1;
        mVar.f45739f = 4;
        mVar.f45740g = photoCacheData.picItem.busi_param;
        mVar.f45741h = 0;
        mVar.f45742i = i3;
        QZoneWriteOperationService.v0().u1(handler, mVar);
    }

    public void e(Activity activity, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTitleSaveTips", "\u4fdd\u5b58\u63d0\u793a");
        DialogUtil.createCustomDialog(activity, 230).setTitle(config).setMessage(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogMessageSaveTime", "\u786e\u8ba4\u4fdd\u5b58\u65f6\u95f4\uff1f")).setPositiveButton(l.a(R.string.ket), onClickListener).setNegativeButton(l.a(R.string.j6l), onClickListener2).show();
        ClickReport.m("368", "5", "");
    }

    public void e0(Activity activity, CellPictureInfo cellPictureInfo, int i3, int i16) {
        PictureViewerFactory.P(activity, cellPictureInfo, i3, i16);
    }

    public void f() {
        i.u().k();
    }

    public void f0(String str, boolean z16) {
        u5.b.o0(str, z16);
    }

    public void g(Activity activity, boolean z16, boolean z17) {
        ((QZonePersonalPhotoListActivity) activity).F3(z16, z17);
    }

    public void g0(String str, int i3, long j3) {
        LocalMultiProcConfig.putInt4Uin(str, i3, j3);
    }

    public void h(Activity activity) {
        ((QZonePersonalPhotoListActivity) activity).G3();
    }

    public void h0(String str, String str2) {
        u5.b.v0(str, str2);
    }

    public void i(Activity activity) {
        ((QZonePersonalPhotoListActivity) activity).H3();
    }

    public void i0(Activity activity) {
        ((QZonePersonalPhotoListActivity) activity).removeObserver();
    }

    public void j(Activity activity) {
        ((QZonePersonalPhotoListActivity) activity).I3();
    }

    public void j0(Activity activity, int i3) {
        if (activity instanceof QZonePersonalPhotoListActivity) {
            ((QZonePersonalPhotoListActivity) activity).P3(8);
        }
    }

    public void k(ArrayList<String> arrayList) {
        QzoneAlbumPicDownloadService.o().k(arrayList);
    }

    public void k0(Activity activity, ArrayList<PictureItem> arrayList, int i3) {
        PictureViewerFactory.S(activity, arrayList, i3);
    }

    public void l(String str, List<String> list) {
        com.qzone.album.base.Service.d.e().b(str, list);
    }

    public Dialog l0(Context context, int i3) {
        return DialogUtil.showProgressDialog(context, i3);
    }

    public String m(File file, boolean z16) {
        String absolutePath = file.getAbsolutePath();
        if (!SharpPUtils.isSharpP(file) || !z16) {
            return absolutePath;
        }
        QZLog.d("AlbumEnv", 2, "file is Sharp");
        try {
            String str = file.getName() + "_from_sharpP.jpeg";
            String str2 = AppConstants.SDCARD_IMG_SAVE;
            File file2 = new File(VFSAssistantUtils.getSDKPrivatePath(str2));
            if (!file2.exists()) {
                file2.mkdirs();
            }
            String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(str2 + str);
            QZLog.d("AlbumEnv", 2, "file is Sharp | newFilePath:", sDKPrivatePath);
            if (!new File(sDKPrivatePath).exists()) {
                Bitmap decodeSharpP = SharpPUtils.decodeSharpP(file.getAbsolutePath());
                if (decodeSharpP == null) {
                    return absolutePath;
                }
                boolean V = com.qzone.util.image.c.V(decodeSharpP, sDKPrivatePath, Bitmap.CompressFormat.JPEG, 90, true);
                if (!V) {
                    QZLog.e("AlbumEnv", "saveBitmapToFile res:" + V);
                    return absolutePath;
                }
            }
            return sDKPrivatePath;
        } catch (SecurityException e16) {
            QZLog.e("AlbumEnv", "SecurityException ", e16);
            return absolutePath;
        } catch (Exception e17) {
            QZLog.e("AlbumEnv", "Exception ", e17);
            return absolutePath;
        } catch (OutOfMemoryError e18) {
            QZLog.w("AlbumEnv", "Out of Memory ", e18);
            return absolutePath;
        }
    }

    public void m0(Activity activity, View view, String str, long j3) {
        QzoneGuideBubbleHelper.g().j(activity, view, str, 1, 14.0f, 5.0d, 10.0d, j3, -15550475, false, true);
    }

    public void n(Handler handler, PhotoCacheData photoCacheData, int i3, String str, boolean z16, long j3) {
        QZoneWriteOperationService.l lVar = new QZoneWriteOperationService.l();
        lVar.f45708a = "";
        lVar.f45709b = "";
        lVar.f45710c = photoCacheData.unikey;
        lVar.f45712e = 4;
        lVar.f45713f = j3;
        lVar.f45714g = photoCacheData.albumid;
        lVar.f45715h = str;
        lVar.f45717j = 0;
        lVar.f45716i = "";
        lVar.f45718k = photoCacheData.picItem.busi_param;
        lVar.f45721n = 0;
        lVar.f45720m = null;
        lVar.f45725r = z16;
        lVar.f45719l = QZoneHelper.QZoneAppConstants.REFER_PHOTO_LIST;
        lVar.f45726s = null;
        lVar.f45723p = i3;
        QZoneWriteOperationService.v0().Q(handler, lVar);
    }

    public void n0() {
        if (QZLog.isColorLevel()) {
            QZLog.d("AlbumEnv", 2, "startDecodePic");
        }
        ImageEnvImpl.setListViewScrollIdle(true);
        ImageEnvImpl.setCurrentLoadingImgStatus(true);
        ImageLoader.onListViewIdle();
    }

    public int o(float f16) {
        return ar.d(f16);
    }

    public void p(Activity activity, Long l3, ArrayList<NetImageInfo> arrayList) {
        Intent intent = new Intent();
        intent.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_TYPE, 9);
        intent.setClass(activity, QZoneUploadPhotoRealActivity.class);
        ParcelableWrapper.putArrayListToIntent(intent, "QZoneUploadPhotoActivity.key_reship_photos", arrayList);
        intent.putExtra("appid", 4);
        intent.putExtra("ownerUin", l3);
        intent.putExtra(QZoneHelper.Constants.KEY_STATE_TYPE_SRC, 12);
        intent.putExtra(QZoneHelper.Constants.KEY_TITLE_NAME, true);
        if (lc.b.d()) {
            QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean = new QZAlbumxUploadAlbumInitBean(LoginData.getInstance().getUinString(), 0, true, null, 0);
            qZAlbumxUploadAlbumInitBean.setRequestCode(8);
            ho.i.x().l(activity, qZAlbumxUploadAlbumInitBean, intent);
        } else {
            ho.i.w().g(activity, new QZonePublishMoodInitBean(System.currentTimeMillis()), 8, intent);
        }
    }

    public void q(Activity activity, AlbumCacheData albumCacheData) {
        TravelAlbumData travelAlbumData;
        ArrayList<PhotoPoiArea> arrayList;
        Intent l3 = ak.l(activity, QZoneHelper.MOOD_SELECT_LOCATION);
        l3.putExtra("show_nearby_poi", true);
        l3.putExtra("key_show_first_line", 0);
        l3.putExtra("key_from_album", true);
        if (albumCacheData != null && (travelAlbumData = albumCacheData.travelData) != null && (arrayList = travelAlbumData.photoPoiAreaList) != null && arrayList.size() > 0) {
            l3.putExtra("photo_list_start_shoot_time", albumCacheData.travelData.startShootTime);
            ParcelableWrapper.putArrayListToIntent(l3, "PHOTO_POI_AREA", albumCacheData.travelData.photoPoiAreaList);
        }
        com.qzone.feed.utils.b.e(activity, l3, 1208);
    }

    public void q0(AbsListView absListView) {
        if (QZLog.isColorLevel()) {
            QZLog.d("AlbumEnv", 2, "stopDecodePic");
        }
        ImageEnvImpl.setListViewScrollIdle(false);
        if (x.b() > 1) {
            ImageEnvImpl.setCurrentLoadingImgStatus(p.a(absListView, u5.a.f438265c));
        } else {
            ImageEnvImpl.setCurrentLoadingImgStatus(false);
        }
    }

    public void r(ArrayList<NetImageInfo> arrayList, BusinessAlbumInfo businessAlbumInfo, long j3, n5.a aVar, Handler handler) {
        String str;
        if (!NetworkState.isNetSupport()) {
            ToastUtil.o(R.string.gdc, 4);
            return;
        }
        if (arrayList == null) {
            return;
        }
        if (businessAlbumInfo != null) {
            str = businessAlbumInfo.mAlbumId;
        } else {
            str = "";
        }
        HashMap hashMap = new HashMap();
        String str2 = arrayList.get(0).mAlbumId;
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator<NetImageInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().lloc);
        }
        QZoneWriteOperationService.p pVar = new QZoneWriteOperationService.p();
        pVar.f45771c = 4;
        pVar.f45773e = j3;
        pVar.f45774f = str2;
        pVar.f45775g = arrayList2;
        pVar.f45790v = hashMap;
        if (aVar != null) {
            aVar.a(str, pVar, handler);
        }
        o5.a.d(businessAlbumInfo);
    }

    public void r0(int i3) {
        ToastUtil.x(i3);
    }

    public void s(String str, List<String> list, f fVar) {
        QzoneAlbumPicDownloadService.o().l(str, list, fVar);
    }

    public void s0(String str) {
        ToastUtil.A(str);
    }

    public void t(Context context, String str, ArrayList<String> arrayList, f fVar) {
        QzoneAlbumPicDownloadService.o().m(context, str, arrayList, fVar);
    }

    public void u(String str, List<String> list, com.qzone.homepage.ui.Facade.a aVar) {
        com.qzone.album.base.Service.d.e().c(str, list, aVar);
    }

    public void v(String str, i.f fVar, DialogInterface.OnClickListener onClickListener) {
        i.u().l(str, fVar, onClickListener);
    }

    public float w(String str) {
        return v.a(str);
    }

    public void x(Context context, String str, String str2, String str3, String str4, String str5, DialogInterface.OnDismissListener onDismissListener, int i3) {
        QZoneShareData qZoneShareData = new QZoneShareData();
        qZoneShareData.mTitle = str3;
        qZoneShareData.mSummary = str5;
        ArrayList<String> arrayList = new ArrayList<>();
        qZoneShareData.mImageUrls = arrayList;
        arrayList.add(str4);
        qZoneShareData.targetUrl = str2;
        QZoneShareManager.shareToQzone(context, str, qZoneShareData, onDismissListener, i3);
    }

    public String I(int i3, boolean z16) {
        if (i3 == 1 || z16) {
            return "";
        }
        return com.qzone.feed.utils.h.e(i3);
    }

    public void W(Activity activity, Context context, String str, String str2) {
        Intent x16 = ak.x(context, str, 0);
        x16.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_ID, str2);
        com.qzone.feed.utils.b.e(activity, x16, 2);
    }

    public void Z(Activity activity, int i3, String str, int i16) {
        ak.Q(activity, ak.p(activity, str, i3, B().getResources().getString(i3 >= 1 ? R.string.h_9 : R.string.gpz), false, LoginData.getInstance().getUin(), LoginData.getInstance().isQzoneVip()), i16);
    }

    public boolean y(Activity activity, Context context, PhotoCacheData photoCacheData) {
        VideoInfo videoInfo;
        String str;
        if (photoCacheData == null || (videoInfo = photoCacheData.videodata) == null || videoInfo.videoUrl == null || activity == null || context == null) {
            return false;
        }
        int videoCoverLimitMs = QZoneHelper.getVideoCoverLimitMs();
        VideoInfo videoInfo2 = photoCacheData.videodata;
        long j3 = videoInfo2.videoTime;
        if (j3 > videoCoverLimitMs) {
            com.qzone.album.env.common.a.m().V(String.format(K().getString(R.string.gpv), Integer.valueOf(videoCoverLimitMs / 1000)));
            return false;
        }
        if (j3 == 0) {
            com.qzone.album.env.common.a.m().W(K().getString(R.string.gpw), 4);
            return false;
        }
        if (1 == videoInfo2.videoStatus) {
            com.qzone.album.env.common.a.m().V(K().getString(R.string.gpf));
            return false;
        }
        if (!TextUtils.isEmpty(photoCacheData.bigUrl)) {
            str = photoCacheData.bigUrl;
        } else {
            str = photoCacheData.videodata.coverUrl.url;
        }
        VideoInfo videoInfo3 = photoCacheData.videodata;
        QZoneHelper.launchVideoCoverPreviewActivity(activity, 2, videoInfo3.videoId, false, videoInfo3.videoUrl.url, str, videoInfo3.width, videoInfo3.height, j3, 0L, j3, videoInfo3.originVideoSize, 0, null, "", "", QZoneVideoCommonUtils.REFER_SHORT_VIDEO_FOR_VIDEO_COVER, QzoneCoverConst.CoverStringType.COVER_TYPE_VIDEO_COVER);
        return true;
    }

    public void p0(Activity activity, String str, String str2, String str3, int i3, int i16, String str4, int i17, int i18) {
        if (com.qzone.common.business.service.b.a(activity)) {
            if (i16 == 1) {
                ClickReport.j(LoginData.getInstance().getUin(), String.valueOf(4), "", QZoneHelper.QZoneAppConstants.REFER_PHOTO_LIST, false, String.valueOf(307), String.valueOf(4), String.valueOf(1), str4);
            }
            String Q2 = QZonePersonalAlbumActivity.Q2();
            if (!TextUtils.isEmpty(Q2)) {
                Q2 = Q2 + ".getPhotoList.localphoto";
            }
            String str5 = Q2;
            Intent F = ak.F(activity, 0, null, null, str, str2, str3, str5, i18);
            F.putExtra("IsBack", true);
            F.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_TYPE, i16);
            F.putExtra("refer", QZoneHelper.QZoneAppConstants.REFER_PHOTO_LIST);
            F.putExtra("UploadPhoto.key_album_anonymity", i3);
            if (i16 == 10) {
                F.putExtra(QAlbumConstants.ALBUM_NAME, QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumRecentlyVideo", "\u6700\u8fd1\u89c6\u9891"));
            }
            String R2 = QZonePersonalAlbumActivity.R2();
            if (!TextUtils.isEmpty(R2) && i16 == 1) {
                F.putExtra(QzoneVideoBeaconReport.BEACON_SOURCE, R2);
                QzoneVideoBeaconReport.reportAlbumEvent(LoginData.getInstance().getUinString(), R2);
            }
            if (lc.b.d()) {
                ho.i.x().l(activity, new QZAlbumxUploadAlbumInitBean(LoginData.getInstance().getUinString(), 0, true, null, 0), F);
                return;
            }
            QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
            qZonePublishMoodInitBean.I0(0);
            qZonePublishMoodInitBean.l0(str);
            qZonePublishMoodInitBean.m0(str2);
            qZonePublishMoodInitBean.k0(str3);
            qZonePublishMoodInitBean.C0(str5);
            qZonePublishMoodInitBean.O0(Integer.valueOf(i18));
            qZonePublishMoodInitBean.v0(Boolean.FALSE);
            com.qzone.reborn.util.l lVar = com.qzone.reborn.util.l.f59550a;
            if (!TextUtils.isEmpty(lVar.j(i18))) {
                qZonePublishMoodInitBean.Q0(lVar.j(i18));
            }
            qZonePublishMoodInitBean.P0(UUID.randomUUID().toString());
            ho.i.w().h(activity, qZonePublishMoodInitBean, F);
        }
    }

    public void o0(Activity activity, String str, String str2, String str3, int i3, int i16, String str4) {
        p0(activity, str, str2, str3, i3, i16, str4, Integer.MIN_VALUE, 13);
    }
}
