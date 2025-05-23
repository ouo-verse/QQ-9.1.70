package rk;

import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.reborn.layer.route.QZoneLocalLayerExtraInfoBean;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.util.ArrayUtils;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b+\u0010,J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0014\u0010\u0010\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R2\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\"\u0010*\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u001d\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010!\u00a8\u0006-"}, d2 = {"Lrk/j;", "Lo9/a;", "", "Lcom/qzone/proxy/feedcomponent/model/PictureItem;", "pictureItemList", "Lcooperation/qzone/model/PhotoInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "items", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "photoInfo", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo;", "mediaInfo", "", "p", "mediaList", "r", "Ljava/util/ArrayList;", "Lcom/qzone/reborn/layer/route/QZoneLocalLayerExtraInfoBean;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "u", "()Ljava/util/ArrayList;", "setExtraInfoBeanList", "(Ljava/util/ArrayList;)V", "extraInfoBeanList", "", "D", "I", "t", "()I", HippyTKDListViewAdapter.X, "(I)V", "editBtnType", "E", ReportConstant.COSTREPORT_PREFIX, "w", "delBtnType", UserInfo.SEX_FEMALE, "v", "y", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class j extends o9.a {

    /* renamed from: D, reason: from kotlin metadata */
    private int editBtnType;

    /* renamed from: F, reason: from kotlin metadata */
    private int showType;

    /* renamed from: C, reason: from kotlin metadata */
    private ArrayList<QZoneLocalLayerExtraInfoBean> extraInfoBeanList = new ArrayList<>();

    /* renamed from: E, reason: from kotlin metadata */
    private int delBtnType = 1;

    private final void p(PhotoInfo photoInfo, RFWLayerPicInfo mediaInfo) {
        PictureUrl pictureUrl;
        PictureViewerFactory.b(photoInfo, mediaInfo);
        VideoInfo videoInfo = photoInfo.videodata;
        String str = (videoInfo == null || (pictureUrl = videoInfo.coverUrl) == null) ? null : pictureUrl.url;
        if (str == null) {
            str = "";
        }
        mediaInfo.getCurrentPicInfo().setUrl(str);
        RFWLayerPicInfo.RFWPicInfo bigPicInfo = mediaInfo.getBigPicInfo();
        if (bigPicInfo == null) {
            return;
        }
        bigPicInfo.setUrl(str);
    }

    private final List<RFWLayerItemMediaInfo> q(List<? extends PhotoInfo> items) {
        ArrayList arrayList = new ArrayList();
        for (PhotoInfo photoInfo : items) {
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
            RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
            rFWLayerPicInfo.setPicId(photoInfo.getPicId());
            if (photoInfo.videodata != null && photoInfo.isVideo()) {
                PictureViewerFactory.c(photoInfo, rFWLayerItemMediaInfo);
                p(photoInfo, rFWLayerPicInfo);
            } else {
                PictureViewerFactory.b(photoInfo, rFWLayerPicInfo);
            }
            rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
            arrayList.add(rFWLayerItemMediaInfo);
        }
        return arrayList;
    }

    private final List<PhotoInfo> z(List<? extends PictureItem> pictureItemList) {
        ArrayList arrayList = new ArrayList();
        for (PictureItem pictureItem : pictureItemList) {
            PhotoInfo photoInfo = new PhotoInfo();
            PictureViewerFactory.j0(photoInfo, pictureItem, false);
            if (TextUtils.isEmpty(photoInfo.lloc)) {
                photoInfo.lloc = pictureItem.localFileUrl;
            }
            arrayList.add(photoInfo);
        }
        return arrayList;
    }

    public final void r(List<? extends PictureItem> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return;
        }
        List<PhotoInfo> z16 = z(mediaList);
        for (PhotoInfo photoInfo : z16) {
            QZoneLocalLayerExtraInfoBean qZoneLocalLayerExtraInfoBean = new QZoneLocalLayerExtraInfoBean();
            qZoneLocalLayerExtraInfoBean.b(photoInfo);
            this.extraInfoBeanList.add(qZoneLocalLayerExtraInfoBean);
        }
        List<RFWLayerItemMediaInfo> q16 = q(z16);
        Intrinsics.checkNotNull(q16, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo>");
        o((ArrayList) q16);
    }

    /* renamed from: s, reason: from getter */
    public final int getDelBtnType() {
        return this.delBtnType;
    }

    /* renamed from: t, reason: from getter */
    public final int getEditBtnType() {
        return this.editBtnType;
    }

    public final ArrayList<QZoneLocalLayerExtraInfoBean> u() {
        return this.extraInfoBeanList;
    }

    /* renamed from: v, reason: from getter */
    public final int getShowType() {
        return this.showType;
    }

    public final void w(int i3) {
        this.delBtnType = i3;
    }

    public final void x(int i3) {
        this.editBtnType = i3;
    }

    public final void y(int i3) {
        this.showType = i3;
    }
}
