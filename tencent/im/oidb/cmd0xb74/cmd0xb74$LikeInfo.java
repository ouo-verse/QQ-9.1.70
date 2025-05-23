package tencent.im.oidb.cmd0xb74;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xb74$LikeInfo extends MessageMicro<cmd0xb74$LikeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"bytes_rowkey", "uint32_like_count", "uint32_is_like", "msg_fusion_biu_info"}, new Object[]{ByteStringMicro.EMPTY, 0, 0, null}, cmd0xb74$LikeInfo.class);
    public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_like = PBField.initUInt32(0);
    public cmd0xb74$FusionBiuInfo msg_fusion_biu_info = new cmd0xb74$FusionBiuInfo();
}
