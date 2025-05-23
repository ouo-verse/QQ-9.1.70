package trpc.qq_av.av_appsvr;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;

/* loaded from: classes29.dex */
public final class PushOnline$PushOnlineMsg extends MessageMicro<PushOnline$PushOnlineMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40}, new String[]{"to_uin", ShortVideoConstants.FROM_UIN, ILaunchTroopSysMsgUIUtilApi.KEY_PUSH_TYPE, "push_msg", "video_msg_type"}, new Object[]{0L, 0L, 0, null, 0}, PushOnline$PushOnlineMsg.class);
    public final PBRepeatField<Long> to_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field from_uin = PBField.initUInt64(0);
    public final PBEnumField push_type = PBField.initEnum(0);
    public PushOnline$PushMsg push_msg = new MessageMicro<PushOnline$PushMsg>() { // from class: trpc.qq_av.av_appsvr.PushOnline$PushMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"multi_sync_msg", "common_channel_msg"}, new Object[]{null, null}, PushOnline$PushMsg.class);
        public PushOnline$MultiTerminalSyncMsg multi_sync_msg = new MessageMicro<PushOnline$MultiTerminalSyncMsg>() { // from class: trpc.qq_av.av_appsvr.PushOnline$MultiTerminalSyncMsg
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56}, new String[]{"term_type", "opereation", "client_seq", "business_type", "relation_type", "relation_id", "av_sdk_version"}, new Object[]{0, 0, 0, 0, 0, 0L, 0}, PushOnline$MultiTerminalSyncMsg.class);
            public final PBUInt32Field term_type = PBField.initUInt32(0);
            public final PBUInt32Field opereation = PBField.initUInt32(0);
            public final PBUInt32Field client_seq = PBField.initUInt32(0);
            public final PBUInt32Field business_type = PBField.initUInt32(0);
            public final PBUInt32Field relation_type = PBField.initUInt32(0);
            public final PBUInt64Field relation_id = PBField.initUInt64(0);
            public final PBUInt32Field av_sdk_version = PBField.initUInt32(0);
        };
        public PushOnline$CommonChannelMsg common_channel_msg = new MessageMicro<PushOnline$CommonChannelMsg>() { // from class: trpc.qq_av.av_appsvr.PushOnline$CommonChannelMsg
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"cmd_type", "bussiness_type", "auth_mode", "auth_key", AudienceReportConst.ROOM_ID, "group_id"}, new Object[]{0, 0, 0, 0L, 0L, 0L}, PushOnline$CommonChannelMsg.class);
            public final PBEnumField cmd_type = PBField.initEnum(0);
            public final PBUInt32Field bussiness_type = PBField.initUInt32(0);
            public final PBUInt32Field auth_mode = PBField.initUInt32(0);
            public final PBUInt64Field auth_key = PBField.initUInt64(0);
            public final PBUInt64Field room_id = PBField.initUInt64(0);
            public final PBUInt64Field group_id = PBField.initUInt64(0);
        };
    };
    public final PBUInt32Field video_msg_type = PBField.initUInt32(0);
}
