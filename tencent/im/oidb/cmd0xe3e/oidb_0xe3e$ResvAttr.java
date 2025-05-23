package tencent.im.oidb.cmd0xe3e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe3e$ResvAttr extends MessageMicro<oidb_0xe3e$ResvAttr> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"uint32_friend_banned_flag", "uint32_gray_tips_from", "bytes_custom_status", "uint64_qqstranger_to_tinyid", "uint32_qqlogin_type"}, new Object[]{0, 0, ByteStringMicro.EMPTY, 0L, 0}, oidb_0xe3e$ResvAttr.class);
    public final PBUInt32Field uint32_friend_banned_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gray_tips_from = PBField.initUInt32(0);
    public final PBBytesField bytes_custom_status = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_qqstranger_to_tinyid = PBField.initUInt64(0);
    public final PBUInt32Field uint32_qqlogin_type = PBField.initUInt32(0);
}
