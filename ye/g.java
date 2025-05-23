package ye;

import NS_MOBILE_FEEDS.cell_comm;
import NS_MOBILE_FEEDS.cell_original;
import android.os.SystemClock;
import com.qzone.personalize.business.FeedSkinData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellActiveAdv;
import com.qzone.proxy.feedcomponent.model.CellAttitude;
import com.qzone.proxy.feedcomponent.model.CellCommentEssence;
import com.qzone.proxy.feedcomponent.model.CellCount;
import com.qzone.proxy.feedcomponent.model.CellDIYData;
import com.qzone.proxy.feedcomponent.model.CellDiss;
import com.qzone.proxy.feedcomponent.model.CellFeedSignature;
import com.qzone.proxy.feedcomponent.model.CellFunctionGuide;
import com.qzone.proxy.feedcomponent.model.CellHighFiveInfo;
import com.qzone.proxy.feedcomponent.model.CellInterestingMessageEmotion;
import com.qzone.proxy.feedcomponent.model.CellOperationRegion;
import com.qzone.proxy.feedcomponent.model.CellRank;
import com.qzone.proxy.feedcomponent.model.CellRecommAction;
import com.qzone.proxy.feedcomponent.model.CellRecommItem;
import com.qzone.proxy.feedcomponent.model.CellUpperBanner;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J2\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nH\u0002J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J2\u0010\u0010\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nH\u0002J\u0006\u0010\u0012\u001a\u00020\u0011J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0014\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ0\u0010\u0015\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nR\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lye/g;", "", "Lye/a;", "cellParser", "", tl.h.F, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "Lcom/qzone/proxy/feedcomponent/model/l;", "jceData", "", "", "", "singleFeedDataMap", "c", "b", "d", "", "f", "a", "e", "g", "", "Ljava/util/List;", "parserList", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f450213a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final List<a> parserList;

    static {
        g gVar = new g();
        f450213a = gVar;
        parserList = new ArrayList();
        gVar.h(new k());
        gVar.h(new bg());
        gVar.h(new aa());
        gVar.h(new d());
        gVar.h(new p());
        gVar.h(new ad());
        gVar.h(new l());
        gVar.h(new i());
        gVar.h(new h());
        gVar.h(new am());
        gVar.h(new al());
        gVar.h(new ai());
        gVar.h(new bh());
        gVar.h(new ae());
        gVar.h(new ax());
        gVar.h(new ak());
        gVar.h(new ac());
        gVar.h(new w());
        gVar.h(new aj());
        gVar.h(new bk());
        gVar.h(new aw());
        gVar.h(new ap());
        gVar.h(new at());
        gVar.h(new ar());
        gVar.h(new bc());
        gVar.h(new z());
        gVar.h(new n());
        gVar.h(new q());
        gVar.h(new az());
        gVar.h(new bd());
        gVar.h(new x());
        gVar.h(new ay());
        gVar.h(new bb());
        gVar.h(new as());
        gVar.h(new ag());
        gVar.h(new af());
        gVar.h(new ab());
        gVar.h(new av());
        gVar.h(new u());
        gVar.h(new b());
        gVar.h(new m());
        gVar.h(new bj());
        gVar.h(new o());
        gVar.h(new y());
        gVar.h(new e());
        gVar.h(new t());
        gVar.h(new f());
        gVar.h(new s());
        gVar.h(new r());
        gVar.h(new aq());
        gVar.h(new bi());
        gVar.h(new ba());
        gVar.h(new ao());
        gVar.h(new c());
        gVar.h(new au());
        gVar.h(new bf());
        gVar.h(new an());
        gVar.h(new j());
        gVar.h(new be());
        gVar.h(new ah());
        gVar.h(new v());
    }

    g() {
    }

    private final void c(BusinessFeedData feedData, com.qzone.proxy.feedcomponent.model.l jceData, Map<Integer, byte[]> singleFeedDataMap) {
        for (a aVar : parserList) {
            if (feedData != null && jceData != null) {
                try {
                    if (aVar.d(singleFeedDataMap)) {
                        aVar.b(feedData, jceData);
                    }
                } catch (Throwable th5) {
                    xe.b.f447841a.d(th5);
                    if (aVar.c()) {
                        feedData.shouldHide = true;
                    }
                }
            }
        }
    }

    private final void h(a cellParser) {
        parserList.add(cellParser);
    }

    public final void a(BusinessFeedData feedData, com.qzone.proxy.feedcomponent.model.l jceData) {
        for (a aVar : parserList) {
            if (feedData != null && jceData != null) {
                try {
                    aVar.b(feedData, jceData);
                } catch (Throwable th5) {
                    xe.b.f447841a.d(th5);
                    if (aVar.c()) {
                        feedData.shouldHide = true;
                    }
                }
            }
        }
    }

    public final boolean f() {
        return com.qzone.reborn.configx.g.f53821a.b().w();
    }

    public final void e(BusinessFeedData feedData, com.qzone.proxy.feedcomponent.model.l jceData) {
        if (feedData == null || jceData == null) {
            return;
        }
        a(feedData, jceData);
        try {
            b(feedData, jceData);
        } catch (Throwable th5) {
            xe.b.f447841a.d(th5);
        }
    }

    private final void b(BusinessFeedData feedData, com.qzone.proxy.feedcomponent.model.l jceData) {
        Map<String, String> map;
        Map<String, String> map2;
        String str;
        if (feedData == null || jceData == null) {
            return;
        }
        feedData.cellFeedSkinInfo = FeedSkinData.create(jceData);
        feedData.cellCommentEssence = CellCommentEssence.create(jceData);
        cell_original cell_originalVar = jceData.f50370p;
        if (cell_originalVar != null) {
            feedData.isOriginalEmpty = false;
            feedData.isForwardFeedData = true;
            BusinessFeedData createFrom = BusinessFeedData.createFrom(cell_originalVar.original_data);
            cell_comm cell_commVar = jceData.f50340a;
            if (cell_commVar != null && (map2 = cell_commVar.extendInfo) != null && (str = map2.get("is_feeds_long_pics_browsing_mode")) != null && Intrinsics.areEqual(str, "1") && createFrom.getPictureInfo() != null && createFrom.getPictureInfo().pics != null && createFrom.getPictureInfo().pics.size() != 0) {
                createFrom.getPictureInfo().pics.get(0).fakeLongPic = 1;
            }
            feedData.cellOriginalInfo = createFrom;
            createFrom.isForwardFeedData = true;
        }
        feedData.cellActiveAdv = CellActiveAdv.create(jceData);
        feedData.cellInterestingMessageEmotion = CellInterestingMessageEmotion.create(jceData);
        feedData.cellRecommItem = CellRecommItem.create(jceData);
        feedData.cellCount = CellCount.create(jceData);
        feedData.cellRank = CellRank.create(jceData);
        feedData.cellFunctionGuide = CellFunctionGuide.create(jceData);
        feedData.cellHighFiveInfo = CellHighFiveInfo.create(jceData);
        if (feedData.isDynamicAlbumFeed() && feedData.getOriginalInfo() != null) {
            feedData.getOriginalInfo().setCellDynamicAlbum(feedData.getCellDynamicAlbum());
        }
        CellRecommAction cellRecommAction = feedData.cellRecommAction;
        if (cellRecommAction != null && cellRecommAction.countDownTimer > 0) {
            feedData.adPullTimeForCountDown = SystemClock.elapsedRealtime();
        }
        feedData.cellDiss = CellDiss.create(jceData);
        feedData.cellAttitude = CellAttitude.create(jceData);
        feedData.cellUpperBanner = CellUpperBanner.create(jceData);
        feedData.cellOperationRegion = CellOperationRegion.create(jceData);
        CellUserInfo cellUserInfo = feedData.cellUserInfo;
        if (cellUserInfo != null && cellUserInfo.getUser() != null) {
            feedData.cellDIYData = CellDIYData.create(jceData, feedData.cellUserInfo.getUser().uin);
        }
        feedData.cellFeedSignature = CellFeedSignature.create(jceData);
        feedData.cellFeedSkinInfo = BusinessFeedData.mergeNewCardData(feedData.cellDecorateInfo, feedData.cellFeedSkinInfo, feedData.cellUserInfo);
        BusinessFeedData.mergeGiftData(feedData.cellDecorateInfo, feedData.cellPictureInfo);
        BusinessFeedData.mergeHighFiveData(feedData.cellSummary, feedData.cellHighFiveInfo);
        cell_comm cell_commVar2 = jceData.f50340a;
        if (cell_commVar2 == null || (map = cell_commVar2.extendInfo) == null) {
            return;
        }
        feedData.mIsFriendPlayingRecomm = Intrinsics.areEqual("2133_1157", map.get("_qboss_patternid"));
    }

    public final void g(BusinessFeedData feedData, com.qzone.proxy.feedcomponent.model.l jceData, Map<Integer, byte[]> singleFeedDataMap) {
        if (feedData == null || jceData == null) {
            return;
        }
        feedData.hasCalculate = false;
        c(feedData, jceData, singleFeedDataMap);
        try {
            d(feedData, jceData, singleFeedDataMap);
        } catch (Throwable th5) {
            xe.b.f447841a.d(th5);
        }
    }

    private final void d(BusinessFeedData feedData, com.qzone.proxy.feedcomponent.model.l jceData, Map<Integer, byte[]> singleFeedDataMap) {
        CellDIYData create;
        if (feedData == null || jceData == null || singleFeedDataMap == null) {
            return;
        }
        if (feedData.isContainsCellKey(singleFeedDataMap, 67)) {
            CellUserInfo cellUserInfo = feedData.cellUserInfo;
            if (cellUserInfo != null) {
                User user = cellUserInfo.getUser();
                Intrinsics.checkNotNullExpressionValue(user, "feedData.cellUserInfo.getUser()");
                com.qzone.proxy.feedcomponent.util.e.c(jceData, user);
            }
            FeedSkinData feedSkinData = feedData.cellFeedSkinInfo;
            if (feedSkinData != null) {
                feedSkinData.update(jceData);
            } else {
                feedData.cellFeedSkinInfo = FeedSkinData.create(jceData);
            }
            CellFeedSignature cellFeedSignature = feedData.cellFeedSignature;
            if (cellFeedSignature != null) {
                cellFeedSignature.update(jceData);
            } else {
                feedData.cellFeedSignature = CellFeedSignature.create(jceData);
            }
            CellUserInfo cellUserInfo2 = feedData.cellUserInfo;
            if (cellUserInfo2 != null && cellUserInfo2.getUser() != null && (create = CellDIYData.create(jceData, feedData.owner_uin)) != null) {
                feedData.cellDIYData = create;
            }
        }
        if (feedData.isContainsCellKey(singleFeedDataMap, 14)) {
            feedData.isOriginalEmpty = false;
            if (feedData.cellOriginalInfo == null) {
                feedData.cellOriginalInfo = new BusinessFeedData();
            }
            cell_original cell_originalVar = jceData.f50370p;
            if (cell_originalVar != null) {
                Map<Integer, byte[]> map = cell_originalVar.original_data;
                g(feedData.cellOriginalInfo, new com.qzone.proxy.feedcomponent.model.l(map), map);
            }
            feedData.isForwardFeedData = true;
            feedData.cellOriginalInfo.isForwardFeedData = true;
        }
        if (feedData.isTravelAlbumFeed() && feedData.getLbsInfoV2() != null) {
            feedData.getLbsInfoV2().showlbs = false;
        }
        if (feedData.isDynamicAlbumFeed() && feedData.getOriginalInfo() != null) {
            feedData.getOriginalInfo().setCellDynamicAlbum(feedData.getCellDynamicAlbum());
        }
        if (feedData.cellShareCard != null && feedData.cellLeftThumb != null) {
            feedData.cellLeftThumb = null;
        }
        if (feedData.isContainsCellKey(singleFeedDataMap, 57) || feedData.isContainsCellKey(singleFeedDataMap, 67)) {
            feedData.cellHighFiveInfo = feedData.cellHighFiveInfo.updateData(jceData);
        }
        feedData.cellFeedSkinInfo = BusinessFeedData.mergeNewCardData(feedData.cellDecorateInfo, feedData.cellFeedSkinInfo, feedData.cellUserInfo);
        BusinessFeedData.mergeGiftData(feedData.cellDecorateInfo, feedData.cellPictureInfo);
        BusinessFeedData.mergeHighFiveData(feedData.cellSummary, feedData.cellHighFiveInfo);
    }
}
