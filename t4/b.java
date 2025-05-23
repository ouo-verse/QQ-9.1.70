package t4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.qzone.album.business.albumlist.activity.QZonePersonalAlbumActivity;
import com.qzone.album.business.albumlist.fragment.AlbumListTabFragment;
import com.qzone.album.business.albumlist.fragment.AlbumRecentTabFragment;
import com.qzone.album.business.albumlist.fragment.AlbumVideoTabFragment;
import com.qzone.album.business.photolist.activity.QZonePersonalPhotoListActivity;
import com.qzone.album.business.search.SearchFilterComposition;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.common.activities.base.ak;
import com.qzone.common.event.EventCenter;
import com.qzone.detail.ui.component.FeedDetailCommentTips;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import ho.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k8.c;
import rk.e;
import rk.k;
import yo.d;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends a {

    /* renamed from: b, reason: collision with root package name */
    private final String f435373b = "AlbumEnvEntryPageSectionImp";

    private ImageView X(View view, int i3) {
        boolean n3 = e.n(i3);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() < (n3 ? 2 : 1)) {
                return null;
            }
            View childAt = viewGroup.getChildAt(n3 ? 1 : 0);
            if (childAt instanceof ImageView) {
                return (ImageView) childAt;
            }
        }
        return null;
    }

    private String Y(ArrayList<PhotoCacheData> arrayList, int i3, int i16) {
        if (arrayList != null && !arrayList.isEmpty() && i3 >= 0 && i3 < arrayList.size()) {
            if (e.n(i16) && arrayList.get(i3) != null && arrayList.get(i3).videodata != null) {
                return arrayList.get(i3).videodata.albumid;
            }
            if (arrayList.get(i3) != null) {
                return arrayList.get(i3).albumid;
            }
        }
        return "";
    }

    private void a0(Context context, Intent intent) {
        if (lc.b.d()) {
            i.x().l(context, new QZAlbumxUploadAlbumInitBean(LoginData.getInstance().getUinString(), 0, true, null, 0), intent);
        } else {
            i.w().h(context, new QZonePublishMoodInitBean(System.currentTimeMillis()), intent);
        }
    }

    @Override // t4.a
    public void A(Fragment fragment) {
        if (fragment instanceof AlbumRecentTabFragment) {
            EventCenter.getInstance().removeObserver((AlbumRecentTabFragment) fragment);
        } else {
            if (fragment instanceof AlbumVideoTabFragment) {
                EventCenter.getInstance().removeObserver((AlbumVideoTabFragment) fragment);
                return;
            }
            throw new RuntimeException("AlbumEnvEntryPageSectionImp albumRecentTabSpecRemoveObserver");
        }
    }

    @Override // t4.a
    public void B(Activity activity, long j3, ArrayList<AlbumCacheData> arrayList, ArrayList<PhotoCacheData> arrayList2, int i3, boolean z16, boolean z17, int i16, View view) {
        PhotoParam photoParam;
        if (!(activity instanceof QZonePersonalAlbumActivity) && !(activity instanceof QZonePersonalPhotoListActivity)) {
            throw new RuntimeException("AlbumEnvEntryPageSectionImp albumRecentTabSpecShowRecentAlbumPictureViewer");
        }
        ArrayList<PhotoParam> arrayList3 = new ArrayList<>();
        Iterator<AlbumCacheData> it = arrayList.iterator();
        while (it.hasNext()) {
            AlbumCacheData next = it.next();
            if (next != null) {
                PhotoParam photoParam2 = new PhotoParam();
                photoParam2.ownerUin = j3;
                photoParam2.feedUin = j3;
                photoParam2.albumid = next.albumid;
                photoParam2.albumType = next.albumtype;
                int i17 = next.albumnum;
                photoParam2.albumnum = i17;
                photoParam2.uploadnum = i17;
                photoParam2.albumPriv = next.albumrights;
                String str = next.albumanswer;
                photoParam2.albumanswer = str;
                if (str == null) {
                    photoParam2.albumanswer = "";
                }
                photoParam2.loginUin = LoginData.getInstance().getUin();
                photoParam2.cell_id = photoParam2.albumid;
                Map<Integer, String> map = next.busi_param;
                photoParam2.busi_param = map;
                if (map != null) {
                    photoParam2.orgKey = map.get(5);
                    photoParam2.curKey = photoParam2.busi_param.get(6);
                }
                photoParam2.mFromRecent = true;
                arrayList3.add(photoParam2);
            }
        }
        String Y = Y(arrayList2, i3, i16);
        Iterator<PhotoParam> it5 = arrayList3.iterator();
        while (true) {
            if (!it5.hasNext()) {
                photoParam = null;
                break;
            }
            photoParam = it5.next();
            String str2 = photoParam.albumid;
            if (str2 != null && str2.equals(Y)) {
                break;
            }
        }
        c.a m3 = new c.a().m(i16);
        k kVar = new k();
        kVar.v(arrayList2);
        kVar.g(i3);
        kVar.h(photoParam);
        kVar.w(j3);
        kVar.u(arrayList3);
        kVar.t(z16);
        kVar.i(0);
        kVar.q(m3);
        kVar.r(false);
        kVar.f(X(view, i16));
        if (e.n(i16)) {
            ((e) i.t(e.class)).z(activity, kVar);
        } else if (z17) {
            ((e) i.t(e.class)).y(activity, kVar);
        } else {
            ((e) i.t(e.class)).x(activity, kVar);
        }
    }

    @Override // t4.a
    public Activity E(Activity activity) {
        if (activity instanceof QZonePersonalAlbumActivity) {
            return ((QZonePersonalAlbumActivity) activity).T2();
        }
        QZLog.e("AlbumEnvEntryPageSectionImp", "baseActivityGetCurrentActivityInTabHost");
        return null;
    }

    @Override // t4.a
    public Handler F(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getHandler();
        }
        QZLog.e("AlbumEnvEntryPageSectionImp", "baseActivityGetHandler");
        return null;
    }

    @Override // t4.a
    public int G(Activity activity, View view) {
        if (activity instanceof BaseActivity) {
            return ((FeedDetailCommentTips) view).e();
        }
        throw new RuntimeException("baseTabSpecActivityGetFooterState");
    }

    @Override // t4.a
    public View H(Activity activity) {
        if (activity instanceof BaseActivity) {
            FeedDetailCommentTips feedDetailCommentTips = new FeedDetailCommentTips(activity, ((BaseActivity) activity).getHandler());
            View d16 = feedDetailCommentTips.d();
            if (d16 != null) {
                d16.setBackgroundDrawable(null);
            }
            feedDetailCommentTips.setLoadingDataText(activity.getString(R.string.f170931b54));
            feedDetailCommentTips.setLoadingMoreDataText(activity.getString(R.string.f170932b55));
            return feedDetailCommentTips;
        }
        throw new RuntimeException("AlbumEnvEntryPageSectionImp baseTabSpecActivityIsRefreshing");
    }

    @Override // t4.a
    public boolean I(Activity activity, View view) {
        if (activity instanceof BaseActivity) {
            return ((FeedDetailCommentTips) view).g();
        }
        throw new RuntimeException("baseTabSpecActivityIsFooterLoading");
    }

    @Override // t4.a
    public boolean J(Activity activity) {
        if (activity instanceof QZonePersonalAlbumActivity) {
            return ((QZonePersonalAlbumActivity) activity).S2();
        }
        QZLog.e("AlbumEnvEntryPageSectionImp", "baseTabSpecActivityIsRefreshing activity");
        return false;
    }

    @Override // t4.a
    public boolean K(Activity activity, View view) {
        if (!(activity instanceof BaseActivity)) {
            throw new RuntimeException("baseTabSpecActivityPreGetMore");
        }
        if (view == null) {
            return false;
        }
        return ((FeedDetailCommentTips) view).h();
    }

    @Override // t4.a
    public void L(Activity activity, View view, int i3) {
        if (activity instanceof BaseActivity) {
            ((FeedDetailCommentTips) view).setState(i3);
        } else {
            QZLog.e("AlbumEnvEntryPageSectionImp", "baseTabSpecActivityIsRefreshing");
        }
    }

    @Override // t4.a
    public void M(Activity activity) {
        if (activity instanceof QZonePersonalAlbumActivity) {
            ((QZonePersonalAlbumActivity) activity).V2();
        } else {
            QZLog.e("AlbumEnvEntryPageSectionImp", "baseTabSpecActivityShowNoNetworkTips");
        }
    }

    @Override // t4.a
    public boolean O(String str) {
        return com.qzone.album.base.b.a(str);
    }

    @Override // t4.a
    public String Q(Object obj) {
        if (obj instanceof ro.a) {
            return ((ro.a) obj).c();
        }
        throw new RuntimeException("AlbumEnvEntryPageSectionImp getReferAndResetReferBag");
    }

    @Override // t4.a
    public String R(Object obj) {
        if (obj instanceof ro.a) {
            return ((ro.a) obj).b();
        }
        throw new RuntimeException("AlbumEnvEntryPageSectionImp getReferFromReferBag");
    }

    @Override // t4.a
    public void V(String str, boolean z16) {
        com.qzone.album.base.b.b(str, z16);
    }

    public String W(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("getActiveFeeds")) {
                return QzoneVideoBeaconReport.EVENT_ALBUM_BANNER_ADD_ALBUM;
            }
            if (str.equals(QZoneHelper.QZoneAppConstants.REFER_QQ_SETTING)) {
                return QzoneVideoBeaconReport.EVENT_ALBUM_LIST_ADD_ALBUM;
            }
            return QzoneVideoBeaconReport.EVENT_ALBUM_OTHER_ADD_ALBUM;
        }
        return "";
    }

    @Override // t4.a
    public void a(Activity activity) {
        if (activity instanceof QZonePersonalAlbumActivity) {
            QZonePersonalAlbumActivity qZonePersonalAlbumActivity = (QZonePersonalAlbumActivity) activity;
            EventCenter.getInstance().addUIObserver(qZonePersonalAlbumActivity, "WriteOperation", 11, 34, 45, 8);
            EventCenter.getInstance().addUIObserver(qZonePersonalAlbumActivity, "QzoneAlbum", 4, 5, 28, 17, 18, 19);
            EventCenter.getInstance().addUIObserver(qZonePersonalAlbumActivity, "QzoneAlbum", 1002);
            EventCenter.getInstance().addUIObserver(qZonePersonalAlbumActivity, "UnRead", 1);
            EventCenter.getInstance().addUIObserver(qZonePersonalAlbumActivity, "LocalPhotoCardView", 5);
            return;
        }
        QZLog.e("AlbumEnvEntryPageSectionImp", "albumActivityAddObserver");
    }

    @Override // t4.a
    public long c(Activity activity, Intent intent) {
        if (activity instanceof QZonePersonalAlbumActivity) {
            return intent.getLongExtra("key_album_owner_uin", 0L);
        }
        QZLog.e("AlbumEnvEntryPageSectionImp", "albumActivityGetUinFromIntent");
        return 0L;
    }

    @Override // t4.a
    public void d(Activity activity) {
        if (activity instanceof QZonePersonalAlbumActivity) {
            EventCenter.getInstance().removeObserver((QZonePersonalAlbumActivity) activity);
        }
    }

    @Override // t4.a
    public void e(Activity activity) {
        if (activity instanceof QZonePersonalAlbumActivity) {
            String str = QZonePersonalAlbumActivity.f42065f0;
            String W = W(str);
            if (str == null) {
                str = "getApplist";
            }
            ClickReport.e(4, str, 307, 4, 1);
            Intent E = ak.E(activity, 0, null, null, str + Z(1), 12);
            E.putExtra("IsBack", true);
            E.putExtra(QzoneVideoBeaconReport.BEACON_SOURCE, W);
            E.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_TYPE, 1);
            a0(activity, E);
            return;
        }
        QZLog.e("AlbumEnvEntryPageSectionImp", "albumActivityStartSelectPhotoActivity");
    }

    @Override // t4.a
    public void f(Fragment fragment, String str, int i3) {
        if (fragment instanceof AlbumListTabFragment) {
            AlbumListTabFragment albumListTabFragment = (AlbumListTabFragment) fragment;
            if (com.qzone.common.business.service.b.a(albumListTabFragment.C.getHostActivity())) {
                String W = W(str);
                if (str == null) {
                    str = "getApplist";
                }
                Intent E = ak.E(albumListTabFragment.C.getHostActivity(), 0, null, null, str + Z(1), 12);
                E.putExtra("IsBack", true);
                E.putExtra(QzoneVideoBeaconReport.BEACON_SOURCE, W);
                E.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_TYPE, 1);
                E.putExtra("UploadPhoto.key_from_create_new_album", true);
                a0(fragment.getContext(), E);
                return;
            }
            return;
        }
        QZLog.e("AlbumEnvEntryPageSectionImp", "albumActivityStartSelectPhotoActivity call failed");
    }

    @Override // t4.a
    public void g(Activity activity) {
        if (activity instanceof QZonePersonalAlbumActivity) {
            if (com.qzone.common.business.service.b.a(activity)) {
                String str = QZonePersonalAlbumActivity.f42065f0;
                if (str == null) {
                    str = "getApplist";
                }
                ClickReport.e(4, str, 307, 4, 1);
                Intent E = ak.E(activity, 0, null, null, str + Z(10), 12);
                E.putExtra("IsBack", true);
                E.putExtra(QAlbumConstants.ALBUM_NAME, QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumRecentlyVideo", "\u6700\u8fd1\u89c6\u9891"));
                E.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_TYPE, 10);
                a0(activity, E);
                return;
            }
            return;
        }
        QZLog.e("AlbumEnvEntryPageSectionImp", "albumActivityStartSelectVideoActivity");
    }

    @Override // t4.a
    public void h(Intent intent) {
        PerfTracer.traceClick2Activity(intent);
    }

    @Override // t4.a
    public void i() {
        PerfTracer.traceEnd(PerfTracer.QZONEALBUM_INITDATA);
    }

    @Override // t4.a
    public void j() {
        PerfTracer.trace(PerfTracer.QZONEALBUM_INITUI, PerfTracer.QZONEALBUM_INITDATA);
    }

    @Override // t4.a
    public void k() {
        PerfTracer.trace(PerfTracer.QZONEALBUM_PARSEINTENT, PerfTracer.QZONEALBUM_INITUI);
    }

    @Override // t4.a
    public void l() {
        PerfTracer.traceStart(PerfTracer.QZONEALBUM_PARSEINTENT);
    }

    @Override // t4.a
    public boolean m() {
        String[] split;
        String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_NEW_ALBUM_CHOOSE_ORDER, "0-0");
        int[] iArr = new int[2];
        if (!TextUtils.isEmpty(config) && (split = config.split("-")) != null && split.length >= 2) {
            iArr[0] = Integer.parseInt(split[0]);
            iArr[1] = Integer.parseInt(split[1]);
        }
        long uin = LoginData.getInstance().getUin() % 100;
        return uin >= ((long) iArr[0]) && uin < ((long) iArr[1]);
    }

    @Override // t4.a
    public void n(Fragment fragment) {
        if (fragment instanceof AlbumListTabFragment) {
            EventCenter.getInstance().addUIObserver((AlbumListTabFragment) fragment, "QzoneAlbum", 2, 10, 25);
            return;
        }
        throw new RuntimeException("AlbumEnvEntryPageSectionImp albumListTabSpecAddObserver");
    }

    @Override // t4.a
    public Intent p(Fragment fragment, String str) {
        if (fragment instanceof AlbumListTabFragment) {
            return ak.o(((AlbumListTabFragment) fragment).C.getHostActivity(), str);
        }
        throw new RuntimeException("AlbumEnvEntryPageSectionImp albumListTabSpecGetPersonalAlbumActivityIntent");
    }

    @Override // t4.a
    public void r(Fragment fragment, int i3) {
        if (fragment instanceof AlbumListTabFragment) {
            fragment.startActivityForResult(ak.o(((AlbumListTabFragment) fragment).C.getHostActivity(), QZonePersonalAlbumActivity.f42065f0), i3);
            return;
        }
        throw new RuntimeException("AlbumEnvEntryPageSectionImp albumListTabSpecJumpToNewAlbum");
    }

    @Override // t4.a
    public void s(Fragment fragment, Intent intent) {
        if (fragment instanceof AlbumListTabFragment) {
            BusinessAlbumInfo businessAlbumInfo = (BusinessAlbumInfo) intent.getParcelableExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO);
            boolean booleanExtra = intent.getBooleanExtra("isPhotoListSkipAfterAlbum", false);
            Intent I = ak.I(((AlbumListTabFragment) fragment).C.getHostActivity(), businessAlbumInfo, 0);
            I.putExtra("isPhotoListSkipAfterAlbum", booleanExtra);
            fragment.startActivity(I);
            return;
        }
        throw new RuntimeException("AlbumEnvEntryPageSectionImpalbumListTabSpecJumpToPhotoList");
    }

    @Override // t4.a
    public void t(Fragment fragment, ArrayList<String> arrayList) {
        if (fragment instanceof AlbumListTabFragment) {
            Intent D = ak.D(((AlbumListTabFragment) fragment).C.getHostActivity(), 0, null, null, 12);
            D.putStringArrayListExtra("QZoneUploadPhotoActivity.key_selected_image_path", arrayList);
            D.putExtra("IsBack", true);
            D.putExtra("refer", QZonePersonalAlbumActivity.f42065f0);
            D.putExtra("QZonePersonalAlbumListt.key_recent_photo", true);
            D.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_TYPE, 5);
            a0(fragment.getContext(), D);
            return;
        }
        throw new RuntimeException("AlbumEnvEntryPageSectionImp albumListTabSpecJumpToUpload");
    }

    @Override // t4.a
    public void u(Activity activity, BaseAdapter baseAdapter) {
        if (activity instanceof QZonePersonalAlbumActivity) {
            ((QZonePersonalAlbumActivity) activity).U2(baseAdapter);
            return;
        }
        throw new RuntimeException("AlbumEnvEntryPageSectionImpalbumListTabSpecNotifyAdapter");
    }

    @Override // t4.a
    public void v() {
        PerfTracer.traceEnd(PerfTracer.QZONEALBUM_ONCREATE);
    }

    @Override // t4.a
    public void w() {
        PerfTracer.traceStart(PerfTracer.QZONEALBUM_ONCREATE);
    }

    @Override // t4.a
    public void x(Fragment fragment) {
        if (fragment instanceof AlbumListTabFragment) {
            EventCenter.getInstance().removeObserver((AlbumListTabFragment) fragment);
            return;
        }
        throw new RuntimeException("AlbumEnvEntryPageSectionImp albumListTabSpecRemoveObserver");
    }

    @Override // t4.a
    public int y(Fragment fragment, String str, String str2) {
        if (fragment instanceof AlbumListTabFragment) {
            return d.d(str, ((AlbumListTabFragment) fragment).C.getHostActivity(), null);
        }
        throw new RuntimeException("AlbumEnvEntryPageSectionImp albumListTabSpecSchemeToPhotoList");
    }

    @Override // t4.a
    public void z(Fragment fragment) {
        if (fragment instanceof AlbumRecentTabFragment) {
            AlbumRecentTabFragment albumRecentTabFragment = (AlbumRecentTabFragment) fragment;
            EventCenter.getInstance().addUIObserver(albumRecentTabFragment, "WriteOperation", 8, 18, 47, 40, 7, 48, 4);
            EventCenter.getInstance().addUIObserver(albumRecentTabFragment, "QzoneAlbum", 4, 8, 9, 24, 31);
        } else {
            if (fragment instanceof AlbumVideoTabFragment) {
                AlbumVideoTabFragment albumVideoTabFragment = (AlbumVideoTabFragment) fragment;
                EventCenter.getInstance().addUIObserver(albumVideoTabFragment, "WriteOperation", 8, 18, 47, 40, 7, 48, 4);
                EventCenter.getInstance().addUIObserver(albumVideoTabFragment, "QzoneAlbum", 4, 8, 9);
                EventCenter.getInstance().addUIObserver(albumVideoTabFragment, "QzoneAlbum", 1001);
                return;
            }
            throw new RuntimeException("AlbumEnvEntryPageSectionImp albumRecentTabSpecAddObserver");
        }
    }

    @Override // t4.a
    public Intent U(Activity activity, AlbumCacheData albumCacheData, int i3, String str, long j3) {
        if (activity instanceof QZonePersonalPhotoListActivity) {
            return ak.H(activity, albumCacheData.albumid, albumCacheData.albumname, Long.valueOf(j3), albumCacheData.albumquestion, albumCacheData.busi_param, i3, str, albumCacheData.albumtype, false);
        }
        throw new RuntimeException("AlbumEnvEntryPageSectionImp albumListTabSpecGetPersonalAlbumActivityIntent");
    }

    @Override // t4.a
    public Intent q(Fragment fragment, AlbumCacheData albumCacheData, int i3, String str, long j3) {
        if (fragment instanceof AlbumListTabFragment) {
            return ak.H(((AlbumListTabFragment) fragment).C.getHostActivity(), albumCacheData.albumid, albumCacheData.albumname, Long.valueOf(j3), albumCacheData.albumquestion, albumCacheData.busi_param, i3, str, albumCacheData.albumtype, false);
        }
        throw new RuntimeException("AlbumEnvEntryPageSectionImp albumListTabSpecGetPersonalAlbumAnswerActivityIntent");
    }

    private String Z(int i3) {
        if (i3 == 1) {
            return ".getApplist.localphoto";
        }
        return "";
    }

    @Override // t4.a
    public boolean b(Intent intent) {
        if (intent != null) {
            return intent.getBooleanExtra(QZoneHelper.QZoneAlbumConstants.CANCELED_FROM_CHOOSE_LOCAL_PHOTO, false);
        }
        return false;
    }

    @Override // t4.a
    public Intent P(Activity activity, AlbumCacheData albumCacheData, long j3) {
        if (albumCacheData == null) {
            return null;
        }
        BusinessAlbumInfo createFrom = BusinessAlbumInfo.createFrom(albumCacheData.albumid, albumCacheData.albumtype, albumCacheData.albumname, albumCacheData.getLloc(), albumCacheData.albumrights, albumCacheData.albumnum, albumCacheData.anonymity, albumCacheData.individual, albumCacheData.operatemask, albumCacheData.allow_share, albumCacheData.isSharingAlbumOnServer(), com.qzone.album.util.b.a(albumCacheData), albumCacheData.isSharingOwner);
        createFrom.mUin = j3;
        createFrom.mCover = albumCacheData.getLloc();
        createFrom.isIndividualityAlbum = albumCacheData.individual != 0;
        createFrom.sortType = albumCacheData.sortType;
        return ak.I(activity, createFrom, 0);
    }

    @Override // t4.a
    public void o(Fragment fragment, AlbumCacheData albumCacheData, long j3) {
        if (!(fragment instanceof AlbumListTabFragment)) {
            throw new RuntimeException("AlbumEnvEntryPageSectionImp albumListTabSpecEnterPhotoListActivity");
        }
        if (albumCacheData == null) {
            return;
        }
        PerfTracer.traceStart(PerfTracer.QZONEALBUM_SHOW);
        com.qzone.album.env.common.a.m().P(326, 11, "1", true, null);
        fragment.startActivityForResult(P(((AlbumListTabFragment) fragment).C.getHostActivity(), albumCacheData, j3), 3);
        int albumThemeTypeValue = albumCacheData.getAlbumThemeTypeValue();
        if (albumThemeTypeValue == 1) {
            ClickReport.r("", "", "", true, "56", "1");
            return;
        }
        if (albumThemeTypeValue == 8) {
            com.qzone.album.env.common.a.m().P(326, 11, "1", true, null);
            ClickReport.r("", "", "", true, "56", "2");
        } else if (albumThemeTypeValue == 9) {
            com.qzone.album.env.common.a.m().P(326, 13, "1", true, null);
            ClickReport.r("", "", "", true, "56", "3");
        } else if (albumThemeTypeValue == 11) {
            com.qzone.album.env.common.a.m().P(326, 12, "1", true, null);
        } else {
            if (albumThemeTypeValue != 12) {
                return;
            }
            com.qzone.album.env.common.a.m().P(326, 14, "1", true, null);
        }
    }

    @Override // t4.a
    public Intent T(Activity activity, AlbumCacheData albumCacheData, long j3, SearchFilterComposition searchFilterComposition) {
        if (activity == null || albumCacheData == null || searchFilterComposition == null || !searchFilterComposition.isDataValid()) {
            return null;
        }
        BusinessAlbumInfo createFrom = BusinessAlbumInfo.createFrom(albumCacheData.albumid, albumCacheData.albumtype, albumCacheData.albumname, albumCacheData.getLloc(), albumCacheData.albumrights, albumCacheData.albumnum, albumCacheData.anonymity, 0L, albumCacheData.operatemask, albumCacheData.allow_share, false, com.qzone.album.util.b.a(albumCacheData), false);
        createFrom.mUin = j3;
        createFrom.mCover = albumCacheData.getLloc();
        createFrom.isIndividualityAlbum = false;
        createFrom.sortType = albumCacheData.sortType;
        Intent I = ak.I(activity, createFrom, 4);
        I.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_PHOTO_SORT_TYPE, 5);
        SearchFilterComposition.serializeMeToIntent(I, searchFilterComposition);
        return I;
    }

    @Override // t4.a
    public void C(Activity activity, long j3, AlbumCacheData albumCacheData, SearchFilterComposition searchFilterComposition, int i3, List<PhotoCacheData> list, int i16, boolean z16, String str) {
        PictureViewerFactory.Y(activity, j3, albumCacheData, i3, list, i16, searchFilterComposition, str, z16, 0);
    }

    @Override // t4.a
    public void D(Activity activity, long j3, AlbumCacheData albumCacheData, SearchFilterComposition searchFilterComposition, int i3, List<PhotoCacheData> list, int i16, boolean z16, String str, int i17, ArrayList<String> arrayList, int i18, int i19) {
        PictureViewerFactory.a0(activity, j3, albumCacheData, i3, list, i16, searchFilterComposition, str, z16, i17, arrayList, i18, i19);
    }
}
