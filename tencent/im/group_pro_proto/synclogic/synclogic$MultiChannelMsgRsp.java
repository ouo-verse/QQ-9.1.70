package tencent.im.group_pro_proto.synclogic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class synclogic$MultiChannelMsgRsp extends MessageMicro<synclogic$MultiChannelMsgRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"result", "err_msg", "seq"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, synclogic$MultiChannelMsgRsp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field seq = PBField.initUInt32(0);
}
