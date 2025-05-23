package tencent.im.oidb.cmd0xb74;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xb74$ReqBody extends MessageMicro<cmd0xb74$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"rpt_bytes_rowkey", "uint32_need_like_count", "uint32_need_like_status", "uint32_need_fusion_biu_info"}, new Object[]{ByteStringMicro.EMPTY, 0, 0, 0}, cmd0xb74$ReqBody.class);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_rowkey = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field uint32_need_like_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_like_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_fusion_biu_info = PBField.initUInt32(0);
}
