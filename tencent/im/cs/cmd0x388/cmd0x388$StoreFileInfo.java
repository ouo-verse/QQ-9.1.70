package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x388$StoreFileInfo extends MessageMicro<cmd0x388$StoreFileInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_order_number", "jump_id"}, new Object[]{0L, 0}, cmd0x388$StoreFileInfo.class);
    public final PBUInt64Field uint64_order_number = PBField.initUInt64(0);
    public final PBUInt32Field jump_id = PBField.initUInt32(0);
}
