package tencent.im.oidb.cmd0x8ca;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x8ca$ReqBody extends MessageMicro<cmd0x8ca$ReqBody> {
    public static final int OPT_BYTES_GROUP_SIG_FIELD_NUMBER = 3;
    public static final int OPT_INT32_OPR_NUM_ALBUM_FIELD_NUMBER = 11;
    public static final int OPT_INT32_OPR_NUM_FIELD_NUMBER = 5;
    public static final int OPT_MSG_APP_TIP_NOTIFY_FIELD_NUMBER = 10;
    public static final int OPT_MSG_APP_UIN_FIELD_NUMBER = 12;
    public static final int OPT_UINT32_GA_OWNER_FIELD_NUMBER = 8;
    public static final int OPT_UINT32_SUB_CMD_FIELD_NUMBER = 1;
    public static final int OPT_UINT64_APPID_FIELD_NUMBER = 6;
    public static final int OPT_UINT64_FROM_UIN_FIELD_NUMBER = 2;
    public static final int OPT_UINT64_GA_CODE_FIELD_NUMBER = 9;
    public static final int OPT_UINT64_GROUP_CODE_FIELD_NUMBER = 4;
    public static final int RPT_UINT64_OPR_UIN_FIELD_NUMBER = 7;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48, 56, 64, 72, 82, 88, 98}, new String[]{"opt_uint32_sub_cmd", "opt_uint64_from_uin", "opt_bytes_group_sig", "opt_uint64_group_code", "opt_int32_opr_num", "opt_uint64_appid", "rpt_uint64_opr_uin", "opt_uint32_ga_owner", "opt_uint64_ga_code", "opt_msg_app_tip_notify", "opt_int32_opr_num_album", "opt_msg_app_uin"}, new Object[]{0L, 0L, ByteStringMicro.EMPTY, 0L, 0, 0L, 0L, 0, 0L, null, 0, null}, cmd0x8ca$ReqBody.class);
    public final PBUInt64Field opt_uint32_sub_cmd = PBField.initUInt64(0);
    public final PBUInt64Field opt_uint64_from_uin = PBField.initUInt64(0);
    public final PBBytesField opt_bytes_group_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field opt_uint64_appid = PBField.initUInt64(0);
    public final PBInt32Field opt_int32_opr_num = PBField.initInt32(0);
    public final PBRepeatField<Long> rpt_uint64_opr_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field opt_uint32_ga_owner = PBField.initUInt32(0);
    public final PBUInt64Field opt_uint64_ga_code = PBField.initUInt64(0);
    public cmd0x8ca$AppTipNotify opt_msg_app_tip_notify = new MessageMicro<cmd0x8ca$AppTipNotify>() { // from class: tencent.im.oidb.cmd0x8ca.cmd0x8ca$AppTipNotify
        public static final int BYTES_TEXT_FIELD_NUMBER = 2;
        public static final int UINT32_ACTION_FIELD_NUMBER = 1;
        public static final int UINT32_NEEDED_TIP_INFO_SEQ_FIELD_NUMBER = 4;
        public static final int UINT32_NOTIFY_SEQ_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uint32_action", "bytes_text", "uint32_notify_seq", "uint32_needed_tip_info_seq"}, new Object[]{0, ByteStringMicro.EMPTY, 0, 0}, cmd0x8ca$AppTipNotify.class);
        public final PBUInt32Field uint32_action = PBField.initUInt32(0);
        public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_notify_seq = PBField.initUInt32(0);
        public final PBUInt32Field uint32_needed_tip_info_seq = PBField.initUInt32(0);
    };
    public final PBInt32Field opt_int32_opr_num_album = PBField.initInt32(0);
    public cmd0x8ca$AppUinSpecial opt_msg_app_uin = new MessageMicro<cmd0x8ca$AppUinSpecial>() { // from class: tencent.im.oidb.cmd0x8ca.cmd0x8ca$AppUinSpecial
        public static final int OPT_UINT32_ACCESS_TIME_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"opt_uint32_access_time"}, new Object[]{0}, cmd0x8ca$AppUinSpecial.class);
        public final PBUInt32Field opt_uint32_access_time = PBField.initUInt32(0);
    };
}
