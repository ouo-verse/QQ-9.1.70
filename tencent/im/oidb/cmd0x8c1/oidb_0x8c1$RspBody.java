package tencent.im.oidb.cmd0x8c1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8c1$RspBody extends MessageMicro<oidb_0x8c1$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_card_info"}, new Object[]{null}, oidb_0x8c1$RspBody.class);
    public oidb_0x8c1$SelfCardInfo msg_card_info = new MessageMicro<oidb_0x8c1$SelfCardInfo>() { // from class: tencent.im.oidb.cmd0x8c1.oidb_0x8c1$SelfCardInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uint64_uin", "bytes_xml_msg", "int32_direction_flag", "int32_friend_flag"}, new Object[]{0L, ByteStringMicro.EMPTY, 0, 0}, oidb_0x8c1$SelfCardInfo.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBBytesField bytes_xml_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBInt32Field int32_direction_flag = PBField.initInt32(0);
        public final PBInt32Field int32_friend_flag = PBField.initInt32(0);
    };
}
