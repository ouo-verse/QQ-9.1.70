package tencent.im.qqgame;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameGcSpkTaskDye {
    public static final int AUDITING_DONE = 3;
    public static final int AUDITING_ODD = 2;
    public static final int FAIL_BUDGET_NOT_ENOUTH = 101;
    public static final int FAIL_INVALID_TASK = 117;
    public static final int FAIL_LOW_QUALITY_PLAYER = 121;
    public static final int FAIL_MIZAR_BEAT = 100;
    public static final int FAIL_MP_FAILED = 112;
    public static final int FAIL_PRM_FAILED = 104;
    public static final int FAIL_REACH_DAILY_LIMIT = 102;
    public static final int FAIL_REACH_TOTAL_LIMIT = 115;
    public static final int FAIL_READCH_DEVICE_LIMIT = 118;
    public static final int FAIL_READCH_INVITE_DAILY_LIMIT = 113;
    public static final int FAIL_READCH_INVITE_TOTAL_LIMIT = 114;
    public static final int FAIL_SPK_BLACK_USER = 103;
    public static final int FAIL_SUBTASK_BUDGET_NOT_ENOUTH = 116;
    public static final int FAIL_SUBTASK_END_BUDGET_NOT_ENOUTH = 119;
    public static final int MONTHLY_REVIEWING = 5;
    public static final int NOT_EXCLUSIVE_LINK_DOWNLOAD = 106;
    public static final int NOT_NEW_GAME_PLAYER = 105;
    public static final int ONGOING_DOWNLOAD_AND_REGIESTER = 108;
    public static final int ONGOING_DOWNLOAD_NOT_REGIESTER = 107;
    public static final int ONGOING_SUBSCRIBE_NOT_REGIESTER = 120;
    public static final int REVIEWING = 4;
    public static final int TASK_AUDITING = 1;
    public static final int TASK_END_BUDGET_NOT_ENOUGH = 110;
    public static final int TASK_END_BY_ADMIN = 109;
    public static final int TASK_END_BY_ENDTS = 111;
    public static final int TASK_ONGOING = 0;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class GetDyedReq extends MessageMicro<GetDyedReq> {
        public static final int DEFAULT = 0;
        public static final int DYE_OP_DEFAULT = 0;
        public static final int DYE_OP_DOWNLOAD = 2;
        public static final int DYE_OP_INSTALL = 4;
        public static final int DYE_OP_START = 3;
        public static final int DYE_OP_SUBSCRIBE = 1;
        public static final int MIE = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50, 58, 64, 72, 80, 90, 98, 106}, new String[]{"task_key", "channel_id", "appid", "plat", "deviceID", "ticket", "rand_str", "from", QCircleSchemeAttr.CoverFeed.SOURCE_TYPE, "op", "subscribe_req", "dye_from", "mini_world_content_id"}, new Object[]{"", "", 0, 0, "", "", "", 0, 0, 0, null, "", ""}, GetDyedReq.class);
        public final PBStringField task_key = PBField.initString("");
        public final PBStringField channel_id = PBField.initString("");
        public final PBUInt32Field appid = PBField.initUInt32(0);
        public final PBInt32Field plat = PBField.initInt32(0);
        public final PBStringField deviceID = PBField.initString("");
        public final PBStringField ticket = PBField.initString("");
        public final PBStringField rand_str = PBField.initString("");
        public final PBEnumField from = PBField.initEnum(0);
        public final PBInt32Field source_type = PBField.initInt32(0);

        /* renamed from: op, reason: collision with root package name */
        public final PBEnumField f436034op = PBField.initEnum(0);
        public SubscribeReq subscribe_req = new SubscribeReq();
        public final PBStringField dye_from = PBField.initString("");
        public final PBStringField mini_world_content_id = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class GetDyedRsp extends MessageMicro<GetDyedRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg", "subscribe_rsp"}, new Object[]{"", null}, GetDyedRsp.class);

        /* renamed from: msg, reason: collision with root package name */
        public final PBStringField f436035msg = PBField.initString("");
        public SubscribeRsp subscribe_rsp = new SubscribeRsp();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubscribeReq extends MessageMicro<SubscribeReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 24, 32, 50, 58, 64, 72, 82}, new String[]{"source", "subscribeType", "needArk", "scheduleID", "oasisActID", "sendWarehouseType", "need_gift", "businessInfo"}, new Object[]{"", 0, 0, "", "", 0, 0, ""}, SubscribeReq.class);
        public final PBStringField source = PBField.initString("");
        public final PBInt32Field subscribeType = PBField.initInt32(0);
        public final PBInt32Field needArk = PBField.initInt32(0);
        public final PBStringField scheduleID = PBField.initString("");
        public final PBStringField oasisActID = PBField.initString("");
        public final PBInt32Field sendWarehouseType = PBField.initInt32(0);
        public final PBInt32Field need_gift = PBField.initInt32(0);
        public final PBStringField businessInfo = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubscribeRsp extends MessageMicro<SubscribeRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 82}, new String[]{"result", "message", "noticeID"}, new Object[]{0, "", ""}, SubscribeRsp.class);
        public final PBInt32Field result = PBField.initInt32(0);
        public final PBStringField message = PBField.initString("");
        public final PBStringField noticeID = PBField.initString("");
    }

    QQGameGcSpkTaskDye() {
    }
}
