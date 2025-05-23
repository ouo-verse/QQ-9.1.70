package tencent.im.pushsvr;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class pushsvrExt$ExtData extends MessageMicro<pushsvrExt$ExtData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_to_uin", "str_remark"}, new Object[]{0L, ByteStringMicro.EMPTY}, pushsvrExt$ExtData.class);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    public final PBBytesField str_remark = PBField.initBytes(ByteStringMicro.EMPTY);
}
