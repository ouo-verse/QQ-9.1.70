package ub;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumCommData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonBatchInfoBanner;
import com.qzone.reborn.albumx.common.convert.bean.CommonMediaLbsAreaList;
import com.qzone.reborn.albumx.common.convert.bean.CommonStCommonExt;
import com.qzone.reborn.albumx.common.convert.bean.CommonStLBS;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStTimeLineEvent;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumMediaType;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxEditAlbumEvent;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxUpdateAlbumEvent;
import com.qzone.reborn.base.n;
import com.qzone.util.ToastUtil;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.BatchInfo;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetPhotoListByTimeLineCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetPhotoListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceSortPicCallback;
import com.tencent.qqnt.kernel.nativeinterface.ItemLinkType;
import com.tencent.qqnt.kernel.nativeinterface.MediaLbsAreaList;
import com.tencent.qqnt.kernel.nativeinterface.MediaListInfo;
import com.tencent.qqnt.kernel.nativeinterface.MediaScene;
import com.tencent.qqnt.kernel.nativeinterface.PAGetPhotoListByTimeLineReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetPhotoListByTimeLineRsp;
import com.tencent.qqnt.kernel.nativeinterface.PAGetPhotoListReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetPhotoListRsp;
import com.tencent.qqnt.kernel.nativeinterface.PASortPicReq;
import com.tencent.qqnt.kernel.nativeinterface.PASortPicRsp;
import com.tencent.qqnt.kernel.nativeinterface.PageEndMsg;
import com.tencent.qqnt.kernel.nativeinterface.RecommendMedia;
import com.tencent.qqnt.kernel.nativeinterface.StMedia;
import com.tencent.qqnt.kernel.nativeinterface.StTimeLine;
import com.tencent.qqnt.kernel.nativeinterface.TimeLineBindingType;
import com.tencent.qqnt.kernel.nativeinterface.TimeLineReqParam;
import com.tencent.qqnt.kernel.nativeinterface.TimeLineReqType;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.ArrayUtils;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import tb.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00fe\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u00ac\u00012\u00020\u0001:\u0002esB\t\u00a2\u0006\u0006\b\u00aa\u0001\u0010\u00ab\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u00a8\u0001\u0010'\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00162\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0014j\b\u0012\u0004\u0012\u00020\u0018`\u00162\u0006\u0010\u001b\u001a\u00020\u001a2\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0014j\b\u0012\u0004\u0012\u00020\u000f`\u00162\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u000bH\u0002Jp\u0010*\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00162\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0014j\b\u0012\u0004\u0012\u00020\u0018`\u00162\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010)\u001a\u00020\"H\u0002J\b\u0010+\u001a\u00020\u000bH\u0002J\b\u0010,\u001a\u00020\u0004H\u0002J@\u0010.\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000f2\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0014j\b\u0012\u0004\u0012\u00020\u0018`\u00162\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016H\u0002J\u0018\u00102\u001a\u00020\u00042\u000e\u00101\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/H\u0002J(\u00106\u001a\u0004\u0018\u0001002\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u0002032\f\u00101\u001a\b\u0012\u0004\u0012\u0002000/H\u0002J(\u00107\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000f2\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0014j\b\u0012\u0004\u0012\u00020\u0018`\u0016H\u0002J\u0018\u0010;\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\t2\u0006\u0010:\u001a\u000209H\u0002J\u0018\u0010>\u001a\u00020\u00042\u0006\u0010=\u001a\u00020<2\u0006\u0010(\u001a\u00020\u000fH\u0002J\u0018\u0010?\u001a\u00020\u00042\u0006\u0010=\u001a\u00020<2\u0006\u0010(\u001a\u00020\u000fH\u0002J \u0010@\u001a\u00020\u000b2\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u0002090\u0014j\b\u0012\u0004\u0012\u000209`\u0016H\u0002J,\u0010B\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020<0A2\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u0002090\u0014j\b\u0012\u0004\u0012\u000209`\u0016H\u0002J\u001a\u0010E\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010D\u001a\u00020CH\u0002J\u000e\u0010H\u001a\u00020\u00042\u0006\u0010G\u001a\u00020FJ\u0018\u0010K\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u000b2\b\u0010J\u001a\u0004\u0018\u000100J\u0018\u0010N\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010M\u001a\u00020LJ\u0018\u0010O\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010M\u001a\u00020LJ\u0010\u0010P\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u000e\u0010Q\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010R\u001a\u00020\u00042\u0006\u0010G\u001a\u00020FJ\u001f\u0010T\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010S\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\bT\u0010UJC\u0010[\u001a\u00020\u00042\u0006\u0010V\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010W\u001a\u0004\u0018\u00010\t2\b\u0010X\u001a\u0004\u0018\u00010\t2\b\u0010S\u001a\u0004\u0018\u00010\u000f2\u0006\u0010Z\u001a\u00020Y\u00a2\u0006\u0004\b[\u0010\\J\u0016\u0010]\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010J\u001a\u000200J8\u0010`\u001a\u00020\u00042\u0006\u0010V\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010X\u001a\u0004\u0018\u00010\t2\u0006\u0010^\u001a\u00020\u000f2\u0006\u0010J\u001a\u0002002\u0006\u0010Z\u001a\u00020_J\u0006\u0010a\u001a\u00020\u000bJ\u0016\u0010c\u001a\u00020\u000f2\u0006\u0010b\u001a\u0002032\u0006\u00108\u001a\u00020\tJ(\u0010e\u001a\u00020\u00042\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u0002090\u0014j\b\u0012\u0004\u0012\u000209`\u00162\u0006\u0010d\u001a\u00020\tH\u0016J(\u0010h\u001a\u00020\u00042\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u0002090\u0014j\b\u0012\u0004\u0012\u000209`\u00162\u0006\u0010g\u001a\u00020fH\u0016J(\u0010l\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010S\u001a\u00020\u000f2\u000e\u0010k\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010j0iR$\u0010r\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001d\u0010w\u001a\b\u0012\u0004\u0012\u00020<0/8\u0006\u00a2\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bu\u0010vR4\u0010~\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0/0A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R+\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u007f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R*\u0010\u008e\u0001\u001a\u00030\u0087\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R*\u0010S\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R+\u0010\u001e\u001a\u0005\u0018\u00010\u0095\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001b\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bc\u0010\u009d\u0001R\u001b\u0010\u00a1\u0001\u001a\u0005\u0018\u00010\u009f\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\f\u0010\u00a0\u0001R\u001a\u0010\u00a3\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bl\u0010\u00a2\u0001R\u0019\u0010\u00a6\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a4\u0001\u0010\u00a5\u0001R\u0019\u0010J\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\r\u0010\u00a7\u0001R\u001c\u0010\u00a9\u0001\u001a\b\u0012\u0004\u0012\u0002090/8BX\u0082\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00a8\u0001\u0010v\u00a8\u0006\u00ad\u0001"}, d2 = {"Lub/k;", "Lub/a;", "Lbb/g;", "requestBean", "", "W", "Lbb/d;", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "albumId", "", "i", "l", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "result", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/AlbumInfo;", "album", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchInfo;", "Lkotlin/collections/ArrayList;", "batchList", "Lcom/tencent/qqnt/kernel/nativeinterface/StMedia;", "mediaList", "Lcom/tencent/qqnt/kernel/nativeinterface/MediaListInfo;", "mediaInfo", "opmask", "Lcom/tencent/qqnt/kernel/nativeinterface/MediaLbsAreaList;", "mediaLbsAreaList", "traceId", "Lcom/tencent/qqnt/kernel/nativeinterface/StTimeLine;", "timeline", "Lcom/tencent/qqnt/kernel/nativeinterface/PageEndMsg;", "pageEndMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/RecommendMedia;", "recommendMedia", "isFromCache", "y", "requestType", "endMsg", HippyTKDListViewAdapter.X, "B", ExifInterface.LATITUDE_SOUTH, "stMediaList", "H", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", LinkReportConstant$GlobalKey.EVENTS, UserInfo.SEX_FEMALE, "", PhotoCategorySinglePicInfo.UPLOAD_TIME, "shootTime", "E", "T", "lLoc", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", QAdVrReportParams.ParamKey.MEDIA, BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/albumx/common/bean/a;", "batchBean", "p", "o", "K", "", DomainData.DOMAIN_NAME, "Lcom/qzone/reborn/albumx/common/bean/b;", "repoBean", "G", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", "bean", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "isTimeLine", "curTimeline", "U", "Lub/k$b;", "listener", "I", "V", "J", BdhLogUtil.LogTag.Tag_Req, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "sortType", "L", "(ZLjava/lang/Integer;)V", "uin", "llocId", "attachInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetPhotoListCallback;", "callback", "v", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetPhotoListCallback;)V", "O", "timelineType", "Lcom/tencent/qqnt/kernel/nativeinterface/IPersonalAlbumServiceGetPhotoListByTimeLineCallback;", "w", "D", "linkId", tl.h.F, "spaceId", "a", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLBS;", "lbs", "X", "Lcom/qzone/reborn/base/n$a;", "", "dataCallback", "j", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", "getInitBean", "()Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", "setInitBean", "(Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;)V", "initBean", "b", "Ljava/util/List;", ReportConstant.COSTREPORT_PREFIX, "()Ljava/util/List;", "allBatch", "c", "Ljava/util/Map;", "getListenerMap", "()Ljava/util/Map;", "setListenerMap", "(Ljava/util/Map;)V", "listenerMap", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "d", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "getAlbumInfoData", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "setAlbumInfoData", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;)V", "albumInfoData", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "e", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "t", "()Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "setLoadInfo", "(Lcom/tencent/biz/richframework/part/block/base/LoadInfo;)V", "loadInfo", "f", "Ljava/lang/Integer;", "getSortType", "()Ljava/lang/Integer;", "setSortType", "(Ljava/lang/Integer;)V", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsAreaList;", "g", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsAreaList;", "getMediaLbsAreaList", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsAreaList;", "setMediaLbsAreaList", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsAreaList;)V", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumCommData;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumCommData;", "commData", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "commonExt", "Lbb/g;", "layerRequestBean", "k", "Z", "isTimeLineMode", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "u", "mediaInfoList", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class k implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private QZAlbumxAlbumDetailInitBean initBean;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private CommonAlbumInfo albumInfoData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Integer sortType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private CommonMediaLbsAreaList mediaLbsAreaList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private CommonAlbumCommData commData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private CommonStCommonExt commonExt;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private bb.g layerRequestBean;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isTimeLineMode;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private CommonStTimeLineEvent curTimeline;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<com.qzone.reborn.albumx.common.bean.a> allBatch = new ArrayList();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Map<String, List<b>> listenerMap = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LoadInfo loadInfo = new LoadInfo();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lub/k$b;", "", "Lcom/qzone/reborn/albumx/common/bean/b;", "repoBean", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public interface b {
        void a(com.qzone.reborn.albumx.common.bean.b repoBean);
    }

    private final boolean B() {
        return this.loadInfo.isFinish();
    }

    private final boolean C(String lLoc, CommonStMedia media) {
        if (media.getType() == CommonEnumMediaType.IMAGE.ordinal()) {
            return TextUtils.equals(media.getImage().getLloc(), lLoc);
        }
        return TextUtils.equals(media.getVideo().getCover().getLloc(), lLoc);
    }

    private final CommonStTimeLineEvent E(long uploadTime, long shootTime, List<CommonStTimeLineEvent> events) {
        CommonStTimeLineEvent commonStTimeLineEvent = null;
        for (CommonStTimeLineEvent commonStTimeLineEvent2 : events) {
            long j3 = commonStTimeLineEvent2.getBindingType() == TimeLineBindingType.KTIMELINEBINDINGMEDIASHOOTTIME.ordinal() ? shootTime : uploadTime;
            if (j3 >= commonStTimeLineEvent2.getBeginTime() && j3 < commonStTimeLineEvent2.getEndTime()) {
                commonStTimeLineEvent = commonStTimeLineEvent2;
            }
        }
        return commonStTimeLineEvent;
    }

    private final void F(List<CommonStTimeLineEvent> events) {
        CommonStTimeLineEvent E;
        List<com.qzone.reborn.albumx.common.bean.a> list = this.allBatch;
        if (!(list == null || list.isEmpty())) {
            List<CommonStTimeLineEvent> list2 = events;
            if (!(list2 == null || list2.isEmpty())) {
                for (com.qzone.reborn.albumx.common.bean.a aVar : this.allBatch) {
                    if (!aVar.getBatchInfo().j().isEmpty() && (E = E(aVar.getBatchInfo().j().get(0).getUploadTime(), aVar.getBatchInfo().j().get(0).getShootTime(), events)) != null) {
                        aVar.getBatchInfo().y(E);
                    }
                }
                return;
            }
        }
        QLog.e("QZAlbumxDetailRepo", 1, "matchTimeEventToBatchInfo  allBatch or events error");
    }

    private final void H(int requestType, ArrayList<StMedia> stMediaList, ArrayList<BatchInfo> batchList) {
        long j3;
        for (StMedia stMedia : stMediaList) {
            for (BatchInfo batchInfo : batchList) {
                if (batchInfo.linkType == ItemLinkType.KITEMLINKTYPEMEDIALINKID.ordinal()) {
                    j3 = stMedia.linkId;
                } else {
                    j3 = stMedia.batchId;
                }
                if (j3 == batchInfo.linkId) {
                    batchInfo.medias.add(stMedia);
                }
            }
        }
        int i3 = 0;
        if (requestType == 3) {
            int size = batchList.size();
            if (!bl.b(batchList) && !bl.b(this.allBatch) && batchList.get(batchList.size() - 1).linkId == this.allBatch.get(0).getBatchInfo().getLinkId()) {
                ArrayList<StMedia> arrayList = batchList.get(batchList.size() - 1).medias;
                Intrinsics.checkNotNullExpressionValue(arrayList, "batchList[batchList.size - 1].medias");
                for (StMedia it : arrayList) {
                    List<CommonStMedia> j16 = this.allBatch.get(0).getBatchInfo().j();
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    j16.add(xh.h.b(it));
                }
                size = batchList.size() - 1;
            }
            QLog.d("QZAlbumxDetailRepo", 1, "polymerizeBatchListData  endMergeBatchPos = " + size);
            for (int i16 = size - 1; -1 < i16; i16--) {
                BatchInfo batchInfo2 = batchList.get(i16);
                Intrinsics.checkNotNullExpressionValue(batchInfo2, "batchList[i]");
                com.qzone.reborn.albumx.common.bean.a aVar = new com.qzone.reborn.albumx.common.bean.a(xh.b.a(batchInfo2));
                p(aVar, requestType);
                o(aVar, requestType);
                this.allBatch.add(0, aVar);
            }
            return;
        }
        if (!bl.b(batchList) && !bl.b(this.allBatch)) {
            long j17 = batchList.get(0).linkId;
            List<com.qzone.reborn.albumx.common.bean.a> list = this.allBatch;
            if (j17 == list.get(list.size() - 1).getBatchInfo().getLinkId()) {
                ArrayList<StMedia> arrayList2 = batchList.get(0).medias;
                Intrinsics.checkNotNullExpressionValue(arrayList2, "batchList[0].medias");
                for (StMedia it5 : arrayList2) {
                    List<com.qzone.reborn.albumx.common.bean.a> list2 = this.allBatch;
                    List<CommonStMedia> j18 = list2.get(list2.size() - 1).getBatchInfo().j();
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    j18.add(xh.h.b(it5));
                }
                i3 = 1;
            }
        }
        QLog.d("QZAlbumxDetailRepo", 1, "polymerizeBatchListData  startMergeBatchPos = " + i3);
        int size2 = batchList.size();
        while (i3 < size2) {
            BatchInfo batchInfo3 = batchList.get(i3);
            Intrinsics.checkNotNullExpressionValue(batchInfo3, "batchList[i]");
            com.qzone.reborn.albumx.common.bean.a aVar2 = new com.qzone.reborn.albumx.common.bean.a(xh.b.a(batchInfo3));
            p(aVar2, requestType);
            o(aVar2, requestType);
            this.allBatch.add(aVar2);
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(long j3, final k this$0, final boolean z16, final PAGetPhotoListRsp pAGetPhotoListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!pAGetPhotoListRsp.isFromCache) {
            mc.c.f416541a.e(QZoneHelper.QZoneAppConstants.REFER_PHOTO_LIST, System.currentTimeMillis() - j3, pAGetPhotoListRsp.result);
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: ub.j
            @Override // java.lang.Runnable
            public final void run() {
                k.N(PAGetPhotoListRsp.this, this$0, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(long j3, final k this$0, final int i3, final PAGetPhotoListByTimeLineRsp pAGetPhotoListByTimeLineRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        mc.c.f416541a.e("getPhotoListByTimeLine", System.currentTimeMillis() - j3, pAGetPhotoListByTimeLineRsp.result);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: ub.i
            @Override // java.lang.Runnable
            public final void run() {
                k.Q(PAGetPhotoListByTimeLineRsp.this, this$0, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(PAGetPhotoListByTimeLineRsp pAGetPhotoListByTimeLineRsp, k this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QZAlbumxDetailRepo", 1, "requestGetAlbumBatchListByTimeline response traceId : " + pAGetPhotoListByTimeLineRsp.traceId + " sortType:" + this$0.sortType + " ");
        String str = pAGetPhotoListByTimeLineRsp.attachInfo;
        MediaListInfo mediaListInfo = new MediaListInfo(str, str, pAGetPhotoListByTimeLineRsp.preHasMore, pAGetPhotoListByTimeLineRsp.nextHasMore, 0);
        int i16 = pAGetPhotoListByTimeLineRsp.result;
        String str2 = pAGetPhotoListByTimeLineRsp.errMs;
        Intrinsics.checkNotNullExpressionValue(str2, "response.errMs");
        AlbumInfo albumInfo = pAGetPhotoListByTimeLineRsp.albumInfo;
        Intrinsics.checkNotNullExpressionValue(albumInfo, "response.albumInfo");
        ArrayList<BatchInfo> arrayList = pAGetPhotoListByTimeLineRsp.batchList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "response.batchList");
        ArrayList<StMedia> arrayList2 = pAGetPhotoListByTimeLineRsp.medias;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "response.medias");
        String str3 = pAGetPhotoListByTimeLineRsp.traceId;
        Intrinsics.checkNotNullExpressionValue(str3, "response.traceId");
        PageEndMsg pageEndMsg = pAGetPhotoListByTimeLineRsp.endMsg;
        Intrinsics.checkNotNullExpressionValue(pageEndMsg, "response.endMsg");
        this$0.x(i3, i16, str2, albumInfo, arrayList, arrayList2, mediaListInfo, str3, pageEndMsg);
    }

    private final void S() {
        LoadInfo loadInfo = new LoadInfo();
        this.loadInfo = loadInfo;
        loadInfo.setStringAttachInfo("");
        this.loadInfo.setFinish(false);
        this.loadInfo.setCanPageUp(false);
    }

    private final void T(int requestType, ArrayList<StMedia> mediaList) {
        if (mediaList.isEmpty()) {
            return;
        }
        if (requestType == 1) {
            u().clear();
            QLog.i("QZAlbumxDetailRepo", 1, "media list size is " + mediaList.size());
            Iterator<T> it = mediaList.iterator();
            while (it.hasNext()) {
                u().add(xh.h.b((StMedia) it.next()));
            }
            return;
        }
        if (requestType != 3) {
            QLog.i("QZAlbumxDetailRepo", 1, "media list size is2 " + mediaList.size());
            Iterator<T> it5 = mediaList.iterator();
            while (it5.hasNext()) {
                u().add(xh.h.b((StMedia) it5.next()));
            }
            return;
        }
        QLog.i("QZAlbumxDetailRepo", 1, "media list size is1 " + mediaList.size());
        ArrayList arrayList = new ArrayList();
        Iterator<T> it6 = mediaList.iterator();
        while (it6.hasNext()) {
            arrayList.add(xh.h.b((StMedia) it6.next()));
        }
        u().addAll(0, arrayList);
    }

    private final void W(bb.g requestBean) {
        bb.d q16 = q(requestBean);
        bb.b bVar = new bb.b();
        bVar.A(q16);
        bVar.p(true);
        G(requestBean.getAlbumId(), bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(n.a dataCallback, PASortPicRsp pASortPicRsp) {
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        QLog.i("QZAlbumxDetailRepo", 1, "sortPic response traceId:" + pASortPicRsp.traceId + ", result: " + pASortPicRsp.result + ", errMs:" + pASortPicRsp.errMs);
        int i3 = pASortPicRsp.result;
        if (i3 == 0) {
            String str = pASortPicRsp.errMs;
            Intrinsics.checkNotNullExpressionValue(str, "response.errMs");
            dataCallback.onSuccess(null, i3, str, true);
            return;
        }
        dataCallback.onFailure(i3, pASortPicRsp.errMs);
    }

    private final void l(String albumId) {
        PreLoader.addListener("qzone_albumx_detail_album_list_data_preload_id", new OnTaskListener() { // from class: ub.g
            @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
            public final void onComplete(Object[] objArr) {
                k.m(k.this, objArr);
            }
        });
    }

    private final Map<Long, com.qzone.reborn.albumx.common.bean.a> n(ArrayList<CommonStMedia> mediaList) {
        long batchId;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return linkedHashMap;
        }
        Iterator<CommonStMedia> it = mediaList.iterator();
        while (it.hasNext()) {
            CommonStMedia stMedia = it.next();
            fj.p pVar = fj.p.f399467a;
            Intrinsics.checkNotNullExpressionValue(stMedia, "stMedia");
            String i3 = pVar.i(stMedia);
            Iterator<com.qzone.reborn.albumx.common.bean.a> it5 = this.allBatch.iterator();
            while (true) {
                if (it5.hasNext()) {
                    com.qzone.reborn.albumx.common.bean.a next = it5.next();
                    if (next.getBatchInfo().getLinkType() == ItemLinkType.KITEMLINKTYPEMEDIALINKID.ordinal()) {
                        batchId = stMedia.getLinkId();
                    } else {
                        batchId = stMedia.getBatchId();
                    }
                    if (next.getBatchInfo().getLinkId() == batchId) {
                        List<CommonStMedia> j3 = next.getBatchInfo().j();
                        if (!j3.isEmpty()) {
                            Iterator<CommonStMedia> it6 = j3.iterator();
                            while (true) {
                                if (!it6.hasNext()) {
                                    break;
                                }
                                if (C(i3, it6.next())) {
                                    linkedHashMap.put(Long.valueOf(next.getBatchInfo().getLinkId()), next);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private final void o(com.qzone.reborn.albumx.common.bean.a batchBean, int requestType) {
        List<com.qzone.reborn.albumx.common.bean.a> reversed;
        batchBean.i(batchBean.getBatchInfo().getBanner());
        reversed = CollectionsKt___CollectionsKt.reversed(this.allBatch);
        for (com.qzone.reborn.albumx.common.bean.a aVar : reversed) {
            if (aVar.getBannerInfo().c(batchBean.getBannerInfo())) {
                if (requestType == 3) {
                    aVar.getBatchInfo().p(new CommonBatchInfoBanner());
                } else {
                    batchBean.getBatchInfo().p(new CommonBatchInfoBanner());
                }
            }
        }
    }

    private final void p(com.qzone.reborn.albumx.common.bean.a batchBean, int requestType) {
        List<com.qzone.reborn.albumx.common.bean.a> reversed;
        batchBean.k(batchBean.getBatchInfo().getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME java.lang.String());
        reversed = CollectionsKt___CollectionsKt.reversed(this.allBatch);
        for (com.qzone.reborn.albumx.common.bean.a aVar : reversed) {
            if (Intrinsics.areEqual(aVar.getTimeId(), batchBean.getBatchInfo().getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME java.lang.String())) {
                if (requestType == 3) {
                    aVar.getBatchInfo().w("");
                } else {
                    batchBean.getBatchInfo().w("");
                }
            }
        }
    }

    private final bb.d q(bb.g requestBean) {
        long coerceIn;
        CommonStUser creator;
        bb.d dVar = new bb.d();
        if (requestBean == null) {
            return dVar;
        }
        String stringAttachInfo = this.loadInfo.getStringAttachInfo();
        Intrinsics.checkNotNullExpressionValue(stringAttachInfo, "loadInfo.stringAttachInfo");
        dVar.j0(stringAttachInfo);
        dVar.t0(requestBean.getIsRefresh());
        dVar.p0(requestBean.getIsFetchLeft());
        dVar.q0(requestBean.getIsFetchRight());
        dVar.r0(this.loadInfo.isFinish());
        dVar.u0(!this.loadInfo.canPageUp());
        CommonAlbumInfo commonAlbumInfo = this.albumInfoData;
        String str = null;
        dVar.k(commonAlbumInfo != null ? commonAlbumInfo.getName() : null);
        CommonAlbumInfo commonAlbumInfo2 = this.albumInfoData;
        dVar.j(commonAlbumInfo2 != null ? commonAlbumInfo2.getAlbumId() : null);
        CommonAlbumInfo commonAlbumInfo3 = this.albumInfoData;
        coerceIn = RangesKt___RangesKt.coerceIn(commonAlbumInfo3 != null ? commonAlbumInfo3.getUploadNumber() : 0L, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, TTL.MAX_VALUE);
        dVar.s0((int) coerceIn);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(u());
        String uin = requestBean.getUin();
        if (uin == null) {
            uin = "";
        }
        dVar.k0(uin);
        CommonAlbumInfo commonAlbumInfo4 = this.albumInfoData;
        if (commonAlbumInfo4 != null && (creator = commonAlbumInfo4.getCreator()) != null) {
            str = creator.getUin();
        }
        dVar.d0(str);
        dVar.y(new ArrayList<>(arrayList));
        return dVar;
    }

    private final bb.d r() {
        bb.g gVar = this.layerRequestBean;
        if (gVar != null) {
            gVar.l(true);
        }
        bb.g gVar2 = this.layerRequestBean;
        if (gVar2 != null) {
            gVar2.g(true);
        }
        bb.g gVar3 = this.layerRequestBean;
        if (gVar3 != null) {
            gVar3.h(true);
        }
        return q(this.layerRequestBean);
    }

    private final List<CommonStMedia> u() {
        ArrayList arrayList = new ArrayList();
        Iterator<com.qzone.reborn.albumx.common.bean.a> it = this.allBatch.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getBatchInfo().j());
        }
        return arrayList;
    }

    private final void x(int requestType, int result, String errMsg, AlbumInfo album, ArrayList<BatchInfo> batchList, ArrayList<StMedia> mediaList, MediaListInfo mediaInfo, String traceId, PageEndMsg endMsg) {
        String str;
        QLog.e("QZAlbumxDetailRepo", 1, "handleAlbumDetailListByTimelineResponse result:=" + result + ",traceId:=" + traceId);
        this.loadInfo.setCurrentState(4);
        if (result != 0) {
            ToastUtil.s(errMsg, 4);
            QLog.e("QZAlbumxDetailRepo", 1, "handleAlbumDetailListByTimelineResponse rsp error  isSuccess = false, errMsg = " + errMsg);
            List<com.qzone.reborn.albumx.common.bean.a> list = this.allBatch;
            CommonAlbumCommData commonAlbumCommData = this.commData;
            QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = this.initBean;
            String albumId = qZAlbumxAlbumDetailInitBean != null ? qZAlbumxAlbumDetailInitBean.getAlbumId() : null;
            com.qzone.reborn.albumx.common.bean.b bVar = new bb.b();
            bVar.s(result);
            bVar.q(requestType != 1);
            if (bVar.getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE java.lang.String()) {
                bVar.l(list);
                bVar.m(commonAlbumCommData);
            }
            Unit unit = Unit.INSTANCE;
            G(albumId, bVar);
            return;
        }
        LoadInfo loadInfo = this.loadInfo;
        if (requestType == 2) {
            str = mediaInfo.nextAttachInfo;
        } else if (requestType != 3) {
            String str2 = mediaInfo.nextAttachInfo;
            Intrinsics.checkNotNullExpressionValue(str2, "mediaInfo.nextAttachInfo");
            if (str2.length() > 0) {
                str = mediaInfo.nextAttachInfo;
            } else {
                String str3 = mediaInfo.prevAttachInfo;
                Intrinsics.checkNotNullExpressionValue(str3, "mediaInfo.prevAttachInfo");
                if (str3.length() > 0) {
                    str = mediaInfo.prevAttachInfo;
                } else {
                    str = "";
                }
            }
        } else {
            str = mediaInfo.prevAttachInfo;
        }
        loadInfo.setStringAttachInfo(str);
        if (requestType == 1) {
            this.allBatch.clear();
        }
        H(requestType, mediaList, batchList);
        CommonAlbumCommData commonAlbumCommData2 = this.commData;
        F(commonAlbumCommData2 != null ? commonAlbumCommData2.e() : null);
        T(requestType, mediaList);
        if (requestType == 1 || requestType == 2) {
            this.loadInfo.setFinish(!mediaInfo.nextHasMore);
        }
        if (requestType == 1 || requestType == 3) {
            this.loadInfo.setCanPageUp(mediaInfo.prevHasMore);
        }
        bb.b bVar2 = new bb.b();
        bVar2.m(this.commData);
        bVar2.k(this.albumInfoData);
        bVar2.o(errMsg);
        bVar2.s(result);
        bVar2.q(requestType != 1);
        bVar2.B(this.mediaLbsAreaList);
        bVar2.l(this.allBatch);
        if (endMsg.code != 0) {
            bVar2.C(fb.a.l(endMsg));
        }
        bVar2.A(q(this.layerRequestBean));
        bVar2.E(requestType);
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean2 = this.initBean;
        G(qZAlbumxAlbumDetailInitBean2 != null ? qZAlbumxAlbumDetailInitBean2.getAlbumId() : null, bVar2);
    }

    private final void y(boolean isLoadMore, int result, String errMsg, AlbumInfo album, ArrayList<BatchInfo> batchList, ArrayList<StMedia> mediaList, MediaListInfo mediaInfo, ArrayList<Integer> opmask, MediaLbsAreaList mediaLbsAreaList, String traceId, StTimeLine timeline, PageEndMsg pageEndMsg, RecommendMedia recommendMedia, boolean isFromCache) {
        int i3;
        ArrayList<BatchInfo> arrayList;
        ArrayList<StMedia> arrayList2;
        String str;
        QLog.e("QZAlbumxDetailRepo", 1, "handleAlbumDetailListResponse result:=" + result + ",traceId:=" + traceId);
        this.loadInfo.setCurrentState(4);
        if (result != 0) {
            if (result != 10097) {
                if (result == 1002) {
                    str = com.qzone.util.l.a(R.string.jhn);
                    Intrinsics.checkNotNullExpressionValue(str, "qqStr(R.string.qzone_albumx_notice_network_error)");
                } else {
                    str = errMsg;
                }
                ToastUtil.s(str, 4);
            }
            QLog.e("QZAlbumxDetailRepo", 1, "albumDetailListResponse rsp error  isSuccess = false, errMsg = " + errMsg);
            List<com.qzone.reborn.albumx.common.bean.a> list = this.allBatch;
            CommonAlbumCommData commonAlbumCommData = this.commData;
            QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = this.initBean;
            String albumId = qZAlbumxAlbumDetailInitBean != null ? qZAlbumxAlbumDetailInitBean.getAlbumId() : null;
            com.qzone.reborn.albumx.common.bean.b bVar = new bb.b();
            bVar.s(result);
            bVar.q(isLoadMore);
            if (isLoadMore) {
                bVar.l(list);
                bVar.m(commonAlbumCommData);
            }
            Unit unit = Unit.INSTANCE;
            G(albumId, bVar);
            return;
        }
        this.loadInfo.setStringAttachInfo(mediaInfo.nextAttachInfo);
        if (!isLoadMore) {
            CommonAlbumCommData commonAlbumCommData2 = new CommonAlbumCommData();
            this.commData = commonAlbumCommData2;
            commonAlbumCommData2.k(false);
            commonAlbumCommData2.c().addAll(opmask);
            commonAlbumCommData2.e().addAll(com.qzone.reborn.albumx.qzonex.utils.g.f53410a.a(timeline));
            CommonAlbumInfo a16 = xh.a.a(album);
            this.albumInfoData = a16;
            this.sortType = a16 != null ? Integer.valueOf(a16.getSortType()) : null;
            this.allBatch.clear();
            this.mediaLbsAreaList = fb.a.i(mediaLbsAreaList);
        }
        if (isLoadMore) {
            i3 = 2;
            arrayList = batchList;
            arrayList2 = mediaList;
        } else {
            arrayList = batchList;
            arrayList2 = mediaList;
            i3 = 1;
        }
        H(i3, arrayList2, arrayList);
        CommonAlbumCommData commonAlbumCommData3 = this.commData;
        F(commonAlbumCommData3 != null ? commonAlbumCommData3.e() : null);
        this.loadInfo.setFinish(!mediaInfo.nextHasMore);
        bb.b bVar2 = new bb.b();
        bVar2.m(this.commData);
        bVar2.k(this.albumInfoData);
        bVar2.o(errMsg);
        bVar2.s(result);
        bVar2.q(isLoadMore);
        bVar2.l(this.allBatch);
        bVar2.r(opmask);
        bVar2.B(this.mediaLbsAreaList);
        bVar2.z(isFromCache);
        bVar2.D(fb.a.m(recommendMedia));
        if (pageEndMsg.code != 0) {
            bVar2.C(fb.a.l(pageEndMsg));
        }
        bVar2.A(q(this.layerRequestBean));
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean2 = this.initBean;
        G(qZAlbumxAlbumDetailInitBean2 != null ? qZAlbumxAlbumDetailInitBean2.getAlbumId() : null, bVar2);
    }

    public final void A(QZAlbumxAlbumDetailInitBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        this.initBean = bean;
    }

    public final boolean D() {
        return !this.loadInfo.canPageUp();
    }

    public final void I(String albumId, b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (albumId == null || albumId.length() == 0) {
            RFWLog.e("QZAlbumxDetailRepo", RFWLog.USR, "register fail groupId is null");
            return;
        }
        if (!this.listenerMap.containsKey(albumId)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(listener);
            this.listenerMap.put(albumId, arrayList);
            return;
        }
        List<b> list = this.listenerMap.get(albumId);
        Intrinsics.checkNotNull(list);
        Iterator<b> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(String.valueOf(listener.hashCode()), String.valueOf(it.next().hashCode()))) {
                return;
            }
        }
        List<b> list2 = this.listenerMap.get(albumId);
        if (list2 != null) {
            list2.add(listener);
        }
    }

    public final void J(String albumId) {
        S();
        if (!(albumId == null || albumId.length() == 0) && this.listenerMap.containsKey(albumId)) {
            this.listenerMap.remove(albumId);
        }
        this.allBatch.clear();
        this.albumInfoData = null;
        this.initBean = null;
        this.layerRequestBean = null;
        this.isTimeLineMode = false;
        this.curTimeline = null;
        this.sortType = null;
        this.mediaLbsAreaList = null;
    }

    public final void O(int requestType, CommonStTimeLineEvent curTimeline) {
        int ordinal;
        Intrinsics.checkNotNullParameter(curTimeline, "curTimeline");
        if (requestType == 1) {
            S();
        }
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = this.initBean;
        if (qZAlbumxAlbumDetailInitBean != null) {
            Intrinsics.checkNotNull(qZAlbumxAlbumDetailInitBean);
            if (TextUtils.isEmpty(qZAlbumxAlbumDetailInitBean.getAlbumId())) {
                return;
            }
            QLog.d("QZAlbumxDetailRepo", 1, "requestGetAlbumBatchListByTimeline  attachInfo : " + this.loadInfo.getStringAttachInfo() + " | requestType : " + requestType + " | initBean : " + this.initBean);
            if (requestType == 2 && B()) {
                return;
            }
            if (requestType == 3 && D()) {
                return;
            }
            this.loadInfo.setCurrentState(requestType != 1 ? requestType != 3 ? 0 : 1 : 2);
            if (requestType == 1) {
                ordinal = TimeLineReqType.KTIMELINEREQTYPEJUMP.ordinal();
            } else if (requestType != 3) {
                ordinal = TimeLineReqType.KTIMELINEREQTYPEDOWN.ordinal();
            } else {
                ordinal = TimeLineReqType.KTIMELINEREQTYPEUP.ordinal();
            }
            final int i3 = ordinal;
            QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean2 = this.initBean;
            if (qZAlbumxAlbumDetailInitBean2 != null) {
                final long currentTimeMillis = System.currentTimeMillis();
                w(qZAlbumxAlbumDetailInitBean2.getUin(), qZAlbumxAlbumDetailInitBean2.getAlbumId(), this.loadInfo.getStringAttachInfo(), i3, curTimeline, new IPersonalAlbumServiceGetPhotoListByTimeLineCallback() { // from class: ub.f
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetPhotoListByTimeLineCallback
                    public final void onGetPhotoListByTimeLine(PAGetPhotoListByTimeLineRsp pAGetPhotoListByTimeLineRsp) {
                        k.P(currentTimeMillis, this, i3, pAGetPhotoListByTimeLineRsp);
                    }
                });
            }
        }
    }

    public final void R(bb.g requestBean) {
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        if (this.initBean == null) {
            RFWLog.e("QZAlbumxDetailRepo", RFWLog.USR, "initBean is null");
            return;
        }
        this.layerRequestBean = requestBean;
        if (requestBean.getIsRefresh()) {
            W(requestBean);
            return;
        }
        if (!this.isTimeLineMode) {
            L(true, this.sortType);
        } else if (this.curTimeline != null) {
            int i3 = requestBean.getIsFetchLeft() ? 3 : 2;
            CommonStTimeLineEvent commonStTimeLineEvent = this.curTimeline;
            Intrinsics.checkNotNull(commonStTimeLineEvent);
            O(i3, commonStTimeLineEvent);
        }
    }

    public final void U(boolean isTimeLine, CommonStTimeLineEvent curTimeline) {
        this.isTimeLineMode = isTimeLine;
        this.curTimeline = curTimeline;
    }

    public final void V(String albumId, b listener) {
        List<b> list;
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (albumId == null || albumId.length() == 0) {
            RFWLog.e("QZAlbumxDetailRepo", RFWLog.USR, "unregister fail groupId is null");
        } else if (this.listenerMap.containsKey(albumId) && (list = this.listenerMap.get(albumId)) != null) {
            list.remove(listener);
        }
    }

    public void X(ArrayList<CommonStMedia> mediaList, CommonStLBS lbs) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Intrinsics.checkNotNullParameter(lbs, "lbs");
        Iterator<T> it = n(mediaList).values().iterator();
        while (it.hasNext()) {
            ((com.qzone.reborn.albumx.common.bean.a) it.next()).getBatchInfo().r(lbs);
        }
        bb.b bVar = new bb.b();
        bVar.m(this.commData);
        bVar.l(this.allBatch);
        bVar.k(this.albumInfoData);
        bVar.n(this.commonExt);
        bVar.q(true);
        bVar.B(this.mediaLbsAreaList);
        bVar.A(r());
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = this.initBean;
        G(qZAlbumxAlbumDetailInitBean != null ? qZAlbumxAlbumDetailInitBean.getAlbumId() : null, bVar);
    }

    @Override // ub.a
    public void a(ArrayList<CommonStMedia> mediaList, String spaceId) {
        String albumId;
        CommonAlbumInfo commonAlbumInfo;
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        boolean K = K(mediaList);
        String str = "";
        if (!K) {
            RFWLog.e("", RFWLog.USR, "isFindInBatchList = " + K);
            return;
        }
        CommonAlbumInfo commonAlbumInfo2 = this.albumInfoData;
        long uploadNumber = (commonAlbumInfo2 != null ? commonAlbumInfo2.getUploadNumber() : 0L) - mediaList.size();
        if (uploadNumber >= 0 && (commonAlbumInfo = this.albumInfoData) != null) {
            commonAlbumInfo.y0(uploadNumber);
        }
        bb.b bVar = new bb.b();
        bVar.m(this.commData);
        bVar.l(this.allBatch);
        bVar.k(this.albumInfoData);
        bVar.n(this.commonExt);
        bVar.q(true);
        bVar.B(this.mediaLbsAreaList);
        bVar.A(r());
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = this.initBean;
        G(qZAlbumxAlbumDetailInitBean != null ? qZAlbumxAlbumDetailInitBean.getAlbumId() : null, bVar);
        SimpleEventBus.getInstance().dispatchEvent(new QZAlbumxEditAlbumEvent(spaceId, null, this.albumInfoData, null, 10, null));
        if (this.allBatch.isEmpty()) {
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            CommonAlbumInfo commonAlbumInfo3 = this.albumInfoData;
            if (commonAlbumInfo3 != null && (albumId = commonAlbumInfo3.getAlbumId()) != null) {
                str = albumId;
            }
            simpleEventBus.dispatchEvent(new QZAlbumxUpdateAlbumEvent(str));
        }
    }

    public final int h(long linkId, String lLoc) {
        Intrinsics.checkNotNullParameter(lLoc, "lLoc");
        Iterator<com.qzone.reborn.albumx.common.bean.a> it = this.allBatch.iterator();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.qzone.reborn.albumx.common.bean.a next = it.next();
            if (next.getBatchInfo().getLinkId() == linkId) {
                List<CommonStMedia> j3 = next.getBatchInfo().j();
                if (!bl.b(j3)) {
                    Iterator<CommonStMedia> it5 = j3.iterator();
                    int i16 = 0;
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        if (C(lLoc, it5.next())) {
                            z16 = true;
                            break;
                        }
                        i16++;
                    }
                    i3 += i16;
                }
            } else {
                i3 += next.getBatchInfo().j().size();
            }
        }
        if (z16) {
            return i3;
        }
        return -1;
    }

    public final void j(String albumId, int sortType, final n.a<Object> dataCallback) {
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        boolean z16 = true;
        QLog.i("QZAlbumxDetailRepo", 1, "editSortType albumId:" + albumId + ", sortType:" + sortType);
        if (albumId != null && albumId.length() != 0) {
            z16 = false;
        }
        if (z16) {
            dataCallback.onFailure(-1L, "");
            return;
        }
        PASortPicReq pASortPicReq = new PASortPicReq();
        pASortPicReq.albumId = albumId;
        pASortPicReq.sortType = sortType;
        com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.sortPic(pASortPicReq, new IPersonalAlbumServiceSortPicCallback() { // from class: ub.h
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceSortPicCallback
                public final void onSortPic(PASortPicRsp pASortPicRsp) {
                    k.k(n.a.this, pASortPicRsp);
                }
            });
        }
    }

    public final List<com.qzone.reborn.albumx.common.bean.a> s() {
        return this.allBatch;
    }

    /* renamed from: t, reason: from getter */
    public final LoadInfo getLoadInfo() {
        return this.loadInfo;
    }

    public final void v(String uin, String albumId, String llocId, String attachInfo, Integer sortType, IPersonalAlbumServiceGetPhotoListCallback callback) {
        int ordinal;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        PAGetPhotoListReq pAGetPhotoListReq = new PAGetPhotoListReq();
        pAGetPhotoListReq.owner.uin = uin;
        pAGetPhotoListReq.albumId = albumId;
        pAGetPhotoListReq.curLloc = llocId;
        if (sortType != null) {
            ordinal = MediaScene.KMEDIASCENEALBUMPAGE.ordinal();
        } else {
            ordinal = MediaScene.KMEDIASCENEUNKNOWN.ordinal();
        }
        pAGetPhotoListReq.scene = ordinal;
        pAGetPhotoListReq.attachInfo = attachInfo;
        pAGetPhotoListReq.sortType = sortType != null ? sortType.intValue() : 0;
        pAGetPhotoListReq.questionAnswer.answer = com.qzone.reborn.albumx.qzonex.utils.e.f53405a.c(albumId);
        pAGetPhotoListReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
        com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.getPhotoList(pAGetPhotoListReq, callback);
        }
    }

    public final void w(String uin, String albumId, String attachInfo, int timelineType, CommonStTimeLineEvent curTimeline, IPersonalAlbumServiceGetPhotoListByTimeLineCallback callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(curTimeline, "curTimeline");
        Intrinsics.checkNotNullParameter(callback, "callback");
        PAGetPhotoListByTimeLineReq pAGetPhotoListByTimeLineReq = new PAGetPhotoListByTimeLineReq();
        pAGetPhotoListByTimeLineReq.owner.uin = uin;
        pAGetPhotoListByTimeLineReq.albumId = albumId;
        pAGetPhotoListByTimeLineReq.attachInfo = attachInfo;
        Integer num = this.sortType;
        pAGetPhotoListByTimeLineReq.sortType = num != null ? num.intValue() : 0;
        TimeLineReqParam timeLineReqParam = pAGetPhotoListByTimeLineReq.timeLineParam;
        timeLineReqParam.type = timelineType;
        timeLineReqParam.event = com.qzone.reborn.albumx.qzonex.utils.g.f53410a.c(curTimeline);
        pAGetPhotoListByTimeLineReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
        com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.getPhotoListByTimeLine(pAGetPhotoListByTimeLineReq, callback);
        }
    }

    public final void z(QZAlbumxAlbumDetailInitBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        this.initBean = bean;
    }

    private final boolean K(ArrayList<CommonStMedia> mediaList) {
        long batchId;
        boolean z16 = false;
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return false;
        }
        Iterator<CommonStMedia> it = mediaList.iterator();
        while (it.hasNext()) {
            CommonStMedia stMedia = it.next();
            fj.p pVar = fj.p.f399467a;
            Intrinsics.checkNotNullExpressionValue(stMedia, "stMedia");
            String i3 = pVar.i(stMedia);
            Iterator<com.qzone.reborn.albumx.common.bean.a> it5 = this.allBatch.iterator();
            while (true) {
                if (it5.hasNext()) {
                    com.qzone.reborn.albumx.common.bean.a next = it5.next();
                    if (next.getBatchInfo().getLinkType() == ItemLinkType.KITEMLINKTYPEMEDIALINKID.ordinal()) {
                        batchId = stMedia.getLinkId();
                    } else {
                        batchId = stMedia.getBatchId();
                    }
                    if (next.getBatchInfo().getLinkId() == batchId) {
                        List<CommonStMedia> j3 = next.getBatchInfo().j();
                        if (!j3.isEmpty()) {
                            Iterator<CommonStMedia> it6 = j3.iterator();
                            while (true) {
                                if (!it6.hasNext()) {
                                    break;
                                }
                                if (C(i3, it6.next())) {
                                    it6.remove();
                                    if (next.getBatchInfo().j().size() == 0) {
                                        this.allBatch.remove(next);
                                    }
                                    next.getBatchInfo().z(r0.getUploadNumber() - 1);
                                    z16 = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return z16;
    }

    private final void G(String albumId, com.qzone.reborn.albumx.common.bean.b repoBean) {
        List<b> list;
        if ((albumId == null || albumId.length() == 0) || !this.listenerMap.containsKey(albumId) || (list = this.listenerMap.get(albumId)) == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(repoBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(PAGetPhotoListRsp pAGetPhotoListRsp, k this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QZAlbumxDetailRepo", 1, "requestGetAlbumBatchList response traceId : " + pAGetPhotoListRsp.traceId + " ");
        MediaListInfo mediaListInfo = new MediaListInfo("", pAGetPhotoListRsp.attachInfo, false, pAGetPhotoListRsp.hasMore, pAGetPhotoListRsp.curIndex);
        int i3 = pAGetPhotoListRsp.result;
        String str = pAGetPhotoListRsp.errMs;
        Intrinsics.checkNotNullExpressionValue(str, "response.errMs");
        AlbumInfo albumInfo = pAGetPhotoListRsp.albumInfo;
        Intrinsics.checkNotNullExpressionValue(albumInfo, "response.albumInfo");
        ArrayList<BatchInfo> arrayList = pAGetPhotoListRsp.batchList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "response.batchList");
        ArrayList<StMedia> arrayList2 = pAGetPhotoListRsp.medias;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "response.medias");
        ArrayList<Integer> arrayList3 = pAGetPhotoListRsp.opmask;
        Intrinsics.checkNotNullExpressionValue(arrayList3, "response.opmask");
        MediaLbsAreaList mediaLbsAreaList = pAGetPhotoListRsp.mediaLbsAreaList;
        Intrinsics.checkNotNullExpressionValue(mediaLbsAreaList, "response.mediaLbsAreaList");
        String str2 = pAGetPhotoListRsp.traceId;
        Intrinsics.checkNotNullExpressionValue(str2, "response.traceId");
        StTimeLine stTimeLine = pAGetPhotoListRsp.timeLine;
        Intrinsics.checkNotNullExpressionValue(stTimeLine, "response.timeLine");
        PageEndMsg pageEndMsg = pAGetPhotoListRsp.endMsg;
        Intrinsics.checkNotNullExpressionValue(pageEndMsg, "response.endMsg");
        RecommendMedia recommendMedia = pAGetPhotoListRsp.recommendMedia;
        Intrinsics.checkNotNullExpressionValue(recommendMedia, "response.recommendMedia");
        this$0.y(z16, i3, str, albumInfo, arrayList, arrayList2, mediaListInfo, arrayList3, mediaLbsAreaList, str2, stTimeLine, pageEndMsg, recommendMedia, pAGetPhotoListRsp.isFromCache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(k this$0, Object[] objArr) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (objArr == null || objArr.length != 1) {
            return;
        }
        Object obj = objArr[0];
        if (obj instanceof d.b) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.preload.QZAlbumxDetailListPreLoaderTask.RspBean");
            d.b bVar = (d.b) obj;
            if (bVar.getResponse() == null) {
                QLog.e("QZAlbumxDetailRepo", 1, "fetchAlbumBatchListDataFromPreload  rspBean.response == null");
                return;
            }
            QLog.d("QZAlbumxDetailRepo", 4, "fetchAlbumBatchListDataFromPreload run");
            PAGetPhotoListRsp response = bVar.getResponse();
            Intrinsics.checkNotNull(response);
            String str = response.attachInfo;
            PAGetPhotoListRsp response2 = bVar.getResponse();
            Intrinsics.checkNotNull(response2);
            boolean z16 = response2.hasMore;
            PAGetPhotoListRsp response3 = bVar.getResponse();
            Intrinsics.checkNotNull(response3);
            MediaListInfo mediaListInfo = new MediaListInfo("", str, false, z16, response3.curIndex);
            PAGetPhotoListRsp response4 = bVar.getResponse();
            Intrinsics.checkNotNull(response4);
            int i3 = response4.result;
            PAGetPhotoListRsp response5 = bVar.getResponse();
            Intrinsics.checkNotNull(response5);
            String str2 = response5.errMs;
            Intrinsics.checkNotNullExpressionValue(str2, "rspBean.response!!.errMs");
            PAGetPhotoListRsp response6 = bVar.getResponse();
            Intrinsics.checkNotNull(response6);
            AlbumInfo albumInfo = response6.albumInfo;
            Intrinsics.checkNotNullExpressionValue(albumInfo, "rspBean.response!!.albumInfo");
            PAGetPhotoListRsp response7 = bVar.getResponse();
            Intrinsics.checkNotNull(response7);
            ArrayList<BatchInfo> arrayList = response7.batchList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "rspBean.response!!.batchList");
            PAGetPhotoListRsp response8 = bVar.getResponse();
            Intrinsics.checkNotNull(response8);
            ArrayList<StMedia> arrayList2 = response8.medias;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "rspBean.response!!.medias");
            PAGetPhotoListRsp response9 = bVar.getResponse();
            Intrinsics.checkNotNull(response9);
            ArrayList<Integer> arrayList3 = response9.opmask;
            Intrinsics.checkNotNullExpressionValue(arrayList3, "rspBean.response!!.opmask");
            PAGetPhotoListRsp response10 = bVar.getResponse();
            Intrinsics.checkNotNull(response10);
            MediaLbsAreaList mediaLbsAreaList = response10.mediaLbsAreaList;
            Intrinsics.checkNotNullExpressionValue(mediaLbsAreaList, "rspBean.response!!.mediaLbsAreaList");
            PAGetPhotoListRsp response11 = bVar.getResponse();
            Intrinsics.checkNotNull(response11);
            String str3 = response11.traceId;
            Intrinsics.checkNotNullExpressionValue(str3, "rspBean.response!!.traceId");
            PAGetPhotoListRsp response12 = bVar.getResponse();
            Intrinsics.checkNotNull(response12);
            StTimeLine stTimeLine = response12.timeLine;
            Intrinsics.checkNotNullExpressionValue(stTimeLine, "rspBean.response!!.timeLine");
            PAGetPhotoListRsp response13 = bVar.getResponse();
            Intrinsics.checkNotNull(response13);
            PageEndMsg pageEndMsg = response13.endMsg;
            Intrinsics.checkNotNullExpressionValue(pageEndMsg, "rspBean.response!!.endMsg");
            PAGetPhotoListRsp response14 = bVar.getResponse();
            Intrinsics.checkNotNull(response14);
            RecommendMedia recommendMedia = response14.recommendMedia;
            Intrinsics.checkNotNullExpressionValue(recommendMedia, "rspBean.response!!.recommendMedia");
            PAGetPhotoListRsp response15 = bVar.getResponse();
            Intrinsics.checkNotNull(response15);
            this$0.y(false, i3, str2, albumInfo, arrayList, arrayList2, mediaListInfo, arrayList3, mediaLbsAreaList, str3, stTimeLine, pageEndMsg, recommendMedia, response15.isFromCache);
        }
    }

    public final void L(final boolean isLoadMore, Integer sortType) {
        if (!isLoadMore) {
            S();
        }
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = this.initBean;
        if (qZAlbumxAlbumDetailInitBean != null) {
            Intrinsics.checkNotNull(qZAlbumxAlbumDetailInitBean);
            if (TextUtils.isEmpty(qZAlbumxAlbumDetailInitBean.getAlbumId())) {
                return;
            }
            String stringAttachInfo = this.loadInfo.getStringAttachInfo();
            QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean2 = this.initBean;
            long currentTimeMillis = System.currentTimeMillis();
            QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean3 = this.initBean;
            Intrinsics.checkNotNull(qZAlbumxAlbumDetailInitBean3);
            QLog.d("QZAlbumxDetailRepo", 1, "requestGetAlbumBatchList  attachInfo : " + stringAttachInfo + " | isLoadMore : " + isLoadMore + " | initBean : " + qZAlbumxAlbumDetailInitBean2 + " cost time: " + (currentTimeMillis - qZAlbumxAlbumDetailInitBean3.getLaunchTime()) + " |sortType:" + sortType);
            this.sortType = sortType;
            if (!isLoadMore) {
                QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean4 = this.initBean;
                if (i(qZAlbumxAlbumDetailInitBean4 != null ? qZAlbumxAlbumDetailInitBean4.getAlbumId() : null)) {
                    return;
                }
            }
            if (isLoadMore && B()) {
                return;
            }
            this.loadInfo.setCurrentState(isLoadMore ? 3 : 2);
            QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean5 = this.initBean;
            if (qZAlbumxAlbumDetailInitBean5 != null) {
                final long currentTimeMillis2 = System.currentTimeMillis();
                v(qZAlbumxAlbumDetailInitBean5.getUin(), qZAlbumxAlbumDetailInitBean5.getAlbumId(), "", this.loadInfo.getStringAttachInfo(), sortType, new IPersonalAlbumServiceGetPhotoListCallback() { // from class: ub.e
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetPhotoListCallback
                    public final void onGetPhotoList(PAGetPhotoListRsp pAGetPhotoListRsp) {
                        k.M(currentTimeMillis2, this, isLoadMore, pAGetPhotoListRsp);
                    }
                });
            }
        }
    }

    private final boolean i(String albumId) {
        if (albumId == null || albumId.length() == 0) {
            QLog.e("QZAlbumxDetailRepo", 1, "canFetchDataFromPreloadTask albumId is null");
            return false;
        }
        if (!PreLoader.exists("qzone_albumx_detail_album_list_data_preload_id")) {
            return false;
        }
        QLog.d("QZAlbumxDetailRepo", 1, "canFetchDataFromPreloadTask from preload task");
        l(albumId);
        return true;
    }
}
