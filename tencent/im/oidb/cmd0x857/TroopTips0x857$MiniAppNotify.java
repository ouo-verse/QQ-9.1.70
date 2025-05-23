package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopTips0x857$MiniAppNotify extends MessageMicro<TroopTips0x857$MiniAppNotify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_msg"}, new Object[]{ByteStringMicro.EMPTY}, TroopTips0x857$MiniAppNotify.class);
    public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
