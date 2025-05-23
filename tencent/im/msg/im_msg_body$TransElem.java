package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$TransElem extends MessageMicro<im_msg_body$TransElem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"elem_type", "elem_value"}, new Object[]{0, ByteStringMicro.EMPTY}, im_msg_body$TransElem.class);
    public final PBUInt32Field elem_type = PBField.initUInt32(0);
    public final PBBytesField elem_value = PBField.initBytes(ByteStringMicro.EMPTY);
}
