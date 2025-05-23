package sj;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean;
import com.qzone.reborn.intimate.layer.bean.QZIntimateLayerExtraInfoBean;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StImage;
import qzone.QZoneBaseMeta$StMedia;
import qzone.QZoneBaseMeta$StVideo;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u0000 L2\u00020\u0001:\u0001MB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\u001e\u0010\u001e\u001a\u00020\u00062\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001bj\b\u0012\u0004\u0012\u00020\u0002`\u001cJ \u0010\u001f\u001a\u00020\u00062\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001bj\b\u0012\u0004\u0012\u00020\u0002`\u001cH\u0016J\u0010\u0010!\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u0002H\u0004J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0004R2\u0010(\u001a\u0012\u0012\u0004\u0012\u00020 0\u001bj\b\u0012\u0004\u0012\u00020 `\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010.\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00101\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010)\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\"\u00104\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010)\u001a\u0004\b2\u0010+\"\u0004\b3\u0010-R\"\u0010:\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010B\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010E\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010)\u001a\u0004\bC\u0010+\"\u0004\bD\u0010-R\"\u0010I\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u00105\u001a\u0004\bG\u00107\"\u0004\bH\u00109\u00a8\u0006N"}, d2 = {"Lsj/d;", "Lo9/a;", "Lqzone/QZoneBaseMeta$StMedia;", "stMedia", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mediaInfo", "", ReportConstant.COSTREPORT_PREFIX, "", BdhLogUtil.LogTag.Tag_Conn, "D", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo;", "layerPicInfo", "t", "Lqzone/QZoneBaseMeta$StImage;", "stImage", "p", "r", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$RFWPicInfo;", "currentPicInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "", "width", UserInfo.SEX_FEMALE, "height", "E", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mediaList", "w", HippyTKDListViewAdapter.X, "Lcom/qzone/reborn/intimate/layer/bean/QZIntimateLayerExtraInfoBean;", "v", "y", "Ljava/util/ArrayList;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/util/ArrayList;", "setExtraInfoBeanList", "(Ljava/util/ArrayList;)V", "extraInfoBeanList", "Ljava/lang/String;", "getLeftAttachInfo", "()Ljava/lang/String;", "setLeftAttachInfo", "(Ljava/lang/String;)V", "leftAttachInfo", "G", "a0", "rightAttachInfo", "M", "c0", "spaceId", "I", "getRightBoundIndex", "()I", "b0", "(I)V", "rightBoundIndex", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;", "H", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;", "V", "(Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;)V", "albumDetailInitBean", "B", "Z", "feedId", "J", "N", "d0", "spaceType", "<init>", "()V", "K", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public class d extends o9.a {

    /* renamed from: G, reason: from kotlin metadata */
    private int rightBoundIndex;

    /* renamed from: H, reason: from kotlin metadata */
    private QZoneIntimateAlbumDetailInitBean albumDetailInitBean;

    /* renamed from: J, reason: from kotlin metadata */
    private int spaceType;

    /* renamed from: C, reason: from kotlin metadata */
    private ArrayList<QZIntimateLayerExtraInfoBean> extraInfoBeanList = new ArrayList<>();

    /* renamed from: D, reason: from kotlin metadata */
    private String leftAttachInfo = "";

    /* renamed from: E, reason: from kotlin metadata */
    private String rightAttachInfo = "";

    /* renamed from: F, reason: from kotlin metadata */
    private String spaceId = "";

    /* renamed from: I, reason: from kotlin metadata */
    private String feedId = "";

    private final String C(QZoneBaseMeta$StMedia stMedia) {
        PBStringField pBStringField;
        QZoneBaseMeta$StImage qZoneBaseMeta$StImage;
        PBStringField pBStringField2;
        String str = null;
        if (stMedia.type.get() == 1) {
            QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo = stMedia.video;
            if (qZoneBaseMeta$StVideo != null && (qZoneBaseMeta$StImage = qZoneBaseMeta$StVideo.cover) != null && (pBStringField2 = qZoneBaseMeta$StImage.lloc) != null) {
                str = pBStringField2.get();
            }
            if (str == null) {
                return "";
            }
        } else {
            QZoneBaseMeta$StImage qZoneBaseMeta$StImage2 = stMedia.image;
            if (qZoneBaseMeta$StImage2 != null && (pBStringField = qZoneBaseMeta$StImage2.lloc) != null) {
                str = pBStringField.get();
            }
            if (str == null) {
                return "";
            }
        }
        return str;
    }

    private final String D(QZoneBaseMeta$StMedia stMedia) {
        PBStringField pBStringField;
        QZoneBaseMeta$StImage qZoneBaseMeta$StImage;
        PBStringField pBStringField2;
        String str = null;
        if (stMedia.type.get() == 1) {
            QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo = stMedia.video;
            if (qZoneBaseMeta$StVideo != null && (qZoneBaseMeta$StImage = qZoneBaseMeta$StVideo.cover) != null && (pBStringField2 = qZoneBaseMeta$StImage.sloc) != null) {
                str = pBStringField2.get();
            }
            if (str == null) {
                return "";
            }
        } else {
            QZoneBaseMeta$StImage qZoneBaseMeta$StImage2 = stMedia.image;
            if (qZoneBaseMeta$StImage2 != null && (pBStringField = qZoneBaseMeta$StImage2.sloc) != null) {
                str = pBStringField.get();
            }
            if (str == null) {
                return "";
            }
        }
        return str;
    }

    private final void p(QZoneBaseMeta$StImage stImage, RFWLayerPicInfo layerPicInfo) {
        mk.c cVar = mk.c.f416874a;
        String d16 = cVar.d(stImage.photo_url.get(), 1);
        if (TextUtils.isEmpty(d16)) {
            return;
        }
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
        rFWPicInfo.setUrl(d16);
        rFWPicInfo.setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(d16)));
        rFWPicInfo.setWidth(F(cVar.f(stImage.photo_url.get(), 1)));
        rFWPicInfo.setHeight(E(cVar.c(stImage.photo_url.get(), 1)));
        layerPicInfo.setBigPicInfo(rFWPicInfo);
    }

    private final void q(QZoneBaseMeta$StImage stImage, RFWLayerPicInfo.RFWPicInfo currentPicInfo) {
        mk.c cVar = mk.c.f416874a;
        String d16 = cVar.d(stImage.photo_url.get(), 5);
        String d17 = cVar.d(stImage.photo_url.get(), 1);
        if (!TextUtils.isEmpty(d16)) {
            currentPicInfo.setUrl(d16);
            currentPicInfo.setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(d16)));
        } else {
            if (TextUtils.isEmpty(d17)) {
                return;
            }
            currentPicInfo.setUrl(d17);
            currentPicInfo.setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(d17)));
        }
    }

    private final void r(QZoneBaseMeta$StImage stImage, RFWLayerPicInfo layerPicInfo) {
        String d16 = mk.c.f416874a.d(stImage.photo_url.get(), 6);
        if (TextUtils.isEmpty(d16)) {
            return;
        }
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
        rFWPicInfo.setUrl(d16);
        rFWPicInfo.setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(d16)));
        layerPicInfo.setDownloadPicInfo(rFWPicInfo);
    }

    private final void s(QZoneBaseMeta$StMedia stMedia, RFWLayerItemMediaInfo mediaInfo) {
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        rFWLayerPicInfo.setPicId(C(stMedia));
        t(stMedia, rFWLayerPicInfo);
        mediaInfo.setMediaId(rFWLayerPicInfo.getPicId());
        mediaInfo.setLayerPicInfo(rFWLayerPicInfo);
    }

    private final void t(QZoneBaseMeta$StMedia stMedia, RFWLayerPicInfo layerPicInfo) {
        QZoneBaseMeta$StImage qZoneBaseMeta$StImage;
        new QZoneBaseMeta$StImage();
        if (stMedia.type.get() == 1) {
            qZoneBaseMeta$StImage = stMedia.video.cover.get();
        } else {
            qZoneBaseMeta$StImage = stMedia.image.get();
        }
        p(qZoneBaseMeta$StImage, layerPicInfo);
        r(qZoneBaseMeta$StImage, layerPicInfo);
        if (layerPicInfo.getBigPicInfo() != null) {
            RFWLayerPicInfo.RFWPicInfo bigPicInfo = layerPicInfo.getBigPicInfo();
            Intrinsics.checkNotNull(bigPicInfo);
            if (bigPicInfo.getWidth() != 0) {
                Intrinsics.checkNotNull(layerPicInfo.getBigPicInfo());
                double height = r0.getHeight() * 1.0d;
                Intrinsics.checkNotNull(layerPicInfo.getBigPicInfo());
                if (height / r2.getWidth() > 2.5d) {
                    RFWLayerPicInfo.RFWPicInfo bigPicInfo2 = layerPicInfo.getBigPicInfo();
                    Intrinsics.checkNotNull(bigPicInfo2);
                    layerPicInfo.setCurrentPicInfo(bigPicInfo2);
                    return;
                }
            }
        }
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
        q(qZoneBaseMeta$StImage, rFWPicInfo);
        mk.c cVar = mk.c.f416874a;
        rFWPicInfo.setWidth(cVar.f(qZoneBaseMeta$StImage.photo_url.get(), 5));
        rFWPicInfo.setHeight(cVar.c(qZoneBaseMeta$StImage.photo_url.get(), 5));
        if (rFWPicInfo.getWidth() == 0 || rFWPicInfo.getHeight() == 0) {
            vj.d dVar = vj.d.f441734a;
            rFWPicInfo.setWidth(dVar.g());
            rFWPicInfo.setHeight(dVar.f());
        }
        layerPicInfo.setCurrentPicInfo(rFWPicInfo);
        if (layerPicInfo.getBigPicInfo() != null) {
            layerPicInfo.setSmallPicInfo(layerPicInfo.getCurrentPicInfo());
            RFWLayerPicInfo.RFWPicInfo bigPicInfo3 = layerPicInfo.getBigPicInfo();
            Intrinsics.checkNotNull(bigPicInfo3);
            layerPicInfo.setCurrentPicInfo(bigPicInfo3);
        }
    }

    private final void u(QZoneBaseMeta$StMedia stMedia, RFWLayerItemMediaInfo mediaInfo) {
        String str;
        String str2;
        QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo;
        PBInt32Field pBInt32Field;
        QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo2;
        PBInt32Field pBInt32Field2;
        QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo3;
        PBStringField pBStringField;
        QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo4;
        PBStringField pBStringField2;
        QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo5;
        PBStringField pBStringField3;
        if (stMedia.type.get() != 1) {
            return;
        }
        RFWLayerVideoInfo rFWLayerVideoInfo = new RFWLayerVideoInfo();
        QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia = stMedia.get();
        if (qZoneBaseMeta$StMedia == null || (qZoneBaseMeta$StVideo5 = qZoneBaseMeta$StMedia.video) == null || (pBStringField3 = qZoneBaseMeta$StVideo5.f430340id) == null || (str = pBStringField3.get()) == null) {
            str = "";
        }
        rFWLayerVideoInfo.setFileId(str);
        QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia2 = stMedia.get();
        if (qZoneBaseMeta$StMedia2 == null || (qZoneBaseMeta$StVideo4 = qZoneBaseMeta$StMedia2.video) == null || (pBStringField2 = qZoneBaseMeta$StVideo4.url) == null || (str2 = pBStringField2.get()) == null) {
            str2 = "";
        }
        rFWLayerVideoInfo.setNormalVideoUrl(str2);
        QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia3 = stMedia.get();
        String str3 = (qZoneBaseMeta$StMedia3 == null || (qZoneBaseMeta$StVideo3 = qZoneBaseMeta$StMedia3.video) == null || (pBStringField = qZoneBaseMeta$StVideo3.url) == null) ? null : pBStringField.get();
        rFWLayerVideoInfo.setCurrentVideoUrl(str3 != null ? str3 : "");
        QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia4 = stMedia.get();
        int i3 = 0;
        rFWLayerVideoInfo.setVideoWidth(F((qZoneBaseMeta$StMedia4 == null || (qZoneBaseMeta$StVideo2 = qZoneBaseMeta$StMedia4.video) == null || (pBInt32Field2 = qZoneBaseMeta$StVideo2.width) == null) ? 0 : pBInt32Field2.get()));
        QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia5 = stMedia.get();
        if (qZoneBaseMeta$StMedia5 != null && (qZoneBaseMeta$StVideo = qZoneBaseMeta$StMedia5.video) != null && (pBInt32Field = qZoneBaseMeta$StVideo.height) != null) {
            i3 = pBInt32Field.get();
        }
        rFWLayerVideoInfo.setVideoHeight(E(i3));
        mediaInfo.setLayerVideoInfo(rFWLayerVideoInfo);
    }

    public final ArrayList<QZIntimateLayerExtraInfoBean> A() {
        return this.extraInfoBeanList;
    }

    /* renamed from: B, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    /* renamed from: G, reason: from getter */
    public final String getRightAttachInfo() {
        return this.rightAttachInfo;
    }

    /* renamed from: M, reason: from getter */
    public final String getSpaceId() {
        return this.spaceId;
    }

    /* renamed from: N, reason: from getter */
    public final int getSpaceType() {
        return this.spaceType;
    }

    public final void V(QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean) {
        this.albumDetailInitBean = qZoneIntimateAlbumDetailInitBean;
    }

    public final void Z(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feedId = str;
    }

    public final void a0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rightAttachInfo = str;
    }

    public final void b0(int i3) {
        this.rightBoundIndex = i3;
    }

    public final void c0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.spaceId = str;
    }

    public final void d0(int i3) {
        this.spaceType = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final QZIntimateLayerExtraInfoBean v(QZoneBaseMeta$StMedia stMedia) {
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(stMedia, "stMedia");
        QZIntimateLayerExtraInfoBean qZIntimateLayerExtraInfoBean = new QZIntimateLayerExtraInfoBean();
        qZIntimateLayerExtraInfoBean.q(C(stMedia));
        qZIntimateLayerExtraInfoBean.r(D(stMedia));
        qZIntimateLayerExtraInfoBean.m(getAlbumId());
        qZIntimateLayerExtraInfoBean.n(getAlbumName());
        qZIntimateLayerExtraInfoBean.o(stMedia.batch_id.get());
        qZIntimateLayerExtraInfoBean.v(stMedia.type.get() == 1);
        if (qZIntimateLayerExtraInfoBean.getIsVideo()) {
            QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo = stMedia.video;
            qZIntimateLayerExtraInfoBean.w((qZoneBaseMeta$StVideo == null || (pBStringField = qZoneBaseMeta$StVideo.f430340id) == null) ? null : pBStringField.get());
        } else {
            qZIntimateLayerExtraInfoBean.w("");
        }
        qZIntimateLayerExtraInfoBean.u(stMedia.uploader.get());
        qZIntimateLayerExtraInfoBean.p(stMedia.desc.get());
        qZIntimateLayerExtraInfoBean.s(this.spaceId);
        qZIntimateLayerExtraInfoBean.t(this.spaceType);
        return qZIntimateLayerExtraInfoBean;
    }

    public final void w(ArrayList<QZoneBaseMeta$StMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return;
        }
        ArrayList<QZIntimateLayerExtraInfoBean> arrayList = new ArrayList<>();
        Iterator<QZoneBaseMeta$StMedia> it = mediaList.iterator();
        while (it.hasNext()) {
            QZoneBaseMeta$StMedia media = it.next();
            Intrinsics.checkNotNullExpressionValue(media, "media");
            arrayList.add(v(media));
        }
        this.extraInfoBeanList = arrayList;
    }

    public void x(ArrayList<QZoneBaseMeta$StMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return;
        }
        ArrayList<RFWLayerItemMediaInfo> arrayList = new ArrayList<>();
        Iterator<QZoneBaseMeta$StMedia> it = mediaList.iterator();
        while (it.hasNext()) {
            QZoneBaseMeta$StMedia media = it.next();
            Intrinsics.checkNotNullExpressionValue(media, "media");
            arrayList.add(y(media));
        }
        o(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RFWLayerItemMediaInfo y(QZoneBaseMeta$StMedia stMedia) {
        Intrinsics.checkNotNullParameter(stMedia, "stMedia");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
        s(stMedia, rFWLayerItemMediaInfo);
        u(stMedia, rFWLayerItemMediaInfo);
        return rFWLayerItemMediaInfo;
    }

    /* renamed from: z, reason: from getter */
    public final QZoneIntimateAlbumDetailInitBean getAlbumDetailInitBean() {
        return this.albumDetailInitBean;
    }

    private final int E(int height) {
        return height == 0 ? vj.d.f441734a.f() : height;
    }

    private final int F(int width) {
        return width == 0 ? vj.d.f441734a.g() : width;
    }
}
