package xo4;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.temp.api.ITroopGuildAIOApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u001b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0010"}, d2 = {"Lxo4/c;", "Lxo4/b;", "", "I", "", "troopUin", "", "H", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "appInterface", "Landroid/content/Context;", "ctx", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", BdhLogUtil.LogTag.Tag_Req, "a", "troop-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class c extends b {
    public c(@Nullable BaseQQAppInterface baseQQAppInterface, @Nullable Context context) {
        super(baseQQAppInterface, context);
    }

    @Override // xo4.b
    public boolean H(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return Intrinsics.areEqual(troopUin, f("group_code"));
    }

    @Override // xo4.b
    public void I() {
        Bundle bundle = new Bundle();
        String f16 = f("guild_id");
        String f17 = f("channel_id");
        String createId = f(AlbumCacheData.CREATE_TIME);
        String f18 = f(INetChannelCallback.KEY_TINY_ID);
        String f19 = f("feed_id");
        String f26 = f(WSAutoShowCommentParams.KEY_COMMENT_ID);
        String f27 = f(WSAutoShowCommentParams.KEY_REPLY_ID);
        String position = f("position");
        QLog.i("TroopGuildFeedDetailAction", 1, "TroopGuildFeedDetailAction guildId: " + f16 + " channelId: " + f17 + " createId: " + createId + " tinyId: " + f18 + " feedId: " + f19);
        if (!TextUtils.isEmpty(f16) && !TextUtils.isEmpty(f17) && !TextUtils.isEmpty(createId) && !TextUtils.isEmpty(f18) && !TextUtils.isEmpty(f19)) {
            bundle.putString("feedId", f19);
            bundle.putString("guildId", f16);
            bundle.putString("channelId", f17);
            Intrinsics.checkNotNullExpressionValue(createId, "createId");
            bundle.putLong(WadlProxyConsts.CREATE_TIME, Long.parseLong(createId));
            bundle.putString("posterTinyId", f18);
            bundle.putString(WSAutoShowCommentParams.KEY_REPLY_ID, f27);
            bundle.putString(WSAutoShowCommentParams.KEY_COMMENT_ID, f26);
            if (!TextUtils.isEmpty(position)) {
                Intrinsics.checkNotNullExpressionValue(position, "position");
                bundle.putInt("position", Integer.parseInt(position));
            }
            bundle.putInt("businessType", 7);
            QRouteApi api = QRoute.api(IGuildFeedLauncherApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IGuildFeedLauncherApi::class.java)");
            IGuildFeedLauncherApi.a.a((IGuildFeedLauncherApi) api, this.f307437b, bundle, false, 4, null);
            if (f.INSTANCE.a(this)) {
                ITroopGuildAIOApi iTroopGuildAIOApi = (ITroopGuildAIOApi) QRoute.api(ITroopGuildAIOApi.class);
                Context context = this.f307437b;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                String f28 = f("group_code");
                Intrinsics.checkNotNullExpressionValue(f28, "getAttribute(TroopGuildJ\u2026stant.URI_KEY_GROUP_CODE)");
                iTroopGuildAIOApi.jumpToTroopFeedList(context, f28);
            }
        }
    }
}
