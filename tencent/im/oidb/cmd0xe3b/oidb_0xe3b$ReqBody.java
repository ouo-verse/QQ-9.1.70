package tencent.im.oidb.cmd0xe3b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe3b$ReqBody extends MessageMicro<oidb_0xe3b$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie_for_req_type_1;
    public final PBBytesField bytes_cookie_for_req_type_2;
    public final PBRepeatField<Long> rpt_uint64_uin_list;
    public final PBRepeatField<Long> rpt_uint64_uin_show_ahead;
    public final PBUInt32Field uint32_graybar_type;
    public final PBUInt32Field uint32_want;
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
    public oidb_0xe3b$GroupInfo msg_group_info = new MessageMicro<oidb_0xe3b$GroupInfo>() { // from class: tencent.im.oidb.cmd0xe3b.oidb_0xe3b$GroupInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_group_id", "uint32_group_type", "uint32_group_total_person", "rpt_uint64_group_manager"}, new Object[]{0L, 0, 0, 0L}, oidb_0xe3b$GroupInfo.class);
        public final PBUInt64Field uint64_group_id = PBField.initUInt64(0);
        public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_group_total_person = PBField.initUInt32(0);
        public final PBRepeatField<Long> rpt_uint64_group_manager = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    };

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 56, 64}, new String[]{"uint32_req_type", "msg_group_info", "bytes_cookie_for_req_type_1", "bytes_cookie_for_req_type_2", "uint32_graybar_type", "uint32_want", "rpt_uint64_uin_show_ahead", "rpt_uint64_uin_list"}, new Object[]{0, null, byteStringMicro, byteStringMicro, 0, 0, 0L, 0L}, oidb_0xe3b$ReqBody.class);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [tencent.im.oidb.cmd0xe3b.oidb_0xe3b$GroupInfo] */
    public oidb_0xe3b$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_cookie_for_req_type_1 = PBField.initBytes(byteStringMicro);
        this.bytes_cookie_for_req_type_2 = PBField.initBytes(byteStringMicro);
        this.uint32_graybar_type = PBField.initUInt32(0);
        this.uint32_want = PBField.initUInt32(0);
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.rpt_uint64_uin_show_ahead = PBField.initRepeat(pBUInt64Field);
        this.rpt_uint64_uin_list = PBField.initRepeat(pBUInt64Field);
    }
}
