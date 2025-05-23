package tencent.im.s2c.msgtype0x210.submsgtype0x26;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x26$MsgBody extends MessageMicro<submsgtype0x26$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"uint32_sub_cmd", "rpt_msg_subcmd_0x1_push_body", "msg_subcmd_0x2_push_body", "msg_subcmd_0x3_push_body", "msg_subcmd_0x4_push_body"}, new Object[]{0, null, null, null, null}, submsgtype0x26$MsgBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public final PBRepeatMessageField<SubCmd0x1UpdateAppUnreadNum> rpt_msg_subcmd_0x1_push_body = PBField.initRepeatMessage(SubCmd0x1UpdateAppUnreadNum.class);
    public SubCmd0x2UpdateAppList msg_subcmd_0x2_push_body = new SubCmd0x2UpdateAppList();
    public SubCmd0x3UpdateDiscussAppInfo msg_subcmd_0x3_push_body = new SubCmd0x3UpdateDiscussAppInfo();
    public SubCmd0x4UpdateApp msg_subcmd_0x4_push_body = new SubCmd0x4UpdateApp();

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubCmd0x1UpdateAppUnreadNum extends MessageMicro<SubCmd0x1UpdateAppUnreadNum> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40}, new String[]{"msg_app_id", "uint64_group_code", "sint32_unread_num", "msg_app_tip_notify", "sint32_album_cnt"}, new Object[]{null, 0L, 0, null, 0}, SubCmd0x1UpdateAppUnreadNum.class);
        public submsgtype0x26$AppID msg_app_id = new submsgtype0x26$AppID();
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBSInt32Field sint32_unread_num = PBField.initSInt32(0);
        public submsgtype0x26$AppTipNotify msg_app_tip_notify = new submsgtype0x26$AppTipNotify();
        public final PBSInt32Field sint32_album_cnt = PBField.initSInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubCmd0x2UpdateAppList extends MessageMicro<SubCmd0x2UpdateAppList> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"rpt_msg_app_id", "rpt_uint32_time_stamp", "uint64_group_code"}, new Object[]{null, 0, 0L}, SubCmd0x2UpdateAppList.class);
        public final PBRepeatMessageField<submsgtype0x26$AppID> rpt_msg_app_id = PBField.initRepeatMessage(submsgtype0x26$AppID.class);
        public final PBRepeatField<Integer> rpt_uint32_time_stamp = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubCmd0x3UpdateDiscussAppInfo extends MessageMicro<SubCmd0x3UpdateDiscussAppInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"msg_app_id", "uint64_conf_uin", "msg_app_tip_notify"}, new Object[]{null, 0L, null}, SubCmd0x3UpdateDiscussAppInfo.class);
        public submsgtype0x26$AppID msg_app_id = new submsgtype0x26$AppID();
        public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0);
        public submsgtype0x26$AppTipNotify msg_app_tip_notify = new submsgtype0x26$AppTipNotify();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubCmd0x4UpdateApp extends MessageMicro<SubCmd0x4UpdateApp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"msg_app_id", "uint64_group_code", "sint32_unread_num"}, new Object[]{null, 0L, 0}, SubCmd0x4UpdateApp.class);
        public submsgtype0x26$AppID msg_app_id = new submsgtype0x26$AppID();
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBSInt32Field sint32_unread_num = PBField.initSInt32(0);
    }
}
