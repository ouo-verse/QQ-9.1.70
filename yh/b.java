package yh;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellGroupAlbumInfo;
import com.qzone.proxy.feedcomponent.model.CellLbsInfo;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.CellMediaInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.CellSummary;
import com.qzone.proxy.feedcomponent.model.CellTitleInfo;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.CellVisitorInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.GpsInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.reborn.albumx.common.convert.bean.CommonStLike;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumMediaType;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumPhotoSpec;
import com.qzone.util.image.ImageInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernel.nativeinterface.ClientFeed;
import com.tencent.qqnt.kernel.nativeinterface.MediaType;
import com.tencent.qqnt.kernel.nativeinterface.PhotoSpec;
import com.tencent.qqnt.kernel.nativeinterface.RichMsgType;
import com.tencent.qqnt.kernel.nativeinterface.StCellBottomRecomm;
import com.tencent.qqnt.kernel.nativeinterface.StComment;
import com.tencent.qqnt.kernel.nativeinterface.StCommonExt;
import com.tencent.qqnt.kernel.nativeinterface.StFeed;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellComment;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellCommon;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellLBS;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellLike;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellMedia;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellQunInfo;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellSummary;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellTitle;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellUserInfo;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellVisitor;
import com.tencent.qqnt.kernel.nativeinterface.StGPS;
import com.tencent.qqnt.kernel.nativeinterface.StImage;
import com.tencent.qqnt.kernel.nativeinterface.StLBS;
import com.tencent.qqnt.kernel.nativeinterface.StLike;
import com.tencent.qqnt.kernel.nativeinterface.StLikeMan;
import com.tencent.qqnt.kernel.nativeinterface.StMedia;
import com.tencent.qqnt.kernel.nativeinterface.StPicSpecUrlEntry;
import com.tencent.qqnt.kernel.nativeinterface.StPicUrl;
import com.tencent.qqnt.kernel.nativeinterface.StReply;
import com.tencent.qqnt.kernel.nativeinterface.StRichMsg;
import com.tencent.qqnt.kernel.nativeinterface.StUser;
import com.tencent.qqnt.kernel.nativeinterface.StVideo;
import ef.d;
import fj.s;
import fj.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b2\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0016\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0016\u0010\u0006\u001a\u00020\u0003*\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0018\u0010\t\u001a\u00020\b*\u0004\u0018\u00010\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0018\u0010\f\u001a\u00020\u000b*\u0004\u0018\u00010\n2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u000e\u0010\u000f\u001a\u00020\u000e*\u0004\u0018\u00010\rH\u0002\u001a\"\u0010\u0014\u001a\u00020\u0013*\u0004\u0018\u00010\u00102\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002\u001a0\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u0019*\u0004\u0018\u00010\u00162\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0016\u0010\u001f\u001a\u00020\u001e*\u0004\u0018\u00010\u001d2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\u0018\u0010\"\u001a\u0004\u0018\u00010!*\u0004\u0018\u00010 2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a4\u0010%\u001a\u0004\u0018\u00010!*\u0004\u0018\u00010 2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u001a\u0010$\u001a\u0016\u0012\u0004\u0012\u00020#\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020#\u0018\u0001`\u001a\u001a4\u0010&\u001a\u0004\u0018\u00010\u001e*\u0004\u0018\u00010 2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u001a\u0010$\u001a\u0016\u0012\u0004\u0012\u00020#\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020#\u0018\u0001`\u001a\u001a4\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u00152\u001a\u0010$\u001a\u0016\u0012\u0004\u0012\u00020#\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020#\u0018\u0001`\u001a2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\u0018\u0010)\u001a\u0004\u0018\u00010'*\u0004\u0018\u00010#2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010,\u001a\u00020+*\u0004\u0018\u00010*H\u0002\u001a\u0010\u0010.\u001a\u0004\u0018\u00010-*\u0004\u0018\u00010\u0007H\u0002\u001a2\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0018\u00010\u0018j\n\u0012\u0004\u0012\u000204\u0018\u0001`\u001a2\u000e\u00101\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/2\u0006\u00103\u001a\u000202\u001a\u0016\u00106\u001a\u000204*\u0004\u0018\u0001002\u0006\u00103\u001a\u000202H\u0002\u001a\u0010\u00108\u001a\u0004\u0018\u000104*\u0004\u0018\u000107H\u0002\u001a\u001e\u0010=\u001a\u00020<2\u0006\u00109\u001a\u0002042\f\u0010;\u001a\b\u0012\u0004\u0012\u00020:0\u0015H\u0002\u001a\u000e\u0010?\u001a\u00020>*\u0004\u0018\u00010\u0007H\u0002\u001a\u0016\u0010@\u001a\u00020>*\u0004\u0018\u0001002\u0006\u00103\u001a\u000202H\u0002\u001a\u0010\u0010B\u001a\u0004\u0018\u00010A*\u0004\u0018\u000107H\u0002\u001a\f\u0010D\u001a\u00020A*\u00020CH\u0002\u001a\u000e\u0010E\u001a\u0004\u0018\u00010C*\u0004\u0018\u000107\u001a\u000e\u0010G\u001a\u00020F*\u0004\u0018\u00010\u0005H\u0002\u001a\u000e\u0010J\u001a\u00020I*\u0004\u0018\u00010HH\u0002\u001a\u000e\u0010M\u001a\u00020L*\u0004\u0018\u00010KH\u0002\u001a\u0018\u0010P\u001a\u00020O*\u0004\u0018\u00010N2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0018\u0010S\u001a\u00020R*\u0004\u0018\u00010Q2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0018\u0010V\u001a\u00020U*\u0004\u0018\u00010T2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u000e\u0010X\u001a\u00020W*\u0004\u0018\u00010\u0011H\u0002\u001a\"\u0010[\u001a\u0002022\u000e\u0010Z\u001a\n\u0012\u0004\u0012\u00020Y\u0018\u00010/2\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001aH\u0010]\u001a\u0016\u0012\u0004\u0012\u000204\u0018\u00010\u0018j\n\u0012\u0004\u0012\u000204\u0018\u0001`\u001a2\u0016\u0010\\\u001a\u0012\u0012\u0004\u0012\u0002000\u0018j\b\u0012\u0004\u0012\u000200`\u001a2\b\b\u0002\u00103\u001a\u0002022\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a6\u0010^\u001a\u0016\u0012\u0004\u0012\u000204\u0018\u00010\u0018j\n\u0012\u0004\u0012\u000204\u0018\u0001`\u001a2\u000e\u0010Z\u001a\n\u0012\u0004\u0012\u00020Y\u0018\u00010/2\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\u001a\u0010`\u001a\u0002022\u0006\u0010_\u001a\u00020Y2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u001a\u0010a\u001a\u0002022\u0006\u0010_\u001a\u00020Y2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0016\u0010d\u001a\u00020c*\u0004\u0018\u00010b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\n\u0010f\u001a\u000200*\u00020e\u001a\n\u0010h\u001a\u000200*\u00020g\u001a\u0012\u0010j\u001a\u00020\u0003*\u00020\u00052\u0006\u0010i\u001a\u00020\u0003\u00a8\u0006k"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/ClientFeed;", "Lcom/tencent/qqnt/kernel/nativeinterface/StCommonExt;", "commonExt", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "J", "Lcom/tencent/qqnt/kernel/nativeinterface/StFeed;", "K", "Lcom/tencent/qqnt/kernel/nativeinterface/StFeedCellMedia;", "Lcom/qzone/proxy/feedcomponent/model/CellMediaInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qqnt/kernel/nativeinterface/StFeedCellVisitor;", "Lcom/qzone/proxy/feedcomponent/model/CellVisitorInfo;", "G", "Lcom/tencent/qqnt/kernel/nativeinterface/StCellBottomRecomm;", "Lcom/qzone/proxy/feedcomponent/model/CellBottomRecomm;", "t", "Lcom/tencent/qqnt/kernel/nativeinterface/StFeedCellLike;", "Lcom/tencent/qqnt/kernel/nativeinterface/StFeedCellCommon;", "cellCommon", "Lcom/qzone/proxy/feedcomponent/model/CellLikeInfo;", "y", "", "Lcom/tencent/qqnt/kernel/nativeinterface/StLikeMan;", "stLikeMen", "Ljava/util/ArrayList;", "Lcom/qzone/proxy/feedcomponent/model/CellLikeInfo$LikeMan;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "L", "Lcom/tencent/qqnt/kernel/nativeinterface/StFeedCellComment;", "Lcom/qzone/proxy/feedcomponent/model/CellCommentInfo;", "v", "Lcom/tencent/qqnt/kernel/nativeinterface/StComment;", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "H", "Lcom/tencent/qqnt/kernel/nativeinterface/StReply;", "stReplies", "I", "u", "Lcom/qzone/proxy/feedcomponent/model/Reply;", ReportConstant.COSTREPORT_PREFIX, "M", "Lcom/tencent/qqnt/kernel/nativeinterface/StFeedCellLBS;", "Lcom/qzone/proxy/feedcomponent/model/CellLbsInfo;", HippyTKDListViewAdapter.X, "Lcom/qzone/proxy/feedcomponent/model/CellPictureInfo;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "Lcom/tencent/qqnt/kernel/nativeinterface/StMedia;", "mediaItems", "", "albumId", "Lcom/qzone/proxy/feedcomponent/model/PictureItem;", "r", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/qqnt/kernel/nativeinterface/StImage;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "pictureItem", "Lcom/tencent/qqnt/kernel/nativeinterface/StPicSpecUrlEntry;", "photoUrls", "", h.F, "Lcom/qzone/proxy/feedcomponent/model/VideoInfo;", "E", UserInfo.SEX_FEMALE, "Lcom/qzone/proxy/feedcomponent/model/PictureUrl;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/qqnt/kernel/nativeinterface/StPicUrl;", "T", "l", "", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/StFeedCellSummary;", "Lcom/qzone/proxy/feedcomponent/model/CellSummary;", "B", "Lcom/tencent/qqnt/kernel/nativeinterface/StFeedCellTitle;", "Lcom/qzone/proxy/feedcomponent/model/CellTitleInfo;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/kernel/nativeinterface/StFeedCellUserInfo;", "Lcom/qzone/proxy/feedcomponent/model/CellUserInfo;", "D", "Lcom/tencent/qqnt/kernel/nativeinterface/StUser;", "Lcom/qzone/proxy/feedcomponent/model/User;", "O", "Lcom/tencent/qqnt/kernel/nativeinterface/StFeedCellQunInfo;", "Lcom/qzone/proxy/feedcomponent/model/CellGroupAlbumInfo;", "P", "Lcom/qzone/proxy/feedcomponent/model/CellFeedCommInfo;", "w", "Lcom/tencent/qqnt/kernel/nativeinterface/StRichMsg;", "richMsgItems", "o", "stMedias", "a", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "stRichMsg", "j", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/StLike;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLike;", "N", "Lcom/qzone/util/image/ImageInfo;", "f", "Lcom/qzone/proxy/feedcomponent/model/ShuoshuoVideoInfo;", "e", "feedData", "g", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final BusinessFeedData J(ClientFeed clientFeed, StCommonExt stCommonExt) {
        StFeed stFeed = clientFeed.feed;
        Intrinsics.checkNotNullExpressionValue(stFeed, "this.feed");
        return K(stFeed, stCommonExt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BusinessFeedData K(StFeed stFeed, StCommonExt stCommonExt) {
        BusinessFeedData businessFeedData = new BusinessFeedData();
        businessFeedData.setCellFeedCommInfo(w(stFeed.cellCommon));
        businessFeedData.cellUserInfo = D(stFeed.cellUserInfo, stCommonExt);
        businessFeedData.setCellTitleInfo(C(stFeed.cellTitle));
        businessFeedData.cellSummary = B(stFeed.cellSummary);
        if (k(stFeed)) {
            businessFeedData.setVideoInfo(E(stFeed.cellMedia));
        } else {
            businessFeedData.setCellPictureInfo(A(stFeed.cellMedia));
        }
        businessFeedData.setCellLbsInfo(x(stFeed.cellLbs));
        businessFeedData.setCellCommentInfo(v(stFeed.cellComment, stCommonExt));
        businessFeedData.setCellLikeInfo(y(stFeed.cellLike, stCommonExt, stFeed.cellCommon));
        businessFeedData.setCellBottomRecomm(t(stFeed.cellBottomRecomm));
        businessFeedData.cellGroupAlbumInfo = P(stFeed.cellQunInfo, stCommonExt);
        businessFeedData.setVisitorInfo(G(stFeed.cellVisitor, stCommonExt));
        businessFeedData.cellMediaInfo = z(stFeed.cellMedia, stCommonExt);
        return businessFeedData;
    }

    private static final PictureUrl T(StPicUrl stPicUrl) {
        PictureUrl pictureUrl = new PictureUrl();
        pictureUrl.url = stPicUrl.url;
        pictureUrl.width = stPicUrl.width;
        pictureUrl.height = stPicUrl.height;
        return pictureUrl;
    }

    public static final ArrayList<PictureItem> a(ArrayList<StMedia> stMedias, String albumId, StCommonExt stCommonExt) {
        Intrinsics.checkNotNullParameter(stMedias, "stMedias");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        ArrayList<PictureItem> arrayList = new ArrayList<>();
        Iterator<T> it = stMedias.iterator();
        while (it.hasNext()) {
            arrayList.add(R((StMedia) it.next(), albumId));
        }
        return arrayList;
    }

    public static final StMedia e(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        Intrinsics.checkNotNullParameter(shuoshuoVideoInfo, "<this>");
        StPicUrl stPicUrl = new StPicUrl(shuoshuoVideoInfo.mCoverUrl, shuoshuoVideoInfo.mVideoWidth, shuoshuoVideoInfo.mVideoHeight);
        StImage stImage = new StImage();
        stImage.defaultUrl = stPicUrl;
        stImage.photoUrl.add(a.e(a.f450323a, shuoshuoVideoInfo.mCoverUrl, shuoshuoVideoInfo.mVideoWidth, shuoshuoVideoInfo.mVideoHeight, 0, 8, null));
        StVideo stVideo = new StVideo("", shuoshuoVideoInfo.mVideoPath, stImage, shuoshuoVideoInfo.mVideoWidth, shuoshuoVideoInfo.mVideoHeight, shuoshuoVideoInfo.mDuration, new ArrayList());
        StMedia stMedia = new StMedia();
        stMedia.type = CommonEnumMediaType.VIDEO.ordinal();
        stMedia.video = stVideo;
        return stMedia;
    }

    public static final StMedia f(ImageInfo imageInfo) {
        Intrinsics.checkNotNullParameter(imageInfo, "<this>");
        ArrayList<StPicSpecUrlEntry> arrayList = new ArrayList<>();
        a aVar = a.f450323a;
        arrayList.add(aVar.d(imageInfo.mPath, imageInfo.photoWidth, imageInfo.photoHeight, CommonEnumPhotoSpec.PHOTO_SPEC_CURRENT.ordinal()));
        arrayList.add(aVar.d(imageInfo.mPath, imageInfo.photoWidth, imageInfo.photoHeight, CommonEnumPhotoSpec.PHOTO_SPEC_BIG.ordinal()));
        arrayList.add(aVar.d(imageInfo.mPath, imageInfo.photoWidth, imageInfo.photoHeight, CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN.ordinal()));
        StPicUrl stPicUrl = new StPicUrl(imageInfo.mPath, imageInfo.photoWidth, imageInfo.photoHeight);
        StImage stImage = new StImage();
        stImage.photoUrl = arrayList;
        stImage.defaultUrl = stPicUrl;
        StMedia stMedia = new StMedia();
        stMedia.type = CommonEnumMediaType.IMAGE.ordinal();
        stMedia.image = stImage;
        return stMedia;
    }

    public static final BusinessFeedData g(StFeed stFeed, BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(stFeed, "<this>");
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        if (k(stFeed)) {
            feedData.setVideoInfo(E(stFeed.cellMedia));
        } else {
            feedData.setCellPictureInfo(A(stFeed.cellMedia));
        }
        return feedData;
    }

    private static final void h(PictureItem pictureItem, List<StPicSpecUrlEntry> list) {
        for (StPicSpecUrlEntry stPicSpecUrlEntry : list) {
            int i3 = stPicSpecUrlEntry.spec;
            if (i3 == PhotoSpec.KPHOTOSPECORIGIN.ordinal()) {
                StPicUrl stPicUrl = stPicSpecUrlEntry.url;
                Intrinsics.checkNotNullExpressionValue(stPicUrl, "it.url");
                pictureItem.originUrl = T(stPicUrl);
            } else if (i3 == PhotoSpec.KPHOTOSPECBIG.ordinal()) {
                StPicUrl stPicUrl2 = stPicSpecUrlEntry.url;
                Intrinsics.checkNotNullExpressionValue(stPicUrl2, "it.url");
                pictureItem.bigUrl = T(stPicUrl2);
            } else if (i3 == PhotoSpec.KPHOTOSPECCURRENT.ordinal()) {
                StPicUrl stPicUrl3 = stPicSpecUrlEntry.url;
                Intrinsics.checkNotNullExpressionValue(stPicUrl3, "it.url");
                pictureItem.currentUrl = T(stPicUrl3);
            } else if (i3 == PhotoSpec.KPHOTOSPECDOWNLOAD.ordinal()) {
                StPicUrl stPicUrl4 = stPicSpecUrlEntry.url;
                Intrinsics.checkNotNullExpressionValue(stPicUrl4, "it.url");
                pictureItem.downloadUrl = T(stPicUrl4);
            }
        }
    }

    private static final String i(StRichMsg stRichMsg, StCommonExt stCommonExt) {
        String str;
        String str2 = stRichMsg.uin;
        if (str2 == null || str2.length() == 0) {
            str = String.valueOf(mk.h.f416877a.g(stRichMsg.uid, stCommonExt));
        } else {
            str = stRichMsg.uin;
            Intrinsics.checkNotNullExpressionValue(str, "stRichMsg.uin");
        }
        return "@{uin:" + str + ",nick:" + s.f399470a.a(str, stRichMsg.name) + ",who:" + stRichMsg.who + "}";
    }

    private static final String j(StRichMsg stRichMsg, StCommonExt stCommonExt) {
        return "{url:" + mk.h.f416877a.c(stRichMsg.url, stCommonExt) + ",text:" + stRichMsg.content + "}";
    }

    public static final String o(List<StRichMsg> list, StCommonExt stCommonExt) {
        StringBuilder sb5 = new StringBuilder();
        if (list != null) {
            for (StRichMsg stRichMsg : list) {
                int i3 = stRichMsg.type;
                if (i3 == RichMsgType.KRICHMSGTYPEPLAINTEXT.ordinal()) {
                    sb5.append(stRichMsg.content);
                } else if (i3 == RichMsgType.KRICHMSGTYPEAT.ordinal()) {
                    sb5.append(i(stRichMsg, stCommonExt));
                } else if (i3 == RichMsgType.KRICHMSGTYPEURL.ordinal()) {
                    sb5.append(j(stRichMsg, stCommonExt));
                }
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }

    private static final ArrayList<CellLikeInfo.LikeMan> q(List<StLikeMan> list, StCommonExt stCommonExt) {
        ArrayList<CellLikeInfo.LikeMan> arrayList = new ArrayList<>();
        Iterator<StLikeMan> it = list.iterator();
        while (it.hasNext()) {
            CellLikeInfo.LikeMan L = L(it.next(), stCommonExt);
            if (L != null) {
                arrayList.add(L);
            }
        }
        return arrayList;
    }

    public static final ArrayList<PictureItem> r(List<StMedia> list, String albumId) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        if (list == null) {
            return null;
        }
        ArrayList<PictureItem> arrayList = new ArrayList<>();
        List<StMedia> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList2.add(R((StMedia) it.next(), albumId));
        }
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    private static final CellMediaInfo z(StFeedCellMedia stFeedCellMedia, StCommonExt stCommonExt) {
        CellMediaInfo cellMediaInfo = new CellMediaInfo();
        if (stFeedCellMedia == null) {
            return cellMediaInfo;
        }
        cellMediaInfo.albumName = stFeedCellMedia.albumName;
        cellMediaInfo.albumId = stFeedCellMedia.albumId;
        cellMediaInfo.uploadNum = stFeedCellMedia.uploadNum;
        cellMediaInfo.albumUploadNum = stFeedCellMedia.albumUploadNum;
        StPicUrl l3 = l(stFeedCellMedia.albumCover);
        if (l3 == null) {
            l3 = stFeedCellMedia.albumCover.defaultUrl;
        }
        cellMediaInfo.albumCoverUrl = l3 != null ? T(l3) : null;
        return cellMediaInfo;
    }

    private static final CellSummary B(StFeedCellSummary stFeedCellSummary) {
        if (stFeedCellSummary == null) {
            return new CellSummary();
        }
        CellSummary cellSummary = new CellSummary();
        String p16 = p(stFeedCellSummary.summary, null, 2, null);
        cellSummary.summary = p16;
        cellSummary.displayStr = p16;
        cellSummary.isMore = stFeedCellSummary.hasMore ? 1 : 0;
        return cellSummary;
    }

    private static final CellTitleInfo C(StFeedCellTitle stFeedCellTitle) {
        if (stFeedCellTitle == null) {
            return new CellTitleInfo();
        }
        CellTitleInfo cellTitleInfo = new CellTitleInfo();
        cellTitleInfo.title = p(stFeedCellTitle.title, null, 2, null);
        cellTitleInfo.titleUrl = stFeedCellTitle.titleUrl;
        return cellTitleInfo;
    }

    private static final CellUserInfo D(StFeedCellUserInfo stFeedCellUserInfo, StCommonExt stCommonExt) {
        if (stFeedCellUserInfo != null && stFeedCellUserInfo.user != null) {
            CellUserInfo cellUserInfo = new CellUserInfo();
            cellUserInfo.user = O(stFeedCellUserInfo.user, stCommonExt);
            return cellUserInfo;
        }
        return new CellUserInfo();
    }

    private static final VideoInfo E(StFeedCellMedia stFeedCellMedia) {
        if (stFeedCellMedia != null) {
            ArrayList<StMedia> arrayList = stFeedCellMedia.mediaItems;
            if (!(arrayList == null || arrayList.isEmpty())) {
                StMedia stMedia = stFeedCellMedia.mediaItems.get(0);
                String str = stFeedCellMedia.albumId;
                Intrinsics.checkNotNullExpressionValue(str, "this.albumId");
                return F(stMedia, str);
            }
        }
        return new VideoInfo();
    }

    private static final VideoInfo F(StMedia stMedia, String str) {
        if (stMedia == null) {
            return new VideoInfo();
        }
        StVideo stVideo = stMedia.video;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.albumid = str;
        videoInfo.videoId = stVideo.f359227id;
        VideoUrl videoUrl = new VideoUrl();
        videoUrl.url = stVideo.url;
        videoInfo.videoUrl = videoUrl;
        videoInfo.width = stVideo.width;
        videoInfo.height = stVideo.height;
        videoInfo.videoTime = stVideo.videoTime;
        PictureUrl S = S(stVideo.cover);
        videoInfo.coverUrl = S;
        videoInfo.currentUrl = S;
        StImage stImage = stVideo.cover;
        videoInfo.lloc = stImage.lloc;
        videoInfo.sloc = stImage.sloc;
        videoInfo.desc = stMedia.desc;
        videoInfo.uploadUid = stMedia.uploader;
        videoInfo.batchId = stMedia.batchId;
        videoInfo.videoShowType = 1;
        videoInfo.playType = (byte) 1;
        videoInfo.likekey = stMedia.like.key;
        return videoInfo;
    }

    private static final CellVisitorInfo G(StFeedCellVisitor stFeedCellVisitor, StCommonExt stCommonExt) {
        if (stFeedCellVisitor == null) {
            return new CellVisitorInfo();
        }
        CellVisitorInfo cellVisitorInfo = new CellVisitorInfo();
        int i3 = stFeedCellVisitor.viewNum;
        cellVisitorInfo.viewCount = i3;
        cellVisitorInfo.visitorCount = stFeedCellVisitor.visitorNum;
        if (i3 > 0) {
            cellVisitorInfo.displayStr = BaseApplicationImpl.sApplication.getResources().getString(R.string.f1330856, Integer.valueOf(stFeedCellVisitor.viewNum));
        }
        return cellVisitorInfo;
    }

    public static final CommonStLike N(StLike stLike, StCommonExt stCommonExt) {
        if (stLike == null) {
            return new CommonStLike();
        }
        CommonStLike commonStLike = new CommonStLike();
        String str = stLike.f359224id;
        Intrinsics.checkNotNullExpressionValue(str, "this.id");
        commonStLike.c(str);
        commonStLike.b(stLike.count);
        commonStLike.e(stLike.ownerStatus);
        commonStLike.f(stLike.status);
        CommonStUser postUser = commonStLike.getPostUser();
        String str2 = stLike.postUser.uid;
        Intrinsics.checkNotNullExpressionValue(str2, "this.postUser.uid");
        postUser.f(str2);
        CommonStUser postUser2 = commonStLike.getPostUser();
        String str3 = stLike.postUser.uin;
        Intrinsics.checkNotNullExpressionValue(str3, "this.postUser.uin");
        postUser2.g(str3);
        s sVar = s.f399470a;
        StUser stUser = stLike.postUser;
        commonStLike.getPostUser().e(sVar.a(stUser.uin, stUser.nick));
        return commonStLike;
    }

    private static final User O(StUser stUser, StCommonExt stCommonExt) {
        if (stUser == null) {
            return new User();
        }
        User user = new User();
        user.nickName = s.f399470a.a(stUser.uin, stUser.nick);
        user.uid = stUser.uid;
        String str = stUser.uin;
        if (!(str == null || str.length() == 0)) {
            user.uin = d.k(stUser.uin);
        } else {
            user.uin = mk.h.f416877a.g(stUser.uid, stCommonExt);
        }
        return user;
    }

    private static final CellGroupAlbumInfo P(StFeedCellQunInfo stFeedCellQunInfo, StCommonExt stCommonExt) {
        if (stFeedCellQunInfo == null) {
            return new CellGroupAlbumInfo();
        }
        CellGroupAlbumInfo cellGroupAlbumInfo = new CellGroupAlbumInfo();
        cellGroupAlbumInfo.groupId = stFeedCellQunInfo.qunId;
        return cellGroupAlbumInfo;
    }

    private static final PictureItem R(StMedia stMedia, String str) {
        String str2;
        PictureItem pictureItem;
        StImage stImage;
        String str3;
        StImage stImage2;
        if (stMedia == null) {
            return new PictureItem();
        }
        if (stMedia.type == MediaType.KMEDIATYPEIMAGE.ordinal()) {
            pictureItem = Q(stMedia.image);
        } else {
            PictureItem pictureItem2 = new PictureItem();
            pictureItem2.videoflag = 1;
            pictureItem2.videodata = F(stMedia, str);
            StVideo stVideo = stMedia.video;
            String str4 = "";
            if (stVideo == null || (stImage2 = stVideo.cover) == null || (str2 = stImage2.lloc) == null) {
                str2 = "";
            }
            pictureItem2.lloc = str2;
            if (stVideo != null && (stImage = stVideo.cover) != null && (str3 = stImage.sloc) != null) {
                str4 = str3;
            }
            pictureItem2.sloc = str4;
            pictureItem = pictureItem2;
        }
        if (pictureItem != null) {
            pictureItem.uploadTime = stMedia.uploadTime;
        }
        if (pictureItem != null) {
            pictureItem.desc = stMedia.desc;
        }
        if (pictureItem != null) {
            pictureItem.uploadUid = stMedia.uploader;
        }
        if (pictureItem != null) {
            pictureItem.likeKey = stMedia.like.key;
        }
        return pictureItem == null ? new PictureItem() : pictureItem;
    }

    private static final PictureUrl S(StImage stImage) {
        StPicUrl l3;
        if (stImage == null || (l3 = l(stImage)) == null) {
            return null;
        }
        return T(l3);
    }

    public static final List<Reply> s(ArrayList<StReply> arrayList, StCommonExt stCommonExt) {
        if (arrayList == null) {
            return new ArrayList();
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<StReply> it = arrayList.iterator();
        while (it.hasNext()) {
            Reply M = M(it.next(), stCommonExt);
            if (M != null) {
                arrayList2.add(M);
            }
        }
        return arrayList2;
    }

    private static final CellBottomRecomm t(StCellBottomRecomm stCellBottomRecomm) {
        if (stCellBottomRecomm == null) {
            return new CellBottomRecomm();
        }
        CellBottomRecomm cellBottomRecomm = new CellBottomRecomm();
        cellBottomRecomm.title = stCellBottomRecomm.title;
        cellBottomRecomm.iconToken = stCellBottomRecomm.iconToken;
        cellBottomRecomm.actionurl = stCellBottomRecomm.actionUrl;
        return cellBottomRecomm;
    }

    public static final CellCommentInfo u(StComment stComment, StCommonExt stCommonExt, ArrayList<StReply> arrayList) {
        if (stComment == null) {
            return new CellCommentInfo();
        }
        CellCommentInfo cellCommentInfo = new CellCommentInfo();
        cellCommentInfo.commentNum = 1;
        ArrayList<Comment> arrayList2 = new ArrayList<>();
        Comment I = I(stComment, stCommonExt, arrayList);
        if (I != null) {
            arrayList2.add(I);
        }
        cellCommentInfo.commments = arrayList2;
        return cellCommentInfo;
    }

    public static final CellCommentInfo v(StFeedCellComment stFeedCellComment, StCommonExt stCommonExt) {
        if (stFeedCellComment == null) {
            return new CellCommentInfo();
        }
        CellCommentInfo cellCommentInfo = new CellCommentInfo();
        int i3 = stFeedCellComment.num;
        cellCommentInfo.commentNum = i3;
        cellCommentInfo.serverRspTotalCommentNum = i3;
        ArrayList<Comment> arrayList = new ArrayList<>();
        Iterator<StComment> it = stFeedCellComment.comments.iterator();
        while (it.hasNext()) {
            Comment H = H(it.next(), stCommonExt);
            if (H != null) {
                arrayList.add(H);
            }
        }
        cellCommentInfo.commments = arrayList;
        return cellCommentInfo;
    }

    private static final CellFeedCommInfo w(StFeedCellCommon stFeedCellCommon) {
        if (stFeedCellCommon == null) {
            return new CellFeedCommInfo();
        }
        CellFeedCommInfo cellFeedCommInfo = new CellFeedCommInfo();
        cellFeedCommInfo.bizId = 3;
        cellFeedCommInfo.appid = stFeedCellCommon.appId;
        cellFeedCommInfo.subid = stFeedCellCommon.subId;
        cellFeedCommInfo.time = stFeedCellCommon.time * 1000;
        cellFeedCommInfo.feedsid = stFeedCellCommon.feedId;
        cellFeedCommInfo.curlikekey = stFeedCellCommon.curLikeKey;
        cellFeedCommInfo.clientkey = stFeedCellCommon.clientKey;
        return cellFeedCommInfo;
    }

    private static final CellLbsInfo x(StFeedCellLBS stFeedCellLBS) {
        if (stFeedCellLBS == null) {
            return new CellLbsInfo();
        }
        CellLbsInfo cellLbsInfo = new CellLbsInfo();
        StLBS stLBS = stFeedCellLBS.lbs;
        StGPS stGPS = stLBS.gps;
        GpsInfo gpsInfo = new GpsInfo();
        gpsInfo.latitude = (int) stGPS.lat;
        gpsInfo.longtitude = (int) stGPS.lon;
        gpsInfo.altitude = (int) stGPS.alt;
        gpsInfo.gpsType = (int) stGPS.eType;
        cellLbsInfo.gpsInfo = gpsInfo;
        cellLbsInfo.location = stLBS.location;
        return cellLbsInfo;
    }

    private static final CellLikeInfo y(StFeedCellLike stFeedCellLike, StCommonExt stCommonExt, StFeedCellCommon stFeedCellCommon) {
        if (stFeedCellLike == null) {
            return new CellLikeInfo();
        }
        CellLikeInfo cellLikeInfo = new CellLikeInfo();
        cellLikeInfo.likeKey = stFeedCellCommon != null ? stFeedCellCommon.curLikeKey : null;
        cellLikeInfo.likeNum = stFeedCellLike.num;
        cellLikeInfo.isLiked = stFeedCellLike.liked;
        ArrayList<StLikeMan> arrayList = stFeedCellLike.likeMans;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.likeMans");
        cellLikeInfo.likeMans = q(arrayList, stCommonExt);
        cellLikeInfo.likeNumInfoFoldTxt = stFeedCellLike.text;
        return cellLikeInfo;
    }

    private static final boolean k(StFeed stFeed) {
        StFeedCellMedia stFeedCellMedia;
        ArrayList<StMedia> arrayList;
        return (stFeed == null || (stFeedCellMedia = stFeed.cellMedia) == null || (arrayList = stFeedCellMedia.mediaItems) == null || arrayList.size() != 1 || arrayList.get(0).type != MediaType.KMEDIATYPEVIDEO.ordinal()) ? false : true;
    }

    public static final ArrayList<PictureItem> m(List<StRichMsg> list, StCommonExt stCommonExt) {
        ArrayList<PictureItem> arrayList = null;
        if (list != null) {
            for (StRichMsg stRichMsg : list) {
                if (stRichMsg.type == RichMsgType.KRICHMSGTYPEMEDIA.ordinal()) {
                    arrayList = r(stRichMsg.mediaItems, "");
                }
            }
        }
        return arrayList != null ? arrayList : new ArrayList<>();
    }

    private static final CellPictureInfo A(StFeedCellMedia stFeedCellMedia) {
        if (stFeedCellMedia == null) {
            return null;
        }
        CellPictureInfo cellPictureInfo = new CellPictureInfo();
        String str = stFeedCellMedia.albumId;
        cellPictureInfo.albumid = str;
        cellPictureInfo.albumname = stFeedCellMedia.albumName;
        cellPictureInfo.uploadnum = stFeedCellMedia.uploadNum;
        cellPictureInfo.batchId = stFeedCellMedia.batchId;
        ArrayList<StMedia> arrayList = stFeedCellMedia.mediaItems;
        Intrinsics.checkNotNullExpressionValue(str, "this.albumId");
        cellPictureInfo.pics = r(arrayList, str);
        return cellPictureInfo;
    }

    public static final Comment H(StComment stComment, StCommonExt stCommonExt) {
        if (stComment == null) {
            return null;
        }
        Comment comment = new Comment();
        comment.commentid = stComment.f359223id;
        comment.user = O(stComment.user, stCommonExt);
        comment.comment = p(stComment.content, null, 2, null);
        comment.commentPictureItems = n(stComment.content, null, 2, null);
        ArrayList<StMedia> arrayList = stComment.mediaItems;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.mediaItems");
        comment.pictureItems = b(arrayList, null, null, 6, null);
        comment.time = (int) stComment.time;
        comment.replies = s(stComment.replys, stCommonExt);
        comment.replyNum = (int) stComment.replyNum;
        comment.clientKey = stComment.clientKey;
        return comment;
    }

    public static final Comment I(StComment stComment, StCommonExt stCommonExt, ArrayList<StReply> arrayList) {
        if (stComment == null) {
            return null;
        }
        Comment comment = new Comment();
        comment.commentid = stComment.f359223id;
        comment.user = O(stComment.user, stCommonExt);
        comment.comment = p(stComment.content, null, 2, null);
        comment.commentPictureItems = n(stComment.content, null, 2, null);
        comment.time = (int) stComment.time;
        comment.replies = s(arrayList, stCommonExt);
        comment.replyNum = (int) stComment.replyNum;
        comment.clientKey = stComment.clientKey;
        return comment;
    }

    private static final CellLikeInfo.LikeMan L(StLikeMan stLikeMan, StCommonExt stCommonExt) {
        if (stLikeMan == null) {
            return null;
        }
        CellLikeInfo.LikeMan likeMan = new CellLikeInfo.LikeMan();
        likeMan.user = O(stLikeMan.user, stCommonExt);
        return likeMan;
    }

    public static final Reply M(StReply stReply, StCommonExt stCommonExt) {
        if (stReply == null) {
            return null;
        }
        Reply reply = new Reply();
        reply.replyId = stReply.f359225id;
        reply.user = O(stReply.user, stCommonExt);
        reply.targetUser = O(stReply.targetUser, stCommonExt);
        reply.content = p(stReply.content, null, 2, null);
        reply.date = (int) stReply.time;
        reply.clientKey = stReply.clientKey;
        return reply;
    }

    private static final PictureItem Q(StImage stImage) {
        if (stImage == null) {
            return null;
        }
        PictureItem pictureItem = new PictureItem();
        pictureItem.picname = stImage.name;
        pictureItem.sloc = stImage.sloc;
        pictureItem.lloc = stImage.lloc;
        pictureItem.isGif = stImage.isGif;
        ArrayList<StPicSpecUrlEntry> arrayList = stImage.photoUrl;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.photoUrl");
        h(pictureItem, arrayList);
        return pictureItem;
    }

    public static /* synthetic */ ArrayList b(ArrayList arrayList, String str, StCommonExt stCommonExt, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        if ((i3 & 4) != 0) {
            stCommonExt = null;
        }
        return a(arrayList, str, stCommonExt);
    }

    public static final StPicUrl l(StImage stImage) {
        if (stImage == null) {
            return null;
        }
        return t.f399471a.g(stImage.photoUrl);
    }

    public static /* synthetic */ ArrayList n(List list, StCommonExt stCommonExt, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            stCommonExt = null;
        }
        return m(list, stCommonExt);
    }

    public static /* synthetic */ String p(List list, StCommonExt stCommonExt, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            stCommonExt = null;
        }
        return o(list, stCommonExt);
    }
}
