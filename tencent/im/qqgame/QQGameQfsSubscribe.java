package tencent.im.qqgame;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;
import com.vivo.push.PushClientConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameQfsSubscribe {
    public static final int STATUS_DOUBLE_SUBSCRIBED = 1995001;
    public static final int SUBSCRIBE_STATUS_DEFAULT = 0;
    public static final int SUBSCRIBE_STATUS_GAME_ONLINE = 3;
    public static final int SUBSCRIBE_STATUS_SUBSCRIBED = 2;
    public static final int SUBSCRIBE_STATUS_WAIT_SUBSCRIBE = 1;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class DownloadInfo extends MessageMicro<DownloadInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 58, 66}, new String[]{"versionCode", VirtualAppProxy.KEY_PKG_SIZE, "iosDownloadUrl", "androidDownloadUrl", "tickets", "encryptValue", PushClientConstants.TAG_PKG_NAME, "min_update_version"}, new Object[]{"", 0L, "", "", "", "", "", ""}, DownloadInfo.class);
        public final PBStringField versionCode = PBField.initString("");
        public final PBInt64Field pkgSize = PBField.initInt64(0);
        public final PBStringField iosDownloadUrl = PBField.initString("");
        public final PBStringField androidDownloadUrl = PBField.initString("");
        public final PBStringField tickets = PBField.initString("");
        public final PBStringField encryptValue = PBField.initString("");
        public final PBStringField pkgName = PBField.initString("");
        public final PBStringField min_update_version = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class GameInfo extends MessageMicro<GameInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"appID", "gameIcon", "slogan", "appName", "gameAuthor", "versionName", "permissions", "privacyGuidePic"}, new Object[]{"", "", "", "", "", "", "", ""}, GameInfo.class);
        public final PBStringField appID = PBField.initString("");
        public final PBStringField gameIcon = PBField.initString("");
        public final PBStringField slogan = PBField.initString("");
        public final PBStringField appName = PBField.initString("");
        public final PBStringField gameAuthor = PBField.initString("");
        public final PBStringField versionName = PBField.initString("");
        public final PBStringField permissions = PBField.initString("");
        public final PBStringField privacyGuidePic = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class GameSummary extends MessageMicro<GameSummary> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50}, new String[]{"game_id", CrashRtInfoHolder.BeaconKey.GAME_NAME, "game_icon", "game_download_total", "game_recommend_text", "package_name"}, new Object[]{"", "", "", 0, "", ""}, GameSummary.class);
        public final PBStringField game_id = PBField.initString("");
        public final PBStringField game_name = PBField.initString("");
        public final PBStringField game_icon = PBField.initString("");
        public final PBInt32Field game_download_total = PBField.initInt32(0);
        public final PBStringField game_recommend_text = PBField.initString("");
        public final PBStringField package_name = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class GetGameListReq extends MessageMicro<GetGameListReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"game_id"}, new Object[]{""}, GetGameListReq.class);
        public final PBStringField game_id = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class GetGameListRsp extends MessageMicro<GetGameListRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"summary"}, new Object[]{null}, GetGameListRsp.class);
        public final PBRepeatMessageField<GameSummary> summary = PBField.initRepeatMessage(GameSummary.class);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class GetInstallationReminderReq extends MessageMicro<GetInstallationReminderReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"app_id", "phone_model"}, new Object[]{"", ""}, GetInstallationReminderReq.class);
        public final PBStringField app_id = PBField.initString("");
        public final PBStringField phone_model = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class GetInstallationReminderRsp extends MessageMicro<GetInstallationReminderRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_support_phone_model"}, new Object[]{Boolean.FALSE}, GetInstallationReminderRsp.class);
        public final PBBoolField is_support_phone_model = PBField.initBool(false);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class GetUserGameStatusReq extends MessageMicro<GetUserGameStatusReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42}, new String[]{"appID", "uin", TtmlNode.TAG_TT, "needGameInfo", "channelID"}, new Object[]{"", 0L, 0, Boolean.FALSE, ""}, GetUserGameStatusReq.class);
        public final PBStringField appID = PBField.initString("");
        public final PBInt64Field uin = PBField.initInt64(0);

        /* renamed from: tt, reason: collision with root package name */
        public final PBInt32Field f436040tt = PBField.initInt32(0);
        public final PBBoolField needGameInfo = PBField.initBool(false);
        public final PBStringField channelID = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class GetUserGameStatusRsp extends MessageMicro<GetUserGameStatusRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{"result", "follow_result", "subscribe_info", "gameInfo", "downloadInfo"}, new Object[]{0, 0, null, null, null}, GetUserGameStatusRsp.class);
        public final PBInt32Field result = PBField.initInt32(0);
        public final PBInt32Field follow_result = PBField.initInt32(0);
        public SubscribeInfo subscribe_info = new SubscribeInfo();
        public GameInfo gameInfo = new GameInfo();
        public DownloadInfo downloadInfo = new DownloadInfo();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubscribeInfo extends MessageMicro<SubscribeInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"source", "bussinessInfo", "succTime"}, new Object[]{"", "", 0L}, SubscribeInfo.class);
        public final PBStringField source = PBField.initString("");
        public final PBStringField bussinessInfo = PBField.initString("");
        public final PBInt64Field succTime = PBField.initInt64(0);
    }

    QQGameQfsSubscribe() {
    }
}
