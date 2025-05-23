package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopTips0x857$NotifyObjmsgUpdate extends MessageMicro<TroopTips0x857$NotifyObjmsgUpdate> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext_msg;
    public final PBBytesField bytes_objmsg_id;
    public final PBUInt32Field uint32_update_type;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"bytes_objmsg_id", "uint32_update_type", "bytes_ext_msg"}, new Object[]{byteStringMicro, 0, byteStringMicro}, TroopTips0x857$NotifyObjmsgUpdate.class);
    }

    public TroopTips0x857$NotifyObjmsgUpdate() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_objmsg_id = PBField.initBytes(byteStringMicro);
        this.uint32_update_type = PBField.initUInt32(0);
        this.bytes_ext_msg = PBField.initBytes(byteStringMicro);
    }
}
