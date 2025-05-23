package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class obj_msg$MsgPic extends MessageMicro<obj_msg$MsgPic> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_original_pic_url;
    public final PBBytesField bytes_small_pic_url;
    public final PBUInt32Field uint32_local_pic_id;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"bytes_small_pic_url", "bytes_original_pic_url", "uint32_local_pic_id"}, new Object[]{byteStringMicro, byteStringMicro, 0}, obj_msg$MsgPic.class);
    }

    public obj_msg$MsgPic() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_small_pic_url = PBField.initBytes(byteStringMicro);
        this.bytes_original_pic_url = PBField.initBytes(byteStringMicro);
        this.uint32_local_pic_id = PBField.initUInt32(0);
    }
}
