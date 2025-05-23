package tencent.im.oidb.cmd0x858;

import com.tencent.mobileqq.gamecenter.api.impl.GameCenterCommonApiImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.apollo_game_status$STCMGameMessage;
import tencent.im.apollo_push_msgInfo$STPushMsgElem;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x858$NotifyMsgBody extends MessageMicro<oidb_0x858$NotifyMsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 66, 74, 82}, new String[]{"opt_enum_type", "opt_uint64_msg_time", "opt_uint64_msg_expires", "opt_uint64_conf_uin", "opt_msg_redtips", "opt_msg_recall_reminder", "opt_msg_obj_update", "opt_stcm_game_state", "apllo_msg_push", "opt_msg_goldtips"}, new Object[]{5, 0L, 0L, 0L, null, null, null, null, null, null}, oidb_0x858$NotifyMsgBody.class);
    public final PBEnumField opt_enum_type = PBField.initEnum(5);
    public final PBUInt64Field opt_uint64_msg_time = PBField.initUInt64(0);
    public final PBUInt64Field opt_uint64_msg_expires = PBField.initUInt64(0);
    public final PBUInt64Field opt_uint64_conf_uin = PBField.initUInt64(0);
    public oidb_0x858$RedGrayTipsInfo opt_msg_redtips = new oidb_0x858$RedGrayTipsInfo();
    public oidb_0x858$MessageRecallReminder opt_msg_recall_reminder = new oidb_0x858$MessageRecallReminder();
    public oidb_0x858$NotifyObjmsgUpdate opt_msg_obj_update = new oidb_0x858$NotifyObjmsgUpdate();
    public apollo_game_status$STCMGameMessage opt_stcm_game_state = new apollo_game_status$STCMGameMessage();
    public apollo_push_msgInfo$STPushMsgElem apllo_msg_push = new MessageMicro<apollo_push_msgInfo$STPushMsgElem>() { // from class: tencent.im.apollo_push_msgInfo$STPushMsgElem
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 90, 98, 106, 114}, new String[]{"type", "showPlace", "priority", "pm1", "pm2", "pm3", "pm4"}, new Object[]{0, 0, 0, null, null, null, null}, apollo_push_msgInfo$STPushMsgElem.class);
        public final PBInt32Field type = PBField.initInt32(0);
        public final PBUInt32Field showPlace = PBField.initUInt32(0);
        public final PBInt32Field priority = PBField.initInt32(0);

        /* renamed from: pm1, reason: collision with root package name */
        public STPushMsgElem0x1 f435931pm1 = new STPushMsgElem0x1();

        /* renamed from: pm2, reason: collision with root package name */
        public STPushMsgElem0x2 f435932pm2 = new STPushMsgElem0x2();

        /* renamed from: pm3, reason: collision with root package name */
        public final PBRepeatMessageField<STPushMsgElem0x3> f435933pm3 = PBField.initRepeatMessage(STPushMsgElem0x3.class);

        /* renamed from: pm4, reason: collision with root package name */
        public final PBRepeatMessageField<STPushMsgElem0x4> f435934pm4 = PBField.initRepeatMessage(STPushMsgElem0x4.class);

        /* loaded from: classes29.dex */
        public static final class STPushMsgElem0x1 extends MessageMicro<STPushMsgElem0x1> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66}, new String[]{"actionId", "actionType", "sendUin", "rcvUin", "aioType", "sessionId", "wordType", "diyWords"}, new Object[]{0, 0, 0L, 0L, 0, 0L, 0, ""}, STPushMsgElem0x1.class);
            public final PBInt32Field actionId = PBField.initInt32(0);
            public final PBInt32Field actionType = PBField.initInt32(0);
            public final PBUInt64Field sendUin = PBField.initUInt64(0);
            public final PBUInt64Field rcvUin = PBField.initUInt64(0);
            public final PBInt32Field aioType = PBField.initInt32(0);
            public final PBUInt64Field sessionId = PBField.initUInt64(0);
            public final PBInt32Field wordType = PBField.initInt32(0);
            public final PBStringField diyWords = PBField.initString("");
        }

        /* loaded from: classes29.dex */
        public static final class STPushMsgElem0x2 extends MessageMicro<STPushMsgElem0x2> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"toUin", "actionId", "endTs", "wordType", "diyWords"}, new Object[]{0L, 0, 0L, 0, ""}, STPushMsgElem0x2.class);
            public final PBUInt64Field toUin = PBField.initUInt64(0);
            public final PBInt32Field actionId = PBField.initInt32(0);
            public final PBUInt64Field endTs = PBField.initUInt64(0);
            public final PBInt32Field wordType = PBField.initInt32(0);
            public final PBStringField diyWords = PBField.initString("");
        }

        /* loaded from: classes29.dex */
        public static final class STPushMsgElem0x3 extends MessageMicro<STPushMsgElem0x3> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 66, 74, 82, 88, 98}, new String[]{"busType", "busId", "dotId", "priority", "begTs", "endTs", "wording", "url", "theme", GameCenterCommonApiImpl.KEY_ACT_ID, "spRegion", "folderIconUrl"}, new Object[]{0, 0, 0, 0, 0, 0, "", "", "", "", 0, ""}, STPushMsgElem0x3.class);
            public final PBUInt32Field busType = PBField.initUInt32(0);
            public final PBUInt32Field busId = PBField.initUInt32(0);
            public final PBUInt32Field dotId = PBField.initUInt32(0);
            public final PBUInt32Field priority = PBField.initUInt32(0);
            public final PBUInt32Field begTs = PBField.initUInt32(0);
            public final PBUInt32Field endTs = PBField.initUInt32(0);
            public final PBStringField wording = PBField.initString("");
            public final PBStringField url = PBField.initString("");
            public final PBStringField theme = PBField.initString("");
            public final PBStringField actId = PBField.initString("");
            public final PBUInt32Field spRegion = PBField.initUInt32(0);
            public final PBStringField folderIconUrl = PBField.initString("");
        }

        /* loaded from: classes29.dex */
        public static final class STPushMsgElem0x4 extends MessageMicro<STPushMsgElem0x4> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"appid", "name", "srcVer", "newVer"}, new Object[]{0, "", 0, 0}, STPushMsgElem0x4.class);
            public final PBUInt32Field appid = PBField.initUInt32(0);
            public final PBStringField name = PBField.initString("");
            public final PBUInt32Field srcVer = PBField.initUInt32(0);
            public final PBUInt32Field newVer = PBField.initUInt32(0);
        }
    };
    public oidb_0x858$GoldMsgTipsElem opt_msg_goldtips = new oidb_0x858$GoldMsgTipsElem();
}
