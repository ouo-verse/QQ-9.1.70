package uk;

import NS_MOBILE_FEEDS.cell_video;
import NS_MOBILE_FEEDS.s_picurl;
import NS_MOBILE_FEEDS.s_videourl;
import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.Photo;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.preview.business.BasePicureViewController;
import com.qzone.preview.service.QZoneAlbumRequestBuilder;
import com.qzone.reborn.layer.part.ac;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.component.media.image.ImageKey;
import com.tencent.libra.request.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.remote.Callback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class a extends ViewModel implements Callback {
    protected List<PhotoInfo> C;

    /* renamed from: i, reason: collision with root package name */
    public MutableLiveData<UIStateData<QZoneResult>> f439100i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    protected PhotoParam f439101m;

    public void L1(Photo photo, RFWLayerItemMediaInfo rFWLayerItemMediaInfo) {
        s_picurl s_picurlVar;
        Map<Integer, s_picurl> map = photo.videodata.coverurl;
        if (map == null || (s_picurlVar = map.get(11)) == null || TextUtils.isEmpty(s_picurlVar.url)) {
            return;
        }
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        rFWLayerPicInfo.setPicId(photo.lloc);
        rFWLayerPicInfo.setCurrentPicInfo(new RFWLayerPicInfo.RFWPicInfo());
        rFWLayerPicInfo.getCurrentPicInfo().setUrl(s_picurlVar.url);
        rFWLayerPicInfo.getCurrentPicInfo().setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(s_picurlVar.url)));
        rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
    }

    protected void M1(PhotoInfo photoInfo, RFWLayerItemMediaInfo rFWLayerItemMediaInfo) {
        rFWLayerItemMediaInfo.setExtraData(photoInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N1(Photo photo, RFWLayerItemMediaInfo rFWLayerItemMediaInfo, boolean z16, PhotoInfo photoInfo) {
        if (rFWLayerItemMediaInfo.getLayerPicInfo() != null) {
            return;
        }
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
        String str = photo.bigurl;
        String str2 = photo.url;
        if (!z16) {
            rFWLayerPicInfo.setPicId(photo.lloc);
        } else if (!TextUtils.isEmpty(str)) {
            rFWLayerPicInfo.setPicId(ImageKey.getUrlKey(str, true));
        }
        if (!TextUtils.isEmpty(str)) {
            rFWLayerPicInfo.setBigPicInfo(new RFWLayerPicInfo.RFWPicInfo());
            rFWLayerPicInfo.getBigPicInfo().setUrl(str);
            rFWLayerPicInfo.getBigPicInfo().setWidth(photo.width);
            rFWLayerPicInfo.getBigPicInfo().setHeight(photo.height);
            rFWLayerPicInfo.getBigPicInfo().setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(str)));
        }
        if (!TextUtils.isEmpty(photo.downloadURL)) {
            rFWLayerPicInfo.setDownloadPicInfo(new RFWLayerPicInfo.RFWPicInfo());
            rFWLayerPicInfo.getDownloadPicInfo().setUrl(photo.downloadURL);
            rFWLayerPicInfo.getDownloadPicInfo().setWidth(photo.width);
            rFWLayerPicInfo.getDownloadPicInfo().setHeight(photo.height);
            rFWLayerPicInfo.getDownloadPicInfo().setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(photo.downloadURL)));
        }
        if (!TextUtils.isEmpty(str2) && photo.videoflag != 1) {
            rFWLayerPicInfo.setOriginPicInfo(new RFWLayerPicInfo.RFWPicInfo());
            rFWLayerPicInfo.getOriginPicInfo().setUrl(str2);
            rFWLayerPicInfo.getOriginPicInfo().setSize(photo.origin_size);
            rFWLayerPicInfo.getOriginPicInfo().setWidth(photo.width);
            rFWLayerPicInfo.getOriginPicInfo().setHeight(photo.height);
            rFWLayerPicInfo.getOriginPicInfo().setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(str2)));
        }
        boolean z17 = rFWLayerPicInfo.getBigPicInfo() == null && rFWLayerPicInfo.getDownloadPicInfo() == null && rFWLayerPicInfo.getOriginPicInfo() == null;
        boolean z18 = (photoInfo == null || z16 || TextUtils.isEmpty(photoInfo.currentUrl)) ? false : true;
        if (z17 && z18) {
            rFWLayerPicInfo.setSmallPicInfo(new RFWLayerPicInfo.RFWPicInfo());
            rFWLayerPicInfo.getSmallPicInfo().setUrl(photoInfo.currentUrl);
            rFWLayerPicInfo.getSmallPicInfo().setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(photoInfo.currentUrl)));
        }
        if (rFWLayerPicInfo.getOriginPicInfo() != null && RFWFileUtils.fileExists(rFWLayerPicInfo.getOriginPicInfo().getLocalPath())) {
            rFWLayerPicInfo.setCurrentPicInfo(rFWLayerPicInfo.getOriginPicInfo());
            return;
        }
        if (rFWLayerPicInfo.getBigPicInfo() != null && RFWFileUtils.fileExists(rFWLayerPicInfo.getBigPicInfo().getLocalPath())) {
            rFWLayerPicInfo.setCurrentPicInfo(rFWLayerPicInfo.getBigPicInfo());
            return;
        }
        if (!TextUtils.isEmpty(photo.currenturl)) {
            rFWLayerPicInfo.setCurrentPicInfo(new RFWLayerPicInfo.RFWPicInfo());
            rFWLayerPicInfo.getCurrentPicInfo().setUrl(photo.currenturl);
            rFWLayerPicInfo.getCurrentPicInfo().setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(photo.currenturl)));
        } else if (rFWLayerPicInfo.getBigPicInfo() != null) {
            rFWLayerPicInfo.setCurrentPicInfo(rFWLayerPicInfo.getBigPicInfo());
        } else if (rFWLayerPicInfo.getDownloadPicInfo() != null) {
            rFWLayerPicInfo.setCurrentPicInfo(rFWLayerPicInfo.getDownloadPicInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P1(Photo photo, RFWLayerItemMediaInfo rFWLayerItemMediaInfo) {
        s_videourl s_videourlVar;
        RFWLayerVideoInfo rFWLayerVideoInfo = new RFWLayerVideoInfo();
        cell_video cell_videoVar = photo.videodata;
        if (cell_videoVar == null) {
            RFWLog.e("QZoneFeedxBaseLayerViewModel", RFWLog.USR, "error video data");
            return;
        }
        if (TextUtils.isEmpty(cell_videoVar.videourl)) {
            RFWLog.e("QZoneFeedxBaseLayerViewModel", RFWLog.USR, "invalid photo info id is " + photo.lloc);
        }
        rFWLayerVideoInfo.setNormalVideoUrl(tk.h.r(PictureViewerFactory.r(com.qzone.proxy.feedcomponent.util.e.s(photo.videodata))));
        rFWLayerVideoInfo.setFileId(photo.videodata.videoid);
        Map<Integer, s_videourl> map = photo.videodata.videourls;
        if (map != null && (s_videourlVar = map.get(3)) != null) {
            rFWLayerVideoInfo.setVideoOriginUrl(s_videourlVar.url);
        }
        String str = "";
        if (ac.J.contains(rFWLayerVideoInfo.getPlayId())) {
            if (!TextUtils.isEmpty(rFWLayerVideoInfo.getVideoOriginUrl())) {
                str = rFWLayerVideoInfo.getVideoOriginUrl();
            }
            rFWLayerVideoInfo.setCurrentVideoUrl(str);
        } else {
            if (!TextUtils.isEmpty(rFWLayerVideoInfo.getNormalVideoUrl())) {
                str = rFWLayerVideoInfo.getNormalVideoUrl();
            }
            rFWLayerVideoInfo.setCurrentVideoUrl(str);
        }
        rFWLayerItemMediaInfo.setLayerVideoInfo(rFWLayerVideoInfo);
    }

    protected boolean Q1(List<Photo> list) {
        if (list.size() < 2) {
            return false;
        }
        String str = list.get(0).lloc;
        String str2 = list.get(1).lloc;
        String str3 = list.get(0).sloc;
        String str4 = list.get(1).sloc;
        QLog.i("QZoneFeedxLayerControlPart", 1, "firstId: " + str + " secondId:" + str2 + "firstSId:" + str3 + " secondSId:" + str4);
        return (!TextUtils.isEmpty(str) && Objects.equals(str, str2)) || (!TextUtils.isEmpty(str3) && Objects.equals(str3, str4));
    }

    public List<RFWLayerItemMediaInfo> R1(ArrayList<Photo> arrayList, Album album) {
        ArrayList arrayList2 = new ArrayList();
        boolean Q1 = Q1(arrayList);
        Iterator<Photo> it = arrayList.iterator();
        while (it.hasNext()) {
            Photo next = it.next();
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
            PhotoInfo photoInfo = new PhotoInfo();
            PhotoInfo T1 = T1(next);
            BasePicureViewController.f1(album, arrayList.size(), photoInfo, next, this.f439101m);
            O1(photoInfo);
            if (X1(next)) {
                L1(next, rFWLayerItemMediaInfo);
                P1(next, rFWLayerItemMediaInfo);
            }
            N1(next, rFWLayerItemMediaInfo, Q1, T1);
            M1(photoInfo, rFWLayerItemMediaInfo);
            arrayList2.add(rFWLayerItemMediaInfo);
        }
        return arrayList2;
    }

    public ArrayList<PhotoInfo> S1(ArrayList<Photo> arrayList, Album album) {
        ArrayList<PhotoInfo> arrayList2 = new ArrayList<>();
        Iterator<Photo> it = arrayList.iterator();
        while (it.hasNext()) {
            Photo next = it.next();
            PhotoInfo photoInfo = new PhotoInfo();
            BasePicureViewController.f1(album, arrayList.size(), photoInfo, next, this.f439101m);
            arrayList2.add(photoInfo);
        }
        return arrayList2;
    }

    protected PhotoInfo T1(Photo photo) {
        for (PhotoInfo photoInfo : this.C) {
            if (Objects.equals(photoInfo.getPicId(), photo.lloc) && !TextUtils.isEmpty(photoInfo.lloc)) {
                return photoInfo;
            }
        }
        return null;
    }

    public List<PhotoInfo> U1() {
        return this.C;
    }

    public PhotoParam W1() {
        PhotoParam photoParam = this.f439101m;
        return photoParam == null ? new PhotoParam() : photoParam;
    }

    public abstract void Z1(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder);

    public void a2(List<PhotoInfo> list) {
        this.C = list;
    }

    public void b2(PhotoParam photoParam) {
        this.f439101m = photoParam;
    }

    @Override // cooperation.qzone.remote.Callback
    public void onResult(Object obj) {
        if (obj instanceof QZoneResult) {
            this.f439100i.postValue(UIStateData.obtainSuccess(false).setDataList((QZoneResult) obj));
        }
    }

    protected boolean X1(Photo photo) {
        return (photo == null || photo.videodata == null || photo.videoflag != 1) ? false : true;
    }

    protected void O1(PhotoInfo photoInfo) {
    }
}
