package yb0;

import com.tencent.biz.qqcircle.immersive.feed.live.od.a;
import com.tencent.biz.qqcircle.immersive.feed.live.w;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.liveroom.impl.room.share.timishare.TgLiveShareParam;
import com.tencent.timi.game.liveroom.impl.room.share.timishare.TgShareParam;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "Le30/b;", "feedBlockData", "Lcom/tencent/timi/game/liveroom/impl/room/share/timishare/TgShareParam;", "a", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class a {
    @NotNull
    public static final TgShareParam a(@NotNull FeedCloudMeta$StFeed feed, @NotNull e30.b feedBlockData) {
        a.C0883a d16;
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(feedBlockData, "feedBlockData");
        TgLiveShareParam tgLiveShareParam = new TgLiveShareParam();
        tgLiveShareParam.roomId = o40.a.b(feed);
        tgLiveShareParam.liveProductType = QQLiveSDKConfigHelper.getSupportProductType();
        String str = feed.poster.thirdId.get();
        Intrinsics.checkNotNullExpressionValue(str, "feed.poster.thirdId.get()");
        tgLiveShareParam.anchorUid = Long.parseLong(str);
        tgLiveShareParam.anchorAvatarUrl = feed.poster.icon.iconUrl.get();
        tgLiveShareParam.anchorNick = feed.poster.nick.get();
        tgLiveShareParam.roomCoverUrl = o40.a.a(feed);
        tgLiveShareParam.roomTitle = feed.live.room.roomTitle.get();
        if (com.tencent.biz.qqcircle.immersive.adapter.n.g(feed) == 2 && (d16 = w.d(w.c(feedBlockData))) != null) {
            tgLiveShareParam.anchorAvatarUrl = d16.f86334c;
            tgLiveShareParam.anchorNick = d16.f86335d;
        }
        tgLiveShareParam.roomType = String.valueOf(o40.a.c(feed));
        tgLiveShareParam.videoSource = QQLiveSDKConfigHelper.getQQLiveAppId();
        TgShareParam tgShareParam = new TgShareParam();
        tgShareParam.tgLiveShareParam = tgLiveShareParam;
        tgShareParam.shareAppName = "QQ\u76f4\u64ad";
        tgShareParam.simpleTitle = tgLiveShareParam.anchorNick;
        tgShareParam.mainName = tgLiveShareParam.roomTitle;
        tgShareParam.originSummary = tgLiveShareParam.getShareSummary();
        tgShareParam.singleSummaryOnly = tgShareParam.tgLiveShareParam.getShareSingleOnlySummary();
        tgShareParam.coverImgUrl = tgShareParam.tgLiveShareParam.roomCoverUrl;
        QLog.i("QCircleLiveShareUtil", 1, "share param: " + tgShareParam);
        return tgShareParam;
    }
}
