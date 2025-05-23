package tencent.im.group;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x2dc$VisitorJoinInfo extends MessageMicro<cmd0x2dc$VisitorJoinInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uint64_visitor_uin", "uint32_join_time", "bytes_visitor_name", "uint32_face_id"}, new Object[]{0L, 0, ByteStringMicro.EMPTY, 0}, cmd0x2dc$VisitorJoinInfo.class);
    public final PBUInt64Field uint64_visitor_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_join_time = PBField.initUInt32(0);
    public final PBBytesField bytes_visitor_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_face_id = PBField.initUInt32(0);
}
