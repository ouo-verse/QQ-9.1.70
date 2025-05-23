package tencent.im.group_pro_proto.synclogic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class synclogic$FirstViewRsp extends MessageMicro<synclogic$FirstViewRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 56, 64, 74}, new String[]{"result", "err_msg", "seq", "udc_flag", "guild_count", "self_tinyid", "direct_message_switch", "direct_message_guild_count", "feeds_event_node"}, new Object[]{0, ByteStringMicro.EMPTY, 0, 0, 0, 0L, 0, 0, null}, synclogic$FirstViewRsp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBUInt32Field udc_flag = PBField.initUInt32(0);
    public final PBUInt32Field guild_count = PBField.initUInt32(0);
    public final PBUInt64Field self_tinyid = PBField.initUInt64(0);
    public final PBUInt32Field direct_message_switch = PBField.initUInt32(0);
    public final PBUInt32Field direct_message_guild_count = PBField.initUInt32(0);
    public synclogic$FeedsEventNode feeds_event_node = new synclogic$FeedsEventNode();
}
