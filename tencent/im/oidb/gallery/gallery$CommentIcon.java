package tencent.im.oidb.gallery;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class gallery$CommentIcon extends MessageMicro<gallery$CommentIcon> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"bytes_icon_url", "uint32_icon_height", "uint32_icon_width"}, new Object[]{ByteStringMicro.EMPTY, 0, 0}, gallery$CommentIcon.class);
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_icon_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_icon_width = PBField.initUInt32(0);
}
