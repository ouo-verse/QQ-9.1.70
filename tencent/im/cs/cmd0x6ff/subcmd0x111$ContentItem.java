package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class subcmd0x111$ContentItem extends MessageMicro<subcmd0x111$ContentItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_filed", "msg_general_buffer"}, new Object[]{0, null}, subcmd0x111$ContentItem.class);
    public final PBUInt32Field uint32_filed = PBField.initUInt32(0);
    public subcmd0x111$GeneralBuffer msg_general_buffer = new MessageMicro<subcmd0x111$GeneralBuffer>() { // from class: tencent.im.cs.cmd0x6ff.subcmd0x111$GeneralBuffer
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_value"}, new Object[]{ByteStringMicro.EMPTY}, subcmd0x111$GeneralBuffer.class);
        public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    };
}
