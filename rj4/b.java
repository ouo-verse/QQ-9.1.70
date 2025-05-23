package rj4;

import android.app.Activity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView;
import com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback;
import com.tencent.mobileqq.qqlive.data.QQLiveEndPageInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.EndPageRealTimeInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.MetricsType;
import com.tencent.mobileqq.qqlive.data.room.realtime.RealTimeData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J:\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a8\u0006\u0013"}, d2 = {"Lrj4/b;", "", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveSDK;", "liveSdk", "Lcom/tencent/mobileqq/qqlive/data/anchor/room/QQLiveAnchorRoomInfo;", "anchorRoomInfo", "Lcom/tencent/mobileqq/qqlive/data/room/realtime/EndPageRealTimeInfo;", "realTimeInfo", "Lcom/tencent/mobileqq/qqlive/data/QQLiveEndPageInfo;", "b", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "liveRealTimeInfo", "Lcom/tencent/mobileqq/qqlive/callback/EndLiveClickCallback;", "callback", "Lcom/tencent/mobileqq/qqlive/api/end/IQQLiveEndView;", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f431589a = new b();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes26.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f431590a;

        static {
            int[] iArr = new int[MetricsType.values().length];
            try {
                iArr[MetricsType.TOTAL_LIVE_TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MetricsType.GIFT_AMOUNT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MetricsType.NEW_FANS_NUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MetricsType.CUMULATIVE_UV.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MetricsType.COMMENT_NUM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MetricsType.GIFT_GIVER_NUM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MetricsType.NUM_OF_LIKE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f431590a = iArr;
        }
    }

    b() {
    }

    private final QQLiveEndPageInfo b(IQQLiveSDK liveSdk, QQLiveAnchorRoomInfo anchorRoomInfo, EndPageRealTimeInfo realTimeInfo) {
        long j3;
        String str;
        String str2;
        String str3;
        long j16;
        String str4;
        List<RealTimeData> list;
        QQLiveAnchorDataUserInfo qQLiveAnchorDataUserInfo;
        String str5;
        QQLiveAnchorDataUserInfo qQLiveAnchorDataUserInfo2;
        QQLiveAnchorDataUserInfo qQLiveAnchorDataUserInfo3;
        QQLiveAnchorDataUserInfo qQLiveAnchorDataUserInfo4;
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo;
        QQLiveAnchorRoomGameInfo qQLiveAnchorRoomGameInfo;
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo2;
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo3;
        QQLiveEndPageInfo qQLiveEndPageInfo = new QQLiveEndPageInfo();
        long j17 = 0;
        if (anchorRoomInfo != null && (qQLiveAnchorDataRoomInfo3 = anchorRoomInfo.roomData) != null) {
            j3 = qQLiveAnchorDataRoomInfo3.getRoomId();
        } else {
            j3 = 0;
        }
        qQLiveEndPageInfo.roomId = j3;
        String str6 = "";
        if (anchorRoomInfo == null || (qQLiveAnchorDataRoomInfo2 = anchorRoomInfo.roomData) == null || (str = qQLiveAnchorDataRoomInfo2.programId) == null) {
            str = "";
        }
        qQLiveEndPageInfo.programId = str;
        qQLiveEndPageInfo.liveType = 0;
        if (anchorRoomInfo == null || (qQLiveAnchorDataRoomInfo = anchorRoomInfo.roomData) == null || (qQLiveAnchorRoomGameInfo = qQLiveAnchorDataRoomInfo.gameInfo) == null || (str2 = Integer.valueOf(qQLiveAnchorRoomGameInfo.f271211id).toString()) == null) {
            str2 = "";
        }
        qQLiveEndPageInfo.liveContent = str2;
        if (liveSdk == null || (str3 = liveSdk.getAppId()) == null) {
            str3 = "";
        }
        qQLiveEndPageInfo.liveSource = str3;
        if (anchorRoomInfo != null && (qQLiveAnchorDataUserInfo4 = anchorRoomInfo.userDta) != null) {
            j16 = qQLiveAnchorDataUserInfo4.f271213id;
        } else {
            j16 = 0;
        }
        qQLiveEndPageInfo.uid = j16;
        if (anchorRoomInfo != null && (qQLiveAnchorDataUserInfo3 = anchorRoomInfo.userDta) != null) {
            j17 = qQLiveAnchorDataUserInfo3.f271213id;
        }
        qQLiveEndPageInfo.anchorUid = j17;
        if (anchorRoomInfo == null || (qQLiveAnchorDataUserInfo2 = anchorRoomInfo.userDta) == null || (str4 = qQLiveAnchorDataUserInfo2.avatarUrl) == null) {
            str4 = "";
        }
        qQLiveEndPageInfo.headIcon = str4;
        if (anchorRoomInfo != null && (qQLiveAnchorDataUserInfo = anchorRoomInfo.userDta) != null && (str5 = qQLiveAnchorDataUserInfo.nickName) != null) {
            str6 = str5;
        }
        qQLiveEndPageInfo.nick = str6;
        if (realTimeInfo != null && (list = realTimeInfo.items) != null) {
            for (RealTimeData realTimeData : list) {
                MetricsType type = realTimeData.type;
                if (type != null) {
                    Intrinsics.checkNotNullExpressionValue(type, "type");
                    switch (a.f431590a[type.ordinal()]) {
                        case 1:
                            qQLiveEndPageInfo.time = realTimeData.value;
                            break;
                        case 2:
                            qQLiveEndPageInfo.giftValue = realTimeData.value;
                            break;
                        case 3:
                            qQLiveEndPageInfo.newFans = realTimeData.value;
                            break;
                        case 4:
                            qQLiveEndPageInfo.popularity = String.valueOf(realTimeData.value);
                            break;
                        case 5:
                            qQLiveEndPageInfo.commentNum = realTimeData.value;
                            break;
                        case 6:
                            qQLiveEndPageInfo.sendGiftPopularity = realTimeData.value;
                            break;
                        case 7:
                            qQLiveEndPageInfo.praiseNum = realTimeData.value;
                            break;
                    }
                }
            }
        }
        qQLiveEndPageInfo.follow = 0;
        return qQLiveEndPageInfo;
    }

    @Nullable
    public final IQQLiveEndView a(@Nullable Activity activity, @Nullable IQQLiveSDK liveSdk, @Nullable QQLiveAnchorRoomInfo anchorRoomInfo, @Nullable EndPageRealTimeInfo liveRealTimeInfo, @Nullable EndLiveClickCallback callback) {
        QBaseActivity qBaseActivity;
        QQLiveEndPageInfo b16;
        if (activity instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) activity;
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity == null || liveSdk == null || (b16 = b(liveSdk, anchorRoomInfo, liveRealTimeInfo)) == null) {
            return null;
        }
        return ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).getAnchorEndLiveView((QBaseActivity) activity, b16, callback);
    }
}
