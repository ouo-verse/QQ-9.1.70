package tencent.aio.video;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_video$ReqGetUinByOpenId extends MessageMicro<aio_video$ReqGetUinByOpenId> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field app_id = PBField.initUInt32(0);
    public final PBUInt64Field group_id;
    public final PBBytesField open_id;
    public final PBBytesField open_key;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"app_id", "open_id", "open_key", "group_id"}, new Object[]{0, byteStringMicro, byteStringMicro, 0L}, aio_video$ReqGetUinByOpenId.class);
    }

    public aio_video$ReqGetUinByOpenId() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.open_id = PBField.initBytes(byteStringMicro);
        this.open_key = PBField.initBytes(byteStringMicro);
        this.group_id = PBField.initUInt64(0L);
    }
}
