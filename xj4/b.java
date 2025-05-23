package xj4;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qqlive.callback.userlevel.UserLevelUpgrade;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import com.tencent.mobileqq.qqlive.data.follow.FollowPushMessage;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.data.heart.QLBroadCastFreeLove;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0011H&J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0016H&J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH&J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&\u00a8\u0006\u001a"}, d2 = {"Lxj4/b;", "", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "msg", "", "D", "P", "Lcom/tencent/mobileqq/qqlive/data/announce/AnnouncePushMessage;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/qqlive/data/follow/FollowPushMessage;", "J", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$SpeakerInfo;", "audienceInfo", "G", "Lcom/tencent/mobileqq/qqlive/data/heart/QLBroadCastFreeLove;", "broadCastFreeLove", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "onGiftMessageReceive", "", "data", "K", "Lcom/tencent/mobileqq/qqlive/callback/userlevel/UserLevelUpgrade;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, UserInfo.SEX_FEMALE, "O", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface b {
    void A(@NotNull UserLevelUpgrade msg2);

    void D(@NotNull LiveMessageData msg2);

    void F(@NotNull FollowPushMessage msg2);

    void G(@NotNull LiveMessageData.SpeakerInfo audienceInfo);

    void J(@NotNull FollowPushMessage msg2);

    void K(@Nullable byte[] data);

    void O(@Nullable byte[] data);

    void P(@NotNull LiveMessageData msg2);

    void Q(@NotNull AnnouncePushMessage msg2);

    void onGiftMessageReceive(@NotNull GiftMessage msg2);

    void x(@Nullable QLBroadCastFreeLove broadCastFreeLove);
}
