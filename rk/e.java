package rk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.common.account.LoginData;
import com.qzone.commoncode.module.videorecommend.utils.WeishiHelper;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.misc.network.report.QzoneFeedVisitorReportService;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellLocalInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.reborn.base.QZoneBaseActivity;
import com.qzone.reborn.layer.fragment.QZoneAlbumLayerFragment;
import com.qzone.reborn.layer.fragment.QZoneAlbumSelectLayerFragment;
import com.qzone.reborn.layer.fragment.QZoneAlbumSelectPreviewLayerFragment;
import com.qzone.reborn.layer.fragment.QZoneExpireLayerFragment;
import com.qzone.reborn.layer.fragment.QZoneFeedxLayerFragment;
import com.qzone.reborn.layer.fragment.QZoneGroupAlbumLayerFragment;
import com.qzone.reborn.layer.fragment.QZoneLimitedInteractionLayerFragment;
import com.qzone.reborn.layer.fragment.QZoneLocalLayerFragment;
import com.qzone.reborn.layer.fragment.QZoneLocalLongPicLayerFragment;
import com.qzone.reborn.layer.fragment.QZoneLongPicLayerFragment;
import com.qzone.reborn.layer.fragment.QZoneRecentAlbumLayerFragment;
import com.qzone.reborn.layer.fragment.QZoneRecentAlbumTimelineLayerFragment;
import com.qzone.reborn.layer.fragment.QZoneRecentVideoLayerFragment;
import com.qzone.reborn.layer.fragment.QZoneSimpleLayerFragment;
import com.qzone.reborn.layer.fragment.QZoneSingleVideoLayerFragment;
import com.qzone.reborn.layer.part.QZoneFeedXGalleryActivity;
import com.qzone.reborn.layer.part.QZoneTransparentGalleryActivity;
import com.qzone.reborn.util.o;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.compat.CompatPublicFragment;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.QQLayerFragment;
import com.tencent.richframework.gallery.RFWLaunchKey;
import com.tencent.richframework.gallery.RFWLayerFragment;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.util.AppSetting;
import com.tencent.util.ArrayUtils;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import xg.g;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e implements ho.a {
    private static void C(d dVar, PhotoParam photoParam, List<PhotoInfo> list) {
        if (k(photoParam, list) && dVar != null) {
            PhotoInfo photoInfo = list.get(0);
            photoInfo.shareAlbumRight = 1;
            photoInfo.shareSpaceRight = 1;
            if (dVar.getClickView() != null) {
                dVar.getClickView().setTag(RFWLaunchKey.ID_VIDEO_MUTE, Boolean.FALSE);
            }
            QZoneFeedUtil.f47421a.put("current_forward_key", dVar.getBusinessFeedData());
            QZoneFeedUtil.f47421a.put("open_action_panel_ahare_to_qzone_key", dVar.getBusinessFeedData());
        }
    }

    private ArrayList<PhotoInfo> a(List<PhotoCacheData> list, int i3) {
        int size = list.size();
        ArrayList<PhotoInfo> arrayList = new ArrayList<>();
        for (int i16 = 0; i16 < size; i16++) {
            PhotoInfo photoInfo = new PhotoInfo();
            PhotoCacheData photoCacheData = list.get(i16);
            PictureViewerFactory.i0(photoInfo, photoCacheData, i3);
            if (i3 == 9 || i3 == 8) {
                photoInfo.currentUrl = null;
            }
            photoInfo.allow_share = photoCacheData.allow_share;
            photoInfo.opMask = photoCacheData.opmask;
            arrayList.add(photoInfo);
        }
        return arrayList;
    }

    private static List<RFWLayerItemMediaInfo> b(List<PhotoInfo> list) {
        if (com.qzone.reborn.configx.g.f53821a.b().v()) {
            return PictureViewerFactory.j(list);
        }
        return PictureViewerFactory.g(list);
    }

    private void d(Activity activity, d dVar, ArrayList<PhotoInfo> arrayList) {
        CellFeedCommInfo feedCommonInfo = dVar.getFeedCommonInfo();
        int curPos = dVar.getCurPos();
        activity.overridePendingTransition(R.anim.f155022gz, R.anim.f155024h1);
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        userInfo.qzone_uin = LoginData.getInstance().getUinString();
        Bundle bundle = new Bundle();
        bundle.putSerializable("picturelist", arrayList);
        bundle.putInt("curindex", curPos);
        bundle.putParcelable("photo_param", dVar.getPhotoParam());
        bundle.putInt("mode", 0);
        bundle.putBoolean("need_clear_cache", true);
        int E = PictureViewerFactory.E(feedCommonInfo);
        bundle.putInt(PeakConstants.KEY_SHOW_TYPE, E);
        bundle.putBoolean(RFWLaunchKey.KEY_IS_CARVED_ANIM_OPEN, tk.h.C());
        boolean c16 = gd.a.f401926a.c("KEY_OPEN_OLD_LONG_PIC_LAYER", false);
        if (E != 0 && (c16 || AppSetting.isPublicVersion())) {
            QZoneHelper.forwardToPictureViewerForQzone(activity, userInfo, bundle, dVar.getRequestCode());
            return;
        }
        List<RFWLayerItemMediaInfo> b16 = b(arrayList);
        if (l(activity, b16)) {
            return;
        }
        int e16 = e(curPos, b16);
        QLog.i("QZoneGalleryLayerNativeLauncher", 1, "launch new gallery layer page");
        RFWLayerLaunchUtil.jumpToGallery(activity, dVar.b(activity), b16, e16, (Class<? extends CompatPublicActivity>) QZoneFeedXGalleryActivity.class, i(dVar), bundle);
    }

    private static int e(int i3, List<RFWLayerItemMediaInfo> list) {
        if (!ArrayUtils.isOutOfArrayIndex(i3, list)) {
            return i3;
        }
        RFWLog.e("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "curPos is out of bound");
        return 0;
    }

    public static Class<? extends RFWLayerFragment> f(PhotoParam photoParam, List<PhotoInfo> list) {
        if (k(photoParam, list)) {
            return QZoneSingleVideoLayerFragment.class;
        }
        return QZoneFeedxLayerFragment.class;
    }

    private static Class<? extends QZoneBaseActivity> g() {
        if (MobileQQ.sProcessId == 2) {
            return QZoneTransparentGalleryActivity.class;
        }
        return QZoneFeedXGalleryActivity.class;
    }

    private static Class<? extends QQLayerFragment> h(j jVar) {
        if (jVar.getShowType() == 1) {
            return QZoneLocalLongPicLayerFragment.class;
        }
        return QZoneLocalLayerFragment.class;
    }

    private Class<? extends RFWLayerFragment> i(d dVar) {
        if (dVar.getDisAllowShare()) {
            return QZoneSimpleLayerFragment.class;
        }
        return QZoneLimitedInteractionLayerFragment.class;
    }

    private boolean m(String str) {
        return (TextUtils.isEmpty(str) || HttpUtil.isValidUrl(str)) ? false : true;
    }

    public static boolean n(int i3) {
        if (i3 == 2) {
            return true;
        }
        return false;
    }

    private boolean o(String str) {
        return (WeishiHelper.isWeishiVideoLayerScheme(str) || WeishiHelper.isWeishiScheme(str) || WeishiHelper.isVerticalNormalVideoLayerSchema(str) || WeishiHelper.isLandscapevideolayerSchema(str)) ? false : true;
    }

    private void w(BusinessFeedData businessFeedData, int i3, Context context, g.a aVar, BusinessFeedData businessFeedData2) {
        String str;
        if (businessFeedData == null) {
            QZLog.e("onSingleAlbumVideoClick", "bfd == null");
            return;
        }
        int i16 = RFWLog.USR;
        Object[] objArr = new Object[1];
        if (("onSingleAlbumVideoClick feed id :" + businessFeedData.getFeedCommInfo()) == null) {
            str = "";
        } else {
            str = businessFeedData.getFeedCommInfo().feedsid;
        }
        objArr[0] = str;
        RFWLog.d("QZoneGalleryLayerNativeLauncher", i16, objArr);
        VideoInfo videoInfo = businessFeedData.getVideoInfo();
        if (videoInfo == null && businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().getVideoInfo() != null) {
            videoInfo = businessFeedData.getOriginalInfo().getVideoInfo();
        }
        if (videoInfo == null) {
            QZLog.e("onSingleAlbumVideoClick", "videoInfo == null");
            return;
        }
        CellPictureInfo a16 = f.a(businessFeedData, videoInfo);
        PhotoParam b16 = f.b(businessFeedData, videoInfo, businessFeedData2, a16);
        int a17 = new com.qzone.proxy.feedcomponent.model.f(i3, 0, false, true).a();
        d dVar = new d();
        dVar.v(a16);
        dVar.r(businessFeedData);
        dVar.g(a17);
        dVar.t(businessFeedData.getFeedCommInfo());
        dVar.h(b16);
        dVar.i(1204);
        dVar.x(businessFeedData.getUser().isSafeModeUser != 0);
        dVar.w(tk.k.f436438a.c(businessFeedData, businessFeedData2));
        if (aVar != null && aVar.f447951a != null && !businessFeedData.isQQVideoFeeds()) {
            dVar.f(aVar.f447951a);
        }
        if (j(businessFeedData, businessFeedData2)) {
            dVar.s(true);
            A(com.qzone.reborn.feedx.widget.i.b(context), dVar);
        } else {
            t(com.qzone.reborn.feedx.widget.i.b(context), dVar);
        }
    }

    public void p(Activity activity, a aVar) {
        ArrayList arrayList = new ArrayList();
        Bundle D = D(activity, aVar, arrayList);
        if (D == null) {
            return;
        }
        RFWLayerLaunchUtil.jumpToGallery(activity, aVar.b(activity), arrayList, e(aVar.getCurPos(), arrayList), (Class<? extends CompatPublicActivity>) QZoneTransparentGalleryActivity.class, (Class<? extends CompatPublicFragment>) QZoneAlbumLayerFragment.class, D);
    }

    public void q(Activity activity, b bVar) {
        ArrayList arrayList = new ArrayList();
        Bundle D = D(activity, bVar, arrayList);
        if (D == null) {
            return;
        }
        D.putInt(PictureConst.KEY_MAX_SELECT_COUNT, bVar.getMaxSelectCount());
        D.putStringArrayList(PictureConst.KEY_SELECTED_PHOTO_LLOC, bVar.t());
        D.putBoolean(PictureConst.KEY_CHECKBOX_WITH_NUMBER, bVar.getIsNumberCheckBox());
        D.putInt(PictureConst.KEY_PAGE_MODE, bVar.getPageMode());
        RFWLayerLaunchUtil.jumpToGallery(activity, bVar.b(activity), arrayList, e(bVar.getCurPos(), arrayList), QZoneTransparentGalleryActivity.class, QZoneAlbumSelectLayerFragment.class, D, bVar.getRequestCode());
    }

    public void r(Activity activity, b bVar) {
        ArrayList<PhotoInfo> a16 = a(bVar.m(), bVar.getAlbumType());
        ArrayList arrayList = new ArrayList(b(a16));
        Bundle bundle = new Bundle();
        bundle.putSerializable("picturelist", a16);
        bundle.putInt(PictureConst.KEY_MAX_SELECT_COUNT, bVar.getMaxSelectCount());
        bundle.putStringArrayList(PictureConst.KEY_SELECTED_PHOTO_LLOC, bVar.t());
        bundle.putBoolean(PictureConst.KEY_CHECKBOX_WITH_NUMBER, bVar.getIsNumberCheckBox());
        bundle.putInt(PictureConst.KEY_PAGE_MODE, bVar.getPageMode());
        RFWLayerLaunchUtil.jumpToGallery(activity, bVar.b(activity), arrayList, 0, QZoneTransparentGalleryActivity.class, QZoneAlbumSelectPreviewLayerFragment.class, bundle, bVar.getRequestCode());
    }

    public void s(Activity activity, d dVar) {
        CellPictureInfo pictureInfo = dVar.getPictureInfo();
        if (pictureInfo != null && pictureInfo.pics != null) {
            ArrayList<PhotoInfo> C = PictureViewerFactory.C(pictureInfo, dVar.getFeedCommonInfo(), new PhotoParam(), dVar.getCurPos());
            int curPos = dVar.getCurPos();
            activity.overridePendingTransition(R.anim.f155022gz, R.anim.f155024h1);
            QZoneHelper.UserInfo.getInstance().qzone_uin = LoginData.getInstance().getUinString();
            Bundle bundle = new Bundle();
            bundle.putInt("curindex", curPos);
            bundle.putParcelable("photo_param", dVar.getPhotoParam());
            bundle.putInt("mode", 0);
            bundle.putBoolean("need_clear_cache", true);
            if (dVar.getBundle() != null) {
                bundle.putAll(dVar.getBundle());
            }
            bundle.putInt(PeakConstants.KEY_SHOW_TYPE, 0);
            bundle.putBoolean(RFWLaunchKey.KEY_IS_CARVED_ANIM_OPEN, tk.h.C());
            RFWLayerLaunchUtil.jumpToGallery(activity, dVar.b(activity), b(C), curPos, (Class<? extends CompatPublicActivity>) QZoneTransparentGalleryActivity.class, (Class<? extends CompatPublicFragment>) QZoneExpireLayerFragment.class, bundle);
            return;
        }
        RFWLog.d("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchSimpleGalleryLayer fail, picInfo: " + pictureInfo);
    }

    private static void c(Activity activity, d dVar, int i3) {
        if (dVar != null && activity != null) {
            CellPictureInfo pictureInfo = dVar.getPictureInfo();
            PhotoParam photoParam = dVar.getPhotoParam();
            if (photoParam == null) {
                photoParam = new PhotoParam();
            }
            PhotoParam photoParam2 = photoParam;
            CellFeedCommInfo feedCommonInfo = dVar.getFeedCommonInfo();
            int curPos = dVar.getCurPos();
            if (pictureInfo != null && pictureInfo.pics != null) {
                ArrayList<PhotoInfo> C = PictureViewerFactory.C(pictureInfo, feedCommonInfo, photoParam2, curPos);
                QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                userInfo.qzone_uin = Long.toString(photoParam2.ownerUin);
                Bundle bundle = new Bundle();
                bundle.putSerializable("picturelist", C);
                bundle.putInt("curindex", curPos);
                bundle.putParcelable("photo_param", photoParam2);
                bundle.putInt("mode", i3);
                bundle.putBoolean("need_clear_cache", true);
                int E = PictureViewerFactory.E(feedCommonInfo);
                bundle.putInt(PeakConstants.KEY_SHOW_TYPE, E);
                bundle.putBoolean(RFWLaunchKey.KEY_IS_CARVED_ANIM_OPEN, tk.h.C());
                bundle.putBoolean("is_forward_album_feed", dVar.getIsForwardAlbumFeed());
                QLog.i("QZoneGalleryLayerNativeLauncher", 1, "launchLayer: isGallery:" + E);
                List<RFWLayerItemMediaInfo> b16 = b(C);
                if (l(activity, b16)) {
                    return;
                }
                int e16 = e(curPos, b16);
                if (E == 0) {
                    C(dVar, photoParam2, C);
                    QLog.i("QZoneGalleryLayerNativeLauncher", 1, "launch new gallery layer page");
                    RFWLayerLaunchUtil.jumpToGallery(activity, dVar.b(activity), b16, e16, (Class<? extends CompatPublicActivity>) QZoneFeedXGalleryActivity.class, f(photoParam2, C), bundle);
                } else {
                    boolean c16 = gd.a.f401926a.c("KEY_OPEN_OLD_LONG_PIC_LAYER", false);
                    if (!com.qzone.reborn.configx.g.f53821a.b().F1() && (c16 || AppSetting.isPublicVersion())) {
                        QZoneHelper.forwardToPictureViewerForQzone(activity, userInfo, bundle, dVar.getRequestCode());
                    } else {
                        RFWLayerLaunchUtil.jumpToGallery(activity, (ImageView) null, b16, e16, (Class<? extends CompatPublicActivity>) QZoneFeedXGalleryActivity.class, (Class<? extends CompatPublicFragment>) QZoneLongPicLayerFragment.class, bundle);
                    }
                }
                QzoneFeedVisitorReportService.f().b(photoParam2, C, e16);
                return;
            }
            RFWLog.d("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchFeedxGalleryLayer fail, picInfo: " + pictureInfo + ", photoParams: " + photoParam2);
            return;
        }
        RFWLog.d("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "doLaunchFeedxGalleryLayer fail, layerLaunchBean: " + dVar + ", activity: " + activity);
    }

    private static boolean l(Activity activity, List<RFWLayerItemMediaInfo> list) {
        if (!ArrayUtils.isOutOfArrayIndex(0, list)) {
            return false;
        }
        QQToast.makeText(activity, 1, "\u7f51\u7edc\u6570\u636e\u5f02\u5e38, \u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
        return true;
    }

    public void y(Activity activity, k kVar) {
        if (kVar != null && activity != null) {
            if (com.qzone.reborn.util.e.b("QZoneGalleryLayerNativeLauncher_Timeline", 500L)) {
                RFWLog.i("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "is fast click, return");
                return;
            } else {
                kVar.s(true);
                x(activity, kVar);
                return;
            }
        }
        RFWLog.e("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchRecentAlbumTimelineGalleryLayer fail, layerLaunchBean: " + kVar + ", activity: " + activity);
    }

    public void A(Activity activity, d dVar) {
        if (dVar != null && activity != null) {
            CellPictureInfo pictureInfo = dVar.getPictureInfo();
            if (pictureInfo != null && pictureInfo.pics != null) {
                if (dVar.getPhotoParam() == null) {
                    dVar.h(new PhotoParam());
                }
                if (dVar.getClickView() != null) {
                    dVar.getClickView().setTag(RFWLaunchKey.ID_VIDEO_MUTE, Boolean.FALSE);
                }
                d(activity, dVar, PictureViewerFactory.C(pictureInfo, dVar.getFeedCommonInfo(), dVar.getPhotoParam(), dVar.getCurPos()));
                return;
            }
            RFWLog.d("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchSimpleGalleryLayer fail, picInfo: " + pictureInfo);
            return;
        }
        RFWLog.d("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchFeedxGalleryLayer fail, layerLaunchBean: " + dVar + ", activity: " + activity);
    }

    public void t(Activity activity, d dVar) {
        long j3;
        if (dVar != null && activity != null) {
            CellPictureInfo pictureInfo = dVar.getPictureInfo();
            PhotoParam photoParam = dVar.getPhotoParam();
            if (pictureInfo != null && pictureInfo.pics != null && photoParam != null) {
                Intent intent = new Intent();
                int i3 = photoParam.appid;
                if (i3 == 4) {
                    photoParam.cell_id = photoParam.albumid;
                } else if (i3 == 311 || i3 == 6100) {
                    intent.putExtra(PictureConst.KEY_PHTOTCOUNT, pictureInfo.pics.size());
                }
                photoParam.loginUin = LoginData.getInstance().getUin();
                photoParam.loginNickName = LoginData.getInstance().getNickName("");
                if (dVar.getRealOwnerUin() > 10001) {
                    j3 = dVar.getRealOwnerUin();
                } else {
                    j3 = pictureInfo.uin;
                }
                photoParam.realOwnerUin = j3;
                photoParam.isShareAlbum = pictureInfo.isSharingAlbumData();
                if (dVar.getClickView() != null) {
                    dVar.getClickView().setTag(RFWLaunchKey.ID_VIDEO_MUTE, Boolean.FALSE);
                }
                activity.overridePendingTransition(R.anim.f155022gz, R.anim.f155024h1);
                c(activity, dVar, 2);
                return;
            }
            RFWLog.d("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchFeedxGalleryLayer fail, picInfo: " + pictureInfo + ", photoParams: " + photoParam);
            return;
        }
        RFWLog.d("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchFeedxGalleryLayer fail, layerLaunchBean: " + dVar + ", activity: " + activity);
    }

    public void x(Activity activity, k kVar) {
        Class cls;
        if (kVar != null && activity != null) {
            if (com.qzone.reborn.util.e.b("QZoneGalleryLayerNativeLauncher_RecentAlbum", 500L)) {
                RFWLog.i("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "is fast click, return");
                return;
            }
            if (kVar.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.EXTRA_DATA java.lang.String() == null) {
                RFWLog.e("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchRecentAlbumGalleryLayer fail, extra data is null");
                return;
            }
            List<PhotoCacheData> m3 = kVar.m();
            PhotoParam photoParam = kVar.getPhotoParam();
            ArrayList<PhotoParam> l3 = kVar.l();
            boolean hasMore = kVar.getHasMore();
            kVar.getUin();
            int curPos = kVar.getCurPos();
            kVar.getRequestCode();
            int i3 = kVar.getIsFromPhotoSearch() ? 16 : 50;
            int size = m3.size();
            if (size > i3) {
                int i16 = curPos - (i3 / 2);
                int i17 = i16 >= 0 ? i16 : 0;
                int i18 = i3 + i17;
                if (i18 <= size) {
                    size = i18;
                }
                m3 = m3.subList(i17, size);
                curPos -= i17;
            }
            ArrayList<PhotoInfo> e06 = PictureViewerFactory.e0(m3);
            if (photoParam == null) {
                photoParam = new PhotoParam();
            }
            photoParam.loginUin = LoginData.getInstance().getUin();
            photoParam.loginNickName = LoginData.getInstance().getNickName("");
            if (kVar.getIsFromTimeline()) {
                cls = QZoneRecentAlbumTimelineLayerFragment.class;
            } else {
                cls = QZoneRecentAlbumLayerFragment.class;
            }
            kVar.getIsFromTimeline();
            if (kVar.getClickView() != null) {
                kVar.getClickView().setTag(RFWLaunchKey.ID_VIDEO_MUTE, Boolean.FALSE);
            }
            QLog.i("QZoneGalleryLayerNativeLauncher", 1, "launch new recent album layer page");
            List<RFWLayerItemMediaInfo> b16 = b(e06);
            if (l(activity, b16)) {
                return;
            }
            int e16 = e(curPos, b16);
            Bundle bundle = new Bundle();
            bundle.putInt("curindex", e16);
            bundle.putInt("mode", 1);
            bundle.putParcelable("photo_param", photoParam);
            bundle.putParcelableArrayList(PictureConst.KEY_PHOTO_PARAM_LIST, l3);
            bundle.putSerializable("picturelist", e06);
            bundle.putBoolean(PictureConst.KEY_HAS_MORE, hasMore);
            bundle.putBoolean(RFWLaunchKey.KEY_IS_CARVED_ANIM_OPEN, tk.h.C());
            RFWLayerLaunchUtil.jumpToGallery(activity, kVar.b(activity), b16, e16, (Class<? extends CompatPublicActivity>) QZoneFeedXGalleryActivity.class, (Class<? extends CompatPublicFragment>) cls, bundle);
            return;
        }
        RFWLog.e("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchRecentAlbumGalleryLayer fail, layerLaunchBean: " + kVar + ", activity: " + activity);
    }

    private Bundle D(Activity activity, a aVar, List<RFWLayerItemMediaInfo> list) {
        if (aVar != null && activity != null) {
            if (com.qzone.reborn.util.e.b("QZoneGalleryLayerNativeLauncher_Album", 500L)) {
                RFWLog.i("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "is fast click, return");
                return null;
            }
            List<PhotoCacheData> m3 = aVar.m();
            PhotoParam photoParam = aVar.getPhotoParam();
            int curPos = aVar.getCurPos();
            aVar.getRequestCode();
            int allPhotoCount = aVar.getAllPhotoCount();
            int indexInAlbum = aVar.getIndexInAlbum();
            if (m3 != null && photoParam != null) {
                Bundle bundle = new Bundle();
                bundle.putLong(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis());
                if (aVar.getClickView() != null) {
                    aVar.getClickView().setTag(RFWLaunchKey.ID_VIDEO_MUTE, Boolean.FALSE);
                }
                ArrayList<PhotoInfo> a16 = a(m3, aVar.getAlbumType());
                photoParam.cell_id = photoParam.albumid;
                if (photoParam.albumanswer == null) {
                    photoParam.albumanswer = "";
                }
                photoParam.loginUin = LoginData.getInstance().getUin();
                QLog.i("QZoneGalleryLayerNativeLauncher", 1, "launch new gallery layer page");
                list.addAll(b(a16));
                if (l(activity, list)) {
                    return null;
                }
                bundle.putInt("curindex", e(curPos, list));
                bundle.putInt("mode", 3);
                bundle.putParcelable("photo_param", photoParam);
                bundle.putSerializable("picturelist", a16);
                bundle.putInt(PictureConst.KEY_ALL_PHOTO_COUNT, allPhotoCount);
                bundle.putInt(PictureConst.KEY_PHOTO_INDEX_IN_ALBUM, indexInAlbum);
                bundle.putBoolean(RFWLaunchKey.KEY_IS_CARVED_ANIM_OPEN, tk.h.C());
                return bundle;
            }
            RFWLog.d("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchFeedxGalleryLayer fail, pics: " + m3 + ", photoParams: " + photoParam);
            return null;
        }
        RFWLog.d("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchAlbumGalleryLayer fail, layerLaunchBean: " + aVar + ", activity: " + activity);
        return null;
    }

    public static boolean k(PhotoParam photoParam, List<PhotoInfo> list) {
        return list != null && list.size() == 1 && list.get(0).isVideo() && (photoParam == null || TextUtils.isEmpty(photoParam.albumid));
    }

    public void u(Activity activity, g gVar) {
        if (activity != null && gVar != null) {
            if (gVar.getClickView() != null) {
                gVar.getClickView().setTag(RFWLaunchKey.ID_VIDEO_MUTE, Boolean.FALSE);
            }
            RFWLayerLaunchUtil.jumpToGallery(activity, (ImageView) null, b(gVar.k()), 0, (Class<? extends CompatPublicActivity>) QZoneFeedXGalleryActivity.class, (Class<? extends CompatPublicFragment>) QZoneGroupAlbumLayerFragment.class, gVar.getBundle());
            return;
        }
        RFWLog.e("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchGroupGalleryLayer fail, layerLaunchBean: " + gVar + ", activity: " + activity);
    }

    public static boolean j(BusinessFeedData businessFeedData, BusinessFeedData businessFeedData2) {
        if (businessFeedData2 != null) {
            return businessFeedData2.getFeedCommInfo() != null && businessFeedData2.getFeedCommInfo().appid == 7035;
        }
        if (businessFeedData != null) {
            return businessFeedData.getFeedCommInfo() != null && businessFeedData.getFeedCommInfo().appid == 7035;
        }
        return false;
    }

    public void v(Activity activity, j jVar) {
        if (activity != null && jVar != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("key_init_data_list", jVar.u());
            bundle.putBoolean(RFWLaunchKey.KEY_IS_CARVED_ANIM_OPEN, false);
            bundle.putInt(PictureConst.KEY_EDIT_BTN_TYPE, jVar.getEditBtnType());
            bundle.putInt(PictureConst.KEY_DEL_TYPE, jVar.getDelBtnType());
            bundle.putString("RECEIVE_DATA_CLASS_NAME", activity.getClass().getName());
            if (jVar.getClickView() != null) {
                jVar.getClickView().setTag(RFWLaunchKey.ID_VIDEO_MUTE, Boolean.FALSE);
            }
            RFWLayerLaunchUtil.jumpToGallery(activity, jVar.getClickView(), jVar.g(), jVar.getCurPos(), g(), h(jVar), bundle, 6002);
            return;
        }
        RFWLog.d("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchLocalLayer fail, Activity or RouteBean is null");
    }

    public void z(Activity activity, k kVar) {
        if (activity != null && kVar != null) {
            if (com.qzone.reborn.util.e.b("QZoneGalleryLayerNativeLauncher_RecentVideo", 500L)) {
                RFWLog.i("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "is fast click, return");
                return;
            }
            if (kVar.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.EXTRA_DATA java.lang.String() == null) {
                RFWLog.e("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchRecentAlbumGalleryLayer fail, extra data is null");
                return;
            }
            List<PhotoCacheData> m3 = kVar.m();
            PhotoParam photoParam = kVar.getPhotoParam();
            ArrayList<PhotoParam> l3 = kVar.l();
            boolean hasMore = kVar.getHasMore();
            long uin = kVar.getUin();
            int curPos = kVar.getCurPos();
            kVar.getRequestCode();
            int i3 = kVar.getIsFromPhotoSearch() ? 16 : 50;
            int size = m3.size();
            if (size > i3) {
                int i16 = curPos - (i3 / 2);
                int i17 = i16 >= 0 ? i16 : 0;
                int i18 = i3 + i17;
                if (i18 <= size) {
                    size = i18;
                }
                m3 = m3.subList(i17, size);
                curPos -= i17;
            }
            if (kVar.getClickView() != null) {
                kVar.getClickView().setTag(RFWLaunchKey.ID_VIDEO_MUTE, Boolean.FALSE);
            }
            ArrayList<PhotoInfo> e06 = PictureViewerFactory.e0(m3);
            if (photoParam == null) {
                photoParam = new PhotoParam();
            }
            photoParam.loginUin = LoginData.getInstance().getUin();
            photoParam.loginNickName = LoginData.getInstance().getNickName("");
            QLog.i("QZoneGalleryLayerNativeLauncher", 1, "launch new recent album layer page");
            Bundle bundle = new Bundle();
            bundle.putInt("curindex", curPos);
            bundle.putInt("mode", 10);
            bundle.putParcelable("photo_param", photoParam);
            bundle.putParcelableArrayList(PictureConst.KEY_PHOTO_PARAM_LIST, l3);
            bundle.putSerializable("picturelist", e06);
            bundle.putBoolean(PictureConst.KEY_HAS_MORE, hasMore);
            bundle.putLong("key_uin", uin);
            bundle.putBoolean(RFWLaunchKey.KEY_IS_CARVED_ANIM_OPEN, tk.h.C());
            List<RFWLayerItemMediaInfo> b16 = b(e06);
            if (l(activity, b16)) {
                return;
            }
            RFWLayerLaunchUtil.jumpToGallery(activity, kVar.b(activity), b16, e(curPos, b16), (Class<? extends CompatPublicActivity>) QZoneFeedXGalleryActivity.class, (Class<? extends CompatPublicFragment>) QZoneRecentVideoLayerFragment.class, bundle);
            return;
        }
        RFWLog.e("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchRecentVideoGalleryLayer fail, layerLaunchBean: " + kVar + ", activity: " + activity);
    }

    public void B(BusinessFeedData businessFeedData, Context context, int i3, long j3, g.a aVar, BusinessFeedData businessFeedData2) {
        String str;
        if (businessFeedData == null) {
            QZLog.w("QZoneGalleryLayerNativeLauncher", "launchSingleVideoLayer error, businessFeedData == null");
            return;
        }
        VideoInfo videoInfo = businessFeedData.getVideoInfo();
        if (videoInfo == null && businessFeedData.getOriginalInfo() != null) {
            videoInfo = businessFeedData.getOriginalInfo().getVideoInfo();
        }
        if (videoInfo == null) {
            RFWLog.d("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchSingleVideoLayer error, videoInfo is null");
            return;
        }
        if (businessFeedData.isQCircleShareCardFeed() && businessFeedData.getVideoInfo() != null && !TextUtils.isEmpty(businessFeedData.getVideoInfo().actionUrl)) {
            eg.f.l(businessFeedData, context, aVar, j3);
            return;
        }
        if (videoInfo.actionType == 23 && !TextUtils.isEmpty(videoInfo.actionUrl) && o(videoInfo.actionUrl)) {
            RFWLog.d("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchSingleVideoLayer processSingleVideoItemClick scheme: " + videoInfo.actionUrl);
            ho.i.q(context, videoInfo.actionUrl);
            return;
        }
        int i16 = videoInfo.videoStatus;
        if (i16 == 3) {
            RFWLog.d("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchSingleVideoLayer error, transfer fail");
            return;
        }
        if (i16 == 1) {
            CellLocalInfo cellLocalInfo = businessFeedData.cellLocalInfo;
            if (cellLocalInfo != null && !TextUtils.isEmpty(cellLocalInfo.videoLocalUrl)) {
                str = businessFeedData.cellLocalInfo.videoLocalUrl;
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                RFWLog.d("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchSingleVideoLayer use videoLocalFileUrl: " + str);
                VideoUrl videoUrl = videoInfo.videoUrl;
                if (videoUrl == null || TextUtils.isEmpty(videoUrl.url)) {
                    VideoUrl videoUrl2 = new VideoUrl();
                    videoUrl2.url = str;
                    RFWLog.d("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchSingleVideoLayer local video: old: " + businessFeedData.cellVideoInfo.videoUrl + ", new: " + videoUrl2);
                    videoInfo.videoUrl = videoUrl2;
                }
            } else {
                RFWLog.d("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchSingleVideoLayer fail transfering and videoLocalFileUrl invalid: " + str);
                o.f59556a.d(videoInfo.toast, 0);
                return;
            }
        }
        if (xm.c.c() && videoInfo.isFakeFeed) {
            RFWLog.d("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchSingleVideoLayer fail, fake feed and canUseQQVideoLayer");
            o.f59556a.c(R.string.gpy, 0);
            return;
        }
        VideoUrl videoUrl3 = videoInfo.videoUrl;
        if (videoUrl3 != null && m(videoUrl3.url) && !new File(videoInfo.videoUrl.url).exists()) {
            RFWLog.d("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchSingleVideoLayer url is local path but not exist");
        } else if (xm.c.e(businessFeedData)) {
            RFWLog.d("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchSingleVideoLayer openQQVideoPlayer");
            com.qzone.reborn.qqvideo.layer.d.k(businessFeedData, context, aVar, j3);
        } else {
            RFWLog.d("QZoneGalleryLayerNativeLauncher", RFWLog.USR, "launchSingleVideoLayer normal");
            w(businessFeedData, i3, context, aVar, businessFeedData2);
        }
    }
}
