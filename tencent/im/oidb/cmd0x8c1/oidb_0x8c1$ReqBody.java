package tencent.im.oidb.cmd0x8c1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8c1$ReqBody extends MessageMicro<oidb_0x8c1$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 48}, new String[]{"msg_req_info", "uint64_first_rater_uin", "bytes_tmp_chat_token", "int32_tmp_chat_token_type", "uint64_first_rater_tinyid", "int32_is_super_love"}, new Object[]{null, 0L, ByteStringMicro.EMPTY, 0, 0L, 0}, oidb_0x8c1$ReqBody.class);
    public oidb_0x8c1$UserDeviceInfo msg_req_info = new MessageMicro<oidb_0x8c1$UserDeviceInfo>() { // from class: tencent.im.oidb.cmd0x8c1.oidb_0x8c1$UserDeviceInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"int32_client_type", "uint32_portal", "uint32_instance_id"}, new Object[]{0, 0, 0}, oidb_0x8c1$UserDeviceInfo.class);
        public final PBInt32Field int32_client_type = PBField.initInt32(0);
        public final PBUInt32Field uint32_portal = PBField.initUInt32(0);
        public final PBUInt32Field uint32_instance_id = PBField.initUInt32(0);
    };
    public final PBUInt64Field uint64_first_rater_uin = PBField.initUInt64(0);
    public final PBBytesField bytes_tmp_chat_token = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_tmp_chat_token_type = PBField.initInt32(0);
    public final PBUInt64Field uint64_first_rater_tinyid = PBField.initUInt64(0);
    public final PBInt32Field int32_is_super_love = PBField.initInt32(0);
}
