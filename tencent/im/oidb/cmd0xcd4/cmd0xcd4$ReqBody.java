package tencent.im.oidb.cmd0xcd4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xcd4$ReqBody extends MessageMicro<cmd0xcd4$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"input_notify"}, new Object[]{null}, cmd0xcd4$ReqBody.class);
    public cmd0xcd4$InputNotifyReq input_notify = new MessageMicro<cmd0xcd4$InputNotifyReq>() { // from class: tencent.im.oidb.cmd0xcd4.cmd0xcd4$InputNotifyReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint64_to_uin", "uint32_ime", "uint32_event_type", "bytes_pb_reserve"}, new Object[]{0L, 0, 0, ByteStringMicro.EMPTY}, cmd0xcd4$InputNotifyReq.class);
        public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_ime = PBField.initUInt32(0);
        public final PBUInt32Field uint32_event_type = PBField.initUInt32(0);
        public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    };
}
