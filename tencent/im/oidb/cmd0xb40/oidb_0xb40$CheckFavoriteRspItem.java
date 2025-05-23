package tencent.im.oidb.cmd0xb40;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb40$CheckFavoriteRspItem extends MessageMicro<oidb_0xb40$CheckFavoriteRspItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBRepeatField<ByteStringMicro> bytes_cid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"bytes_rowkey", "uint32_result", "bytes_cid_list"}, new Object[]{byteStringMicro, 0, byteStringMicro}, oidb_0xb40$CheckFavoriteRspItem.class);
    }
}
