package tencent.im.oidb.cmd0x920;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x920$MeetingInfo extends MessageMicro<oidb_cmd0x920$MeetingInfo> {
    public static final int BYTES_ERROR_INFO_FIELD_NUMBER = 21;
    public static final int BYTES_MEETING_INTRO_FIELD_NUMBER = 6;
    public static final int RPT_UINT64_PARTICIPANTS_FIELD_NUMBER = 5;
    public static final int UINT32_BEGIN_TIME_FIELD_NUMBER = 3;
    public static final int UINT32_ENABLE_FIELD_NUMBER = 8;
    public static final int UINT32_END_TIME_FIELD_NUMBER = 4;
    public static final int UINT32_ERR_CODE_FIELD_NUMBER = 20;
    public static final int UINT32_TYPE_FIELD_NUMBER = 9;
    public static final int UINT64_CREATOR_UIN_FIELD_NUMBER = 2;
    public static final int UINT64_DISCUSS_UIN_FIELD_NUMBER = 1;
    public static final int UINT64_MEETING_SEQ_FIELD_NUMBER = 7;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_info;
    public final PBBytesField bytes_meeting_intro;
    public final PBUInt32Field uint32_enable;
    public final PBUInt32Field uint32_err_code;
    public final PBUInt32Field uint32_type;
    public final PBUInt64Field uint64_meeting_seq;
    public final PBUInt64Field uint64_discuss_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_creator_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_begin_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_end_time = PBField.initUInt32(0);
    public final PBRepeatField<Long> rpt_uint64_participants = PBField.initRepeat(PBUInt64Field.__repeatHelper__);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 56, 64, 72, 160, 170}, new String[]{"uint64_discuss_uin", "uint64_creator_uin", "uint32_begin_time", "uint32_end_time", "rpt_uint64_participants", "bytes_meeting_intro", "uint64_meeting_seq", "uint32_enable", "uint32_type", "uint32_err_code", "bytes_error_info"}, new Object[]{0L, 0L, 0, 0, 0L, byteStringMicro, 0L, 0, 0, 0, byteStringMicro}, oidb_cmd0x920$MeetingInfo.class);
    }

    public oidb_cmd0x920$MeetingInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_meeting_intro = PBField.initBytes(byteStringMicro);
        this.uint64_meeting_seq = PBField.initUInt64(0L);
        this.uint32_enable = PBField.initUInt32(0);
        this.uint32_type = PBField.initUInt32(0);
        this.uint32_err_code = PBField.initUInt32(0);
        this.bytes_error_info = PBField.initBytes(byteStringMicro);
    }
}
