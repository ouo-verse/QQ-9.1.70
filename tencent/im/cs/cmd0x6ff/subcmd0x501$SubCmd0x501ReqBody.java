package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class subcmd0x501$SubCmd0x501ReqBody extends MessageMicro<subcmd0x501$SubCmd0x501ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 64}, new String[]{"uint64_uin", "uint32_idc_id", "uint32_appid", "uint32_login_sig_type", "bytes_login_sig_ticket", "uint32_request_flag", "rpt_uint32_service_types", "uint32_bid"}, new Object[]{0L, 0, 0, 0, ByteStringMicro.EMPTY, 0, 0, 0}, subcmd0x501$SubCmd0x501ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_idc_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_login_sig_type = PBField.initUInt32(0);
    public final PBBytesField bytes_login_sig_ticket = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_request_flag = PBField.initUInt32(0);
    public final PBRepeatField<Integer> rpt_uint32_service_types = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
}
