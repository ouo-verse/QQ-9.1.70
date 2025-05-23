package tencent.im.oidb.cmd0x9c0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x9c0$NearbyUser extends MessageMicro<cmd0x9c0$NearbyUser> {
    public static final int BYTES_NICK_FIELD_NUMBER = 4;
    public static final int BYTES_REMARK_FIELD_NUMBER = 3;
    public static final int UINT32_IS_FRD_FIELD_NUMBER = 2;
    public static final int UINT64_NEARBY_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nick;
    public final PBBytesField bytes_remark;
    public final PBUInt64Field uint64_nearby_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_is_frd = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint64_nearby_uin", "uint32_is_frd", "bytes_remark", "bytes_nick"}, new Object[]{0L, 0, byteStringMicro, byteStringMicro}, cmd0x9c0$NearbyUser.class);
    }

    public cmd0x9c0$NearbyUser() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_remark = PBField.initBytes(byteStringMicro);
        this.bytes_nick = PBField.initBytes(byteStringMicro);
    }
}
