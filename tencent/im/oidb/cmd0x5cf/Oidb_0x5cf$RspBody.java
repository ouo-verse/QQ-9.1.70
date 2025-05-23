package tencent.im.oidb.cmd0x5cf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x5cf$RspBody extends MessageMicro<Oidb_0x5cf$RspBody> {
    public static final int MSG_FAILEDSYS_FIELD_NUMBER = 4;
    public static final int MSG_SUCCESSREAD_FIELD_NUMBER = 3;
    public static final int STR_RESERVE_FIELD_NUMBER = 5;
    public static final int UINT32_RESULT_FIELD_NUMBER = 2;
    public static final int UINT32_VERSION_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{"uint32_version", "uint32_result", "msg_successread", "msg_failedsys", "str_reserve"}, new Object[]{0, 0, null, null, ""}, Oidb_0x5cf$RspBody.class);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public Oidb_0x5cf$SuccessRead msg_successread = new MessageMicro<Oidb_0x5cf$SuccessRead>() { // from class: tencent.im.oidb.cmd0x5cf.Oidb_0x5cf$SuccessRead
        public static final int FIXED32_SEQUENCE_FIELD_NUMBER = 1;
        public static final int RPT_MSG_ALL_FIELD_NUMBER = 7;
        public static final int RPT_MSG_DECIDED_FIELD_NUMBER = 5;
        public static final int RPT_MSG_UNDECIDE_FIELD_NUMBER = 4;
        public static final int RPT_UINT64_UNREAD_UNDECIDE_UIN_FIELD_NUMBER = 12;
        public static final int UINT32_FIRST_UPDATE_FIELD_NUMBER = 10;
        public static final int UINT32_OVER_FIELD_NUMBER = 2;
        public static final int UINT32_TOTLE_FIELD_NUMBER = 3;
        public static final int UINT32_UNREAD_UNDECIDE_NUM_FIELD_NUMBER = 11;
        public static final int UINT32_UN_READ_COUNT2_FIELD_NUMBER = 9;
        public static final int UINT32_UN_READ_COUNT_FIELD_NUMBER = 6;
        public static final int UINT64_UPDATETIME_FIELD_NUMBER = 8;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 16, 24, 34, 42, 48, 58, 64, 72, 80, 88, 96}, new String[]{"fixed32_sequence", "uint32_over", "uint32_totle", "rpt_msg_undecide", "rpt_msg_decided", "uint32_un_read_count", "rpt_msg_all", "uint64_updatetime", "uint32_un_read_count2", "uint32_first_update", "uint32_unread_undecide_num", "rpt_uint64_unread_undecide_uin"}, new Object[]{0, 0, 0, null, null, 0, null, 0L, 0, 0, 0, 0L}, Oidb_0x5cf$SuccessRead.class);
        public final PBFixed32Field fixed32_sequence = PBField.initFixed32(0);
        public final PBUInt32Field uint32_over = PBField.initUInt32(0);
        public final PBUInt32Field uint32_totle = PBField.initUInt32(0);
        public final PBRepeatMessageField<Oidb_0x5cf$UnDecide> rpt_msg_undecide = PBField.initRepeatMessage(Oidb_0x5cf$UnDecide.class);
        public final PBRepeatMessageField<Oidb_0x5cf$Decided> rpt_msg_decided = PBField.initRepeatMessage(Oidb_0x5cf$Decided.class);
        public final PBUInt32Field uint32_un_read_count = PBField.initUInt32(0);
        public final PBRepeatMessageField<Oidb_0x5cf$All> rpt_msg_all = PBField.initRepeatMessage(Oidb_0x5cf$All.class);
        public final PBUInt64Field uint64_updatetime = PBField.initUInt64(0);
        public final PBUInt32Field uint32_un_read_count2 = PBField.initUInt32(0);
        public final PBUInt32Field uint32_first_update = PBField.initUInt32(0);
        public final PBUInt32Field uint32_unread_undecide_num = PBField.initUInt32(0);
        public final PBRepeatField<Long> rpt_uint64_unread_undecide_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    };
    public Oidb_0x5cf$FailedSys msg_failedsys = new MessageMicro<Oidb_0x5cf$FailedSys>() { // from class: tencent.im.oidb.cmd0x5cf.Oidb_0x5cf$FailedSys
        public static final int STR_MSG_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"str_msg"}, new Object[]{""}, Oidb_0x5cf$FailedSys.class);
        public final PBStringField str_msg = PBField.initString("");
    };
    public final PBStringField str_reserve = PBField.initString("");
}
