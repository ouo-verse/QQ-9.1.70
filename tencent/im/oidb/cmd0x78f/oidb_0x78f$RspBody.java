package tencent.im.oidb.cmd0x78f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x78f$RspBody extends MessageMicro<oidb_0x78f$RspBody> {
    public static final int OPT_MSG_RECORD_FIELD_NUMBER = 4;
    public static final int STR_ERRORINFO_FIELD_NUMBER = 5;
    public static final int UINT32_CUR_CNT_FIELD_NUMBER = 3;
    public static final int UINT32_TOTAL_CNT_FIELD_NUMBER = 2;
    public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public static final oidb_0x78f$RspBody __repeatHelper__;
    public final PBBytesField opt_msg_record;
    public final PBBytesField str_errorinfo;
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_total_cnt = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cur_cnt = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"uint64_group_code", "uint32_total_cnt", "uint32_cur_cnt", "opt_msg_record", "str_errorinfo"}, new Object[]{0L, 0, 0, byteStringMicro, byteStringMicro}, oidb_0x78f$RspBody.class);
        __repeatHelper__ = new oidb_0x78f$RspBody();
    }

    public oidb_0x78f$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.opt_msg_record = PBField.initBytes(byteStringMicro);
        this.str_errorinfo = PBField.initBytes(byteStringMicro);
    }
}
