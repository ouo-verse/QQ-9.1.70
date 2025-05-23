package tencent.im.oidb.cmd0xb73;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb73$LikeAnimationIconConfig extends MessageMicro<oidb_0xb73$LikeAnimationIconConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_icon_url"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0xb73$LikeAnimationIconConfig.class);
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
}
