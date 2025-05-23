package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopTips0x857$TopBannerNotify extends MessageMicro<TroopTips0x857$TopBannerNotify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"biz_type", "msg_id"}, new Object[]{0, ByteStringMicro.EMPTY}, TroopTips0x857$TopBannerNotify.class);
    public final PBUInt32Field biz_type = PBField.initUInt32(0);
    public final PBBytesField msg_id = PBField.initBytes(ByteStringMicro.EMPTY);
}
