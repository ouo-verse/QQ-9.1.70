package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopTips0x857$QQVaLiveNotifyMsg extends MessageMicro<TroopTips0x857$QQVaLiveNotifyMsg> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext1;
    public final PBBytesField bytes_ext2;
    public final PBBytesField bytes_ext3;
    public final PBBytesField bytes_uid;
    public final PBInt32Field notify_type;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42}, new String[]{"bytes_uid", "notify_type", "bytes_ext1", "bytes_ext2", "bytes_ext3"}, new Object[]{byteStringMicro, 0, byteStringMicro, byteStringMicro, byteStringMicro}, TroopTips0x857$QQVaLiveNotifyMsg.class);
    }

    public TroopTips0x857$QQVaLiveNotifyMsg() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_uid = PBField.initBytes(byteStringMicro);
        this.notify_type = PBField.initInt32(0);
        this.bytes_ext1 = PBField.initBytes(byteStringMicro);
        this.bytes_ext2 = PBField.initBytes(byteStringMicro);
        this.bytes_ext3 = PBField.initBytes(byteStringMicro);
    }
}
