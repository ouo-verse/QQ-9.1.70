package tencent.im.oidb.cmd0xf26;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf26$AuthItem extends MessageMicro<oidb_0xf26$AuthItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField auth_group_desc;
    public final PBUInt32Field auth_group_id = PBField.initUInt32(0);
    public final PBBytesField auth_group_name;
    public final PBUInt32Field auth_result;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"auth_group_id", "auth_group_name", "auth_group_desc", "auth_result"}, new Object[]{0, byteStringMicro, byteStringMicro, 0}, oidb_0xf26$AuthItem.class);
    }

    public oidb_0xf26$AuthItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.auth_group_name = PBField.initBytes(byteStringMicro);
        this.auth_group_desc = PBField.initBytes(byteStringMicro);
        this.auth_result = PBField.initUInt32(0);
    }
}
