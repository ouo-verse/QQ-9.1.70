package tencent.im.oidb.cmd0xcd4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xcd4$RspBody extends MessageMicro<cmd0xcd4$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"input_notify"}, new Object[]{null}, cmd0xcd4$RspBody.class);
    public cmd0xcd4$InputNotifyRsp input_notify = new MessageMicro<cmd0xcd4$InputNotifyRsp>() { // from class: tencent.im.oidb.cmd0xcd4.cmd0xcd4$InputNotifyRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"sint32_result", "bytes_err_msg", "uint32_interval"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, cmd0xcd4$InputNotifyRsp.class);
        public final PBSInt32Field sint32_result = PBField.initSInt32(0);
        public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_interval = PBField.initUInt32(0);
    };
}
