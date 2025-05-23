package tencent.im.cs.longconn;

import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hd_video_comm$TransBuffer extends MessageMicro<hd_video_comm$TransBuffer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_type", MessageForUniteGrayTip.KEY_BYTES_CONTENT}, new Object[]{0, ByteStringMicro.EMPTY}, hd_video_comm$TransBuffer.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
}
