package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import com.tenpay.sdk.util.QWSoterConstans;
import org.apache.commons.fileupload.FileUploadBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class report {
    public static final int ACHIEVEREWARD = 2;
    public static final int ADD_FOLLOW = 9;
    public static final int AFTER_PASTER_ADV = 10;
    public static final int CLICK = 1;
    public static final int CREATOR_SHARE_ADV_QQ_LIVE = 25;
    public static final int CREATOR_SHARE_ADV_XWORLD = 21;
    public static final int DISTRIBUTE = 5;
    public static final int EFFECTIVE_EXPOSURE = 6;
    public static final int EXPOSURE = 0;
    public static final int FIRST_ADV = 11;
    public static final int GAMEBAR = 7;
    public static final int GROUP_ALBUM_RECOMMEND_ADV = 68;
    public static final int LEAVE = 3;
    public static final int MINI_APP_MINI_GAME = 11;
    public static final int NEG_FEEDBACK = 4;
    public static final int NORMAL = 0;
    public static final int OFFICIAL_ACCOUNT_ADV = 4;
    public static final int OFFICIAL_ACCOUNT_ADV_GAME = 8;
    public static final int OFFICIAL_ACCOUNT_ADV_SHOP = 9;
    public static final int OFFICIAL_ACCOUNT_ADV_VIP = 7;
    public static final int OFFICIAL_ACCOUNT_LAYER_MASK_ADV = 14;
    public static final int OFFICIAL_ACCOUNT_SPORT = 13;
    public static final int OFFICIAL_ACCOUNT_TIAN_QI = 10;
    public static final int PC_QQTAB_ADV = 18;
    public static final int PRECIP = 2;
    public static final int QIQIAOBAN_SDK = 15;
    public static final int QQ_CPS = 16;
    public static final int QQ_SHOP_ACCOUNT_WATERFALL = 29;
    public static final int QQ_SHOP_ACCOUNT_WATERFALL_FIRST = 28;
    public static final int QQ_WALLET_CPS = 17;
    public static final int QZONE_FEEDS = 0;
    public static final int QZONE_PHOTO_TAIL = 2;
    public static final int QZONE_THIRD_NONSTANDARD = 62;
    public static final int QZONE_VIDEO_LAYER = 1;
    public static final int RECOMM = 1;
    public static final int RECOMM_OMG = 6;
    public static final int REWARD_2023_SPRING_FESTIVAL = 30;
    public static final int REWARD_GIFT_ADV = 6;
    public static final int REWARD_GROUPGIFT_ADV = 12;
    public static final int REWARD_PERSONAL_ADV = 5;
    public static final int REWARD_QQSPORT_ADV = 27;
    public static final int REWARD_QZONE_THIRD_ACTIVITY = 60;
    public static final int REWARD_SUPER_SHOW = 61;
    public static final int SELF_MEDIA = 8;
    public static final int SPORT = 2;
    public static final int UNKNOWN = 0;
    public static final int VIDEO_LAYER = 3;
    public static final int VIDEO_LAYER_POP = 5;
    public static final int VIDEO_LAYER_TIPS = 4;
    public static final int WEATHER = 1;
    public static final int WEISEE_OFFICIAL_ACCOUNT = 3;
    public static final int WEISEE_OFFICIAL_ACCOUNT_WATERFALL = 24;
    public static final int X_WORLD_CREATOR_ADV = 20;
    public static final int X_WORLD_OFFICIAL_ACCOUNT_ADV = 26;
    public static final int X_WORLD_QZONE_LAYER = 22;
    public static final int X_WORLD_SHOP = 31;
    public static final int X_WORLD_TOPVIEW_ADV = 23;
    public static final int X_WORLD_VIDEO_ADV = 19;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class RetMsg extends MessageMicro<RetMsg> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret_code", "err_msg"}, new Object[]{0, ""}, RetMsg.class);
        public final PBInt32Field ret_code = PBField.initInt32(0);
        public final PBStringField err_msg = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SsoPushReportReq extends MessageMicro<SsoPushReportReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 144, 152, 160, 168, 176}, new String[]{"account_type", "platform", "qimei36", "province", JsonRuleKey.OPERATOR, "app_version", "model", "os_version", "event_code", "oper_name", "module", "action", "ext1", "ext2", "ext3", "ext4", "ext5", "ext6", "ext7", "ext8", "ext9", "ext10"}, new Object[]{0, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 0L, 0L, 0L, 0L, 0L}, SsoPushReportReq.class);
        public final PBEnumField account_type = PBField.initEnum(0);
        public final PBStringField platform = PBField.initString("");
        public final PBStringField qimei36 = PBField.initString("");
        public final PBStringField province = PBField.initString("");
        public final PBStringField operator = PBField.initString("");
        public final PBStringField app_version = PBField.initString("");
        public final PBStringField model = PBField.initString("");
        public final PBStringField os_version = PBField.initString("");
        public final PBStringField event_code = PBField.initString("");
        public final PBStringField oper_name = PBField.initString("");
        public final PBStringField module = PBField.initString("");
        public final PBStringField action = PBField.initString("");
        public final PBStringField ext1 = PBField.initString("");
        public final PBStringField ext2 = PBField.initString("");
        public final PBStringField ext3 = PBField.initString("");
        public final PBStringField ext4 = PBField.initString("");
        public final PBStringField ext5 = PBField.initString("");
        public final PBInt64Field ext6 = PBField.initInt64(0);
        public final PBInt64Field ext7 = PBField.initInt64(0);
        public final PBInt64Field ext8 = PBField.initInt64(0);
        public final PBInt64Field ext9 = PBField.initInt64(0);
        public final PBInt64Field ext10 = PBField.initInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SsoPushReportRsp extends MessageMicro<SsoPushReportRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"ret_msg"}, new Object[]{null}, SsoPushReportRsp.class);
        public RetMsg ret_msg = new RetMsg();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class UserActionReportReq extends MessageMicro<UserActionReportReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 26, 32, 40, 48, 56, 66, 74, 82, 90, 98, 104, 114}, new String[]{QWSoterConstans.CGI_KEY_BUSI_TYPE, WinkDaTongReportConstant.ElementParamKey.ADID, "adpos_type", "action_type", "action_time", "feeds_index", QAdVrReportParams.ParamKey.EXPERIMENT_ID, FileUploadBase.ATTACHMENT, "adpos_id", "trace_id", "qq_ver", "os_type", "app_id"}, new Object[]{0, "", 0, 0, 0L, 0, "", "", "", "", "", 0, ""}, UserActionReportReq.class);
        public final PBEnumField busi_type = PBField.initEnum(0);
        public final PBStringField adid = PBField.initString("");
        public final PBEnumField adpos_type = PBField.initEnum(0);
        public final PBEnumField action_type = PBField.initEnum(0);
        public final PBInt64Field action_time = PBField.initInt64(0);
        public final PBUInt32Field feeds_index = PBField.initUInt32(0);
        public final PBRepeatField<String> experiment_id = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBStringField attachment = PBField.initString("");
        public final PBStringField adpos_id = PBField.initString("");
        public final PBStringField trace_id = PBField.initString("");
        public final PBStringField qq_ver = PBField.initString("");
        public final PBUInt32Field os_type = PBField.initUInt32(0);
        public final PBStringField app_id = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class UserActionReportRsp extends MessageMicro<UserActionReportRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"ret_msg"}, new Object[]{null}, UserActionReportRsp.class);
        public RetMsg ret_msg = new RetMsg();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class UserData extends MessageMicro<UserData> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 800}, new String[]{"user_action_data", "write_time"}, new Object[]{null, 0L}, UserData.class);
        public final PBRepeatMessageField<UserActionReportReq> user_action_data = PBField.initRepeatMessage(UserActionReportReq.class);
        public final PBInt64Field write_time = PBField.initInt64(0);
    }

    report() {
    }
}
